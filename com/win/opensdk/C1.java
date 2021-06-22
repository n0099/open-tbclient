package com.win.opensdk;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
/* loaded from: classes7.dex */
public class C1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ E1 f40574a;

    public C1(E1 e1) {
        this.f40574a = e1;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        this.f40574a.f40599b.setVisibility(8);
        if (str.contains("TIMED_OUT")) {
            E1 e1 = this.f40574a;
            if (e1.f40600c != null) {
                w0 b2 = x0.a(e1.f40598a).b(new y0(this.f40574a.f40600c), 4);
                b2.a("desc", str + "&errcode:" + i2 + "&fileurl:" + str2).a();
            }
            Toast.makeText(this.f40574a.f40598a, R.string.win_toast_network_error, 0).show();
        }
    }
}
