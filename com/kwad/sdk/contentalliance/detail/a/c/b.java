package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f34415b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34416c;

    /* renamed from: d  reason: collision with root package name */
    public int f34417d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f34418e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f34419f;

    /* renamed from: g  reason: collision with root package name */
    public long f34420g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34421h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34422i;
    public volatile long j;
    public boolean k;
    public e l;
    public com.kwad.sdk.contentalliance.a.a m;
    public com.kwad.sdk.core.i.c n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1939533673, "Lcom/kwad/sdk/contentalliance/detail/a/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1939533673, "Lcom/kwad/sdk/contentalliance/detail/a/c/b;");
        }
    }

    public b() {
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
        this.f34420g = 0L;
        this.f34421h = false;
        this.f34422i = true;
        this.k = false;
        this.l = new f(this) { // from class: com.kwad.sdk.contentalliance.detail.a.c.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34423a;

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
                this.f34423a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.b();
                    this.f34423a.f34422i = false;
                    if (!this.f34423a.k) {
                        this.f34423a.f34420g = SystemClock.elapsedRealtime();
                    }
                    this.f34423a.j = SystemClock.elapsedRealtime();
                    if (b.f34415b) {
                        com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + this.f34423a.f34417d + " onVideoPlayStart");
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.c();
                    this.f34423a.f34422i = true;
                    if (this.f34423a.f34421h) {
                        com.kwad.sdk.core.report.e.a(this.f34423a.f34419f, this.f34423a.f34416c, this.f34423a.j > 0 ? SystemClock.elapsedRealtime() - this.f34423a.j : -1L);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.d();
                    if (b.f34415b) {
                        com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + this.f34423a.f34417d + " onVideoPlaying");
                    }
                    this.f34423a.g();
                    this.f34423a.j = SystemClock.elapsedRealtime();
                    if (this.f34423a.f34421h && this.f34423a.f34422i) {
                        com.kwad.sdk.core.report.e.b(this.f34423a.f34416c);
                    }
                    this.f34423a.f34422i = false;
                }
            }
        };
        this.m = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.a.c.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34424a;

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
                this.f34424a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.j();
                    if (b.f34415b) {
                        com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + this.f34424a.f34417d + " becomesAttachedOnPageSelected");
                    }
                    this.f34424a.f34420g = SystemClock.elapsedRealtime();
                    if (this.f34424a.f34418e == null) {
                        com.kwad.sdk.core.d.a.c("DetailLogVideoPresenter", "mVisibleHelper is null");
                    } else {
                        this.f34424a.f34418e.a(this.f34424a.n);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.k();
                    if (b.f34415b) {
                        com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + this.f34424a.f34417d + " becomesDetachedOnPageSelected");
                    }
                    if (this.f34424a.f34418e == null) {
                        com.kwad.sdk.core.d.a.c("DetailLogVideoPresenter", "mVisibleHelper is null");
                        return;
                    }
                    this.f34424a.f34418e.b(this.f34424a.n);
                    this.f34424a.f();
                }
            }
        };
        this.n = new com.kwad.sdk.core.i.c(this) { // from class: com.kwad.sdk.contentalliance.detail.a.c.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34425a;

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
                this.f34425a = this;
            }

            @Override // com.kwad.sdk.core.i.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34425a.k = false;
                }
            }

            @Override // com.kwad.sdk.core.i.c
            public void c_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (b.f34415b) {
                        com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + this.f34425a.f34417d + " onPageVisible");
                    }
                    this.f34425a.k = true;
                    this.f34425a.f34420g = SystemClock.elapsedRealtime();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.k = false;
            this.f34421h = false;
            this.f34422i = false;
            this.j = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || this.f34421h) {
            return;
        }
        this.f34421h = true;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f34420g;
        if (f34415b) {
            com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + this.f34417d + " startPlayDuration startPlayDuration: " + elapsedRealtime);
        }
        com.kwad.sdk.core.report.e.a(this.f34416c, elapsedRealtime);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            h hVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34574a;
            if (hVar != null) {
                this.f34418e = hVar.f35240a;
                this.f34419f = hVar.k;
            }
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            this.f34416c = cVar.j;
            this.f34417d = cVar.f34582i;
            f();
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.m);
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            if (bVar != null) {
                bVar.a(this.l);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.m);
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            if (bVar != null) {
                bVar.b(this.l);
            }
        }
    }
}
