package com.bytedance.sdk.openadsdk.m;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(WebSettings webSettings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, webSettings) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    webSettings.setMediaPlaybackRequiresUserGesture(false);
                }
            } catch (Throwable th) {
                e.a("WebViewSettings", "allowMediaPlayWithoutUserGesture error", th);
            }
        }
    }

    public static void b(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, webView) == null) {
            try {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable th) {
                e.a("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
            }
        }
    }

    public static void a(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, webView) == null) {
            b(webView);
            WebSettings settings = webView.getSettings();
            a(settings);
            if (settings == null) {
                return;
            }
            try {
                settings.setJavaScriptEnabled(true);
            } catch (Throwable th) {
                e.a("WebViewSettings", "setJavaScriptEnabled error", th);
            }
            try {
                settings.setSupportZoom(false);
            } catch (Throwable th2) {
                e.a("WebViewSettings", "setSupportZoom error", th2);
            }
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setDomStorageEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setBlockNetworkImage(false);
            settings.setDisplayZoomControls(false);
            if (Build.VERSION.SDK_INT >= 16) {
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
            }
            settings.setSavePassword(false);
            boolean z = Build.VERSION.SDK_INT >= 28;
            try {
                if (Build.VERSION.SDK_INT >= 11 && !z) {
                    webView.setLayerType(0, null);
                } else if (Build.VERSION.SDK_INT >= 16 && z) {
                    webView.setLayerType(2, null);
                }
            } catch (Throwable th3) {
                e.a("WebViewSettings", "setLayerType error", th3);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                webView.getSettings().setMixedContentMode(0);
            }
        }
    }
}
