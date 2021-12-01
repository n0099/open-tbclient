package com.kwad.sdk.reward.presenter.platdetail;

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
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical;
import com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.be;
/* loaded from: classes2.dex */
public class a extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ActionBarLandscapeVertical f59194b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarPortraitHorizontal f59195c;

    /* renamed from: d  reason: collision with root package name */
    public s f59196d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f59197e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59198f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f59199g;

    /* renamed from: h  reason: collision with root package name */
    public long f59200h;

    /* renamed from: i  reason: collision with root package name */
    public KsAdWebView f59201i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f59202j;

    /* renamed from: k  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f59203k;
    public boolean l;
    public boolean m;
    public KsAdWebView.d n;
    public d o;
    public f p;
    public b.c q;
    public long r;
    public Runnable s;
    public bd t;
    public j.b u;
    public i.b v;
    public p.b w;

    public a() {
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
        this.n = new KsAdWebView.d(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.a.1
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.f59199g.removeCallbacksAndMessages(null);
                    this.a.f59199g.postDelayed(this.a.t, this.a.f59200h);
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i4, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str, str2) == null) {
                    this.a.f59199g.removeCallbacksAndMessages(null);
                    this.a.s.run();
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        };
        this.o = new e(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.a.3
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.c();
                    if (this.a.m) {
                        this.a.f59201i.setVisibility(4);
                        a aVar = this.a;
                        aVar.a(((g) aVar).a.f58878k.f(), ((g) this.a).a.f58878k.g());
                    }
                    this.a.l = true;
                }
            }
        };
        this.p = new f(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.a.4
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.l = false;
                    this.a.e();
                    if (this.a.m) {
                        this.a.i();
                    }
                }
            }
        };
        this.q = new b.c(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.a.7
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.d.a.a("NewStylePresenter", "onAdClicked");
                    ((g) this.a).a.f58869b.a();
                }
            }
        };
        Runnable runnable = new Runnable(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.a.8
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.m = true;
                    this.a.f59201i.setVisibility(4);
                    if (this.a.l) {
                        a aVar = this.a;
                        aVar.a(((g) aVar).a.f58878k.f(), ((g) this.a).a.f58878k.g());
                    }
                }
            }
        };
        this.s = runnable;
        this.t = new bd(runnable);
        this.u = new j.b(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.a.9
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.j.b
            public void a(j.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                }
            }
        };
        this.v = new i.b(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.a.10
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.a.f59196d.e();
                    this.a.f59201i.setVisibility(4);
                    this.a.f59196d.f();
                }
            }
        };
        this.w = new p.b(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.a.2
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.d.a.c("NewStylePresenter", "load time:" + (System.currentTimeMillis() - this.a.r));
                    this.a.f59199g.removeCallbacksAndMessages(null);
                    if (aVar.a != 1) {
                        com.kwad.sdk.core.d.a.a("NewStylePresenter", "show webCard fail, reason: timeout");
                        this.a.s.run();
                        return;
                    }
                    this.a.i();
                    this.a.f59201i.setVisibility(0);
                    this.a.f59196d.d();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, this, i2, i3) == null) {
            int min = Math.min(av.o(q()), av.n(q()));
            if (((g) this).a.f58873f == 1) {
                if (i2 <= i3) {
                    b((int) ((i2 / (i3 * 1.0f)) * min));
                }
            } else if (i2 >= i3) {
                c((int) ((i3 / (i2 * 1.0f)) * min));
            }
        }
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f59203k, this.f59198f, this.q));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f59203k, this.f59198f, this.q));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f59203k));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f59203k));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f59203k));
            gVar.a(new j(this.f59203k, this.u));
            gVar.a(new p(this.w));
            gVar.a(this.f59196d);
            gVar.a(new t(this.f59203k, this.f59198f));
            gVar.a(new i(this.v));
            gVar.a(new k(this.f59203k));
        }
    }

    private void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            this.f59194b.a(this.f59197e, this.f59198f, new ActionBarLandscapeVertical.a(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.a.5
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
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.a.b(z);
                    }
                }
            }, i2);
            this.f59194b.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, this, z) == null) {
            com.kwad.sdk.core.report.a.a(this.f59197e, z ? 1 : 153, ((g) this).a.f58877j.getTouchCoords(), ((g) this).a.f58872e);
            ((g) this).a.f58869b.a();
        }
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i2) == null) {
            this.f59195c.a(this.f59197e, this.f59198f, new ActionBarPortraitHorizontal.a(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.a.6
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
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.a.b(z);
                    }
                }
            }, i2);
            this.f59195c.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f59196d.b();
            this.f59201i.setVisibility(8);
            this.f59201i.setHttpErrorListener(null);
            u();
            Handler handler = this.f59199g;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.f59194b.setVisibility(8);
            this.f59195c.setVisibility(8);
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f59203k = aVar;
            aVar.a(((g) this).a.f58874g);
            com.kwad.sdk.core.webview.a aVar2 = this.f59203k;
            com.kwad.sdk.reward.a aVar3 = ((g) this).a;
            aVar2.a = aVar3.f58873f;
            AdBaseFrameLayout adBaseFrameLayout = aVar3.f58877j;
            aVar2.f57955b = adBaseFrameLayout;
            aVar2.f57957d = adBaseFrameLayout;
            aVar2.f57958e = this.f59201i;
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            t();
            this.r = System.currentTimeMillis();
            if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.b.e(this.f59197e))) {
                this.s.run();
                return;
            }
            this.f59196d.c();
            this.f59201i.setVisibility(4);
            this.f59201i.loadUrl(com.kwad.sdk.core.response.a.b.e(this.f59197e));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            u();
            be.a(this.f59201i);
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f59201i);
            this.f59202j = gVar;
            a(gVar);
            this.f59201i.addJavascriptInterface(this.f59202j, "KwaiAd");
        }
    }

    private void u() {
        com.kwad.sdk.core.webview.kwai.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65567, this) == null) || (gVar = this.f59202j) == null) {
            return;
        }
        gVar.a();
        this.f59202j = null;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            AdTemplate adTemplate = aVar.f58874g;
            this.f59197e = adTemplate;
            this.f59198f = aVar.l;
            long f2 = com.kwad.sdk.core.response.a.b.f(adTemplate);
            if (f2 <= 0) {
                f2 = 1000;
            }
            this.f59200h = f2;
            this.f59201i.setHttpErrorListener(this.n);
            r();
            s();
            ((g) this).a.a(this.p);
            ((g) this).a.f58878k.a(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            ((g) this).a.b(this.p);
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            KsAdWebView ksAdWebView = (KsAdWebView) a(R.id.ksad_actionbar_black_style_h5);
            this.f59201i = ksAdWebView;
            ksAdWebView.setBackgroundColor(0);
            this.f59201i.getBackground().setAlpha(0);
            this.f59194b = (ActionBarLandscapeVertical) a(R.id.ksad_actionbar_landscape_vertical);
            this.f59195c = (ActionBarPortraitHorizontal) a(R.id.ksad_actionbar_portrait_horizontal);
            this.f59196d = new s();
            this.f59199g = new Handler(Looper.getMainLooper());
        }
    }
}
