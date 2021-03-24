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
    public C2 f39785a;

    /* renamed from: b  reason: collision with root package name */
    public A2 f39786b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f39787c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39788d;

    /* renamed from: e  reason: collision with root package name */
    public String f39789e;

    public S(Context context) {
        WebView webView = new WebView(context);
        this.f39787c = webView;
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
        this.f39787c.getSettings().setJavaScriptEnabled(true);
        JsBridge.getInstance().clazz(JsInvokeJavaScope.class).inject();
        this.f39787c.setWebChromeClient(new JsBridgeWebChromeClient());
        this.f39787c.setWebViewClient(new Q(this));
    }

    @Override // com.win.opensdk.z2
    public void a() {
        WebView webView = this.f39787c;
        if (webView != null) {
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f39787c);
            }
            this.f39787c.removeAllViews();
            this.f39787c.stopLoading();
            this.f39787c.setWebChromeClient(null);
            this.f39787c.setWebViewClient(null);
            this.f39787c.destroy();
        }
        if (this.f39786b != null) {
            this.f39786b = null;
        }
    }

    @Override // com.win.opensdk.z2
    public void a(A2 a2) {
        this.f39786b = a2;
    }

    @Override // com.win.opensdk.z2
    public void a(String str, Info info) {
        if ((!TextUtils.isEmpty(str) && (str.startsWith("http") || str.startsWith("https"))) || str.startsWith(ImageSource.FILE_SCHEME)) {
            this.f39787c.loadUrl(str);
        } else {
            this.f39787c.loadDataWithBaseURL("http://abcd/", str, SapiWebView.K, "UTF-8", null);
        }
        C2 c2 = this.f39785a;
        if (c2 != null) {
            c2.a();
        }
        this.f39787c.setOnTouchListener(new T(info, new P(this)));
    }

    @Override // com.win.opensdk.z2
    public View b() {
        return this.f39787c;
    }
}
