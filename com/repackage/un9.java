package com.repackage;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class un9 extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public boolean c;
    public final /* synthetic */ yn9 d;

    public un9(yn9 yn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yn9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = yn9Var;
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            yn9 yn9Var = this.d;
            if (yn9Var.d) {
                yn9Var.d = false;
                yn9 yn9Var2 = this.d;
                lk9 lk9Var = yn9Var2.b;
                if (lk9Var != null) {
                    return lk9Var.a(str, yn9Var2.e);
                }
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
            if (TextUtils.isEmpty(this.b)) {
                this.b = str;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
            tk9 tk9Var = this.d.a;
            if (tk9Var != null && !this.c) {
                this.c = true;
                tk9Var.onLoaded();
            }
            this.a = webView.getUrl();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, webResourceRequest, webResourceError) == null) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if ((TextUtils.equals(webView.getUrl(), "http://abcd/") || TextUtils.equals(webView.getUrl(), this.a)) && Build.VERSION.SDK_INT >= 23) {
                webResourceError.getDescription().toString();
                webResourceError.getErrorCode();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, webResourceRequest)) == null) {
            if (Build.VERSION.SDK_INT < 24 || !a(webResourceRequest.getUrl().toString())) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
            if (Build.VERSION.SDK_INT >= 24 || !a(str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
