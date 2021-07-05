package com.kwad.sdk.reward.c;

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
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.b;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.reward.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f39049a;

    /* renamed from: b  reason: collision with root package name */
    public long f39050b;

    /* renamed from: c  reason: collision with root package name */
    public long f39051c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f39052d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f39053e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayerStatus f39054f;

    /* renamed from: g  reason: collision with root package name */
    public f f39055g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39056h;

    /* renamed from: i  reason: collision with root package name */
    public final List<g.a> f39057i;
    public g.a j;

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
        this.f39051c = -1L;
        this.f39057i = new ArrayList();
        this.j = new g.a(this) { // from class: com.kwad.sdk.reward.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f39058a;

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
                this.f39058a = this;
            }

            @Override // com.kwad.sdk.utils.g.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.f39058a.f39057i) {
                        for (g.a aVar : this.f39058a.f39057i) {
                            aVar.a();
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.utils.g.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f39058a.f39057i) {
                        for (g.a aVar : this.f39058a.f39057i) {
                            aVar.b();
                        }
                    }
                }
            }
        };
        this.f39053e = ksVideoPlayConfig;
        this.f39054f = adTemplate.mVideoPlayerStatus;
        String a2 = com.kwad.sdk.core.response.b.a.a(c.j(adTemplate));
        this.f39050b = com.kwad.sdk.core.response.b.a.k(c.j(adTemplate));
        this.f39051c = adTemplate.mKsPlayerClickTimeParam;
        int v = com.kwad.sdk.core.config.c.v();
        if (v < 0) {
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a2);
            if (b2 != null && b2.exists()) {
                a2 = b2.getAbsolutePath();
            }
            this.f39052d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
            k();
            f fVar = new f(this, adTemplate) { // from class: com.kwad.sdk.reward.c.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f39059a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f39060b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, adTemplate};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f39060b = this;
                    this.f39059a = adTemplate;
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
                public void a(int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) {
                        super.a(i4, i5);
                        e.b(this.f39059a, i4, i5);
                    }
                }
            };
            this.f39055g = fVar;
            this.f39052d.a(fVar);
            this.f39052d.a(new c.e(this) { // from class: com.kwad.sdk.reward.c.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f39061a;

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
                    this.f39061a = this;
                }

                @Override // com.kwad.sdk.core.video.a.c.e
                public void a(com.kwad.sdk.core.video.a.c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        this.f39061a.f39052d.f();
                    }
                }
            });
            b.a().a(this.j);
        } else if (v != 0) {
            a2 = com.kwad.sdk.core.videocache.c.a.a(detailVideoView.getContext()).a(a2);
        }
        this.f39049a = a2;
        this.f39052d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        k();
        f fVar2 = new f(this, adTemplate) { // from class: com.kwad.sdk.reward.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f39059a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f39060b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr2 = {this, adTemplate};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f39060b = this;
                this.f39059a = adTemplate;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) {
                    super.a(i4, i5);
                    e.b(this.f39059a, i4, i5);
                }
            }
        };
        this.f39055g = fVar2;
        this.f39052d.a(fVar2);
        this.f39052d.a(new c.e(this) { // from class: com.kwad.sdk.reward.c.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f39061a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
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
                this.f39061a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.f39061a.f39052d.f();
                }
            }
        });
        b.a().a(this.j);
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f39052d.a(new d.a().a(this.f39049a).a(this.f39054f).a(new com.kwad.sdk.contentalliance.detail.video.c(this.f39050b, this.f39051c)).a());
            KsVideoPlayConfig ksVideoPlayConfig = this.f39053e;
            if (ksVideoPlayConfig != null) {
                a(ksVideoPlayConfig.isVideoSoundEnable(), false);
            }
            this.f39052d.e();
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f39052d.a() == null) {
            k();
        }
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f39052d.a(eVar);
    }

    public void a(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f39057i.add(aVar);
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f39056h = z;
            if (!z) {
                this.f39052d.a(0.0f, 0.0f);
                return;
            }
            this.f39052d.a(1.0f, 1.0f);
            if (z2) {
                b.a().a(true);
            }
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e();
            if (this.f39056h) {
                b.a().a(false);
                if (b.a().b()) {
                    this.f39056h = false;
                    a(false, false);
                }
            }
        }
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f39052d.b(eVar);
    }

    public void b(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f39057i.remove(aVar);
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            f();
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void d() {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f39052d) == null) {
            return;
        }
        aVar.b(this.f39055g);
        this.f39052d.k();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.f39052d.h();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.f39052d.j();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f39052d.a(9);
            this.f39052d.k();
        }
    }

    @MainThread
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.kwad.sdk.contentalliance.detail.video.a aVar = this.f39052d;
            if (aVar != null) {
                aVar.p();
                this.f39052d.k();
            }
            b.a().b(this.j);
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f39052d.l() : invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f39052d.m() : invokeV.intValue;
    }
}
