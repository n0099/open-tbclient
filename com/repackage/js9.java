package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.win.opensdk.bridge.JsBridge;
import com.win.opensdk.bridge.JsInvokeJavaScope;
import com.win.opensdk.bridge.core.JsBridgeWebChromeClient;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class js9 implements so9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ep9 a;
    public wo9 b;
    public WebView c;
    public boolean d;
    public String e;

    public js9(Context context) {
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
        WebView webView = new WebView(context);
        this.c = webView;
        webView.setScrollContainer(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        wp9.m(webView);
        this.c.getSettings().setJavaScriptEnabled(true);
        JsBridge.getInstance().clazz(JsInvokeJavaScope.class).inject();
        this.c.setWebChromeClient(new JsBridgeWebChromeClient());
        this.c.setWebViewClient(new fs9(this));
    }

    public void a(String str, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, info) == null) {
            if ((!TextUtils.isEmpty(str) && (str.startsWith("http") || str.startsWith("https"))) || str.startsWith(ImageSource.FILE_SCHEME)) {
                this.c.loadUrl(str);
            } else {
                this.c.loadDataWithBaseURL("http://abcd/", str, SapiWebView.DATA_MIME_TYPE, "UTF-8", null);
            }
            ep9 ep9Var = this.a;
            if (ep9Var != null) {
                ep9Var.a();
            }
            this.c.setOnTouchListener(new ms9(info, new bs9(this)));
        }
    }
}
