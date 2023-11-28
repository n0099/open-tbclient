package com.kwad.sdk.core.webview.a;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.d;
/* loaded from: classes10.dex */
public class a extends WebViewClient {
    public boolean aCU = true;
    public String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z) {
        this.aCU = z;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.aCU && d.AZ()) {
            String uri = webResourceRequest.getUrl().toString();
            com.kwad.sdk.core.e.c.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + uri);
            WebResourceResponse Y = com.kwad.sdk.core.webview.b.a.FM().Y(uri, this.mUniqueId);
            if (Y == null) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            return Y;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.aCU && d.AZ()) {
            com.kwad.sdk.core.e.c.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
            WebResourceResponse Y = com.kwad.sdk.core.webview.b.a.FM().Y(str, this.mUniqueId);
            if (Y == null) {
                return super.shouldInterceptRequest(webView, str);
            }
            return Y;
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
