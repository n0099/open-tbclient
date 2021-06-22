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
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ar;
import java.io.File;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.reward.d {

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f37210b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37211c;

    /* renamed from: d  reason: collision with root package name */
    public g f37212d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f37213e;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f37215g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f37216h;

    /* renamed from: i  reason: collision with root package name */
    public String f37217i;
    public RatioFrameLayout j;
    public n k;
    public long l;

    /* renamed from: f  reason: collision with root package name */
    public int f37214f = -1;
    public com.kwad.sdk.contentalliance.detail.video.e m = new f() { // from class: com.kwad.sdk.reward.b.c.7
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            c.this.e();
        }
    };
    public a.b n = new a.b() { // from class: com.kwad.sdk.reward.b.c.8
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            if (((com.kwad.sdk.reward.d) c.this).f37299a.f37049b != null) {
                ((com.kwad.sdk.reward.d) c.this).f37299a.f37049b.a();
            }
        }
    };
    public i.b o = new i.b() { // from class: com.kwad.sdk.reward.b.c.10
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            c.this.f37210b.setTranslationY(aVar.f35105a + aVar.f35108d);
        }
    };
    public k.b p = new k.b() { // from class: com.kwad.sdk.reward.b.c.11
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
            c.this.f37214f = i2;
            com.kwad.sdk.core.d.a.b("RewardMiniCardPresenter", "updatePageStatus mPageState: " + i2);
            if (c.this.f37214f == -1) {
                com.kwad.sdk.core.report.e.e(((com.kwad.sdk.reward.d) c.this).f37299a.f37053f, c.this.f37217i, "3");
            }
        }
    };

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f37213e, this.f37211c, this.n));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f37213e));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f37213e));
        gVar.a(new i(this.f37213e, this.o));
        gVar.a(new k(this.p));
        n nVar = new n();
        this.k = nVar;
        gVar.a(nVar);
        gVar.a(new o(this.f37213e, this.f37211c));
        gVar.a(new j(this.f37213e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f37214f = -1;
        this.f37210b.setVisibility(8);
        p();
    }

    private void f() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f37213e = aVar;
        com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f37299a;
        aVar.f35027b = aVar2.f37053f;
        aVar.f35026a = 0;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f37055h;
        aVar.f35028c = adBaseFrameLayout;
        aVar.f35030e = adBaseFrameLayout;
        aVar.f35031f = this.f37210b;
    }

    private void g() {
        this.f37214f = -1;
        h();
        this.f37210b.setBackgroundColor(0);
        this.f37210b.setVisibility(4);
        if (o() != null) {
            File e2 = com.kwad.sdk.core.config.c.e(o());
            if (e2.exists() && e2.length() > 0) {
                this.f37217i = Uri.fromFile(e2).toString();
            }
        }
        if (this.f37217i == null) {
            this.f37217i = com.kwad.sdk.core.config.c.c().h5Url;
        }
        if (!TextUtils.isEmpty(this.f37217i)) {
            this.f37210b.loadUrl(this.f37217i);
        }
        this.f37210b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.reward.b.c.9
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
                com.kwad.sdk.core.report.e.e(((com.kwad.sdk.reward.d) c.this).f37299a.f37053f, c.this.f37217i, "1");
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        g gVar = new g(this.f37210b);
        this.f37212d = gVar;
        a(gVar);
        this.f37210b.addJavascriptInterface(this.f37212d, "KwaiAd");
    }

    private void p() {
        g gVar = this.f37212d;
        if (gVar != null) {
            gVar.a();
            this.f37212d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f37210b.getVisibility() == 0) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f37299a.f37056i.f();
        for (com.kwad.sdk.reward.a.d dVar : ((com.kwad.sdk.reward.d) this).f37299a.o) {
            dVar.a();
        }
        this.f37210b.setAlpha(1.0f);
        this.f37210b.setScaleX(0.0f);
        this.f37210b.setScaleY(0.0f);
        this.f37210b.setVisibility(0);
        this.k.c();
        this.f37210b.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f37210b.setVisibility(0);
                c.this.k.d();
            }
        }).start();
        this.f37210b.setVisibility(0);
        this.f37216h.setVisibility(0);
        this.f37216h.setAlpha(0.0f);
        this.f37216h.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                c.this.f37216h.setAlpha(1.0f);
                c.this.f37216h.setVisibility(0);
            }
        }).setDuration(300L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.f37210b.getVisibility() != 0) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f37299a.f37056i.e();
        for (com.kwad.sdk.reward.a.d dVar : ((com.kwad.sdk.reward.d) this).f37299a.o) {
            dVar.b();
        }
        this.k.e();
        this.f37210b.setVisibility(0);
        this.f37210b.setScaleX(1.0f);
        this.f37210b.setScaleY(1.0f);
        this.f37210b.animate().scaleX(0.5f).scaleY(0.5f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.k.f();
                c.this.f37210b.setVisibility(8);
            }
        }).start();
        this.f37216h.animate().alpha(0.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f37216h.setVisibility(8);
            }
        }).start();
    }

    private void s() {
        this.f37210b.animate().cancel();
        this.f37210b.setVisibility(8);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a() {
        super.a();
        this.l = SystemClock.elapsedRealtime();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f37299a;
        this.f37211c = aVar.j;
        aVar.f37056i.a(this.m);
        f();
        ar.b(this.f37210b);
        g();
        final AdInfo j = com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.reward.d) this).f37299a.f37053f);
        this.f37215g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.kwad.sdk.core.response.b.a.y(j)) {
                    AdWebViewActivityProxy.launch(c.this.o(), ((com.kwad.sdk.reward.d) c.this).f37299a.f37053f);
                } else if (TextUtils.isEmpty(c.this.f37217i) || SystemClock.elapsedRealtime() - c.this.l <= 1500) {
                } else {
                    c.this.q();
                }
            }
        });
        this.f37216h.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.b.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.r();
            }
        });
        ((com.kwad.sdk.reward.d) this).f37299a.f37048a.add(new com.kwad.sdk.reward.a.a() { // from class: com.kwad.sdk.reward.b.c.6
            @Override // com.kwad.sdk.reward.a.a
            public void a() {
            }

            @Override // com.kwad.sdk.reward.a.a
            public void b() {
            }

            @Override // com.kwad.sdk.reward.a.a
            public void c() {
                c.this.r();
            }

            @Override // com.kwad.sdk.reward.a.a
            public void d() {
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f37299a.f37056i.b(this.m);
        s();
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37210b = (KsAdWebView) b(R.id.ksad_mini_web_card_webView);
        this.j = (RatioFrameLayout) b(R.id.ksad_mini_web_card_container);
        this.f37216h = (ImageView) b(R.id.ksad_reward_mini_card_close);
        this.f37215g = (DetailVideoView) b(R.id.ksad_video_player);
        this.j.setVisibility(0);
        this.j.setRatio(1.0f);
    }
}
