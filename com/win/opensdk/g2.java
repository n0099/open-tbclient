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
/* loaded from: classes10.dex */
public class g2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f77351a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f77352b;

    /* renamed from: c  reason: collision with root package name */
    public Info f77353c;

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
        this.f77351a = context;
        if (this.f77352b == null) {
            WebView webView = new WebView(this.f77351a);
            this.f77352b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f77352b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f77352b.removeJavascriptInterface("accessibility");
                this.f77352b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f77352b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f77352b.getSettings().setBlockNetworkImage(true);
            this.f77352b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f77352b.getSettings().setCacheMode(2);
            this.f77352b.getSettings().setAppCacheEnabled(true);
            this.f77352b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(1);
            }
            settings.setNeedInitialFocus(false);
            this.f77352b.clearCache(true);
            this.f77352b.clearHistory();
            this.f77352b.setWebChromeClient(new d2(this));
            this.f77352b.setWebViewClient(new e2(this));
        }
    }
}
