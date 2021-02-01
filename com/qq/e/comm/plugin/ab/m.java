package com.qq.e.comm.plugin.ab;

import android.graphics.Bitmap;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
/* loaded from: classes15.dex */
class m extends WebViewClient {
    public void onLoadResource(WebView webView, String str) {
        GDTLogger.d("X5 LoadingResource:" + str);
        super.onLoadResource(webView, str);
    }

    public void onPageFinished(WebView webView, String str) {
        GDTLogger.d("X5 onPageFinished====>" + str);
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        GDTLogger.d("X5 onPageStarted====>" + str);
        super.onPageStarted(webView, str, bitmap);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        GDTLogger.d("X5 onReceivedError. errorCode:" + i + ".description:" + str + "failingUrl:" + str2);
        if (webView instanceof l) {
            ((l) webView).a(new com.qq.e.comm.plugin.ab.a.a(com.qq.e.comm.plugin.ab.a.c.ResourceLoadFail, null));
        }
        super.onReceivedError(webView, i, str, str2);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        GDTLogger.d("X5 shouldOverrideUrlLoading:" + str);
        try {
            if (webView instanceof l) {
                l lVar = (l) webView;
                lVar.c().a();
                lVar.c().a(str);
                return true;
            }
            return false;
        } catch (Throwable th) {
            GDTLogger.e("Exception occurred in X5WebViewClient:", th);
            return true;
        }
    }
}
