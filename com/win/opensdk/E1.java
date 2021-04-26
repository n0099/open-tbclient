package com.win.opensdk;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class E1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f37642a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f37643b;

    /* renamed from: c  reason: collision with root package name */
    public Info f37644c;

    public E1(Context context) {
        this.f37642a = context;
        if (this.f37643b == null) {
            WebView webView = new WebView(this.f37642a);
            this.f37643b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f37643b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f37643b.removeJavascriptInterface("accessibility");
                this.f37643b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f37643b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f37643b.getSettings().setBlockNetworkImage(true);
            this.f37643b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f37643b.getSettings().setCacheMode(2);
            this.f37643b.getSettings().setAppCacheEnabled(true);
            this.f37643b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(1);
            }
            settings.setNeedInitialFocus(false);
            this.f37643b.clearCache(true);
            this.f37643b.clearHistory();
            this.f37643b.setWebChromeClient(new B1(this));
            this.f37643b.setWebViewClient(new C1(this));
        }
    }
}
