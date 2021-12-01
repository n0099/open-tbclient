package com.kwad.sdk.splashscreen.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.TextureView;
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
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.b;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap a;

    /* renamed from: b  reason: collision with root package name */
    public String f59541b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f59542c;

    /* renamed from: d  reason: collision with root package name */
    public KsVideoPlayConfig f59543d;

    /* renamed from: e  reason: collision with root package name */
    public long f59544e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayerStatus f59545f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59546g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f59547h;

    /* renamed from: i  reason: collision with root package name */
    public Context f59548i;

    /* renamed from: j  reason: collision with root package name */
    public DetailVideoView f59549j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f59550k;
    public final List<j.a> l;
    public j.a m;
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
        this.m = new j.a(this) { // from class: com.kwad.sdk.splashscreen.b.a.1
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.utils.j.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.a.l) {
                        for (j.a aVar : this.a.l) {
                            aVar.a();
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.utils.j.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.a.l) {
                        for (j.a aVar : this.a.l) {
                            aVar.b();
                        }
                    }
                }
            }
        };
        this.n = -1L;
        this.f59547h = adTemplate;
        this.f59543d = ksVideoPlayConfig;
        this.f59548i = detailVideoView.getContext();
        String N = com.kwad.sdk.core.response.a.a.N(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f59545f = adTemplate.mVideoPlayerStatus;
        File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(N);
        if (b2 != null && b2.exists()) {
            this.f59541b = b2.getAbsolutePath();
        }
        this.f59549j = detailVideoView;
        this.f59542c = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        this.f59544e = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f59542c.a(new c.e(this, detailVideoView) { // from class: com.kwad.sdk.splashscreen.b.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DetailVideoView a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f59551b;

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
                this.f59551b = this;
                this.a = detailVideoView;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    boolean a = bb.a(this.a, 50, true);
                    com.kwad.sdk.core.d.a.a("SplashPlayModule", " onPrepared" + a);
                    if (a) {
                        this.f59551b.f59542c.e();
                    }
                }
            }
        });
        b.a(this.f59548i).a(this.m);
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f59542c.a(new c.a(this.f59547h).a(this.f59545f).a(this.f59541b).b(f.b(com.kwad.sdk.core.response.a.d.k(this.f59547h))).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f59547h)).a(), this.f59549j);
            KsVideoPlayConfig ksVideoPlayConfig = this.f59543d;
            if (ksVideoPlayConfig != null) {
                a(ksVideoPlayConfig.isVideoSoundEnable(), false);
            }
            this.f59542c.d();
        }
    }

    public TextureView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59549j.a : (TextureView) invokeV.objValue;
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f59542c.a(dVar);
    }

    public void a(j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.l.add(aVar);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f59550k = z;
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f59546g = z;
            if (!z) {
                this.f59542c.a(0.0f, 0.0f);
                return;
            }
            this.f59542c.a(1.0f, 1.0f);
            if (z2) {
                b.a(this.f59548i).a(true);
            }
        }
    }

    public AdTemplate b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f59547h : (AdTemplate) invokeV.objValue;
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f59542c.b(dVar);
    }

    public void b(j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.l.remove(aVar);
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f59542c.m() : invokeV.longValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f59542c.f();
            if (this.f59546g && this.f59550k) {
                b.a(this.f59548i).a(false);
                if (b.a(this.f59548i).a()) {
                    this.f59546g = false;
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
            this.f59542c.g();
        }
    }

    @MainThread
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            com.kwad.sdk.contentalliance.detail.video.a aVar = this.f59542c;
            if (aVar != null) {
                aVar.n();
                this.f59542c.h();
            }
            b.a(this.f59548i).b(this.m);
        }
    }

    @MainThread
    public void i() {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (aVar = this.f59542c) == null) {
            return;
        }
        aVar.n();
        this.f59542c.g();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.f59542c.a() == null) {
                k();
            }
            this.f59542c.e();
        }
    }
}
