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
    public KsAdWebView f73778b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f73779c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f73780d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f73781e;

    /* renamed from: f  reason: collision with root package name */
    public int f73782f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f73783g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f73784h;

    /* renamed from: i  reason: collision with root package name */
    public String f73785i;

    /* renamed from: j  reason: collision with root package name */
    public RatioFrameLayout f73786j;
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
        this.f73782f = -1;
        this.m = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.reward.b.c.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73797a;

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
                this.f73797a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.f();
                    this.f73797a.e();
                }
            }
        };
        this.n = new a.b(this) { // from class: com.kwad.sdk.reward.b.c.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73798a;

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
                this.f73798a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(@Nullable a.C2006a c2006a) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c2006a) == null) || ((com.kwad.sdk.reward.d) this.f73798a).f73944a.f73603b == null) {
                    return;
                }
                ((com.kwad.sdk.reward.d) this.f73798a).f73944a.f73603b.a();
            }
        };
        this.o = new i.b(this) { // from class: com.kwad.sdk.reward.b.c.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73789a;

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
                this.f73789a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.f73789a.f73778b.setTranslationY(aVar.f72894a + aVar.f72897d);
                }
            }
        };
        this.p = new m.b(this) { // from class: com.kwad.sdk.reward.b.c.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73790a;

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
                this.f73790a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.m.b
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f73790a.f73782f = i4;
                    com.kwad.sdk.core.d.a.c("RewardMiniCardPresenter", "updatePageStatus mPageState: " + i4);
                    if (this.f73790a.f73782f == -1) {
                        com.kwad.sdk.core.report.d.c(((com.kwad.sdk.reward.d) this.f73790a).f73944a.f73607f, this.f73790a.f73785i, "3");
                    }
                }
            }
        };
    }

    private void a(com.kwad.sdk.core.webview.a.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, gVar) == null) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f73781e, this.f73779c, this.n));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f73781e));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f73781e));
            gVar.a(new i(this.f73781e, this.o));
            gVar.a(new m(this.p));
            p pVar = new p();
            this.k = pVar;
            gVar.a(pVar);
            gVar.a(new q(this.f73781e, this.f73779c));
            gVar.a(new j(this.f73781e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f73782f = -1;
            this.f73778b.setVisibility(8);
            p();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f73781e = aVar;
            com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f73944a;
            aVar.f72777b = aVar2.f73607f;
            aVar.f72776a = 0;
            AdBaseFrameLayout adBaseFrameLayout = aVar2.f73609h;
            aVar.f72778c = adBaseFrameLayout;
            aVar.f72780e = adBaseFrameLayout;
            aVar.f72781f = this.f73778b;
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.f73782f = -1;
            o();
            this.f73778b.setBackgroundColor(0);
            this.f73778b.setVisibility(4);
            if (m() != null) {
                File g2 = com.kwad.sdk.core.config.c.g(m());
                if (g2.exists() && g2.length() > 0) {
                    this.f73785i = Uri.fromFile(g2).toString();
                }
            }
            if (this.f73785i == null) {
                this.f73785i = com.kwad.sdk.core.config.c.c().h5Url;
            }
            if (!TextUtils.isEmpty(this.f73785i)) {
                this.f73778b.loadUrl(this.f73785i);
            }
            this.f73778b.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.reward.b.c.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73799a;

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
                    this.f73799a = this;
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
                        com.kwad.sdk.core.report.d.c(((com.kwad.sdk.reward.d) this.f73799a).f73944a.f73607f, this.f73799a.f73785i, "1");
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
            com.kwad.sdk.core.webview.a.g gVar = new com.kwad.sdk.core.webview.a.g(this.f73778b);
            this.f73780d = gVar;
            a(gVar);
            this.f73778b.addJavascriptInterface(this.f73780d, "KwaiAd");
        }
    }

    private void p() {
        com.kwad.sdk.core.webview.a.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (gVar = this.f73780d) == null) {
            return;
        }
        gVar.a();
        this.f73780d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || this.f73778b.getVisibility() == 0) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f73944a.f73610i.g();
        for (com.kwad.sdk.reward.a.e eVar : ((com.kwad.sdk.reward.d) this).f73944a.o) {
            eVar.a();
        }
        this.f73778b.setAlpha(1.0f);
        this.f73778b.setScaleX(0.0f);
        this.f73778b.setScaleY(0.0f);
        this.f73778b.setVisibility(0);
        this.k.c();
        this.f73778b.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.c.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73791a;

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
                this.f73791a = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f73791a.f73778b.setVisibility(0);
                    this.f73791a.k.d();
                }
            }
        }).start();
        this.f73778b.setVisibility(0);
        this.f73784h.setVisibility(0);
        this.f73784h.setAlpha(0.0f);
        this.f73784h.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73792a;

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
                this.f73792a = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    super.onAnimationCancel(animator);
                    this.f73792a.f73784h.setAlpha(1.0f);
                    this.f73792a.f73784h.setVisibility(0);
                }
            }
        }).setDuration(300L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65561, this) == null) && this.f73778b.getVisibility() == 0) {
            for (com.kwad.sdk.reward.a.e eVar : ((com.kwad.sdk.reward.d) this).f73944a.o) {
                eVar.b();
            }
            this.k.e();
            this.f73778b.setVisibility(0);
            this.f73778b.setScaleX(1.0f);
            this.f73778b.setScaleY(1.0f);
            this.f73778b.animate().scaleX(0.5f).scaleY(0.5f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73793a;

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
                    this.f73793a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f73793a.k.f();
                        this.f73793a.f73778b.setVisibility(8);
                    }
                }
            }).start();
            this.f73784h.animate().alpha(0.0f).setDuration(300L).setListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.reward.b.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73794a;

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
                    this.f73794a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f73794a.f73784h.setVisibility(8);
                    }
                }
            }).start();
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            this.f73778b.animate().cancel();
            this.f73778b.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.l = SystemClock.elapsedRealtime();
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f73944a;
            this.f73779c = aVar.f73611j;
            aVar.f73610i.a(this.m);
            f();
            ay.b(this.f73778b);
            n();
            this.f73783g.setOnClickListener(new View.OnClickListener(this, com.kwad.sdk.core.response.b.c.i(((com.kwad.sdk.reward.d) this).f73944a.f73607f)) { // from class: com.kwad.sdk.reward.b.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f73787a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f73788b;

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
                    this.f73788b = this;
                    this.f73787a = r7;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!com.kwad.sdk.core.response.b.a.v(this.f73787a)) {
                            AdWebViewActivityProxy.launch(this.f73788b.m(), ((com.kwad.sdk.reward.d) this.f73788b).f73944a.f73607f);
                        } else if (TextUtils.isEmpty(this.f73788b.f73785i) || SystemClock.elapsedRealtime() - this.f73788b.l <= 1500) {
                        } else {
                            this.f73788b.q();
                        }
                    }
                }
            });
            this.f73784h.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.reward.b.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73795a;

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
                    this.f73795a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f73795a.r();
                        ((com.kwad.sdk.reward.d) this.f73795a).f73944a.f73610i.f();
                    }
                }
            });
            ((com.kwad.sdk.reward.d) this).f73944a.f73602a.add(new com.kwad.sdk.reward.a.a(this) { // from class: com.kwad.sdk.reward.b.c.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73796a;

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
                    this.f73796a = this;
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
                        this.f73796a.r();
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
            this.f73778b = (KsAdWebView) a(R.id.ksad_mini_web_card_webView);
            this.f73786j = (RatioFrameLayout) a(R.id.ksad_mini_web_card_container);
            this.f73784h = (ImageView) a(R.id.ksad_reward_mini_card_close);
            this.f73783g = (DetailVideoView) a(R.id.ksad_video_player);
            this.f73786j.setVisibility(0);
            this.f73786j.setRatio(1.0f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((com.kwad.sdk.reward.d) this).f73944a.f73610i.b(this.m);
            s();
            e();
        }
    }
}
