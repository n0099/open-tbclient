package com.kwad.sdk.feed.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.feed.a.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37397c;

    /* renamed from: d  reason: collision with root package name */
    public long f37398d;

    /* renamed from: e  reason: collision with root package name */
    public String f37399e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f37400f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f37401g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f37402h;

    public c() {
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
        this.f37402h = new com.kwad.sdk.core.i.c(this) { // from class: com.kwad.sdk.feed.a.c.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f37403a;

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
                this.f37403a = this;
            }

            @Override // com.kwad.sdk.core.i.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f37403a.f37398d <= 0) {
                    return;
                }
                e.a(this.f37403a.f37400f, System.currentTimeMillis() - this.f37403a.f37398d);
                this.f37403a.f37398d = 0L;
            }

            @Override // com.kwad.sdk.core.i.c
            public void c_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.f37403a.f37397c) {
                        e.c(this.f37403a.f37400f);
                    } else {
                        this.f37403a.f37397c = true;
                        e.b(this.f37403a.f37400f);
                    }
                    this.f37403a.f37398d = System.currentTimeMillis();
                }
            }
        };
    }

    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.feed.a.b.a) this).f37377a.f37379b;
            this.f37401g = aVar;
            if (aVar == null) {
                return;
            }
            aVar.a(this.f37402h);
            com.kwad.sdk.feed.a.b.b bVar = ((com.kwad.sdk.feed.a.b.a) this).f37377a;
            this.f37400f = bVar.f37378a;
            this.f37399e = String.valueOf(bVar.f38467e.hashCode());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            com.kwad.sdk.core.i.a aVar = this.f37401g;
            if (aVar != null) {
                aVar.b(this.f37402h);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            com.kwad.sdk.core.scene.a.a().c(this.f37399e);
        }
    }
}
