package com.kwad.sdk.a.c;

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
import com.ksad.download.d.b;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.view.g;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f34138a;

    /* renamed from: b  reason: collision with root package name */
    public long f34139b;

    /* renamed from: c  reason: collision with root package name */
    public g f34140c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f34141d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34142e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34143f;

    /* renamed from: g  reason: collision with root package name */
    public Context f34144g;

    /* renamed from: h  reason: collision with root package name */
    public f f34145h;

    /* renamed from: i  reason: collision with root package name */
    public g.a f34146i;

    public a(@NonNull AdTemplate adTemplate, @NonNull g gVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, gVar, detailVideoView, ksAdVideoPlayConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34146i = new g.a(this) { // from class: com.kwad.sdk.a.c.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34150a;

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
                this.f34150a = this;
            }

            @Override // com.kwad.sdk.core.view.g.a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    if (z) {
                        this.f34150a.c();
                    } else {
                        this.f34150a.d();
                    }
                }
            }
        };
        this.f34138a = adTemplate;
        this.f34139b = com.kwad.sdk.core.response.b.a.k(c.j(adTemplate));
        this.f34140c = gVar;
        boolean z = true;
        this.f34142e = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        this.f34143f = (ksAdVideoPlayConfig == null || !ksAdVideoPlayConfig.isDataFlowAutoStart()) ? false : false;
        this.f34144g = detailVideoView.getContext();
        this.f34141d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f fVar = new f(this, adTemplate) { // from class: com.kwad.sdk.a.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdTemplate f34147a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f34148b;

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
                this.f34148b = this;
                this.f34147a = adTemplate;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) {
                    super.a(i4, i5);
                    e.b(this.f34147a, i4, i5);
                }
            }
        };
        this.f34145h = fVar;
        this.f34141d.a(fVar);
        g();
        this.f34141d.a(new c.e(this) { // from class: com.kwad.sdk.a.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34149a;

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
                this.f34149a = this;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) && this.f34149a.h() && this.f34149a.f34140c.d()) {
                    this.f34149a.f34141d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f34149a.f34139b, System.currentTimeMillis()));
                    this.f34149a.f34141d.f();
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
                aVar = this.f34141d;
                f2 = 1.0f;
            } else {
                aVar = this.f34141d;
                f2 = 0.0f;
            }
            aVar.a(f2, f2);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f34141d.a(new d.a().a(com.kwad.sdk.core.response.b.c.l(this.f34138a)).a(this.f34138a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.c.a(this.f34138a)).a());
            a(this.f34142e);
            if (h()) {
                this.f34141d.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (!this.f34143f) {
                this.f34143f = b.b(this.f34144g);
            }
            return this.f34143f;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f34141d.a() == null) {
                g();
            }
            if (h() && this.f34140c.d()) {
                this.f34141d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f34139b, currentTimeMillis));
                this.f34141d.f();
            }
            this.f34140c.a(this.f34146i);
        }
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f34141d.a(eVar);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f34140c.b(this.f34146i);
            this.f34141d.k();
        }
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f34141d.b(eVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && h()) {
            if (this.f34142e) {
                com.kwad.sdk.utils.b.a().a(false);
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f34142e = false;
                    a(false);
                }
            }
            this.f34141d.h();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f34141d.j();
        }
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f34141d) == null) {
            return;
        }
        aVar.p();
        this.f34141d.k();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f34143f = true;
            if (this.f34140c.d()) {
                this.f34141d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f34139b, System.currentTimeMillis()));
                this.f34141d.f();
            }
        }
    }
}
