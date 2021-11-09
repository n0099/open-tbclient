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
/* loaded from: classes2.dex */
public class c extends com.kwad.sdk.reward.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f66178b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f66179c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f66180d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f66181e;

    /* renamed from: f  reason: collision with root package name */
    public int f66182f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f66183g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f66184h;

    /* renamed from: i  reason: collision with root package name */
    public String f66185i;
    public RatioFrameLayout j;
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
        this.f66182f = -1;
        this.m = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.reward.b.c.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66196a;

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
                this.f66196a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.f();
                    this.f66196a.e();
                }
            }
        };
        this.n = new a.b(this) { // from class: com.kwad.sdk.reward.b.c.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66197a;

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
                this.f66197a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(@Nullable a.C1916a c1916a) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c1916a) == null) || ((com.kwad.sdk.reward.d) this.f66197a).f66342a.f66011b == null) {
                    return;
                }
                ((com.kwad.sdk.reward.d) this.f66197a).f66342a.f66011b.a();
            }
        };
        this.o = new i.b(this) { // from class: com.kwad.sdk.reward.b.c.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66188a;

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
                this.f66188a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.f66188a.f66178b.setTranslationY(aVar.f65341a + aVar.f65344d);
                }
            }
        };
        this.p = new m.b(this) { // from class: com.kwad.sdk.reward.b.c.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66189a;

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
                this.f66189a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f66189a.f66182f = i4;
                    com.kwad.sdk.core.d.a.c("RewardMiniCardPresenter", "updatePageStatus mPageState: " + i4);
                    if (this.f66189a.f66182f == -1) {
                        com.kwad.sdk.core.report.d.c(((com.kwad.sdk.reward.d) this.f66189a).f66342a.f66015f, this.f66189a.f66185i, "3");
                    }
                }
            }
        };
    }

    private void a(com.kwad.sdk.core.webview.a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f66181e, this.f66179c, this.n));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f66181e));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f66181e));
            gVar.a(new i(this.f66181e, this.o));
            gVar.a(new m(this.p));
            p pVar = new p();
            this.k = pVar;
            gVar.a(pVar);
            gVar.a(new q(this.f66181e, this.f66179c));
            gVar.a(new j(this.f66181e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f66182f = -1;
            this.f66178b.setVisibility(8);
            p();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f66181e = aVar;
            com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f66342a;
            aVar.f65226b = aVar2.f66015f;
            aVar.f65225a = 0;
            AdBaseFrameLayout adBaseFrameLayout = aVar2.f66017h;
            aVar.f65227c = adBaseFrameLayout;
            aVar.f65229e = adBaseFrameLayout;
            aVar.f65230f = this.f66178b;
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.f66182f = -1;
            o();
            this.f66178b.setBackgroundColor(0);
            this.f66178b.setVisibility(4);
            if (m() != null) {
                File g2 = com.kwad.sdk.core.config.c.g(m());
                if (g2.exists() && g2.length() > 0) {
                    this.f66185i = Uri.fromFile(g2).toString();
                }
            }
            if (this.f66185i == null) {
                this.f66185i = com.kwad.sdk.core.config.c.c().h5Url;
            }
            if (!TextUtils.isEmpty(this.f66185i)) {
                this.f66178b.loadUrl(this.f66185i);
            }
            this.f66178b.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.reward.b.c.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f66198a;

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
                    this.f66198a = this;
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
                        com.kwad.sdk.core.report.d.c(((com.kwad.sdk.reward.d) this.f66198a).f66342a.f66015f, this.f66198a.f66185i, "1");
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
            com.kwad.sdk.core.webview.a.g gVar = new com.kwad.sdk.core.webview.a.g(this.f66178b);
            this.f66180d = gVar;
            a(gVar);
            this.f66178b.addJavascriptInterface(this.f66180d, "KwaiAd");
        }
    }

    private void p() {
        com.kwad.sdk.core.webview.a.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (gVar = this.f66180d) == null) {
            return;
        }
        gVar.a();
        this.f66180d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || this.f66178b.getVisibility() == 0) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f66342a.f66018i.g();
        for (com.kwad.sdk.reward.a.e eVar : ((com.kwad.sdk.reward.d) this).f66342a.o) {
            eVar.a();
        }
        this.f66178b.setAlpha(1.0f);
        this.f66178b.setScaleX(0.0f);
        this.f66178b.setScaleY(0.0f);
        this.f66178b.setVisibility(0);
        this.k.c();
        this.f66178b.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.c.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66190a;

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
                this.f66190a = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f66190a.f66178b.setVisibility(0);
                    this.f66190a.k.d();
                }
            }
        }).start();
        this.f66178b.setVisibility(0);
        this.f66184h.setVisibility(0);
        this.f66184h.setAlpha(0.0f);
        this.f66184h.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66191a;

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
                this.f66191a = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    super.onAnimationCancel(animator);
                    this.f66191a.f66184h.setAlpha(1.0f);
                    this.f66191a.f66184h.setVisibility(0);
                }
            }
        }).setDuration(300L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65561, this) == null) && this.f66178b.getVisibility() == 0) {
            for (com.kwad.sdk.reward.a.e eVar : ((com.kwad.sdk.reward.d) this).f66342a.o) {
                eVar.b();
            }
            this.k.e();
            this.f66178b.setVisibility(0);
            this.f66178b.setScaleX(1.0f);
            this.f66178b.setScaleY(1.0f);
            this.f66178b.animate().scaleX(0.5f).scaleY(0.5f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f66192a;

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
                    this.f66192a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f66192a.k.f();
                        this.f66192a.f66178b.setVisibility(8);
                    }
                }
            }).start();
            this.f66184h.animate().alpha(0.0f).setDuration(300L).setListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f66193a;

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
                    this.f66193a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f66193a.f66184h.setVisibility(8);
                    }
                }
            }).start();
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            this.f66178b.animate().cancel();
            this.f66178b.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.l = SystemClock.elapsedRealtime();
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66342a;
            this.f66179c = aVar.j;
            aVar.f66018i.a(this.m);
            f();
            ay.b(this.f66178b);
            n();
            this.f66183g.setOnClickListener(new View.OnClickListener(this, com.kwad.sdk.core.response.b.c.i(((com.kwad.sdk.reward.d) this).f66342a.f66015f)) { // from class: com.kwad.sdk.reward.b.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f66186a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f66187b;

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
                    this.f66187b = this;
                    this.f66186a = r7;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!com.kwad.sdk.core.response.b.a.v(this.f66186a)) {
                            AdWebViewActivityProxy.launch(this.f66187b.m(), ((com.kwad.sdk.reward.d) this.f66187b).f66342a.f66015f);
                        } else if (TextUtils.isEmpty(this.f66187b.f66185i) || SystemClock.elapsedRealtime() - this.f66187b.l <= 1500) {
                        } else {
                            this.f66187b.q();
                        }
                    }
                }
            });
            this.f66184h.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.reward.b.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f66194a;

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
                    this.f66194a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f66194a.r();
                        ((com.kwad.sdk.reward.d) this.f66194a).f66342a.f66018i.f();
                    }
                }
            });
            ((com.kwad.sdk.reward.d) this).f66342a.f66010a.add(new com.kwad.sdk.reward.a.a(this) { // from class: com.kwad.sdk.reward.b.c.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f66195a;

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
                    this.f66195a = this;
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
                        this.f66195a.r();
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
            this.f66178b = (KsAdWebView) a(R.id.ksad_mini_web_card_webView);
            this.j = (RatioFrameLayout) a(R.id.ksad_mini_web_card_container);
            this.f66184h = (ImageView) a(R.id.ksad_reward_mini_card_close);
            this.f66183g = (DetailVideoView) a(R.id.ksad_video_player);
            this.j.setVisibility(0);
            this.j.setRatio(1.0f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((com.kwad.sdk.reward.d) this).f66342a.f66018i.b(this.m);
            s();
            e();
        }
    }
}
