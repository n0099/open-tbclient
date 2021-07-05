package com.kwad.sdk.contentalliance.detail.a.c;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.detail.a.c.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aj;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f34404b;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f34405c;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f34406d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34407e;

    /* renamed from: f  reason: collision with root package name */
    public int f34408f;

    /* renamed from: g  reason: collision with root package name */
    public aj f34409g;

    /* renamed from: h  reason: collision with root package name */
    public aj f34410h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34411i;
    public long j;
    public int k;
    public SlidePlayViewPager l;
    public c m;
    public e n;
    public com.kwad.sdk.contentalliance.a.a o;
    public com.kwad.sdk.core.i.c p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1939533704, "Lcom/kwad/sdk/contentalliance/detail/a/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1939533704, "Lcom/kwad/sdk/contentalliance/detail/a/c/a;");
        }
    }

    public a() {
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
        this.f34411i = false;
        this.n = new f(this) { // from class: com.kwad.sdk.contentalliance.detail.a.c.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34412a;

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
                this.f34412a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.a();
                    this.f34412a.f34410h.c();
                    if (a.f34404b) {
                        com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f34412a.f34408f + " onVideoPlayCompleted playDuration: " + this.f34412a.f34410h.f());
                    }
                    a.d(this.f34412a);
                    this.f34412a.j = 0L;
                    this.f34412a.m.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5) == null) {
                    super.a(i4, i5);
                    this.f34412a.f34410h.c();
                    this.f34412a.m.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    super.a(j, j2);
                    this.f34412a.j = j2;
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    super.b();
                    if (this.f34412a.f34410h.e()) {
                        this.f34412a.f34410h.b();
                    }
                    if (a.f34404b) {
                        com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f34412a.f34408f + " onVideoPlayStart resumeTiming playDuration: " + this.f34412a.f34410h.f());
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    super.c();
                    this.f34412a.f34410h.c();
                    if (a.f34404b) {
                        com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f34412a.f34408f + " onVideoPlayPaused playDuration: " + this.f34412a.f34410h.f());
                    }
                    this.f34412a.m.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                StringBuilder sb;
                String str;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    super.d();
                    if (this.f34412a.f34410h.e()) {
                        this.f34412a.f34410h.b();
                        if (a.f34404b) {
                            sb = new StringBuilder();
                            sb.append("position: ");
                            sb.append(this.f34412a.f34408f);
                            str = " onVideoPlaying resumeTiming playDuration: ";
                            sb.append(str);
                            sb.append(this.f34412a.f34410h.f());
                            com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", sb.toString());
                        }
                        this.f34412a.m.b();
                    }
                    this.f34412a.f34410h.a();
                    if (a.f34404b) {
                        sb = new StringBuilder();
                        sb.append("position: ");
                        sb.append(this.f34412a.f34408f);
                        str = " onVideoPlaying startTiming playDuration: ";
                        sb.append(str);
                        sb.append(this.f34412a.f34410h.f());
                        com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", sb.toString());
                    }
                    this.f34412a.m.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    super.f();
                    this.f34412a.m.a();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                    super.g();
                    this.f34412a.m.a();
                }
            }
        };
        this.o = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.a.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34413a;

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
                this.f34413a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.j();
                    if (a.f34404b) {
                        com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f34413a.f34408f + " becomesAttachedOnPageSelected");
                    }
                    if (this.f34413a.f34405c == null) {
                        com.kwad.sdk.core.d.a.c("DetailLogPagePresenter", "mVisibleHelper is null");
                    } else {
                        this.f34413a.f34405c.a(this.f34413a.p);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.k();
                    if (a.f34404b) {
                        com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f34413a.f34408f + " becomesDetachedOnPageSelected");
                    }
                    if (this.f34413a.f34405c == null) {
                        com.kwad.sdk.core.d.a.c("DetailLogPagePresenter", "mVisibleHelper is null");
                        return;
                    }
                    this.f34413a.f34405c.b(this.f34413a.p);
                    this.f34413a.a(this.f34413a.f34409g.d(), this.f34413a.f34410h.d());
                    this.f34413a.f();
                }
            }
        };
        this.p = new com.kwad.sdk.core.i.c(this) { // from class: com.kwad.sdk.contentalliance.detail.a.c.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34414a;

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
                this.f34414a = this;
            }

            @Override // com.kwad.sdk.core.i.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34414a.f34409g.c();
                    if (a.f34404b) {
                        com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f34414a.f34408f + " onPageInvisible stayDuration: " + this.f34414a.f34409g.f());
                    }
                }
            }

            @Override // com.kwad.sdk.core.i.c
            public void c_() {
                StringBuilder sb;
                String str;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34414a.g();
                    if (this.f34414a.f34409g.e()) {
                        this.f34414a.f34409g.b();
                        if (!a.f34404b) {
                            return;
                        }
                        sb = new StringBuilder();
                        sb.append("position: ");
                        sb.append(this.f34414a.f34408f);
                        str = " onPageVisible resumeTiming stayDuration: ";
                    } else {
                        this.f34414a.f34409g.a();
                        if (!a.f34404b) {
                            return;
                        }
                        sb = new StringBuilder();
                        sb.append("position: ");
                        sb.append(this.f34414a.f34408f);
                        str = " onPageVisible startTiming stayDuration: ";
                    }
                    sb.append(str);
                    sb.append(this.f34414a.f34409g.f());
                    com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", sb.toString());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65540, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j == 0) {
            return;
        }
        long b2 = com.kwad.sdk.core.response.b.c.c(this.f34407e) ? com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(this.f34407e)) * 1000 : d.c(com.kwad.sdk.core.response.b.c.k(this.f34407e)).longValue();
        if (f34404b) {
            com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f34408f + " reportPlayFinish videoDuration: " + b2 + " stayDuration: " + j + " playDuration " + j2);
        }
        int i2 = (this.k <= 0 || this.j != 0) ? 2 : 1;
        c.a c2 = this.m.c();
        com.kwad.sdk.core.report.e.a(this.f34406d, this.f34407e, j2, i2, j, c2.b(), c2.a());
    }

    public static /* synthetic */ int d(a aVar) {
        int i2 = aVar.k;
        aVar.k = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.k = 0;
            this.j = 0L;
            this.f34411i = false;
            c cVar = this.m;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || this.f34411i) {
            return;
        }
        this.f34411i = true;
        SlidePlayViewPager slidePlayViewPager = this.l;
        if (slidePlayViewPager == null) {
            return;
        }
        int preItem = slidePlayViewPager.getPreItem();
        int currentItem = this.l.getCurrentItem();
        int i2 = currentItem <= preItem ? currentItem < preItem ? 2 : 3 : 1;
        if (f34404b) {
            com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f34408f + " reportItemImpression enterType=" + i2);
        }
        com.kwad.sdk.core.report.e.a(this.f34407e, i2);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            h hVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34574a;
            if (hVar != null) {
                this.f34405c = hVar.f35240a;
                this.f34406d = hVar.k;
            }
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            this.f34407e = cVar.j;
            this.f34408f = cVar.f34582i;
            this.l = cVar.l;
            this.f34409g = new aj();
            this.f34410h = new aj();
            this.m = new c();
            f();
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(0, this.o);
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            if (bVar != null) {
                this.f34407e.mMediaPlayerType = bVar.c();
                ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m.a(this.n);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.o);
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            if (bVar != null) {
                bVar.b(this.n);
            }
        }
    }
}
