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
    private boolean qjq;
    public WebView qkQ;
    public bq qka;
    public bo qkb;

    public bw(Context context) {
        this.qkQ = new WebView(context);
        WebView webView = this.qkQ;
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
        this.qkQ.getSettings().setJavaScriptEnabled(true);
        JsBridge.eJn().E(JsInvokeJavaScope.class).eJq();
        this.qkQ.setWebChromeClient(new JsBridgeWebChromeClient());
        this.qkQ.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.bw.2

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
                if (Build.VERSION.SDK_INT >= 24 || !abQ(str)) {
                    return super.shouldOverrideUrlLoading(webView2, str);
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                if (Build.VERSION.SDK_INT < 24 || !abQ(webResourceRequest.getUrl().toString())) {
                    return super.shouldOverrideUrlLoading(webView2, webResourceRequest);
                }
                return true;
            }

            private boolean abQ(String str) {
                if (bw.this.qjq) {
                    bw.this.qjq = false;
                    if (bw.this.qkb != null) {
                        return bw.this.qkb.hC(str, bw.this.f30case);
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
                    if (bw.this.qka != null) {
                        bw.this.qka.eIY();
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
        if (be.abQ(str) || str.startsWith("file:///")) {
            this.qkQ.loadUrl(str);
        } else {
            this.qkQ.loadDataWithBaseURL("http://abcd/", str, "text/html", "UTF-8", null);
        }
        if (this.qka != null) {
            this.qka.eIX();
        }
        this.qkQ.setOnTouchListener(new bx(info, new bx.a() { // from class: com.win.opensdk.bw.1
            @Override // com.win.opensdk.bx.a
            public final boolean abQ(String str2) {
                bw.this.qjq = true;
                bw.this.f30case = str2;
                return false;
            }

            @Override // com.win.opensdk.bx.a
            public final void abR(String str2) {
                if (bw.this.qkb != null) {
                    bw.this.qkb.abR(str2);
                }
            }
        }));
    }

    @Override // com.win.opensdk.bn
    public final void eIX() {
        if (this.qkQ != null) {
            ViewGroup viewGroup = (ViewGroup) this.qkQ.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.qkQ);
            }
            this.qkQ.removeAllViews();
            this.qkQ.stopLoading();
            this.qkQ.setWebChromeClient(null);
            this.qkQ.setWebViewClient(null);
            this.qkQ.destroy();
        }
    }

    @Override // com.win.opensdk.bn
    public final void a(bo boVar) {
        this.qkb = boVar;
    }

    @Override // com.win.opensdk.bn
    public final /* bridge */ /* synthetic */ View eJa() {
        return this.qkQ;
    }
}
