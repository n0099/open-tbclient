package com.kwad.components.ad.draw.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.draw.a.a.a;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.d;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes5.dex */
public final class c extends com.kwad.components.ad.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup b;
    public KsAdWebView c;
    public o.a d;
    public com.kwad.components.core.c.a.b e;
    public com.kwad.components.core.webview.a f;
    public com.kwad.sdk.core.webview.b g;
    public int h;
    public x i;
    public AdTemplate j;
    public g k;
    public a.b l;
    public com.kwad.sdk.core.webview.a.kwai.a m;
    public o.b n;
    public n.b o;
    public u.b p;
    public ValueAnimator q;
    public ValueAnimator r;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = -1;
        this.k = new h(this) { // from class: com.kwad.components.ad.draw.a.a.c.1
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.d();
                    this.a.d();
                }
            }
        };
        this.l = new a.b(this) { // from class: com.kwad.components.ad.draw.a.a.c.2
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.ad.draw.a.a.a.b
            public final boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.a.j() : invokeV.booleanValue;
            }
        };
        this.m = new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.draw.a.a.c.3
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || ((com.kwad.components.ad.draw.kwai.a) this.a).a.a == null) {
                    return;
                }
                ((com.kwad.components.ad.draw.kwai.a) this.a).a.a.onAdClicked();
            }
        };
        this.n = new o.b(this) { // from class: com.kwad.components.ad.draw.a.a.c.4
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.o.b
            public final void a(o.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.a.d = aVar;
                    this.a.c.setTranslationY(aVar.a + aVar.d);
                }
            }
        };
        this.o = new n.b(this) { // from class: com.kwad.components.ad.draw.a.a.c.5
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.n.b
            public final void a(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    this.a.m();
                }
            }
        };
        this.p = new u.b(this) { // from class: com.kwad.components.ad.draw.a.a.c.6
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.u.b
            public final void a(u.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.a.h = aVar.a;
                    com.kwad.sdk.core.d.b.c("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
                }
            }
        };
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            aVar.a(new f(this.g, this.e, this.m));
            aVar.a(new d(this.g, this.e, this.m));
            aVar.a(new i(this.g));
            aVar.a(new l(this.g));
            aVar.a(new com.kwad.components.core.webview.jshandler.h(this.g));
            aVar.a(new o(this.g, this.n));
            aVar.a(new u(this.p, com.kwad.sdk.core.response.a.b.a(this.j)));
            x xVar = new x();
            this.i = xVar;
            aVar.a(xVar);
            aVar.a(new z(this.g, this.e));
            aVar.a(new n(this.o));
            aVar.a(new p(this.g));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.h = -1;
            this.c.setVisibility(8);
            i();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.g = bVar;
            bVar.a(((com.kwad.components.ad.draw.kwai.a) this).a.c);
            com.kwad.sdk.core.webview.b bVar2 = this.g;
            bVar2.a = 0;
            AdBaseFrameLayout adBaseFrameLayout = ((com.kwad.components.ad.draw.kwai.a) this).a.b;
            bVar2.b = adBaseFrameLayout;
            bVar2.d = adBaseFrameLayout;
            bVar2.e = this.c;
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.h = -1;
            h();
            this.c.setBackgroundColor(0);
            this.c.getBackground().setAlpha(0);
            this.c.setVisibility(4);
            this.c.loadUrl(com.kwad.sdk.core.response.a.b.a(this.j));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            i();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.c);
            this.f = aVar;
            a(aVar);
            this.c.addJavascriptInterface(this.f, "KwaiAd");
        }
    }

    private void i() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (aVar = this.f) == null) {
            return;
        }
        aVar.a();
        this.f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            if (this.h == 1) {
                k();
                return true;
            }
            w();
            return false;
        }
        return invokeV.booleanValue;
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            if (this.d == null) {
                l();
                return;
            }
            v();
            this.b.setVisibility(8);
            this.c.setVisibility(0);
            KsAdWebView ksAdWebView = this.c;
            o.a aVar = this.d;
            ValueAnimator b = com.kwad.components.core.l.n.b(ksAdWebView, aVar.a + aVar.d, 0);
            this.q = b;
            b.setInterpolator(new DecelerateInterpolator(2.0f));
            this.q.setDuration(300L);
            this.q.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.draw.a.a.c.7
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.a.i != null) {
                            this.a.i.d();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.a.i != null) {
                            this.a.i.c();
                        }
                    }
                }
            });
            this.q.start();
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            x xVar = this.i;
            if (xVar != null) {
                xVar.c();
            }
            this.b.setVisibility(8);
            this.c.setVisibility(0);
            x xVar2 = this.i;
            if (xVar2 != null) {
                xVar2.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, this) == null) && this.c.getVisibility() == 0) {
            if (this.d == null) {
                n();
                return;
            }
            v();
            KsAdWebView ksAdWebView = this.c;
            o.a aVar = this.d;
            ValueAnimator b = com.kwad.components.core.l.n.b(ksAdWebView, 0, aVar.a + aVar.d);
            this.r = b;
            b.setInterpolator(new DecelerateInterpolator(2.0f));
            this.r.setDuration(300L);
            this.r.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.draw.a.a.c.8
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.a.c.setVisibility(4);
                        this.a.b.setVisibility(0);
                        if (this.a.i != null) {
                            this.a.i.f();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.a.i != null) {
                            this.a.i.e();
                        }
                    }
                }
            });
            this.r.start();
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.c.getVisibility() == 0) {
            x xVar = this.i;
            if (xVar != null) {
                xVar.e();
            }
            this.c.setVisibility(4);
            this.b.setVisibility(0);
            x xVar2 = this.i;
            if (xVar2 != null) {
                xVar2.f();
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
            int i = this.h;
            String str = i == -1 ? "timeout" : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
            com.kwad.sdk.core.d.b.d("DrawPlayWebCard", "show webCard fail, reason: " + str);
        }
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.components.ad.draw.kwai.b bVar = ((com.kwad.components.ad.draw.kwai.a) this).a;
            this.j = bVar.c;
            bVar.f.a(this.l);
            com.kwad.components.ad.draw.kwai.b bVar2 = ((com.kwad.components.ad.draw.kwai.a) this).a;
            this.e = bVar2.d;
            bVar2.e.a(this.k);
            e();
            g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
            this.b = (ViewGroup) b(R.id.obfuscated_res_0x7f090fe9);
            this.c = (KsAdWebView) b(R.id.obfuscated_res_0x7f0910b4);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.k_();
            ((com.kwad.components.ad.draw.kwai.a) this).a.f.a((a.b) null);
            ((com.kwad.components.ad.draw.kwai.a) this).a.e.b(this.k);
            v();
            d();
        }
    }
}
