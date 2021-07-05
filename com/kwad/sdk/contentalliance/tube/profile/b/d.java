package com.kwad.sdk.contentalliance.tube.profile.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.contentalliance.tube.profile.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35740b;

    /* renamed from: c  reason: collision with root package name */
    public long f35741c;

    /* renamed from: d  reason: collision with root package name */
    public String f35742d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f35743e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35744f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f35745g;

    public d() {
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
        this.f35745g = new com.kwad.sdk.core.i.c(this) { // from class: com.kwad.sdk.contentalliance.tube.profile.b.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f35746a;

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
                this.f35746a = this;
            }

            @Override // com.kwad.sdk.core.i.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35746a.f35741c <= 0) {
                    return;
                }
                com.kwad.sdk.core.report.e.a(this.f35746a.f35743e, System.currentTimeMillis() - this.f35746a.f35741c);
                this.f35746a.f35741c = 0L;
            }

            @Override // com.kwad.sdk.core.i.c
            public void c_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.f35746a.f35740b) {
                        com.kwad.sdk.core.report.e.c(this.f35746a.f35743e);
                    } else {
                        this.f35746a.f35740b = true;
                        com.kwad.sdk.core.report.e.b(this.f35746a.f35743e);
                    }
                    this.f35746a.f35741c = System.currentTimeMillis();
                }
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f35705a.f35709d;
            this.f35744f = aVar;
            if (aVar == null) {
                return;
            }
            aVar.a(this.f35745g);
            com.kwad.sdk.contentalliance.tube.profile.a.b bVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f35705a;
            this.f35743e = bVar.f35711f;
            this.f35742d = String.valueOf(bVar.f35706a.hashCode());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            com.kwad.sdk.core.i.a aVar = this.f35744f;
            if (aVar != null) {
                aVar.b(this.f35745g);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            com.kwad.sdk.core.scene.a.a().c(this.f35742d);
        }
    }
}
