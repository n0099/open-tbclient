package i.a.a.e.n;

import android.webkit.WebView;
import kotlin.jvm.JvmStatic;
/* loaded from: classes7.dex */
public final class a {
    @JvmStatic
    public static final void a(WebView webView) {
        if (webView != null) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
        }
        if (webView != null) {
            webView.removeJavascriptInterface("accessibility");
        }
        if (webView != null) {
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
    }
}
