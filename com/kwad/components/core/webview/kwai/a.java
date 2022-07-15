package com.kwad.components.core.webview.kwai;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.d;
/* loaded from: classes5.dex */
public class a extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = true;
        this.a = "";
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.b = z;
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, webResourceRequest)) == null) {
            if (this.b && d.U()) {
                String uri = webResourceRequest.getUrl().toString();
                com.kwad.sdk.core.d.b.a("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + uri);
                WebResourceResponse a = com.kwad.components.a.a.a().a(uri, this.a);
                return a == null ? super.shouldInterceptRequest(webView, webResourceRequest) : a;
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
            if (this.b && d.U()) {
                com.kwad.sdk.core.d.b.a("HybridWebViewClient", "shouldInterceptRequest: " + str);
                WebResourceResponse a = com.kwad.components.a.a.a().a(str, this.a);
                return a == null ? super.shouldInterceptRequest(webView, str) : a;
            }
            return super.shouldInterceptRequest(webView, str);
        }
        return (WebResourceResponse) invokeLL.objValue;
    }
}
