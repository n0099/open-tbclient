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
/* loaded from: classes7.dex */
public class E1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f42341a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f42342b;

    /* renamed from: c  reason: collision with root package name */
    public Info f42343c;

    public E1(Context context) {
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
        this.f42341a = context;
        if (this.f42342b == null) {
            WebView webView = new WebView(this.f42341a);
            this.f42342b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f42342b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f42342b.removeJavascriptInterface("accessibility");
                this.f42342b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f42342b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f42342b.getSettings().setBlockNetworkImage(true);
            this.f42342b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f42342b.getSettings().setCacheMode(2);
            this.f42342b.getSettings().setAppCacheEnabled(true);
            this.f42342b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(1);
            }
            settings.setNeedInitialFocus(false);
            this.f42342b.clearCache(true);
            this.f42342b.clearHistory();
            this.f42342b.setWebChromeClient(new B1(this));
            this.f42342b.setWebViewClient(new C1(this));
        }
    }
}
