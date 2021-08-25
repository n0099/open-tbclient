package com.kwad.sdk.reward.c;

import android.content.Context;
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
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.b;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements com.kwad.sdk.reward.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f73396a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f73397b;

    /* renamed from: c  reason: collision with root package name */
    public long f73398c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f73399d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f73400e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayerStatus f73401f;

    /* renamed from: g  reason: collision with root package name */
    public e f73402g;

    /* renamed from: h  reason: collision with root package name */
    public Context f73403h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f73404i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f73405j;
    public final List<h.a> k;
    public h.a l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NonNull AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this(adTemplate, detailVideoView, ksVideoPlayConfig, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, detailVideoView, ksVideoPlayConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((AdTemplate) objArr2[0], (DetailVideoView) objArr2[1], (KsVideoPlayConfig) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73403h = detailVideoView.getContext();
    }

    public a(@NonNull AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, detailVideoView, ksVideoPlayConfig, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f73405j = false;
        this.k = new ArrayList();
        this.l = new h.a(this) { // from class: com.kwad.sdk.reward.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f73406a;

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
                this.f73406a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.f73406a.k) {
                        for (h.a aVar : this.f73406a.k) {
                            aVar.a();
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f73406a.k) {
                        for (h.a aVar : this.f73406a.k) {
                            aVar.b();
                        }
                    }
                }
            }
        };
        this.f73400e = ksVideoPlayConfig;
        this.f73397b = adTemplate;
        this.f73403h = detailVideoView.getContext();
        this.f73401f = adTemplate.mVideoPlayerStatus;
        this.f73405j = z;
        String a2 = com.kwad.sdk.core.response.b.a.a(c.i(adTemplate));
        this.f73398c = com.kwad.sdk.core.response.b.a.i(c.i(adTemplate));
        int C = com.kwad.sdk.core.config.c.C();
        if (C < 0) {
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a2);
            if (b2 != null && b2.exists()) {
                a2 = b2.getAbsolutePath();
            }
            this.f73399d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
            l();
            e eVar = new e(this, adTemplate) { // from class: com.kwad.sdk.reward.c.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f73407a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f73408b;

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
                    this.f73408b = this;
                    this.f73407a = adTemplate;
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) {
                        super.a(i4, i5);
                        d.b(this.f73407a, i4, i5);
                    }
                }
            };
            this.f73402g = eVar;
            this.f73399d.a(eVar);
            this.f73399d.a(new c.e(this) { // from class: com.kwad.sdk.reward.c.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73409a;

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
                    this.f73409a = this;
                }

                @Override // com.kwad.sdk.core.video.a.c.e
                public void a(com.kwad.sdk.core.video.a.c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        this.f73409a.f73399d.e();
                    }
                }
            });
            b.a(this.f73403h).a(this.l);
        } else if (C != 0) {
            a2 = com.kwad.sdk.core.videocache.c.a.a(detailVideoView.getContext()).a(a2);
        }
        this.f73396a = a2;
        this.f73399d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        l();
        e eVar2 = new e(this, adTemplate) { // from class: com.kwad.sdk.reward.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f73407a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f73408b;

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
                this.f73408b = this;
                this.f73407a = adTemplate;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) {
                    super.a(i4, i5);
                    d.b(this.f73407a, i4, i5);
                }
            }
        };
        this.f73402g = eVar2;
        this.f73399d.a(eVar2);
        this.f73399d.a(new c.e(this) { // from class: com.kwad.sdk.reward.c.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f73409a;

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
                this.f73409a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.f73409a.f73399d.e();
                }
            }
        });
        b.a(this.f73403h).a(this.l);
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f73399d.a(new c.a().a(this.f73396a).b(com.kwad.sdk.core.response.b.e.b(com.kwad.sdk.core.response.b.c.j(this.f73397b))).a(this.f73401f).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f73397b)).a());
            KsVideoPlayConfig ksVideoPlayConfig = this.f73400e;
            if (ksVideoPlayConfig != null) {
                a(ksVideoPlayConfig.isVideoSoundEnable(), false);
            }
            this.f73399d.d();
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f73399d.a() == null) {
            l();
        }
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f73399d.a(dVar);
    }

    public void a(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.k.add(aVar);
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f73404i = z;
            if (!z) {
                this.f73399d.a(0.0f, 0.0f);
                return;
            }
            this.f73399d.a(1.0f, 1.0f);
            if (z2) {
                b.a(this.f73403h).a(true);
            }
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f();
            if (this.f73404i) {
                b.a(this.f73403h).a(false);
                if (this.f73405j || !b.a(this.f73403h).a()) {
                    return;
                }
                this.f73404i = false;
                a(false, false);
            }
        }
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f73399d.b(dVar);
    }

    public void b(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.k.remove(aVar);
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            g();
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void d() {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f73399d) == null) {
            return;
        }
        aVar.b(this.f73402g);
        this.f73399d.h();
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f73405j : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.f73399d.f();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.f73399d.g();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f73399d.a(9);
            this.f73399d.h();
        }
    }

    @MainThread
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            com.kwad.sdk.contentalliance.detail.video.a aVar = this.f73399d;
            if (aVar != null) {
                aVar.m();
                this.f73399d.h();
            }
            b.a(this.f73403h).b(this.l);
        }
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f73399d.i() : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f73399d.j() : invokeV.intValue;
    }
}
