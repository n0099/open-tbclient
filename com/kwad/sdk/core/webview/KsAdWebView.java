package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.IntentConstants;
import com.kwad.sdk.core.webview.a.c;
import com.kwad.sdk.m.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.s;
/* loaded from: classes10.dex */
public class KsAdWebView extends com.kwad.sdk.core.webview.c {
    @NonNull
    public c.a HE;
    public com.kwad.sdk.core.webview.a.c aCN;
    public String aCO;
    public long aCP;
    @Nullable
    public com.kwad.sdk.core.webview.d aCQ;
    public String mUniqueId;

    /* loaded from: classes10.dex */
    public interface b {
        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes10.dex */
    public interface c {
        void pr();
    }

    /* loaded from: classes10.dex */
    public interface d {
        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i, String str, String str2);
    }

    /* loaded from: classes10.dex */
    public class a implements DownloadListener {
        public a() {
        }

        public /* synthetic */ a(KsAdWebView ksAdWebView, byte b) {
            this();
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            boolean o = bq.o(KsAdWebView.this, 100);
            com.kwad.sdk.core.e.c.d("KsAdWebView", "onDownloadStart: currentVisible " + o);
            if (!o || !KsAdWebView.this.HE.FL()) {
                return;
            }
            if (KsAdWebView.this.HE != null && KsAdWebView.this.HE.getAdTemplate() != null && KsAdWebView.this.HE.FJ()) {
                com.kwad.sdk.core.response.b.e.dP(KsAdWebView.this.HE.getAdTemplate()).adConversionInfo.appDownloadUrl = str;
                KsAdWebView.this.HE.getAdTemplate().isWebViewDownload = true;
                c.a readyClientConfig = KsAdWebView.this.getReadyClientConfig();
                if (readyClientConfig != null) {
                    readyClientConfig.eh(KsAdWebView.this.HE.getAdTemplate());
                }
                ((com.kwad.sdk.service.a.a) ServiceProvider.get(com.kwad.sdk.service.a.a.class)).g(l.wrapContextIfNeed(KsAdWebView.this.getContext()), KsAdWebView.this.HE.getAdTemplate());
                return;
            }
            try {
                KsAdWebView.this.getContext().startActivity(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str)));
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
    }

    public KsAdWebView(Context context) {
        super(context);
        init(context);
    }

    private void setAccessibilityStateDisable(Context context) {
        if (Build.VERSION.SDK_INT == 17 && context != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                    s.callMethod(accessibilityManager, "setState", 0);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        com.kwad.sdk.core.webview.b.c.b.eA(this.mUniqueId);
        this.aCO = str;
        this.aCP = System.currentTimeMillis();
        super.loadUrl(str);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.HE.an(System.currentTimeMillis());
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setClientConfig(c.a aVar) {
        this.aCN.setClientConfig(aVar);
        if (this.HE.FK()) {
            this.aCQ = new com.kwad.sdk.core.webview.d();
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (com.kwad.framework.a.a.mc.booleanValue() && !(webChromeClient instanceof com.kwad.sdk.core.webview.a.b)) {
            throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (com.kwad.framework.a.a.mc.booleanValue() && !(webViewClient instanceof com.kwad.sdk.core.webview.a.a)) {
            throw new IllegalArgumentException("Not supported set webViewClient, please check it");
        }
        super.setWebViewClient(webViewClient);
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

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        c.a aVar = this.HE;
        if (aVar != null && aVar.pq() != null) {
            this.HE.pq().pr();
        }
    }

    private String FF() {
        return "KSADSDK_V3.3.55_" + getContext().getPackageName() + "_" + k.bQ(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a getReadyClientConfig() {
        com.kwad.sdk.core.webview.a.c cVar = this.aCN;
        if (cVar != null && cVar.getClientConfig() != null) {
            return this.aCN.getClientConfig();
        }
        return null;
    }

    public c.a getClientConfig() {
        return this.HE;
    }

    public long getLoadTime() {
        return this.aCP;
    }

    public String getLoadUrl() {
        return this.aCO;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public final void onActivityCreate() {
        com.kwad.sdk.core.webview.d dVar = this.aCQ;
        if (dVar != null) {
            dVar.a(this.HE);
        }
    }

    public final void onActivityDestroy() {
        release();
        com.kwad.sdk.core.webview.d dVar = this.aCQ;
        if (dVar != null) {
            dVar.b(this.HE);
        }
    }

    private void init(Context context) {
        com.kwad.sdk.core.e.c.i("KsAdWebView", "init");
        setAccessibilityStateDisable(context);
        WebSettings a2 = bs.a(this);
        a2.setUseWideViewPort(true);
        a2.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        com.kwad.sdk.core.webview.a.c cVar = new com.kwad.sdk.core.webview.a.c() { // from class: com.kwad.sdk.core.webview.KsAdWebView.1
            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (KsAdWebView.this.aCQ != null) {
                    KsAdWebView.this.aCQ.c(KsAdWebView.this.HE);
                }
            }

            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (KsAdWebView.this.aCQ != null) {
                    com.kwad.sdk.core.webview.d unused = KsAdWebView.this.aCQ;
                    com.kwad.sdk.core.webview.d.d(KsAdWebView.this.HE);
                }
            }
        };
        this.aCN = cVar;
        cVar.K(this.mUniqueId);
        setWebViewClient(this.aCN);
        setWebChromeClient(new com.kwad.sdk.core.webview.a.b());
        setDownloadListener(new a(this, (byte) 0));
        String userAgentString = a2.getUserAgentString();
        a2.setUserAgentString(userAgentString + FF());
        this.HE = new c.a(getContext());
    }
}
