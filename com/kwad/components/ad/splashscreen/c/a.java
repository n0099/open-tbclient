package com.kwad.components.ad.splashscreen.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.g;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.h.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class a extends com.kwad.components.ad.h.a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean km;
    public Bitmap mBitmap;
    public Context mContext;
    public KsVideoPlayConfig mVideoPlayConfig;
    public VideoPlayerStatus mVideoPlayerStatus;
    public String uf;
    public final List<h.a> uj;
    public h.a uk;
    public boolean zJ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, detailVideoView, ksVideoPlayConfig};
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
        this.uj = new ArrayList();
        this.uk = new h.a(this) { // from class: com.kwad.components.ad.splashscreen.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a zK;

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
                this.zK = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.zK.uj) {
                        for (h.a aVar : this.zK.uj) {
                            aVar.bk();
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.zK.uj) {
                        for (h.a aVar : this.zK.uj) {
                            aVar.bl();
                        }
                    }
                }
            }
        };
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        String az = com.kwad.sdk.core.response.a.a.az(d.bQ(adTemplate));
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(az);
        if (ad != null && ad.exists()) {
            this.uf = ad.getAbsolutePath();
        }
        this.BL.a(new c.e(this, detailVideoView) { // from class: com.kwad.components.ad.splashscreen.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a zK;
            public final /* synthetic */ DetailVideoView zL;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this, detailVideoView};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.zK = this;
                this.zL = detailVideoView;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    boolean a = com.kwad.sdk.b.kwai.a.a((View) this.zL, 50, true);
                    com.kwad.sdk.core.e.b.d("SplashPlayModule", " onPrepared" + a);
                    if (a) {
                        this.zK.BL.start();
                    }
                }
            }
        });
        com.kwad.components.core.m.b.at(this.mContext).a(this.uk);
    }

    private void aQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.BL.a(new b.a(this.mAdTemplate).a(this.mVideoPlayerStatus).bk(this.uf).bl(f.b(d.bR(this.mAdTemplate))).b(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate)).rC(), this.mDetailVideoView);
            KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
            if (ksVideoPlayConfig != null) {
                c(ksVideoPlayConfig.isVideoSoundEnable(), false);
            }
            this.BL.prepareAsync();
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

    public final void a(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.uj.add(aVar);
        }
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aR() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            resume();
        }
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            pause();
        }
    }

    public final void ad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.zJ = true;
        }
    }

    @MainThread
    public final void b(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || gVar == null) {
            return;
        }
        this.BL.d(gVar);
    }

    public final void b(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.uj.remove(aVar);
        }
    }

    public final void c(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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

    public final AdTemplate getAdTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mAdTemplate : (AdTemplate) invokeV.objValue;
    }

    public final long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.BL.getCurrentPosition() : invokeV.longValue;
    }

    public final void kA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.BL.oT() == null) {
                aQ();
            }
            this.BL.start();
        }
    }

    public final TextureView ky() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mDetailVideoView.Kb : (TextureView) invokeV.objValue;
    }

    @MainThread
    public final void kz() {
        com.kwad.components.core.video.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (bVar = this.BL) == null) {
            return;
        }
        bVar.clear();
        this.BL.pause();
    }

    public final void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.BL.pause();
        }
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

    public final void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.BL.resume();
            if (this.km && this.zJ) {
                com.kwad.components.core.m.b.at(this.mContext).ay(false);
                if (com.kwad.components.core.m.b.at(this.mContext).ov()) {
                    this.km = false;
                    c(false, false);
                }
            }
        }
    }
}
