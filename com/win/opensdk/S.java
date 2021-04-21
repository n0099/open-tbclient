package com.win.opensdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.sapi2.SapiWebView;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.win.opensdk.bridge.JsBridge;
import com.win.opensdk.bridge.JsInvokeJavaScope;
import com.win.opensdk.bridge.core.JsBridgeWebChromeClient;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class S implements z2 {

    /* renamed from: a  reason: collision with root package name */
    public C2 f40170a;

    /* renamed from: b  reason: collision with root package name */
    public A2 f40171b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f40172c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40173d;

    /* renamed from: e  reason: collision with root package name */
    public String f40174e;

    public S(Context context) {
        WebView webView = new WebView(context);
        this.f40172c = webView;
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
        this.f40172c.getSettings().setJavaScriptEnabled(true);
        JsBridge.getInstance().clazz(JsInvokeJavaScope.class).inject();
        this.f40172c.setWebChromeClient(new JsBridgeWebChromeClient());
        this.f40172c.setWebViewClient(new Q(this));
    }

    @Override // com.win.opensdk.z2
    public void a() {
        WebView webView = this.f40172c;
        if (webView != null) {
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f40172c);
            }
            this.f40172c.removeAllViews();
            this.f40172c.stopLoading();
            this.f40172c.setWebChromeClient(null);
            this.f40172c.setWebViewClient(null);
            this.f40172c.destroy();
        }
        if (this.f40171b != null) {
            this.f40171b = null;
        }
    }

    @Override // com.win.opensdk.z2
    public void a(A2 a2) {
        this.f40171b = a2;
    }

    @Override // com.win.opensdk.z2
    public void a(String str, Info info) {
        if ((!TextUtils.isEmpty(str) && (str.startsWith("http") || str.startsWith("https"))) || str.startsWith(ImageSource.FILE_SCHEME)) {
            this.f40172c.loadUrl(str);
        } else {
            this.f40172c.loadDataWithBaseURL("http://abcd/", str, SapiWebView.K, "UTF-8", null);
        }
        C2 c2 = this.f40170a;
        if (c2 != null) {
            c2.a();
        }
        this.f40172c.setOnTouchListener(new T(info, new P(this)));
    }

    @Override // com.win.opensdk.z2
    public View b() {
        return this.f40172c;
    }
}
