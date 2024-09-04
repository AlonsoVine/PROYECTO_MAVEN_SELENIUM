#Este Script da fallo porque no tenemos permisos de administrador y no los puedo cambiar(chmod)

#EJECUTAMOS LOS TEST

#Ejecutamos los grupos:
.\mvnw clean test -Dgroups="smoke"
.\mvnw clean test -Dgroups="regression"

#Ejecuta el package
.\mvnw clean test -Dtest="pruebas.**"

# REALIZAMOS LOS TEST Y LEVANTAMOS LA SUITE DE SUREFIRE
.\mvnw clean test -Dgroups="smoke" surefire-report:report
.\mvnw clean test -Dgroups="regression" surefire-report:report
#podemos ver el reporte en la siguiente ubicacion:
#target/site/surefire-report.html


# REALIZAMOS LOS TEST Y LEVANTAMOS LA SUITE DE ALLURE
#da fallo porque no tenemos permisos(creo)
.\mvnw clean test -Dgroups="regression"
#da fallo si no tienes creado el directorio target/allure-results (creado a mano)
mkdir target\allure-resuts
.\mvnw allure:serve