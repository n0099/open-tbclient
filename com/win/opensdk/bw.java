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
    private boolean pYL;
    public bq pZv;
    public bo pZw;
    public WebView qal;

    public bw(Context context) {
        this.qal = new WebView(context);
        WebView webView = this.qal;
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
        this.qal.getSettings().setJavaScriptEnabled(true);
        JsBridge.eGP().E(JsInvokeJavaScope.class).eGS();
        this.qal.setWebChromeClient(new JsBridgeWebChromeClient());
        this.qal.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.bw.2

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
                if (Build.VERSION.SDK_INT >= 24 || !aaC(str)) {
                    return super.shouldOverrideUrlLoading(webView2, str);
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                if (Build.VERSION.SDK_INT < 24 || !aaC(webResourceRequest.getUrl().toString())) {
                    return super.shouldOverrideUrlLoading(webView2, webResourceRequest);
                }
                return true;
            }

            private boolean aaC(String str) {
                if (bw.this.pYL) {
                    bw.this.pYL = false;
                    if (bw.this.pZw != null) {
                        return bw.this.pZw.ht(str, bw.this.f30case);
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
                    if (bw.this.pZv != null) {
                        bw.this.pZv.eGA();
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
        if (be.aaC(str) || str.startsWith("file:///")) {
            this.qal.loadUrl(str);
        } else {
            this.qal.loadDataWithBaseURL("http://abcd/", str, "text/html", "UTF-8", null);
        }
        if (this.pZv != null) {
            this.pZv.eGz();
        }
        this.qal.setOnTouchListener(new bx(info, new bx.a() { // from class: com.win.opensdk.bw.1
            @Override // com.win.opensdk.bx.a
            public final boolean aaC(String str2) {
                bw.this.pYL = true;
                bw.this.f30case = str2;
                return false;
            }

            @Override // com.win.opensdk.bx.a
            public final void aaD(String str2) {
                if (bw.this.pZw != null) {
                    bw.this.pZw.aaD(str2);
                }
            }
        }));
    }

    @Override // com.win.opensdk.bn
    public final void eGz() {
        if (this.qal != null) {
            ViewGroup viewGroup = (ViewGroup) this.qal.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.qal);
            }
            this.qal.removeAllViews();
            this.qal.stopLoading();
            this.qal.setWebChromeClient(null);
            this.qal.setWebViewClient(null);
            this.qal.destroy();
        }
    }

    @Override // com.win.opensdk.bn
    public final void a(bo boVar) {
        this.pZw = boVar;
    }

    @Override // com.win.opensdk.bn
    public final /* bridge */ /* synthetic */ View eGC() {
        return this.qal;
    }
}
