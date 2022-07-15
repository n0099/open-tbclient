package com.kwad.components.ad.reward.presenter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.az;
/* loaded from: classes5.dex */
public final class j extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.video.g b;
    public final com.kwad.components.ad.reward.c.j c;

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.presenter.j.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.d();
                    if (g.a(((a) this.a).a)) {
                        az.a(new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.j.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i3 = newInitContext2.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    ((a) this.a.a).a.c();
                                }
                            }
                        }, 200L);
                    } else {
                        ((a) this.a).a.c();
                    }
                }
            }
        };
        this.c = new com.kwad.components.ad.reward.c.j(this) { // from class: com.kwad.components.ad.reward.presenter.j.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.c.j
            public final void a(com.kwad.components.core.webview.b.kwai.m mVar) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, mVar) == null) && mVar != null && mVar.b == 1) {
                    ((a) this.a).a.j.e();
                    ((a) this.a).a.c();
                }
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((a) this).a.j.a(this.b);
            com.kwad.components.ad.reward.d.a().a(this.c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.k_();
            ((a) this).a.j.b(this.b);
            com.kwad.components.ad.reward.d.a().b(this.c);
        }
    }
}
