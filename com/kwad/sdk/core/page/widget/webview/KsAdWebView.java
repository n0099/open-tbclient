package com.kwad.sdk.core.page.widget.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.be;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class KsAdWebView extends com.kwad.sdk.core.page.widget.webview.a {
    public boolean a;
    public c b;
    public AdTemplate c;
    public boolean d;
    public d e;
    public b f;
    public p.a g;
    public long h;
    public boolean i;
    public boolean j;

    /* loaded from: classes5.dex */
    public class a implements DownloadListener {
        public a() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (KsAdWebView.this.c != null && KsAdWebView.this.d) {
                com.kwad.sdk.core.response.a.d.j(KsAdWebView.this.c).adConversionInfo.appDownloadUrl = str;
                KsAdWebView.this.c.isWebViewDownload = true;
                com.kwad.sdk.core.download.a.a.a(new a.C0296a(KsAdWebView.this.getContext2()).a(KsAdWebView.this.c).c(true));
                return;
            }
            try {
                KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view2, int i, int i2, int i3, int i4);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();

        void a(int i, String str, String str2);

        void b();
    }

    public KsAdWebView(Context context) {
        super(context);
        this.d = true;
        this.i = true;
        this.j = true;
        a(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = true;
        this.i = true;
        this.j = true;
        a(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = true;
        this.i = true;
        this.j = true;
        a(context);
    }

    private void a(Context context) {
        com.kwad.sdk.core.d.a.e("KsAdWebView", "init");
        setAccessibilityStateDisable(context);
        WebSettings a2 = be.a(this);
        a2.setUseWideViewPort(true);
        a2.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        setWebViewClient(new WebViewClient() { // from class: com.kwad.sdk.core.page.widget.webview.KsAdWebView.1
            private WebResourceResponse a(String str) {
                try {
                    return com.kwad.sdk.c.c.a().a(str);
                } catch (Exception e) {
                    com.kwad.sdk.core.d.a.e(V8ExceptionInfo.V8_EXCEPTION_ERROR, e.toString());
                    e.printStackTrace();
                    return null;
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                KsAdWebView ksAdWebView = KsAdWebView.this;
                if (!ksAdWebView.a) {
                    ksAdWebView.a = true;
                    if (ksAdWebView.h > 0) {
                        if (KsAdWebView.this.g == null) {
                            KsAdWebView.this.g = new p.a();
                        }
                        KsAdWebView.this.g.t = System.currentTimeMillis() - KsAdWebView.this.h;
                        KsAdWebView.this.h = -1L;
                    }
                    com.kwad.sdk.core.report.a.b(KsAdWebView.this.c, KsAdWebView.this.g);
                }
                if (KsAdWebView.this.e != null) {
                    KsAdWebView.this.e.b();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (KsAdWebView.this.e != null) {
                    KsAdWebView.this.e.a();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                com.kwad.sdk.core.d.a.a("KsAdWebView", "onReceivedError " + i);
                if (KsAdWebView.this.e != null) {
                    KsAdWebView.this.e.a(i, str, str2);
                }
                com.kwad.sdk.core.report.a.d(KsAdWebView.this.c, KsAdWebView.this.g);
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                if (KsAdWebView.this.j && com.kwad.sdk.core.config.b.J()) {
                    WebResourceResponse a3 = a(webResourceRequest.getUrl().toString());
                    return a3 == null ? super.shouldInterceptRequest(webView, webResourceRequest) : a3;
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                if (KsAdWebView.this.j && com.kwad.sdk.core.config.b.J()) {
                    WebResourceResponse a3 = a(str);
                    return a3 == null ? super.shouldInterceptRequest(webView, str) : a3;
                }
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                com.kwad.sdk.core.d.a.e("KsAdWebView", "shouldOverrideUrlLoading url=" + str);
                try {
                } catch (Exception e) {
                    com.kwad.sdk.core.d.a.a(e);
                }
                if (!str.startsWith("http") && !str.startsWith("https")) {
                    if (!str.startsWith("tel:") && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                        if (KsAdWebView.this.i) {
                            int a3 = com.kwad.sdk.core.download.a.d.a(KsAdWebView.this.getContext(), str);
                            if (a3 == 1) {
                                if (KsAdWebView.this.f != null) {
                                    KsAdWebView.this.f.a();
                                }
                                com.kwad.sdk.core.report.a.a(KsAdWebView.this.c, 2);
                                return true;
                            }
                            if (KsAdWebView.this.f != null) {
                                KsAdWebView.this.f.b();
                            }
                            if (a3 == -1) {
                                com.kwad.sdk.core.report.a.b(KsAdWebView.this.c, 2);
                            }
                        } else if (KsAdWebView.this.f != null) {
                            KsAdWebView.this.f.b();
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
        return "KSADSDK_V3.3.17.4_" + getContext().getPackageName() + "_" + av.w(getContext());
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

    public void b() {
        com.kwad.sdk.core.report.a.a(this.c, this.g);
        this.h = System.currentTimeMillis();
    }

    public void c() {
        a();
        com.kwad.sdk.core.report.a.c(this.c, this.g);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(this, i, i2, i3, i4);
        }
    }

    public void setClientParams(p.a aVar) {
        this.g = aVar;
    }

    public void setDeepLinkEnabled(boolean z) {
        this.i = z;
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

    public void setNeedHybridLoad(boolean z) {
        this.j = z;
    }

    public void setOnWebViewScrollChangeListener(c cVar) {
        this.b = cVar;
    }

    public void setTemplateData(@Nullable AdTemplate adTemplate) {
        this.c = adTemplate;
    }
}
