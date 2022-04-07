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
/* loaded from: classes5.dex */
public class cs9 implements lo9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xo9 a;
    public po9 b;
    public WebView c;
    public boolean d;
    public String e;

    public cs9(Context context) {
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
        pp9.m(webView);
        this.c.getSettings().setJavaScriptEnabled(true);
        JsBridge.getInstance().clazz(JsInvokeJavaScope.class).inject();
        this.c.setWebChromeClient(new JsBridgeWebChromeClient());
        this.c.setWebViewClient(new yr9(this));
    }

    public void a(String str, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, info) == null) {
            if ((!TextUtils.isEmpty(str) && (str.startsWith("http") || str.startsWith("https"))) || str.startsWith(ImageSource.FILE_SCHEME)) {
                this.c.loadUrl(str);
            } else {
                this.c.loadDataWithBaseURL("http://abcd/", str, SapiWebView.DATA_MIME_TYPE, "UTF-8", null);
            }
            xo9 xo9Var = this.a;
            if (xo9Var != null) {
                xo9Var.a();
            }
            this.c.setOnTouchListener(new fs9(info, new ur9(this)));
        }
    }
}
