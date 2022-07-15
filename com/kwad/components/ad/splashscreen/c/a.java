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
import com.kwad.sdk.core.g.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap a;
    public String b;
    public com.kwad.components.core.video.b c;
    public KsVideoPlayConfig d;
    public VideoPlayerStatus e;
    public boolean f;
    public AdTemplate g;
    public Context h;
    public DetailVideoView i;
    public boolean j;
    public final List<h.a> k;
    public h.a l;

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
        this.k = new ArrayList();
        this.l = new h.a(this) { // from class: com.kwad.components.ad.splashscreen.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.a.k) {
                        for (h.a aVar : this.a.k) {
                            aVar.a();
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.a.k) {
                        for (h.a aVar : this.a.k) {
                            aVar.b();
                        }
                    }
                }
            }
        };
        this.g = adTemplate;
        this.d = ksVideoPlayConfig;
        this.h = detailVideoView.getContext();
        String U = com.kwad.sdk.core.response.a.a.U(d.i(adTemplate));
        this.e = adTemplate.mVideoPlayerStatus;
        File b = com.kwad.sdk.core.diskcache.a.a.a().b(U);
        if (b != null && b.exists()) {
            this.b = b.getAbsolutePath();
        }
        this.i = detailVideoView;
        com.kwad.components.core.video.b bVar = new com.kwad.components.core.video.b(detailVideoView);
        this.c = bVar;
        bVar.a(new c.e(this, detailVideoView) { // from class: com.kwad.components.ad.splashscreen.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DetailVideoView a;
            public final /* synthetic */ a b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, detailVideoView};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.b = this;
                this.a = detailVideoView;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    boolean a = com.kwad.sdk.b.kwai.a.a((View) this.a, 50, true);
                    com.kwad.sdk.core.d.b.a("SplashPlayModule", " onPrepared" + a);
                    if (a) {
                        this.b.c.d();
                    }
                }
            }
        });
        com.kwad.components.core.l.b.a(this.h).a(this.l);
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.c.a(new b.a(this.g).a(this.e).a(this.b).b(f.b(d.j(this.g))).a(com.kwad.sdk.contentalliance.kwai.kwai.a.a(this.g)).a(), this.i);
            KsVideoPlayConfig ksVideoPlayConfig = this.d;
            if (ksVideoPlayConfig != null) {
                a(ksVideoPlayConfig.isVideoSoundEnable(), false);
            }
            this.c.c();
        }
    }

    @MainThread
    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null) {
            return;
        }
        this.c.a(gVar);
    }

    public final void a(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.k.add(aVar);
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.j = true;
        }
    }

    public final void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f = z;
            if (!z) {
                this.c.a(0.0f, 0.0f);
                return;
            }
            this.c.a(1.0f, 1.0f);
            if (z2) {
                com.kwad.components.core.l.b.a(this.h).a(true);
            }
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            g();
        }
    }

    @MainThread
    public final void b(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || gVar == null) {
            return;
        }
        this.c.b(gVar);
    }

    public final void b(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.k.remove(aVar);
        }
    }

    public final TextureView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.i.a : (TextureView) invokeV.objValue;
    }

    public final AdTemplate d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : (AdTemplate) invokeV.objValue;
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c.j() : invokeV.longValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.c.e();
            if (this.f && this.j) {
                com.kwad.components.core.l.b.a(this.h).a(false);
                if (com.kwad.components.core.l.b.a(this.h).a()) {
                    this.f = false;
                    a(false, false);
                }
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.c.f();
        }
    }

    @MainThread
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.kwad.components.core.video.b bVar = this.c;
            if (bVar != null) {
                bVar.k();
                this.c.g();
            }
            com.kwad.components.core.l.b.a(this.h).b(this.l);
        }
    }

    @MainThread
    public final void i() {
        com.kwad.components.core.video.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bVar = this.c) == null) {
            return;
        }
        bVar.k();
        this.c.f();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.c.a() == null) {
                k();
            }
            this.c.d();
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void m_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            f();
        }
    }
}
