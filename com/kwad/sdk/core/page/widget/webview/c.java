package com.kwad.sdk.core.page.widget.webview;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes6.dex */
public class c extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        try {
            if (webView instanceof b) {
                ((b) webView).a(webView);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        super.doUpdateVisitedHistory(webView, str, z);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        try {
            if (webView instanceof b) {
                ((b) webView).a(webView);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        try {
            if (webView instanceof b) {
                ((b) webView).a(webView);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        try {
            if (webView instanceof b) {
                ((b) webView).a(webView);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        try {
            if (webView instanceof b) {
                ((b) webView).a(webView);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        super.onReceivedError(webView, i2, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (webView instanceof b) {
                ((b) webView).a(webView);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
