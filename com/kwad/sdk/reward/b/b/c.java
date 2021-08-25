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
/* loaded from: classes10.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ActionBarLandscapeVertical f73225b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarPortraitHorizontal f73226c;

    /* renamed from: d  reason: collision with root package name */
    public p f73227d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f73228e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f73229f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f73230g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdWebView f73231h;

    /* renamed from: i  reason: collision with root package name */
    public g f73232i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f73233j;
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
            public final /* synthetic */ c f73234a;

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
                this.f73234a = this;
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f73234a.f73230g.removeCallbacksAndMessages(null);
                    this.f73234a.f73230g.postDelayed(this.f73234a.s, com.kwad.sdk.core.response.b.b.g(this.f73234a.f73228e) + 200);
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i4, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str, str2) == null) {
                    this.f73234a.v.a(-1);
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
            public final /* synthetic */ c f73237a;

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
                this.f73237a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.c();
                    if (this.f73237a.l) {
                        this.f73237a.f73231h.setVisibility(4);
                        c cVar = this.f73237a;
                        cVar.a(((d) cVar).f73410a.f73076i.j(), ((d) this.f73237a).f73410a.f73076i.k());
                    }
                    this.f73237a.k = true;
                }
            }
        };
        this.o = new f(this) { // from class: com.kwad.sdk.reward.b.b.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73238a;

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
                this.f73238a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f73238a.k = false;
                    this.f73238a.f();
                    if (this.f73238a.l) {
                        this.f73238a.n();
                    }
                }
            }
        };
        this.p = new a.b(this) { // from class: com.kwad.sdk.reward.b.b.c.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73241a;

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
                this.f73241a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C2000a c2000a) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, c2000a) == null) {
                    com.kwad.sdk.core.d.a.a("NewStylePresenter", "onAdClicked");
                    ((d) this.f73241a).f73410a.f73069b.a();
                }
            }
        };
        Runnable runnable = new Runnable(this) { // from class: com.kwad.sdk.reward.b.b.c.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73242a;

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
                this.f73242a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f73242a.l = true;
                    this.f73242a.f73231h.setVisibility(4);
                    if (this.f73242a.k) {
                        c cVar = this.f73242a;
                        cVar.a(((d) cVar).f73410a.f73076i.j(), ((d) this.f73242a).f73410a.f73076i.k());
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
            public final /* synthetic */ c f73243a;

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
                this.f73243a = this;
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
            public final /* synthetic */ c f73235a;

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
                this.f73235a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f73235a.f73227d.e();
                    this.f73235a.f73231h.setVisibility(4);
                    this.f73235a.f73227d.f();
                }
            }
        };
        this.v = new m.b(this) { // from class: com.kwad.sdk.reward.b.b.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73236a;

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
                this.f73236a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    com.kwad.sdk.core.d.a.c("NewStylePresenter", "load time:" + (System.currentTimeMillis() - this.f73236a.q));
                    this.f73236a.f73230g.removeCallbacksAndMessages(null);
                    if (i4 != 1) {
                        com.kwad.sdk.core.d.a.a("NewStylePresenter", "show webCard fail, reason: timeout");
                        this.f73236a.r.run();
                        return;
                    }
                    this.f73236a.n();
                    this.f73236a.f73231h.setVisibility(0);
                    this.f73236a.f73227d.d();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, this, i2, i3) == null) {
            int min = Math.min(ap.l(m()), ap.k(m()));
            if (((d) this).f73410a.f73072e == 1) {
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
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f73233j, this.f73229f, this.p));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f73233j));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f73233j));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f73233j));
            gVar.a(new i(this.f73233j, this.t));
            gVar.a(new m(this.v));
            gVar.a(this.f73227d);
            gVar.a(new q(this.f73233j, this.f73229f));
            gVar.a(new h(this.u));
            gVar.a(new j(this.f73233j));
        }
    }

    private void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            this.f73225b.a(this.f73228e, this.f73229f, new ActionBarLandscapeVertical.a(this) { // from class: com.kwad.sdk.reward.b.b.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73239a;

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
                    this.f73239a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f73239a.e();
                    }
                }
            }, i2);
            this.f73225b.setVisibility(0);
        }
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, this, i2) == null) {
            this.f73226c.a(this.f73228e, this.f73229f, new ActionBarPortraitHorizontal.a(this) { // from class: com.kwad.sdk.reward.b.b.c.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73240a;

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
                    this.f73240a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f73240a.e();
                    }
                }
            }, i2);
            this.f73226c.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f73228e, 1, ((d) this).f73410a.f73075h.getTouchCoords(), ((d) this).f73410a.f73071d);
            ((d) this).f73410a.f73069b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.f73227d.b();
            this.f73231h.setVisibility(8);
            this.f73231h.setHttpErrorListener(null);
            r();
            Handler handler = this.f73230g;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.f73225b.setVisibility(8);
            this.f73226c.setVisibility(8);
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f73233j = aVar;
            com.kwad.sdk.reward.a aVar2 = ((d) this).f73410a;
            aVar.f72243b = aVar2.f73073f;
            aVar.f72242a = aVar2.f73072e;
            AdBaseFrameLayout adBaseFrameLayout = aVar2.f73075h;
            aVar.f72244c = adBaseFrameLayout;
            aVar.f72246e = adBaseFrameLayout;
            aVar.f72247f = this.f73231h;
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            q();
            this.q = System.currentTimeMillis();
            String h2 = com.kwad.sdk.core.response.b.b.h(this.f73228e);
            if (TextUtils.isEmpty(h2)) {
                this.r.run();
                return;
            }
            this.f73227d.c();
            this.f73231h.setVisibility(4);
            this.f73231h.loadUrl(h2);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            r();
            ay.a(this.f73231h);
            g gVar = new g(this.f73231h);
            this.f73232i = gVar;
            a(gVar);
            this.f73231h.addJavascriptInterface(this.f73232i, "KwaiAd");
        }
    }

    private void r() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65568, this) == null) || (gVar = this.f73232i) == null) {
            return;
        }
        gVar.a();
        this.f73232i = null;
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((d) this).f73410a;
            this.f73228e = aVar.f73073f;
            this.f73229f = aVar.f73077j;
            this.f73231h.setHttpErrorListener(this.m);
            o();
            p();
            ((d) this).f73410a.a(this.o);
            ((d) this).f73410a.f73076i.a(this.n);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            KsAdWebView ksAdWebView = (KsAdWebView) a(R.id.ksad_actionbar_black_style_h5);
            this.f73231h = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.f73231h.getBackground().setAlpha(0);
            this.f73225b = (ActionBarLandscapeVertical) a(R.id.ksad_actionbar_landscape_vertical);
            this.f73226c = (ActionBarPortraitHorizontal) a(R.id.ksad_actionbar_portrait_horizontal);
            this.f73227d = new p();
            this.f73230g = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((d) this).f73410a.b(this.o);
            f();
        }
    }
}
