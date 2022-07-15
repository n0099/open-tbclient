package com.kwad.components.ad.reward.presenter.c;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.ad.reward.c.i;
import com.kwad.components.ad.reward.l;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.b.d;
import com.kwad.components.core.webview.b.e;
import com.kwad.components.core.webview.b.kwai.j;
import com.kwad.components.core.webview.b.kwai.p;
import com.kwad.components.core.webview.b.l;
import com.kwad.components.core.webview.b.q;
import com.kwad.components.core.webview.b.r;
import com.kwad.components.core.webview.b.s;
import com.kwad.components.core.webview.b.t;
import com.kwad.sdk.components.g;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.h;
/* loaded from: classes5.dex */
public abstract class a extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.f.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.h.a b;
    public com.kwad.components.ad.reward.f.b c;
    public t d;
    public s e;
    public q f;
    public r g;
    public com.kwad.components.core.webview.b.kwai.q h;
    public final h.a i;
    public final i j;
    public final f k;
    public final com.kwad.components.core.video.h l;

    public a() {
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
        this.i = new h.a(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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

            @Override // com.kwad.sdk.utils.h.a
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.e == null) {
                    return;
                }
                com.kwad.components.core.webview.b.kwai.h hVar = new com.kwad.components.core.webview.b.kwai.h();
                hVar.a = true;
                this.a.e.a(hVar);
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.j = new i(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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

            @Override // com.kwad.components.ad.reward.c.i
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.f == null) {
                    return;
                }
                com.kwad.components.core.webview.b.kwai.f fVar = new com.kwad.components.core.webview.b.kwai.f();
                fVar.a = 1;
                this.a.f.a(fVar);
            }
        };
        this.k = new f(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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

            @Override // com.kwad.components.ad.reward.c.f
            public final void d_() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.g == null) {
                    return;
                }
                az.a(new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.4.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass4 a;

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
                            j jVar = new j();
                            jVar.a = 1;
                            this.a.a.g.a(jVar);
                        }
                    }
                }, 0L);
            }
        };
        this.l = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
            public final void a(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) {
                    this.a.A();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.a.a(j, j2);
                    this.a.a(j2);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.a(0.0d);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    if (((com.kwad.components.ad.reward.presenter.a) this.a).a.v) {
                        this.a.A();
                    } else {
                        this.a.z();
                    }
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void h() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.a.a(0.0d);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.kwad.components.core.webview.b.kwai.q qVar = this.h;
            qVar.b = true;
            qVar.c = false;
            B();
        }
    }

    private void B() {
        t tVar;
        com.kwad.components.core.webview.b.kwai.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (tVar = this.d) == null || (qVar = this.h) == null) {
            return;
        }
        tVar.a(qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Double.valueOf(d)}) == null) {
            com.kwad.components.core.webview.b.kwai.q qVar = this.h;
            qVar.b = false;
            qVar.c = false;
            qVar.a = (int) ((d / 1000.0d) + 0.5d);
            B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            long min = Math.min(com.kwad.sdk.core.response.a.a.r(((com.kwad.components.ad.reward.presenter.a) this).a.g.adInfoList.get(0)), j);
            if (j2 < min - 800) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.D = (int) ((((float) (min - j2)) / 1000.0f) + 0.5f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            com.kwad.sdk.core.report.a.c(lVar.g, 17, lVar.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            com.kwad.sdk.core.report.a.c(lVar.g, 18, lVar.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            com.kwad.sdk.core.report.a.a(lVar.g, 39, lVar.h.getTouchCoords(), ((com.kwad.components.ad.reward.presenter.a) this).a.e);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            com.kwad.sdk.core.report.a.a(lVar.g, 40, lVar.h.getTouchCoords(), ((com.kwad.components.ad.reward.presenter.a) this).a.e);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            com.kwad.sdk.core.report.a.a(lVar.g, 41, lVar.h.getTouchCoords(), ((com.kwad.components.ad.reward.presenter.a) this).a.e);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.b.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            com.kwad.components.core.webview.b.kwai.q qVar = this.h;
            qVar.c = true;
            qVar.b = false;
            qVar.a = com.kwad.sdk.core.response.a.a.c(com.kwad.sdk.core.response.a.d.i(((com.kwad.components.ad.reward.presenter.a) this).a.g));
            B();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (i()) {
                if (this.c == null) {
                    this.c = new com.kwad.components.ad.reward.f.b(u());
                }
                if (this.h == null) {
                    this.h = new com.kwad.components.core.webview.b.kwai.q();
                }
                l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
                this.b = lVar.j;
                this.c.a(lVar.L, lVar.g, this);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void a(com.kwad.components.core.webview.b.kwai.h hVar) {
        com.kwad.components.ad.reward.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) || (aVar = this.b) == null) {
            return;
        }
        aVar.a(!hVar.a, true);
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void a(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            e.a(lVar, false, (e.a) lVar.m());
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void a(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sVar) == null) {
            this.e = sVar;
            this.b.a(this.i);
            az.a(com.kwad.components.core.l.b.a(u()).a() ? new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.components.core.webview.b.kwai.h hVar = new com.kwad.components.core.webview.b.kwai.h();
                        hVar.a = true;
                        this.a.e.a(hVar);
                    }
                }
            } : new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.components.core.webview.b.kwai.h hVar = new com.kwad.components.core.webview.b.kwai.h();
                        hVar.a = !((com.kwad.components.ad.reward.presenter.a) this.a).a.d.isVideoSoundEnable();
                        this.a.e.a(hVar);
                    }
                }
            }, 0L);
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void a(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tVar) == null) {
            this.d = tVar;
            this.b.a(this.l);
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public void a(g gVar, com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, bVar) == null) {
            long j = ((com.kwad.components.ad.reward.presenter.a) this).a.E;
            gVar.a(new com.kwad.components.ad.reward.f.a(j > 0 ? ((int) j) / 1000 : 0));
            q qVar = new q();
            this.f = qVar;
            gVar.a(qVar);
            r rVar = new r();
            this.g = rVar;
            gVar.a(rVar);
            com.kwad.components.ad.reward.c.a().a(this.j);
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(this.k);
            com.kwad.components.core.webview.b.d dVar = new com.kwad.components.core.webview.b.d();
            dVar.a(new d.a(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.webview.b.d.a
                public final void a(com.kwad.components.core.webview.b.kwai.l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, lVar) == null) {
                        com.kwad.components.core.c.a.a.a(new a.C0507a(this.a.u()).a(((com.kwad.components.ad.reward.presenter.a) this.a).a.g).a(((com.kwad.components.ad.reward.presenter.a) this.a).a.k).a(1).a(new a.b(this, lVar) { // from class: com.kwad.components.ad.reward.presenter.c.a.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ com.kwad.components.core.webview.b.kwai.l a;
                            public final /* synthetic */ AnonymousClass1 b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, lVar};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.b = this;
                                this.a = lVar;
                            }

                            @Override // com.kwad.components.core.c.a.a.b
                            public final void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.a.a) {
                                        this.b.a.v();
                                    } else {
                                        this.b.a.w();
                                    }
                                }
                            }
                        }));
                    }
                }
            });
            gVar.a(dVar);
            com.kwad.components.core.webview.b.e eVar = new com.kwad.components.core.webview.b.e();
            eVar.a(new e.a(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.webview.b.e.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.components.core.c.a.a.a(new a.C0507a(this.a.u()).a(((com.kwad.components.ad.reward.presenter.a) this.a).a.g).a(((com.kwad.components.ad.reward.presenter.a) this.a).a.k).a(2).a(new a.b(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.6.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass6 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // com.kwad.components.core.c.a.a.b
                            public final void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.a.a.x();
                                }
                            }
                        }));
                    }
                }
            });
            gVar.a(eVar);
            gVar.a(new com.kwad.components.core.webview.b.l(new l.a(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.webview.b.l.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (com.kwad.components.ad.reward.l.c(((com.kwad.components.ad.reward.presenter.a) this.a).a.g)) {
                            if (!com.kwad.components.ad.reward.l.a(((com.kwad.components.ad.reward.presenter.a) this.a).a.g) || ((com.kwad.components.ad.reward.presenter.a) this.a).a.B == null) {
                                if (com.kwad.components.ad.reward.l.b(((com.kwad.components.ad.reward.presenter.a) this.a).a.g) && ((com.kwad.components.ad.reward.presenter.a) this.a).a.C != null && !((com.kwad.components.ad.reward.presenter.a) this.a).a.C.j()) {
                                    ((com.kwad.components.ad.reward.presenter.a) this.a).a.C.h();
                                }
                            } else if (!((com.kwad.components.ad.reward.presenter.a) this.a).a.B.l()) {
                                ((com.kwad.components.ad.reward.presenter.a) this.a).a.B.h();
                            }
                        }
                        this.a.y();
                    }
                }
            }));
            gVar.a(new com.kwad.components.core.webview.b.c(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.webview.b.c
                public final void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.a.e();
                    }
                }
            });
            gVar.a(new com.kwad.components.core.webview.b.g(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.webview.b.g
                public final void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        com.kwad.components.ad.reward.presenter.e.b(((com.kwad.components.ad.reward.presenter.a) this.a).a, ((com.kwad.components.ad.reward.presenter.a) this.a).a.m());
                    }
                }
            });
            gVar.a(new com.kwad.components.core.webview.b.b(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.webview.b.b
                public final void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.a.d();
                    }
                }
            });
            gVar.a(new com.kwad.components.ad.reward.d.b(u(), ((com.kwad.components.ad.reward.presenter.a) this).a.g, PlayableSource.ACTIONBAR_CLICK));
        }
    }

    public abstract boolean i();

    @Override // com.kwad.components.ad.reward.f.c
    public final com.kwad.sdk.widget.e k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ((com.kwad.components.ad.reward.presenter.a) this).a.h : (com.kwad.sdk.widget.e) invokeV.objValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.k_();
            if (i()) {
                this.c.a();
                this.b.b(this.l);
                this.b.b(this.i);
                com.kwad.components.ad.reward.c.a().b(this.j);
                ((com.kwad.components.ad.reward.presenter.a) this).a.b(this.k);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final com.kwad.sdk.core.webview.a.kwai.a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    ((com.kwad.components.ad.reward.presenter.a) this.a).a.b.a();
                }
            }
        } : (com.kwad.sdk.core.webview.a.kwai.a) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }
}
