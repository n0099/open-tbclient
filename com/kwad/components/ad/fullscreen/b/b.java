package com.kwad.components.ad.fullscreen.b;

import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.fullscreen.b.kwai.f;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.presenter.d;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.ad.reward.presenter.h;
import com.kwad.components.ad.reward.presenter.i;
import com.kwad.components.ad.reward.presenter.n;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
/* loaded from: classes5.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements e, com.kwad.components.ad.reward.g.b, e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.fullscreen.b er;
    public ViewGroup es;
    public com.kwad.components.core.g.b et;
    public n eu;

    public b(com.kwad.components.core.g.b bVar, ViewGroup viewGroup, com.kwad.components.ad.fullscreen.b bVar2, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, viewGroup, bVar2, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.et = bVar;
        this.er = bVar2;
        this.es = viewGroup;
        this.nM = kVar;
        kVar.a((e.a) this);
        this.nM.a((e.b) this);
        bF();
    }

    private void bF() {
        com.kwad.components.ad.fullscreen.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (bVar = this.er) == null) {
            return;
        }
        AdTemplate adTemplate = bVar.getAdTemplate();
        AdInfo by = this.er.by();
        boolean z = this.er.bz() && !ag.zL();
        a(new r());
        if (com.kwad.sdk.core.response.a.a.ao(by)) {
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
        n nVar = new n(adTemplate, false, false);
        this.eu = nVar;
        a(nVar);
        a(new com.kwad.components.ad.reward.presenter.a.b(adTemplate, false));
        a(new com.kwad.components.ad.reward.presenter.kwai.a());
        a(new d(adTemplate, by, this.es));
        a(new h());
        if (com.kwad.sdk.core.response.a.b.bB(adTemplate)) {
            a(new f());
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            this.nM.a((com.kwad.components.ad.reward.d.e) this);
        }
    }

    @Override // com.kwad.components.ad.reward.d.e
    public final void bA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.nM.F(true);
        }
    }

    public final boolean bG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            n nVar = this.eu;
            if (nVar != null) {
                return nVar.bG();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean bH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            n nVar = this.eu;
            return nVar != null && nVar.bH();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.e.b
    public final void bI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.kwad.components.ad.reward.g.a.a(getActivity(), this, this.nM.mAdTemplate);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.e.a
    public final boolean bJ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.g.b
    public final void bK() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.nM.mAdOpenInteractionListener.j(false);
            gR();
        }
    }

    @Override // com.kwad.components.ad.reward.g.c
    public final void onPlayAgainClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.nM.fu();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onUnbind();
            this.nM.b(this);
        }
    }
}
