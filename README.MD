# Serize Akka - serize serialization for akka

Add suport for [serize](https://github.com/aki-ks/serize/) (a fork of [boopickle](https://github.com/suzaku-io/boopickle)) to [akka](https://akka.io/).

# Usage

First of all add the jitpack resolver and this github repository as a dependency to your project:
https://jitpack.io/#aki-ks/serize-akka/

You must create a singleton that contains all picklers and a class that will be used as serializer for akka:
``` Scala
import serize._

object ExamplePicklers extends Default {
  val container = Container
//  .withCaseClass[...]
//  .withCaseObject(...)
}

class ExampleSerizeSerializer extends SerizeAkkaSerializer(ExamplePicklers)
```

Now you must add your Serializer to your akka configuration:
```
akka {
  actor {
    serializers {
      example = "me.mypackage.ExampleSerizeSerializer"
    }

    serialization-bindings {
      "serize.SerizeMessage" = example
    }
  }
}
```
