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
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import h.a.a.e.f.h;
import h.a.a.e.f.i;
import h.a.a.e.h.p;
import h.a.a.e.j.b;
import java.net.URL;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.webview.UrlPageParams;
/* loaded from: classes8.dex */
public class YYPayWebView extends LinearLayout implements h.a.a.e.i.a, b.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f45886b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45887c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45888d;

    /* renamed from: e  reason: collision with root package name */
    public Context f45889e;

    /* loaded from: classes8.dex */
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
                        this.a.f45889e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    } else if (str.endsWith("html/help/download.html")) {
                        try {
                            this.a.f45889e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        } catch (Exception e2) {
                            RLog.error("YYPayWebView", "shouldOverrideUrlLoading exception:" + e2.getLocalizedMessage(), new Object[0]);
                        }
                        return true;
                    } else {
                        this.a.f45886b.loadUrl(str);
                        if (this.a.a != null) {
                            this.a.a.onUrlLoading(webView, str);
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public interface c {
        String getToken();

        void onNativeOperation(NativeOperationParams nativeOperationParams);

        void onOpenNewUrl(i iVar, h hVar);

        void onUpdateTopUi(h hVar);

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

    @Override // h.a.a.e.j.b.e
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
                cVar.onUpdateTopUi(new h(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl));
            }
        }
    }

    @Override // h.a.a.e.j.b.e
    public void b(UrlPageParams urlPageParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlPageParams) == null) {
            if (urlPageParams == null) {
                RLog.error("YYPayWebView", "openPage null pageParams", new Object[0]);
                return;
            }
            RLog.debug("YYPayWebView", "onOpenUrl pageParams: %s", urlPageParams);
            if (this.a != null) {
                this.a.onOpenNewUrl(new i(urlPageParams.url, urlPageParams.pageType), new h(urlPageParams.title, urlPageParams.rightTitle, urlPageParams.rightUrl));
            }
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Object[] objArr = h.a.a.e.d.a.a;
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

    @Override // h.a.a.e.i.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // h.a.a.e.j.b.e
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d066d, (ViewGroup) this, true);
            WebView webView = (WebView) findViewById(R.id.obfuscated_res_0x7f09244a);
            this.f45886b = webView;
            this.f45889e = context;
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
            this.f45886b.addJavascriptInterface(new h.a.a.e.j.b(this), "YYPaySdkJsInterface");
            this.f45886b.setWebViewClient(new a(this));
            if (Build.VERSION.SDK_INT < 23) {
                this.f45886b.setWebChromeClient(new b(this));
            }
            h.a.a.e.j.a.a(this.f45886b);
            this.f45888d = !Env.instance().isTestEnv();
            RLog.info("YYPayWebView", "isEnableBackupDomain=" + this.f45888d);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            RLog.info("YYPayWebView", "loadUrl: " + p.a(str));
            this.f45886b.loadUrl(str);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f45888d) {
            if (!this.f45887c) {
                RLog.warn("YYPayWebView", "reloadWithBackupDomains: ignore, cur has detached from window");
                return;
            }
            WebView webView = this.f45886b;
            String url = webView != null ? webView.getUrl() : null;
            if (TextUtils.isEmpty(url)) {
                RLog.warn("YYPayWebView", "reloadWithBackupDomains: ignore, invalid url");
                return;
            }
            try {
                String host = new URL(url).getHost();
                String str = url.split(host)[1];
                String g2 = g("https://" + host);
                if (TextUtils.isEmpty(g2)) {
                    return;
                }
                RLog.info("YYPayWebView", "reloadWithBackupDomains: load empty page before retry");
                this.f45886b.stopLoading();
                this.f45886b.loadUrl("about:blank");
                i(g2 + str);
            } catch (Exception e2) {
                RLog.error("YYPayWebView", "reloadWithBackupDomains: error=" + Log.getStackTraceString(e2), new Object[0]);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            this.f45887c = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            this.f45887c = false;
        }
    }

    @Override // h.a.a.e.j.b.e
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

    @Override // h.a.a.e.i.a
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
        this.f45887c = true;
        this.f45888d = true;
        h(context, attributeSet);
    }
}
