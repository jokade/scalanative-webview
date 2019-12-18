import scalanative._
import unsafe._
import webview.WebView

object Main {
//  def foo(view: Ptr[Byte], str: CString): Unit = {
//    println(fromCString(str))
//  }
//  val fooFunc = CFunctionPtr.fromFunction2(foo)
  def main(args: Array[String]): Unit = Zone{ implicit z =>
    val view = WebView("ARTE","http://www.arte.de",callback = null)
    view.init()
    view.eval(c"window.onload = function() {invoke('foo');alert('hello');};")
    while( view.loop(true) == 0 ) {
    }
    view.exit()
//    WebView.open(c"google",c"http://www.arte.de",800,600,true)
  }
}
