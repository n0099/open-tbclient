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
    private boolean qiQ = false;
    private Info qji;
    private AdvancedWebView qjm;
    private ProgressBar qjn;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.c.layout_h5_open_activity);
        try {
            this.qji = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.qji != null) {
            this.qiQ = true;
            w.iN(this).e(new x(this.qji)).eIP();
            this.qjn = (ProgressBar) findViewById(d.b.h5_open_webview_process);
            this.qjm = (AdvancedWebView) findViewById(d.b.h5_open_webview);
            this.qjm.a(this, this);
            this.qjm.setGeolocationEnabled(false);
            this.qjm.setMixedContentAllowed(false);
            this.qjm.setCookiesEnabled(true);
            this.qjm.setThirdPartyCookiesEnabled(true);
            this.qjm.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.activitys.H5OpenActivity.1
                @Override // android.webkit.WebViewClient
                public final void onPageFinished(WebView webView, String str) {
                }
            });
            this.qjm.setWebChromeClient(new WebChromeClient() { // from class: com.win.opensdk.activitys.H5OpenActivity.2
                @Override // android.webkit.WebChromeClient
                public final void onReceivedTitle(WebView webView, String str) {
                    super.onReceivedTitle(webView, str);
                }

                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView, int i) {
                    if (H5OpenActivity.this.qjn != null) {
                        H5OpenActivity.this.qjn.setVisibility(0);
                        H5OpenActivity.this.qjn.setProgress(i);
                        if (i == 100) {
                            H5OpenActivity.this.qjn.setVisibility(8);
                        }
                    }
                    super.onProgressChanged(webView, i);
                }
            });
            if (this.qji != null && !TextUtils.isEmpty(this.qji.getOph5Url())) {
                this.qjm.loadUrl(this.qji.getOph5Url());
            } else if (this.qji != null && !TextUtils.isEmpty(this.qji.getOpen()) && !"null".equals(this.qji.getOpen())) {
                this.qjm.loadUrl(this.qji.getOpen());
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.qjm != null) {
            AdvancedWebView advancedWebView = this.qjm;
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
        this.qiQ = false;
        w.iN(this).d(new x(this.qji)).eIP();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.qjm != null) {
            this.qjm.d(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z;
        if (this.qjm != null) {
            AdvancedWebView advancedWebView = this.qjm;
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
    public final void eIP() {
        this.qjm.setVisibility(4);
    }

    @Override // com.win.opensdk.webviewbase.AdvancedWebView.a
    public final void abF(String str) {
        this.qjm.setVisibility(0);
        if (this.qiQ) {
            w.iN(this).a(new x(this.qji), 200, str).eIP();
            this.qiQ = false;
        }
    }

    @Override // com.win.opensdk.webviewbase.AdvancedWebView.a
    public final void ck(int i, String str) {
        if (this.qiQ) {
            w.iN(this).a(new x(this.qji), i, str).eIP();
            this.qiQ = false;
            Toast.makeText(this, getString(d.e.win_loadp_error), 0).show();
        }
    }
}
