package com.win.opensdk;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.win.opensdk.activitys.H5OpenActivity;
/* loaded from: classes14.dex */
public class eq extends WebChromeClient {
    public final /* synthetic */ H5OpenActivity qmm;

    public eq(H5OpenActivity h5OpenActivity) {
        this.qmm = h5OpenActivity;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        ProgressBar progressBar = this.qmm.b;
        if (progressBar != null) {
            progressBar.setVisibility(0);
            this.qmm.b.setProgress(i);
            if (i == 100) {
                this.qmm.b.setVisibility(8);
            }
        }
        super.onProgressChanged(webView, i);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
    }
}
