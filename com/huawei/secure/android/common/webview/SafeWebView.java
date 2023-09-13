package com.huawei.secure.android.common.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h0c;
import com.baidu.tieba.i0c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.secure.android.common.util.LogsUtil;
import com.huawei.secure.android.common.webview.WebViewLoadCallBack;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes10.dex */
public class SafeWebView extends WebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String[] b;
    public String[] c;
    public String[] d;
    public WebViewLoadCallBack e;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public final class b extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WebViewClient a;
        public boolean b;
        public final /* synthetic */ SafeWebView c;

        public b(SafeWebView safeWebView, WebViewClient webViewClient, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeWebView, webViewClient, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = safeWebView;
            this.a = webViewClient;
            this.b = z;
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{webView, Float.valueOf(f), Float.valueOf(f2)}) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onScaleChanged(webView, f, f2);
                } else {
                    super.onScaleChanged(webView, f, f2);
                }
            }
        }

        public /* synthetic */ b(SafeWebView safeWebView, WebViewClient webViewClient, boolean z, a aVar) {
            this(safeWebView, webViewClient, z);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048583, this, webView, i, str, str2) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onReceivedError(webView, i, str, str2);
                } else {
                    super.onReceivedError(webView, i, str, str2);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048585, this, webView, httpAuthHandler, str, str2) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
                } else {
                    super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(12)
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048587, this, webView, str, str2, str3) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
                } else {
                    super.onReceivedLoginRequest(webView, str, str2, str3);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(1048590, this, webView, webResourceRequest, i, safeBrowsingResponse) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
                } else {
                    super.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, webView, str, z) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.doUpdateVisitedHistory(webView, str, z);
                } else {
                    super.doUpdateVisitedHistory(webView, str, z);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, message, message2) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onFormResubmission(webView, message, message2);
                } else {
                    super.onFormResubmission(webView, message, message2);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, webView, str, bitmap) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null && !this.b) {
                    webViewClient.onPageStarted(webView, str, bitmap);
                } else if (!this.c.c(str)) {
                    this.c.d(webView, str);
                } else {
                    super.onPageStarted(webView, str, bitmap);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, webResourceRequest, webResourceError) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
                } else {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048586, this, webView, webResourceRequest, webResourceResponse) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                } else {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048588, this, webView, sslErrorHandler, sslError) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
                } else {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048592, this, webView, message, message2) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onTooManyRedirects(webView, message, message2);
                } else {
                    super.onTooManyRedirects(webView, message, message2);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onLoadResource(webView, str);
                } else {
                    super.onLoadResource(webView, str);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onPageCommitVisible(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onPageCommitVisible(webView, str);
                } else {
                    super.onPageCommitVisible(webView, str);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onPageFinished(webView, str);
                } else {
                    super.onPageFinished(webView, str);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, webView, clientCertRequest) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
                } else {
                    super.onReceivedClientCertRequest(webView, clientCertRequest);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, webView, renderProcessGoneDetail)) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    return webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, webView, keyEvent) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    webViewClient.onUnhandledKeyEvent(webView, keyEvent);
                } else {
                    super.onUnhandledKeyEvent(webView, keyEvent);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, webView, webResourceRequest)) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            return (WebResourceResponse) invokeLL.objValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, webView, keyEvent)) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
                }
                return super.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, webView, webResourceRequest)) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
                }
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(11)
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, webView, str)) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    return webViewClient.shouldInterceptRequest(webView, str);
                }
                return super.shouldInterceptRequest(webView, str);
            }
            return (WebResourceResponse) invokeLL.objValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, webView, str)) == null) {
                WebViewClient webViewClient = this.a;
                if (webViewClient != null) {
                    return webViewClient.shouldOverrideUrlLoading(webView, str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (b(str)) {
                Log.e("SafeWebView", "loadUrl: http url , not safe");
                if (!TextUtils.isEmpty(this.a)) {
                    super.loadUrl(this.a);
                    return;
                } else if (getWebViewLoadCallBack() != null) {
                    Log.e("SafeWebView", "WebViewLoadCallBack");
                    getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
                    return;
                } else {
                    return;
                }
            }
            super.loadUrl(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a();
    }

    public final void d(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) {
            LogsUtil.e("SafeWebView", "onCheckError url is not in white list ", str);
            webView.stopLoading();
            String defaultErrorPage = getDefaultErrorPage();
            if (!TextUtils.isEmpty(defaultErrorPage)) {
                webView.loadUrl(defaultErrorPage);
            } else if (getWebViewLoadCallBack() != null) {
                Log.e("SafeWebView", "onPageStarted WebViewLoadCallBack");
                getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.URL_NOT_IN_WHITE_LIST);
            }
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, map) == null) {
            if (b(str)) {
                Log.e("SafeWebView", "loadUrl: http url , not safe");
                if (!TextUtils.isEmpty(this.a)) {
                    super.loadUrl(this.a, map);
                    return;
                } else if (getWebViewLoadCallBack() != null) {
                    Log.e("SafeWebView", "WebViewLoadCallBack");
                    getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
                    return;
                } else {
                    return;
                }
            }
            super.loadUrl(str, map);
        }
    }

    @Override // android.webkit.WebView
    public void postUrl(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, bArr) == null) {
            if (b(str)) {
                Log.e("SafeWebView", "postUrl: http url , not safe");
                if (!TextUtils.isEmpty(this.a)) {
                    super.postUrl(this.a, bArr);
                    return;
                } else if (getWebViewLoadCallBack() != null) {
                    Log.e("SafeWebView", "WebViewLoadCallBack");
                    getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
                    return;
                } else {
                    return;
                }
            }
            super.postUrl(str, bArr);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h0c.f(this);
            setWebViewClient(null);
        }
    }

    public String getDefaultErrorPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public WebViewLoadCallBack getWebViewLoadCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (WebViewLoadCallBack) invokeV.objValue;
    }

    @TargetApi(9)
    @Deprecated
    public String[] getWhitelist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String[] strArr = this.b;
            if (strArr == null) {
                return null;
            }
            return (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        return (String[]) invokeV.objValue;
    }

    public String[] getWhitelistNotMatchSubDomain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String[] strArr = this.c;
            if (strArr == null) {
                return null;
            }
            return (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        return (String[]) invokeV.objValue;
    }

    @Deprecated
    public String[] getWhitelistNotMathcSubDomain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String[] strArr = this.c;
            if (strArr == null) {
                return null;
            }
            return (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        return (String[]) invokeV.objValue;
    }

    @TargetApi(9)
    public String[] getWhitelistWithPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String[] strArr = this.d;
            if (strArr == null) {
                return null;
            }
            return (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        return (String[]) invokeV.objValue;
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return URLUtil.isHttpUrl(str);
        }
        return invokeL.booleanValue;
    }

    public void setDefaultErrorPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.a = str;
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, webViewClient) == null) {
            super.setWebViewClient(new b(this, webViewClient, true, null));
        }
    }

    public void setWebViewLoadCallBack(WebViewLoadCallBack webViewLoadCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, webViewLoadCallBack) == null) {
            this.e = webViewLoadCallBack;
        }
    }

    @TargetApi(9)
    @Deprecated
    public void setWhitelist(String[] strArr) {
        String[] strArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, strArr) == null) {
            if (strArr == null) {
                strArr2 = null;
            } else {
                strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            this.b = strArr2;
        }
    }

    public void setWhitelistNotMatchSubDomain(String[] strArr) {
        String[] strArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, strArr) == null) {
            if (strArr == null) {
                strArr2 = null;
            } else {
                strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            this.c = strArr2;
        }
    }

    @Deprecated
    public void setWhitelistNotMathcSubDomain(String[] strArr) {
        String[] strArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, strArr) == null) {
            if (strArr == null) {
                strArr2 = null;
            } else {
                strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            this.c = strArr2;
        }
    }

    @TargetApi(9)
    public void setWhitelistWithPath(String[] strArr) {
        String[] strArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, strArr) == null) {
            if (strArr == null) {
                strArr2 = null;
            } else {
                strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            this.d = strArr2;
        }
    }

    @TargetApi(9)
    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                LogsUtil.d("SafeWebView", "url is null");
                return false;
            } else if (!URLUtil.isNetworkUrl(str)) {
                return true;
            } else {
                String[] whitelistWithPath = getWhitelistWithPath();
                String[] whitelistNotMatchSubDomain = getWhitelistNotMatchSubDomain();
                String[] whitelist = getWhitelist();
                if (whitelistWithPath != null && whitelistWithPath.length != 0) {
                    return i0c.c(str, whitelistWithPath);
                }
                if (whitelistNotMatchSubDomain != null && whitelistNotMatchSubDomain.length != 0) {
                    return i0c.h(str, whitelistNotMatchSubDomain);
                }
                return i0c.e(str, whitelist);
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, str, str2, str3, str4, str5) == null) {
            if (b(str)) {
                Log.e("SafeWebView", "loadDataWithBaseURL: http url , not safe");
                if (!TextUtils.isEmpty(this.a)) {
                    super.loadDataWithBaseURL(this.a, str2, str3, str4, str5);
                    return;
                } else if (getWebViewLoadCallBack() != null) {
                    Log.e("SafeWebView", "WebViewLoadCallBack");
                    getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
                    return;
                } else {
                    return;
                }
            }
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, webViewClient, z) == null) {
            super.setWebViewClient(new b(this, webViewClient, z, null));
        }
    }
}
