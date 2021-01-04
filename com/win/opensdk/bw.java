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
/* loaded from: classes4.dex */
public class bw implements bn {
    public static final String java = bw.class.getSimpleName();

    /* renamed from: case  reason: not valid java name */
    private String f30case;
    private boolean qbE;
    public bq qco;
    public bo qcp;
    public WebView qde;

    public bw(Context context) {
        this.qde = new WebView(context);
        WebView webView = this.qde;
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
        this.qde.getSettings().setJavaScriptEnabled(true);
        JsBridge.eKb().E(JsInvokeJavaScope.class).eKe();
        this.qde.setWebChromeClient(new JsBridgeWebChromeClient());
        this.qde.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.bw.2

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
                if (Build.VERSION.SDK_INT >= 24 || !abJ(str)) {
                    return super.shouldOverrideUrlLoading(webView2, str);
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                if (Build.VERSION.SDK_INT < 24 || !abJ(webResourceRequest.getUrl().toString())) {
                    return super.shouldOverrideUrlLoading(webView2, webResourceRequest);
                }
                return true;
            }

            private boolean abJ(String str) {
                if (bw.this.qbE) {
                    bw.this.qbE = false;
                    if (bw.this.qcp != null) {
                        return bw.this.qcp.ht(str, bw.this.f30case);
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
                    if (bw.this.qco != null) {
                        bw.this.qco.eJM();
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
        if (be.abJ(str) || str.startsWith("file:///")) {
            this.qde.loadUrl(str);
        } else {
            this.qde.loadDataWithBaseURL("http://abcd/", str, "text/html", "UTF-8", null);
        }
        if (this.qco != null) {
            this.qco.eJL();
        }
        this.qde.setOnTouchListener(new bx(info, new bx.a() { // from class: com.win.opensdk.bw.1
            @Override // com.win.opensdk.bx.a
            public final boolean abJ(String str2) {
                bw.this.qbE = true;
                bw.this.f30case = str2;
                return false;
            }

            @Override // com.win.opensdk.bx.a
            public final void abK(String str2) {
                if (bw.this.qcp != null) {
                    bw.this.qcp.abK(str2);
                }
            }
        }));
    }

    @Override // com.win.opensdk.bn
    public final void eJL() {
        if (this.qde != null) {
            ViewGroup viewGroup = (ViewGroup) this.qde.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.qde);
            }
            this.qde.removeAllViews();
            this.qde.stopLoading();
            this.qde.setWebChromeClient(null);
            this.qde.setWebViewClient(null);
            this.qde.destroy();
        }
    }

    @Override // com.win.opensdk.bn
    public final void a(bo boVar) {
        this.qcp = boVar;
    }

    @Override // com.win.opensdk.bn
    public final /* bridge */ /* synthetic */ View eJO() {
        return this.qde;
    }
}
