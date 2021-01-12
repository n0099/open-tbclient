package com.qq.e.comm.plugin.ab.d;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.qq.e.comm.plugin.util.r;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
public class d extends com.qq.e.comm.plugin.ab.f.d {

    /* renamed from: a  reason: collision with root package name */
    private f f11756a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.ab.f.e f11757b;

    public void a(f fVar) {
        this.f11756a = fVar;
    }

    public void a(com.qq.e.comm.plugin.ab.f.e eVar) {
        this.f11757b = eVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.f11756a != null) {
            this.f11756a.a(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.f11756a != null) {
            this.f11756a.a(str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.f11756a != null) {
            this.f11756a.a(i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            sslErrorHandler.cancel();
        }
        r.a(sslError);
    }

    @Override // com.qq.e.comm.plugin.ab.f.d, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        GDTLogger.d("InnerAndroidWebViewClient shouldOverrideUrlLoading, url : " + str);
        boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, str);
        if (this.f11756a != null) {
            if (shouldOverrideUrlLoading) {
                this.f11756a.d_();
            }
            this.f11756a.b(str);
        }
        if (this.f11757b != null && com.qq.e.comm.plugin.ab.b.a.a(Uri.parse(str))) {
            this.f11757b.a(str);
        }
        return shouldOverrideUrlLoading;
    }
}
