# Locate

This is android app which collects my gps location at a regular intervel and at a fixed displacement. After collectecting, it sends data to django server with the help of django rest api call.

It can start three trip at a time with different starting and ending point as per the requirement.

Cool thing about this is it can collect and store data even when you are offline. The only requirement is that when you start and when you save your trip your android device should be connected to internet

Server part of this project is in another repository named Locate_django which plots my location on google map.
