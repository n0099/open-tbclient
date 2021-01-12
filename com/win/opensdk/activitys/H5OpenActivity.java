package com.win.opensdk.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.win.opensdk.core.Info;
import com.win.opensdk.d;
import com.win.opensdk.w;
import com.win.opensdk.webviewbase.AdvancedWebView;
import com.win.opensdk.x;
/* loaded from: classes3.dex */
public class H5OpenActivity extends Activity implements AdvancedWebView.a {
    private boolean pYL = false;
    private Info pZd;
    private AdvancedWebView pZh;
    private ProgressBar pZi;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.c.layout_h5_open_activity);
        try {
            this.pZd = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.pZd != null) {
            this.pYL = true;
            w.iK(this).e(new x(this.pZd)).eGz();
            this.pZi = (ProgressBar) findViewById(d.b.h5_open_webview_process);
            this.pZh = (AdvancedWebView) findViewById(d.b.h5_open_webview);
            this.pZh.a(this, this);
            this.pZh.setGeolocationEnabled(false);
            this.pZh.setMixedContentAllowed(false);
            this.pZh.setCookiesEnabled(true);
            this.pZh.setThirdPartyCookiesEnabled(true);
            this.pZh.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.activitys.H5OpenActivity.1
                @Override // android.webkit.WebViewClient
                public final void onPageFinished(WebView webView, String str) {
                }
            });
            this.pZh.setWebChromeClient(new WebChromeClient() { // from class: com.win.opensdk.activitys.H5OpenActivity.2
                @Override // android.webkit.WebChromeClient
                public final void onReceivedTitle(WebView webView, String str) {
                    super.onReceivedTitle(webView, str);
                }

                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView, int i) {
                    if (H5OpenActivity.this.pZi != null) {
                        H5OpenActivity.this.pZi.setVisibility(0);
                        H5OpenActivity.this.pZi.setProgress(i);
                        if (i == 100) {
                            H5OpenActivity.this.pZi.setVisibility(8);
                        }
                    }
                    super.onProgressChanged(webView, i);
                }
            });
            if (this.pZd != null && !TextUtils.isEmpty(this.pZd.getOph5Url())) {
                this.pZh.loadUrl(this.pZd.getOph5Url());
            } else if (this.pZd != null && !TextUtils.isEmpty(this.pZd.getOpen()) && !"null".equals(this.pZd.getOpen())) {
                this.pZh.loadUrl(this.pZd.getOpen());
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.pZh != null) {
            AdvancedWebView advancedWebView = this.pZh;
            try {
                ((ViewGroup) advancedWebView.getParent()).removeView(advancedWebView);
            } catch (Exception e) {
            }
            try {
                advancedWebView.removeAllViews();
            } catch (Exception e2) {
            }
            advancedWebView.destroy();
        }
        super.onDestroy();
        this.pYL = false;
        w.iK(this).d(new x(this.pZd)).eGz();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.pZh != null) {
            this.pZh.d(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z;
        if (this.pZh != null) {
            AdvancedWebView advancedWebView = this.pZh;
            if (advancedWebView.canGoBack()) {
                advancedWebView.goBack();
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                return;
            }
        }
        super.onBackPressed();
    }

    @Override // com.win.opensdk.webviewbase.AdvancedWebView.a
    public final void eGz() {
        this.pZh.setVisibility(4);
    }

    @Override // com.win.opensdk.webviewbase.AdvancedWebView.a
    public final void aaD(String str) {
        this.pZh.setVisibility(0);
        if (this.pYL) {
            w.iK(this).a(new x(this.pZd), 200, str).eGz();
            this.pYL = false;
        }
    }

    @Override // com.win.opensdk.webviewbase.AdvancedWebView.a
    public final void cd(int i, String str) {
        if (this.pYL) {
            w.iK(this).a(new x(this.pZd), i, str).eGz();
            this.pYL = false;
            Toast.makeText(this, getString(d.e.win_loadp_error), 0).show();
        }
    }
}
