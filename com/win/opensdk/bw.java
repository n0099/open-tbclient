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
    private boolean pYM;
    public bq pZw;
    public bo pZx;
    public WebView qam;

    public bw(Context context) {
        this.qam = new WebView(context);
        WebView webView = this.qam;
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
        this.qam.getSettings().setJavaScriptEnabled(true);
        JsBridge.eGP().E(JsInvokeJavaScope.class).eGS();
        this.qam.setWebChromeClient(new JsBridgeWebChromeClient());
        this.qam.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.bw.2

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
                if (Build.VERSION.SDK_INT >= 24 || !aaD(str)) {
                    return super.shouldOverrideUrlLoading(webView2, str);
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                if (Build.VERSION.SDK_INT < 24 || !aaD(webResourceRequest.getUrl().toString())) {
                    return super.shouldOverrideUrlLoading(webView2, webResourceRequest);
                }
                return true;
            }

            private boolean aaD(String str) {
                if (bw.this.pYM) {
                    bw.this.pYM = false;
                    if (bw.this.pZx != null) {
                        return bw.this.pZx.ht(str, bw.this.f30case);
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
                    if (bw.this.pZw != null) {
                        bw.this.pZw.eGA();
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
        if (be.aaD(str) || str.startsWith("file:///")) {
            this.qam.loadUrl(str);
        } else {
            this.qam.loadDataWithBaseURL("http://abcd/", str, "text/html", "UTF-8", null);
        }
        if (this.pZw != null) {
            this.pZw.eGz();
        }
        this.qam.setOnTouchListener(new bx(info, new bx.a() { // from class: com.win.opensdk.bw.1
            @Override // com.win.opensdk.bx.a
            public final boolean aaD(String str2) {
                bw.this.pYM = true;
                bw.this.f30case = str2;
                return false;
            }

            @Override // com.win.opensdk.bx.a
            public final void aaE(String str2) {
                if (bw.this.pZx != null) {
                    bw.this.pZx.aaE(str2);
                }
            }
        }));
    }

    @Override // com.win.opensdk.bn
    public final void eGz() {
        if (this.qam != null) {
            ViewGroup viewGroup = (ViewGroup) this.qam.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.qam);
            }
            this.qam.removeAllViews();
            this.qam.stopLoading();
            this.qam.setWebChromeClient(null);
            this.qam.setWebViewClient(null);
            this.qam.destroy();
        }
    }

    @Override // com.win.opensdk.bn
    public final void a(bo boVar) {
        this.pZx = boVar;
    }

    @Override // com.win.opensdk.bn
    public final /* bridge */ /* synthetic */ View eGC() {
        return this.qam;
    }
}
