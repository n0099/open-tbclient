package com.kwad.components.core.page.a;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class a implements com.kwad.components.core.g.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public AdTemplate b;
    public DetailVideoView c;
    public b d;
    public KsVideoPlayConfig e;
    public VideoPlayerStatus f;
    public h g;
    public Context h;
    public boolean i;
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
        this.j = false;
        this.k = new ArrayList();
        this.l = new h.a(this) { // from class: com.kwad.components.core.page.a.a.1
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
                    this.a.j = true;
                    if (this.a.d != null) {
                        this.a.d.a(false);
                    }
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
        this.e = ksVideoPlayConfig;
        this.b = adTemplate;
        this.h = detailVideoView.getContext();
        this.f = adTemplate.mVideoPlayerStatus;
        String b = com.kwad.sdk.core.response.a.a.b(d.i(adTemplate));
        int J = com.kwad.sdk.core.config.d.J();
        if (J < 0) {
            File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(b);
            if (b2 != null && b2.exists()) {
                b = b2.getAbsolutePath();
            }
            this.c = detailVideoView;
            this.d = new b(detailVideoView);
            b();
            com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h(this, adTemplate) { // from class: com.kwad.components.core.page.a.a.2
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
            this.g = hVar;
            this.d.a(hVar);
            this.d.a(new c.e(this) { // from class: com.kwad.components.core.page.a.a.3
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
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        this.a.d.d();
                    }
                }
            });
            com.kwad.components.core.l.b.a(this.h).a(this.l);
        } else if (J != 0) {
            b = com.kwad.sdk.core.videocache.b.a.a(detailVideoView.getContext()).a(b);
        }
        this.a = b;
        this.c = detailVideoView;
        this.d = new b(detailVideoView);
        b();
        com.kwad.components.core.video.h hVar2 = new com.kwad.components.core.video.h(this, adTemplate) { // from class: com.kwad.components.core.page.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate a;
            public final /* synthetic */ a b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
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
        this.g = hVar2;
        this.d.a(hVar2);
        this.d.a(new c.e(this) { // from class: com.kwad.components.core.page.a.a.3
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
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.a.d.d();
                }
            }
        });
        com.kwad.components.core.l.b.a(this.h).a(this.l);
    }

    private void a(boolean z, boolean z2) {
        b bVar;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.i = z;
            if (z) {
                bVar = this.d;
                f = 1.0f;
            } else {
                bVar = this.d;
                f = 0.0f;
            }
            bVar.a(f, f);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.d.a(new b.a(this.b).a(this.a).b(f.b(d.j(this.b))).a(this.f).a(com.kwad.sdk.contentalliance.kwai.kwai.a.a(this.b)).a(), this.c);
            KsVideoPlayConfig ksVideoPlayConfig = this.e;
            if (ksVideoPlayConfig != null) {
                a(ksVideoPlayConfig.isVideoSoundEnable(), false);
            }
            this.d.c();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.d.e();
        }
    }

    private void d() {
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            AdTemplate adTemplate = this.b;
            if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
                return;
            }
            this.d.f();
        }
    }

    @MainThread
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.components.core.video.b bVar = this.d;
            if (bVar != null) {
                bVar.k();
                this.d.g();
            }
            com.kwad.components.core.l.b.a(this.h).b(this.l);
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

    @MainThread
    public final void b(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) || gVar == null) {
            return;
        }
        this.d.b(gVar);
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j = false;
            if (this.d.a() == null) {
                b();
            }
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c();
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d();
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j = false;
            com.kwad.components.core.video.b bVar = this.d;
            if (bVar != null) {
                bVar.b(this.g);
                this.d.g();
            }
        }
    }
}
