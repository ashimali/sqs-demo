#### Toy Spring cloud messaging and Localstack integration test example


1. In one terminal run localstack in docker container
   
   ```make run-localstack```
   
2. In another terminal run the tests
   
   ```make integration-test```  
     
     
There are ways of getting gradle to handle starting and waiting for localstack using [Testcontainers](https://www.testcontainers.org)
but I leave that as an exercise for the reader. It probably makes more sense to do it what way but I haven't tried it out.
