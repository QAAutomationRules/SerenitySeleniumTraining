# Serenity Test Framework Docker Image
# Want: Java 10, linux webdrivers (Chrome and Firefox), and Linux browsers (Chrome and Firefox)
# Known: Serenity standalone drivers do not have Java 10, Docker Java 10 images do not have webdrivers (or Browsers)
# Also Known: Need IE Webdriver, but how do we install IE webdriver and browser on Linux container????

# Add Java 10 - Will worry about slim later
FROM openjdk:10-jdk-slim

# Ready ALL THE THINGS
RUN apt-get update
RUN apt-get install -y wget gnupg

#Make working directories for webdrivers
RUN mkdir /serenity
WORKDIR /serenity

# Add Webdrivers
#Chrome Webdriver
RUN wget https://chromedriver.storage.googleapis.com/2.41/chromedriver_linux64.zip && unzip *.zip 
#FireFox Webdriver
RUN wget https://github.com/mozilla/geckodriver/releases/download/v0.21.0/geckodriver-v0.21.0-linux64.tar.gz && tar -xzvf *.gz*

# Add Browsers
#Firefox
RUN wget https://download.mozilla.org/?product=firefox-latest-ssl&os=linux64&lang=en-US && tar -xzvf *.gz*
# Set the Chrome repo.
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list
# Install Chrome.
RUN apt-get update && apt-get -y install google-chrome-stable

# Added from foreign project as filler

# Add the project files
ADD src /project/src
ADD gradle /project/gradle
ADD gradlew build.gradle settings.gradle /project/
WORKDIR /project
# Download gradle and build
RUN /project/gradlew compileTestJava
# Keep the container running by default
CMD tail -f /dev/null
