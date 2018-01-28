Exercises
===

We have file data/planes_log.csv.gz containing some data about plane flights 

1) List of all airports with total number of planes for the whole period that arrived to each airport
2) Non-Zero difference in total number of planes that arrived to and left from the airport
3) Do the point 1 but sum number of planes separately per each week
4) Write some tests for the implemented functions

Clone
===
```
git clone https://github.com/yurii-khomenko/plane-flights-analyzer.git
```
Test
===
In project directory type(http://www.scala-sbt.org/):
```
sbt test
```
Run
===
```
sbt "run [Number of task: 1..3]"
```