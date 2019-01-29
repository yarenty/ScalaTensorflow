package com.yarenty.tf.introduciton

import com.typesafe.scalalogging.Logger
import org.platanios.tensorflow.api._


import org.slf4j.LoggerFactory

class PlayWithTensors {
  private val logger = Logger(LoggerFactory.getLogger("TF on Scala"))

  def flow(): Unit = {
    println(
      """
        |==================================================
        |     TENSOR SIMPLE
        |==================================================
        |     
      """.stripMargin)
    simpleTensor
    println(
      """
        |==================================================
        |     TENSOR CASTING
        |==================================================
        |     
      """.stripMargin)
    tensorCasting
    println(
      """
        |==================================================
        |     TENSOR SHAPES
        |==================================================
        |     
      """.stripMargin)
    tensorShapes()
    println(
      """
        |==================================================
        |     TENSOR INDEXING / SLICING
        |==================================================
        |     
      """.stripMargin)
    indexingAndSlicing()

    println("=============================================")
  }

  def simpleTensor(): Unit = {
    val tensor = Tensor.zeros[Int](Shape(2, 5))

    println(tensor.summarize())
    println

    val a = Tensor[Int](1, 2) // Creates a Tensor[Int] with shape [2]
    val b = Tensor[Long](1L, 2) // Creates a Tensor[Long] with shape [2]
    val c = Tensor[Float](3.0f) // Creates a Tensor[Float] with shape [1]
    val d = Tensor[Double](-4.0) // Creates a Tensor[Double] with shape [1]
    val e = Tensor.empty[Int] // Creates an empty Tensor[Int] with shape [0]
    val z = Tensor.zeros[Float](Shape(5, 2)) // Creates a zeros Tensor[Float] with shape [5, 2]
    val r = Tensor.randn(Double, Shape(10, 3)) // Creates a Tensor[Double] with shape [10, 3] and
    // elements drawn from the standard Normal distribution.

    println("a:\n" + a.summarize())
    println("b:\n" + b.summarize())
    println("c:\n" + c.summarize())
    println("d:\n" + d.summarize())
    println("e:\n" + e.summarize())
    println("z:\n" + z.summarize())
    println("r:\n" + r.summarize())
    println
    println
  }

  def tensorCasting(): Unit = {
    val floatTensor = Tensor[Float](1, 2, 3) // Floating point vector containing the elements: 1.0f, 2.0f, and 3.0f.
    val t1 = floatTensor.toInt // Integer vector containing the elements: 1, 2, and 3.
    val t2 = floatTensor.castTo[Int] // Integer vector containing the elements: 1, 2, and 3.

    println("float::\n" + floatTensor.summarize())
    println("datatype:" + floatTensor.dataType)
    println("shape:" + floatTensor.shape)
    println("device:" + floatTensor.device)
    println


    println("toInt:\n" + t1.summarize())
    println(t1.dataType)
    println
    println("cast:\n" + t2.summarize())
    println
  }

  def tensorShapes(): Unit = {

    val t0 = Tensor.ones[Int](Shape()) // Creates a scalar equal to the value 1
    val t1 = Tensor.ones[Int](Shape(10)) // Creates a vector with 10 elements, all of which are equal to 1
    val t2 = Tensor.ones[Int](Shape(5, 2)) // Creates a matrix with 5 rows with 2 columns

    // You can also create tensors in the following way:
    val t3 = Tensor(2.0, 5.6) // Creates a vector that contains the numbers 2.0 and 5.6
    val t4 = Tensor(Tensor(1.2f, -8.4f), Tensor(-2.3f, 0.4f)) // Creates a matrix with 2 rows and 2 columns


    println("t0:\n" + t0.summarize())
    println("shape:" + t0.shape)
    println("rank:" + t0.rank)
    println
    println("t1:\n" + t1.summarize())
    println("shape:" + t1.shape)
    println("rank:" + t1.rank)
    println
    println("t2:\n" + t2.summarize())
    println("shape:" + t2.shape)
    println("rank:" + t2.rank)
    println
    println("t3:\n" + t3.summarize())
    println("shape:" + t3.shape)
    println("rank:" + t3.rank)
    println
    println("t4:\n" + t4.summarize())
    println("shape:" + t4.shape)
    println("rank:" + t4.rank)
    println

  }

  def indexingAndSlicing(): Unit = {

    val t = Tensor.zeros[Float](Shape(4, 2, 3, 8))
    println(t(::, ::, 1, ::))            // Tensor with shape [4, 2, 1, 8]
    println(t(1 :: -2, ---, 2) )         // Tensor with shape [1, 2, 3, 1]
    println(t(---) )                     // Tensor with shape [4, 2, 3, 8]
    println(t(1 :: -2, ---, NewAxis, 2)) // Tensor with shape [1, 2, 3, 1, 1]
    println(t(1 ::, ---, NewAxis, 2))    // Tensor with shape [3, 2, 3, 1, 1]
    
  }

}
