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
/* loaded from: classes4.dex */
public class H5OpenActivity extends Activity implements AdvancedWebView.a {
    private boolean qbE = false;
    private Info qbW;
    private AdvancedWebView qca;
    private ProgressBar qcb;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.c.layout_h5_open_activity);
        try {
            this.qbW = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.qbW != null) {
            this.qbE = true;
            w.iM(this).e(new x(this.qbW)).eJL();
            this.qcb = (ProgressBar) findViewById(d.b.h5_open_webview_process);
            this.qca = (AdvancedWebView) findViewById(d.b.h5_open_webview);
            this.qca.a(this, this);
            this.qca.setGeolocationEnabled(false);
            this.qca.setMixedContentAllowed(false);
            this.qca.setCookiesEnabled(true);
            this.qca.setThirdPartyCookiesEnabled(true);
            this.qca.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.activitys.H5OpenActivity.1
                @Override // android.webkit.WebViewClient
                public final void onPageFinished(WebView webView, String str) {
                }
            });
            this.qca.setWebChromeClient(new WebChromeClient() { // from class: com.win.opensdk.activitys.H5OpenActivity.2
                @Override // android.webkit.WebChromeClient
                public final void onReceivedTitle(WebView webView, String str) {
                    super.onReceivedTitle(webView, str);
                }

                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView, int i) {
                    if (H5OpenActivity.this.qcb != null) {
                        H5OpenActivity.this.qcb.setVisibility(0);
                        H5OpenActivity.this.qcb.setProgress(i);
                        if (i == 100) {
                            H5OpenActivity.this.qcb.setVisibility(8);
                        }
                    }
                    super.onProgressChanged(webView, i);
                }
            });
            if (this.qbW != null && !TextUtils.isEmpty(this.qbW.getOph5Url())) {
                this.qca.loadUrl(this.qbW.getOph5Url());
            } else if (this.qbW != null && !TextUtils.isEmpty(this.qbW.getOpen()) && !"null".equals(this.qbW.getOpen())) {
                this.qca.loadUrl(this.qbW.getOpen());
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.qca != null) {
            AdvancedWebView advancedWebView = this.qca;
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
        this.qbE = false;
        w.iM(this).d(new x(this.qbW)).eJL();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.qca != null) {
            this.qca.d(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z;
        if (this.qca != null) {
            AdvancedWebView advancedWebView = this.qca;
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
    public final void eJL() {
        this.qca.setVisibility(4);
    }

    @Override // com.win.opensdk.webviewbase.AdvancedWebView.a
    public final void abK(String str) {
        this.qca.setVisibility(0);
        if (this.qbE) {
            w.iM(this).a(new x(this.qbW), 200, str).eJL();
            this.qbE = false;
        }
    }

    @Override // com.win.opensdk.webviewbase.AdvancedWebView.a
    public final void cc(int i, String str) {
        if (this.qbE) {
            w.iM(this).a(new x(this.qbW), i, str).eJL();
            this.qbE = false;
            Toast.makeText(this, getString(d.e.win_loadp_error), 0).show();
        }
    }
}
