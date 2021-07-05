package com.kwad.sdk.draw.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.util.Log;
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
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.draw.b.b.a;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ar;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.draw.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f37082b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f37083c;

    /* renamed from: d  reason: collision with root package name */
    public i.a f37084d;

    /* renamed from: e  reason: collision with root package name */
    public AdStyleInfo.PlayDetailInfo.DetailWebCardInfo f37085e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37086f;

    /* renamed from: g  reason: collision with root package name */
    public g f37087g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f37088h;

    /* renamed from: i  reason: collision with root package name */
    public int f37089i;
    public n j;
    public e k;
    public a.b l;
    public a.b m;
    public i.b n;
    public h.a o;
    public k.b p;
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
        this.f37089i = -1;
        this.k = new f(this) { // from class: com.kwad.sdk.draw.b.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f37090a;

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
                this.f37090a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.a();
                    this.f37090a.e();
                }
            }
        };
        this.l = new a.b(this) { // from class: com.kwad.sdk.draw.b.b.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f37091a;

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
                this.f37091a = this;
            }

            @Override // com.kwad.sdk.draw.b.b.a.b
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f37091a.q() : invokeV.booleanValue;
            }
        };
        this.m = new a.b(this) { // from class: com.kwad.sdk.draw.b.b.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f37092a;

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
                this.f37092a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((com.kwad.sdk.draw.a.a) this.f37092a).f37034a.f37035a == null) {
                    return;
                }
                ((com.kwad.sdk.draw.a.a) this.f37092a).f37034a.f37035a.onAdClicked();
            }
        };
        this.n = new i.b(this) { // from class: com.kwad.sdk.draw.b.b.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f37093a;

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
                this.f37093a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.f37093a.f37084d = aVar;
                    this.f37093a.f37083c.setTranslationY(aVar.f36868a + aVar.f36871d);
                }
            }
        };
        this.o = new h.a(this) { // from class: com.kwad.sdk.draw.b.b.c.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f37094a;

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
                this.f37094a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f37094a.t();
                }
            }
        };
        this.p = new k.b(this) { // from class: com.kwad.sdk.draw.b.b.c.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f37095a;

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
                this.f37095a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f37095a.f37089i = i4;
                    com.kwad.sdk.core.d.a.b("DrawPlayWebCard", "updatePageStatus mPageState: " + i4);
                }
            }
        };
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f37088h, this.f37086f, this.m));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f37088h));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f37088h));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f37088h));
            gVar.a(new i(this.f37088h, this.n));
            gVar.a(new k(this.p));
            n nVar = new n();
            this.j = nVar;
            gVar.a(nVar);
            gVar.a(new o(this.f37088h, this.f37086f));
            gVar.a(new h(this.o));
            gVar.a(new j(this.f37088h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f37089i = -1;
            this.f37083c.setVisibility(8);
            p();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f37088h = aVar;
            com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f37034a;
            aVar.f36790b = bVar.f37037c;
            aVar.f36789a = 0;
            AdBaseFrameLayout adBaseFrameLayout = bVar.f37036b;
            aVar.f36791c = adBaseFrameLayout;
            aVar.f36793e = adBaseFrameLayout;
            aVar.f36794f = this.f37083c;
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.f37089i = -1;
            h();
            this.f37083c.setBackgroundColor(0);
            this.f37083c.getBackground().setAlpha(0);
            this.f37083c.setVisibility(4);
            this.f37083c.loadUrl(this.f37085e.cardUrl);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            p();
            ar.a(this.f37083c);
            g gVar = new g(this.f37083c);
            this.f37087g = gVar;
            a(gVar);
            this.f37083c.addJavascriptInterface(this.f37087g, "KwaiAd");
        }
    }

    private void p() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (gVar = this.f37087g) == null) {
            return;
        }
        gVar.a();
        this.f37087g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            if (this.f37089i == 1) {
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
            if (this.f37084d == null) {
                s();
                return;
            }
            v();
            this.f37082b.setVisibility(8);
            this.f37083c.setVisibility(0);
            WebView webView = this.f37083c;
            i.a aVar = this.f37084d;
            ValueAnimator b2 = am.b(webView, aVar.f36868a + aVar.f36871d, 0);
            this.q = b2;
            b2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.q.setDuration(300L);
            this.q.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.draw.b.b.c.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f37096a;

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
                    this.f37096a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.f37096a.j != null) {
                            this.f37096a.j.d();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f37096a.j != null) {
                            this.f37096a.j.c();
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
            n nVar = this.j;
            if (nVar != null) {
                nVar.c();
            }
            this.f37082b.setVisibility(8);
            this.f37083c.setVisibility(0);
            n nVar2 = this.j;
            if (nVar2 != null) {
                nVar2.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, this) == null) && this.f37083c.getVisibility() == 0) {
            if (this.f37084d == null) {
                u();
                return;
            }
            v();
            WebView webView = this.f37083c;
            i.a aVar = this.f37084d;
            ValueAnimator b2 = am.b(webView, 0, aVar.f36868a + aVar.f36871d);
            this.r = b2;
            b2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.r.setDuration(300L);
            this.r.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.draw.b.b.c.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f37097a;

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
                    this.f37097a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f37097a.f37083c.setVisibility(4);
                        this.f37097a.f37082b.setVisibility(0);
                        if (this.f37097a.j != null) {
                            this.f37097a.j.f();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f37097a.j != null) {
                            this.f37097a.j.e();
                        }
                    }
                }
            });
            this.r.start();
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.f37083c.getVisibility() == 0) {
            n nVar = this.j;
            if (nVar != null) {
                nVar.e();
            }
            this.f37083c.setVisibility(4);
            this.f37082b.setVisibility(0);
            n nVar2 = this.j;
            if (nVar2 != null) {
                nVar2.f();
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
            int i2 = this.f37089i;
            String str = i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
            Log.w("DrawPlayWebCard", "show webCard fail, reason: " + str);
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f37085e = com.kwad.sdk.core.response.b.b.q(((com.kwad.sdk.draw.a.a) this).f37034a.f37037c).playDetailInfo.detailWebCardInfo;
            ((com.kwad.sdk.draw.a.a) this).f37034a.f37040f.a(this.l);
            com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f37034a;
            this.f37086f = bVar.f37038d;
            bVar.f37039e.a(this.k);
            f();
            g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.draw.a.a) this).f37034a.f37040f.a((a.b) null);
            ((com.kwad.sdk.draw.a.a) this).f37034a.f37039e.b(this.k);
            v();
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f37082b = (ViewGroup) b(R.id.ksad_ad_normal_container);
            this.f37083c = (WebView) b(R.id.ksad_play_web_card_webView);
        }
    }
}
