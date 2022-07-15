package com.kwad.components.ad.e.b;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.components.core.widget.kwai.b;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.k;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate a;
    public b b;
    public DetailVideoView c;
    public com.kwad.components.core.video.b d;
    public boolean e;
    public boolean f;
    public Context g;
    public h h;
    public boolean i;
    public boolean j;
    public final AdInfo k;
    public KsAdVideoPlayConfig l;
    public final com.kwad.sdk.core.g.b m;
    public h.a n;

    public a(@NonNull AdTemplate adTemplate, @NonNull b bVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, bVar, detailVideoView, ksAdVideoPlayConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.m = new com.kwad.sdk.core.g.b(this) { // from class: com.kwad.components.ad.e.b.a.3
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

            @Override // com.kwad.sdk.core.g.b
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.d();
                }
            }

            @Override // com.kwad.sdk.core.g.b
            public final void m_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.c();
                }
            }
        };
        this.n = new h.a(this) { // from class: com.kwad.components.ad.e.b.a.4
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
                    this.a.j = false;
                    this.a.b(false);
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.a = adTemplate;
        this.b = bVar;
        this.k = d.i(adTemplate);
        this.e = (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) ? com.kwad.sdk.core.response.a.a.ay(this.k) : ksAdVideoPlayConfig.isVideoSoundEnable();
        this.l = ksAdVideoPlayConfig;
        this.g = detailVideoView.getContext();
        this.c = detailVideoView;
        this.d = new com.kwad.components.core.video.b(detailVideoView);
        if (ksAdVideoPlayConfig != null) {
            try {
                this.i = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.b(th);
            }
        }
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h(this, adTemplate) { // from class: com.kwad.components.ad.e.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate a;
            public final /* synthetic */ a b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, adTemplate};
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
                this.a = adTemplate;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) {
                    super.a(i3, i4);
                    com.kwad.components.core.i.a.a().b(this.a, i3, i4);
                }
            }
        };
        this.h = hVar;
        this.d.a(hVar);
        g();
        this.d.a(new c.e(this) { // from class: com.kwad.components.ad.e.b.a.2
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

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) && this.a.h() && this.a.b.a()) {
                    this.a.d.a(com.kwad.sdk.contentalliance.kwai.kwai.a.a(this.a.a));
                    this.a.d.d();
                }
            }
        });
    }

    private boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, this, z)) == null) {
            if (z) {
                if (!com.kwad.sdk.core.config.d.Z()) {
                    return !com.kwad.components.core.l.b.a(this.g).b() ? com.kwad.components.core.l.b.a(this.g).a(false) : !com.kwad.components.core.l.b.a(this.g).a();
                }
                if (!this.j) {
                    this.j = com.kwad.components.core.l.b.a(this.g).a(true);
                }
                return this.j;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, this, z) == null) {
            com.kwad.components.core.video.b bVar = this.d;
            float f = z ? 1.0f : 0.0f;
            bVar.a(f, f);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.d.a(new b.a(this.a).a(d.k(this.a)).b(f.b(d.j(this.a))).a(this.a.mVideoPlayerStatus).a(this.i).a(com.kwad.sdk.contentalliance.kwai.kwai.a.a(this.a)).a(), true, true, this.c);
            b(a(this.e));
            if (h()) {
                this.d.c();
                com.kwad.components.core.l.b.a(this.g).a(this.n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.f) {
                return true;
            }
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.l;
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                    return ac.b(this.g);
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                    return ac.c(this.g);
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                    return false;
                }
                if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                    return ac.c(this.g) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ac.d(this.g));
                }
            }
            if (com.kwad.sdk.core.response.a.a.az(this.k) && ac.b(this.g)) {
                return true;
            }
            return com.kwad.sdk.core.response.a.a.aA(this.k) && ac.c(this.g);
        }
        return invokeV.booleanValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k.c(this.a);
            if (this.d.a() == null) {
                g();
            }
            if (h() && this.b.a()) {
                this.d.a(com.kwad.sdk.contentalliance.kwai.kwai.a.a(this.a));
                this.d.d();
            }
            this.b.a(this.m);
        }
    }

    @MainThread
    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || gVar == null) {
            return;
        }
        this.d.a(gVar);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k.a(this.a);
            this.b.b(this.m);
            this.d.g();
            com.kwad.components.core.l.b.a(this.g).b(this.n);
        }
    }

    @MainThread
    public final void b(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || gVar == null) {
            return;
        }
        this.d.b(gVar);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b(a(this.e));
            if (h()) {
                this.d.e();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d.f();
        }
    }

    @MainThread
    public final void e() {
        com.kwad.components.core.video.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bVar = this.d) == null) {
            return;
        }
        bVar.k();
        this.d.g();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f = true;
            if (this.b.a()) {
                k.b(this.a);
                this.d.a(com.kwad.sdk.contentalliance.kwai.kwai.a.a(this.a));
                this.d.d();
            }
        }
    }
}
