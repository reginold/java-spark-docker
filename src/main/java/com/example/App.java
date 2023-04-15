package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.codehaus.janino.Java;

import com.google.common.collect.Iterables;

import scala.Tuple2;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<String> inputData = new ArrayList<>();
        inputData.add("WARN: 1111111111");
        inputData.add("ERROR: 2222222222");
        inputData.add("FATAL: 3333333333");
        inputData.add("ERROR: 4444444444");

        Logger logger = LogManager.getLogger("org.apache");
        ((org.apache.logging.log4j.core.Logger) logger).setLevel(Level.WARN);

        SparkConf conf = new SparkConf().setAppName("startSpark").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // JavaRDD<Integer> originalIntegers = sc.parallelize(inputData);
        // // JavaRDD<InterWithSquareRoot> sqrtRdd = originalIntegers.map(value -> new
        // // InterWithSquareRoot(value));
        // JavaRDD<Tuple2<Integer, Double>> sqRdd = originalIntegers.map(value -> new
        // Tuple2<>(value, Math.sqrt(value)));
        // // Collect the elements and print them
        // List<Tuple2<Integer, Double>> result = sqRdd.collect();
        // for (Tuple2<Integer, Double> element : result) {
        // System.out.println("Number: " + element._1 + ", Square Root: " + element._2);
        // }

        // sc.parallelize(inputData)
        // .mapToPair(rawValue -> new Tuple2<>(rawValue.split(":")[0], 1L))
        // .groupByKey()
        // .foreach(tuple -> System.out.println(tuple._1 + " has " +
        // Iterables.size(tuple._2) + " instances"));

        // sc.parallelize(inputData)
        // .flatMap(value -> Arrays.asList(value.split(" ")).iterator())
        // .filter(word -> word.length() < 6)
        // .foreach(value -> System.out.println(value));
        sc.textFile("src/main/data/test.txt")
                .flatMap(value -> Arrays.asList(value.split(" ")).iterator())
                .foreach(value -> System.out.println(value));
        sc.close();
    }
}
