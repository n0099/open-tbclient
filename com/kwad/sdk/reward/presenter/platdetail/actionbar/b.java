package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
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
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.be;
/* loaded from: classes3.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f59806b;

    /* renamed from: c  reason: collision with root package name */
    public j.a f59807c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59808d;

    /* renamed from: e  reason: collision with root package name */
    public RewardActionBarControl f59809e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59810f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f59811g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f59812h;

    /* renamed from: i  reason: collision with root package name */
    public int f59813i;

    /* renamed from: j  reason: collision with root package name */
    public s f59814j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f59815k;
    public RewardActionBarControl.d l;
    public f m;
    public com.kwad.sdk.contentalliance.detail.video.d n;
    public b.c o;
    public long p;
    public j.b q;
    public i.b r;
    public p.b s;
    public ValueAnimator t;
    public ValueAnimator u;

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
        this.f59813i = -1;
        this.l = new RewardActionBarControl.d(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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

            @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    b bVar = this.a;
                    bVar.f59815k = bVar.u();
                    return this.a.f59815k;
                }
                return invokeV.booleanValue;
            }
        };
        this.m = new f(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                    this.a.e();
                }
            }
        };
        this.n = new e(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                    this.a.f59810f = true;
                }
            }
        };
        this.o = new b.c(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                    ((g) this.a).a.f59450b.a();
                }
            }
        };
        this.q = new j.b(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                    this.a.f59807c = aVar;
                    this.a.f59806b.setTranslationY(aVar.a + aVar.f58614d);
                }
            }
        };
        this.r = new i.b(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                    this.a.f59815k = false;
                    this.a.x();
                }
            }
        };
        this.s = new p.b(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                    this.a.f59813i = aVar.a;
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.a.p;
                    com.kwad.sdk.core.d.a.c("RewardActionBarWeb", "load time:" + elapsedRealtime);
                    if (this.a.f59813i == 1) {
                        com.kwad.sdk.core.report.d.b(((g) this.a).a.f59455g, elapsedRealtime);
                    }
                    if (this.a.f59810f) {
                        this.a.f59809e.b(((g) this.a).a.f59459k.f(), ((g) this.a).a.f59459k.g());
                    }
                }
            }
        };
    }

    private void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            int i2 = this.f59813i;
            String str = "show webCard fail, reason: " + (i2 == -1 ? com.alipay.sdk.data.a.O : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
        }
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f59812h, this.f59808d, this.o));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f59812h, this.f59808d, this.o));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f59812h));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f59812h));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f59812h));
            gVar.a(new j(this.f59812h, this.q));
            gVar.a(new p(this.s));
            s sVar = new s();
            this.f59814j = sVar;
            gVar.a(sVar);
            gVar.a(new t(this.f59812h, this.f59808d));
            gVar.a(new i(this.r));
            gVar.a(new k(this.f59812h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f59813i = -1;
            this.f59806b.setVisibility(8);
            t();
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f59812h = aVar;
            aVar.a(((g) this).a.f59455g);
            com.kwad.sdk.core.webview.a aVar2 = this.f59812h;
            com.kwad.sdk.reward.a aVar3 = ((g) this).a;
            aVar2.a = aVar3.f59454f;
            AdBaseFrameLayout adBaseFrameLayout = aVar3.f59458j;
            aVar2.f58536b = adBaseFrameLayout;
            aVar2.f58538d = adBaseFrameLayout;
            aVar2.f58539e = this.f59806b;
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.f59813i = -1;
            s();
            this.f59806b.setBackgroundColor(0);
            this.f59806b.getBackground().setAlpha(0);
            this.f59806b.setVisibility(4);
            this.p = SystemClock.elapsedRealtime();
            this.f59806b.loadUrl(com.kwad.sdk.core.response.a.b.b(((g) this).a.f59455g));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            t();
            be.a(this.f59806b);
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f59806b);
            this.f59811g = gVar;
            a(gVar);
            this.f59806b.addJavascriptInterface(this.f59811g, "KwaiAd");
        }
    }

    private void t() {
        com.kwad.sdk.core.webview.kwai.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || (gVar = this.f59811g) == null) {
            return;
        }
        gVar.a();
        this.f59811g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            KsAdWebView ksAdWebView = this.f59806b;
            if (ksAdWebView == null) {
                return false;
            }
            if (ksAdWebView.getVisibility() == 0) {
                return true;
            }
            if (this.f59813i == 1) {
                v();
                return true;
            }
            A();
            return false;
        }
        return invokeV.booleanValue;
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            if (this.f59807c == null) {
                w();
                return;
            }
            z();
            this.f59806b.setVisibility(0);
            KsAdWebView ksAdWebView = this.f59806b;
            j.a aVar = this.f59807c;
            ValueAnimator b2 = az.b(ksAdWebView, aVar.a + aVar.f58614d, 0);
            this.t = b2;
            b2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.t.setDuration(300L);
            this.t.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.8
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.a.f59814j != null) {
                            this.a.f59814j.d();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.a.f59814j != null) {
                            this.a.f59814j.c();
                        }
                    }
                }
            });
            this.t.start();
        }
    }

    private void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            s sVar = this.f59814j;
            if (sVar != null) {
                sVar.c();
            }
            this.f59806b.setVisibility(0);
            s sVar2 = this.f59814j;
            if (sVar2 != null) {
                sVar2.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65565, this) == null) && this.f59806b.getVisibility() == 0) {
            if (this.f59807c == null) {
                y();
                return;
            }
            z();
            KsAdWebView ksAdWebView = this.f59806b;
            j.a aVar = this.f59807c;
            ValueAnimator b2 = az.b(ksAdWebView, 0, aVar.a + aVar.f58614d);
            this.u = b2;
            b2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.u.setDuration(300L);
            this.u.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.9
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.a.f59806b.setVisibility(4);
                        if (this.a.f59814j != null) {
                            this.a.f59814j.f();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.a.f59814j != null) {
                            this.a.f59814j.e();
                        }
                    }
                }
            });
            this.u.start();
        }
    }

    private void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65566, this) == null) && this.f59806b.getVisibility() == 0) {
            s sVar = this.f59814j;
            if (sVar != null) {
                sVar.e();
            }
            this.f59806b.setVisibility(4);
            s sVar2 = this.f59814j;
            if (sVar2 != null) {
                sVar2.f();
            }
        }
    }

    private void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            ValueAnimator valueAnimator = this.t;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.t.cancel();
            }
            ValueAnimator valueAnimator2 = this.u;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllListeners();
                this.u.cancel();
            }
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            this.f59808d = aVar.l;
            RewardActionBarControl rewardActionBarControl = aVar.n;
            this.f59809e = rewardActionBarControl;
            rewardActionBarControl.a(this.l);
            i();
            r();
            ((g) this).a.a(this.m);
            ((g) this).a.f59459k.a(this.n);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f59809e.a((RewardActionBarControl.d) null);
            ((g) this).a.b(this.m);
            ((g) this).a.f59459k.b(this.n);
            z();
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f59806b = (KsAdWebView) a(R.id.ksad_play_web_card_webView);
        }
    }
}
