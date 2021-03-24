package com.win.opensdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.win.opensdk.webviewbase.AdvancedWebView;
/* loaded from: classes7.dex */
public class v2 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40059a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdvancedWebView f40060b;

    public v2(AdvancedWebView advancedWebView, Context context) {
        this.f40060b = advancedWebView;
        this.f40059a = context;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        WebViewClient webViewClient = this.f40060b.j;
        if (webViewClient != null) {
            webViewClient.doUpdateVisitedHistory(webView, str, z);
        } else {
            super.doUpdateVisitedHistory(webView, str, z);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.f40060b.j;
        if (webViewClient != null) {
            webViewClient.onFormResubmission(webView, message, message2);
        } else {
            super.onFormResubmission(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        WebViewClient webViewClient = this.f40060b.j;
        if (webViewClient != null) {
            webViewClient.onLoadResource(webView, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        y2 y2Var;
        if (!this.f40060b.a() && (y2Var = this.f40060b.f40091c) != null) {
            y2Var.a(str);
        }
        WebViewClient webViewClient = this.f40060b.j;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        y2 y2Var;
        if (!this.f40060b.a() && (y2Var = this.f40060b.f40091c) != null) {
            y2Var.a(str, bitmap);
        }
        WebViewClient webViewClient = this.f40060b.j;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        if (Build.VERSION.SDK_INT >= 21) {
            WebViewClient webViewClient = this.f40060b.j;
            if (webViewClient != null) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f40060b.e();
        y2 y2Var = this.f40060b.f40091c;
        if (y2Var != null) {
            y2Var.a(i, str, str2);
        }
        WebViewClient webViewClient = this.f40060b.j;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        WebViewClient webViewClient = this.f40060b.j;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT >= 12) {
            WebViewClient webViewClient = this.f40060b.j;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewClient webViewClient = this.f40060b.j;
        if (webViewClient != null) {
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f2, float f3) {
        WebViewClient webViewClient = this.f40060b.j;
        if (webViewClient != null) {
            webViewClient.onScaleChanged(webView, f2, f3);
        } else {
            super.onScaleChanged(webView, f2, f3);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.f40060b.j;
        if (webViewClient != null) {
            webViewClient.onUnhandledKeyEvent(webView, keyEvent);
        } else {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT >= 21) {
            WebViewClient webViewClient = this.f40060b.j;
            return webViewClient != null ? webViewClient.shouldInterceptRequest(webView, webResourceRequest) : super.shouldInterceptRequest(webView, webResourceRequest);
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (Build.VERSION.SDK_INT >= 11) {
            WebViewClient webViewClient = this.f40060b.j;
            return webViewClient != null ? webViewClient.shouldInterceptRequest(webView, str) : super.shouldInterceptRequest(webView, str);
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.f40060b.j;
        return webViewClient != null ? webViewClient.shouldOverrideKeyEvent(webView, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.f40060b.a(str)) {
            y2 y2Var = this.f40060b.f40091c;
            if (y2Var != null) {
                y2Var.b(str);
            }
            return true;
        }
        WebViewClient webViewClient = this.f40060b.j;
        if (webViewClient == null || !webViewClient.shouldOverrideUrlLoading(webView, str)) {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (!((TextUtils.isEmpty(scheme) || scheme.equals("http") || scheme.equals("https")) ? false : true)) {
                webView.loadUrl(str);
                return true;
            }
            try {
                a2.b(this.f40059a, parse);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        }
        return true;
    }
}
