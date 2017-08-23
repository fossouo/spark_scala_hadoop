package donald.spark.training

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object LinesCount {
  def main(args: Array[String]) {
     if(args.length != 1) 
      println("Usage : spark-submit --class donald.spark.training.LinesCount target/scala-2.10/linescount_2.10-1.0.jar <file to read with full hdfs path>")
     else {
    // create Spark context with Spark configuration
    val sc = new SparkContext(new SparkConf().setAppName("Spark Count"))
   
    // read in text file
    val files = sc.textFile(args(0))

    // count Number of lines for the read file
    val wordCounts = files.count
    System.out.println("**********************************************")
    System.out.println("** | This file have "+wordCounts+" Lines | ***")
    System.out.println("**********************************************")
    sc.stop()
    }
  }
}