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
import com.kwad.sdk.utils.ag;
/* loaded from: classes5.dex */
public final class p extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.d.e, com.kwad.components.ad.reward.g.b, e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup es;
    public com.kwad.components.ad.reward.presenter.n eu;
    public com.kwad.components.ad.reward.model.c mModel;
    public k nM;
    @Nullable
    public a nN;
    @Nullable
    public com.kwad.components.ad.reward.presenter.p nO;

    /* loaded from: classes5.dex */
    public interface a {
        void onUnbind();
    }

    public p(com.kwad.components.core.g.b bVar, ViewGroup viewGroup, com.kwad.components.ad.reward.model.c cVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, viewGroup, cVar, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.es = viewGroup;
        this.mModel = cVar;
        this.nM = kVar;
        kVar.a((e.a) this);
        this.nM.a((e.b) this);
        a(bVar, cVar);
    }

    private void a(com.kwad.components.core.g.b bVar, com.kwad.components.ad.reward.model.c cVar) {
        com.kwad.components.ad.reward.model.c cVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, this, bVar, cVar) == null) || (cVar2 = this.mModel) == null) {
            return;
        }
        AdInfo by = cVar2.by();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        a(new com.kwad.components.ad.reward.presenter.r());
        if (com.kwad.sdk.core.response.a.a.ao(by)) {
            a(new com.kwad.components.ad.reward.presenter.c());
        }
        a(new com.kwad.components.ad.reward.presenter.i());
        a(new com.kwad.components.ad.reward.presenter.f());
        a(new com.kwad.components.ad.reward.presenter.platdetail.b());
        a(new com.kwad.components.ad.reward.presenter.platdetail.kwai.e());
        a(new com.kwad.components.ad.reward.presenter.c.b());
        boolean gL = cVar.gL();
        boolean gM = cVar.gM();
        boolean z = cVar.bz() && !ag.zL();
        if (!gL && !gM && !z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c());
        }
        a(new com.kwad.components.ad.reward.presenter.j());
        com.kwad.components.ad.reward.presenter.n nVar = new com.kwad.components.ad.reward.presenter.n(adTemplate);
        this.eu = nVar;
        a(nVar);
        a(new com.kwad.components.ad.reward.presenter.b(by));
        a(new com.kwad.components.ad.reward.presenter.a.b(adTemplate, true));
        a(new com.kwad.components.ad.reward.presenter.kwai.a());
        a(new com.kwad.components.ad.reward.presenter.q());
        a(new com.kwad.components.ad.reward.presenter.d(adTemplate, by, this.es));
        if (t(adTemplate)) {
            com.kwad.components.ad.reward.presenter.p pVar = new com.kwad.components.ad.reward.presenter.p();
            this.nO = pVar;
            a(pVar);
        }
        a(new com.kwad.components.ad.reward.presenter.h());
    }

    public static boolean t(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            return com.kwad.sdk.core.response.a.a.bP(bQ) && !(com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(bQ)) || com.kwad.sdk.core.response.a.d.p(adTemplate));
        }
        return invokeL.booleanValue;
    }

    public final void a(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.nN = aVar;
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            this.nM.a((com.kwad.components.ad.reward.d.e) this);
            com.kwad.components.ad.reward.b.a.gp().setCallerContext(this.nM);
        }
    }

    @Override // com.kwad.components.ad.reward.d.e
    public final void bA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.nM.F(true);
        }
    }

    public final boolean bH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            com.kwad.components.ad.reward.presenter.n nVar = this.eu;
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
            com.kwad.components.ad.reward.presenter.p pVar = this.nO;
            if (pVar == null) {
                return false;
            }
            if (pVar.isRefluxVisible()) {
                return true;
            }
            return this.nO.hm();
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

    public final BackPressHandleResult fS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            com.kwad.components.ad.reward.presenter.n nVar = this.eu;
            if (nVar == null || !nVar.bG()) {
                com.kwad.components.ad.reward.presenter.p pVar = this.nO;
                return pVar != null ? pVar.fS() : BackPressHandleResult.NOT_HANDLED;
            }
            return BackPressHandleResult.HANDLED;
        }
        return (BackPressHandleResult) invokeV.objValue;
    }

    public final boolean isRefluxVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.kwad.components.ad.reward.presenter.p pVar = this.nO;
            return pVar != null && pVar.isRefluxVisible();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.g.c
    public final void onPlayAgainClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.nM.fu();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onUnbind();
            this.nM.b(this);
            a aVar = this.nN;
            if (aVar != null) {
                aVar.onUnbind();
            }
            com.kwad.components.ad.reward.b.a.gp().reset();
        }
    }
}
