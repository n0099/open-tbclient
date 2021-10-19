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
import com.baidu.mobads.container.components.countly.XAdRemoteSDKCountly;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import j.a.a.e.l.d;
import j.a.a.e.l.e;
import j.a.a.e.p.b;
import java.net.URL;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.webview.UrlPageParams;
/* loaded from: classes2.dex */
public class YYPayWebView extends LinearLayout implements j.a.a.e.o.a, b.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f80336e;

    /* renamed from: f  reason: collision with root package name */
    public WebView f80337f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f80338g;

    /* renamed from: h  reason: collision with root package name */
    public Context f80339h;
    public boolean isEnableBackupDomain;

    /* loaded from: classes2.dex */
    public class a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayWebView f80340a;

        public a(YYPayWebView yYPayWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f80340a = yYPayWebView;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i2, str, str2) == null) {
                RLog.error("YYPayWebView", "onReceivedError: statusCode" + i2 + ", desc=" + str, new Object[0]);
                this.f80340a.g();
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
                        this.f80340a.f80339h.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    } else if (str.endsWith("html/help/download.html")) {
                        try {
                            this.f80340a.f80339h.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        } catch (Exception e2) {
                            RLog.error("YYPayWebView", "shouldOverrideUrlLoading exception:" + e2.getLocalizedMessage(), new Object[0]);
                        }
                        return true;
                    } else {
                        this.f80340a.f80337f.loadUrl(str);
                        if (this.f80340a.f80336e != null) {
                            this.f80340a.f80336e.onUrlLoading(webView, str);
                        }
                        return true;
                    }
                } catch (Exception e3) {
                    RLog.error("YYPayWebView", "shouldOverrideUrlLoading exception:" + e3.getLocalizedMessage(), new Object[0]);
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayWebView f80341a;

        public b(YYPayWebView yYPayWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f80341a = yYPayWebView;
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) || str == null) {
                return;
            }
            if (str.contains("500") || str.contains(XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH)) {
                RLog.error("YYPayWebView", "onReceivedTitle: contains error: " + str, new Object[0]);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        String getToken();

        void onNativeOperation(NativeOperationParams nativeOperationParams);

        void onOpenNewUrl(e eVar, d dVar);

        void onUpdateTopUi(d dVar);

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Object[] objArr = j.a.a.e.j.a.f79446a;
            if (objArr == null || objArr.length <= 0 || str == null) {
                return null;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= objArr.length) {
                    break;
                } else if (str.equals(objArr[i3])) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            int i4 = i2 + 1;
            if (i4 < objArr.length) {
                return objArr[i4];
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void f(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) {
            LayoutInflater.from(context).inflate(j.a.a.e.e.pay_ui_layout_pay_wallet_view, (ViewGroup) this, true);
            WebView webView = (WebView) findViewById(j.a.a.e.d.webview);
            this.f80337f = webView;
            this.f80339h = context;
            WebSettings settings = webView.getSettings();
            if (settings != null) {
                settings.setJavaScriptEnabled(true);
                settings.setBuiltInZoomControls(false);
                settings.setTextZoom(100);
                settings.setMediaPlaybackRequiresUserGesture(false);
                settings.setUseWideViewPort(true);
                if (Build.VERSION.SDK_INT >= 21) {
                    settings.setMixedContentMode(0);
                }
            }
            this.f80337f.addJavascriptInterface(new j.a.a.e.p.b(this), "YYPaySdkJsInterface");
            this.f80337f.setWebViewClient(new a(this));
            if (Build.VERSION.SDK_INT < 23) {
                this.f80337f.setWebChromeClient(new b(this));
            }
            j.a.a.e.p.a.a(this.f80337f);
            this.isEnableBackupDomain = !Env.instance().isTestEnv();
            RLog.info("YYPayWebView", "isEnableBackupDomain=" + this.isEnableBackupDomain);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.isEnableBackupDomain) {
            if (!this.f80338g) {
                RLog.warn("YYPayWebView", "reloadWithBackupDomains: ignore, cur has detached from window");
                return;
            }
            WebView webView = this.f80337f;
            String url = webView != null ? webView.getUrl() : null;
            if (TextUtils.isEmpty(url)) {
                RLog.warn("YYPayWebView", "reloadWithBackupDomains: ignore, invalid url");
                return;
            }
            try {
                String host = new URL(url).getHost();
                String str = url.split(host)[1];
                String e2 = e("https://" + host);
                if (TextUtils.isEmpty(e2)) {
                    return;
                }
                RLog.info("YYPayWebView", "reloadWithBackupDomains: load empty page before retry");
                this.f80337f.stopLoading();
                this.f80337f.loadUrl("about:blank");
                loadUrl(e2 + str);
            } catch (Exception e3) {
                RLog.error("YYPayWebView", "reloadWithBackupDomains: error=" + Log.getStackTraceString(e3), new Object[0]);
            }
        }
    }

    @Override // j.a.a.e.o.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // j.a.a.e.p.b.f
    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c cVar = this.f80336e;
            if (cVar != null) {
                return cVar.getToken();
            }
            RLog.error("YYPayWebView", "getToken() mCallback null", new Object[0]);
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            RLog.info("YYPayWebView", "loadUrl: " + str);
            this.f80337f.loadUrl(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            this.f80338g = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            this.f80338g = false;
        }
    }

    @Override // j.a.a.e.p.b.f
    public void onNativeOperation(NativeOperationParams nativeOperationParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nativeOperationParams) == null) {
            if (nativeOperationParams == null) {
                RLog.error("YYPayWebView", "onNativeOperation params = null", new Object[0]);
                return;
            }
            RLog.debug("YYPayWebView", "onNativeOperation params: %s", nativeOperationParams);
            c cVar = this.f80336e;
            if (cVar != null) {
                cVar.onNativeOperation(nativeOperationParams);
            }
        }
    }

    @Override // j.a.a.e.p.b.f
    public void onOpenUrl(UrlPageParams urlPageParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, urlPageParams) == null) {
            if (urlPageParams == null) {
                RLog.error("YYPayWebView", "openPage null pageParams", new Object[0]);
                return;
            }
            RLog.debug("YYPayWebView", "onOpenUrl pageParams: %s", urlPageParams);
            if (this.f80336e != null) {
                this.f80336e.onOpenNewUrl(new e(urlPageParams.url, urlPageParams.pageType), new d(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl));
            }
        }
    }

    @Override // j.a.a.e.p.b.f
    public void onUpdateTopUi(UrlPageParams urlPageParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, urlPageParams) == null) {
            if (urlPageParams == null) {
                RLog.error("YYPayWebView", "onUpdateTopUi pageParams is null", new Object[0]);
                return;
            }
            RLog.debug("YYPayWebView", "onUpdateTopUi pageParams: %s", urlPageParams);
            c cVar = this.f80336e;
            if (cVar != null) {
                cVar.onUpdateTopUi(new d(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl));
            }
        }
    }

    @Override // j.a.a.e.o.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void setCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.f80336e = cVar;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayWebView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f80338g = true;
        this.isEnableBackupDomain = true;
        f(context, attributeSet);
    }
}
