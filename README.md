## Introduction to JSON

## Reminders
1. add jedis and json-p dependencies from mvnrepository
### Weather Application Exercise
1. Create controller WeatherController
2. RequestMapping & GetMapping
3. Exporting API_KEY
4. WeatherService 
5. Using POSTMAN / ARC to determine the keys & values for the string query.
6. Conversion of payload to JSON
7. Reading the json Object

#### Using redis and caching the data
1. Add AppConfig file for redis
2. Create a repository & export redis password
3. Create a cache
4. *VERY IMPORTANT* make sure that redisTemplate equals to the json that you are reading e.g. <String, String> or <String, Object>
5. Use of Optional
6. Setting duration of cache for it to expire.