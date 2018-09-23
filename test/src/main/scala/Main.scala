import scalanative.native._
import webview.WebView

object Main {
  def main(args: Array[String]): Unit = Zone{ implicit z =>
    val view = WebView("ARTE","http://www.arte.de")
    view.init()
    while( view.loop(true) == 0 ) {}
    view.exit()
//    WebView.open(c"google",c"http://www.arte.de",800,600,true)
  }
}
