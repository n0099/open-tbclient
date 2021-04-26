package com.win.opensdk;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.win.opensdk.activitys.H5OpenActivity;
/* loaded from: classes6.dex */
public class v extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5OpenActivity f37957a;

    public v(H5OpenActivity h5OpenActivity) {
        this.f37957a = h5OpenActivity;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        ProgressBar progressBar = this.f37957a.f37830b;
        if (progressBar != null) {
            progressBar.setVisibility(0);
            this.f37957a.f37830b.setProgress(i2);
            if (i2 == 100) {
                this.f37957a.f37830b.setVisibility(8);
            }
        }
        super.onProgressChanged(webView, i2);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
    }
}
