package com.kwad.sdk.draw.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.kwai.g;
import com.kwad.sdk.draw.a.a.a;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.be;
/* loaded from: classes2.dex */
public class c extends com.kwad.sdk.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f58329b;

    /* renamed from: c  reason: collision with root package name */
    public KsAdWebView f58330c;

    /* renamed from: d  reason: collision with root package name */
    public j.a f58331d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58332e;

    /* renamed from: f  reason: collision with root package name */
    public g f58333f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f58334g;

    /* renamed from: h  reason: collision with root package name */
    public int f58335h;

    /* renamed from: i  reason: collision with root package name */
    public s f58336i;

    /* renamed from: j  reason: collision with root package name */
    public AdTemplate f58337j;

    /* renamed from: k  reason: collision with root package name */
    public d f58338k;
    public a.b l;
    public b.c m;
    public j.b n;
    public i.b o;
    public p.b p;
    public ValueAnimator q;
    public ValueAnimator r;

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
        this.f58335h = -1;
        this.f58338k = new e(this) { // from class: com.kwad.sdk.draw.a.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.f();
                    this.a.e();
                }
            }
        };
        this.l = new a.b(this) { // from class: com.kwad.sdk.draw.a.a.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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

            @Override // com.kwad.sdk.draw.a.a.a.b
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.a.r() : invokeV.booleanValue;
            }
        };
        this.m = new b.c(this) { // from class: com.kwad.sdk.draw.a.a.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || ((com.kwad.sdk.draw.kwai.a) this.a).a.a == null) {
                    return;
                }
                ((com.kwad.sdk.draw.kwai.a) this.a).a.a.onAdClicked();
            }
        };
        this.n = new j.b(this) { // from class: com.kwad.sdk.draw.a.a.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                    this.a.f58331d = aVar;
                    this.a.f58330c.setTranslationY(aVar.a + aVar.f58033d);
                }
            }
        };
        this.o = new i.b(this) { // from class: com.kwad.sdk.draw.a.a.c.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                    this.a.u();
                }
            }
        };
        this.p = new p.b(this) { // from class: com.kwad.sdk.draw.a.a.c.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                    this.a.f58335h = aVar.a;
                    com.kwad.sdk.core.d.a.c("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
                }
            }
        };
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f58334g, this.f58332e, this.m));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f58334g, this.f58332e, this.m));
            gVar.a(new f(this.f58334g));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f58334g));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f58334g));
            gVar.a(new j(this.f58334g, this.n));
            gVar.a(new p(this.p));
            s sVar = new s();
            this.f58336i = sVar;
            gVar.a(sVar);
            gVar.a(new t(this.f58334g, this.f58332e));
            gVar.a(new i(this.o));
            gVar.a(new k(this.f58334g));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f58335h = -1;
            this.f58330c.setVisibility(8);
            i();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f58334g = aVar;
            aVar.a(((com.kwad.sdk.draw.kwai.a) this).a.f58379c);
            com.kwad.sdk.core.webview.a aVar2 = this.f58334g;
            aVar2.a = 0;
            AdBaseFrameLayout adBaseFrameLayout = ((com.kwad.sdk.draw.kwai.a) this).a.f58378b;
            aVar2.f57955b = adBaseFrameLayout;
            aVar2.f57957d = adBaseFrameLayout;
            aVar2.f57958e = this.f58330c;
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.f58335h = -1;
            h();
            this.f58330c.setBackgroundColor(0);
            this.f58330c.getBackground().setAlpha(0);
            this.f58330c.setVisibility(4);
            this.f58330c.loadUrl(com.kwad.sdk.core.response.a.b.b(this.f58337j));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            i();
            be.a(this.f58330c);
            g gVar = new g(this.f58330c);
            this.f58333f = gVar;
            a(gVar);
            this.f58330c.addJavascriptInterface(this.f58333f, "KwaiAd");
        }
    }

    private void i() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (gVar = this.f58333f) == null) {
            return;
        }
        gVar.a();
        this.f58333f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            if (this.f58335h == 1) {
                s();
                return true;
            }
            x();
            return false;
        }
        return invokeV.booleanValue;
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            if (this.f58331d == null) {
                t();
                return;
            }
            w();
            this.f58329b.setVisibility(8);
            this.f58330c.setVisibility(0);
            KsAdWebView ksAdWebView = this.f58330c;
            j.a aVar = this.f58331d;
            ValueAnimator b2 = az.b(ksAdWebView, aVar.a + aVar.f58033d, 0);
            this.q = b2;
            b2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.q.setDuration(300L);
            this.q.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.draw.a.a.c.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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
                        if (this.a.f58336i != null) {
                            this.a.f58336i.d();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.a.f58336i != null) {
                            this.a.f58336i.c();
                        }
                    }
                }
            });
            this.q.start();
        }
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            s sVar = this.f58336i;
            if (sVar != null) {
                sVar.c();
            }
            this.f58329b.setVisibility(8);
            this.f58330c.setVisibility(0);
            s sVar2 = this.f58336i;
            if (sVar2 != null) {
                sVar2.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, this) == null) && this.f58330c.getVisibility() == 0) {
            if (this.f58331d == null) {
                v();
                return;
            }
            w();
            KsAdWebView ksAdWebView = this.f58330c;
            j.a aVar = this.f58331d;
            ValueAnimator b2 = az.b(ksAdWebView, 0, aVar.a + aVar.f58033d);
            this.r = b2;
            b2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.r.setDuration(300L);
            this.r.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.draw.a.a.c.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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
                        this.a.f58330c.setVisibility(4);
                        this.a.f58329b.setVisibility(0);
                        if (this.a.f58336i != null) {
                            this.a.f58336i.f();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.a.f58336i != null) {
                            this.a.f58336i.e();
                        }
                    }
                }
            });
            this.r.start();
        }
    }

    private void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.f58330c.getVisibility() == 0) {
            s sVar = this.f58336i;
            if (sVar != null) {
                sVar.e();
            }
            this.f58330c.setVisibility(4);
            this.f58329b.setVisibility(0);
            s sVar2 = this.f58336i;
            if (sVar2 != null) {
                sVar2.f();
            }
        }
    }

    private void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            ValueAnimator valueAnimator = this.q;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.q.cancel();
            }
            ValueAnimator valueAnimator2 = this.r;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllListeners();
                this.r.cancel();
            }
        }
    }

    private void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            int i2 = this.f58335h;
            String str = "show webCard fail, reason: " + (i2 == -1 ? com.alipay.sdk.data.a.O : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
        }
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.draw.kwai.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a;
            this.f58337j = bVar.f58379c;
            bVar.f58382f.a(this.l);
            com.kwad.sdk.draw.kwai.b bVar2 = ((com.kwad.sdk.draw.kwai.a) this).a;
            this.f58332e = bVar2.f58380d;
            bVar2.f58381e.a(this.f58338k);
            f();
            g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            ((com.kwad.sdk.draw.kwai.a) this).a.f58382f.a((a.b) null);
            ((com.kwad.sdk.draw.kwai.a) this).a.f58381e.b(this.f58338k);
            w();
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f58329b = (ViewGroup) a(R.id.ksad_ad_normal_container);
            this.f58330c = (KsAdWebView) a(R.id.ksad_play_web_card_webView);
        }
    }
}
