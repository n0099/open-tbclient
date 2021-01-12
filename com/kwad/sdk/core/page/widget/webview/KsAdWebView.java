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
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.t;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class KsAdWebView extends com.kwad.sdk.core.page.widget.webview.b {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f9370a;

    /* renamed from: b  reason: collision with root package name */
    protected c f9371b;
    private AdTemplate c;
    private boolean d;
    private d e;
    private b f;
    private o.a g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements DownloadListener {
        private a() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            AdDownloadProxy proxyForDownload = KsAdSDKImpl.get().getProxyForDownload();
            if (proxyForDownload == null || !KsAdWebView.this.d) {
                try {
                    KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return;
                } catch (Exception e) {
                    com.kwad.sdk.core.d.a.a(e);
                    return;
                }
            }
            DownloadParams downloadParams = new DownloadParams();
            downloadParams.mDownloadid = t.a(str);
            AdInfo j2 = com.kwad.sdk.core.response.b.c.j(KsAdWebView.this.c);
            downloadParams.mAppName = j2.adBaseInfo.appName;
            downloadParams.mPkgname = j2.adBaseInfo.appPackageName;
            downloadParams.mFileUrl = str;
            downloadParams.mAppIcon = j2.adBaseInfo.appIconUrl;
            downloadParams.mShortDesc = j2.adBaseInfo.adDescription;
            proxyForDownload.startDownload(KsAdWebView.this.getContext(), downloadParams.mDownloadid, downloadParams);
            Toast.makeText(KsAdWebView.this.getContext(), "开始下载", 0).show();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view, int i, int i2, int i3, int i4);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a();

        void a(int i, String str, String str2);

        void b();
    }

    public KsAdWebView(Context context) {
        super(context);
        this.d = true;
        g();
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = true;
        g();
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = true;
        g();
    }

    private void g() {
        WebSettings settings = getSettings();
        try {
            settings.setJavaScriptEnabled(true);
            settings.setUseWideViewPort(true);
        } catch (Exception e) {
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
                if (!KsAdWebView.this.f9370a) {
                    KsAdWebView.this.f9370a = true;
                    com.kwad.sdk.core.report.b.b(KsAdWebView.this.c, KsAdWebView.this.g);
                }
                if (KsAdWebView.this.e != null) {
                    KsAdWebView.this.e.b();
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (KsAdWebView.this.e != null) {
                    KsAdWebView.this.e.a();
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                com.kwad.sdk.core.d.a.a("KsAdWebView", "onReceivedError " + i);
                if (KsAdWebView.this.e != null) {
                    KsAdWebView.this.e.a(i, str, str2);
                }
                com.kwad.sdk.core.report.b.d(KsAdWebView.this.c, KsAdWebView.this.g);
            }

            @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                try {
                    if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str.startsWith("https")) {
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                    if (str.startsWith("tel:") || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                        KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    }
                    int a2 = com.kwad.sdk.core.download.b.d.a(KsAdWebView.this.getContext(), str);
                    if (a2 == 1) {
                        if (KsAdWebView.this.f != null) {
                            KsAdWebView.this.f.a();
                        }
                        com.kwad.sdk.core.report.b.a(KsAdWebView.this.c, 2);
                        return true;
                    }
                    if (KsAdWebView.this.f != null) {
                        KsAdWebView.this.f.b();
                    }
                    if (a2 == -1) {
                        com.kwad.sdk.core.report.b.b(KsAdWebView.this.c, 2);
                        return true;
                    }
                    return true;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    return true;
                }
            }
        });
        setWebChromeClient(new com.kwad.sdk.core.page.widget.webview.a() { // from class: com.kwad.sdk.core.page.widget.webview.KsAdWebView.2
            @Override // com.kwad.sdk.core.page.widget.webview.a, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        setDownloadListener(new a());
        settings.setUserAgentString(settings.getUserAgentString() + h());
    }

    private String h() {
        return "KSADSDK_V3.3.9_" + getContext().getPackageName() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + ah.l(getContext());
    }

    public void d() {
        com.kwad.sdk.core.report.b.a(this.c, this.g);
    }

    public void e() {
        f();
        com.kwad.sdk.core.report.b.c(this.c, this.g);
    }

    public void f() {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeAllViews();
        }
        destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f9371b != null) {
            this.f9371b.a(this, i, i2, i3, i4);
        }
    }

    public void setClientParams(o.a aVar) {
        this.g = aVar;
    }

    public void setDeepLinkListener(b bVar) {
        this.f = bVar;
    }

    public void setHttpErrorListener(d dVar) {
        this.e = dVar;
    }

    public void setInsideDownloadEnable(boolean z) {
        this.d = z;
    }

    public void setOnWebViewScrollChangeListener(c cVar) {
        this.f9371b = cVar;
    }

    public void setTemplateData(@Nullable AdTemplate adTemplate) {
        this.c = adTemplate;
    }
}
