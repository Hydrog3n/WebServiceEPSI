# WebServiceEPSI

Tester le Web Service :
- récupérer et décompresser la projet (zip)
- dans le dossier du projet faire 'gradlew build' si vous n'avez pas Gragle ou 'gradle build' sinon
- dans le dossier du projet faire 'gradlew eclipse' si vous n'avez pas Gragle ou 'gradle eclipse' sinon
- importer le projet dans Eclipse
- lancer le projet (run as -> java application) du main : fr.epsi.WebServiceEpsiApplication
- ouvrir un nagigateur et aller à : http://localhost:8080/concert

A faire (1 choix parmi) :

- Continuer à développer le  Web Service (voir le doc TD conception Web Service Rest -gestion concert (niveau prog : assez élévé)
- Développer l'interface Web du présent Web Service en Angular (version 1 recommandée sur vous ne connaissez pas) (niveau prog moyen)
https://angularjs.org/
- Implanter un annuaire de Web Service avec Spring Cloud Eureka (niveau prog assez facile)
https://spring.io/guides/gs/service-registration-and-discovery/
Load balancing côté client avec Ribbon
https://spring.io/blog/2015/01/20/microservice-registration-and-discovery-with-spring-cloud-and-netflix-s-eureka
