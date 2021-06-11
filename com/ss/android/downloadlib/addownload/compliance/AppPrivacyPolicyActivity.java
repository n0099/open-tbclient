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
import d.o.a.d.f.c;
import d.o.a.d.f.n;
/* loaded from: classes7.dex */
public class AppPrivacyPolicyActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f39477a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f39478b;

    /* renamed from: c  reason: collision with root package name */
    public long f39479c;

    /* renamed from: d  reason: collision with root package name */
    public long f39480d;

    /* renamed from: e  reason: collision with root package name */
    public String f39481e;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.o.a.d.f.f.c.c("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.f39480d);
            AppPrivacyPolicyActivity.this.finish();
        }
    }

    /* loaded from: classes7.dex */
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
        this.f39477a = (ImageView) findViewById(d.o.a.d.b.iv_privacy_back);
        this.f39478b = (WebView) findViewById(d.o.a.d.b.privacy_webview);
        this.f39477a.setOnClickListener(new a());
        WebSettings settings = this.f39478b.getSettings();
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
        this.f39478b.setWebViewClient(new b());
        this.f39478b.setScrollBarStyle(0);
        this.f39478b.loadUrl(this.f39481e);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        d.o.a.d.f.f.c.c("lp_app_privacy_click_close", this.f39480d);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.o.a.d.c.ttdownloader_activity_app_privacy_policy);
        a();
        b();
    }

    public static void a(Activity activity, long j) {
        Intent intent = new Intent(activity, AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private void a() {
        this.f39479c = getIntent().getLongExtra("app_info_id", 0L);
        c.C1926c a2 = c.a().a(this.f39479c);
        this.f39480d = a2.f70523b;
        String str = a2.f70529h;
        this.f39481e = str;
        if (TextUtils.isEmpty(str)) {
            this.f39481e = n.s().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
        }
    }
}
