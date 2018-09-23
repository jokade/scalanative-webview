package webview

import de.surfice.smacrotools.debug

import scala.scalanative.native._
import cobj._

@CObj(prefix = "webview_")
@debug
class WebView(title: CString, url: CString, width: Int, height: Int, resizable: Boolean) {

  def init(): Int = extern

  def loop(blocking: Boolean): Int = extern

  def exit(): Unit = extern

  def eval(js: CString): Int = extern
}


object WebView {
  @name("webview")
  def open(title: CString, url: CString, width: Int, height: Int, resizable: Boolean): Int = extern

  def apply(title: String = "",
            url: String = "",
            width: Int = 800,
            height: Int = 600,
            resizable: Boolean = true)(implicit z: Zone): WebView =
    new WebView(toCString(title),toCString(url),width,height,resizable)
}
