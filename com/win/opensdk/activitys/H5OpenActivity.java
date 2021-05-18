package com.win.opensdk.activitys;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.baidu.android.common.others.lang.StringUtil;
import com.win.opensdk.R;
import com.win.opensdk.T1;
import com.win.opensdk.core.Info;
import com.win.opensdk.u;
import com.win.opensdk.v;
import com.win.opensdk.w0;
import com.win.opensdk.webviewbase.AdvancedWebView;
import com.win.opensdk.x0;
import com.win.opensdk.y0;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class H5OpenActivity extends Activity implements T1 {

    /* renamed from: a  reason: collision with root package name */
    public AdvancedWebView f37074a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f37075b;

    /* renamed from: c  reason: collision with root package name */
    public Info f37076c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37077d = false;

    @Override // com.win.opensdk.T1
    public void a(int i2, String str, String str2) {
        if (this.f37077d) {
            x0.a(this).a(new y0(this.f37076c), i2, str2).a();
            this.f37077d = false;
            Toast.makeText(this, getString(R.string.win_loadp_error), 0).show();
        }
    }

    @Override // com.win.opensdk.T1
    public void a(String str) {
        this.f37074a.setVisibility(0);
        if (this.f37077d) {
            x0.a(this).a(new y0(this.f37076c), 200, str).a();
            this.f37077d = false;
        }
    }

    @Override // com.win.opensdk.T1
    public void a(String str, Bitmap bitmap) {
        this.f37074a.setVisibility(4);
    }

    @Override // com.win.opensdk.T1
    public void a(String str, String str2, String str3, long j, String str4, String str5) {
    }

    @Override // com.win.opensdk.T1
    public void b(String str) {
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        AdvancedWebView advancedWebView = this.f37074a;
        if (advancedWebView != null) {
            advancedWebView.a(i2, i3, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        AdvancedWebView advancedWebView = this.f37074a;
        if (advancedWebView == null || advancedWebView.b()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        AdvancedWebView advancedWebView;
        String open;
        super.onCreate(bundle);
        setContentView(R.layout.win_layout_h5_open_activity);
        try {
            this.f37076c = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f37076c == null) {
            return;
        }
        this.f37077d = true;
        w0 a2 = x0.a(this);
        try {
            a2.f37229b = x0.a("wbas", new y0(this.f37076c));
        } catch (JSONException unused) {
        }
        a2.a();
        this.f37075b = (ProgressBar) findViewById(R.id.win_h5_open_webview_process);
        AdvancedWebView advancedWebView2 = (AdvancedWebView) findViewById(R.id.win_h5_open_webview);
        this.f37074a = advancedWebView2;
        advancedWebView2.a(this, this);
        this.f37074a.setGeolocationEnabled(false);
        this.f37074a.setMixedContentAllowed(false);
        this.f37074a.setCookiesEnabled(true);
        this.f37074a.setThirdPartyCookiesEnabled(true);
        this.f37074a.setWebViewClient(new u(this));
        this.f37074a.setWebChromeClient(new v(this));
        Info info = this.f37076c;
        if (info == null || TextUtils.isEmpty(info.getOph5Url())) {
            Info info2 = this.f37076c;
            if (info2 == null || TextUtils.isEmpty(info2.getOpen()) || StringUtil.NULL_STRING.equals(this.f37076c.getOpen())) {
                return;
            }
            advancedWebView = this.f37074a;
            open = this.f37076c.getOpen();
        } else {
            advancedWebView = this.f37074a;
            open = this.f37076c.getOph5Url();
        }
        advancedWebView.loadUrl(open);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        AdvancedWebView advancedWebView = this.f37074a;
        if (advancedWebView != null) {
            advancedWebView.c();
        }
        super.onDestroy();
        this.f37077d = false;
        w0 a2 = x0.a(this);
        try {
            a2.f37229b = x0.a("wbao", new y0(this.f37076c));
        } catch (JSONException unused) {
        }
        a2.a();
    }
}
