package tv.athena.revenue.payui.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d6a;
import com.repackage.e6a;
import com.repackage.o7a;
import com.repackage.p7a;
import com.repackage.s4a;
import com.repackage.w6a;
import com.repackage.y6a;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import java.net.URL;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.webview.UrlPageParams;
/* loaded from: classes9.dex */
public class YYPayWebView extends LinearLayout implements y6a, p7a.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public WebView b;
    public boolean c;
    public boolean d;
    public Context e;

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
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i, str, str2) == null) {
                RLog.error("YYPayWebView", "onReceivedError: statusCode" + i + ", desc=" + str, new Object[0]);
                this.a.j();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, webResourceRequest, webResourceResponse) == null) && Build.VERSION.SDK_INT >= 23 && webResourceRequest.isForMainFrame()) {
                RLog.error("YYPayWebView", "onReceivedHttpError: statusCode" + webResourceResponse.getStatusCode(), new Object[0]);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
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
                        this.a.b.loadUrl(str);
                        if (this.a.a != null) {
                            this.a.a.onUrlLoading(webView, str);
                        }
                        return true;
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
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) || str == null) {
                return;
            }
            if (str.contains("500") || str.contains("404")) {
                RLog.error("YYPayWebView", "onReceivedTitle: contains error: " + str, new Object[0]);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        String getToken();

        void onNativeOperation(NativeOperationParams nativeOperationParams);

        void onOpenNewUrl(e6a e6aVar, d6a d6aVar);

        void onUpdateTopUi(d6a d6aVar);

        void onUrlLoading(WebView webView, String str);
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

    @Override // com.repackage.p7a.e
    public void a(UrlPageParams urlPageParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, urlPageParams) == null) {
            if (urlPageParams == null) {
                RLog.error("YYPayWebView", "onUpdateTopUi pageParams is null", new Object[0]);
                return;
            }
            RLog.debug("YYPayWebView", "onUpdateTopUi pageParams: %s", urlPageParams);
            c cVar = this.a;
            if (cVar != null) {
                cVar.onUpdateTopUi(new d6a(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl));
            }
        }
    }

    @Override // com.repackage.p7a.e
    public void b(UrlPageParams urlPageParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlPageParams) == null) {
            if (urlPageParams == null) {
                RLog.error("YYPayWebView", "openPage null pageParams", new Object[0]);
                return;
            }
            RLog.debug("YYPayWebView", "onOpenUrl pageParams: %s", urlPageParams);
            if (this.a != null) {
                this.a.onOpenNewUrl(new e6a(urlPageParams.url, urlPageParams.pageType), new d6a(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl));
            }
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Object[] objArr = s4a.a;
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
            if (i3 < objArr.length) {
                return objArr[i3];
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.y6a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.repackage.p7a.e
    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.getToken();
            }
            RLog.error("YYPayWebView", "getToken() mCallback null", new Object[0]);
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void h(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, attributeSet) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0669, (ViewGroup) this, true);
            WebView webView = (WebView) findViewById(R.id.obfuscated_res_0x7f092427);
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
            this.b.addJavascriptInterface(new p7a(this), "YYPaySdkJsInterface");
            this.b.setWebViewClient(new a(this));
            if (Build.VERSION.SDK_INT < 23) {
                this.b.setWebChromeClient(new b(this));
            }
            o7a.a(this.b);
            this.d = !Env.instance().isTestEnv();
            RLog.info("YYPayWebView", "isEnableBackupDomain=" + this.d);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            RLog.info("YYPayWebView", "loadUrl: " + w6a.a(str));
            this.b.loadUrl(str);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.d) {
            if (!this.c) {
                RLog.warn("YYPayWebView", "reloadWithBackupDomains: ignore, cur has detached from window");
                return;
            }
            WebView webView = this.b;
            String url = webView != null ? webView.getUrl() : null;
            if (TextUtils.isEmpty(url)) {
                RLog.warn("YYPayWebView", "reloadWithBackupDomains: ignore, invalid url");
                return;
            }
            try {
                String host = new URL(url).getHost();
                String str = url.split(host)[1];
                String g = g("https://" + host);
                if (TextUtils.isEmpty(g)) {
                    return;
                }
                RLog.info("YYPayWebView", "reloadWithBackupDomains: load empty page before retry");
                this.b.stopLoading();
                this.b.loadUrl("about:blank");
                i(g + str);
            } catch (Exception e) {
                RLog.error("YYPayWebView", "reloadWithBackupDomains: error=" + Log.getStackTraceString(e), new Object[0]);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            this.c = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            this.c = false;
        }
    }

    @Override // com.repackage.p7a.e
    public void onNativeOperation(NativeOperationParams nativeOperationParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, nativeOperationParams) == null) {
            if (nativeOperationParams == null) {
                RLog.error("YYPayWebView", "onNativeOperation params = null", new Object[0]);
                return;
            }
            RLog.debug("YYPayWebView", "onNativeOperation params: %s", nativeOperationParams);
            c cVar = this.a;
            if (cVar != null) {
                cVar.onNativeOperation(nativeOperationParams);
            }
        }
    }

    @Override // com.repackage.y6a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void setCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.a = cVar;
        }
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
}
