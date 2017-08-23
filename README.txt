1. Launch LinesCount sample :

Move to the project directory in shell and then launch : sbt package

spark-submit --class donald.spark.training.LinesCount target/scala-2.10/linescount_2.10-1.0.jar <file to read with full hdfs path>

2. Launch Min Max Salaries per Departement 

Move to the project directory in shell and then launch : sbt package

spark-submit --class donald.spark.training.MaxMinSalFinder target/scala-2.10/minmaxsal_2.10-1.0.jar <file to read with full hdfs path> <file to save at hdfs directory>
