package sjsonnet

import ujson.Value
object TestUtils {
  def eval(s: String, preserveOrder: Boolean = false, strict: Boolean = false): Value = {
    new Interpreter(
      Map(),
      Map(),
      DummyPath(),
      Importer.empty,
      parseCache = new DefaultParseCache,
      new Settings(preserveOrder = preserveOrder, strict = strict)
    ).interpret(s, DummyPath("(memory)")) match {
      case Right(x) => x
      case Left(e) => throw new Exception(e)
    }
  }

}
