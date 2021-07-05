package com.kwad.sdk.splashscreen.b;

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
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.i.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.b;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f39262a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f39263b;

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f39264c;

    /* renamed from: d  reason: collision with root package name */
    public long f39265d;

    /* renamed from: e  reason: collision with root package name */
    public VideoPlayerStatus f39266e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39267f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39268g;

    /* renamed from: h  reason: collision with root package name */
    public final List<g.a> f39269h;

    /* renamed from: i  reason: collision with root package name */
    public g.a f39270i;
    public long j;

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
        this.f39269h = new ArrayList();
        this.f39270i = new g.a(this) { // from class: com.kwad.sdk.splashscreen.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f39271a;

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
                this.f39271a = this;
            }

            @Override // com.kwad.sdk.utils.g.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.f39271a.f39269h) {
                        for (g.a aVar : this.f39271a.f39269h) {
                            aVar.a();
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.utils.g.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f39271a.f39269h) {
                        for (g.a aVar : this.f39271a.f39269h) {
                            aVar.b();
                        }
                    }
                }
            }
        };
        this.j = -1L;
        this.f39264c = ksVideoPlayConfig;
        String H = com.kwad.sdk.core.response.b.a.H(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.f39266e = adTemplate.mVideoPlayerStatus;
        File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(H);
        if (b2 != null && b2.exists()) {
            this.f39262a = b2.getAbsolutePath();
        }
        this.f39263b = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        this.f39265d = com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.j = adTemplate.mKsPlayerClickTimeParam;
        this.f39263b.a(new c.e(this, detailVideoView) { // from class: com.kwad.sdk.splashscreen.b.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DetailVideoView f39272a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f39273b;

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
                this.f39273b = this;
                this.f39272a = detailVideoView;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    boolean a2 = ao.a((View) this.f39272a, 50, true);
                    com.kwad.sdk.core.d.a.a("SplashPlayModule", " onPrepared" + a2);
                    if (a2) {
                        this.f39273b.f39263b.f();
                    }
                }
            }
        });
        b.a().a(this.f39270i);
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f39263b.a(new d.a().a(this.f39266e).a(this.f39262a).a(new com.kwad.sdk.contentalliance.detail.video.c(this.f39265d, this.j)).a());
            KsVideoPlayConfig ksVideoPlayConfig = this.f39264c;
            if (ksVideoPlayConfig != null) {
                a(ksVideoPlayConfig.isVideoSoundEnable(), false);
            }
            this.f39263b.e();
        }
    }

    @MainThread
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f39263b.a(eVar);
    }

    public void a(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f39269h.add(aVar);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f39268g = z;
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f39267f = z;
            if (!z) {
                this.f39263b.a(0.0f, 0.0f);
                return;
            }
            this.f39263b.a(1.0f, 1.0f);
            if (z2) {
                b.a().a(true);
            }
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e();
        }
    }

    @MainThread
    public void b(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f39263b.b(eVar);
    }

    public void b(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f39269h.remove(aVar);
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f39263b.o() : invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f39263b.h();
            if (this.f39267f && this.f39268g) {
                b.a().a(false);
                if (b.a().b()) {
                    this.f39267f = false;
                    a(false, false);
                }
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f39263b.j();
        }
    }

    @MainThread
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            com.kwad.sdk.contentalliance.detail.video.a aVar = this.f39263b;
            if (aVar != null) {
                aVar.p();
                this.f39263b.k();
            }
            b.a().b(this.f39270i);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.f39263b.a() == null) {
                h();
            }
            this.f39263b.f();
        }
    }
}
