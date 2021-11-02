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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f64096a;

    /* renamed from: b  reason: collision with root package name */
    public long f64097b;

    /* renamed from: c  reason: collision with root package name */
    public e f64098c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f64099d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64100e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64101f;

    /* renamed from: g  reason: collision with root package name */
    public Context f64102g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f64103h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f64104i;
    public final d j;

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
        this.f64104i = false;
        this.j = new d(this) { // from class: com.kwad.sdk.b.c.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f64108a;

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
                this.f64108a = this;
            }

            @Override // com.kwad.sdk.core.j.d
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f64108a.c();
                }
            }

            @Override // com.kwad.sdk.core.j.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f64108a.d();
                }
            }
        };
        this.f64096a = adTemplate;
        this.f64097b = com.kwad.sdk.core.response.b.a.i(c.i(adTemplate));
        this.f64098c = eVar;
        this.f64100e = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        if (ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isDataFlowAutoStart()) {
            z = true;
        }
        this.f64101f = z;
        this.f64102g = detailVideoView.getContext();
        this.f64099d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        if (ksAdVideoPlayConfig != null) {
            try {
                this.f64104i = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
        com.kwad.sdk.contentalliance.detail.video.e eVar2 = new com.kwad.sdk.contentalliance.detail.video.e(this, adTemplate) { // from class: com.kwad.sdk.b.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f64105a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f64106b;

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
                this.f64106b = this;
                this.f64105a = adTemplate;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) {
                    super.a(i4, i5);
                    com.kwad.sdk.core.report.d.b(this.f64105a, i4, i5);
                }
            }
        };
        this.f64103h = eVar2;
        this.f64099d.a(eVar2);
        g();
        this.f64099d.a(new c.e(this) { // from class: com.kwad.sdk.b.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f64107a;

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
                this.f64107a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) && this.f64107a.h() && this.f64107a.f64098c.c()) {
                    this.f64107a.f64099d.a(b.a(this.f64107a.f64096a));
                    this.f64107a.f64099d.e();
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
                aVar = this.f64099d;
                f2 = 1.0f;
            } else {
                aVar = this.f64099d;
                f2 = 0.0f;
            }
            aVar.a(f2, f2);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f64099d.a(new c.a().a(com.kwad.sdk.core.response.b.c.l(this.f64096a)).b(com.kwad.sdk.core.response.b.e.b(com.kwad.sdk.core.response.b.c.j(this.f64096a))).a(this.f64096a.mVideoPlayerStatus).a(this.f64104i).a(b.a(this.f64096a)).a(), true, true);
            a(this.f64100e);
            if (h()) {
                this.f64099d.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (!this.f64101f) {
                this.f64101f = com.ksad.download.d.b.b(this.f64102g);
            }
            return this.f64101f;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j.c(this.f64096a);
            if (this.f64099d.a() == null) {
                g();
            }
            if (h() && this.f64098c.c()) {
                this.f64099d.a(b.a(this.f64096a));
                this.f64099d.e();
            }
            this.f64098c.a(this.j);
        }
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f64099d.a(dVar);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j.a(this.f64096a);
            this.f64098c.b(this.j);
            this.f64099d.h();
        }
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f64099d.b(dVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && h()) {
            if (this.f64100e) {
                com.kwad.sdk.utils.b.a(this.f64102g).a(false);
                if (com.kwad.sdk.utils.b.a(this.f64102g).a()) {
                    this.f64100e = false;
                    a(false);
                }
            }
            this.f64099d.f();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f64099d.g();
        }
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f64099d) == null) {
            return;
        }
        aVar.m();
        this.f64099d.h();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f64101f = true;
            if (this.f64098c.c()) {
                j.b(this.f64096a);
                this.f64099d.a(b.a(this.f64096a));
                this.f64099d.e();
            }
        }
    }
}
