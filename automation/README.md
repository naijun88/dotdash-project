# How to run

## Run server
```
php -S localhost:8081 -c php.ini
```
## Run automation tests
```
cd automation/dotdash

mvn clean install -Dtest=FrontendAutomation
mvn clean install -Dtest=ApiAutomation
```
## Open reports
```
cd automation/dotdash

open ./target/surefire-reports/index.html 
```
