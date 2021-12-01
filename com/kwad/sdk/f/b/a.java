package com.kwad.sdk.f.b;

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
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.b;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.core.j.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.m;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public long f58490b;

    /* renamed from: c  reason: collision with root package name */
    public f f58491c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f58492d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f58493e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58494f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58495g;

    /* renamed from: h  reason: collision with root package name */
    public Context f58496h;

    /* renamed from: i  reason: collision with root package name */
    public e f58497i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f58498j;

    /* renamed from: k  reason: collision with root package name */
    public final d f58499k;

    public a(@NonNull AdTemplate adTemplate, @NonNull f fVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, fVar, detailVideoView, ksAdVideoPlayConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        boolean z = false;
        this.f58498j = false;
        this.f58499k = new d(this) { // from class: com.kwad.sdk.f.b.a.3
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

            @Override // com.kwad.sdk.core.j.d
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.c();
                }
            }

            @Override // com.kwad.sdk.core.j.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.d();
                }
            }
        };
        this.a = adTemplate;
        this.f58490b = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f58491c = fVar;
        this.f58494f = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        if (ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isDataFlowAutoStart()) {
            z = true;
        }
        this.f58495g = z;
        this.f58496h = detailVideoView.getContext();
        this.f58492d = detailVideoView;
        this.f58493e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        if (ksAdVideoPlayConfig != null) {
            try {
                this.f58498j = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
        e eVar = new e(this, adTemplate) { // from class: com.kwad.sdk.f.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f58500b;

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
                this.f58500b = this;
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
        this.f58497i = eVar;
        this.f58493e.a(eVar);
        g();
        this.f58493e.a(new c.e(this) { // from class: com.kwad.sdk.f.b.a.2
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) && this.a.h() && this.a.f58491c.c()) {
                    this.a.f58493e.a(b.a(this.a.a));
                    this.a.f58493e.e();
                }
            }
        });
    }

    private void a(boolean z) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
            if (z) {
                aVar = this.f58493e;
                f2 = 1.0f;
            } else {
                aVar = this.f58493e;
                f2 = 0.0f;
            }
            aVar.a(f2, f2);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.f58493e.a(new c.a(this.a).a(com.kwad.sdk.core.response.a.d.m(this.a)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.a))).a(this.a.mVideoPlayerStatus).a(this.f58498j).a(b.a(this.a)).a(), true, true, this.f58492d);
            a(this.f58494f);
            if (h()) {
                this.f58493e.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (!this.f58495g) {
                this.f58495g = com.ksad.download.c.b.b(this.f58496h);
            }
            return this.f58495g;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m.c(this.a);
            if (this.f58493e.a() == null) {
                g();
            }
            if (h() && this.f58491c.c()) {
                this.f58493e.a(b.a(this.a));
                this.f58493e.e();
            }
            this.f58491c.a(this.f58499k);
        }
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f58493e.a(dVar);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            m.a(this.a);
            this.f58491c.b(this.f58499k);
            this.f58493e.h();
        }
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f58493e.b(dVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && h()) {
            if (this.f58494f) {
                com.kwad.sdk.utils.b.a(this.f58496h).a(false);
                if (com.kwad.sdk.utils.b.a(this.f58496h).a()) {
                    this.f58494f = false;
                    a(false);
                }
            }
            this.f58493e.f();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f58493e.g();
        }
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f58493e) == null) {
            return;
        }
        aVar.n();
        this.f58493e.h();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f58495g = true;
            if (this.f58491c.c()) {
                m.b(this.a);
                this.f58493e.a(b.a(this.a));
                this.f58493e.e();
            }
        }
    }
}
