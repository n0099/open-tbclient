package com.kwad.components.ad.e.b;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.g;
import com.kwad.components.core.widget.kwai.b;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.k;
/* loaded from: classes7.dex */
public final class a extends com.kwad.components.ad.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b aM;
    public final com.kwad.sdk.core.h.b bX;
    public KsAdVideoPlayConfig cN;
    public boolean dt;
    public h.a dv;
    public boolean hasNoCache;
    public boolean km;
    public boolean kn;
    public com.kwad.components.core.video.h ko;
    public final AdInfo mAdInfo;
    public Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AdTemplate adTemplate, b bVar, DetailVideoView detailVideoView, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, bVar, detailVideoView, ksAdVideoPlayConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AdTemplate) objArr2[0], (DetailVideoView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hasNoCache = false;
        this.bX = new com.kwad.sdk.core.h.b(this) { // from class: com.kwad.components.ad.e.b.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a kq;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.kq = this;
            }

            @Override // com.kwad.sdk.core.h.b
            public final void aR() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.kq.resume();
                }
            }

            @Override // com.kwad.sdk.core.h.b
            public final void aS() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.kq.pause();
                }
            }
        };
        this.dv = new h.a(this) { // from class: com.kwad.components.ad.e.b.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a kq;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.kq = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.kq.dt = false;
                    this.kq.setAudioEnabled(false);
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.aM = bVar;
        this.mAdInfo = d.bQ(this.mAdTemplate);
        this.km = (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) ? com.kwad.sdk.core.response.a.a.bh(this.mAdInfo) : ksAdVideoPlayConfig.isVideoSoundEnable();
        this.cN = ksAdVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        if (ksAdVideoPlayConfig != null) {
            try {
                this.hasNoCache = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            }
        }
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h(this, adTemplate) { // from class: com.kwad.components.ad.e.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate kp;
            public final /* synthetic */ a kq;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this, adTemplate};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.kq = this;
                this.kp = adTemplate;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) {
                    super.onVideoPlayError(i3, i4);
                    com.kwad.components.core.j.a.og().b(this.kp, i3, i4);
                }
            }
        };
        this.ko = hVar;
        this.BL.c(hVar);
        aQ();
        this.BL.a(new c.e(this) { // from class: com.kwad.components.ad.e.b.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a kq;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.kq = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) && this.kq.ew() && this.kq.aM.dK()) {
                    this.kq.BL.a(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.kq.mAdTemplate));
                    this.kq.BL.start();
                }
            }
        });
    }

    private void aQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.BL.a(new b.a(this.mAdTemplate).bk(d.bS(this.mAdTemplate)).bl(f.b(d.bR(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).aJ(this.hasNoCache).b(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate)).rC(), true, true, this.mDetailVideoView);
            setAudioEnabled(h(this.km));
            if (ew()) {
                this.BL.prepareAsync();
                com.kwad.components.core.m.b.at(this.mContext).a(this.dv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.kn) {
                return true;
            }
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.cN;
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                    return ae.isNetworkConnected(this.mContext);
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                    return ae.isWifiConnected(this.mContext);
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                    return false;
                }
                if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                    return ae.isWifiConnected(this.mContext) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ae.isMobileConnected(this.mContext));
                }
            }
            if (com.kwad.sdk.core.response.a.a.bi(this.mAdInfo) && ae.isNetworkConnected(this.mContext)) {
                return true;
            }
            return com.kwad.sdk.core.response.a.a.bj(this.mAdInfo) && ae.isWifiConnected(this.mContext);
        }
        return invokeV.booleanValue;
    }

    private boolean h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, this, z)) == null) {
            if (z) {
                if (!com.kwad.sdk.core.config.d.fY()) {
                    return !com.kwad.components.core.m.b.at(this.mContext).ow() ? com.kwad.components.core.m.b.at(this.mContext).ay(false) : !com.kwad.components.core.m.b.at(this.mContext).ov();
                }
                if (!this.dt) {
                    this.dt = com.kwad.components.core.m.b.at(this.mContext).ay(true);
                }
                return this.dt;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
            com.kwad.components.core.video.b bVar = this.BL;
            float f = z ? 1.0f : 0.0f;
            bVar.setVolume(f, f);
        }
    }

    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null) {
            return;
        }
        this.BL.c(gVar);
    }

    public final void aO() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k.cj(this.mAdTemplate);
            if (this.BL.oT() == null) {
                aQ();
            }
            if (ew() && this.aM.dK()) {
                this.BL.a(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate));
                this.BL.start();
            }
            this.aM.a(this.bX);
        }
    }

    public final void aP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k.ch(this.mAdTemplate);
            this.aM.b(this.bX);
            this.BL.release();
            com.kwad.components.core.m.b.at(this.mContext).b(this.dv);
        }
    }

    public final void b(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || gVar == null) {
            return;
        }
        this.BL.d(gVar);
    }

    public final void ex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.kn = true;
            if (this.aM.dK()) {
                k.ci(this.mAdTemplate);
                this.BL.a(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate));
                this.BL.start();
            }
        }
    }

    public final void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.BL.pause();
        }
    }

    @Override // com.kwad.components.ad.h.a
    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.release();
            com.kwad.components.core.video.b bVar = this.BL;
            if (bVar != null) {
                bVar.clear();
                this.BL.release();
            }
        }
    }

    public final void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setAudioEnabled(h(this.km));
            if (ew()) {
                this.BL.resume();
            }
        }
    }
}
