package com.win.opensdk;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class E1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f40598a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f40599b;

    /* renamed from: c  reason: collision with root package name */
    public Info f40600c;

    public E1(Context context) {
        this.f40598a = context;
        if (this.f40599b == null) {
            WebView webView = new WebView(this.f40598a);
            this.f40599b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f40599b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f40599b.removeJavascriptInterface("accessibility");
                this.f40599b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f40599b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f40599b.getSettings().setBlockNetworkImage(true);
            this.f40599b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f40599b.getSettings().setCacheMode(2);
            this.f40599b.getSettings().setAppCacheEnabled(true);
            this.f40599b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(1);
            }
            settings.setNeedInitialFocus(false);
            this.f40599b.clearCache(true);
            this.f40599b.clearHistory();
            this.f40599b.setWebChromeClient(new B1(this));
            this.f40599b.setWebViewClient(new C1(this));
        }
    }
}
