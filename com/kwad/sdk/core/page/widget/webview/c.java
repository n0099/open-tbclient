package com.kwad.sdk.core.page.widget.webview;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, webView, str, z) == null) {
            try {
                if (webView instanceof b) {
                    ((b) webView).a(webView);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            super.doUpdateVisitedHistory(webView, str, z);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
            try {
                if (webView instanceof b) {
                    ((b) webView).a(webView);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            super.onLoadResource(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
            try {
                if (webView instanceof b) {
                    ((b) webView).a(webView);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            super.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, str, bitmap) == null) {
            try {
                if (webView instanceof b) {
                    ((b) webView).a(webView);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            super.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, webView, i2, str, str2) == null) {
            try {
                if (webView instanceof b) {
                    ((b) webView).a(webView);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            super.onReceivedError(webView, i2, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
            try {
                if (webView instanceof b) {
                    ((b) webView).a(webView);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return invokeLL.booleanValue;
    }
}
