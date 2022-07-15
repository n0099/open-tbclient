package com.kwad.components.core.webview.kwai;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class c extends com.kwad.components.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;
    public long c;
    public boolean d;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public AdTemplate b;
        public KsAdWebView.d c;
        public KsAdWebView.b d;
        public u.b e;
        public boolean f;
        public KsAdWebView.c g;
        public boolean h;
        public boolean i;
        public boolean j;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = true;
            this.h = true;
            this.i = true;
            this.a = context;
        }

        public final a a(KsAdWebView.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                this.d = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(KsAdWebView.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.g = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(KsAdWebView.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
                this.c = dVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(u.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
                this.e = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, adTemplate)) == null) {
                this.b = adTemplate;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.h = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final AdTemplate a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (AdTemplate) invokeV.objValue;
        }

        public final Context b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (Context) invokeV.objValue;
        }

        public final a b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.f = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final KsAdWebView.d c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : (KsAdWebView.d) invokeV.objValue;
        }

        public final a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.j = true;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final KsAdWebView.b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.d : (KsAdWebView.b) invokeV.objValue;
        }

        public final u.b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.e : (u.b) invokeV.objValue;
        }

        public final boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.h : invokeV.booleanValue;
        }

        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.i : invokeV.booleanValue;
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f : invokeV.booleanValue;
        }

        public final KsAdWebView.c i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.g : (KsAdWebView.c) invokeV.objValue;
        }

        public final boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.j : invokeV.booleanValue;
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (a) invokeV.objValue;
    }

    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.c = j;
        }
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.b = aVar;
            a(aVar.g());
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.a = str;
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) {
            super.onPageFinished(webView, str);
            com.kwad.components.a.b.b.a(this.a, "onPageFinished");
            a aVar = this.b;
            if (aVar != null && aVar.j() && !this.d) {
                this.d = true;
                if (this.c > 0) {
                    if (this.b.e() == null) {
                        this.b.a(new u.b());
                    }
                    this.b.e().v = System.currentTimeMillis() - this.c;
                    this.c = -1L;
                }
                com.kwad.sdk.core.report.a.b(this.b.a(), this.b.e());
            }
            a aVar2 = this.b;
            if (aVar2 == null || aVar2.c() == null) {
                return;
            }
            this.b.c().b();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
            com.kwad.components.a.b.b.a(this.a, "onPageStart");
            a aVar = this.b;
            if (aVar == null || aVar.c() == null) {
                return;
            }
            this.b.c().a();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048582, this, webView, i, str, str2) == null) {
            super.onReceivedError(webView, i, str, str2);
            com.kwad.sdk.core.d.b.a("KsAdWebViewClient", "onReceivedError " + i);
            a aVar = this.b;
            if (aVar != null && aVar.c() != null) {
                this.b.c().a(i, str);
            }
            com.kwad.components.a.b.b.b(str2, str);
            a aVar2 = this.b;
            if (aVar2 == null || !aVar2.j()) {
                return;
            }
            com.kwad.sdk.core.report.a.d(this.b.a(), this.b.e());
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, renderProcessGoneDetail)) == null) {
            return (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) || super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str)) == null) {
            com.kwad.sdk.core.d.b.e("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
            com.kwad.components.a.b.b.a(this.a, "shouldOverrideUrlLoading");
            try {
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.a(e);
            }
            if (!str.startsWith("http") && !str.startsWith("https")) {
                if (!str.startsWith("tel:") && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                    if (this.b != null && this.b.f()) {
                        int a2 = com.kwad.sdk.core.download.kwai.b.a(this.b.b(), str);
                        if (a2 == 1) {
                            if (this.b.d() != null) {
                                this.b.d().a();
                            }
                            com.kwad.sdk.core.report.a.c(this.b.a(), 2);
                            return true;
                        }
                        if (this.b.d() != null) {
                            this.b.d().b();
                        }
                        if (a2 == -1) {
                            com.kwad.sdk.core.report.a.d(this.b.a(), 2);
                        }
                    }
                    return true;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (this.b != null) {
                    this.b.b().startActivity(intent);
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return invokeLL.booleanValue;
    }
}
