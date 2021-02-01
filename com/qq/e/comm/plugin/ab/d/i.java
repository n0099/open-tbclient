package com.qq.e.comm.plugin.ab.d;

import android.graphics.Bitmap;
import android.net.Uri;
import com.qq.e.comm.plugin.ab.f.j;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
/* loaded from: classes15.dex */
public class i extends j {

    /* renamed from: a  reason: collision with root package name */
    private f f11765a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.ab.f.e f11766b;

    public void a(f fVar) {
        this.f11765a = fVar;
    }

    public void a(com.qq.e.comm.plugin.ab.f.e eVar) {
        this.f11766b = eVar;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.f11765a != null) {
            this.f11765a.a(str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.f11765a != null) {
            this.f11765a.a(str, bitmap);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.f11765a != null) {
            this.f11765a.a(i, str, str2);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // com.qq.e.comm.plugin.ab.f.j
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, str);
        if (this.f11765a != null) {
            if (shouldOverrideUrlLoading) {
                this.f11765a.d_();
            }
            this.f11765a.b(str);
        }
        if (this.f11766b != null && com.qq.e.comm.plugin.ab.b.a.a(Uri.parse(str))) {
            this.f11766b.a(str);
        }
        return shouldOverrideUrlLoading;
    }
}
