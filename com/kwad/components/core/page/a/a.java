package com.kwad.components.core.page.a;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class a implements com.kwad.components.core.g.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b BL;
    public boolean km;
    public h ko;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public KsVideoPlayConfig mVideoPlayConfig;
    public VideoPlayerStatus mVideoPlayerStatus;
    public String uf;
    public boolean uh;
    public final List<h.a> uj;
    public h.a uk;

    public a(@NonNull AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, detailVideoView, ksVideoPlayConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.uh = false;
        this.uj = new ArrayList();
        this.uk = new h.a(this) { // from class: com.kwad.components.core.page.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a GX;

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
                this.GX = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.GX.uh = true;
                    if (this.GX.BL != null) {
                        this.GX.BL.setAudioEnabled(false);
                    }
                    synchronized (this.GX.uj) {
                        for (h.a aVar : this.GX.uj) {
                            aVar.bk();
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.GX.uj) {
                        for (h.a aVar : this.GX.uj) {
                            aVar.bl();
                        }
                    }
                }
            }
        };
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mAdTemplate = adTemplate;
        this.mContext = detailVideoView.getContext();
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        String A = com.kwad.sdk.core.response.a.a.A(d.bQ(adTemplate));
        int sc = com.kwad.sdk.core.config.d.sc();
        if (sc < 0) {
            File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(A);
            if (ad != null && ad.exists()) {
                A = ad.getAbsolutePath();
            }
            this.mDetailVideoView = detailVideoView;
            this.BL = new b(detailVideoView);
            aQ();
            com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h(this, adTemplate) { // from class: com.kwad.components.core.page.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a GX;
                public final /* synthetic */ AdTemplate kp;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, adTemplate};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.GX = this;
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
            this.BL.a(new c.e(this) { // from class: com.kwad.components.core.page.a.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a GX;

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
                    this.GX = this;
                }

                @Override // com.kwad.sdk.core.video.kwai.c.e
                public final void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        this.GX.BL.start();
                    }
                }
            });
            com.kwad.components.core.m.b.at(this.mContext).a(this.uk);
        } else if (sc != 0) {
            A = com.kwad.sdk.core.videocache.b.a.bC(detailVideoView.getContext()).cA(A);
        }
        this.uf = A;
        this.mDetailVideoView = detailVideoView;
        this.BL = new b(detailVideoView);
        aQ();
        com.kwad.components.core.video.h hVar2 = new com.kwad.components.core.video.h(this, adTemplate) { // from class: com.kwad.components.core.page.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a GX;
            public final /* synthetic */ AdTemplate kp;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr2 = {this, adTemplate};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.GX = this;
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
        this.ko = hVar2;
        this.BL.c(hVar2);
        this.BL.a(new c.e(this) { // from class: com.kwad.components.core.page.a.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a GX;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
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
                this.GX = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.GX.BL.start();
                }
            }
        });
        com.kwad.components.core.m.b.at(this.mContext).a(this.uk);
    }

    private void aQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.BL.a(new b.a(this.mAdTemplate).bk(this.uf).bl(f.b(d.bR(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate)).rC(), this.mDetailVideoView);
            KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
            if (ksVideoPlayConfig != null) {
                c(ksVideoPlayConfig.isVideoSoundEnable(), false);
            }
            this.BL.prepareAsync();
        }
    }

    private void c(boolean z, boolean z2) {
        com.kwad.components.core.video.b bVar;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.km = z;
            if (z) {
                bVar = this.BL;
                f = 1.0f;
            } else {
                bVar = this.BL;
                f = 0.0f;
            }
            bVar.setVolume(f, f);
        }
    }

    private void pause() {
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
                return;
            }
            this.BL.pause();
        }
    }

    private void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.BL.resume();
        }
    }

    @MainThread
    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null) {
            return;
        }
        this.BL.c(gVar);
    }

    @MainThread
    public final void b(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || gVar == null) {
            return;
        }
        this.BL.d(gVar);
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void iK() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.uh = false;
            if (this.BL.oT() == null) {
                aQ();
            }
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void iL() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            resume();
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void iM() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            pause();
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void iN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.uh = false;
            com.kwad.components.core.video.b bVar = this.BL;
            if (bVar != null) {
                bVar.d(this.ko);
                this.BL.release();
            }
        }
    }

    @MainThread
    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.kwad.components.core.video.b bVar = this.BL;
            if (bVar != null) {
                bVar.clear();
                this.BL.release();
            }
            com.kwad.components.core.m.b.at(this.mContext).b(this.uk);
        }
    }
}
