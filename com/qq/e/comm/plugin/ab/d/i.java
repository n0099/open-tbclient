package com.qq.e.comm.plugin.ab.d;

import android.graphics.Bitmap;
import android.net.Uri;
import com.qq.e.comm.plugin.ab.f.j;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
/* loaded from: classes4.dex */
public class i extends j {

    /* renamed from: a  reason: collision with root package name */
    private f f12063a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.ab.f.e f12064b;

    public void a(f fVar) {
        this.f12063a = fVar;
    }

    public void a(com.qq.e.comm.plugin.ab.f.e eVar) {
        this.f12064b = eVar;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.f12063a != null) {
            this.f12063a.a(str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.f12063a != null) {
            this.f12063a.a(str, bitmap);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.f12063a != null) {
            this.f12063a.a(i, str, str2);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // com.qq.e.comm.plugin.ab.f.j
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, str);
        if (this.f12063a != null) {
            if (shouldOverrideUrlLoading) {
                this.f12063a.d_();
            }
            this.f12063a.b(str);
        }
        if (this.f12064b != null && com.qq.e.comm.plugin.ab.b.a.a(Uri.parse(str))) {
            this.f12064b.a(str);
        }
        return shouldOverrideUrlLoading;
    }
}
