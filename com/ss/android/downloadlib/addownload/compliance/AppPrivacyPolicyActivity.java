package com.ss.android.downloadlib.addownload.compliance;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import d.p.a.d.f.c;
import d.p.a.d.f.n;
/* loaded from: classes6.dex */
public class AppPrivacyPolicyActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f39039a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f39040b;

    /* renamed from: c  reason: collision with root package name */
    public long f39041c;

    /* renamed from: d  reason: collision with root package name */
    public long f39042d;

    /* renamed from: e  reason: collision with root package name */
    public String f39043e;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.p.a.d.f.f.c.c("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.f39042d);
            AppPrivacyPolicyActivity.this.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends WebViewClient {
        public b() {
        }

        public final boolean a(Uri uri) {
            String scheme = uri.getScheme();
            return ("http".equals(scheme) || "https".equals(scheme)) ? false : true;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return a(webResourceRequest.getUrl());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return a(Uri.parse(str));
        }
    }

    private void b() {
        this.f39039a = (ImageView) findViewById(d.p.a.d.b.iv_privacy_back);
        this.f39040b = (WebView) findViewById(d.p.a.d.b.privacy_webview);
        this.f39039a.setOnClickListener(new a());
        WebSettings settings = this.f39040b.getSettings();
        settings.setGeolocationEnabled(true);
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        this.f39040b.setWebViewClient(new b());
        this.f39040b.setScrollBarStyle(0);
        this.f39040b.loadUrl(this.f39043e);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        d.p.a.d.f.f.c.c("lp_app_privacy_click_close", this.f39042d);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.p.a.d.c.ttdownloader_activity_app_privacy_policy);
        a();
        b();
    }

    public static void a(Activity activity, long j) {
        Intent intent = new Intent(activity, AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private void a() {
        this.f39041c = getIntent().getLongExtra("app_info_id", 0L);
        c.C1863c a2 = c.a().a(this.f39041c);
        this.f39042d = a2.f67662b;
        String str = a2.f67668h;
        this.f39043e = str;
        if (TextUtils.isEmpty(str)) {
            this.f39043e = n.s().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
        }
    }
}
