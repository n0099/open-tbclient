package com.kwad.sdk.core.page.widget.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.t;
/* loaded from: classes6.dex */
public class KsAdWebView extends com.kwad.sdk.core.page.widget.webview.b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f33963a;

    /* renamed from: b  reason: collision with root package name */
    public c f33964b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f33965c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33966d;

    /* renamed from: e  reason: collision with root package name */
    public d f33967e;

    /* renamed from: f  reason: collision with root package name */
    public b f33968f;

    /* renamed from: g  reason: collision with root package name */
    public o.a f33969g;

    /* loaded from: classes6.dex */
    public class a implements DownloadListener {
        public a() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            AdDownloadProxy proxyForDownload = KsAdSDKImpl.get().getProxyForDownload();
            if (proxyForDownload == null || !KsAdWebView.this.f33966d) {
                try {
                    KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    return;
                }
            }
            DownloadParams downloadParams = new DownloadParams();
            downloadParams.mDownloadid = t.a(str);
            AdInfo.AdBaseInfo adBaseInfo = com.kwad.sdk.core.response.b.c.j(KsAdWebView.this.f33965c).adBaseInfo;
            downloadParams.mAppName = adBaseInfo.appName;
            downloadParams.mPkgname = adBaseInfo.appPackageName;
            downloadParams.mFileUrl = str;
            downloadParams.mAppIcon = adBaseInfo.appIconUrl;
            downloadParams.mShortDesc = adBaseInfo.adDescription;
            proxyForDownload.startDownload(KsAdWebView.this.getContext(), downloadParams.mDownloadid, downloadParams);
            Toast.makeText(KsAdWebView.this.getContext(), "开始下载", 0).show();
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(View view, int i, int i2, int i3, int i4);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a();

        void a(int i, String str, String str2);

        void b();
    }

    public KsAdWebView(Context context) {
        super(context);
        this.f33966d = true;
        g();
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33966d = true;
        g();
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33966d = true;
        g();
    }

    private void g() {
        WebSettings settings = getSettings();
        try {
            settings.setJavaScriptEnabled(true);
            settings.setUseWideViewPort(true);
        } catch (Exception unused) {
            a();
            settings.setJavaScriptEnabled(true);
        }
        settings.setSavePassword(false);
        settings.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
        setWebViewClient(new com.kwad.sdk.core.page.widget.webview.c() { // from class: com.kwad.sdk.core.page.widget.webview.KsAdWebView.1
            @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                KsAdWebView ksAdWebView = KsAdWebView.this;
                if (!ksAdWebView.f33963a) {
                    ksAdWebView.f33963a = true;
                    com.kwad.sdk.core.report.b.b(ksAdWebView.f33965c, KsAdWebView.this.f33969g);
                }
                if (KsAdWebView.this.f33967e != null) {
                    KsAdWebView.this.f33967e.b();
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (KsAdWebView.this.f33967e != null) {
                    KsAdWebView.this.f33967e.a();
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                com.kwad.sdk.core.d.a.a("KsAdWebView", "onReceivedError " + i);
                if (KsAdWebView.this.f33967e != null) {
                    KsAdWebView.this.f33967e.a(i, str, str2);
                }
                com.kwad.sdk.core.report.b.d(KsAdWebView.this.f33965c, KsAdWebView.this.f33969g);
            }

            @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                try {
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                if (!str.startsWith("http") && !str.startsWith("https")) {
                    if (!str.startsWith("tel:") && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                        int a2 = com.kwad.sdk.core.download.b.d.a(KsAdWebView.this.getContext(), str);
                        if (a2 == 1) {
                            if (KsAdWebView.this.f33968f != null) {
                                KsAdWebView.this.f33968f.a();
                            }
                            com.kwad.sdk.core.report.b.a(KsAdWebView.this.f33965c, 2);
                            return true;
                        }
                        if (KsAdWebView.this.f33968f != null) {
                            KsAdWebView.this.f33968f.b();
                        }
                        if (a2 == -1) {
                            com.kwad.sdk.core.report.b.b(KsAdWebView.this.f33965c, 2);
                        }
                        return true;
                    }
                    KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        setWebChromeClient(new com.kwad.sdk.core.page.widget.webview.a() { // from class: com.kwad.sdk.core.page.widget.webview.KsAdWebView.2
            @Override // com.kwad.sdk.core.page.widget.webview.a, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        setDownloadListener(new a());
        String userAgentString = settings.getUserAgentString();
        settings.setUserAgentString(userAgentString + h());
    }

    private String h() {
        return "KSADSDK_V3.3.9_" + getContext().getPackageName() + "_" + ah.l(getContext());
    }

    public void d() {
        com.kwad.sdk.core.report.b.a(this.f33965c, this.f33969g);
    }

    public void e() {
        f();
        com.kwad.sdk.core.report.b.c(this.f33965c, this.f33969g);
    }

    public void f() {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeAllViews();
        }
        destroy();
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        c cVar = this.f33964b;
        if (cVar != null) {
            cVar.a(this, i, i2, i3, i4);
        }
    }

    public void setClientParams(o.a aVar) {
        this.f33969g = aVar;
    }

    public void setDeepLinkListener(b bVar) {
        this.f33968f = bVar;
    }

    public void setHttpErrorListener(d dVar) {
        this.f33967e = dVar;
    }

    public void setInsideDownloadEnable(boolean z) {
        this.f33966d = z;
    }

    public void setOnWebViewScrollChangeListener(c cVar) {
        this.f33964b = cVar;
    }

    public void setTemplateData(@Nullable AdTemplate adTemplate) {
        this.f33965c = adTemplate;
    }
}
