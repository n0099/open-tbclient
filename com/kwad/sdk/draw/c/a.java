package com.kwad.sdk.draw.c;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.b;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.core.j.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.j;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f65638a;

    /* renamed from: b  reason: collision with root package name */
    public long f65639b;

    /* renamed from: c  reason: collision with root package name */
    public e f65640c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f65641d;

    /* renamed from: e  reason: collision with root package name */
    public b f65642e;

    /* renamed from: f  reason: collision with root package name */
    public Context f65643f;

    /* renamed from: g  reason: collision with root package name */
    public final d f65644g;

    public a(@NonNull AdTemplate adTemplate, @NonNull e eVar, @NonNull DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, eVar, detailVideoView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65644g = new d(this) { // from class: com.kwad.sdk.draw.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65646a;

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
                this.f65646a = this;
            }

            @Override // com.kwad.sdk.core.j.d
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f65646a.f65642e == null) {
                        a aVar = this.f65646a;
                        aVar.f65642e = b.a(aVar.f65638a);
                        this.f65646a.f65641d.a(this.f65646a.f65642e);
                    }
                    this.f65646a.c();
                }
            }

            @Override // com.kwad.sdk.core.j.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f65646a.d();
                }
            }
        };
        this.f65638a = adTemplate;
        this.f65639b = com.kwad.sdk.core.response.b.a.i(c.i(adTemplate));
        this.f65640c = eVar;
        this.f65643f = detailVideoView.getContext();
        this.f65641d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.f65641d.a(new c.e(this) { // from class: com.kwad.sdk.draw.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65645a;

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
                this.f65645a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.f65645a.a(j.d(this.f65645a.f65638a));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65539, this, j) == null) && this.f65640c.c()) {
            this.f65641d.a(new b(this.f65638a, j));
            this.f65641d.e();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f65641d.a(new c.a().a(com.kwad.sdk.core.response.b.c.l(this.f65638a)).b(com.kwad.sdk.core.response.b.e.b(com.kwad.sdk.core.response.b.c.j(this.f65638a))).a(this.f65638a.mVideoPlayerStatus).a(new b(this.f65638a, System.currentTimeMillis())).a());
            this.f65641d.d();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long d2 = j.d(this.f65638a);
            if (this.f65641d.a() == null) {
                f();
            }
            a(d2);
            this.f65640c.a(this.f65644g);
        }
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f65641d.a(dVar);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f65642e = null;
            this.f65640c.b(this.f65644g);
            this.f65641d.h();
        }
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f65641d.b(dVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f65641d.f();
            com.kwad.sdk.utils.b.a(this.f65643f).a(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f65641d.g();
        }
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f65641d) == null) {
            return;
        }
        aVar.m();
        this.f65641d.h();
    }
}
