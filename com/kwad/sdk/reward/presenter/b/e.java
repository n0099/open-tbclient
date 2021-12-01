package com.kwad.sdk.reward.presenter.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes2.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.c f59103b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.a.b f59104c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59105d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59106e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59107f;

    /* renamed from: g  reason: collision with root package name */
    public f f59108g;

    public e(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59108g = new f(this) { // from class: com.kwad.sdk.reward.presenter.b.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

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

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (com.kwad.sdk.core.response.a.a.q(com.kwad.sdk.core.response.a.d.j(((g) this.a).a.f58874g))) {
                        this.a.m().findViewById(this.a.i()).setVisibility(8);
                    }
                    this.a.s();
                }
            }
        };
        this.f59105d = z;
        this.f59106e = z2;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(8);
            m().findViewById(R.id.ksad_play_end_top_toolbar).setVisibility(8);
            super.a();
            ((g) this).a.a(this.f59108g);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            aVar.a = (int) ((bb.b(q()) / bb.c(q())) + 0.5f);
            aVar.f57994b = 44;
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            if (this.f59107f) {
                this.f59104c.j();
                this.f59103b.j();
            }
            ((g) this).a.b(this.f59108g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c_();
            this.f59103b = new com.kwad.sdk.reward.presenter.platdetail.c(this.f59106e);
            this.f59104c = new com.kwad.sdk.reward.presenter.a.b(this.f59105d);
            this.f59103b.c(m());
            this.f59104c.c(m());
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.d_();
            if (this.f59107f) {
                this.f59104c.k();
                this.f59103b.k();
            }
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "ksad-video-top-bar.js" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.id.ksad_js_top : invokeV.intValue;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f59107f = true;
            m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(0);
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            aVar.t = false;
            this.f59104c.a(aVar);
            this.f59103b.a(((g) this).a);
        }
    }
}
