package com.qq.e.comm.plugin.ab;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
class f extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12075a = f.class.getSimpleName();

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        ai.a(f12075a, "LoadingResource:" + str);
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        ai.a(f12075a, "onPageFinished====>" + str);
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        ai.a(f12075a, "onPageStarted====>" + str);
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        ai.a(f12075a, "onReceivedError. errorCode:" + i + ".description:" + str + "failingUrl:" + str2);
        if (webView instanceof d) {
            ((d) webView).a(new com.qq.e.comm.plugin.ab.a.a(com.qq.e.comm.plugin.ab.a.c.ResourceLoadFail, null));
        }
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (webView instanceof d) {
                d dVar = (d) webView;
                dVar.a().a();
                dVar.a().a(str);
                return true;
            }
            return false;
        } catch (Throwable th) {
            GDTLogger.e("Exception occurred in GDTWebViewClient:", th);
            return true;
        }
    }
}
