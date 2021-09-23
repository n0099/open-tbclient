package com.kwad.sdk.splashscreen.b;

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
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.b;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f74160a;

    /* renamed from: b  reason: collision with root package name */
    public String f74161b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f74162c;

    /* renamed from: d  reason: collision with root package name */
    public KsVideoPlayConfig f74163d;

    /* renamed from: e  reason: collision with root package name */
    public long f74164e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayerStatus f74165f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f74166g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f74167h;

    /* renamed from: i  reason: collision with root package name */
    public Context f74168i;

    /* renamed from: j  reason: collision with root package name */
    public DetailVideoView f74169j;
    public boolean k;
    public final List<h.a> l;
    public h.a m;
    public long n;

    public a(@NonNull AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, detailVideoView, ksVideoPlayConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.m = new h.a(this) { // from class: com.kwad.sdk.splashscreen.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f74170a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f74170a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.f74170a.l) {
                        for (h.a aVar : this.f74170a.l) {
                            aVar.a();
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f74170a.l) {
                        for (h.a aVar : this.f74170a.l) {
                            aVar.b();
                        }
                    }
                }
            }
        };
        this.n = -1L;
        this.f74167h = adTemplate;
        this.f74163d = ksVideoPlayConfig;
        this.f74168i = detailVideoView.getContext();
        String D = com.kwad.sdk.core.response.b.a.D(c.i(adTemplate));
        this.f74165f = adTemplate.mVideoPlayerStatus;
        File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(D);
        if (b2 != null && b2.exists()) {
            this.f74161b = b2.getAbsolutePath();
        }
        this.f74169j = detailVideoView;
        this.f74162c = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        this.f74164e = com.kwad.sdk.core.response.b.a.i(c.i(adTemplate));
        this.f74162c.a(new c.e(this, detailVideoView) { // from class: com.kwad.sdk.splashscreen.b.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DetailVideoView f74171a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f74172b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, detailVideoView};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f74172b = this;
                this.f74171a = detailVideoView;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    boolean a2 = av.a((View) this.f74171a, 50, true);
                    com.kwad.sdk.core.d.a.a("SplashPlayModule", " onPrepared" + a2);
                    if (a2) {
                        this.f74172b.f74162c.e();
                    }
                }
            }
        });
        b.a(this.f74168i).a(this.m);
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f74162c.a(new c.a().a(this.f74165f).a(this.f74161b).b(e.b(com.kwad.sdk.core.response.b.c.j(this.f74167h))).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f74167h)).a());
            KsVideoPlayConfig ksVideoPlayConfig = this.f74163d;
            if (ksVideoPlayConfig != null) {
                a(ksVideoPlayConfig.isVideoSoundEnable(), false);
            }
            this.f74162c.d();
        }
    }

    public TextureView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f74169j.f71707a : (TextureView) invokeV.objValue;
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f74162c.a(dVar);
    }

    public void a(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.l.add(aVar);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.k = z;
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f74166g = z;
            if (!z) {
                this.f74162c.a(0.0f, 0.0f);
                return;
            }
            this.f74162c.a(1.0f, 1.0f);
            if (z2) {
                b.a(this.f74168i).a(true);
            }
        }
    }

    public AdTemplate b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f74167h : (AdTemplate) invokeV.objValue;
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f74162c.b(dVar);
    }

    public void b(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.l.remove(aVar);
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f74162c.l() : invokeV.longValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f74162c.f();
            if (this.f74166g && this.k) {
                b.a(this.f74168i).a(false);
                if (b.a(this.f74168i).a()) {
                    this.f74166g = false;
                    a(false, false);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            d();
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            g();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f74162c.g();
        }
    }

    @MainThread
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            com.kwad.sdk.contentalliance.detail.video.a aVar = this.f74162c;
            if (aVar != null) {
                aVar.m();
                this.f74162c.h();
            }
            b.a(this.f74168i).b(this.m);
        }
    }

    @MainThread
    public void i() {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (aVar = this.f74162c) == null) {
            return;
        }
        aVar.m();
        this.f74162c.g();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.f74162c.a() == null) {
                k();
            }
            this.f74162c.e();
        }
    }
}
