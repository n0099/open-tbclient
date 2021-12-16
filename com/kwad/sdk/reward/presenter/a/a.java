package com.kwad.sdk.reward.presenter.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.l;
import com.kwad.sdk.reward.presenter.a.kwai.c;
/* loaded from: classes3.dex */
public class a extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f59603b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f59604c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.e.a f59605d;

    /* renamed from: e  reason: collision with root package name */
    public l.b f59606e;

    /* renamed from: com.kwad.sdk.reward.presenter.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2116a extends com.kwad.sdk.reward.presenter.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2116a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.reward.presenter.a
        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.id.ksad_blur_end_cover : invokeV.intValue;
        }

        @Override // com.kwad.sdk.reward.presenter.a
        public int i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 8;
            }
            return invokeV.intValue;
        }
    }

    public a(com.kwad.sdk.core.e.a<?> aVar, AdTemplate adTemplate, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, adTemplate, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59606e = new l.b(this, null, null) { // from class: com.kwad.sdk.reward.presenter.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, r9, r10};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        Object[] objArr3 = newInitContext2.callArgs;
                        super((l) objArr3[0], (l.a) objArr3[1]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.reward.l.b, com.kwad.sdk.reward.l.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.b();
                    this.a.h();
                }
            }

            @Override // com.kwad.sdk.reward.l.b, com.kwad.sdk.reward.l.a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.c();
                    ((g) this.a).a.a(this.a.q(), 15, 1);
                }
            }

            @Override // com.kwad.sdk.reward.l.b, com.kwad.sdk.reward.l.a
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.d();
                    ((g) this.a).a.a(this.a.q(), 17, 2);
                }
            }
        };
        this.f59604c = adTemplate;
        this.f59605d = aVar;
        this.f59603b = d.j(adTemplate);
        if (z) {
            e();
        } else {
            i();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || com.kwad.sdk.core.response.a.a.an(this.f59603b)) {
            return;
        }
        if (com.kwad.sdk.core.response.a.b.j(this.f59604c)) {
            a(new com.kwad.sdk.reward.presenter.a.kwai.a());
        }
        c cVar = new c();
        cVar.a(this.f59606e);
        a((Presenter) cVar);
        if (com.kwad.sdk.core.response.a.b.h(this.f59604c)) {
            a(new com.kwad.sdk.reward.presenter.a.kwai.d());
        }
        a(new C2116a());
        if (com.kwad.sdk.core.response.a.a.aG(this.f59603b) || !com.kwad.sdk.core.response.a.a.q(this.f59603b)) {
            return;
        }
        a(new com.kwad.sdk.reward.presenter.a.kwai.b());
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            c cVar = new c();
            cVar.a(this.f59606e);
            a((Presenter) cVar);
            if (com.kwad.sdk.core.response.a.b.h(this.f59604c)) {
                a(new com.kwad.sdk.reward.presenter.a.kwai.d());
            }
            if (d.s(this.f59604c)) {
                a(new com.kwad.sdk.reward.presenter.a.kwai.b());
            }
            if (com.kwad.sdk.core.response.a.b.j(this.f59604c)) {
                a(new com.kwad.sdk.reward.presenter.a.kwai.a());
            }
        }
    }
}
