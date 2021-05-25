package com.win.opensdk;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class E1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f36816a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f36817b;

    /* renamed from: c  reason: collision with root package name */
    public Info f36818c;

    public E1(Context context) {
        this.f36816a = context;
        if (this.f36817b == null) {
            WebView webView = new WebView(this.f36816a);
            this.f36817b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f36817b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f36817b.removeJavascriptInterface("accessibility");
                this.f36817b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f36817b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f36817b.getSettings().setBlockNetworkImage(true);
            this.f36817b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f36817b.getSettings().setCacheMode(2);
            this.f36817b.getSettings().setAppCacheEnabled(true);
            this.f36817b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(1);
            }
            settings.setNeedInitialFocus(false);
            this.f36817b.clearCache(true);
            this.f36817b.clearHistory();
            this.f36817b.setWebChromeClient(new B1(this));
            this.f36817b.setWebViewClient(new C1(this));
        }
    }
}
