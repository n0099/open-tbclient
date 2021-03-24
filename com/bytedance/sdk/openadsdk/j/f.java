package com.bytedance.sdk.openadsdk.j;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
/* loaded from: classes6.dex */
public class f {
    public static void a(WebSettings webSettings) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                webSettings.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            d.a("WebViewSettings", "allowMediaPlayWithoutUserGesture error", th);
        }
    }

    public static void b(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            d.a("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    public static void a(WebView webView) {
        b(webView);
        WebSettings settings = webView.getSettings();
        a(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Throwable th) {
            d.a("WebViewSettings", "setJavaScriptEnabled error", th);
        }
        try {
            settings.setSupportZoom(false);
        } catch (Throwable th2) {
            d.a("WebViewSettings", "setSupportZoom error", th2);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setBlockNetworkImage(false);
        settings.setDisplayZoomControls(false);
        boolean z = Build.VERSION.SDK_INT >= 28;
        try {
            if (Build.VERSION.SDK_INT >= 11 && !z) {
                webView.setLayerType(0, null);
            } else if (Build.VERSION.SDK_INT >= 16 && z) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th3) {
            d.a("WebViewSettings", "setLayerType error", th3);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            webView.getSettings().setMixedContentMode(0);
        }
    }
}
