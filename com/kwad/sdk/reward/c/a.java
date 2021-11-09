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
/* loaded from: classes2.dex */
public class a implements com.kwad.sdk.reward.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f66329a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f66330b;

    /* renamed from: c  reason: collision with root package name */
    public long f66331c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f66332d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f66333e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayerStatus f66334f;

    /* renamed from: g  reason: collision with root package name */
    public e f66335g;

    /* renamed from: h  reason: collision with root package name */
    public Context f66336h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66337i;
    public boolean j;
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
        this.f66336h = detailVideoView.getContext();
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
        this.j = false;
        this.k = new ArrayList();
        this.l = new h.a(this) { // from class: com.kwad.sdk.reward.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f66338a;

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
                this.f66338a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.f66338a.k) {
                        for (h.a aVar : this.f66338a.k) {
                            aVar.a();
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f66338a.k) {
                        for (h.a aVar : this.f66338a.k) {
                            aVar.b();
                        }
                    }
                }
            }
        };
        this.f66333e = ksVideoPlayConfig;
        this.f66330b = adTemplate;
        this.f66336h = detailVideoView.getContext();
        this.f66334f = adTemplate.mVideoPlayerStatus;
        this.j = z;
        String a2 = com.kwad.sdk.core.response.b.a.a(c.i(adTemplate));
        this.f66331c = com.kwad.sdk.core.response.b.a.i(c.i(adTemplate));
        int C = com.kwad.sdk.core.config.c.C();
        if (C < 0) {
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a2);
            if (b2 != null && b2.exists()) {
                a2 = b2.getAbsolutePath();
            }
            this.f66332d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
            l();
            e eVar = new e(this, adTemplate) { // from class: com.kwad.sdk.reward.c.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f66339a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f66340b;

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
                    this.f66340b = this;
                    this.f66339a = adTemplate;
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) {
                        super.a(i4, i5);
                        d.b(this.f66339a, i4, i5);
                    }
                }
            };
            this.f66335g = eVar;
            this.f66332d.a(eVar);
            this.f66332d.a(new c.e(this) { // from class: com.kwad.sdk.reward.c.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66341a;

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
                    this.f66341a = this;
                }

                @Override // com.kwad.sdk.core.video.a.c.e
                public void a(com.kwad.sdk.core.video.a.c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        this.f66341a.f66332d.e();
                    }
                }
            });
            b.a(this.f66336h).a(this.l);
        } else if (C != 0) {
            a2 = com.kwad.sdk.core.videocache.c.a.a(detailVideoView.getContext()).a(a2);
        }
        this.f66329a = a2;
        this.f66332d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        l();
        e eVar2 = new e(this, adTemplate) { // from class: com.kwad.sdk.reward.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f66339a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f66340b;

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
                this.f66340b = this;
                this.f66339a = adTemplate;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) {
                    super.a(i4, i5);
                    d.b(this.f66339a, i4, i5);
                }
            }
        };
        this.f66335g = eVar2;
        this.f66332d.a(eVar2);
        this.f66332d.a(new c.e(this) { // from class: com.kwad.sdk.reward.c.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f66341a;

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
                this.f66341a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.f66341a.f66332d.e();
                }
            }
        });
        b.a(this.f66336h).a(this.l);
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f66332d.a(new c.a().a(this.f66329a).b(com.kwad.sdk.core.response.b.e.b(com.kwad.sdk.core.response.b.c.j(this.f66330b))).a(this.f66334f).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f66330b)).a());
            KsVideoPlayConfig ksVideoPlayConfig = this.f66333e;
            if (ksVideoPlayConfig != null) {
                a(ksVideoPlayConfig.isVideoSoundEnable(), false);
            }
            this.f66332d.d();
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f66332d.a() == null) {
            l();
        }
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f66332d.a(dVar);
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
            this.f66337i = z;
            if (!z) {
                this.f66332d.a(0.0f, 0.0f);
                return;
            }
            this.f66332d.a(1.0f, 1.0f);
            if (z2) {
                b.a(this.f66336h).a(true);
            }
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f();
            if (this.f66337i) {
                b.a(this.f66336h).a(false);
                if (this.j || !b.a(this.f66336h).a()) {
                    return;
                }
                this.f66337i = false;
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
        this.f66332d.b(dVar);
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f66332d) == null) {
            return;
        }
        aVar.b(this.f66335g);
        this.f66332d.h();
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.f66332d.f();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.f66332d.g();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f66332d.a(9);
            this.f66332d.h();
        }
    }

    @MainThread
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            com.kwad.sdk.contentalliance.detail.video.a aVar = this.f66332d;
            if (aVar != null) {
                aVar.m();
                this.f66332d.h();
            }
            b.a(this.f66336h).b(this.l);
        }
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f66332d.i() : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f66332d.j() : invokeV.intValue;
    }
}
