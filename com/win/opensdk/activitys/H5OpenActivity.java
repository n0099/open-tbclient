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
    private Info qdE;
    private AdvancedWebView qdI;
    private ProgressBar qdJ;
    private boolean qdm = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.c.layout_h5_open_activity);
        try {
            this.qdE = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.qdE != null) {
            this.qdm = true;
            w.iM(this).e(new x(this.qdE)).eKp();
            this.qdJ = (ProgressBar) findViewById(d.b.h5_open_webview_process);
            this.qdI = (AdvancedWebView) findViewById(d.b.h5_open_webview);
            this.qdI.a(this, this);
            this.qdI.setGeolocationEnabled(false);
            this.qdI.setMixedContentAllowed(false);
            this.qdI.setCookiesEnabled(true);
            this.qdI.setThirdPartyCookiesEnabled(true);
            this.qdI.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.activitys.H5OpenActivity.1
                @Override // android.webkit.WebViewClient
                public final void onPageFinished(WebView webView, String str) {
                }
            });
            this.qdI.setWebChromeClient(new WebChromeClient() { // from class: com.win.opensdk.activitys.H5OpenActivity.2
                @Override // android.webkit.WebChromeClient
                public final void onReceivedTitle(WebView webView, String str) {
                    super.onReceivedTitle(webView, str);
                }

                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView, int i) {
                    if (H5OpenActivity.this.qdJ != null) {
                        H5OpenActivity.this.qdJ.setVisibility(0);
                        H5OpenActivity.this.qdJ.setProgress(i);
                        if (i == 100) {
                            H5OpenActivity.this.qdJ.setVisibility(8);
                        }
                    }
                    super.onProgressChanged(webView, i);
                }
            });
            if (this.qdE != null && !TextUtils.isEmpty(this.qdE.getOph5Url())) {
                this.qdI.loadUrl(this.qdE.getOph5Url());
            } else if (this.qdE != null && !TextUtils.isEmpty(this.qdE.getOpen()) && !"null".equals(this.qdE.getOpen())) {
                this.qdI.loadUrl(this.qdE.getOpen());
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.qdI != null) {
            AdvancedWebView advancedWebView = this.qdI;
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
        this.qdm = false;
        w.iM(this).d(new x(this.qdE)).eKp();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.qdI != null) {
            this.qdI.d(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z;
        if (this.qdI != null) {
            AdvancedWebView advancedWebView = this.qdI;
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
    public final void eKp() {
        this.qdI.setVisibility(4);
    }

    @Override // com.win.opensdk.webviewbase.AdvancedWebView.a
    public final void abL(String str) {
        this.qdI.setVisibility(0);
        if (this.qdm) {
            w.iM(this).a(new x(this.qdE), 200, str).eKp();
            this.qdm = false;
        }
    }

    @Override // com.win.opensdk.webviewbase.AdvancedWebView.a
    public final void cc(int i, String str) {
        if (this.qdm) {
            w.iM(this).a(new x(this.qdE), i, str).eKp();
            this.qdm = false;
            Toast.makeText(this, getString(d.e.win_loadp_error), 0).show();
        }
    }
}
