package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class gr9 extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Info c;
    public final /* synthetic */ String d;
    public final /* synthetic */ jr9 e;

    public gr9(jr9 jr9Var, Context context, Info info, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jr9Var, context, info, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = jr9Var;
        this.b = context;
        this.c = info;
        this.d = str;
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Uri parse = Uri.parse(str);
            if (jr9.b(parse) || jr9.c(parse)) {
                this.a = true;
                if (!vp9.b(this.b, parse, null)) {
                    yq9.a(this.b, parse);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
            super.onPageFinished(webView, str);
            this.e.c.removeMessages(11);
            if (this.a) {
                return;
            }
            tq9 a = xq9.a(this.b);
            try {
                a.b = xq9.d("ps", new br9(this.c));
                a.k("co", 2004);
                a.l("msg", str);
            } catch (JSONException unused) {
            }
            a.m();
            Message obtain = Message.obtain();
            obtain.what = 12;
            obtain.obj = this.d;
            this.e.c.sendMessage(obtain);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, webResourceRequest)) == null) ? Build.VERSION.SDK_INT >= 24 ? a(webResourceRequest.getUrl().toString()) : super.shouldOverrideUrlLoading(webView, webResourceRequest) : invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) ? Build.VERSION.SDK_INT < 24 ? a(str) : super.shouldOverrideUrlLoading(webView, str) : invokeLL.booleanValue;
    }
}
