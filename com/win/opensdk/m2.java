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
/* loaded from: classes8.dex */
public class m2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public WebView b;
    public Info c;

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b == null) {
            WebView webView = new WebView(this.a);
            this.b = webView;
            WebSettings settings = webView.getSettings();
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
                settings.setMixedContentMode(0);
            }
            settings.setNeedInitialFocus(false);
            this.b.clearCache(true);
            this.b.clearHistory();
            this.b.setWebChromeClient(new j2(this));
            this.b.setWebViewClient(new k2(this));
        }
    }

    public m2(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        if (c2.a()) {
            a();
        } else {
            c2.a.post(new i2(this));
        }
    }
}
