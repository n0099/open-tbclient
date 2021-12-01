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
import com.kwad.sdk.core.config.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.reward.KSRewardVideoActivityProxy;
import com.kwad.sdk.utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements com.kwad.sdk.reward.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f58886b;

    /* renamed from: c  reason: collision with root package name */
    public long f58887c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f58888d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f58889e;

    /* renamed from: f  reason: collision with root package name */
    public KsVideoPlayConfig f58890f;

    /* renamed from: g  reason: collision with root package name */
    public VideoPlayerStatus f58891g;

    /* renamed from: h  reason: collision with root package name */
    public e f58892h;

    /* renamed from: i  reason: collision with root package name */
    public Context f58893i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f58894j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f58895k;
    public boolean l;
    public final List<j.a> m;
    public j.a n;

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
        this.f58893i = detailVideoView.getContext();
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
        this.f58895k = false;
        this.l = false;
        this.m = new ArrayList();
        this.n = new j.a(this) { // from class: com.kwad.sdk.reward.c.a.1
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
                    this.a.l = true;
                    if (this.a.f58889e != null) {
                        this.a.f58889e.a(false);
                    }
                    synchronized (this.a.m) {
                        for (j.a aVar : this.a.m) {
                            aVar.a();
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.utils.j.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.a.m) {
                        for (j.a aVar : this.a.m) {
                            aVar.b();
                        }
                    }
                }
            }
        };
        this.f58890f = ksVideoPlayConfig;
        this.f58886b = adTemplate;
        this.f58893i = detailVideoView.getContext();
        this.f58891g = adTemplate.mVideoPlayerStatus;
        this.f58895k = z;
        String a = com.kwad.sdk.core.response.a.a.a(d.j(adTemplate));
        this.f58887c = com.kwad.sdk.core.response.a.a.l(d.j(adTemplate));
        int C = b.C();
        if (C < 0) {
            File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(a);
            if (b2 != null && b2.exists()) {
                a = b2.getAbsolutePath();
            }
            this.f58888d = detailVideoView;
            this.f58889e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
            i();
            e eVar = new e(this, adTemplate) { // from class: com.kwad.sdk.reward.c.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdTemplate a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f58896b;

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
                    this.f58896b = this;
                    this.a = adTemplate;
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) {
                        super.a(i4, i5);
                        com.kwad.sdk.core.report.d.b(this.a, i4, i5);
                    }
                }
            };
            this.f58892h = eVar;
            this.f58889e.a(eVar);
            this.f58889e.a(new c.e(this) { // from class: com.kwad.sdk.reward.c.a.3
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

                @Override // com.kwad.sdk.core.video.kwai.c.e
                public void a(c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        this.a.f58889e.e();
                    }
                }
            });
            com.kwad.sdk.utils.b.a(this.f58893i).a(this.n);
        } else if (C != 0) {
            a = com.kwad.sdk.core.videocache.b.a.a(detailVideoView.getContext()).a(a);
        }
        this.a = a;
        this.f58888d = detailVideoView;
        this.f58889e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        i();
        e eVar2 = new e(this, adTemplate) { // from class: com.kwad.sdk.reward.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f58896b;

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
                this.f58896b = this;
                this.a = adTemplate;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) {
                    super.a(i4, i5);
                    com.kwad.sdk.core.report.d.b(this.a, i4, i5);
                }
            }
        };
        this.f58892h = eVar2;
        this.f58889e.a(eVar2);
        this.f58889e.a(new c.e(this) { // from class: com.kwad.sdk.reward.c.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.a.f58889e.e();
                }
            }
        });
        com.kwad.sdk.utils.b.a(this.f58893i).a(this.n);
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.f58889e.a(new c.a(this.f58886b).a(this.a).b(f.b(d.k(this.f58886b))).a(this.f58891g).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f58886b)).a(), this.f58888d);
            KsVideoPlayConfig ksVideoPlayConfig = this.f58890f;
            if (ksVideoPlayConfig != null) {
                a(ksVideoPlayConfig.isVideoSoundEnable(), false);
            }
            this.f58889e.d();
        }
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f58889e.a(dVar);
    }

    @Override // com.kwad.sdk.reward.a.a
    public void a(com.kwad.sdk.core.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.l = false;
            if (this.f58889e.a() == null) {
                i();
            }
        }
    }

    public void a(j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.m.add(aVar);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            long k2 = this.f58889e.k();
            if (z) {
                this.f58889e.a(9);
            } else {
                this.f58889e.a(k2);
            }
            if (z) {
                this.f58889e.h();
            }
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f58894j = z;
            if (!z) {
                this.f58889e.a(0.0f, 0.0f);
                return;
            }
            this.f58889e.a(1.0f, 1.0f);
            if (z2) {
                com.kwad.sdk.utils.b.a(this.f58893i).a(true);
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58895k : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || com.kwad.sdk.reward.j.a()) {
            return;
        }
        this.f58889e.f();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f58889e.b(dVar);
    }

    @Override // com.kwad.sdk.reward.a.a
    public void b(com.kwad.sdk.core.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            if (((aVar instanceof KSRewardVideoActivityProxy) && ((KSRewardVideoActivityProxy) aVar).isRefluxVisible()) ? false : true) {
                b();
            }
            if (this.f58894j || (b.F() && this.l)) {
                com.kwad.sdk.utils.b.a(this.f58893i).a(b.F());
                if (b.F() && this.l) {
                    this.l = false;
                    this.f58894j = true;
                    a(true, false);
                } else if (this.f58895k || !com.kwad.sdk.utils.b.a(this.f58893i).a()) {
                } else {
                    this.f58894j = false;
                    a(false, false);
                }
            }
        }
    }

    public void b(j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.m.remove(aVar);
        }
    }

    public void c() {
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || com.kwad.sdk.reward.j.a()) {
            return;
        }
        AdTemplate adTemplate = this.f58886b;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.f58889e.g();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void c(com.kwad.sdk.core.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            c();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || com.kwad.sdk.reward.j.a()) {
            return;
        }
        this.f58889e.g();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void d(com.kwad.sdk.core.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.l = false;
            com.kwad.sdk.contentalliance.detail.video.a aVar2 = this.f58889e;
            if (aVar2 != null) {
                aVar2.b(this.f58892h);
                this.f58889e.h();
            }
        }
    }

    @MainThread
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            com.kwad.sdk.contentalliance.detail.video.a aVar = this.f58889e;
            if (aVar != null) {
                aVar.n();
                this.f58889e.h();
            }
            com.kwad.sdk.utils.b.a(this.f58893i).b(this.n);
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f58889e.i() : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f58889e.j() : invokeV.intValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            com.kwad.sdk.contentalliance.detail.video.a aVar = this.f58889e;
            if (aVar != null) {
                return aVar.l();
            }
            return 0L;
        }
        return invokeV.longValue;
    }
}
