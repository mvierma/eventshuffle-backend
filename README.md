# Event Shuffle REST API

A simple Spring Boot REST API for managing events, votes, and retrieving suitable event dates.

## Running the application

1. Clone the repository
2. Build and deploy containers with docker compose up -d
3. For a clean shutdown use docker compose down



## Endpoints

### List all events

Endpoint: /api/v1/event/list

Method: GET


### Create an event

Endpoint: /api/v1/event

Method: POST

Body:

{
  "name": "Jake's secret party",
  "dates": [
    "2014-01-01",
    "2014-01-05",
    "2014-01-12"
  ]
}


### Show an event

Endpoint: /api/v1/event/{id}

Method: GET

Parameters: id, long


### Add votes to an event

Endpoint: /api/v1/event/{id}/vote

Method: POST

Parameters: id, long

Body:

{
  "name": "Dick",
  "votes": [
    "2014-01-01",
    "2014-01-05"
  ]
}

### Show the results of an event

Endpoint: /api/v1/event/{id}/results Responds with dates that are suitable for all participants.

Method: GET

Parameters: id, long