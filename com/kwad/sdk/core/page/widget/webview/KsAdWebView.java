package com.kwad.sdk.core.page.widget.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.t;
/* loaded from: classes7.dex */
public class KsAdWebView extends com.kwad.sdk.core.page.widget.webview.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f36457a;

    /* renamed from: b  reason: collision with root package name */
    public c f36458b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f36459c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36460d;

    /* renamed from: e  reason: collision with root package name */
    public d f36461e;

    /* renamed from: f  reason: collision with root package name */
    public b f36462f;

    /* renamed from: g  reason: collision with root package name */
    public o.a f36463g;

    /* loaded from: classes7.dex */
    public class a implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ KsAdWebView f36466a;

        public a(KsAdWebView ksAdWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ksAdWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36466a = ksAdWebView;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                AdDownloadProxy proxyForDownload = KsAdSDKImpl.get().getProxyForDownload();
                if (proxyForDownload == null || !this.f36466a.f36460d) {
                    try {
                        this.f36466a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return;
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                        return;
                    }
                }
                DownloadParams downloadParams = new DownloadParams();
                downloadParams.mDownloadid = t.a(str);
                AdInfo.AdBaseInfo adBaseInfo = com.kwad.sdk.core.response.b.c.j(this.f36466a.f36459c).adBaseInfo;
                downloadParams.mAppName = adBaseInfo.appName;
                downloadParams.mPkgname = adBaseInfo.appPackageName;
                downloadParams.mFileUrl = str;
                downloadParams.mAppIcon = adBaseInfo.appIconUrl;
                downloadParams.mShortDesc = adBaseInfo.adDescription;
                proxyForDownload.startDownload(this.f36466a.getContext(), downloadParams.mDownloadid, downloadParams);
                Toast.makeText(this.f36466a.getContext(), "开始下载", 0).show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();

        void a(int i2, String str, String str2);

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsAdWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36460d = true;
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36460d = true;
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsAdWebView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f36460d = true;
        g();
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            WebSettings settings = getSettings();
            try {
                settings.setJavaScriptEnabled(true);
                settings.setUseWideViewPort(true);
            } catch (Exception unused) {
                a();
                settings.setJavaScriptEnabled(true);
            }
            settings.setSavePassword(false);
            settings.setDomStorageEnabled(true);
            setVerticalScrollBarEnabled(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setAllowFileAccess(false);
            if (Build.VERSION.SDK_INT >= 21) {
                getSettings().setMixedContentMode(0);
            }
            setWebViewClient(new com.kwad.sdk.core.page.widget.webview.c(this) { // from class: com.kwad.sdk.core.page.widget.webview.KsAdWebView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsAdWebView f36464a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36464a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        super.onPageFinished(webView, str);
                        KsAdWebView ksAdWebView = this.f36464a;
                        if (!ksAdWebView.f36457a) {
                            ksAdWebView.f36457a = true;
                            com.kwad.sdk.core.report.b.b(ksAdWebView.f36459c, this.f36464a.f36463g);
                        }
                        if (this.f36464a.f36461e != null) {
                            this.f36464a.f36461e.b();
                        }
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                        super.onPageStarted(webView, str, bitmap);
                        if (this.f36464a.f36461e != null) {
                            this.f36464a.f36461e.a();
                        }
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                        super.onReceivedError(webView, i2, str, str2);
                        com.kwad.sdk.core.d.a.a("KsAdWebView", "onReceivedError " + i2);
                        if (this.f36464a.f36461e != null) {
                            this.f36464a.f36461e.a(i2, str, str2);
                        }
                        com.kwad.sdk.core.report.b.d(this.f36464a.f36459c, this.f36464a.f36463g);
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048579, this, webView, str)) == null) {
                        try {
                        } catch (Exception e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                        if (!str.startsWith("http") && !str.startsWith("https")) {
                            if (!str.startsWith("tel:") && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                                int a2 = com.kwad.sdk.core.download.b.d.a(this.f36464a.getContext(), str);
                                if (a2 == 1) {
                                    if (this.f36464a.f36462f != null) {
                                        this.f36464a.f36462f.a();
                                    }
                                    com.kwad.sdk.core.report.b.a(this.f36464a.f36459c, 2);
                                    return true;
                                }
                                if (this.f36464a.f36462f != null) {
                                    this.f36464a.f36462f.b();
                                }
                                if (a2 == -1) {
                                    com.kwad.sdk.core.report.b.b(this.f36464a.f36459c, 2);
                                }
                                return true;
                            }
                            this.f36464a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                    return invokeLL.booleanValue;
                }
            });
            setWebChromeClient(new com.kwad.sdk.core.page.widget.webview.a(this) { // from class: com.kwad.sdk.core.page.widget.webview.KsAdWebView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsAdWebView f36465a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36465a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.a, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, webView, i2) == null) {
                        super.onProgressChanged(webView, i2);
                    }
                }
            });
            setDownloadListener(new a());
            String userAgentString = settings.getUserAgentString();
            settings.setUserAgentString(userAgentString + h());
        }
    }

    private String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            return "KSADSDK_V3.3.9_" + getContext().getPackageName() + "_" + ah.l(getContext());
        }
        return (String) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.core.report.b.a(this.f36459c, this.f36463g);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f();
            com.kwad.sdk.core.report.b.c(this.f36459c, this.f36463g);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (getParent() != null && (getParent() instanceof ViewGroup)) {
                ((ViewGroup) getParent()).removeAllViews();
            }
            destroy();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            c cVar = this.f36458b;
            if (cVar != null) {
                cVar.a(this, i2, i3, i4, i5);
            }
        }
    }

    public void setClientParams(o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f36463g = aVar;
        }
    }

    public void setDeepLinkListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f36462f = bVar;
        }
    }

    public void setHttpErrorListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f36461e = dVar;
        }
    }

    public void setInsideDownloadEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f36460d = z;
        }
    }

    public void setOnWebViewScrollChangeListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f36458b = cVar;
        }
    }

    public void setTemplateData(@Nullable AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adTemplate) == null) {
            this.f36459c = adTemplate;
        }
    }
}
