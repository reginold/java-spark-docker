package com.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<Double> inputData = new ArrayList<>();
        inputData.add(35.5);
        inputData.add(20.32);
        
        Logger logger = LogManager.getLogger("org.apache");
        ((org.apache.logging.log4j.core.Logger) logger).setLevel(Level.WARN);

        SparkConf conf = new SparkConf().setAppName("startSpark").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<Double> myRdd = sc.parallelize(inputData);
        System.out.println( "second greeting!!!" );
        sc.close();
    }
}
