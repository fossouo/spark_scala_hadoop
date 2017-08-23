package donald.spark.training

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object MaxMinSalFinder {
  def main(args : Array[String]) {
     if(args.length != 2) 
      println("Usage : spark-submit --class donald.spark.training.MaxMinSalFinder target/scala-2.10/minmaxsal_2.10-1.0.jar <file to read with full hdfs path> <file to save at hdfs directory>")
     else {
       val sConf = new SparkConf().setAppName("MinMaxSal")
       val sc = new SparkContext(sConf)
       val textFile = sc.textFile(args(0), 1)
       val mappedRdd = textFile.map(line => {val arr = line.split(","); val dept = arr(0); val sal = arr(1); (dept,sal)})
       val reducedRdd1 = mappedRdd.reduceByKey((a,b) => {if(a>b) a else b})
       val reducedRdd2 = mappedRdd.reduceByKey((a,b) => {if(a>b) b else a})
       val result = reducedRdd1 join reducedRdd2
       result.saveAsTextFile(args(1))
       sc.stop()
     }
  }

}