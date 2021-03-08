package com.win.opensdk;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class cy {

    /* renamed from: a  reason: collision with root package name */
    public Context f8149a;
    public WebView b;
    public Info qkh;

    public cy(Context context) {
        this.f8149a = context;
        if (this.b == null) {
            this.b = new WebView(this.f8149a);
            WebSettings settings = this.b.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.b.removeJavascriptInterface("accessibility");
                this.b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.b.getSettings().setBlockNetworkImage(true);
            this.b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.b.getSettings().setCacheMode(2);
            this.b.getSettings().setAppCacheEnabled(true);
            this.b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(1);
            }
            settings.setNeedInitialFocus(false);
            this.b.clearCache(true);
            this.b.clearHistory();
            this.b.setWebChromeClient(new co(this));
            this.b.setWebViewClient(new cs(this));
        }
    }
}
