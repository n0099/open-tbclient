package com.kwad.sdk.reward.b.b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical;
import com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.ay;
/* loaded from: classes2.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ActionBarLandscapeVertical f66161b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarPortraitHorizontal f66162c;

    /* renamed from: d  reason: collision with root package name */
    public p f66163d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f66164e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f66165f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f66166g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdWebView f66167h;

    /* renamed from: i  reason: collision with root package name */
    public g f66168i;
    public com.kwad.sdk.core.webview.a j;
    public boolean k;
    public boolean l;
    public KsAdWebView.d m;
    public com.kwad.sdk.contentalliance.detail.video.d n;
    public f o;
    public a.b p;
    public long q;
    public Runnable r;
    public ax s;
    public i.b t;
    public h.a u;
    public m.b v;

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
        this.m = new KsAdWebView.d(this) { // from class: com.kwad.sdk.reward.b.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66169a;

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
                this.f66169a = this;
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f66169a.f66166g.removeCallbacksAndMessages(null);
                    this.f66169a.f66166g.postDelayed(this.f66169a.s, com.kwad.sdk.core.response.b.b.g(this.f66169a.f66164e) + 200);
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i4, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str, str2) == null) {
                    this.f66169a.v.a(-1);
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        };
        this.n = new e(this) { // from class: com.kwad.sdk.reward.b.b.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66172a;

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
                this.f66172a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.c();
                    if (this.f66172a.l) {
                        this.f66172a.f66167h.setVisibility(4);
                        c cVar = this.f66172a;
                        cVar.a(((d) cVar).f66343a.f66019i.j(), ((d) this.f66172a).f66343a.f66019i.k());
                    }
                    this.f66172a.k = true;
                }
            }
        };
        this.o = new f(this) { // from class: com.kwad.sdk.reward.b.b.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66173a;

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
                this.f66173a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f66173a.k = false;
                    this.f66173a.f();
                    if (this.f66173a.l) {
                        this.f66173a.n();
                    }
                }
            }
        };
        this.p = new a.b(this) { // from class: com.kwad.sdk.reward.b.b.c.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66176a;

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
                this.f66176a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C1916a c1916a) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1916a) == null) {
                    com.kwad.sdk.core.d.a.a("NewStylePresenter", "onAdClicked");
                    ((d) this.f66176a).f66343a.f66012b.a();
                }
            }
        };
        Runnable runnable = new Runnable(this) { // from class: com.kwad.sdk.reward.b.b.c.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66177a;

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
                this.f66177a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f66177a.l = true;
                    this.f66177a.f66167h.setVisibility(4);
                    if (this.f66177a.k) {
                        c cVar = this.f66177a;
                        cVar.a(((d) cVar).f66343a.f66019i.j(), ((d) this.f66177a).f66343a.f66019i.k());
                    }
                }
            }
        };
        this.r = runnable;
        this.s = new ax(runnable);
        this.t = new i.b(this) { // from class: com.kwad.sdk.reward.b.b.c.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66178a;

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
                this.f66178a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                }
            }
        };
        this.u = new h.a(this) { // from class: com.kwad.sdk.reward.b.b.c.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66170a;

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
                this.f66170a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f66170a.f66163d.e();
                    this.f66170a.f66167h.setVisibility(4);
                    this.f66170a.f66163d.f();
                }
            }
        };
        this.v = new m.b(this) { // from class: com.kwad.sdk.reward.b.b.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66171a;

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
                this.f66171a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    com.kwad.sdk.core.d.a.c("NewStylePresenter", "load time:" + (System.currentTimeMillis() - this.f66171a.q));
                    this.f66171a.f66166g.removeCallbacksAndMessages(null);
                    if (i4 != 1) {
                        com.kwad.sdk.core.d.a.a("NewStylePresenter", "show webCard fail, reason: timeout");
                        this.f66171a.r.run();
                        return;
                    }
                    this.f66171a.n();
                    this.f66171a.f66167h.setVisibility(0);
                    this.f66171a.f66163d.d();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, this, i2, i3) == null) {
            int min = Math.min(ap.l(m()), ap.k(m()));
            if (((d) this).f66343a.f66015e == 1) {
                if (i2 <= i3) {
                    b((int) ((i2 / (i3 * 1.0f)) * min));
                }
            } else if (i2 >= i3) {
                c((int) ((i3 / (i2 * 1.0f)) * min));
            }
        }
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.f66165f, this.p));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.j));
            gVar.a(new i(this.j, this.t));
            gVar.a(new m(this.v));
            gVar.a(this.f66163d);
            gVar.a(new q(this.j, this.f66165f));
            gVar.a(new h(this.u));
            gVar.a(new j(this.j));
        }
    }

    private void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            this.f66161b.a(this.f66164e, this.f66165f, new ActionBarLandscapeVertical.a(this) { // from class: com.kwad.sdk.reward.b.b.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f66174a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66174a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66174a.e();
                    }
                }
            }, i2);
            this.f66161b.setVisibility(0);
        }
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, this, i2) == null) {
            this.f66162c.a(this.f66164e, this.f66165f, new ActionBarPortraitHorizontal.a(this) { // from class: com.kwad.sdk.reward.b.b.c.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f66175a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66175a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66175a.e();
                    }
                }
            }, i2);
            this.f66162c.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f66164e, 1, ((d) this).f66343a.f66018h.getTouchCoords(), ((d) this).f66343a.f66014d);
            ((d) this).f66343a.f66012b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.f66163d.b();
            this.f66167h.setVisibility(8);
            this.f66167h.setHttpErrorListener(null);
            r();
            Handler handler = this.f66166g;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.f66161b.setVisibility(8);
            this.f66162c.setVisibility(8);
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.j = aVar;
            com.kwad.sdk.reward.a aVar2 = ((d) this).f66343a;
            aVar.f65227b = aVar2.f66016f;
            aVar.f65226a = aVar2.f66015e;
            AdBaseFrameLayout adBaseFrameLayout = aVar2.f66018h;
            aVar.f65228c = adBaseFrameLayout;
            aVar.f65230e = adBaseFrameLayout;
            aVar.f65231f = this.f66167h;
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            q();
            this.q = System.currentTimeMillis();
            String h2 = com.kwad.sdk.core.response.b.b.h(this.f66164e);
            if (TextUtils.isEmpty(h2)) {
                this.r.run();
                return;
            }
            this.f66163d.c();
            this.f66167h.setVisibility(4);
            this.f66167h.loadUrl(h2);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            r();
            ay.a(this.f66167h);
            g gVar = new g(this.f66167h);
            this.f66168i = gVar;
            a(gVar);
            this.f66167h.addJavascriptInterface(this.f66168i, "KwaiAd");
        }
    }

    private void r() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65568, this) == null) || (gVar = this.f66168i) == null) {
            return;
        }
        gVar.a();
        this.f66168i = null;
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((d) this).f66343a;
            this.f66164e = aVar.f66016f;
            this.f66165f = aVar.j;
            this.f66167h.setHttpErrorListener(this.m);
            o();
            p();
            ((d) this).f66343a.a(this.o);
            ((d) this).f66343a.f66019i.a(this.n);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            KsAdWebView ksAdWebView = (KsAdWebView) a(R.id.ksad_actionbar_black_style_h5);
            this.f66167h = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.f66167h.getBackground().setAlpha(0);
            this.f66161b = (ActionBarLandscapeVertical) a(R.id.ksad_actionbar_landscape_vertical);
            this.f66162c = (ActionBarPortraitHorizontal) a(R.id.ksad_actionbar_portrait_horizontal);
            this.f66163d = new p();
            this.f66166g = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((d) this).f66343a.b(this.o);
            f();
        }
    }
}
