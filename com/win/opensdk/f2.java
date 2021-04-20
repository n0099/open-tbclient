package com.win.opensdk;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
/* loaded from: classes7.dex */
public class f2 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h2 f40220a;

    public f2(h2 h2Var) {
        this.f40220a = h2Var;
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
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f40220a.f40232b.setVisibility(8);
        if (str.contains("TIMED_OUT")) {
            h2 h2Var = this.f40220a;
            if (h2Var.f40233c != null) {
                Z0 b2 = a1.a(h2Var.f40231a).b(new b1(this.f40220a.f40233c), 4);
                b2.a("desc", str + "&errcode:" + i + "&fileurl:" + str2).a();
            }
            Toast.makeText(this.f40220a.f40231a, R.string.win_toast_network_error, 0).show();
        }
    }
}
