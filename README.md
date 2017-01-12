# edge-service

This acts as a proxy for the ui-service. The goal is to work around CORS and the Same Origin Policy restriction of the browser and allow the UI to call the API even though they don’t share the same origin. It also modifies the API response as ui-service needed. Edge-servicein has been used in the UI application to proxy calls to the REST API. 
Edge-service is based on Spring Cloud's zuul proxy which runs on a separate docker container .
For more information https://github.com/manojbest/edge-service