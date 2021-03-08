package com.win.opensdk.activitys;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.win.opensdk.bd;
import com.win.opensdk.bx;
import com.win.opensdk.ca;
import com.win.opensdk.cd;
import com.win.opensdk.core.Info;
import com.win.opensdk.en;
import com.win.opensdk.eq;
import com.win.opensdk.fb;
import com.win.opensdk.webviewbase.AdvancedWebView;
import org.json.JSONException;
/* loaded from: classes14.dex */
public class H5OpenActivity extends Activity implements fb {
    public ProgressBar b;
    public boolean d = false;
    public Info qkh;
    public AdvancedWebView qlt;

    @Override // com.win.opensdk.fb
    public void a(int i, String str, String str2) {
        if (this.d) {
            ca.iT(this).a(new cd(this.qkh), i, str2).a();
            this.d = false;
            Toast.makeText(this, getString(bd.e.win_loadp_error), 0).show();
        }
    }

    @Override // com.win.opensdk.fb
    public void a(String str) {
        this.qlt.setVisibility(0);
        if (this.d) {
            ca.iT(this).a(new cd(this.qkh), 200, str).a();
            this.d = false;
        }
    }

    @Override // com.win.opensdk.fb
    public void a(String str, Bitmap bitmap) {
        this.qlt.setVisibility(4);
    }

    @Override // com.win.opensdk.fb
    public void b(String str) {
    }

    @Override // com.win.opensdk.fb
    public void b(String str, String str2, String str3, long j, String str4, String str5) {
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        AdvancedWebView advancedWebView = this.qlt;
        if (advancedWebView != null) {
            advancedWebView.a(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        AdvancedWebView advancedWebView = this.qlt;
        if (advancedWebView == null || advancedWebView.b()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        AdvancedWebView advancedWebView = this.qlt;
        if (advancedWebView != null) {
            advancedWebView.c();
        }
        super.onDestroy();
        this.d = false;
        bx iT = ca.iT(this);
        try {
            iT.qlo = ca.a("wbao", new cd(this.qkh));
        } catch (JSONException e) {
        }
        iT.a();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(bd.c.layout_h5_open_activity);
        try {
            this.qkh = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.qkh != null) {
            this.d = true;
            bx iT = ca.iT(this);
            try {
                iT.qlo = ca.a("wbas", new cd(this.qkh));
            } catch (JSONException e2) {
            }
            iT.a();
            this.b = (ProgressBar) findViewById(bd.b.h5_open_webview_process);
            this.qlt = (AdvancedWebView) findViewById(bd.b.h5_open_webview);
            this.qlt.a(this, this);
            this.qlt.setGeolocationEnabled(false);
            this.qlt.setMixedContentAllowed(false);
            this.qlt.setCookiesEnabled(true);
            this.qlt.setThirdPartyCookiesEnabled(true);
            this.qlt.setWebViewClient(new en(this));
            this.qlt.setWebChromeClient(new eq(this));
            Info info = this.qkh;
            if (info != null && !TextUtils.isEmpty(info.getOph5Url())) {
                this.qlt.loadUrl(this.qkh.getOph5Url());
                return;
            }
            Info info2 = this.qkh;
            if (info2 == null || TextUtils.isEmpty(info2.getOpen()) || "null".equals(this.qkh.getOpen())) {
                return;
            }
            this.qlt.loadUrl(this.qkh.getOpen());
        }
    }
}
