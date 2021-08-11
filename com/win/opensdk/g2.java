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
    public Context f76651a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f76652b;

    /* renamed from: c  reason: collision with root package name */
    public Info f76653c;

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
        this.f76651a = context;
        if (this.f76652b == null) {
            WebView webView = new WebView(this.f76651a);
            this.f76652b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f76652b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f76652b.removeJavascriptInterface("accessibility");
                this.f76652b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f76652b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f76652b.getSettings().setBlockNetworkImage(true);
            this.f76652b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f76652b.getSettings().setCacheMode(2);
            this.f76652b.getSettings().setAppCacheEnabled(true);
            this.f76652b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(1);
            }
            settings.setNeedInitialFocus(false);
            this.f76652b.clearCache(true);
            this.f76652b.clearHistory();
            this.f76652b.setWebChromeClient(new d2(this));
            this.f76652b.setWebViewClient(new e2(this));
        }
    }
}
