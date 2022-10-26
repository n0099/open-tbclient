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
/* loaded from: classes7.dex */
public final class c extends com.kwad.components.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long KK;
    public boolean KQ;
    public a gX;

    /* loaded from: classes7.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean KN;
        public boolean KP;
        public KsAdWebView.b KR;
        public u.b KS;
        public boolean KT;
        public KsAdWebView.c KU;
        public boolean KV;
        public AdTemplate mAdTemplate;
        public final Context mContext;
        public KsAdWebView.d rb;

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
            this.KT = true;
            this.KV = true;
            this.KP = true;
            this.mContext = context;
        }

        public final a R(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adTemplate)) == null) {
                this.mAdTemplate = adTemplate;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(KsAdWebView.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
                this.KR = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(KsAdWebView.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                this.KU = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a aA(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.KV = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final a aB(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.KT = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final a aC(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.KN = true;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final a b(KsAdWebView.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dVar)) == null) {
                this.rb = dVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a b(u.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
                this.KS = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final AdTemplate getAdTemplate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mAdTemplate : (AdTemplate) invokeV.objValue;
        }

        public final u.b getClientParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.KS : (u.b) invokeV.objValue;
        }

        public final Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mContext : (Context) invokeV.objValue;
        }

        public final KsAdWebView.c getOnWebViewScrollChangeListener() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.KU : (KsAdWebView.c) invokeV.objValue;
        }

        public final KsAdWebView.d getWebListener() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.rb : (KsAdWebView.d) invokeV.objValue;
        }

        public final KsAdWebView.b kS() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.KR : (KsAdWebView.b) invokeV.objValue;
        }

        public final boolean pq() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.KV : invokeV.booleanValue;
        }

        public final boolean pr() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.KP : invokeV.booleanValue;
        }

        public final boolean ps() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.KT : invokeV.booleanValue;
        }

        public final boolean pt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.KN : invokeV.booleanValue;
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

    public final void aC(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.mUniqueId = str;
        }
    }

    public final a getClientConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.gX : (a) invokeV.objValue;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
            super.onPageFinished(webView, str);
            com.kwad.components.a.b.b.r(this.mUniqueId, "onPageFinished");
            a aVar = this.gX;
            if (aVar != null && aVar.pt() && !this.KQ) {
                this.KQ = true;
                if (this.KK > 0) {
                    if (this.gX.getClientParams() == null) {
                        this.gX.b(new u.b());
                    }
                    this.gX.getClientParams().abR = System.currentTimeMillis() - this.KK;
                    this.KK = -1L;
                }
                com.kwad.sdk.core.report.a.c(this.gX.getAdTemplate(), this.gX.getClientParams());
            }
            a aVar2 = this.gX;
            if (aVar2 == null || aVar2.getWebListener() == null) {
                return;
            }
            this.gX.getWebListener().bw();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
            com.kwad.components.a.b.b.r(this.mUniqueId, "onPageStart");
            a aVar = this.gX;
            if (aVar == null || aVar.getWebListener() == null) {
                return;
            }
            this.gX.getWebListener().bv();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, webView, i, str, str2) == null) {
            super.onReceivedError(webView, i, str, str2);
            com.kwad.sdk.core.e.b.d("KsAdWebViewClient", "onReceivedError " + i);
            a aVar = this.gX;
            if (aVar != null && aVar.getWebListener() != null) {
                this.gX.getWebListener().a(i, str, str2);
            }
            com.kwad.components.a.b.b.t(str2, str);
            a aVar2 = this.gX;
            if (aVar2 == null || !aVar2.pt()) {
                return;
            }
            com.kwad.sdk.core.report.a.e(this.gX.getAdTemplate(), this.gX.getClientParams());
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, renderProcessGoneDetail)) == null) {
            return (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) || super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        return invokeLL.booleanValue;
    }

    public final void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.KK = j;
        }
    }

    public final void setClientConfig(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.gX = aVar;
            setNeedHybridLoad(aVar.pr());
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str)) == null) {
            com.kwad.sdk.core.e.b.e("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
            com.kwad.components.a.b.b.r(this.mUniqueId, "shouldOverrideUrlLoading");
            try {
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
            if (!str.startsWith("http") && !str.startsWith("https")) {
                if (!str.startsWith("tel:") && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                    if (this.gX != null && this.gX.pq()) {
                        int s = com.kwad.sdk.core.download.kwai.b.s(this.gX.getContext(), str);
                        if (s == 1) {
                            if (this.gX.kS() != null) {
                                this.gX.kS().onSuccess();
                            }
                            com.kwad.sdk.core.report.a.j(this.gX.getAdTemplate(), 2);
                            return true;
                        }
                        if (this.gX.kS() != null) {
                            this.gX.kS().kU();
                        }
                        if (s == -1) {
                            com.kwad.sdk.core.report.a.k(this.gX.getAdTemplate(), 2);
                        }
                    }
                    return true;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (this.gX != null) {
                    this.gX.getContext().startActivity(intent);
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return invokeLL.booleanValue;
    }
}
