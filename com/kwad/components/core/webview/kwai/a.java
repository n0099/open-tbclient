package com.kwad.components.core.webview.kwai;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.d;
/* loaded from: classes9.dex */
public class a extends WebViewClient {
    public boolean KP = true;
    public String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z) {
        this.KP = z;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.KP && d.si()) {
            String uri = webResourceRequest.getUrl().toString();
            com.kwad.sdk.core.e.b.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + uri);
            WebResourceResponse m = com.kwad.components.a.a.qo().m(uri, this.mUniqueId);
            return m == null ? super.shouldInterceptRequest(webView, webResourceRequest) : m;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.KP && d.si()) {
            com.kwad.sdk.core.e.b.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
            WebResourceResponse m = com.kwad.components.a.a.qo().m(str, this.mUniqueId);
            return m == null ? super.shouldInterceptRequest(webView, str) : m;
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
