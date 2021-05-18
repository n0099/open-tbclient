package com.win.opensdk;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class E1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f36887a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f36888b;

    /* renamed from: c  reason: collision with root package name */
    public Info f36889c;

    public E1(Context context) {
        this.f36887a = context;
        if (this.f36888b == null) {
            WebView webView = new WebView(this.f36887a);
            this.f36888b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f36888b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f36888b.removeJavascriptInterface("accessibility");
                this.f36888b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f36888b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f36888b.getSettings().setBlockNetworkImage(true);
            this.f36888b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f36888b.getSettings().setCacheMode(2);
            this.f36888b.getSettings().setAppCacheEnabled(true);
            this.f36888b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(1);
            }
            settings.setNeedInitialFocus(false);
            this.f36888b.clearCache(true);
            this.f36888b.clearHistory();
            this.f36888b.setWebChromeClient(new B1(this));
            this.f36888b.setWebViewClient(new C1(this));
        }
    }
}
