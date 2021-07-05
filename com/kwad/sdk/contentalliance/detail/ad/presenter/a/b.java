package com.kwad.sdk.contentalliance.detail.ad.presenter.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.ar;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f34481b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f34482c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f34483d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f34484e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f34485f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f34486g;

    /* renamed from: h  reason: collision with root package name */
    public AdStyleInfo.PlayDetailInfo.DetailWebCardInfo f34487h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34488i;
    public g j;
    public com.kwad.sdk.core.webview.a k;
    public int l;
    public n m;
    public ValueAnimator n;
    public ValueAnimator o;
    public boolean p;
    public boolean q;
    public e r;
    public com.kwad.sdk.contentalliance.a.a s;
    public long t;
    public int u;
    public h.a v;
    public k.b w;
    public Runnable x;
    public Runnable y;

    /* renamed from: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass2 extends com.kwad.sdk.contentalliance.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ViewTreeObserver.OnGlobalLayoutListener f34490a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f34491b;

        public AnonymousClass2(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34491b = bVar;
        }

        private void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.f34491b.p = false;
                this.f34491b.q = false;
                this.f34491b.f34483d.setTranslationX(0.0f);
                this.f34491b.f34481b.setTranslationX(-this.f34491b.u);
                this.f34491b.f34484e.removeCallbacks(this.f34491b.y);
            }
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.f34490a = new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.2.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass2 f34492a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f34492a = this;
                    }

                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f34492a.f34491b.f34481b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            AnonymousClass2 anonymousClass2 = this.f34492a;
                            anonymousClass2.f34490a = null;
                            anonymousClass2.f34491b.g();
                        }
                    }
                };
                this.f34491b.f34481b.getViewTreeObserver().addOnGlobalLayoutListener(this.f34490a);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.j();
                a();
                b();
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.k();
                a();
                this.f34491b.p();
                this.f34491b.t();
                if (this.f34490a != null) {
                    this.f34491b.f34481b.getViewTreeObserver().removeOnGlobalLayoutListener(this.f34490a);
                }
            }
        }
    }

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
        this.l = -1;
        this.p = false;
        this.q = false;
        this.r = new f(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34489a;

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
                this.f34489a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.a();
                    this.f34489a.p = false;
                    this.f34489a.a(false);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 < com.kwad.sdk.core.response.b.b.g(this.f34489a.f34485f)) {
                    return;
                }
                this.f34489a.q();
            }
        };
        this.s = new AnonymousClass2(this);
        this.v = new h.a(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34493a;

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
                this.f34493a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34493a.a(true);
                }
            }
        };
        this.w = new k.b(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34494a;

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
                this.f34494a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f34494a.l = i4;
                    com.kwad.sdk.core.d.a.b("ActionBarWebCard", "position:" + ((com.kwad.sdk.contentalliance.detail.b) this.f34494a).f34553a.f34582i + " load time:" + (System.currentTimeMillis() - this.f34494a.t));
                }
            }
        };
        Runnable runnable = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34495a;

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
                this.f34495a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34495a.a(false);
                }
            }
        };
        this.x = runnable;
        this.y = new aq(runnable);
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.k, this.f34488i, null));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.k));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.k));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.k));
            gVar.a(new i(this.k, null));
            gVar.a(new k(this.w));
            n nVar = new n();
            this.m = nVar;
            gVar.a(nVar);
            gVar.a(new o(this.k, this.f34488i));
            gVar.a(new h(this.v));
            gVar.a(new j(this.k));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65540, this, z) == null) && ao.a((View) this.f34484e, 50, false)) {
            this.q = z;
            t();
            this.f34484e.removeCallbacks(this.y);
            ValueAnimator a2 = am.a(this.f34481b, this.f34483d, this.u);
            this.o = a2;
            a2.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f34497a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34497a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.f34497a.m != null) {
                            this.f34497a.m.f();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f34497a.m != null) {
                            this.f34497a.m.e();
                        }
                    }
                }
            });
            this.o.start();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            com.kwad.sdk.core.webview.a aVar = this.k;
            aVar.f36790b = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
            aVar.f36789a = 0;
            aVar.f36791c = this.f34482c;
            aVar.f36793e = this.f34481b;
            aVar.f36794f = this.f34484e;
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f34481b.setVisibility(4);
            this.f34484e.setBackgroundColor(0);
            this.f34484e.getBackground().setAlpha(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.u = this.f34481b.getWidth() + ao.a(this.f34481b.getContext(), 12.0f);
            com.kwad.sdk.core.d.a.a("ActionBarWebCard", "initWebCard mWebCardContainerWidth:" + this.u);
            this.f34481b.setTranslationX((float) (-this.u));
            this.f34481b.setVisibility(0);
            h();
            this.l = -1;
            this.t = System.currentTimeMillis();
            this.f34484e.loadUrl(this.f34487h.cardUrl);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            p();
            ar.a(this.f34484e);
            g gVar = new g(this.f34484e);
            this.j = gVar;
            a(gVar);
            this.f34484e.addJavascriptInterface(this.j, "KwaiAd");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (gVar = this.j) == null) {
            return;
        }
        gVar.a();
        this.j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || this.p || this.q) {
            return;
        }
        this.p = true;
        com.kwad.sdk.core.d.a.a("ActionBarWebCard", "showWebActionBar");
        if (this.l != 1) {
            u();
            return;
        }
        s();
        r();
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            this.f34484e.postDelayed(this.y, com.kwad.sdk.core.response.b.b.m(this.f34485f));
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            t();
            ValueAnimator a2 = am.a(this.f34483d, this.f34481b, this.u);
            this.n = a2;
            a2.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f34496a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34496a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.f34496a.m != null) {
                            this.f34496a.m.d();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f34496a.m != null) {
                            this.f34496a.m.c();
                        }
                    }
                }
            });
            this.n.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            ValueAnimator valueAnimator = this.n;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.n.cancel();
            }
            ValueAnimator valueAnimator2 = this.o;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllListeners();
                this.o.cancel();
            }
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            int i2 = this.l;
            String str = i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
            Log.w("ActionBarWebCard", "show webCard fail, reason: " + str);
            com.kwad.sdk.core.report.b.n(this.f34485f);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
            this.f34485f = adTemplate;
            if (!com.kwad.sdk.core.response.b.b.o(adTemplate) || this.f34484e == null) {
                this.f34481b.setVisibility(8);
                return;
            }
            this.f34481b.setVisibility(0);
            this.f34487h = com.kwad.sdk.core.response.b.b.q(this.f34485f).playDetailInfo.detailWebCardInfo;
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            this.f34486g = cVar.m;
            this.f34488i = cVar.o;
            if (this.k == null) {
                this.k = new com.kwad.sdk.core.webview.a();
                f();
            }
            e();
            com.kwad.sdk.contentalliance.detail.video.b bVar = this.f34486g;
            if (bVar != null) {
                bVar.a(this.r);
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.s);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            if (!com.kwad.sdk.core.response.b.b.o(this.f34485f) || this.f34484e == null) {
                return;
            }
            com.kwad.sdk.contentalliance.detail.video.b bVar = this.f34486g;
            if (bVar != null) {
                bVar.b(this.r);
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.s);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34482c = (AdBaseFrameLayout) b(R.id.ksad_root_container);
            this.f34483d = (ViewGroup) b(R.id.ksad_bottom_content_container);
            this.f34481b = (FrameLayout) b(R.id.ksad_web_card_container);
            this.f34484e = (WebView) b(R.id.ksad_actionbar_web_card);
        }
    }
}
