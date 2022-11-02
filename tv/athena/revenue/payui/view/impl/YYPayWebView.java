package tv.athena.revenue.payui.view.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.f8a;
import com.baidu.tieba.g8a;
import com.baidu.tieba.m7a;
import com.baidu.tieba.o7a;
import com.baidu.tieba.s6a;
import com.baidu.tieba.t6a;
import com.baidu.tieba.w4a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import java.net.URL;
import java.util.Locale;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.webview.UrlPageParams;
/* loaded from: classes9.dex */
public class YYPayWebView extends LinearLayout implements o7a, g8a.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public WebView b;
    public boolean c;
    public boolean d;
    public Context e;

    /* loaded from: classes9.dex */
    public interface c {
        void a(NativeOperationParams nativeOperationParams);

        void b(t6a t6aVar, s6a s6aVar);

        void c(WebView webView, String str);

        void d(s6a s6aVar);

        String getToken();
    }

    @Override // com.baidu.tieba.o7a
    public void attachWindow(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, window) == null) {
        }
    }

    @Override // com.baidu.tieba.o7a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o7a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.tieba.o7a
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, windowParams) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayWebView a;

        public a(YYPayWebView yYPayWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayWebView;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                RLog.info("YYPayWebView", "onPageFinished: url:" + m7a.a(str));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                RLog.info("YYPayWebView", "onPageStarted: url:" + m7a.a(str));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                RLog.error("YYPayWebView", "onReceivedError: statusCode" + i + ", desc=" + str, new Object[0]);
                this.a.j();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048579, this, webView, webResourceRequest, webResourceResponse) == null) && Build.VERSION.SDK_INT >= 23 && webResourceRequest.isForMainFrame()) {
                RLog.error("YYPayWebView", "onReceivedHttpError: statusCode" + webResourceResponse.getStatusCode(), new Object[0]);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, sslErrorHandler, sslError) == null) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                if (sslError != null) {
                    str = sslError.toString();
                } else {
                    str = "";
                }
                RLog.error("YYPayWebView", "onReceivedSslError: errorMsg" + str, new Object[0]);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
                RLog.info("YYPayWebView", "OriginalUrl : " + webView.getOriginalUrl());
                RLog.info("YYPayWebView", "shouldOverrideUrlLoading url = " + str);
                if (str == null) {
                    return false;
                }
                RLog.info("YYPayWebView", "shouldOverrideUrlLoading url:" + str);
                try {
                    if (str.startsWith("upwrp://")) {
                        this.a.e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    } else if (str.endsWith("html/help/download.html")) {
                        try {
                            this.a.e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        } catch (Exception e) {
                            RLog.error("YYPayWebView", "shouldOverrideUrlLoading exception:" + e.getLocalizedMessage(), new Object[0]);
                        }
                        return true;
                    } else {
                        if (this.a.a != null) {
                            this.a.a.c(webView, str);
                        }
                        if (str.toLowerCase(Locale.CHINA).startsWith("http") || str.toLowerCase(Locale.CHINA).startsWith("https") || str.toLowerCase(Locale.CHINA).startsWith("file")) {
                            return false;
                        }
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                } catch (Exception e2) {
                    RLog.error("YYPayWebView", "shouldOverrideUrlLoading exception:" + e2.getLocalizedMessage(), new Object[0]);
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayWebView a;

        public b(YYPayWebView yYPayWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayWebView;
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) && str != null) {
                if (str.contains("500") || str.contains("404")) {
                    RLog.error("YYPayWebView", "onReceivedTitle: contains error: " + str, new Object[0]);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYPayWebView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.g8a.f
    public void b(UrlPageParams urlPageParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, urlPageParams) == null) {
            if (urlPageParams == null) {
                RLog.error("YYPayWebView", "onUpdateTopUi pageParams is null", new Object[0]);
                return;
            }
            RLog.debug("YYPayWebView", "onUpdateTopUi pageParams: %s", urlPageParams);
            c cVar = this.a;
            if (cVar != null) {
                cVar.d(new s6a(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl));
            }
        }
    }

    @Override // com.baidu.tieba.g8a.f
    public void c(UrlPageParams urlPageParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, urlPageParams) == null) {
            if (urlPageParams == null) {
                RLog.error("YYPayWebView", "openPage null pageParams", new Object[0]);
                return;
            }
            RLog.debug("YYPayWebView", "onOpenUrl pageParams: %s", urlPageParams);
            if (this.a != null) {
                this.a.b(new t6a(urlPageParams.url, urlPageParams.pageType), new s6a(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl));
            }
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Object[] objArr = w4a.a;
            if (objArr == null || objArr.length <= 0 || str == null) {
                return null;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= objArr.length) {
                    break;
                } else if (str.equals(objArr[i2])) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            int i3 = i + 1;
            if (i3 >= objArr.length) {
                return null;
            }
            return objArr[i3];
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYPayWebView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayWebView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.c = true;
        this.d = true;
        h(context, attributeSet);
    }

    @Override // com.baidu.tieba.g8a.f
    public void a(NativeOperationParams nativeOperationParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nativeOperationParams) == null) {
            if (nativeOperationParams == null) {
                RLog.error("YYPayWebView", "onNativeOperation params = null", new Object[0]);
                return;
            }
            RLog.debug("YYPayWebView", "onNativeOperation params: %s", nativeOperationParams);
            c cVar = this.a;
            if (cVar != null) {
                cVar.a(nativeOperationParams);
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            RLog.info("YYPayWebView", "loadUrl: " + m7a.a(str));
            this.b.loadUrl(str);
        }
    }

    public void setCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.a = cVar;
        }
    }

    @Override // com.baidu.tieba.g8a.f
    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.getToken();
            }
            RLog.error("YYPayWebView", "getToken() mCallback null", new Object[0]);
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onAttachedToWindow();
            this.c = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            this.c = false;
        }
    }

    public final void h(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, attributeSet) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d06c5, (ViewGroup) this, true);
            WebView webView = (WebView) findViewById(R.id.obfuscated_res_0x7f092699);
            this.b = webView;
            this.e = context;
            WebSettings settings = webView.getSettings();
            if (settings != null) {
                String str = settings.getUserAgentString() + " YYPaySdk(SdkVersion:" + BuildConfig.VERSION_NAME + SmallTailInfo.EMOTION_SUFFIX;
                RLog.info("YYPayWebView", "init newUA:" + str);
                settings.setUserAgentString(str);
                settings.setDomStorageEnabled(true);
                settings.setJavaScriptEnabled(true);
                settings.setBuiltInZoomControls(false);
                settings.setTextZoom(100);
                settings.setMediaPlaybackRequiresUserGesture(false);
                settings.setUseWideViewPort(true);
                if (Build.VERSION.SDK_INT >= 21) {
                    settings.setMixedContentMode(0);
                }
            }
            this.b.addJavascriptInterface(new g8a(this), "YYPaySdkJsInterface");
            this.b.setWebViewClient(new a(this));
            if (Build.VERSION.SDK_INT < 23) {
                this.b.setWebChromeClient(new b(this));
            }
            f8a.a(this.b);
            this.d = !Env.instance().isTestEnv();
            RLog.info("YYPayWebView", "isEnableBackupDomain=" + this.d);
        }
    }

    public final void j() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || !this.d) {
            return;
        }
        if (!this.c) {
            RLog.warn("YYPayWebView", "reloadWithBackupDomains: ignore, cur has detached from window");
            return;
        }
        WebView webView = this.b;
        if (webView != null) {
            str = webView.getUrl();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            RLog.warn("YYPayWebView", "reloadWithBackupDomains: ignore, invalid url");
            return;
        }
        try {
            String host = new URL(str).getHost();
            String str2 = str.split(host)[1];
            String g = g("https://" + host);
            if (!TextUtils.isEmpty(g)) {
                RLog.info("YYPayWebView", "reloadWithBackupDomains: load empty page before retry");
                this.b.stopLoading();
                this.b.loadUrl("about:blank");
                i(g + str2);
            }
        } catch (Exception e) {
            RLog.error("YYPayWebView", "reloadWithBackupDomains: error=" + Log.getStackTraceString(e), new Object[0]);
        }
    }
}
