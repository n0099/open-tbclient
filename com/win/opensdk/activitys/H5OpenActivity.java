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
import com.win.opensdk.Z0;
import com.win.opensdk.a1;
import com.win.opensdk.b1;
import com.win.opensdk.core.Info;
import com.win.opensdk.u;
import com.win.opensdk.v;
import com.win.opensdk.webviewbase.AdvancedWebView;
import com.win.opensdk.y2;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class H5OpenActivity extends Activity implements y2 {

    /* renamed from: a  reason: collision with root package name */
    public AdvancedWebView f40164a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f40165b;

    /* renamed from: c  reason: collision with root package name */
    public Info f40166c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40167d = false;

    @Override // com.win.opensdk.y2
    public void a(int i, String str, String str2) {
        if (this.f40167d) {
            a1.a(this).a(new b1(this.f40166c), i, str2).a();
            this.f40167d = false;
            Toast.makeText(this, getString(R.string.win_loadp_error), 0).show();
        }
    }

    @Override // com.win.opensdk.y2
    public void a(String str) {
        this.f40164a.setVisibility(0);
        if (this.f40167d) {
            a1.a(this).a(new b1(this.f40166c), 200, str).a();
            this.f40167d = false;
        }
    }

    @Override // com.win.opensdk.y2
    public void a(String str, Bitmap bitmap) {
        this.f40164a.setVisibility(4);
    }

    @Override // com.win.opensdk.y2
    public void a(String str, String str2, String str3, long j, String str4, String str5) {
    }

    @Override // com.win.opensdk.y2
    public void b(String str) {
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        AdvancedWebView advancedWebView = this.f40164a;
        if (advancedWebView != null) {
            advancedWebView.a(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        AdvancedWebView advancedWebView = this.f40164a;
        if (advancedWebView == null || advancedWebView.b()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        AdvancedWebView advancedWebView;
        String open;
        super.onCreate(bundle);
        setContentView(R.layout.layout_h5_open_activity);
        try {
            this.f40166c = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f40166c == null) {
            return;
        }
        this.f40167d = true;
        Z0 a2 = a1.a(this);
        try {
            a2.f40139b = a1.a("wbas", new b1(this.f40166c));
        } catch (JSONException unused) {
        }
        a2.a();
        this.f40165b = (ProgressBar) findViewById(R.id.h5_open_webview_process);
        AdvancedWebView advancedWebView2 = (AdvancedWebView) findViewById(R.id.h5_open_webview);
        this.f40164a = advancedWebView2;
        advancedWebView2.a(this, this);
        this.f40164a.setGeolocationEnabled(false);
        this.f40164a.setMixedContentAllowed(false);
        this.f40164a.setCookiesEnabled(true);
        this.f40164a.setThirdPartyCookiesEnabled(true);
        this.f40164a.setWebViewClient(new u(this));
        this.f40164a.setWebChromeClient(new v(this));
        Info info = this.f40166c;
        if (info == null || TextUtils.isEmpty(info.getOph5Url())) {
            Info info2 = this.f40166c;
            if (info2 == null || TextUtils.isEmpty(info2.getOpen()) || StringUtil.NULL_STRING.equals(this.f40166c.getOpen())) {
                return;
            }
            advancedWebView = this.f40164a;
            open = this.f40166c.getOpen();
        } else {
            advancedWebView = this.f40164a;
            open = this.f40166c.getOph5Url();
        }
        advancedWebView.loadUrl(open);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        AdvancedWebView advancedWebView = this.f40164a;
        if (advancedWebView != null) {
            advancedWebView.c();
        }
        super.onDestroy();
        this.f40167d = false;
        Z0 a2 = a1.a(this);
        try {
            a2.f40139b = a1.a("wbao", new b1(this.f40166c));
        } catch (JSONException unused) {
        }
        a2.a();
    }
}
