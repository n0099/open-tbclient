package com.kwad.sdk.reward.b.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.b.b.a.a;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ar;
/* loaded from: classes7.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WebView f38885b;

    /* renamed from: c  reason: collision with root package name */
    public i.a f38886c;

    /* renamed from: d  reason: collision with root package name */
    public AdStyleInfo.PlayDetailInfo.DetailWebCardInfo f38887d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f38888e;

    /* renamed from: f  reason: collision with root package name */
    public a f38889f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38890g;

    /* renamed from: h  reason: collision with root package name */
    public g f38891h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f38892i;
    public int j;
    public n k;
    public boolean l;
    public a.b m;
    public e n;
    public com.kwad.sdk.reward.a.d o;
    public com.kwad.sdk.contentalliance.detail.video.e p;
    public a.b q;
    public long r;
    public i.b s;
    public h.a t;
    public k.b u;
    public ValueAnimator v;
    public ValueAnimator w;

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
        this.j = -1;
        this.m = new a.b(this) { // from class: com.kwad.sdk.reward.b.b.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f38893a;

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
                this.f38893a = this;
            }

            @Override // com.kwad.sdk.reward.b.b.a.a.b
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    c cVar = this.f38893a;
                    cVar.l = cVar.q();
                    return this.f38893a.l;
                }
                return invokeV.booleanValue;
            }
        };
        this.n = new e(this) { // from class: com.kwad.sdk.reward.b.b.a.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f38896a;

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
                this.f38896a = this;
            }

            @Override // com.kwad.sdk.reward.a.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f38896a.e();
                }
            }
        };
        this.o = new com.kwad.sdk.reward.a.d(this) { // from class: com.kwad.sdk.reward.b.b.a.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f38897a;

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
                this.f38897a = this;
            }

            @Override // com.kwad.sdk.reward.a.d
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f38897a.t();
                }
            }

            @Override // com.kwad.sdk.reward.a.d
            public void b() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f38897a.l) {
                    this.f38897a.r();
                }
            }
        };
        this.p = new f(this) { // from class: com.kwad.sdk.reward.b.b.a.c.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f38898a;

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
                this.f38898a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.b();
                    this.f38898a.f38890g = true;
                }
            }
        };
        this.q = new a.b(this) { // from class: com.kwad.sdk.reward.b.b.a.c.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f38899a;

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
                this.f38899a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ((d) this.f38899a).f39062a.f38812b.a();
                }
            }
        };
        this.s = new i.b(this) { // from class: com.kwad.sdk.reward.b.b.a.c.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f38900a;

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
                this.f38900a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.f38900a.f38886c = aVar;
                    this.f38900a.f38885b.setTranslationY(aVar.f36868a + aVar.f36871d);
                }
            }
        };
        this.t = new h.a(this) { // from class: com.kwad.sdk.reward.b.b.a.c.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f38901a;

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
                this.f38901a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f38901a.l = false;
                    this.f38901a.t();
                }
            }
        };
        this.u = new k.b(this) { // from class: com.kwad.sdk.reward.b.b.a.c.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f38902a;

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
                this.f38902a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f38902a.j = i4;
                    com.kwad.sdk.core.d.a.b("RewardActionBarWeb", "load time:" + (System.currentTimeMillis() - this.f38902a.r));
                    if (this.f38902a.f38890g) {
                        this.f38902a.f38889f.b(((d) this.f38902a).f39062a.f38819i.i(), ((d) this.f38902a).f39062a.f38819i.j());
                    }
                }
            }
        };
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f38892i, this.f38888e, this.q));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f38892i));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f38892i));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f38892i));
            gVar.a(new i(this.f38892i, this.s));
            gVar.a(new k(this.u));
            n nVar = new n();
            this.k = nVar;
            gVar.a(nVar);
            gVar.a(new o(this.f38892i, this.f38888e));
            gVar.a(new h(this.t));
            gVar.a(new j(this.f38892i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.j = -1;
            this.f38885b.setVisibility(8);
            p();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f38892i = aVar;
            com.kwad.sdk.reward.a aVar2 = ((d) this).f39062a;
            aVar.f36790b = aVar2.f38816f;
            aVar.f36789a = aVar2.f38815e;
            AdBaseFrameLayout adBaseFrameLayout = aVar2.f38818h;
            aVar.f36791c = adBaseFrameLayout;
            aVar.f36793e = adBaseFrameLayout;
            aVar.f36794f = this.f38885b;
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.j = -1;
            h();
            this.f38885b.setBackgroundColor(0);
            this.f38885b.getBackground().setAlpha(0);
            this.f38885b.setVisibility(4);
            this.r = System.currentTimeMillis();
            this.f38885b.loadUrl(this.f38887d.cardUrl);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            p();
            ar.a(this.f38885b);
            g gVar = new g(this.f38885b);
            this.f38891h = gVar;
            a(gVar);
            this.f38885b.addJavascriptInterface(this.f38891h, "KwaiAd");
        }
    }

    private void p() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (gVar = this.f38891h) == null) {
            return;
        }
        gVar.a();
        this.f38891h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            if (this.f38885b.getVisibility() == 0) {
                return true;
            }
            if (this.j == 1) {
                r();
                return true;
            }
            w();
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            if (this.f38886c == null) {
                s();
                return;
            }
            v();
            this.f38885b.setVisibility(0);
            WebView webView = this.f38885b;
            i.a aVar = this.f38886c;
            ValueAnimator b2 = am.b(webView, aVar.f36868a + aVar.f36871d, 0);
            this.v = b2;
            b2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.v.setDuration(300L);
            this.v.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.b.a.c.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f38894a;

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
                    this.f38894a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.f38894a.k != null) {
                            this.f38894a.k.d();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f38894a.k != null) {
                            this.f38894a.k.c();
                        }
                    }
                }
            });
            this.v.start();
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            n nVar = this.k;
            if (nVar != null) {
                nVar.c();
            }
            this.f38885b.setVisibility(0);
            n nVar2 = this.k;
            if (nVar2 != null) {
                nVar2.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65563, this) == null) && this.f38885b.getVisibility() == 0) {
            if (this.f38886c == null) {
                u();
                return;
            }
            v();
            WebView webView = this.f38885b;
            i.a aVar = this.f38886c;
            ValueAnimator b2 = am.b(webView, 0, aVar.f36868a + aVar.f36871d);
            this.w = b2;
            b2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.w.setDuration(300L);
            this.w.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.b.a.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f38895a;

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
                    this.f38895a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f38895a.f38885b.setVisibility(4);
                        if (this.f38895a.k != null) {
                            this.f38895a.k.f();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f38895a.k != null) {
                            this.f38895a.k.e();
                        }
                    }
                }
            });
            this.w.start();
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65564, this) == null) && this.f38885b.getVisibility() == 0) {
            n nVar = this.k;
            if (nVar != null) {
                nVar.e();
            }
            this.f38885b.setVisibility(4);
            n nVar2 = this.k;
            if (nVar2 != null) {
                nVar2.f();
            }
        }
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            ValueAnimator valueAnimator = this.v;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.v.cancel();
            }
            ValueAnimator valueAnimator2 = this.w;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllListeners();
                this.w.cancel();
            }
        }
    }

    private void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            int i2 = this.j;
            String str = i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
            Log.w("RewardActionBarWeb", "show webCard fail, reason: " + str);
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f38887d = com.kwad.sdk.core.response.b.b.q(((d) this).f39062a.f38816f).playDetailInfo.detailWebCardInfo;
            com.kwad.sdk.reward.a aVar = ((d) this).f39062a;
            this.f38888e = aVar.j;
            a aVar2 = aVar.k;
            this.f38889f = aVar2;
            aVar2.a(this.m);
            f();
            g();
            ((d) this).f39062a.n.add(this.n);
            ((d) this).f39062a.f38819i.a(this.p);
            ((d) this).f39062a.o.add(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f38889f.a((a.b) null);
            ((d) this).f39062a.n.remove(this.n);
            ((d) this).f39062a.o.remove(this.o);
            ((d) this).f39062a.f38819i.b(this.p);
            v();
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f38885b = (WebView) b(R.id.ksad_play_web_card_webView);
        }
    }
}
