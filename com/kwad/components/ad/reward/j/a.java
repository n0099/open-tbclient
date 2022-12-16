package com.kwad.components.ad.reward.j;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.m.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public final class a extends com.kwad.components.ad.h.a implements com.kwad.components.core.g.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hx;
    public boolean km;
    public h ko;
    public Context mContext;
    public KsVideoPlayConfig mVideoPlayConfig;
    public VideoPlayerStatus mVideoPlayerStatus;
    public k nM;
    public String uf;
    public boolean ug;
    public boolean uh;
    public List<InterfaceC0572a> ui;
    public final List<h.a> uj;
    public h.a uk;

    /* renamed from: com.kwad.components.ad.reward.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0572a {
        boolean handledOnResume();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(k kVar, boolean z) {
        super(kVar.mAdTemplate, kVar.mj);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, Boolean.valueOf(z)};
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
        this.ug = false;
        this.uh = false;
        this.hx = false;
        this.ui = new CopyOnWriteArrayList();
        this.uj = new ArrayList();
        this.uk = new h.a(this) { // from class: com.kwad.components.ad.reward.j.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a ul;

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
                this.ul = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.ul.uh = true;
                    if (this.ul.BL != null) {
                        this.ul.BL.setAudioEnabled(false);
                    }
                    synchronized (this.ul.uj) {
                        for (h.a aVar : this.ul.uj) {
                            aVar.bk();
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.ul.uj) {
                        for (h.a aVar : this.ul.uj) {
                            aVar.bl();
                        }
                    }
                }
            }
        };
        this.nM = kVar;
        this.mContext = kVar.mContext;
        this.mVideoPlayConfig = kVar.mVideoPlayConfig;
        this.mVideoPlayerStatus = this.mAdTemplate.mVideoPlayerStatus;
        this.ug = z;
        this.uf = getVideoUrl();
        aQ();
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.j.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a ul;

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
                this.ul = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) {
                    super.onVideoPlayError(i3, i4);
                    com.kwad.components.core.j.a.og().b(this.ul.mAdTemplate, i3, i4);
                }
            }
        };
        this.ko = hVar;
        this.BL.c(hVar);
        this.BL.a(new c.e(this) { // from class: com.kwad.components.ad.reward.j.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a ul;

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
                this.ul = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.ul.BL.start();
                }
            }
        });
        b.at(this.mContext).a(this.uk);
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

    private String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            String A = com.kwad.sdk.core.response.a.a.A(d.bQ(this.mAdTemplate));
            File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(A);
            return (ad == null || !ad.exists()) ? com.kwad.sdk.core.config.d.sc() > 0 ? com.kwad.sdk.core.videocache.b.a.bC(this.mContext).cA(A) : A : ad.getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    private void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            pause();
            this.hx = true;
        }
    }

    public final void a(InterfaceC0572a interfaceC0572a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0572a) == null) {
            this.ui.add(interfaceC0572a);
        }
    }

    @MainThread
    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || gVar == null) {
            return;
        }
        this.BL.c(gVar);
    }

    public final void a(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.uj.add(aVar);
        }
    }

    public final void b(InterfaceC0572a interfaceC0572a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0572a) == null) {
            this.ui.remove(interfaceC0572a);
        }
    }

    @MainThread
    public final void b(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) || gVar == null) {
            return;
        }
        this.BL.d(gVar);
    }

    public final void b(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.uj.remove(aVar);
        }
    }

    public final void c(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.km = z;
            if (!z) {
                this.BL.setVolume(0.0f, 0.0f);
                return;
            }
            this.BL.setVolume(1.0f, 1.0f);
            if (z2) {
                com.kwad.components.core.m.b.at(this.mContext).ay(true);
            }
        }
    }

    public final long getPlayDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            com.kwad.components.core.video.b bVar = this.BL;
            if (bVar != null) {
                return bVar.getPlayDuration();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final boolean iJ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.ug : invokeV.booleanValue;
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void iK() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.uh = false;
            if (this.BL.oT() == null) {
                aQ();
            }
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void iL() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            loop0: while (true) {
                for (InterfaceC0572a interfaceC0572a : this.ui) {
                    z = z || interfaceC0572a.handledOnResume();
                }
            }
            if (!z && !this.hx) {
                resume();
            }
            if (this.km || (com.kwad.components.ad.reward.kwai.b.fY() && this.uh)) {
                com.kwad.components.core.m.b.at(this.mContext).ay(com.kwad.components.ad.reward.kwai.b.fY());
                if (com.kwad.components.ad.reward.kwai.b.fY() && this.uh) {
                    this.uh = false;
                    this.km = true;
                    c(true, false);
                } else if (!this.ug && com.kwad.components.core.m.b.at(this.mContext).ov()) {
                    this.km = false;
                    c(false, false);
                }
            }
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void iM() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            pause();
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void iN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.uh = false;
            com.kwad.components.core.video.b bVar = this.BL;
            if (bVar != null) {
                bVar.d(this.ko);
                this.BL.release();
            }
        }
    }

    public final void pause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || k.d(this.nM)) {
            return;
        }
        this.BL.pause();
    }

    @Override // com.kwad.components.ad.h.a
    @MainThread
    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.release();
            com.kwad.components.core.video.b bVar = this.BL;
            if (bVar != null) {
                bVar.clear();
                this.BL.release();
            }
            com.kwad.components.core.m.b.at(this.mContext).b(this.uk);
        }
    }

    @Override // com.kwad.components.ad.h.a
    @WorkerThread
    public final void releaseSync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.releaseSync();
            com.kwad.components.core.video.b bVar = this.BL;
            if (bVar != null) {
                bVar.clear();
                this.BL.releaseSync();
            }
            com.kwad.components.core.m.b.at(this.mContext).b(this.uk);
        }
    }

    public final void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.hx = false;
            if (k.d(this.nM)) {
                return;
            }
            this.BL.resume();
        }
    }

    @Deprecated
    public final void skipToEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.BL.onPlayStateChanged(9);
            stop();
        }
    }
}
