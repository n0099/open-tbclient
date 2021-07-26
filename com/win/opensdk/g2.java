package com.win.opensdk;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class g2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f39810a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f39811b;

    /* renamed from: c  reason: collision with root package name */
    public Info f39812c;

    public g2(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39810a = context;
        if (this.f39811b == null) {
            WebView webView = new WebView(this.f39810a);
            this.f39811b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f39811b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f39811b.removeJavascriptInterface("accessibility");
                this.f39811b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f39811b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f39811b.getSettings().setBlockNetworkImage(true);
            this.f39811b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f39811b.getSettings().setCacheMode(2);
            this.f39811b.getSettings().setAppCacheEnabled(true);
            this.f39811b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(1);
            }
            settings.setNeedInitialFocus(false);
            this.f39811b.clearCache(true);
            this.f39811b.clearHistory();
            this.f39811b.setWebChromeClient(new d2(this));
            this.f39811b.setWebViewClient(new e2(this));
        }
    }
}
