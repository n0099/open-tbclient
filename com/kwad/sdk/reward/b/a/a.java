package com.kwad.sdk.reward.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.detail.a.c.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.d;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f38825b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f38826c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f38827d;

    /* renamed from: e  reason: collision with root package name */
    public c f38828e;

    /* renamed from: f  reason: collision with root package name */
    public long f38829f;

    /* renamed from: g  reason: collision with root package name */
    public e f38830g;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38829f = 0L;
        this.f38830g = new f(this) { // from class: com.kwad.sdk.reward.b.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f38831a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f38831a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    b.h(this.f38831a.f38825b, ((d) this.f38831a).f39062a.f38814d);
                    this.f38831a.f38828e.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.f38831a.a(j2);
                    this.f38831a.f38829f = j2;
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.b();
                    b.a(this.f38831a.f38825b, ((d) this.f38831a).f39062a.f38814d);
                    b.g(this.f38831a.f38825b, ((d) this.f38831a).f39062a.f38814d);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    super.c();
                    this.f38831a.f38828e.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    super.d();
                    this.f38831a.f38828e.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    super.f();
                    this.f38831a.f38828e.a();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    super.g();
                    this.f38831a.f38828e.a();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.f38827d;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.f38827d) {
                if (ceil >= num.intValue()) {
                    b.b(this.f38825b, ceil, ((d) this).f39062a.f38814d);
                    this.f38827d.remove(num);
                    return;
                }
            }
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f38828e = new c();
            AdTemplate adTemplate = ((d) this).f39062a.f38816f;
            this.f38825b = adTemplate;
            AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
            this.f38826c = j;
            this.f38827d = com.kwad.sdk.core.response.b.a.M(j);
            ((d) this).f39062a.f38819i.a(this.f38830g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((d) this).f39062a.f38819i.b(this.f38830g);
            c.a c2 = this.f38828e.c();
            com.kwad.sdk.core.report.e.a(((d) this).f39062a.f38816f, this.f38829f, c2.b(), c2.a());
        }
    }
}
