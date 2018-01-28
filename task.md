Problem:

You are provided with the *.csv.gz file containing some data about plane flights.

Data has the following schema

```
"YEAR","QUARTER","MONTH","DAY_OF_MONTH","DAY_OF_WEEK","FL_DATE","ORIGIN","DEST"
```

You'll need to extract several statistics out of the data file:

1) List of all airports with total number of planes for the whole period that arrived to each airport
2) Non-Zero difference in total number of planes that arrived to and left from the airport
3) Do the point 1 but sum number of planes separately per each week
4) Write some tests for the implemented functions

Each point 1-3 should produce a separate output file.

 
Whole task is expected to be done in scala language using "sbt" as a build tool.
Output all expected files after being launched via "sbt run" command
expect planes_log.csv.gz to be present in resources folder, so you do not need to read it's location from input
"specs2" as framework for writing tests. There is no typo there, "specs2" is the name of testing framework, without the space between "specs" and "2"
 

Example of data processing:

Given the following input

 
```
"YEAR","QUARTER","MONTH","DAY_OF_MONTH","DAY_OF_WEEK","FL_DATE","ORIGIN","DEST",
2014,1,1,1,3,2014-01-01,"JFK","LAX",
2014,1,1,5,7,2014-01-05,"JFK","KBP",
2014,1,1,6,1,2014-01-06,"KBP","LAX",

2014,1,1,8,3,2014-01-08,"JFK","LAX",
2014,1,1,12,7,2014-01-12,"JFK","KBP",
2014,1,1,13,1,2014-01-13,"KBP","LAX",
 ```

The output will be:

```
First task
    LAX 4
    KBP 2
    JFK 0
    
Second Task
    JFK -4
    LAX +4
    
Third task:
    W1
        LAX 2
        KBP 1
        JFK 0
    W2
        LAX 2
        KBP 1
        JFK 0
```

Fourth task - whatever tests you'd like to write.

The output if of course packed into files, I'm just using  plain test to give the example of numbers.