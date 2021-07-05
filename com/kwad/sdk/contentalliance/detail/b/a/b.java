package com.kwad.sdk.contentalliance.detail.b.a;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.contentalliance.a.d;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.i.c;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KsContentPage.SubShowItem f34561b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34562c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.b.b f34563d;

    /* renamed from: e  reason: collision with root package name */
    public int f34564e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f34565f;

    /* renamed from: g  reason: collision with root package name */
    public int f34566g;

    /* renamed from: h  reason: collision with root package name */
    public c f34567h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.c f34568i;
    public com.kwad.sdk.contentalliance.a.a j;

    public b() {
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
        this.f34567h = new c(this) { // from class: com.kwad.sdk.contentalliance.detail.b.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34569a;

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
                this.f34569a = this;
            }

            @Override // com.kwad.sdk.core.i.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f34569a.f34566g == -1) {
                    return;
                }
                this.f34569a.f34566g = -1;
                if (this.f34569a.f34561b != null) {
                    this.f34569a.f34561b.onPageVisibleChange(false);
                }
            }

            @Override // com.kwad.sdk.core.i.c
            public void c_() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f34569a.f34566g == 1) {
                    return;
                }
                this.f34569a.f34566g = 1;
                if (this.f34569a.f34561b != null) {
                    this.f34569a.f34561b.onPageVisibleChange(true);
                }
            }
        };
        this.f34568i = new d(this) { // from class: com.kwad.sdk.contentalliance.detail.b.a.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34570a;

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
                this.f34570a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
            public void c() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f34570a.f34561b == null) {
                    return;
                }
                this.f34570a.f34561b.onPageResume();
            }

            @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f34570a.f34561b == null) {
                    return;
                }
                this.f34570a.f34561b.onPagePause();
            }

            @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
            public void e() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f34570a.f34561b == null) {
                    return;
                }
                this.f34570a.f34561b.onPageCreate();
            }

            @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
            public void f() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.f34570a.f34561b == null) {
                    return;
                }
                this.f34570a.f34561b.onPageDestroy();
            }

            @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
            public void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                }
            }
        };
        this.j = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.b.a.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34571a;

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
                this.f34571a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.j();
                    if (this.f34571a.f34565f == null) {
                        return;
                    }
                    this.f34571a.f34565f.a(this.f34571a.f34567h);
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.k();
                    if (this.f34571a.f34565f == null) {
                        return;
                    }
                    this.f34571a.f34567h.b();
                    this.f34571a.f34565f.b(this.f34571a.f34567h);
                }
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            h hVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34574a;
            if (hVar != null) {
                this.f34565f = hVar.f35240a;
            }
            this.f34566g = 0;
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            AdTemplate adTemplate = cVar.j;
            this.f34562c = adTemplate;
            com.kwad.sdk.contentalliance.detail.b.b bVar = cVar.q;
            this.f34563d = bVar;
            this.f34564e = cVar.f34582i;
            if (bVar == null || adTemplate == null) {
                return;
            }
            KsContentPage.SubShowItem a2 = bVar.a(adTemplate);
            this.f34561b = a2;
            if (a2 == null) {
                return;
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34576c.add(this.f34568i);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            if (cVar != null) {
                cVar.f34575b.remove(this.j);
            }
        }
    }
}
