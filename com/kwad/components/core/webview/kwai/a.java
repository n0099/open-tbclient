package com.kwad.components.core.webview.kwai;

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
/* loaded from: classes7.dex */
public class a extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean KP;
    public String mUniqueId;

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
        this.KP = true;
        this.mUniqueId = "";
    }

    public final void setNeedHybridLoad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.KP = z;
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, webResourceRequest)) == null) {
            if (this.KP && d.si()) {
                String uri = webResourceRequest.getUrl().toString();
                com.kwad.sdk.core.e.b.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + uri);
                WebResourceResponse m = com.kwad.components.a.a.qo().m(uri, this.mUniqueId);
                return m == null ? super.shouldInterceptRequest(webView, webResourceRequest) : m;
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
            if (this.KP && d.si()) {
                com.kwad.sdk.core.e.b.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
                WebResourceResponse m = com.kwad.components.a.a.qo().m(str, this.mUniqueId);
                return m == null ? super.shouldInterceptRequest(webView, str) : m;
            }
            return super.shouldInterceptRequest(webView, str);
        }
        return (WebResourceResponse) invokeLL.objValue;
    }
}
