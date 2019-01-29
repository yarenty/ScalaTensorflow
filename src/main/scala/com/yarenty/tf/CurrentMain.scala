package com.yarenty.tf

import com.typesafe.scalalogging.Logger
import com.yarenty.tf.introduciton.PlayWithTensors
import org.platanios.tensorflow.jni.TensorFlow
import org.slf4j.LoggerFactory

object CurrentMain extends App {
  private val logger = Logger(LoggerFactory.getLogger("TF on Scala"))
  
  logger.info("Hello from Tensorflow::" + TensorFlow.version )
  
  //  RNNExample.main(null)
  new PlayWithTensors().flow()

}
