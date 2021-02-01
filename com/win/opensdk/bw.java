package com.win.opensdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.win.opensdk.bridge.JsBridge;
import com.win.opensdk.bridge.JsInvokeJavaScope;
import com.win.opensdk.bridge.core.JsBridgeWebChromeClient;
import com.win.opensdk.bx;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class bw implements bn {
    public static final String java = bw.class.getSimpleName();

    /* renamed from: case  reason: not valid java name */
    private String f30case;
    private boolean qiQ;
    public bq qjA;
    public bo qjB;
    public WebView qkq;

    public bw(Context context) {
        this.qkq = new WebView(context);
        WebView webView = this.qkq;
        webView.setScrollContainer(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(false);
        settings.setLoadWithOverviewMode(false);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            settings.setTextZoom(100);
        }
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.setAcceptCookie(true);
            if (Build.VERSION.SDK_INT >= 21) {
                cookieManager.setAcceptThirdPartyCookies(webView, true);
            }
        }
        this.qkq.getSettings().setJavaScriptEnabled(true);
        JsBridge.eJf().E(JsInvokeJavaScope.class).eJi();
        this.qkq.setWebChromeClient(new JsBridgeWebChromeClient());
        this.qkq.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.bw.2

            /* renamed from: case  reason: not valid java name */
            private String f31case;
            private String java;

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
                this.java = webView2.getUrl();
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                if (Build.VERSION.SDK_INT >= 24 || !abE(str)) {
                    return super.shouldOverrideUrlLoading(webView2, str);
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                if (Build.VERSION.SDK_INT < 24 || !abE(webResourceRequest.getUrl().toString())) {
                    return super.shouldOverrideUrlLoading(webView2, webResourceRequest);
                }
                return true;
            }

            private boolean abE(String str) {
                if (bw.this.qiQ) {
                    bw.this.qiQ = false;
                    if (bw.this.qjB != null) {
                        return bw.this.qjB.hA(str, bw.this.f30case);
                    }
                    return false;
                }
                return false;
            }

            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                if (TextUtils.isEmpty(this.f31case)) {
                    this.f31case = str;
                    if (bw.this.qjA != null) {
                        bw.this.qjA.eIQ();
                    }
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                if ((TextUtils.equals(webView2.getUrl(), "http://abcd/") || TextUtils.equals(webView2.getUrl(), this.java)) && Build.VERSION.SDK_INT >= 23) {
                    webResourceError.getDescription().toString();
                    webResourceError.getErrorCode();
                }
            }
        });
    }

    @Override // com.win.opensdk.bn
    public final void a(String str, Info info) {
        if (be.abE(str) || str.startsWith("file:///")) {
            this.qkq.loadUrl(str);
        } else {
            this.qkq.loadDataWithBaseURL("http://abcd/", str, "text/html", "UTF-8", null);
        }
        if (this.qjA != null) {
            this.qjA.eIP();
        }
        this.qkq.setOnTouchListener(new bx(info, new bx.a() { // from class: com.win.opensdk.bw.1
            @Override // com.win.opensdk.bx.a
            public final boolean abE(String str2) {
                bw.this.qiQ = true;
                bw.this.f30case = str2;
                return false;
            }

            @Override // com.win.opensdk.bx.a
            public final void abF(String str2) {
                if (bw.this.qjB != null) {
                    bw.this.qjB.abF(str2);
                }
            }
        }));
    }

    @Override // com.win.opensdk.bn
    public final void eIP() {
        if (this.qkq != null) {
            ViewGroup viewGroup = (ViewGroup) this.qkq.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.qkq);
            }
            this.qkq.removeAllViews();
            this.qkq.stopLoading();
            this.qkq.setWebChromeClient(null);
            this.qkq.setWebViewClient(null);
            this.qkq.destroy();
        }
    }

    @Override // com.win.opensdk.bn
    public final void a(bo boVar) {
        this.qjB = boVar;
    }

    @Override // com.win.opensdk.bn
    public final /* bridge */ /* synthetic */ View eIS() {
        return this.qkq;
    }
}
