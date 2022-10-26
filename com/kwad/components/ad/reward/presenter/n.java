package com.kwad.components.ad.reward.presenter;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public final class n extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.d.e, com.kwad.components.ad.reward.d.f, x.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float pY;
    public boolean qn;
    public a qo;
    public m qp;
    public k qq;
    public l qr;
    public int qs;
    public boolean qt;
    public boolean qu;
    public boolean qv;
    public boolean qw;

    /* loaded from: classes7.dex */
    public final class a extends com.kwad.components.core.video.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long qx;
        public final /* synthetic */ n qy;
        public long videoDuration;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.qy = nVar;
        }

        public /* synthetic */ a(n nVar, byte b) {
            this(nVar);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                super.onVideoPlayProgress(j, j2);
                this.qx = j2;
                this.videoDuration = j;
                if (this.qy.qu) {
                    return;
                }
                this.qy.a(j, j2, false);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(AdTemplate adTemplate) {
        this(adTemplate, true, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((AdTemplate) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public n(AdTemplate adTemplate, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.qs = 0;
        this.qt = false;
        this.qu = false;
        this.qv = true;
        this.qw = true;
        this.qv = z;
        this.qw = z2;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (!com.kwad.sdk.core.response.a.a.aY(bQ)) {
            if (com.kwad.sdk.core.response.a.a.aZ(bQ)) {
                return;
            }
            com.kwad.components.core.j.a.og().P(adTemplate);
            return;
        }
        l lVar = new l();
        this.qr = lVar;
        a(lVar);
        if (this.qw) {
            m mVar = new m(this);
            this.qp = mVar;
            a(mVar);
        }
        if (this.qv) {
            k kVar = new k(this);
            this.qq = kVar;
            a(kVar);
        }
        a(new com.kwad.components.ad.reward.presenter.b.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2, boolean z) {
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            if (hf() && j2 >= 10000 && ((float) j2) >= ((float) j) * this.pY) {
                if (!com.kwad.components.ad.reward.kwai.b.gd()) {
                    k kVar = this.qq;
                    if (kVar != null) {
                        kVar.M(!z);
                        this.qs = 2;
                    }
                } else if (this.qt || (mVar = this.qp) == null) {
                } else {
                    mVar.hb();
                    this.qs = 1;
                    this.qt = true;
                }
            }
        }
    }

    private boolean hf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.qn : invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void a(PlayableSource playableSource, com.kwad.components.ad.reward.d.j jVar) {
        k kVar;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, playableSource, jVar) == null) {
            this.qu = true;
            if (this.qs == 1 && (mVar = this.qp) != null) {
                mVar.hc();
            } else if (this.qs != 2 || (kVar = this.qq) == null) {
            } else {
                kVar.hide();
            }
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.x.b
    public final void a(x.a aVar) {
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            boolean isSuccess = aVar.isSuccess();
            this.qn = isSuccess;
            if (!isSuccess || (aVar2 = this.qo) == null) {
                return;
            }
            a(aVar2.videoDuration, this.qo.qx, false);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.aq();
            this.nM.a(this);
            com.kwad.components.core.playable.a aVar = this.nM.mk;
            if (aVar != null) {
                aVar.a(this);
            }
            boolean gc = com.kwad.components.ad.reward.kwai.b.gc();
            this.pY = com.kwad.components.ad.reward.kwai.b.gb();
            if (gc) {
                a aVar2 = new a(this, (byte) 0);
                this.qo = aVar2;
                this.nM.eF.a(aVar2);
            }
            com.kwad.components.ad.reward.b.eV().a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.d.e
    public final void bA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RewardActionBarControl.ShowActionBarResult hx = this.nM.ml.hx();
            if (hx != null) {
                hx.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
            }
            if (this.qr == null || this.nM.fA()) {
                return;
            }
            if (hf()) {
                this.qr.e(PlayableSource.PLAY_FINISHED_NORMAL);
            } else {
                this.qr.ha();
            }
        }
    }

    public final boolean bG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            boolean fD = this.nM.fD();
            if (!this.qu || fD) {
                return false;
            }
            com.kwad.components.ad.reward.b.eV().eW();
            this.qu = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean bH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.qu : invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bO() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.qu = false;
            a aVar = this.qo;
            if (aVar == null || this.qs != 2) {
                return;
            }
            a(aVar.videoDuration, this.qo.qx, true);
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onUnbind();
            this.nM.b(this);
            com.kwad.components.core.playable.a aVar = this.nM.mk;
            if (aVar != null) {
                aVar.b(this);
            }
            a aVar2 = this.qo;
            if (aVar2 != null) {
                this.nM.eF.b(aVar2);
            }
            com.kwad.components.ad.reward.b.eV().b(this);
        }
    }
}
