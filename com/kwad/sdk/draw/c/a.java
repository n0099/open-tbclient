package com.kwad.sdk.draw.c;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.utils.b;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f37109a;

    /* renamed from: b  reason: collision with root package name */
    public long f37110b;

    /* renamed from: c  reason: collision with root package name */
    public g f37111c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f37112d;

    /* renamed from: e  reason: collision with root package name */
    public c f37113e;

    /* renamed from: f  reason: collision with root package name */
    public g.a f37114f;

    public a(@NonNull AdTemplate adTemplate, @NonNull g gVar, @NonNull DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, gVar, detailVideoView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37114f = new g.a(this) { // from class: com.kwad.sdk.draw.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f37116a;

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
                this.f37116a = this;
            }

            @Override // com.kwad.sdk.core.view.g.a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    if (!z) {
                        this.f37116a.d();
                        return;
                    }
                    if (this.f37116a.f37113e == null) {
                        a aVar = this.f37116a;
                        aVar.f37113e = new c(aVar.f37110b, System.currentTimeMillis());
                        this.f37116a.f37112d.a(this.f37116a.f37113e);
                    }
                    this.f37116a.c();
                }
            }
        };
        adTemplate.mKsPlayerClickTimeParam = System.currentTimeMillis();
        this.f37109a = adTemplate;
        this.f37110b = com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.f37111c = gVar;
        this.f37112d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.f37112d.a(new c.e(this) { // from class: com.kwad.sdk.draw.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f37115a;

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
                this.f37115a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.f37115a.a(System.currentTimeMillis());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65539, this, j) == null) && this.f37111c.d()) {
            this.f37112d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f37110b, j));
            this.f37112d.f();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f37112d.a(new d.a().a(com.kwad.sdk.core.response.b.c.l(this.f37109a)).a(this.f37109a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.c.a(this.f37109a)).a());
            this.f37112d.e();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f37112d.a() == null) {
                f();
            }
            a(currentTimeMillis);
            this.f37111c.a(this.f37114f);
        }
    }

    @MainThread
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f37112d.a(eVar);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f37113e = null;
            this.f37111c.b(this.f37114f);
            this.f37112d.k();
        }
    }

    @MainThread
    public void b(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f37112d.b(eVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f37112d.h();
            b.a().a(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f37112d.j();
        }
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f37112d) == null) {
            return;
        }
        aVar.p();
        this.f37112d.k();
    }
}
