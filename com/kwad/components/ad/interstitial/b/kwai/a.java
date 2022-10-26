package com.kwad.components.ad.interstitial.b.kwai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.webview.b.a.q;
import com.kwad.components.core.webview.b.d;
import com.kwad.components.core.webview.b.e;
import com.kwad.components.core.webview.b.kwai.i;
import com.kwad.components.core.webview.b.kwai.j;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.sdk.components.h;
/* loaded from: classes7.dex */
public abstract class a extends com.kwad.components.ad.interstitial.b.b implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d hN;

    public a() {
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

    @Override // com.kwad.components.core.webview.b.e
    public final void a(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar) == null) {
            com.kwad.components.core.webview.b.a.i iVar2 = new com.kwad.components.core.webview.b.a.i();
            iVar2.NR = !this.gh.cN.isVideoSoundEnable();
            iVar.c(iVar2);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public void a(aa aaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aaVar) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public void a(h hVar, com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, hVar, bVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.aq();
            this.hN.a(getActivity(), this.gh.mAdTemplate, this);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(com.kwad.components.core.webview.b.a.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final com.kwad.sdk.widget.e dD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.gh.gq : (com.kwad.sdk.widget.e) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.e
    public void dE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final com.kwad.sdk.core.webview.a.kwai.a getClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.interstitial.b.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a hO;

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
                this.hO = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.hO.gh.gl = true;
                    this.hO.gh.fo.onAdClicked();
                }
            }
        } : (com.kwad.sdk.core.webview.a.kwai.a) invokeV.objValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onCreate();
            this.hN = new d(-1L, getContext());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onUnbind();
            this.hN.pF();
        }
    }
}
