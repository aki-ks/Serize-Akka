# Serize Akka - serize serialization for akka
[![](https://jitpack.io/v/aki-ks/serize-akka.svg)](https://jitpack.io/#aki-ks/serize-akka)

Add suport for [serize](https://github.com/aki-ks/serize/) (a fork of [boopickle](https://github.com/suzaku-io/boopickle)) to [akka](https://akka.io/).

# Usage

First of all add the jitpack resolver and this github repository as a dependency to your project:
https://jitpack.io/#aki-ks/serize-akka/

If you want to use the @serize macro annotation, you must add the macroparadise compiler plugin:
``` sbt
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)
```

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
