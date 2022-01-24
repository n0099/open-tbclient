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
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.j;
/* loaded from: classes4.dex */
public class AppPrivacyPolicyActivity extends Activity {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f59536b;

    /* renamed from: c  reason: collision with root package name */
    public long f59537c;

    /* renamed from: d  reason: collision with root package name */
    public long f59538d;

    /* renamed from: e  reason: collision with root package name */
    public String f59539e;

    private void b() {
        this.a = (ImageView) findViewById(R.id.iv_privacy_back);
        this.f59536b = (WebView) findViewById(R.id.privacy_webview);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.f59538d);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.f59536b.getSettings();
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
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.f59536b.setWebViewClient(new WebViewClient() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
            private boolean a(Uri uri) {
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
        });
        a(this.f59536b);
        this.f59536b.setScrollBarStyle(0);
        this.f59536b.loadUrl(this.f59539e);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e.a("lp_app_privacy_click_close", this.f59538d);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_privacy_policy);
        if (a()) {
            b();
        } else {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    public static void a(Activity activity, long j2) {
        Intent intent = new Intent(activity, AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j2);
        activity.startActivity(intent);
    }

    private boolean a() {
        this.f59537c = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.b.b a = c.a().a(this.f59537c);
        if (a == null) {
            return false;
        }
        this.f59538d = a.f59486b;
        String str = a.f59493i;
        this.f59539e = str;
        if (TextUtils.isEmpty(str)) {
            this.f59539e = j.i().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
            return true;
        }
        return true;
    }

    private void a(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }
}
