package com.win.opensdk;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class h2 {

    /* renamed from: a  reason: collision with root package name */
    public Context f39941a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f39942b;

    /* renamed from: c  reason: collision with root package name */
    public Info f39943c;

    public h2(Context context) {
        this.f39941a = context;
        if (this.f39942b == null) {
            WebView webView = new WebView(this.f39941a);
            this.f39942b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f39942b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f39942b.removeJavascriptInterface("accessibility");
                this.f39942b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f39942b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f39942b.getSettings().setBlockNetworkImage(true);
            this.f39942b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f39942b.getSettings().setCacheMode(2);
            this.f39942b.getSettings().setAppCacheEnabled(true);
            this.f39942b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(1);
            }
            settings.setNeedInitialFocus(false);
            this.f39942b.clearCache(true);
            this.f39942b.clearHistory();
            this.f39942b.setWebChromeClient(new e2(this));
            this.f39942b.setWebViewClient(new f2(this));
        }
    }
}
