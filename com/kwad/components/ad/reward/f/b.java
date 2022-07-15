package com.kwad.components.ad.reward.f;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.f.kwai.d;
import com.kwad.components.core.page.SimpleWebViewActivity;
import com.kwad.components.core.video.h;
import com.kwad.components.core.webview.b.j;
import com.kwad.components.core.webview.b.kwai.m;
import com.kwad.components.core.webview.b.kwai.q;
import com.kwad.components.core.webview.b.s;
import com.kwad.components.core.webview.b.t;
import com.kwad.components.core.webview.b.u;
import com.kwad.components.core.webview.b.v;
import com.kwad.components.core.webview.b.w;
import com.kwad.components.core.webview.b.x;
import com.kwad.components.core.webview.b.y;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.kwad.sdk.components.g;
import com.kwad.sdk.core.download.e;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.az;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Future;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public final Context b;
    public d c;
    public AdTemplate d;
    public c e;
    public com.kwad.components.core.offline.api.kwai.a f;
    public Future<?> g;
    public g h;
    public final q i;
    public t j;
    public com.kwad.sdk.core.download.g k;
    public StyleTemplate l;
    public long m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public long r;
    public long s;
    public long t;
    public final Runnable u;
    public final h v;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.u = new Runnable(this) { // from class: com.kwad.components.ad.reward.f.b.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.d.b.a("TKLoadController", "已经超时");
                    this.a.h();
                    this.a.n = true;
                    this.a.d();
                }
            }
        };
        this.v = new h(this) { // from class: com.kwad.components.ad.reward.f.b.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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

            private void a(double d) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(65537, this, new Object[]{Double.valueOf(d)}) == null) {
                    this.a.i.b = false;
                    this.a.i.c = false;
                    this.a.i.a = (int) ((d / 1000.0d) + 0.5d);
                    i();
                }
            }

            private void i() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(65538, this) == null) || this.a.j == null || this.a.i == null) {
                    return;
                }
                this.a.j.a(this.a.i);
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) {
                    this.a.i.b = true;
                    this.a.i.c = false;
                    i();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    a(j2);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    a(0.0d);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.a.i.c = true;
                    this.a.i.b = false;
                    this.a.i.a = com.kwad.sdk.core.response.a.a.c(com.kwad.sdk.core.response.a.d.i(this.a.d));
                    i();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void h() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    a(0.0d);
                }
            }
        };
        this.b = context;
        this.i = new q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o.a aVar) {
        FrameLayout g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, aVar) == null) || (g = this.e.g()) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) g.getLayoutParams();
        layoutParams.height = com.kwad.sdk.b.kwai.a.a(this.b, aVar.a);
        layoutParams.leftMargin = com.kwad.sdk.b.kwai.a.a(this.b, aVar.b);
        layoutParams.rightMargin = com.kwad.sdk.b.kwai.a.a(this.b, aVar.c);
        layoutParams.bottomMargin = com.kwad.sdk.b.kwai.a.a(this.b, aVar.d);
        layoutParams.width = -1;
        g.setLayoutParams(layoutParams);
    }

    private void a(g gVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, gVar, viewGroup) == null) {
            com.kwad.components.core.c.a.b bVar = new com.kwad.components.core.c.a.b(this.d);
            u uVar = new u();
            uVar.a(new u.a(this) { // from class: com.kwad.components.ad.reward.f.b.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.components.core.webview.b.u.a
                public final void a(m mVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mVar) == null) {
                        com.kwad.components.ad.reward.d.a().a(mVar);
                    }
                }
            });
            gVar.a(uVar);
            com.kwad.sdk.core.webview.b bVar2 = new com.kwad.sdk.core.webview.b();
            bVar2.a(this.d);
            bVar2.a = !ae.e(this.b) ? 1 : 0;
            bVar2.b = this.e.k();
            bVar2.d = viewGroup;
            bVar2.e = null;
            this.e.a(gVar, bVar2);
            w wVar = new w();
            wVar.a(new w.a(this) { // from class: com.kwad.components.ad.reward.f.b.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.components.core.webview.b.w.a
                public final void a(com.kwad.components.core.webview.b.kwai.o oVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, oVar) == null) || TextUtils.isEmpty(oVar.a)) {
                        return;
                    }
                    com.kwad.sdk.utils.t.b(this.a.b, oVar.a, 0L);
                }
            });
            gVar.a(wVar);
            gVar.a(new com.kwad.sdk.core.webview.a.a());
            gVar.a(new j());
            gVar.a(new f(bVar2, bVar, this.e.m()));
            gVar.a(new com.kwad.components.core.webview.jshandler.d(bVar2, bVar, this.e.m()));
            gVar.a(new i(bVar2));
            gVar.a(new l(bVar2));
            com.kwad.components.core.webview.jshandler.h hVar = new com.kwad.components.core.webview.jshandler.h(bVar2);
            hVar.a(new h.b(this) { // from class: com.kwad.components.ad.reward.f.b.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.components.core.webview.jshandler.h.b
                public final void a(h.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.a.e.a(aVar);
                    }
                }
            });
            gVar.a(hVar);
            gVar.a(new o(bVar2, new o.b(this) { // from class: com.kwad.components.ad.reward.f.b.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.components.core.webview.jshandler.o.b
                public final void a(o.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.a.a(aVar);
                    }
                }
            }));
            gVar.a(new com.kwad.components.core.webview.jshandler.u(new u.b(this) { // from class: com.kwad.components.ad.reward.f.b.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.components.core.webview.jshandler.u.b
                public final void a(u.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        if (aVar.a != 1) {
                            this.a.d();
                            this.a.b(aVar.b);
                            return;
                        }
                        this.a.g();
                        if (this.a.e != null) {
                        }
                    }
                }
            }));
            gVar.a(new x());
            gVar.a(new z(bVar2, bVar));
            gVar.a(new n(new n.b(this) { // from class: com.kwad.components.ad.reward.f.b.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.components.core.webview.jshandler.n.b
                public final void a(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        this.a.e.g().setVisibility(8);
                    }
                }
            }));
            gVar.a(new p(bVar2));
            t tVar = new t();
            this.j = tVar;
            gVar.a(tVar);
            this.e.a(this.j);
            if (com.kwad.sdk.core.response.a.a.I(com.kwad.sdk.core.response.a.d.i(this.d))) {
                com.kwad.components.core.webview.b.o oVar = new com.kwad.components.core.webview.b.o();
                gVar.a(oVar);
                this.k = new com.kwad.sdk.core.download.g(this, this.d, oVar) { // from class: com.kwad.components.ad.reward.f.b.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.kwad.components.core.webview.b.o a;
                    public final /* synthetic */ b b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8, oVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super((AdTemplate) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = oVar;
                    }

                    @Override // com.kwad.sdk.core.download.g, com.kwad.sdk.core.download.f
                    public final void a(String str, int i, com.kwad.sdk.core.download.h hVar2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, str, i, hVar2) == null) {
                            super.a(str, i, hVar2);
                            com.kwad.components.core.webview.b.kwai.b bVar3 = new com.kwad.components.core.webview.b.kwai.b();
                            bVar3.a = 1;
                            this.a.a(bVar3);
                        }
                    }
                };
                e.a().a(this.k, this.d);
            }
            com.kwad.components.core.webview.b.x xVar = new com.kwad.components.core.webview.b.x();
            xVar.a(new x.a(this) { // from class: com.kwad.components.ad.reward.f.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.components.core.webview.b.x.a
                public final void a(com.kwad.components.core.webview.b.kwai.p pVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, pVar) == null) {
                        this.a.e.a(pVar);
                    }
                }
            });
            gVar.a(xVar);
            y yVar = new y();
            yVar.a(new y.a(this) { // from class: com.kwad.components.ad.reward.f.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.components.core.webview.b.y.a
                public final void a(com.kwad.components.core.webview.b.kwai.h hVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, hVar2) == null) {
                        this.a.e.a(hVar2);
                    }
                }
            });
            gVar.a(yVar);
            s sVar = new s();
            gVar.a(sVar);
            this.e.a(sVar);
            gVar.a(new v(this) { // from class: com.kwad.components.ad.reward.f.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.components.core.webview.b.v
                public final void a(com.kwad.components.core.webview.b.kwai.n nVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, nVar) == null) {
                        super.a(nVar);
                        if (this.a.a.isFinishing()) {
                            return;
                        }
                        if (this.a.c != null) {
                            this.a.c.dismiss();
                        }
                        d.b bVar3 = new d.b();
                        bVar3.a(this.a.d);
                        bVar3.a(nVar.a);
                        this.a.c = d.a(bVar3);
                        this.a.c.show(this.a.a.getFragmentManager(), "");
                    }
                }
            });
            gVar.a(new com.kwad.components.core.webview.b.f(this) { // from class: com.kwad.components.ad.reward.f.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.components.core.webview.b.f
                public final void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        if (this.a.c != null) {
                            this.a.c.dismiss();
                        }
                        if (this.a.e != null) {
                            this.a.e.l();
                        }
                    }
                }
            });
            gVar.a(new com.kwad.components.core.webview.jshandler.e(new com.kwad.sdk.core.webview.a.kwai.b(this) { // from class: com.kwad.components.ad.reward.f.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.sdk.core.webview.a.kwai.b
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.e.n();
                    }
                }
            }));
            gVar.a(new com.kwad.components.core.webview.b.h(this) { // from class: com.kwad.components.ad.reward.f.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.components.core.webview.b.h
                public final void a(com.kwad.components.core.webview.b.kwai.e eVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, eVar) == null) {
                        super.a(eVar);
                        com.kwad.components.core.i.a.a().a(eVar.b, this.a.d, eVar.a);
                    }
                }
            });
            gVar.a(new com.kwad.components.core.webview.b.n(this) { // from class: com.kwad.components.ad.reward.f.b.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // com.kwad.components.core.webview.b.n
                public final void a(com.kwad.components.core.webview.b.kwai.i iVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, iVar) == null) {
                        super.a(iVar);
                        SimpleWebViewActivity.launch(this.a.b, iVar.a, iVar.b);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        StyleTemplate findStyleTemplateFromConfigById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, str) == null) || (findStyleTemplateFromConfigById = this.f.findStyleTemplateFromConfigById(this.e.f())) == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(0).setRenderState(4).setErrorReason(str).setTemplateId(this.e.f()).setVersionCode(String.valueOf(findStyleTemplateFromConfigById.templateVersionCode)).toJson());
    }

    private void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, th) == null) {
            com.kwad.components.core.b.a.a(th);
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.l.tkSouce).setRenderState(3).setErrorReason(th.getMessage()).setTemplateId(this.e.f()).setVersionCode(String.valueOf(this.l.templateVersionCode)).toJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(StyleTemplate styleTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65548, this, styleTemplate)) != null) {
            return invokeL.booleanValue;
        }
        this.l = styleTemplate;
        com.kwad.sdk.core.d.b.d("TKLoadController", "addTKView mTKPlugin.getState(): " + this.f.getState());
        if (this.f.getState() == ITkOfflineCompo.TKState.SO_FAIL) {
            a(TKPerformMsg.ERROR_REASON.KSAD_TK_SO_FAIL);
            return false;
        }
        FrameLayout g = this.e.g();
        FileInputStream fileInputStream = null;
        try {
            String jsBaseDir = this.f.getJsBaseDir(this.b, this.e.f());
            File file = new File(jsBaseDir, styleTemplate.tkFileName);
            if (!com.kwad.sdk.utils.o.a(file)) {
                a(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_FILE);
                return false;
            }
            f();
            this.s = SystemClock.elapsedRealtime();
            Context context = this.b;
            Context wrapContextIfNeed = new com.kwad.components.core.offline.init.kwai.h(ITkOfflineCompo.PACKAGE_NAME).wrapContextIfNeed(context);
            com.kwad.sdk.core.d.b.a("TKLoadController", "context: " + context + " , resources: " + context.getResources() + "\nwrappedContext: " + wrapContextIfNeed + ", wrapped resources: " + wrapContextIfNeed.getResources());
            g view2 = this.f.getView(wrapContextIfNeed, styleTemplate.tkFileName, styleTemplate.templateVersionCode, styleTemplate.tkSouce);
            this.t = SystemClock.elapsedRealtime() - this.s;
            this.r = SystemClock.elapsedRealtime();
            a(view2, g);
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                String inputStreamToString = IoUtils.inputStreamToString(fileInputStream2);
                if (inputStreamToString != null) {
                    File file2 = new File(jsBaseDir);
                    view2.a(inputStreamToString, file2.getAbsolutePath() + "/");
                    View a = view2.a();
                    a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    g.addView(a);
                    this.h = view2;
                }
                com.kwad.sdk.crash.utils.b.a(fileInputStream2);
                return true;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    a(th);
                    return false;
                } finally {
                    com.kwad.sdk.crash.utils.b.a(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.o = false;
            this.p = false;
            this.n = false;
            this.q = false;
            this.m = 0L;
            this.s = 0L;
            this.t = 0L;
            this.r = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, this, str) == null) && this.o && !this.p) {
            this.p = true;
            com.kwad.sdk.core.d.b.a("tkRender", "logTkRenderFail : " + str);
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.l.tkSouce).setRenderState(2).setErrorReason(str).setTemplateId(this.e.f()).setVersionCode(String.valueOf(this.l.templateVersionCode)).toJson());
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            az.a(this.u, 1000L);
            this.g = com.kwad.sdk.core.threads.b.g().submit(new Runnable(this) { // from class: com.kwad.components.ad.reward.f.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.m = SystemClock.elapsedRealtime();
                        com.kwad.sdk.core.d.b.a("TKLoadController", "开始读取模板 id: " + this.a.e.f());
                        StyleTemplate loadTkFileByTemplateId = this.a.f.loadTkFileByTemplateId(this.a.b, this.a.e.f());
                        StringBuilder sb = new StringBuilder("读取完毕，总耗时");
                        sb.append(SystemClock.elapsedRealtime() - this.a.m);
                        sb.append(", 读取");
                        if (loadTkFileByTemplateId == null) {
                            str = "失败";
                        } else {
                            str = "成功" + loadTkFileByTemplateId.toJson() + AnonymousClass1.class.getSimpleName();
                        }
                        sb.append(str);
                        com.kwad.sdk.core.d.b.a("TKLoadController", sb.toString());
                        if (this.a.n) {
                            return;
                        }
                        com.kwad.sdk.core.d.b.a("TKLoadController", "没有超时");
                        az.b(this.a.u);
                        az.a(new Runnable(this, loadTkFileByTemplateId) { // from class: com.kwad.components.ad.reward.f.b.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ StyleTemplate a;
                            public final /* synthetic */ AnonymousClass1 b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, loadTkFileByTemplateId};
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
                                this.a = loadTkFileByTemplateId;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.a == null) {
                                        this.b.a.a(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
                                        com.kwad.sdk.core.d.b.a("TKLoadController", "没有模板信息" + Thread.currentThread().getName());
                                        this.b.a.d();
                                    } else if (this.b.a.a == null || this.b.a.a.isFinishing()) {
                                    } else {
                                        boolean a = this.b.a.a(this.a);
                                        if (!a) {
                                            this.b.a.d();
                                        }
                                        com.kwad.sdk.core.d.b.a("TKLoadController", a ? "本地预加载成功并渲染成功" : "本地预加载成功渲染失败");
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || this.q) {
            return;
        }
        this.q = true;
        this.e.h();
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            com.kwad.components.core.offline.api.kwai.a aVar = this.f;
            StyleTemplate findStyleTemplateFromConfigById = aVar == null ? null : aVar.findStyleTemplateFromConfigById(this.e.f());
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(findStyleTemplateFromConfigById == null ? 0 : findStyleTemplateFromConfigById.tkSouce).setRenderState(-1).setTemplateId(this.e.f()).setVersionCode(findStyleTemplateFromConfigById == null ? "" : String.valueOf(findStyleTemplateFromConfigById.templateVersionCode)).toJson());
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.o = true;
            com.kwad.sdk.core.d.b.a("tkrender", "logTkRenderStart");
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.l.tkSouce).setRenderState(0).setTemplateId(this.e.f()).setVersionCode(String.valueOf(this.l.templateVersionCode)).toJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65561, this) == null) && this.o && !this.p) {
            this.p = true;
            com.kwad.sdk.core.d.b.a("tkRender", "logTkRenderSuccess");
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.l.tkSouce).setRenderState(1).setRenderTime(this.r > 0 ? SystemClock.elapsedRealtime() - this.r : 0L).setTemplateId(this.e.f()).setLoadTime(this.s - this.m).setInitTime(this.t).setVersionCode(String.valueOf(this.l.templateVersionCode)).toJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        StyleTemplate findStyleTemplateFromConfigById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65564, this) == null) || (findStyleTemplateFromConfigById = this.f.findStyleTemplateFromConfigById(this.e.f())) == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(findStyleTemplateFromConfigById.tkSouce).setRenderState(3).setErrorReason("timeout").setTemplateId(this.e.f()).setVersionCode(String.valueOf(findStyleTemplateFromConfigById.templateVersionCode)).toJson());
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Future<?> future = this.g;
            if (future != null) {
                future.cancel(true);
            }
            az.b(this.u);
            if (this.k != null) {
                e.a().a(this.k);
            }
            g gVar = this.h;
            if (gVar != null) {
                gVar.b();
            }
            d dVar = this.c;
            if (dVar != null) {
                dVar.dismiss();
            }
        }
    }

    public final void a(Activity activity, AdTemplate adTemplate, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, adTemplate, cVar) == null) {
            this.a = activity;
            this.d = adTemplate;
            this.e = cVar;
            b();
            this.e.g().removeAllViews();
            if (!com.kwad.sdk.core.config.d.C()) {
                d();
                return;
            }
            this.f = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.a(com.kwad.components.core.offline.api.kwai.a.class);
            e();
            com.kwad.sdk.core.d.b.a("TKLoadController", "bind mTKPlugin: " + this.f);
            if (this.f != null) {
                c();
                return;
            }
            d();
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(0).setRenderState(4).setErrorReason(TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED).setTemplateId(this.e.f()).toJson());
        }
    }
}
