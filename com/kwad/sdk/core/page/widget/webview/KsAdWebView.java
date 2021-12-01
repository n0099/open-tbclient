package com.kwad.sdk.core.page.widget.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.be;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class KsAdWebView extends com.kwad.sdk.core.page.widget.webview.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public c f57624b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f57625c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57626d;

    /* renamed from: e  reason: collision with root package name */
    public d f57627e;

    /* renamed from: f  reason: collision with root package name */
    public b f57628f;

    /* renamed from: g  reason: collision with root package name */
    public p.a f57629g;

    /* renamed from: h  reason: collision with root package name */
    public long f57630h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57631i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57632j;

    /* loaded from: classes2.dex */
    public class a implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ KsAdWebView a;

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
            this.a = ksAdWebView;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                if (this.a.f57625c != null && this.a.f57626d) {
                    com.kwad.sdk.core.response.a.d.j(this.a.f57625c).adConversionInfo.appDownloadUrl = str;
                    this.a.f57625c.isWebViewDownload = true;
                    com.kwad.sdk.core.download.a.a.a(new a.C2015a(this.a.getContext2()).a(this.a.f57625c).c(true));
                    return;
                }
                try {
                    this.a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
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
        this.f57626d = true;
        this.f57631i = true;
        this.f57632j = true;
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
        this.f57626d = true;
        this.f57631i = true;
        this.f57632j = true;
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
        this.f57626d = true;
        this.f57631i = true;
        this.f57632j = true;
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            com.kwad.sdk.core.d.a.e("KsAdWebView", "init");
            setAccessibilityStateDisable(context);
            WebSettings a2 = be.a(this);
            a2.setUseWideViewPort(true);
            a2.setDomStorageEnabled(true);
            setVerticalScrollBarEnabled(false);
            setWebViewClient(new WebViewClient(this) { // from class: com.kwad.sdk.core.page.widget.webview.KsAdWebView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsAdWebView a;

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
                    this.a = this;
                }

                private WebResourceResponse a(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, str)) == null) {
                        try {
                            return com.kwad.sdk.c.c.a().a(str);
                        } catch (Exception e2) {
                            com.kwad.sdk.core.d.a.e(V8ExceptionInfo.V8_EXCEPTION_ERROR, e2.toString());
                            e2.printStackTrace();
                            return null;
                        }
                    }
                    return (WebResourceResponse) invokeL.objValue;
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        super.onPageFinished(webView, str);
                        KsAdWebView ksAdWebView = this.a;
                        if (!ksAdWebView.a) {
                            ksAdWebView.a = true;
                            if (ksAdWebView.f57630h > 0) {
                                if (this.a.f57629g == null) {
                                    this.a.f57629g = new p.a();
                                }
                                this.a.f57629g.t = System.currentTimeMillis() - this.a.f57630h;
                                this.a.f57630h = -1L;
                            }
                            com.kwad.sdk.core.report.a.b(this.a.f57625c, this.a.f57629g);
                        }
                        if (this.a.f57627e != null) {
                            this.a.f57627e.b();
                        }
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                        super.onPageStarted(webView, str, bitmap);
                        if (this.a.f57627e != null) {
                            this.a.f57627e.a();
                        }
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                        super.onReceivedError(webView, i2, str, str2);
                        com.kwad.sdk.core.d.a.a("KsAdWebView", "onReceivedError " + i2);
                        if (this.a.f57627e != null) {
                            this.a.f57627e.a(i2, str, str2);
                        }
                        com.kwad.sdk.core.report.a.d(this.a.f57625c, this.a.f57629g);
                    }
                }

                @Override // android.webkit.WebViewClient
                @TargetApi(21)
                public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048579, this, webView, webResourceRequest)) == null) {
                        if (this.a.f57632j && com.kwad.sdk.core.config.b.J()) {
                            WebResourceResponse a3 = a(webResourceRequest.getUrl().toString());
                            return a3 == null ? super.shouldInterceptRequest(webView, webResourceRequest) : a3;
                        }
                        return super.shouldInterceptRequest(webView, webResourceRequest);
                    }
                    return (WebResourceResponse) invokeLL.objValue;
                }

                @Override // android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, webView, str)) == null) {
                        if (this.a.f57632j && com.kwad.sdk.core.config.b.J()) {
                            WebResourceResponse a3 = a(str);
                            return a3 == null ? super.shouldInterceptRequest(webView, str) : a3;
                        }
                        return super.shouldInterceptRequest(webView, str);
                    }
                    return (WebResourceResponse) invokeLL.objValue;
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048581, this, webView, str)) == null) {
                        com.kwad.sdk.core.d.a.e("KsAdWebView", "shouldOverrideUrlLoading url=" + str);
                        try {
                        } catch (Exception e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                        if (!str.startsWith("http") && !str.startsWith("https")) {
                            if (!str.startsWith("tel:") && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                                if (this.a.f57631i) {
                                    int a3 = com.kwad.sdk.core.download.a.d.a(this.a.getContext(), str);
                                    if (a3 == 1) {
                                        if (this.a.f57628f != null) {
                                            this.a.f57628f.a();
                                        }
                                        com.kwad.sdk.core.report.a.a(this.a.f57625c, 2);
                                        return true;
                                    }
                                    if (this.a.f57628f != null) {
                                        this.a.f57628f.b();
                                    }
                                    if (a3 == -1) {
                                        com.kwad.sdk.core.report.a.b(this.a.f57625c, 2);
                                    }
                                } else if (this.a.f57628f != null) {
                                    this.a.f57628f.b();
                                }
                                return true;
                            }
                            this.a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
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
            return "KSADSDK_V3.3.17.4_" + getContext().getPackageName() + "_" + av.w(getContext());
        }
        return (String) invokeV.objValue;
    }

    public static void setAccessibilityStateDisable(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, null, context) == null) && Build.VERSION.SDK_INT == 17 && context != null) {
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

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f57625c, this.f57629g);
            this.f57630h = System.currentTimeMillis();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            com.kwad.sdk.core.report.a.c(this.f57625c, this.f57629g);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            c cVar = this.f57624b;
            if (cVar != null) {
                cVar.a(this, i2, i3, i4, i5);
            }
        }
    }

    public void setClientParams(p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f57629g = aVar;
        }
    }

    public void setDeepLinkEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f57631i = z;
        }
    }

    public void setDeepLinkListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f57628f = bVar;
        }
    }

    public void setHttpErrorListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f57627e = dVar;
        }
    }

    public void setInsideDownloadEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f57626d = z;
        }
    }

    public void setNeedHybridLoad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f57632j = z;
        }
    }

    public void setOnWebViewScrollChangeListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f57624b = cVar;
        }
    }

    public void setTemplateData(@Nullable AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adTemplate) == null) {
            this.f57625c = adTemplate;
        }
    }
}
