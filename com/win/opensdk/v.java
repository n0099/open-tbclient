package com.win.opensdk;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.win.opensdk.activitys.H5OpenActivity;
/* loaded from: classes7.dex */
public class v extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5OpenActivity f40810a;

    public v(H5OpenActivity h5OpenActivity) {
        this.f40810a = h5OpenActivity;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        ProgressBar progressBar = this.f40810a.f40683b;
        if (progressBar != null) {
            progressBar.setVisibility(0);
            this.f40810a.f40683b.setProgress(i2);
            if (i2 == 100) {
                this.f40810a.f40683b.setVisibility(8);
            }
        }
        super.onProgressChanged(webView, i2);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
    }
}
