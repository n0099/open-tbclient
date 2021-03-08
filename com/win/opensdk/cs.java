package com.win.opensdk;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.win.opensdk.bd;
/* loaded from: classes14.dex */
public class cs extends WebViewClient {
    public final /* synthetic */ cy qlD;

    public cs(cy cyVar) {
        this.qlD = cyVar;
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
        this.qlD.b.setVisibility(8);
        if (str.contains("TIMED_OUT")) {
            cy cyVar = this.qlD;
            if (cyVar.qkh != null) {
                ca.iT(cyVar.f8149a).a(new cd(this.qlD.qkh), 4).hD("desc", str + "&errcode:" + i + "&fileurl:" + str2).a();
            }
            Toast.makeText(this.qlD.f8149a, bd.e.win_toast_network_error, 0).show();
        }
    }
}
