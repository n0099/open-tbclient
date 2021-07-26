package com.kwad.sdk.reward.b.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
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
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.b.b.a.a;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.ay;
/* loaded from: classes6.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WebView f36151b;

    /* renamed from: c  reason: collision with root package name */
    public i.a f36152c;

    /* renamed from: d  reason: collision with root package name */
    public AdStyleInfo.PlayDetailInfo.DetailWebCardInfo f36153d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36154e;

    /* renamed from: f  reason: collision with root package name */
    public a f36155f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36156g;

    /* renamed from: h  reason: collision with root package name */
    public g f36157h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f36158i;
    public int j;
    public p k;
    public boolean l;
    public a.b m;
    public f n;
    public e o;
    public com.kwad.sdk.contentalliance.detail.video.d p;
    public a.b q;
    public long r;
    public i.b s;
    public h.a t;
    public m.b u;
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
            public final /* synthetic */ c f36159a;

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
                this.f36159a = this;
            }

            @Override // com.kwad.sdk.reward.b.b.a.a.b
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    c cVar = this.f36159a;
                    cVar.l = cVar.q();
                    return this.f36159a.l;
                }
                return invokeV.booleanValue;
            }
        };
        this.n = new f(this) { // from class: com.kwad.sdk.reward.b.b.a.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f36162a;

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
                this.f36162a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36162a.e();
                }
            }
        };
        this.o = new e(this) { // from class: com.kwad.sdk.reward.b.b.a.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f36163a;

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
                this.f36163a = this;
            }

            @Override // com.kwad.sdk.reward.a.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36163a.t();
                }
            }

            @Override // com.kwad.sdk.reward.a.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f36163a.l) {
                    this.f36163a.r();
                }
            }
        };
        this.p = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.reward.b.b.a.c.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f36164a;

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
                this.f36164a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.c();
                    this.f36164a.f36156g = true;
                }
            }
        };
        this.q = new a.b(this) { // from class: com.kwad.sdk.reward.b.b.a.c.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f36165a;

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
                this.f36165a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C0429a c0429a) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, c0429a) == null) {
                    ((d) this.f36165a).f36403a.f36073b.a();
                }
            }
        };
        this.s = new i.b(this) { // from class: com.kwad.sdk.reward.b.b.a.c.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f36166a;

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
                this.f36166a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.f36166a.f36152c = aVar;
                    this.f36166a.f36151b.setTranslationY(aVar.f35403a + aVar.f35406d);
                }
            }
        };
        this.t = new h.a(this) { // from class: com.kwad.sdk.reward.b.b.a.c.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f36167a;

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
                this.f36167a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36167a.l = false;
                    this.f36167a.t();
                }
            }
        };
        this.u = new m.b(this) { // from class: com.kwad.sdk.reward.b.b.a.c.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f36168a;

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
                this.f36168a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f36168a.j = i4;
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.f36168a.r;
                    com.kwad.sdk.core.d.a.c("RewardActionBarWeb", "load time:" + elapsedRealtime);
                    if (this.f36168a.j == 1) {
                        com.kwad.sdk.core.report.d.b(((d) this.f36168a).f36403a.f36077f, elapsedRealtime);
                    }
                    if (this.f36168a.f36156g) {
                        this.f36168a.f36155f.b(((d) this.f36168a).f36403a.f36080i.j(), ((d) this.f36168a).f36403a.f36080i.k());
                    }
                }
            }
        };
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f36158i, this.f36154e, this.q));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f36158i));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f36158i));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f36158i));
            gVar.a(new i(this.f36158i, this.s));
            gVar.a(new m(this.u));
            p pVar = new p();
            this.k = pVar;
            gVar.a(pVar);
            gVar.a(new q(this.f36158i, this.f36154e));
            gVar.a(new h(this.t));
            gVar.a(new j(this.f36158i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.j = -1;
            this.f36151b.setVisibility(8);
            p();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f36158i = aVar;
            com.kwad.sdk.reward.a aVar2 = ((d) this).f36403a;
            aVar.f35288b = aVar2.f36077f;
            aVar.f35287a = aVar2.f36076e;
            AdBaseFrameLayout adBaseFrameLayout = aVar2.f36079h;
            aVar.f35289c = adBaseFrameLayout;
            aVar.f35291e = adBaseFrameLayout;
            aVar.f35292f = this.f36151b;
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            this.j = -1;
            o();
            this.f36151b.setBackgroundColor(0);
            this.f36151b.getBackground().setAlpha(0);
            this.f36151b.setVisibility(4);
            this.r = SystemClock.elapsedRealtime();
            this.f36151b.loadUrl(this.f36153d.cardUrl);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            p();
            ay.a(this.f36151b);
            g gVar = new g(this.f36151b);
            this.f36157h = gVar;
            a(gVar);
            this.f36151b.addJavascriptInterface(this.f36157h, "KwaiAd");
        }
    }

    private void p() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || (gVar = this.f36157h) == null) {
            return;
        }
        gVar.a();
        this.f36157h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            WebView webView = this.f36151b;
            if (webView == null) {
                return false;
            }
            if (webView.getVisibility() == 0) {
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
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            if (this.f36152c == null) {
                s();
                return;
            }
            v();
            this.f36151b.setVisibility(0);
            WebView webView = this.f36151b;
            i.a aVar = this.f36152c;
            ValueAnimator b2 = at.b(webView, aVar.f35403a + aVar.f35406d, 0);
            this.v = b2;
            b2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.v.setDuration(300L);
            this.v.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.b.a.c.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f36160a;

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
                    this.f36160a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.f36160a.k != null) {
                            this.f36160a.k.d();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f36160a.k != null) {
                            this.f36160a.k.c();
                        }
                    }
                }
            });
            this.v.start();
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            p pVar = this.k;
            if (pVar != null) {
                pVar.c();
            }
            this.f36151b.setVisibility(0);
            p pVar2 = this.k;
            if (pVar2 != null) {
                pVar2.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65565, this) == null) && this.f36151b.getVisibility() == 0) {
            if (this.f36152c == null) {
                u();
                return;
            }
            v();
            WebView webView = this.f36151b;
            i.a aVar = this.f36152c;
            ValueAnimator b2 = at.b(webView, 0, aVar.f35403a + aVar.f35406d);
            this.w = b2;
            b2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.w.setDuration(300L);
            this.w.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.b.a.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f36161a;

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
                    this.f36161a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f36161a.f36151b.setVisibility(4);
                        if (this.f36161a.k != null) {
                            this.f36161a.k.f();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f36161a.k != null) {
                            this.f36161a.k.e();
                        }
                    }
                }
            });
            this.w.start();
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65566, this) == null) && this.f36151b.getVisibility() == 0) {
            p pVar = this.k;
            if (pVar != null) {
                pVar.e();
            }
            this.f36151b.setVisibility(4);
            p pVar2 = this.k;
            if (pVar2 != null) {
                pVar2.f();
            }
        }
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
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
            this.f36153d = com.kwad.sdk.core.response.b.b.k(((d) this).f36403a.f36077f).playDetailInfo.detailWebCardInfo;
            com.kwad.sdk.reward.a aVar = ((d) this).f36403a;
            this.f36154e = aVar.j;
            a aVar2 = aVar.k;
            this.f36155f = aVar2;
            aVar2.a(this.m);
            f();
            n();
            ((d) this).f36403a.a(this.n);
            ((d) this).f36403a.f36080i.a(this.p);
            ((d) this).f36403a.o.add(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f36151b = (WebView) a(R.id.ksad_play_web_card_webView);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f36155f.a((a.b) null);
            ((d) this).f36403a.b(this.n);
            ((d) this).f36403a.o.remove(this.o);
            ((d) this).f36403a.f36080i.b(this.p);
            v();
            e();
        }
    }
}
