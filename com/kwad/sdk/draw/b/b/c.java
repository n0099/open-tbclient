package com.kwad.sdk.draw.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.ViewGroup;
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
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.draw.b.b.a;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.ay;
/* loaded from: classes2.dex */
public class c extends com.kwad.sdk.draw.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f65611b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f65612c;

    /* renamed from: d  reason: collision with root package name */
    public i.a f65613d;

    /* renamed from: e  reason: collision with root package name */
    public AdStyleInfo.PlayDetailInfo.DetailWebCardInfo f65614e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f65615f;

    /* renamed from: g  reason: collision with root package name */
    public g f65616g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f65617h;

    /* renamed from: i  reason: collision with root package name */
    public int f65618i;
    public p j;
    public d k;
    public a.b l;
    public a.b m;
    public i.b n;
    public h.a o;
    public m.b p;
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
        this.f65618i = -1;
        this.k = new e(this) { // from class: com.kwad.sdk.draw.b.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f65619a;

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
                this.f65619a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.f();
                    this.f65619a.e();
                }
            }
        };
        this.l = new a.b(this) { // from class: com.kwad.sdk.draw.b.b.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f65620a;

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
                this.f65620a = this;
            }

            @Override // com.kwad.sdk.draw.b.b.a.b
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f65620a.q() : invokeV.booleanValue;
            }
        };
        this.m = new a.b(this) { // from class: com.kwad.sdk.draw.b.b.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f65621a;

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
                this.f65621a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C1916a c1916a) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c1916a) == null) || ((com.kwad.sdk.draw.a.a) this.f65621a).f65560a.f65561a == null) {
                    return;
                }
                ((com.kwad.sdk.draw.a.a) this.f65621a).f65560a.f65561a.onAdClicked();
            }
        };
        this.n = new i.b(this) { // from class: com.kwad.sdk.draw.b.b.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f65622a;

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
                this.f65622a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.f65622a.f65613d = aVar;
                    this.f65622a.f65612c.setTranslationY(aVar.f65341a + aVar.f65344d);
                }
            }
        };
        this.o = new h.a(this) { // from class: com.kwad.sdk.draw.b.b.c.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f65623a;

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
                this.f65623a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f65623a.t();
                }
            }
        };
        this.p = new m.b(this) { // from class: com.kwad.sdk.draw.b.b.c.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f65624a;

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
                this.f65624a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f65624a.f65618i = i4;
                    com.kwad.sdk.core.d.a.c("DrawPlayWebCard", "updatePageStatus mPageState: " + i4);
                }
            }
        };
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f65617h, this.f65615f, this.m));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f65617h));
            gVar.a(new f(this.f65617h));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f65617h));
            gVar.a(new i(this.f65617h, this.n));
            gVar.a(new m(this.p));
            p pVar = new p();
            this.j = pVar;
            gVar.a(pVar);
            gVar.a(new q(this.f65617h, this.f65615f));
            gVar.a(new h(this.o));
            gVar.a(new j(this.f65617h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f65618i = -1;
            this.f65612c.setVisibility(8);
            p();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f65617h = aVar;
            com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f65560a;
            aVar.f65226b = bVar.f65563c;
            aVar.f65225a = 0;
            AdBaseFrameLayout adBaseFrameLayout = bVar.f65562b;
            aVar.f65227c = adBaseFrameLayout;
            aVar.f65229e = adBaseFrameLayout;
            aVar.f65230f = this.f65612c;
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f65618i = -1;
            o();
            this.f65612c.setBackgroundColor(0);
            this.f65612c.getBackground().setAlpha(0);
            this.f65612c.setVisibility(4);
            this.f65612c.loadUrl(this.f65614e.cardUrl);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            p();
            ay.a(this.f65612c);
            g gVar = new g(this.f65612c);
            this.f65616g = gVar;
            a(gVar);
            this.f65612c.addJavascriptInterface(this.f65616g, "KwaiAd");
        }
    }

    private void p() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (gVar = this.f65616g) == null) {
            return;
        }
        gVar.a();
        this.f65616g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            if (this.f65618i == 1) {
                r();
                return true;
            }
            w();
            return false;
        }
        return invokeV.booleanValue;
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            if (this.f65613d == null) {
                s();
                return;
            }
            v();
            this.f65611b.setVisibility(8);
            this.f65612c.setVisibility(0);
            WebView webView = this.f65612c;
            i.a aVar = this.f65613d;
            ValueAnimator b2 = at.b(webView, aVar.f65341a + aVar.f65344d, 0);
            this.q = b2;
            b2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.q.setDuration(300L);
            this.q.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.draw.b.b.c.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f65625a;

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
                    this.f65625a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.f65625a.j != null) {
                            this.f65625a.j.d();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f65625a.j != null) {
                            this.f65625a.j.c();
                        }
                    }
                }
            });
            this.q.start();
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            p pVar = this.j;
            if (pVar != null) {
                pVar.c();
            }
            this.f65611b.setVisibility(8);
            this.f65612c.setVisibility(0);
            p pVar2 = this.j;
            if (pVar2 != null) {
                pVar2.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, this) == null) && this.f65612c.getVisibility() == 0) {
            if (this.f65613d == null) {
                u();
                return;
            }
            v();
            WebView webView = this.f65612c;
            i.a aVar = this.f65613d;
            ValueAnimator b2 = at.b(webView, 0, aVar.f65341a + aVar.f65344d);
            this.r = b2;
            b2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.r.setDuration(300L);
            this.r.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.draw.b.b.c.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f65626a;

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
                    this.f65626a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f65626a.f65612c.setVisibility(4);
                        this.f65626a.f65611b.setVisibility(0);
                        if (this.f65626a.j != null) {
                            this.f65626a.j.f();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f65626a.j != null) {
                            this.f65626a.j.e();
                        }
                    }
                }
            });
            this.r.start();
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.f65612c.getVisibility() == 0) {
            p pVar = this.j;
            if (pVar != null) {
                pVar.e();
            }
            this.f65612c.setVisibility(4);
            this.f65611b.setVisibility(0);
            p pVar2 = this.j;
            if (pVar2 != null) {
                pVar2.f();
            }
        }
    }

    private void v() {
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

    private void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            int i2 = this.f65618i;
            String str = "show webCard fail, reason: " + (i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f65614e = com.kwad.sdk.core.response.b.b.k(((com.kwad.sdk.draw.a.a) this).f65560a.f65563c).playDetailInfo.detailWebCardInfo;
            ((com.kwad.sdk.draw.a.a) this).f65560a.f65566f.a(this.l);
            com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f65560a;
            this.f65615f = bVar.f65564d;
            bVar.f65565e.a(this.k);
            f();
            n();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f65611b = (ViewGroup) a(R.id.ksad_ad_normal_container);
            this.f65612c = (WebView) a(R.id.ksad_play_web_card_webView);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((com.kwad.sdk.draw.a.a) this).f65560a.f65566f.a((a.b) null);
            ((com.kwad.sdk.draw.a.a) this).f65560a.f65565e.b(this.k);
            v();
            e();
        }
    }
}
