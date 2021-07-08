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
public class E1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f39355a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f39356b;

    /* renamed from: c  reason: collision with root package name */
    public Info f39357c;

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
        this.f39355a = context;
        if (this.f39356b == null) {
            WebView webView = new WebView(this.f39355a);
            this.f39356b = webView;
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f39356b.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f39356b.removeJavascriptInterface("accessibility");
                this.f39356b.removeJavascriptInterface("accessibilityTraversal");
            }
            this.f39356b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f39356b.getSettings().setBlockNetworkImage(true);
            this.f39356b.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.f39356b.getSettings().setCacheMode(2);
            this.f39356b.getSettings().setAppCacheEnabled(true);
            this.f39356b.setScrollBarStyle(0);
            settings.setDomStorageEnabled(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setEnableSmoothTransition(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(1);
            }
            settings.setNeedInitialFocus(false);
            this.f39356b.clearCache(true);
            this.f39356b.clearHistory();
            this.f39356b.setWebChromeClient(new B1(this));
            this.f39356b.setWebViewClient(new C1(this));
        }
    }
}
