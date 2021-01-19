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
    private boolean pYM = false;
    private Info pZe;
    private AdvancedWebView pZi;
    private ProgressBar pZj;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.c.layout_h5_open_activity);
        try {
            this.pZe = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.pZe != null) {
            this.pYM = true;
            w.iK(this).e(new x(this.pZe)).eGz();
            this.pZj = (ProgressBar) findViewById(d.b.h5_open_webview_process);
            this.pZi = (AdvancedWebView) findViewById(d.b.h5_open_webview);
            this.pZi.a(this, this);
            this.pZi.setGeolocationEnabled(false);
            this.pZi.setMixedContentAllowed(false);
            this.pZi.setCookiesEnabled(true);
            this.pZi.setThirdPartyCookiesEnabled(true);
            this.pZi.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.activitys.H5OpenActivity.1
                @Override // android.webkit.WebViewClient
                public final void onPageFinished(WebView webView, String str) {
                }
            });
            this.pZi.setWebChromeClient(new WebChromeClient() { // from class: com.win.opensdk.activitys.H5OpenActivity.2
                @Override // android.webkit.WebChromeClient
                public final void onReceivedTitle(WebView webView, String str) {
                    super.onReceivedTitle(webView, str);
                }

                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView, int i) {
                    if (H5OpenActivity.this.pZj != null) {
                        H5OpenActivity.this.pZj.setVisibility(0);
                        H5OpenActivity.this.pZj.setProgress(i);
                        if (i == 100) {
                            H5OpenActivity.this.pZj.setVisibility(8);
                        }
                    }
                    super.onProgressChanged(webView, i);
                }
            });
            if (this.pZe != null && !TextUtils.isEmpty(this.pZe.getOph5Url())) {
                this.pZi.loadUrl(this.pZe.getOph5Url());
            } else if (this.pZe != null && !TextUtils.isEmpty(this.pZe.getOpen()) && !"null".equals(this.pZe.getOpen())) {
                this.pZi.loadUrl(this.pZe.getOpen());
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.pZi != null) {
            AdvancedWebView advancedWebView = this.pZi;
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
        this.pYM = false;
        w.iK(this).d(new x(this.pZe)).eGz();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.pZi != null) {
            this.pZi.d(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z;
        if (this.pZi != null) {
            AdvancedWebView advancedWebView = this.pZi;
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
        this.pZi.setVisibility(4);
    }

    @Override // com.win.opensdk.webviewbase.AdvancedWebView.a
    public final void aaE(String str) {
        this.pZi.setVisibility(0);
        if (this.pYM) {
            w.iK(this).a(new x(this.pZe), 200, str).eGz();
            this.pYM = false;
        }
    }

    @Override // com.win.opensdk.webviewbase.AdvancedWebView.a
    public final void cd(int i, String str) {
        if (this.pYM) {
            w.iK(this).a(new x(this.pZe), i, str).eGz();
            this.pYM = false;
            Toast.makeText(this, getString(d.e.win_loadp_error), 0).show();
        }
    }
}
