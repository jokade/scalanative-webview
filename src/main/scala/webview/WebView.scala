package webview

import de.surfice.smacrotools.debug

import scala.scalanative._
import unsafe._
import cobj._

@CObj(prefix = "webview_")
@debug
class WebView {

  def init(): Int = extern

  def loop(blocking: Boolean): Int = extern

  def exit(): Unit = extern

  def eval(js: CString): Int = extern
}


object WebView {
  type Callback = CFuncPtr2[Ptr[Byte],CString,Unit]

  @name("webview")
  def open(title: CString, url: CString, width: Int, height: Int, resizable: Boolean): Int = extern

  @name("webview_new")
  def apply(title: CString, url: CString, width: Int, height: Int, resizable: Boolean, debug: Int, callback: Ptr[Byte]): WebView = extern

  def apply(title: String = "",
            url: String = "",
            width: Int = 800,
            height: Int = 600,
            resizable: Boolean = true,
            callback: Callback = null)(implicit z: Zone): WebView =
    apply(toCString(title),toCString(url),width,height,resizable,0,callback.asInstanceOf[Ptr[Byte]])
}
