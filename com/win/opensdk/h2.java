package com.win.opensdk;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class h2 {

    /* renamed from: a  reason: collision with root package name */
    public Context f40326a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f40327b;

    /* renamed from: c  reason: collision with root package name */
    public Info f40328c;

    public h2(Context context) {
        this.f40326a = context;
        if (this.f40327b == null) {
            WebView webView = new WebView(this.f40326a);
            this.f40327b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f40327b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f40327b.removeJavascriptInterface("accessibility");
                this.f40327b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f40327b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f40327b.getSettings().setBlockNetworkImage(true);
            this.f40327b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f40327b.getSettings().setCacheMode(2);
            this.f40327b.getSettings().setAppCacheEnabled(true);
            this.f40327b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(1);
            }
            settings.setNeedInitialFocus(false);
            this.f40327b.clearCache(true);
            this.f40327b.clearHistory();
            this.f40327b.setWebChromeClient(new e2(this));
            this.f40327b.setWebViewClient(new f2(this));
        }
    }
}
