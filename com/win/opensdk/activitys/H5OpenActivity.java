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
    private Info qjI;
    private AdvancedWebView qjM;
    private ProgressBar qjN;
    private boolean qjq = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.c.layout_h5_open_activity);
        try {
            this.qjI = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.qjI != null) {
            this.qjq = true;
            w.iN(this).e(new x(this.qjI)).eIX();
            this.qjN = (ProgressBar) findViewById(d.b.h5_open_webview_process);
            this.qjM = (AdvancedWebView) findViewById(d.b.h5_open_webview);
            this.qjM.a(this, this);
            this.qjM.setGeolocationEnabled(false);
            this.qjM.setMixedContentAllowed(false);
            this.qjM.setCookiesEnabled(true);
            this.qjM.setThirdPartyCookiesEnabled(true);
            this.qjM.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.activitys.H5OpenActivity.1
                @Override // android.webkit.WebViewClient
                public final void onPageFinished(WebView webView, String str) {
                }
            });
            this.qjM.setWebChromeClient(new WebChromeClient() { // from class: com.win.opensdk.activitys.H5OpenActivity.2
                @Override // android.webkit.WebChromeClient
                public final void onReceivedTitle(WebView webView, String str) {
                    super.onReceivedTitle(webView, str);
                }

                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView, int i) {
                    if (H5OpenActivity.this.qjN != null) {
                        H5OpenActivity.this.qjN.setVisibility(0);
                        H5OpenActivity.this.qjN.setProgress(i);
                        if (i == 100) {
                            H5OpenActivity.this.qjN.setVisibility(8);
                        }
                    }
                    super.onProgressChanged(webView, i);
                }
            });
            if (this.qjI != null && !TextUtils.isEmpty(this.qjI.getOph5Url())) {
                this.qjM.loadUrl(this.qjI.getOph5Url());
            } else if (this.qjI != null && !TextUtils.isEmpty(this.qjI.getOpen()) && !"null".equals(this.qjI.getOpen())) {
                this.qjM.loadUrl(this.qjI.getOpen());
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.qjM != null) {
            AdvancedWebView advancedWebView = this.qjM;
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
        this.qjq = false;
        w.iN(this).d(new x(this.qjI)).eIX();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.qjM != null) {
            this.qjM.d(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z;
        if (this.qjM != null) {
            AdvancedWebView advancedWebView = this.qjM;
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
    public final void eIX() {
        this.qjM.setVisibility(4);
    }

    @Override // com.win.opensdk.webviewbase.AdvancedWebView.a
    public final void abR(String str) {
        this.qjM.setVisibility(0);
        if (this.qjq) {
            w.iN(this).a(new x(this.qjI), 200, str).eIX();
            this.qjq = false;
        }
    }

    @Override // com.win.opensdk.webviewbase.AdvancedWebView.a
    public final void ck(int i, String str) {
        if (this.qjq) {
            w.iN(this).a(new x(this.qjI), i, str).eIX();
            this.qjq = false;
            Toast.makeText(this, getString(d.e.win_loadp_error), 0).show();
        }
    }
}
