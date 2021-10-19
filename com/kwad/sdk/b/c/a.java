package com.kwad.sdk.b.c;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.b;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.core.j.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.j;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f71619a;

    /* renamed from: b  reason: collision with root package name */
    public long f71620b;

    /* renamed from: c  reason: collision with root package name */
    public e f71621c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f71622d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71623e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f71624f;

    /* renamed from: g  reason: collision with root package name */
    public Context f71625g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f71626h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f71627i;

    /* renamed from: j  reason: collision with root package name */
    public final d f71628j;

    public a(@NonNull AdTemplate adTemplate, @NonNull e eVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, eVar, detailVideoView, ksAdVideoPlayConfig};
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
        this.f71627i = false;
        this.f71628j = new d(this) { // from class: com.kwad.sdk.b.c.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f71632a;

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
                this.f71632a = this;
            }

            @Override // com.kwad.sdk.core.j.d
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f71632a.c();
                }
            }

            @Override // com.kwad.sdk.core.j.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f71632a.d();
                }
            }
        };
        this.f71619a = adTemplate;
        this.f71620b = com.kwad.sdk.core.response.b.a.i(c.i(adTemplate));
        this.f71621c = eVar;
        this.f71623e = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        if (ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isDataFlowAutoStart()) {
            z = true;
        }
        this.f71624f = z;
        this.f71625g = detailVideoView.getContext();
        this.f71622d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        if (ksAdVideoPlayConfig != null) {
            try {
                this.f71627i = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
        com.kwad.sdk.contentalliance.detail.video.e eVar2 = new com.kwad.sdk.contentalliance.detail.video.e(this, adTemplate) { // from class: com.kwad.sdk.b.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f71629a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f71630b;

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
                this.f71630b = this;
                this.f71629a = adTemplate;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) {
                    super.a(i4, i5);
                    com.kwad.sdk.core.report.d.b(this.f71629a, i4, i5);
                }
            }
        };
        this.f71626h = eVar2;
        this.f71622d.a(eVar2);
        g();
        this.f71622d.a(new c.e(this) { // from class: com.kwad.sdk.b.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f71631a;

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
                this.f71631a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) && this.f71631a.h() && this.f71631a.f71621c.c()) {
                    this.f71631a.f71622d.a(b.a(this.f71631a.f71619a));
                    this.f71631a.f71622d.e();
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
                aVar = this.f71622d;
                f2 = 1.0f;
            } else {
                aVar = this.f71622d;
                f2 = 0.0f;
            }
            aVar.a(f2, f2);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f71622d.a(new c.a().a(com.kwad.sdk.core.response.b.c.l(this.f71619a)).b(com.kwad.sdk.core.response.b.e.b(com.kwad.sdk.core.response.b.c.j(this.f71619a))).a(this.f71619a.mVideoPlayerStatus).a(this.f71627i).a(b.a(this.f71619a)).a());
            a(this.f71623e);
            if (h()) {
                this.f71622d.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (!this.f71624f) {
                this.f71624f = com.ksad.download.d.b.b(this.f71625g);
            }
            return this.f71624f;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j.c(this.f71619a);
            if (this.f71622d.a() == null) {
                g();
            }
            if (h() && this.f71621c.c()) {
                this.f71622d.a(b.a(this.f71619a));
                this.f71622d.e();
            }
            this.f71621c.a(this.f71628j);
        }
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f71622d.a(dVar);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j.a(this.f71619a);
            this.f71621c.b(this.f71628j);
            this.f71622d.h();
        }
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f71622d.b(dVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && h()) {
            if (this.f71623e) {
                com.kwad.sdk.utils.b.a(this.f71625g).a(false);
                if (com.kwad.sdk.utils.b.a(this.f71625g).a()) {
                    this.f71623e = false;
                    a(false);
                }
            }
            this.f71622d.f();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f71622d.g();
        }
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f71622d) == null) {
            return;
        }
        aVar.m();
        this.f71622d.h();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f71624f = true;
            if (this.f71621c.c()) {
                j.b(this.f71619a);
                this.f71622d.a(b.a(this.f71619a));
                this.f71622d.e();
            }
        }
    }
}
