package com.kwad.sdk.core.page.widget.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.r;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class KsAdWebView extends KSApiWebView {

    /* renamed from: a  reason: collision with root package name */
    public boolean f33336a;

    /* renamed from: b  reason: collision with root package name */
    public c f33337b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f33338c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33339d;

    /* renamed from: e  reason: collision with root package name */
    public d f33340e;

    /* renamed from: f  reason: collision with root package name */
    public b f33341f;

    /* renamed from: g  reason: collision with root package name */
    public o.a f33342g;

    /* renamed from: h  reason: collision with root package name */
    public long f33343h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33344i;

    /* loaded from: classes6.dex */
    public class a implements DownloadListener {
        public a() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            AdDownloadProxy proxyForDownload = KsAdSDKImpl.get().getProxyForDownload();
            if (proxyForDownload == null || !KsAdWebView.this.f33339d) {
                try {
                    KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    return;
                }
            }
            DownloadParams downloadParams = new DownloadParams();
            downloadParams.mDownloadid = r.a(str);
            AdInfo.AdBaseInfo adBaseInfo = com.kwad.sdk.core.response.b.c.g(KsAdWebView.this.f33338c).adBaseInfo;
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
        void a(View view, int i2, int i3, int i4, int i5);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a();

        void a(int i2, String str, String str2);

        void b();
    }

    public KsAdWebView(Context context) {
        super(context);
        this.f33339d = true;
        this.f33344i = true;
        a(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33339d = true;
        this.f33344i = true;
        a(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33339d = true;
        this.f33344i = true;
        a(context);
    }

    private void a(Context context) {
        setAccessibilityStateDisable(context);
        WebSettings a2 = aq.a(this);
        a2.setUseWideViewPort(true);
        a2.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        setWebViewClient(new WebViewClient() { // from class: com.kwad.sdk.core.page.widget.webview.KsAdWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                KsAdWebView ksAdWebView = KsAdWebView.this;
                if (!ksAdWebView.f33336a) {
                    ksAdWebView.f33336a = true;
                    if (ksAdWebView.f33343h > 0) {
                        if (KsAdWebView.this.f33342g == null) {
                            KsAdWebView.this.f33342g = new o.a();
                        }
                        KsAdWebView.this.f33342g.q = System.currentTimeMillis() - KsAdWebView.this.f33343h;
                        KsAdWebView.this.f33343h = -1L;
                    }
                    com.kwad.sdk.core.report.b.b(KsAdWebView.this.f33338c, KsAdWebView.this.f33342g);
                }
                if (KsAdWebView.this.f33340e != null) {
                    KsAdWebView.this.f33340e.b();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (KsAdWebView.this.f33340e != null) {
                    KsAdWebView.this.f33340e.a();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
                com.kwad.sdk.core.d.a.a("KsAdWebView", "onReceivedError " + i2);
                if (KsAdWebView.this.f33340e != null) {
                    KsAdWebView.this.f33340e.a(i2, str, str2);
                }
                com.kwad.sdk.core.report.b.d(KsAdWebView.this.f33338c, KsAdWebView.this.f33342g);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                try {
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                if (!str.startsWith("http") && !str.startsWith("https")) {
                    if (!str.startsWith("tel:") && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                        if (KsAdWebView.this.f33344i) {
                            int a3 = com.kwad.sdk.core.download.b.d.a(KsAdWebView.this.getContext(), str);
                            if (a3 == 1) {
                                if (KsAdWebView.this.f33341f != null) {
                                    KsAdWebView.this.f33341f.a();
                                }
                                com.kwad.sdk.core.report.b.a(KsAdWebView.this.f33338c, 2);
                                return true;
                            }
                            if (KsAdWebView.this.f33341f != null) {
                                KsAdWebView.this.f33341f.b();
                            }
                            if (a3 == -1) {
                                com.kwad.sdk.core.report.b.b(KsAdWebView.this.f33338c, 2);
                            }
                        } else if (KsAdWebView.this.f33341f != null) {
                            KsAdWebView.this.f33341f.b();
                        }
                        return true;
                    }
                    KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        setDownloadListener(new a());
        String userAgentString = a2.getUserAgentString();
        a2.setUserAgentString(userAgentString + d());
    }

    private String d() {
        return "KSADSDK_V3.3.8.3_" + getContext().getPackageName() + "_" + ai.n(getContext());
    }

    public static void setAccessibilityStateDisable(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(accessibilityManager, 0);
            }
        } catch (Throwable unused) {
        }
    }

    public void a() {
        com.kwad.sdk.core.report.b.a(this.f33338c, this.f33342g);
        this.f33343h = System.currentTimeMillis();
    }

    public void b() {
        c();
        com.kwad.sdk.core.report.b.c(this.f33338c, this.f33342g);
    }

    public void c() {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeAllViews();
        }
        destroy();
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        c cVar = this.f33337b;
        if (cVar != null) {
            cVar.a(this, i2, i3, i4, i5);
        }
    }

    public void setClientParams(o.a aVar) {
        this.f33342g = aVar;
    }

    public void setDeepLinkEnabled(boolean z) {
        this.f33344i = z;
    }

    public void setDeepLinkListener(b bVar) {
        this.f33341f = bVar;
    }

    public void setHttpErrorListener(d dVar) {
        this.f33340e = dVar;
    }

    public void setInsideDownloadEnable(boolean z) {
        this.f33339d = z;
    }

    public void setOnWebViewScrollChangeListener(c cVar) {
        this.f33337b = cVar;
    }

    public void setTemplateData(@Nullable AdTemplate adTemplate) {
        this.f33338c = adTemplate;
    }
}
