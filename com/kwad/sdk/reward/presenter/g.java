package com.kwad.sdk.reward.presenter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
/* loaded from: classes2.dex */
public class g extends com.kwad.sdk.reward.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.widget.e f59161b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f59162c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.reward.a.g f59163d;

    public g() {
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
        this.f59162c = new com.kwad.sdk.reward.a.f(this) { // from class: com.kwad.sdk.reward.presenter.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.f59161b != null && this.a.f59161b.e()) {
                        this.a.f59161b.c();
                    } else if (this.a.f59161b != null) {
                        this.a.f59161b.d();
                        this.a.h();
                    }
                }
            }
        };
        this.f59163d = new com.kwad.sdk.reward.a.g(this) { // from class: com.kwad.sdk.reward.presenter.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.reward.a.g
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.f59161b != null && this.a.f59161b.e()) {
                        this.a.f59161b.c();
                        if (((com.kwad.sdk.reward.g) this.a).a != null) {
                            ((com.kwad.sdk.reward.g) this.a).a.b();
                            ((com.kwad.sdk.reward.g) this.a).a.u = true;
                            ((com.kwad.sdk.reward.g) this.a).a.f58878k.a(true);
                        }
                    } else if (this.a.f59161b != null) {
                        this.a.f59161b.d();
                        if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this.a).a.f58874g))) {
                            AdWebViewLandPageActivityProxy.launch(this.a.o(), ((com.kwad.sdk.reward.g) this.a).a.f58874g, true);
                        }
                    }
                }
            }
        };
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((com.kwad.sdk.reward.g) this).a.a(this.f59162c);
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
            com.kwad.sdk.widget.e eVar = aVar.m;
            this.f59161b = eVar;
            eVar.a(aVar.f58874g, aVar.f58877j, aVar.l);
            this.f59161b.b();
            com.kwad.sdk.reward.c.a().a(this.f59163d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f59161b.a();
            this.f59161b.d();
            ((com.kwad.sdk.reward.g) this).a.b(this.f59162c);
            com.kwad.sdk.reward.c.a().b(this.f59163d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            ((KsAdWebView) a(R.id.ksad_playable_webview)).setVisibility(4);
        }
    }
}
