package com.kwad.sdk.contentalliance.detail.a;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f34393b;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f34394c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsContentPage.PageListener f34395d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public KsContentPage.VideoListener f34396e;

    /* renamed from: f  reason: collision with root package name */
    public KsContentPage.ContentItem f34397f;

    /* renamed from: g  reason: collision with root package name */
    public int f34398g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f34399h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34400i;
    public boolean j;
    public boolean k;
    public com.kwad.sdk.contentalliance.a.a l;
    public com.kwad.sdk.core.i.c m;
    public com.kwad.sdk.contentalliance.detail.video.e n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(976751626, "Lcom/kwad/sdk/contentalliance/detail/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(976751626, "Lcom/kwad/sdk/contentalliance/detail/a/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34400i = false;
        this.j = false;
        this.k = false;
        this.l = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f34401a;

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
                this.f34401a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34401a.f34400i = false;
                    this.f34401a.j = false;
                    this.f34401a.k = false;
                    this.f34401a.f34394c.a(this.f34401a.m);
                    if (this.f34401a.f34399h != null) {
                        this.f34401a.f34399h.a(this.f34401a.n);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.f34401a.j) {
                        this.f34401a.h();
                    }
                    this.f34401a.f();
                    this.f34401a.f34394c.b(this.f34401a.m);
                    if (this.f34401a.f34399h != null) {
                        this.f34401a.f34399h.b(this.f34401a.n);
                    }
                }
            }
        };
        this.m = new com.kwad.sdk.core.i.c(this) { // from class: com.kwad.sdk.contentalliance.detail.a.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f34402a;

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
                this.f34402a = this;
            }

            @Override // com.kwad.sdk.core.i.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34402a.h();
                }
            }

            @Override // com.kwad.sdk.core.i.c
            public void c_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34402a.e();
                    this.f34402a.g();
                }
            }
        };
        this.n = new f(this) { // from class: com.kwad.sdk.contentalliance.detail.a.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f34403a;

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
                this.f34403a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34403a.s();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5) == null) {
                    this.f34403a.a(i4, i5);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f34403a.e();
                    this.f34403a.g();
                    this.f34403a.p();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    if (!this.f34403a.f34394c.e()) {
                        this.f34403a.h();
                    }
                    this.f34403a.q();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    if (this.f34403a.f34394c.e()) {
                        this.f34403a.g();
                    }
                    this.f34403a.r();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, this, i2, i3) == null) {
            if (f34393b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f34398g + " onVideoPlayError");
            }
            KsContentPage.VideoListener videoListener = this.f34396e;
            if (videoListener != null) {
                videoListener.onVideoPlayError(this.f34397f, i2, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.f34400i) {
            return;
        }
        this.f34400i = true;
        if (f34393b) {
            com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f34398g + " onPageEnter");
        }
        KsContentPage.PageListener pageListener = this.f34395d;
        if (pageListener != null) {
            pageListener.onPageEnter(this.f34397f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && this.f34400i) {
            if (f34393b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f34398g + " onPageLeave");
            }
            KsContentPage.PageListener pageListener = this.f34395d;
            if (pageListener != null) {
                pageListener.onPageLeave(this.f34397f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (!this.j) {
                if (f34393b) {
                    com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f34398g + " onPageResume");
                }
                KsContentPage.PageListener pageListener = this.f34395d;
                if (pageListener != null) {
                    pageListener.onPageResume(this.f34397f);
                }
            }
            this.j = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            if (this.j) {
                if (f34393b) {
                    com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f34398g + " onPagePause");
                }
                KsContentPage.PageListener pageListener = this.f34395d;
                if (pageListener != null) {
                    pageListener.onPagePause(this.f34397f);
                }
            }
            this.j = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            if (f34393b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f34398g + " onVideoPlayStart");
            }
            KsContentPage.VideoListener videoListener = this.f34396e;
            if (videoListener != null) {
                videoListener.onVideoPlayStart(this.f34397f);
            }
            this.k = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            if (f34393b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f34398g + " onVideoPlayPaused");
            }
            this.k = true;
            KsContentPage.VideoListener videoListener = this.f34396e;
            if (videoListener != null) {
                videoListener.onVideoPlayPaused(this.f34397f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            if (this.k) {
                if (f34393b) {
                    com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f34398g + " onVideoPlayResume");
                }
                KsContentPage.VideoListener videoListener = this.f34396e;
                if (videoListener != null) {
                    videoListener.onVideoPlayResume(this.f34397f);
                }
            }
            this.k = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            if (f34393b) {
                com.kwad.sdk.core.d.a.a("DetailOpenListener", "position: " + this.f34398g + " onVideoPlayCompleted");
            }
            KsContentPage.VideoListener videoListener = this.f34396e;
            if (videoListener != null) {
                videoListener.onVideoPlayCompleted(this.f34397f);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        KsContentPage.ContentItem contentItem;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            h hVar = cVar.f34574a;
            if (hVar == null) {
                com.kwad.sdk.core.d.a.c("DetailOpenListener", "homePageHelper is null");
                return;
            }
            this.f34394c = hVar.f35240a;
            this.f34395d = hVar.f35241b;
            this.f34396e = hVar.f35242c;
            AdTemplate adTemplate = cVar.j;
            this.f34398g = cVar.f34582i;
            KsContentPage.ContentItem contentItem2 = new KsContentPage.ContentItem();
            this.f34397f = contentItem2;
            contentItem2.id = t.a(String.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)));
            this.f34397f.position = this.f34398g;
            if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                contentItem = this.f34397f;
                i2 = 1;
            } else if (com.kwad.sdk.core.response.b.c.c(adTemplate)) {
                contentItem = this.f34397f;
                i2 = 2;
            } else if (!com.kwad.sdk.core.response.b.c.d(adTemplate)) {
                this.f34397f.materialType = 0;
                ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(0, this.l);
                this.f34399h = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            } else {
                contentItem = this.f34397f;
                i2 = 3;
            }
            contentItem.materialType = i2;
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(0, this.l);
            this.f34399h = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            if (cVar.f34574a == null) {
                return;
            }
            cVar.f34575b.remove(this.l);
        }
    }
}
