package com.kwad.components.ad.reward.f.kwai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.webview.b.kwai.h;
import com.kwad.components.core.webview.b.kwai.p;
import com.kwad.components.core.webview.b.s;
import com.kwad.components.core.webview.b.t;
import com.kwad.sdk.components.g;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.e;
/* loaded from: classes5.dex */
public abstract class a extends Presenter implements com.kwad.components.ad.reward.f.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public com.kwad.components.ad.reward.f.b b;

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

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            b bVar = (b) t();
            this.a = bVar;
            this.b.a(bVar.e, bVar.c, this);
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void a(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public void a(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void a(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public void a(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void a(g gVar, com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, bVar) == null) {
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.i_();
            this.b = new com.kwad.components.ad.reward.f.b(u());
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final e k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.b : (e) invokeV.objValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.k_();
            this.b.a();
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final com.kwad.sdk.core.webview.a.kwai.a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (com.kwad.sdk.core.webview.a.kwai.a) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void n() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (dVar = this.a.a) == null) {
            return;
        }
        dVar.dismiss();
    }
}
