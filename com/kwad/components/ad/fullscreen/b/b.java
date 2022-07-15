package com.kwad.components.ad.fullscreen.b;

import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.ad.reward.l;
import com.kwad.components.ad.reward.presenter.d;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.ad.reward.presenter.h;
import com.kwad.components.ad.reward.presenter.i;
import com.kwad.components.ad.reward.presenter.n;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ae;
/* loaded from: classes5.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements f, com.kwad.components.ad.reward.e.b, e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.fullscreen.b b;
    public ViewGroup c;
    public com.kwad.components.core.g.b d;
    public n e;

    public b(com.kwad.components.core.g.b bVar, ViewGroup viewGroup, com.kwad.components.ad.fullscreen.b bVar2, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, viewGroup, bVar2, lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = bVar;
        this.b = bVar2;
        this.c = viewGroup;
        ((com.kwad.components.ad.reward.presenter.a) this).a = lVar;
        lVar.a((e.a) this);
        ((com.kwad.components.ad.reward.presenter.a) this).a.a((e.b) this);
        i();
    }

    private void i() {
        com.kwad.components.ad.fullscreen.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (bVar = this.b) == null) {
            return;
        }
        AdTemplate a = bVar.a();
        AdInfo b = this.b.b();
        boolean z = this.b.c() && !ae.a();
        a(new r());
        if (com.kwad.sdk.core.response.a.a.K(b)) {
            a(new com.kwad.components.ad.reward.presenter.c());
        }
        a(new i());
        a(new com.kwad.components.ad.reward.presenter.platdetail.b());
        a(new c());
        a(new com.kwad.components.ad.reward.presenter.c.b());
        if (!z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c());
        }
        a(new a());
        n nVar = new n(a, false, false);
        this.e = nVar;
        a((Presenter) nVar);
        a(new com.kwad.components.ad.reward.presenter.a.b(a, false));
        a(new com.kwad.components.ad.reward.presenter.kwai.a());
        a(new d(a, b, this.c));
        a(new h());
        if (com.kwad.sdk.core.response.a.b.D(a)) {
            a(new com.kwad.components.ad.fullscreen.b.kwai.f());
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((com.kwad.components.ad.reward.presenter.a) this).a.a((f) this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.e.b
    public final void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.kwad.components.ad.reward.e.a.a(s(), this, ((com.kwad.components.ad.reward.presenter.a) this).a.g);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            n nVar = this.e;
            if (nVar != null) {
                return nVar.g();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.c.f
    public final void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.e(true);
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            n nVar = this.e;
            return nVar != null && nVar.h();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.e.a
    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.e.b
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.b.a(false);
            j();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.k_();
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this);
        }
    }

    @Override // com.kwad.components.ad.reward.e.c
    public final void onPlayAgainClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.e();
        }
    }
}
