package com.kwad.sdk.core.page.widget.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.w;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class KsAdWebView extends KSApiWebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f65855a;

    /* renamed from: b  reason: collision with root package name */
    public c f65856b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f65857c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65858d;

    /* renamed from: e  reason: collision with root package name */
    public d f65859e;

    /* renamed from: f  reason: collision with root package name */
    public b f65860f;

    /* renamed from: g  reason: collision with root package name */
    public n.a f65861g;

    /* renamed from: h  reason: collision with root package name */
    public long f65862h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65863i;

    /* loaded from: classes2.dex */
    public class a implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ KsAdWebView f65865a;

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
            this.f65865a = ksAdWebView;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                AdDownloadProxy proxyForDownload = KsAdSDKImpl.get().getProxyForDownload();
                if (this.f65865a.f65857c == null || proxyForDownload == null || !this.f65865a.f65858d) {
                    try {
                        this.f65865a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return;
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                        return;
                    }
                }
                DownloadParams downloadParams = new DownloadParams();
                downloadParams.mDownloadid = w.a(str);
                AdInfo.AdBaseInfo adBaseInfo = com.kwad.sdk.core.response.b.c.i(this.f65865a.f65857c).adBaseInfo;
                downloadParams.mAppName = adBaseInfo.appName;
                downloadParams.mPkgname = adBaseInfo.appPackageName;
                downloadParams.mFileUrl = str;
                downloadParams.mAppIcon = adBaseInfo.appIconUrl;
                downloadParams.mShortDesc = adBaseInfo.adDescription;
                proxyForDownload.startDownload(this.f65865a.getContext(), downloadParams.mDownloadid, downloadParams);
                Toast.makeText(this.f65865a.getContext(), "开始下载", 0).show();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    /* loaded from: classes2.dex */
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
        this.f65858d = true;
        this.f65863i = true;
        a(context);
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
        this.f65858d = true;
        this.f65863i = true;
        a(context);
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
        this.f65858d = true;
        this.f65863i = true;
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context) == null) {
            com.kwad.sdk.core.d.a.e("KsAdWebView", "init");
            setAccessibilityStateDisable(context);
            WebSettings a2 = ay.a(this);
            a2.setUseWideViewPort(true);
            a2.setDomStorageEnabled(true);
            setVerticalScrollBarEnabled(false);
            setWebViewClient(new WebViewClient(this) { // from class: com.kwad.sdk.core.page.widget.webview.KsAdWebView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsAdWebView f65864a;

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
                    this.f65864a = this;
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        super.onPageFinished(webView, str);
                        KsAdWebView ksAdWebView = this.f65864a;
                        if (!ksAdWebView.f65855a) {
                            ksAdWebView.f65855a = true;
                            if (ksAdWebView.f65862h > 0) {
                                if (this.f65864a.f65861g == null) {
                                    this.f65864a.f65861g = new n.a();
                                }
                                this.f65864a.f65861g.r = System.currentTimeMillis() - this.f65864a.f65862h;
                                this.f65864a.f65862h = -1L;
                            }
                            com.kwad.sdk.core.report.a.b(this.f65864a.f65857c, this.f65864a.f65861g);
                        }
                        if (this.f65864a.f65859e != null) {
                            this.f65864a.f65859e.b();
                        }
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                        super.onPageStarted(webView, str, bitmap);
                        if (this.f65864a.f65859e != null) {
                            this.f65864a.f65859e.a();
                        }
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                        super.onReceivedError(webView, i2, str, str2);
                        com.kwad.sdk.core.d.a.a("KsAdWebView", "onReceivedError " + i2);
                        if (this.f65864a.f65859e != null) {
                            this.f65864a.f65859e.a(i2, str, str2);
                        }
                        com.kwad.sdk.core.report.a.d(this.f65864a.f65857c, this.f65864a.f65861g);
                    }
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048579, this, webView, str)) == null) {
                        com.kwad.sdk.core.d.a.e("KsAdWebView", "shouldOverrideUrlLoading url=" + str);
                        try {
                        } catch (Exception e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                        if (!str.startsWith("http") && !str.startsWith("https")) {
                            if (!str.startsWith("tel:") && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                                if (this.f65864a.f65863i) {
                                    int a3 = com.kwad.sdk.core.download.b.d.a(this.f65864a.getContext(), str);
                                    if (a3 == 1) {
                                        if (this.f65864a.f65860f != null) {
                                            this.f65864a.f65860f.a();
                                        }
                                        com.kwad.sdk.core.report.a.a(this.f65864a.f65857c, 2);
                                        return true;
                                    }
                                    if (this.f65864a.f65860f != null) {
                                        this.f65864a.f65860f.b();
                                    }
                                    if (a3 == -1) {
                                        com.kwad.sdk.core.report.a.b(this.f65864a.f65857c, 2);
                                    }
                                } else if (this.f65864a.f65860f != null) {
                                    this.f65864a.f65860f.b();
                                }
                                return true;
                            }
                            this.f65864a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                    return invokeLL.booleanValue;
                }
            });
            setDownloadListener(new a());
            String userAgentString = a2.getUserAgentString();
            a2.setUserAgentString(userAgentString + d());
        }
    }

    private String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            return "KSADSDK_V3.3.11.4_" + getContext().getPackageName() + "_" + ap.p(getContext());
        }
        return (String) invokeV.objValue;
    }

    public static void setAccessibilityStateDisable(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, context) == null) && Build.VERSION.SDK_INT == 17 && context != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                    Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(accessibilityManager, 0);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f65857c, this.f65861g);
            this.f65862h = System.currentTimeMillis();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c();
            com.kwad.sdk.core.report.a.c(this.f65857c, this.f65861g);
        }
    }

    public void c() {
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
            c cVar = this.f65856b;
            if (cVar != null) {
                cVar.a(this, i2, i3, i4, i5);
            }
        }
    }

    public void setClientParams(n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f65861g = aVar;
        }
    }

    public void setDeepLinkEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f65863i = z;
        }
    }

    public void setDeepLinkListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f65860f = bVar;
        }
    }

    public void setHttpErrorListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f65859e = dVar;
        }
    }

    public void setInsideDownloadEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f65858d = z;
        }
    }

    public void setOnWebViewScrollChangeListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f65856b = cVar;
        }
    }

    public void setTemplateData(@Nullable AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adTemplate) == null) {
            this.f65857c = adTemplate;
        }
    }
}
