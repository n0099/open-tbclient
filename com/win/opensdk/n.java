package com.win.opensdk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.win.opensdk.d;
/* loaded from: classes4.dex */
public final class n extends WebViewClient {
    private boolean qbE;
    private y qcd;
    private h qch;

    public n(y yVar, h hVar) {
        this.qcd = yVar;
        this.qch = hVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (Build.VERSION.SDK_INT < 24) {
            if (TextUtils.isEmpty(str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (str.startsWith("javascript:")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if ("mraid".equals(Uri.parse(str).getScheme())) {
                if (this.qch != null) {
                    this.qch.abK(str);
                }
                return true;
            } else if (this.qch != null) {
                return this.qch.abJ(str);
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT >= 24) {
            Uri url = webResourceRequest.getUrl();
            String uri = url.toString();
            String scheme = url.getScheme();
            String host = url.getHost();
            webResourceRequest.getUrl().getQueryParameter("url");
            if (uri.startsWith("javascript")) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            if ("mraid".equals(scheme)) {
                if (this.qch != null) {
                    this.qch.abK(uri);
                }
                g.e(this.qcd, "javascript:window.mraidbridge.nativeCallComplete('" + host + "')");
                return true;
            } else if (this.qch != null) {
                return this.qch.abJ(uri);
            }
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                if (str.contains("mraid.js") && Build.VERSION.SDK_INT >= 12) {
                    return new WebResourceResponse("text/javascript", "utf-8", webView.getResources().openRawResource(d.C1247d.mraid));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    @RequiresApi(api = 21)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                if (webResourceRequest.getUrl().toString().contains("mraid.js") && Build.VERSION.SDK_INT >= 12) {
                    return new WebResourceResponse("text/javascript", "utf-8", webView.getResources().openRawResource(d.C1247d.mraid));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (!this.qbE) {
            if (this.qcd != null && this.qch != null) {
                this.qch.a(this.qcd);
            }
            if (!this.qch.java()) {
                this.qcd.getDispatcher().eJL();
            }
            this.qbE = true;
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }
}
