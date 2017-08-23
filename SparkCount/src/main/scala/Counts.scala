import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Counts {
  def main(args: Array[String]) {
    // create Spark context with Spark configuration
    val sc = new SparkContext(new SparkConf().setAppName("Spark Count"))

    // read in text file
    val files = sc.textFile(args(0))

    // count Number of lines for the read file
    val wordCounts = files.count

    System.out.println("This file have "+wordCounts+" Lines")
  }
}