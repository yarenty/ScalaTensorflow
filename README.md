Scala Tensorflow
================

How to do Tensorflow fully in Scala

## Intro 
This project is dependent on implementation of https://github.com/eaplatanios/tensorflow_scala
Make sure you have tebsorflow installed.
Soon will add docker build .. 


## Idea
Check if can do all tensorflow activities using strongly typed language as scala.


## Status
- 2019/01/25 - it's alive!! First RNN model !


## Troubleshooting

### Installation / Runing: Issues with JNI
- this works with tensorflow 1.12.0
- install: `brew install tensorflow` or download from tensorflow original `https://storage.googleapis.com/tensorflow/libtensorflow/libtensorflow-cpu-darwin-x86_64-1.12.0.tar.gz`
- gradle: `compile group: 'org.platanios', name: "tensorflow_$scalaBinaryVersion", version: '0.4.1', classifier: 'darwin-cpu-x86_64'`
- for linux version need to change classifier to: `linux-cpu-x86_64`, or  `linux-gpu-x86_64`
     


