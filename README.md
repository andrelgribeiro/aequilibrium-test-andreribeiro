# Swang Labs Tests Automation

# Get the project
Git clone

# Setings
mvn install 
mvn compile


# Execute
mvn  -DbrowserOption="chrome" -Dtest=runner.Runner test
mvn  -DbrowserOption="firefox" -Dtest=runner.Runner test


# Maybe you need updating your chromedriver/firefoxdriver to your current version of browser if you are using a firefox as main browser