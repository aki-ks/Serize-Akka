package serize

import akka.serialization._
import boopickle.{PickleState, UnpickleState}

class SerizeRemoteSerializer(container: Container) extends Serializer {
  val identifier = /* "serize-akka".hashCode */ -901492679
  val includeManifest = false

  def this(picklers: SerizePicklers) = this(picklers.container)

  def toBinary(o: AnyRef): Array[Byte] = {
    val state = PickleState.pickleStateSize
    container.pickle(o)(state)
    state.toByteBuffer.toByteArray
  }

  def fromBinary(bytes: Array[Byte], manifest: Option[Class[_]]): AnyRef = {
    val state = UnpickleState.unpickleStateSize(bytes.toByteBuffer)
    container.unpickle[AnyRef](state)
  }
}
