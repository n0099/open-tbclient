package com.kwad.sdk.reward.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ay;
import java.io.File;
/* loaded from: classes10.dex */
public class c extends com.kwad.sdk.reward.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f73244b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f73245c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f73246d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f73247e;

    /* renamed from: f  reason: collision with root package name */
    public int f73248f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f73249g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f73250h;

    /* renamed from: i  reason: collision with root package name */
    public String f73251i;

    /* renamed from: j  reason: collision with root package name */
    public RatioFrameLayout f73252j;
    public p k;
    public long l;
    public com.kwad.sdk.contentalliance.detail.video.d m;
    public a.b n;
    public i.b o;
    public m.b p;

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
        this.f73248f = -1;
        this.m = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.reward.b.c.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73263a;

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
                this.f73263a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.f();
                    this.f73263a.e();
                }
            }
        };
        this.n = new a.b(this) { // from class: com.kwad.sdk.reward.b.c.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73264a;

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
                this.f73264a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(@Nullable a.C2000a c2000a) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c2000a) == null) || ((com.kwad.sdk.reward.d) this.f73264a).f73410a.f73069b == null) {
                    return;
                }
                ((com.kwad.sdk.reward.d) this.f73264a).f73410a.f73069b.a();
            }
        };
        this.o = new i.b(this) { // from class: com.kwad.sdk.reward.b.c.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73255a;

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
                this.f73255a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.f73255a.f73244b.setTranslationY(aVar.f72360a + aVar.f72363d);
                }
            }
        };
        this.p = new m.b(this) { // from class: com.kwad.sdk.reward.b.c.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73256a;

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
                this.f73256a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f73256a.f73248f = i4;
                    com.kwad.sdk.core.d.a.c("RewardMiniCardPresenter", "updatePageStatus mPageState: " + i4);
                    if (this.f73256a.f73248f == -1) {
                        com.kwad.sdk.core.report.d.c(((com.kwad.sdk.reward.d) this.f73256a).f73410a.f73073f, this.f73256a.f73251i, "3");
                    }
                }
            }
        };
    }

    private void a(com.kwad.sdk.core.webview.a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f73247e, this.f73245c, this.n));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f73247e));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f73247e));
            gVar.a(new i(this.f73247e, this.o));
            gVar.a(new m(this.p));
            p pVar = new p();
            this.k = pVar;
            gVar.a(pVar);
            gVar.a(new q(this.f73247e, this.f73245c));
            gVar.a(new j(this.f73247e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f73248f = -1;
            this.f73244b.setVisibility(8);
            p();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f73247e = aVar;
            com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f73410a;
            aVar.f72243b = aVar2.f73073f;
            aVar.f72242a = 0;
            AdBaseFrameLayout adBaseFrameLayout = aVar2.f73075h;
            aVar.f72244c = adBaseFrameLayout;
            aVar.f72246e = adBaseFrameLayout;
            aVar.f72247f = this.f73244b;
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.f73248f = -1;
            o();
            this.f73244b.setBackgroundColor(0);
            this.f73244b.setVisibility(4);
            if (m() != null) {
                File g2 = com.kwad.sdk.core.config.c.g(m());
                if (g2.exists() && g2.length() > 0) {
                    this.f73251i = Uri.fromFile(g2).toString();
                }
            }
            if (this.f73251i == null) {
                this.f73251i = com.kwad.sdk.core.config.c.c().h5Url;
            }
            if (!TextUtils.isEmpty(this.f73251i)) {
                this.f73244b.loadUrl(this.f73251i);
            }
            this.f73244b.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.reward.b.c.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73265a;

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
                    this.f73265a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
                        com.kwad.sdk.core.report.d.c(((com.kwad.sdk.reward.d) this.f73265a).f73410a.f73073f, this.f73265a.f73251i, "1");
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }
            });
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            p();
            com.kwad.sdk.core.webview.a.g gVar = new com.kwad.sdk.core.webview.a.g(this.f73244b);
            this.f73246d = gVar;
            a(gVar);
            this.f73244b.addJavascriptInterface(this.f73246d, "KwaiAd");
        }
    }

    private void p() {
        com.kwad.sdk.core.webview.a.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (gVar = this.f73246d) == null) {
            return;
        }
        gVar.a();
        this.f73246d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || this.f73244b.getVisibility() == 0) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f73410a.f73076i.g();
        for (com.kwad.sdk.reward.a.e eVar : ((com.kwad.sdk.reward.d) this).f73410a.o) {
            eVar.a();
        }
        this.f73244b.setAlpha(1.0f);
        this.f73244b.setScaleX(0.0f);
        this.f73244b.setScaleY(0.0f);
        this.f73244b.setVisibility(0);
        this.k.c();
        this.f73244b.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.c.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73257a;

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
                this.f73257a = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f73257a.f73244b.setVisibility(0);
                    this.f73257a.k.d();
                }
            }
        }).start();
        this.f73244b.setVisibility(0);
        this.f73250h.setVisibility(0);
        this.f73250h.setAlpha(0.0f);
        this.f73250h.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73258a;

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
                this.f73258a = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    super.onAnimationCancel(animator);
                    this.f73258a.f73250h.setAlpha(1.0f);
                    this.f73258a.f73250h.setVisibility(0);
                }
            }
        }).setDuration(300L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65561, this) == null) && this.f73244b.getVisibility() == 0) {
            for (com.kwad.sdk.reward.a.e eVar : ((com.kwad.sdk.reward.d) this).f73410a.o) {
                eVar.b();
            }
            this.k.e();
            this.f73244b.setVisibility(0);
            this.f73244b.setScaleX(1.0f);
            this.f73244b.setScaleY(1.0f);
            this.f73244b.animate().scaleX(0.5f).scaleY(0.5f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73259a;

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
                    this.f73259a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f73259a.k.f();
                        this.f73259a.f73244b.setVisibility(8);
                    }
                }
            }).start();
            this.f73250h.animate().alpha(0.0f).setDuration(300L).setListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73260a;

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
                    this.f73260a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f73260a.f73250h.setVisibility(8);
                    }
                }
            }).start();
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            this.f73244b.animate().cancel();
            this.f73244b.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.l = SystemClock.elapsedRealtime();
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f73410a;
            this.f73245c = aVar.f73077j;
            aVar.f73076i.a(this.m);
            f();
            ay.b(this.f73244b);
            n();
            this.f73249g.setOnClickListener(new View.OnClickListener(this, com.kwad.sdk.core.response.b.c.i(((com.kwad.sdk.reward.d) this).f73410a.f73073f)) { // from class: com.kwad.sdk.reward.b.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f73253a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f73254b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73254b = this;
                    this.f73253a = r7;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!com.kwad.sdk.core.response.b.a.v(this.f73253a)) {
                            AdWebViewActivityProxy.launch(this.f73254b.m(), ((com.kwad.sdk.reward.d) this.f73254b).f73410a.f73073f);
                        } else if (TextUtils.isEmpty(this.f73254b.f73251i) || SystemClock.elapsedRealtime() - this.f73254b.l <= 1500) {
                        } else {
                            this.f73254b.q();
                        }
                    }
                }
            });
            this.f73250h.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.reward.b.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73261a;

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
                    this.f73261a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f73261a.r();
                        ((com.kwad.sdk.reward.d) this.f73261a).f73410a.f73076i.f();
                    }
                }
            });
            ((com.kwad.sdk.reward.d) this).f73410a.f73068a.add(new com.kwad.sdk.reward.a.a(this) { // from class: com.kwad.sdk.reward.b.c.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73262a;

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
                    this.f73262a = this;
                }

                @Override // com.kwad.sdk.reward.a.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.reward.a.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.reward.a.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f73262a.r();
                    }
                }

                @Override // com.kwad.sdk.reward.a.a
                public void d() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f73244b = (KsAdWebView) a(R.id.ksad_mini_web_card_webView);
            this.f73252j = (RatioFrameLayout) a(R.id.ksad_mini_web_card_container);
            this.f73250h = (ImageView) a(R.id.ksad_reward_mini_card_close);
            this.f73249g = (DetailVideoView) a(R.id.ksad_video_player);
            this.f73252j.setVisibility(0);
            this.f73252j.setRatio(1.0f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((com.kwad.sdk.reward.d) this).f73410a.f73076i.b(this.m);
            s();
            e();
        }
    }
}
