package com.kwad.components.ad.reward.presenter;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class i extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.j.a eF;
    @NonNull
    public com.kwad.components.ad.reward.d.a mAdOpenInteractionListener;
    public final com.kwad.components.core.video.g mVideoPlayStateListener;
    public long pQ;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mVideoPlayStateListener = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.presenter.i.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i pR;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.pR = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    i iVar = this.pR;
                    com.kwad.components.ad.reward.k kVar = iVar.nM;
                    if (kVar.mz && kVar.mC) {
                        iVar.mAdOpenInteractionListener.onVideoSkipToEnd(this.pR.pQ);
                    } else {
                        this.pR.mAdOpenInteractionListener.onVideoPlayEnd();
                    }
                    e.k(this.pR.nM);
                    com.kwad.components.ad.reward.k kVar2 = this.pR.nM;
                    if (kVar2.mQ) {
                        com.kwad.components.ad.reward.n.g(kVar2);
                    }
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4) == null) {
                    this.pR.mAdOpenInteractionListener.onVideoPlayError(i3, i4);
                    this.pR.gR();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    com.kwad.components.ad.reward.k kVar = this.pR.nM;
                    kVar.mP = j2;
                    kVar.mQ = j - j2 < 800;
                    i iVar = this.pR;
                    if (iVar.nM.mC) {
                        return;
                    }
                    iVar.pQ = j2;
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.pR.mAdOpenInteractionListener.onVideoPlayStart();
                }
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            com.kwad.components.ad.reward.k kVar = this.nM;
            kVar.mP = 0L;
            kVar.mQ = false;
            this.mAdOpenInteractionListener = kVar.mAdOpenInteractionListener;
            com.kwad.components.ad.reward.j.a aVar = kVar.eF;
            this.eF = aVar;
            aVar.a(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onUnbind();
            this.eF.b(this.mVideoPlayStateListener);
        }
    }
}
