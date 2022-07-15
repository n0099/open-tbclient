package com.kwad.components.ad.draw.b;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.g;
import com.kwad.components.core.widget.kwai.b;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.k;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public AdTemplate a;
    public long b;
    public b c;
    public DetailVideoView d;
    public com.kwad.components.core.video.b e;
    public com.kwad.sdk.contentalliance.kwai.kwai.a f;
    public Context g;
    public boolean h;
    public final com.kwad.sdk.core.g.b i;

    public a(@NonNull AdTemplate adTemplate, @NonNull b bVar, @NonNull DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, bVar, detailVideoView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new com.kwad.sdk.core.g.b(this) { // from class: com.kwad.components.ad.draw.b.a.2
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
                    if (this.a.f == null) {
                        a aVar = this.a;
                        aVar.f = com.kwad.sdk.contentalliance.kwai.kwai.a.a(aVar.a);
                        this.a.e.a(this.a.f);
                    }
                    if (this.a.h) {
                        return;
                    }
                    this.a.c();
                }
            }
        };
        this.a = adTemplate;
        this.b = com.kwad.sdk.core.response.a.a.m(d.i(adTemplate));
        this.c = bVar;
        this.g = detailVideoView.getContext();
        this.d = detailVideoView;
        this.e = new com.kwad.components.core.video.b(detailVideoView);
        f();
        this.e.a(new c.e(this) { // from class: com.kwad.components.ad.draw.b.a.1
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
                    this.a.a(k.d(this.a.a));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65539, this, j) == null) && this.c.a()) {
            this.e.a(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.a, j));
            this.e.d();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.e.a(new b.a(this.a).a(d.k(this.a)).b(f.b(d.j(this.a))).a(this.a.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.a, System.currentTimeMillis())).a(), this.d);
            this.e.c();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long d = k.d(this.a);
            if (this.e.a() == null) {
                f();
            }
            a(d);
            this.c.a(this.i);
        }
    }

    @MainThread
    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || gVar == null) {
            return;
        }
        this.e.a(gVar);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.h = z;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f = null;
            this.c.b(this.i);
            this.e.g();
        }
    }

    @MainThread
    public final void b(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) || gVar == null) {
            return;
        }
        this.e.b(gVar);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.e();
            com.kwad.components.core.l.b.a(this.g).a(false);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e.f();
        }
    }

    @MainThread
    public final void e() {
        com.kwad.components.core.video.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bVar = this.e) == null) {
            return;
        }
        bVar.k();
        this.e.g();
    }
}
