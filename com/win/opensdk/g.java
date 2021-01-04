package com.win.opensdk;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
/* loaded from: classes4.dex */
public final class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(WebView webView, String str) {
        if (webView != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        webView.evaluateJavascript(str, null);
                    } else {
                        webView.loadUrl(str);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static void a(WebView webView, int i, int i2) {
        e(webView, "javascript:window.mraidbridge.setMaxSize(" + i + "," + i2 + ")");
    }

    public static void b(WebView webView, int i, int i2) {
        e(webView, "javascript:window.mraidbridge.setScreenSize(" + i + "," + i2 + ")");
    }

    public static void d(WebView webView, String str) {
        e(webView, "javascript:window.mraidbridge.setState('" + str + "')");
    }

    public static void b(WebView webView, boolean z) {
        e(webView, "javascript:window.mraidbridge.setIsViewable(" + z + ")");
    }
}
