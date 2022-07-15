package com.kwad.components.ad.reward.i;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.at;
/* loaded from: classes5.dex */
public class e extends com.kwad.sdk.core.download.kwai.a implements o.b, u.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public KsAdWebView b;
    public com.kwad.sdk.core.webview.b c;
    public com.kwad.components.core.webview.a e;
    @Nullable
    public com.kwad.components.core.c.a.b f;
    public ab g;
    public com.kwad.sdk.core.webview.a.kwai.a h;
    public f i;
    @Nullable
    public AdTemplate j;
    public final com.kwad.components.ad.reward.c.i k;

    public e(KsAdWebView ksAdWebView, View view2, @Nullable com.kwad.components.core.c.a.b bVar, com.kwad.sdk.core.webview.a.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksAdWebView, view2, bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new com.kwad.components.ad.reward.c.i(this) { // from class: com.kwad.components.ad.reward.i.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.c.i
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.g == null) {
                    return;
                }
                this.a.g.a(true);
            }
        };
        this.a = view2;
        this.b = ksAdWebView;
        this.f = bVar;
        this.h = aVar;
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, aVar, str) == null) {
            aVar.a(new com.kwad.components.core.webview.jshandler.d(this.c, this.f, this.h));
            aVar.a(new com.kwad.components.core.webview.jshandler.i(this.c));
            aVar.a(new com.kwad.components.core.webview.jshandler.h(this.c));
            aVar.a(new com.kwad.components.core.webview.jshandler.u(this, str));
            ab abVar = new ab();
            this.g = abVar;
            aVar.a(abVar);
            aVar.a(new com.kwad.components.core.webview.jshandler.p(this.c));
            aVar.a(new com.kwad.components.core.webview.jshandler.l(this.c));
            aVar.a(new com.kwad.components.core.webview.b.j());
            aVar.a(new com.kwad.components.core.webview.jshandler.o(this.c, this));
            aVar.a(new z(this.c, this.f));
            aVar.a(new com.kwad.components.ad.reward.d.b(this.b.getContext(), this.j, PlayableSource.ACTIONBAR_CLICK));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            if (at.a(str)) {
                b();
                return;
            }
            d();
            this.b.setClientConfig(this.b.getClientConfig().a(this.j).a(c()));
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.b);
            this.e = aVar;
            a(aVar, str);
            this.b.addJavascriptInterface(this.e, "KwaiAd");
            this.b.loadUrl(str);
        }
    }

    private void a(String str, int i) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, str, i) == null) || (fVar = this.i) == null) {
            return;
        }
        fVar.a(str, i);
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            com.kwad.sdk.core.d.b.a("BottomCardWebViewHelper", "switchWebView: " + z);
            KsAdWebView ksAdWebView = this.b;
            if (ksAdWebView == null) {
                return;
            }
            ksAdWebView.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            View view2 = this.a;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            a(false);
        }
    }

    private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, adTemplate, viewGroup) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.c = bVar;
            bVar.a(adTemplate);
            com.kwad.sdk.core.webview.b bVar2 = this.c;
            bVar2.a = 0;
            bVar2.b = null;
            bVar2.d = viewGroup;
            bVar2.e = this.b;
            bVar2.c = null;
            bVar2.g = true;
        }
    }

    @NonNull
    private KsAdWebView.d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.reward.i.e.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                    com.kwad.sdk.core.d.b.a("BottomCardWebViewHelper", "onReceivedHttpError: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
                    this.a.b();
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    private void d() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (aVar = this.e) == null) {
            return;
        }
        aVar.a();
        this.e = null;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.components.core.c.a.b bVar = this.f;
            if (bVar != null) {
                bVar.b(this);
            }
            com.kwad.components.ad.reward.c.a().b(this.k);
        }
    }

    @Override // com.kwad.sdk.core.download.kwai.a
    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            a(com.kwad.sdk.core.response.a.a.b(i), i);
        }
    }

    public final void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.i = fVar;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.o.b
    public final void a(@NonNull o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            com.kwad.sdk.core.d.b.a("BottomCardWebViewHelper", "onAdFrameValid : " + aVar.toJson());
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.u.b
    public final void a(u.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            com.kwad.sdk.core.d.b.a("BottomCardWebViewHelper", getClass().getName() + " updatePageStatus: " + aVar);
            if (aVar.a == 1) {
                a(true);
            } else {
                b();
            }
        }
    }

    public final void a(AdTemplate adTemplate, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, adTemplate, viewGroup) == null) {
            KsAdWebView ksAdWebView = this.b;
            if (ksAdWebView != null) {
                ksAdWebView.setBackgroundColor(0);
                if (this.b.getBackground() != null) {
                    this.b.getBackground().setAlpha(0);
                }
            }
            com.kwad.components.ad.reward.c.a().a(this.k);
            this.j = adTemplate;
            b(adTemplate, viewGroup);
            a(com.kwad.sdk.core.response.a.b.a(this.j));
            com.kwad.components.core.c.a.b bVar = this.f;
            if (bVar != null) {
                bVar.a(this);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AdTemplate adTemplate = this.j;
            a(adTemplate != null ? com.kwad.sdk.core.response.a.a.H(com.kwad.sdk.core.response.a.d.i(adTemplate)) : "立即下载", 100);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            AdTemplate adTemplate = this.j;
            a(adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.a(adTemplate), 100);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AdTemplate adTemplate = this.j;
            a(adTemplate != null ? com.kwad.sdk.core.response.a.a.H(com.kwad.sdk.core.response.a.d.i(adTemplate)) : "立即下载", 100);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AdTemplate adTemplate = this.j;
            a(adTemplate != null ? com.kwad.sdk.core.response.a.a.n(com.kwad.sdk.core.response.a.d.i(adTemplate)) : "立即打开", 100);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || i == 0) {
            return;
        }
        a(com.kwad.sdk.core.response.a.a.a(i), i);
    }
}
