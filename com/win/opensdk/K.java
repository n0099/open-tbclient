package com.win.opensdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.sapi2.SapiWebView;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.win.opensdk.bridge.JsBridge;
import com.win.opensdk.bridge.JsInvokeJavaScope;
import com.win.opensdk.bridge.core.JsBridgeWebChromeClient;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class K implements U1 {

    /* renamed from: a  reason: collision with root package name */
    public X1 f37675a;

    /* renamed from: b  reason: collision with root package name */
    public V1 f37676b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f37677c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37678d;

    /* renamed from: e  reason: collision with root package name */
    public String f37679e;

    public K(Context context) {
        WebView webView = new WebView(context);
        this.f37677c = webView;
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
        this.f37677c.getSettings().setJavaScriptEnabled(true);
        JsBridge.getInstance().clazz(JsInvokeJavaScope.class).inject();
        this.f37677c.setWebChromeClient(new JsBridgeWebChromeClient());
        this.f37677c.setWebViewClient(new J(this));
    }

    public void a(String str, Info info) {
        if ((!TextUtils.isEmpty(str) && (str.startsWith("http") || str.startsWith("https"))) || str.startsWith(ImageSource.FILE_SCHEME)) {
            this.f37677c.loadUrl(str);
        } else {
            this.f37677c.loadDataWithBaseURL("http://abcd/", str, SapiWebView.DATA_MIME_TYPE, "UTF-8", null);
        }
        X1 x1 = this.f37675a;
        if (x1 != null) {
            x1.a();
        }
        this.f37677c.setOnTouchListener(new L(info, new I(this)));
    }
}
