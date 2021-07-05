package com.kwad.sdk.contentalliance.home.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes7.dex */
public class i extends com.kwad.sdk.contentalliance.home.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35141b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f35142c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35143d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f35144e;

    /* renamed from: f  reason: collision with root package name */
    public KsFragment f35145f;

    /* renamed from: g  reason: collision with root package name */
    public long f35146g;

    /* renamed from: h  reason: collision with root package name */
    public String f35147h;

    public i() {
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

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f35218a;
            com.kwad.sdk.contentalliance.home.h hVar = fVar.f35224f;
            if (hVar == null) {
                return;
            }
            com.kwad.sdk.core.i.a aVar = hVar.f35240a;
            this.f35141b = aVar;
            if (aVar == null) {
                return;
            }
            this.f35144e = fVar.f35223e;
            KsFragment ksFragment = fVar.f35219a;
            this.f35145f = ksFragment;
            this.f35147h = String.valueOf(ksFragment.hashCode());
            if (this.f35142c == null) {
                com.kwad.sdk.core.i.c cVar = new com.kwad.sdk.core.i.c(this) { // from class: com.kwad.sdk.contentalliance.home.b.i.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ i f35148a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f35148a = this;
                    }

                    @Override // com.kwad.sdk.core.i.c
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35148a.f35144e == null || this.f35148a.f35145f == null || this.f35148a.f35146g <= 0) {
                            return;
                        }
                        com.kwad.sdk.core.report.e.a(this.f35148a.f35144e, System.currentTimeMillis() - this.f35148a.f35146g);
                        this.f35148a.f35146g = 0L;
                    }

                    @Override // com.kwad.sdk.core.i.c
                    public void c_() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            if (this.f35148a.f35143d) {
                                com.kwad.sdk.core.report.e.c(this.f35148a.f35144e);
                            } else {
                                this.f35148a.f35143d = true;
                                com.kwad.sdk.core.report.e.b(this.f35148a.f35144e);
                            }
                            this.f35148a.f35146g = System.currentTimeMillis();
                        }
                    }
                };
                this.f35142c = cVar;
                this.f35141b.a(cVar);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        com.kwad.sdk.core.i.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            com.kwad.sdk.core.i.c cVar = this.f35142c;
            if (cVar == null || (aVar = this.f35141b) == null) {
                return;
            }
            aVar.b(cVar);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            com.kwad.sdk.core.scene.a.a().c(this.f35147h);
        }
    }
}
