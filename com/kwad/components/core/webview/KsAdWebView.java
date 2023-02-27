package com.kwad.components.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.m.p;
import com.kwad.components.core.webview.kwai.c;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.q;
import java.util.UUID;
/* loaded from: classes8.dex */
public class KsAdWebView extends com.kwad.components.core.webview.b {
    public com.kwad.components.core.webview.kwai.c KJ;
    public long KK;
    public String KL;
    public long KM;
    public boolean KN;
    public c.a gX;
    public String mUniqueId;

    /* loaded from: classes8.dex */
    public class a implements DownloadListener {
        public a() {
        }

        public /* synthetic */ a(KsAdWebView ksAdWebView, byte b) {
            this();
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (KsAdWebView.this.gX == null || KsAdWebView.this.gX.getAdTemplate() == null || !KsAdWebView.this.gX.ps()) {
                try {
                    KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return;
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                    return;
                }
            }
            com.kwad.sdk.core.response.a.d.bQ(KsAdWebView.this.gX.getAdTemplate()).adConversionInfo.appDownloadUrl = str;
            KsAdWebView.this.gX.getAdTemplate().isWebViewDownload = true;
            c.a readyClientConfig = KsAdWebView.this.getReadyClientConfig();
            if (readyClientConfig != null) {
                readyClientConfig.R(KsAdWebView.this.gX.getAdTemplate());
            }
            com.kwad.components.core.c.a.a.a(new a.C0588a(KsAdWebView.this.getContext2()).L(KsAdWebView.this.gX.getAdTemplate()).al(true));
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void kU();

        void onSuccess();
    }

    /* loaded from: classes8.dex */
    public interface c {
        void nu();
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(int i, String str, String str2);

        void bv();

        void bw();
    }

    public KsAdWebView(Context context) {
        super(context);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        init(context);
    }

    private void aB(String str) {
        c.a aVar = this.gX;
        if (aVar == null || aVar.getAdTemplate() == null) {
            return;
        }
        boolean equals = TextUtils.equals(com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.bQ(this.gX.getAdTemplate())), str);
        this.KN = equals;
        if (equals) {
            this.gX.aC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a getReadyClientConfig() {
        com.kwad.components.core.webview.kwai.c cVar = this.KJ;
        if (cVar == null || cVar.getClientConfig() == null) {
            return null;
        }
        return this.KJ.getClientConfig();
    }

    private void init(Context context) {
        com.kwad.sdk.core.e.b.e("KsAdWebView", "init");
        setAccessibilityStateDisable(context);
        WebSettings b2 = p.b(this);
        b2.setUseWideViewPort(true);
        b2.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        this.mUniqueId = UUID.randomUUID().toString();
        com.kwad.components.core.webview.kwai.c cVar = new com.kwad.components.core.webview.kwai.c();
        this.KJ = cVar;
        cVar.aC(this.mUniqueId);
        setWebViewClient(this.KJ);
        setWebChromeClient(new com.kwad.components.core.webview.kwai.b());
        setDownloadListener(new a(this, (byte) 0));
        String userAgentString = b2.getUserAgentString();
        b2.setUserAgentString(userAgentString + po());
    }

    private String po() {
        return "KSADSDK_V3.3.26_" + getContext().getPackageName() + "_" + j.cb(getContext());
    }

    private void setAccessibilityStateDisable(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                q.a((Object) accessibilityManager, "setState", 0);
            }
        } catch (Throwable unused) {
        }
    }

    public c.a getClientConfig() {
        if (this.gX == null) {
            this.gX = new c.a(getContext());
        }
        return this.gX;
    }

    public long getLoadTime() {
        return this.KM;
    }

    public String getLoadUrl() {
        return this.KL;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        aB(str);
        com.kwad.components.a.b.b.aW(this.mUniqueId);
        this.KL = str;
        this.KM = System.currentTimeMillis();
        super.loadUrl(str);
    }

    public final void onActivityDestroy() {
        release();
        c.a aVar = this.gX;
        if (aVar == null || !aVar.pt()) {
            return;
        }
        u.b clientParams = this.gX.getClientParams();
        if (clientParams == null) {
            clientParams = new u.b();
        }
        clientParams.Es = System.currentTimeMillis() - this.KK;
        com.kwad.sdk.core.report.a.d(this.gX.getAdTemplate(), clientParams);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        c.a aVar = this.gX;
        if (aVar == null || aVar.getOnWebViewScrollChangeListener() == null) {
            return;
        }
        this.gX.getOnWebViewScrollChangeListener().nu();
    }

    public final void pp() {
        c.a aVar = this.gX;
        if (aVar != null && aVar.pt()) {
            com.kwad.sdk.core.report.a.b(this.gX.getAdTemplate(), this.gX.getClientParams());
        }
        if (this.KJ != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.KK = currentTimeMillis;
            this.KJ.r(currentTimeMillis);
        }
    }

    public void setClientConfig(c.a aVar) {
        this.KJ.setClientConfig(aVar);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (com.kwad.kwai.kwai.a.aw.booleanValue() && !(webChromeClient instanceof com.kwad.components.core.webview.kwai.b)) {
            throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (com.kwad.kwai.kwai.a.aw.booleanValue() && !(webViewClient instanceof com.kwad.components.core.webview.kwai.a)) {
            throw new IllegalArgumentException("Not supported set webViewClient, please check it");
        }
        super.setWebViewClient(webViewClient);
    }
}
