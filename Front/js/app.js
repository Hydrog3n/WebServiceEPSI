var App = App || {}

$(function() {

    App.init = function() {
        App.getConcert();
    };

    App.getConcert = function() {
        $('.js-concert-line').empty();
        $.ajax({
            url: "http://localhost:8080/concert/",
        })
        .done(function( concerts ) {
           concerts.forEach(function(concert) {
               App.insertTable(concert);
           }, this);
        });
    };

    App.insertTable = function(concert) {
        var trConcert = "<tr> <th scope=\"row\">" + concert.id + "</th> " +
        "<td>" + concert.artiste+ "</td> <td>" + new Date(concert.date) +"</td> "+
        "<td>" + concert.lieu + "</td> <td>"+ concert.nbPlace + "</td> <td>"+ concert.prix + " €</td>"+
        "<td>" +
        "<div class=\"js-reservation-data\" attr-id=\"" + concert.id + "\"><input type=\"number\" min=\"0\" max=\""+concert.nbPlace+"\"/>" +
        "<p class=\"btn btn-info js-reservation-resa\">Réserver</p></div></td> "+
        "<td><p attr-id=\"" + concert.id + "\" class=\"btn btn-info js-reservation-show\">Voir Réservation</p></td></tr>";

        $('.js-concert-line').append(trConcert);
        $(".js-reservation-resa").click(function(e) {
            var nom = prompt("Indiquer votre nom !");
            var id = $(this).parent().attr('attr-id');
            var nbPlace = $(this).parent().find('input')[0].value;

            if (nbPlace <= 0) {
                alert("Merci de renseigner un nombre de place");
            } else {
                App.reservation(id, nbPlace, nom);
            }
            e.stopPropagation();
        });

        $(".js-reservation-show").click(function() {
            var id = concert.id;
            App.showReservation(id);
        });
    };

    App.reservation = function(id, nbPlace, nom) {
        var resa = {
            "nbPlace": parseInt(nbPlace),
            "nom": nom
        };

        $.ajax({
            url: "http://localhost:8080/concert/"+id,
            method: "POST",
            data: JSON.stringify(resa),
            contentType: "application/json",
        }).done(function(data) {
            alert("Votre réservation à pour id : " + data.id + "\n Et contient " + data.nbPlace + " place(s)");
            App.getConcert();
        });
    };

    App.showReservation = function(idConcert) {
        var id = parseInt(idConcert);
        $('.js-reservation-line').empty();
        $.ajax({
            url: "http://localhost:8080/concert/"+id,
        }).done(function(data) {
            data.reservations.forEach(function(reservation) {
                var trResa = "<tr><th scope=\"row\">" + reservation.id + "</th> " +
                "<td>"+reservation.nom+"</td>" +
                "<td>"+reservation.nbPlace+"</td>" +
                "<td><p attr-id-resa=\""+reservation.id+"\" attr-id-concert=\""+id+"\" class=\"btn btn-danger js-resa-cancel\">Annuler</p><td/>";
                $('.js-reservation-line').append(trResa);
            }, this);
            $('.js-resa-cancel').click(function() {
                App.deleteReservation($(this).attr('attr-id-concert'), $(this).attr('attr-id-resa'))
            });
            $('.js-reservation').show();

        });
    };

    App.deleteReservation = function(idConcert, idResa) {
         $.ajax({
            url: "http://localhost:8080/concert/"+idConcert+"/"+idResa,
            method: "DELETE",
        }).done(function(data) {
            alert("Votre réservation était annuler");
            App.showReservation(idConcert)
        });
    }

    App.init();

});