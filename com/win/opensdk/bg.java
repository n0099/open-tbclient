package com.win.opensdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.win.opensdk.bridge.JsBridge;
import com.win.opensdk.bridge.JsInvokeJavaScope;
import com.win.opensdk.bridge.core.JsBridgeWebChromeClient;
import com.win.opensdk.core.Info;
import org.apache.http.HttpHost;
/* loaded from: classes14.dex */
public class bg implements fe {
    public WebView c;
    public boolean d;
    public String e;
    public m qlb;
    public g qlc;

    public bg(Context context) {
        this.c = new WebView(context);
        WebView webView = this.c;
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
        this.c.getSettings().setJavaScriptEnabled(true);
        JsBridge.eJf().E(JsInvokeJavaScope.class).eJi();
        this.c.setWebChromeClient(new JsBridgeWebChromeClient());
        this.c.setWebViewClient(new ba(this));
    }

    @Override // com.win.opensdk.fe
    public void a() {
        WebView webView = this.c;
        if (webView != null) {
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.c);
            }
            this.c.removeAllViews();
            this.c.stopLoading();
            this.c.setWebChromeClient(null);
            this.c.setWebViewClient(null);
            this.c.destroy();
        }
        if (this.qlc != null) {
            this.qlc = null;
        }
    }

    @Override // com.win.opensdk.fe
    public void a(g gVar) {
        this.qlc = gVar;
    }

    @Override // com.win.opensdk.fe
    public void a(String str, Info info) {
        if ((!TextUtils.isEmpty(str) && (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str.startsWith("https"))) || str.startsWith("file:///")) {
            this.c.loadUrl(str);
        } else {
            this.c.loadDataWithBaseURL("http://abcd/", str, "text/html", "UTF-8", null);
        }
        m mVar = this.qlb;
        if (mVar != null) {
            mVar.a();
        }
        this.c.setOnTouchListener(new bj(info, new at(this)));
    }

    @Override // com.win.opensdk.fe
    public View b() {
        return this.c;
    }
}
