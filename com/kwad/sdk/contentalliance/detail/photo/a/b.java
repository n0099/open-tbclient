package com.kwad.sdk.contentalliance.detail.photo.a;

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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.e;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ar;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdBaseFrameLayout f34588a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f34589b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f34590c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f34591d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f34592e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f34593f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34594g;

    /* renamed from: h  reason: collision with root package name */
    public String f34595h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f34596i;
    public g j;
    public n k;
    public int l;
    public ViewTreeObserver.OnGlobalLayoutListener m;
    public int n;
    public boolean o;
    public boolean p;
    public ValueAnimator q;
    public ValueAnimator r;
    public a.b s;
    public Runnable t;
    public h.a u;
    public k.b v;

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
        this.o = false;
        this.p = false;
        this.s = new a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34598a;

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
                this.f34598a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(this.f34598a.f34593f))) {
                        this.f34598a.f34592e.post(this.f34598a.t);
                    } else {
                        this.f34598a.f34592e.postDelayed(this.f34598a.t, 100L);
                    }
                }
            }
        };
        this.t = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34599a;

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
                this.f34599a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34599a.a(false);
                }
            }
        };
        this.u = new h.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34600a;

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
                this.f34600a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34600a.a(true);
                }
            }
        };
        this.v = new k.b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34601a;

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
                this.f34601a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f34601a.l = i4;
                }
            }
        };
    }

    private void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f34596i, this.f34594g, this.s));
            gVar.a(new e(this.f34596i));
            gVar.a(new f(this.f34596i));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f34596i));
            gVar.a(new i(this.f34596i, null));
            gVar.a(new k(this.v));
            n nVar = new n();
            this.k = nVar;
            gVar.a(nVar);
            gVar.a(new o(this.f34596i, this.f34594g));
            gVar.a(new h(this.u));
            gVar.a(new j(this.f34596i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, this, z) == null) && ao.a((View) this.f34592e, 50, false)) {
            this.p = z;
            if (z) {
                this.f34590c.setVisibility(8);
            }
            j();
            ValueAnimator a2 = am.a(this.f34591d, this.f34589b, this.n);
            this.r = a2;
            a2.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f34603a;

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
                    this.f34603a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.f34603a.k != null) {
                            this.f34603a.k.f();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f34603a.k != null) {
                            this.f34603a.k.e();
                        }
                    }
                }
            });
            this.r.start();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f34591d.setVisibility(4);
            this.f34592e.setBackgroundColor(0);
            this.f34592e.getBackground().setAlpha(0);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f34596i = aVar;
            aVar.f36790b = this.f34593f;
            aVar.f36789a = 0;
            aVar.f36791c = this.f34588a;
            aVar.f36793e = this.f34591d;
            aVar.f36794f = this.f34592e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.n = this.f34591d.getWidth() + ao.a(this.f34591d.getContext(), 12.0f);
            com.kwad.sdk.core.d.a.a("PatchAdWebCard", "initWebCard mWebCardContainerWidth:" + this.n);
            this.f34591d.setTranslationX((float) (-this.n));
            this.f34591d.setVisibility(0);
            g();
            this.l = -1;
            this.f34592e.loadUrl(this.f34595h);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            h();
            ar.a(this.f34592e);
            g gVar = new g(this.f34592e);
            this.j = gVar;
            a(gVar);
            this.f34592e.addJavascriptInterface(this.j, "KwaiAd");
        }
    }

    private void h() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (gVar = this.j) == null) {
            return;
        }
        gVar.a();
        this.j = null;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            j();
            ValueAnimator a2 = am.a(this.f34589b, this.f34591d, this.n);
            this.q = a2;
            a2.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f34602a;

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
                    this.f34602a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.f34602a.k != null) {
                            this.f34602a.k.d();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f34602a.k != null) {
                            this.f34602a.k.c();
                        }
                    }
                }
            });
            this.q.start();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
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

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            int i2 = this.l;
            String str = i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
            Log.w("PatchAdWebCard", "show webCard fail, reason: " + str);
            com.kwad.sdk.core.report.b.n(this.f34593f);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.m = new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f34597a;

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
                    this.f34597a = this;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f34597a.f34591d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        this.f34597a.m = null;
                        this.f34597a.f();
                    }
                }
            };
            this.f34591d.getViewTreeObserver().addOnGlobalLayoutListener(this.m);
        }
    }

    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, FrameLayout frameLayout, WebView webView, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{viewGroup, viewGroup2, frameLayout, webView, adBaseFrameLayout, adTemplate, bVar}) == null) {
            this.f34589b = viewGroup;
            this.f34590c = viewGroup2;
            this.f34591d = frameLayout;
            this.f34592e = webView;
            this.f34588a = adBaseFrameLayout;
            this.f34593f = adTemplate;
            this.f34594g = bVar;
            this.f34595h = com.kwad.sdk.core.response.b.b.a(adTemplate).strongStyleCardUrl;
            d();
            e();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o = false;
            this.p = false;
            this.l = -1;
            h();
            j();
            if (this.m != null) {
                this.f34591d.getViewTreeObserver().removeOnGlobalLayoutListener(this.m);
            }
            this.f34589b.setTranslationX(0.0f);
            this.f34591d.setVisibility(8);
            this.f34592e.removeCallbacks(this.t);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.o || this.p) {
            return;
        }
        this.o = true;
        com.kwad.sdk.core.d.a.a("PatchAdWebCard", "showWebActionBar");
        if (this.l == 1) {
            i();
        } else {
            k();
        }
    }
}
