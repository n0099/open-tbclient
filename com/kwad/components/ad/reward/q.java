package com.kwad.components.ad.reward;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ae;
/* loaded from: classes5.dex */
public final class q extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.c.f, com.kwad.components.ad.reward.e.b, e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.model.c b;
    public ViewGroup c;
    public l d;
    @Nullable
    public a e;
    @Nullable
    public com.kwad.components.ad.reward.presenter.p f;
    public com.kwad.components.ad.reward.presenter.n g;

    /* loaded from: classes5.dex */
    public interface a {
        void onUnbind();
    }

    public q(com.kwad.components.core.g.b bVar, ViewGroup viewGroup, com.kwad.components.ad.reward.model.c cVar, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, viewGroup, cVar, lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = viewGroup;
        this.b = cVar;
        this.d = lVar;
        lVar.a((e.a) this);
        this.d.a((e.b) this);
        a(bVar, cVar);
    }

    private void a(com.kwad.components.core.g.b bVar, com.kwad.components.ad.reward.model.c cVar) {
        com.kwad.components.ad.reward.model.c cVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, this, bVar, cVar) == null) || (cVar2 = this.b) == null) {
            return;
        }
        AdInfo e = cVar2.e();
        AdTemplate d = this.b.d();
        a(new com.kwad.components.ad.reward.presenter.r());
        if (com.kwad.sdk.core.response.a.a.K(e)) {
            a(new com.kwad.components.ad.reward.presenter.c());
        }
        a(new com.kwad.components.ad.reward.presenter.i());
        a(new com.kwad.components.ad.reward.presenter.f());
        a(new com.kwad.components.ad.reward.presenter.platdetail.b());
        a(new com.kwad.components.ad.reward.presenter.platdetail.kwai.e());
        a(new com.kwad.components.ad.reward.presenter.c.b());
        boolean a2 = cVar.a();
        boolean b = cVar.b();
        boolean z = cVar.c() && !ae.a();
        if (!a2 && !b && !z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c());
        }
        a(new com.kwad.components.ad.reward.presenter.j());
        com.kwad.components.ad.reward.presenter.n nVar = new com.kwad.components.ad.reward.presenter.n(d);
        this.g = nVar;
        a((Presenter) nVar);
        a(new com.kwad.components.ad.reward.presenter.b(e));
        a(new com.kwad.components.ad.reward.presenter.a.b(d, true));
        a(new com.kwad.components.ad.reward.presenter.kwai.a());
        a(new com.kwad.components.ad.reward.presenter.q());
        a(new com.kwad.components.ad.reward.presenter.d(d, e, this.c));
        if (a(d)) {
            com.kwad.components.ad.reward.presenter.p pVar = new com.kwad.components.ad.reward.presenter.p();
            this.f = pVar;
            a((Presenter) pVar);
        }
        a(new com.kwad.components.ad.reward.presenter.h());
    }

    public static boolean a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) {
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            return com.kwad.sdk.core.response.a.a.bf(i) && !(com.kwad.sdk.core.response.a.d.a(adTemplate, com.kwad.components.ad.reward.kwai.b.d(i)) || com.kwad.sdk.core.response.a.d.q(adTemplate));
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.d.a((com.kwad.components.ad.reward.c.f) this);
        }
    }

    public final void a(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.e = aVar;
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.e.b
    public final void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.kwad.components.ad.reward.e.a.a(s(), this, this.d.g);
        }
    }

    public final BackPressHandleResult d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            com.kwad.components.ad.reward.presenter.n nVar = this.g;
            if (nVar == null || !nVar.g()) {
                com.kwad.components.ad.reward.presenter.p pVar = this.f;
                return pVar != null ? pVar.g() : BackPressHandleResult.NOT_HANDLED;
            }
            return BackPressHandleResult.HANDLED;
        }
        return (BackPressHandleResult) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.c.f
    public final void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d.e(true);
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            com.kwad.components.ad.reward.presenter.p pVar = this.f;
            return pVar != null && pVar.h();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.e.a
    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            com.kwad.components.ad.reward.presenter.p pVar = this.f;
            if (pVar == null) {
                return false;
            }
            if (pVar.h()) {
                return true;
            }
            return this.f.e();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.e.b
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d.b.a(false);
            j();
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.kwad.components.ad.reward.presenter.n nVar = this.g;
            return nVar != null && nVar.h();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.k_();
            this.d.b(this);
            a aVar = this.e;
            if (aVar != null) {
                aVar.onUnbind();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.e.c
    public final void onPlayAgainClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d.e();
        }
    }
}
