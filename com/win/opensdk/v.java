package com.win.opensdk;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.win.opensdk.activitys.H5OpenActivity;
/* loaded from: classes7.dex */
public class v extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5OpenActivity f40441a;

    public v(H5OpenActivity h5OpenActivity) {
        this.f40441a = h5OpenActivity;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        ProgressBar progressBar = this.f40441a.f40260b;
        if (progressBar != null) {
            progressBar.setVisibility(0);
            this.f40441a.f40260b.setProgress(i);
            if (i == 100) {
                this.f40441a.f40260b.setVisibility(8);
            }
        }
        super.onProgressChanged(webView, i);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
    }
}
