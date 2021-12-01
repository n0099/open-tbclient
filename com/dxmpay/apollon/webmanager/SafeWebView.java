package com.dxmpay.apollon.webmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import c.f.a.i.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.NoProguard;
/* loaded from: classes12.dex */
public class SafeWebView extends WebView {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f55231f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public volatile a f55232e;

    /* loaded from: classes12.dex */
    public static class SafeChromeClient extends WebChromeClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public SafeChromeClient() {
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

        private void a(WebView webView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, this, webView) == null) && (webView instanceof SafeWebView)) {
                ((SafeWebView) webView).impactJavascriptInterfaces();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, webView, str, str2, str3, jsPromptResult)) == null) {
                if (SafeWebView.f55231f) {
                    String str4 = "onJsPrompt: " + str;
                    String str5 = "msg: " + str2;
                    String str6 = "defaultValue" + str3;
                }
                if ((webView instanceof SafeWebView) && ((SafeWebView) webView).jsCallJava(str, str2, str3, jsPromptResult)) {
                    return true;
                }
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2) == null) {
                if (i2 <= 25) {
                    this.a = false;
                } else if (!this.a) {
                    a(webView);
                    this.a = true;
                    if (SafeWebView.f55231f) {
                        String str = " inject js interface completely on progress " + i2;
                    }
                }
                super.onProgressChanged(webView, i2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) || this.a) {
                return;
            }
            this.a = false;
            if (SafeWebView.f55231f) {
                String str2 = "onReceivedTitle: " + str;
            }
            a(webView);
            super.onReceivedTitle(webView, str);
            this.a = true;
        }
    }

    /* loaded from: classes12.dex */
    public static class SafeWebViewClient extends WebViewClient implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public SafeWebViewClient() {
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

        private void a(WebView webView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, this, webView) == null) && (webView instanceof SafeWebView)) {
                ((SafeWebView) webView).impactJavascriptInterfaces();
            }
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, webView, str, z) == null) || this.a) {
                return;
            }
            this.a = false;
            if (SafeWebView.f55231f) {
                String str2 = "doUpdateVisitedHistory: " + str;
            }
            a(webView);
            super.doUpdateVisitedHistory(webView, str, z);
            this.a = true;
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) || this.a) {
                return;
            }
            this.a = false;
            if (SafeWebView.f55231f) {
                String str2 = "onLoadResource: " + str;
            }
            super.onLoadResource(webView, str);
            this.a = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) || this.a) {
                return;
            }
            this.a = false;
            if (SafeWebView.f55231f) {
                String str2 = "onPageFinished: " + str;
            }
            a(webView);
            super.onPageFinished(webView, str);
            this.a = false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048579, this, webView, str, bitmap) == null) || this.a) {
                return;
            }
            this.a = false;
            if (SafeWebView.f55231f) {
                String str2 = "onPageStarted: " + str;
            }
            a(webView);
            super.onPageStarted(webView, str, bitmap);
            this.a = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048580, this, webView, httpAuthHandler, str, str2) == null) {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            InterceptResult invokeLL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 14 && i2 < 16) {
                    try {
                        z = webView.getSettings().getAllowFileAccess();
                    } catch (Exception unused) {
                        z = false;
                    }
                    String lowerCase = str == null ? null : str.toLowerCase();
                    if (lowerCase != null && !lowerCase.startsWith("file:///android_asset/") && !lowerCase.startsWith("file:///android_res/") && !z && lowerCase.startsWith("file://")) {
                        return new WebResourceResponse(null, null, null);
                    }
                }
                return super.shouldInterceptRequest(webView, str);
            }
            return (WebResourceResponse) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(679690543, "Lcom/dxmpay/apollon/webmanager/SafeWebView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(679690543, "Lcom/dxmpay/apollon/webmanager/SafeWebView;");
                return;
            }
        }
        f55231f = ApollonConstants.DEBUG & true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public SafeWebView(Context context, AttributeSet attributeSet, int i2, boolean z) {
        super(context, attributeSet, i2, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f55232e = null;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setWebChromeClient(new SafeChromeClient());
            setWebViewClient(new SafeWebViewClient());
            getSettings().setAllowFileAccess(false);
            getSettings().setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT <= 18) {
                getSettings().setSavePassword(false);
            }
            c();
        }
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, str) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                super.addJavascriptInterface(obj, str);
            } else {
                getJsBridge().d(obj, str);
            }
        }
    }

    public void addJsCode(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            getJsBridge().f(str, str2);
        }
    }

    @SuppressLint({"NewApi"})
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 11 || i2 >= 17) {
                return false;
            }
            super.removeJavascriptInterface("searchBoxJavaBridge_");
            super.removeJavascriptInterface("accessibility");
            super.removeJavascriptInterface("accessibilityTraversal");
            return true;
        }
        return invokeV.booleanValue;
    }

    public void clearJsCode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            getJsBridge().c();
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            getJsBridge().m();
            super.destroy();
        }
    }

    public a getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f55232e == null) {
                synchronized (this) {
                    if (this.f55232e == null) {
                        this.f55232e = new a();
                    }
                }
            }
            return this.f55232e;
        }
        return (a) invokeV.objValue;
    }

    public void impactJavascriptInterfaces() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String j2 = getJsBridge().j();
            try {
                if (Build.VERSION.SDK_INT >= 19) {
                    evaluateJavascript(j2.substring(11), null);
                } else {
                    super.loadUrl(j2);
                }
            } catch (Throwable unused) {
            }
            boolean z = f55231f;
        }
    }

    public boolean jsCallJava(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, jsPromptResult)) == null) ? getJsBridge().i(str, str2, str3, jsPromptResult) : invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebView
    @SuppressLint({"NewApi"})
    public void removeJavascriptInterface(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                super.removeJavascriptInterface(str);
            } else {
                getJsBridge().e(str);
            }
        }
    }

    public void removeJsCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            getJsBridge().k(str);
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, webChromeClient) == null) {
            if (webChromeClient != null && !(webChromeClient instanceof SafeChromeClient)) {
                throw new RuntimeException("WebChromeClient must be extended from SecureWebChromeClient!!");
            }
            super.setWebChromeClient(webChromeClient);
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, webViewClient) == null) {
            if (webViewClient != null && !(webViewClient instanceof SafeWebViewClient)) {
                throw new RuntimeException("WebViewClient must be extended from SafeWebViewClient!!");
            }
            super.setWebViewClient(webViewClient);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f55232e = null;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f55232e = null;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55232e = null;
        a(context);
    }
}
