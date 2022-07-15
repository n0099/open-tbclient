package com.kwad.components.core.l;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @MainThread
    public static WebSettings a(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, webView)) == null) {
            if (webView == null) {
                return null;
            }
            webView.getSettings().setAllowFileAccess(false);
            return b(webView);
        }
        return (WebSettings) invokeL.objValue;
    }

    public static WebSettings b(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, webView)) == null) {
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(false);
            settings.setJavaScriptEnabled(true);
            settings.setSavePassword(false);
            settings.setTextZoom(100);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            if (Build.VERSION.SDK_INT < 19) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
            }
            webView.setSaveEnabled(false);
            return settings;
        }
        return (WebSettings) invokeL.objValue;
    }
}
