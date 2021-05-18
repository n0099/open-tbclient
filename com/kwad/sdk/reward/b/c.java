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
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.aq;
import java.io.File;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.reward.d {

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f33729b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33730c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f33731d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f33732e;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f33734g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f33735h;

    /* renamed from: i  reason: collision with root package name */
    public String f33736i;
    public RatioFrameLayout j;
    public m k;
    public long l;

    /* renamed from: f  reason: collision with root package name */
    public int f33733f = -1;
    public com.kwad.sdk.contentalliance.detail.video.d m = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.c.7
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            c.this.e();
        }
    };
    public a.b n = new a.b() { // from class: com.kwad.sdk.reward.b.c.8
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(@Nullable a.C0373a c0373a) {
            if (((com.kwad.sdk.reward.d) c.this).f33839a.f33562b != null) {
                ((com.kwad.sdk.reward.d) c.this).f33839a.f33562b.a();
            }
        }
    };
    public i.b o = new i.b() { // from class: com.kwad.sdk.reward.b.c.10
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            c.this.f33729b.setTranslationY(aVar.f32952a + aVar.f32955d);
        }
    };
    public k.b p = new k.b() { // from class: com.kwad.sdk.reward.b.c.11
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
            c.this.f33733f = i2;
            com.kwad.sdk.core.d.a.c("RewardMiniCardPresenter", "updatePageStatus mPageState: " + i2);
            if (c.this.f33733f == -1) {
                com.kwad.sdk.core.report.e.c(((com.kwad.sdk.reward.d) c.this).f33839a.f33566f, c.this.f33736i, "3");
            }
        }
    };

    private void a(com.kwad.sdk.core.webview.a.g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f33732e, this.f33730c, this.n));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f33732e));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f33732e));
        gVar.a(new i(this.f33732e, this.o));
        gVar.a(new k(this.p));
        m mVar = new m();
        this.k = mVar;
        gVar.a(mVar);
        gVar.a(new n(this.f33732e, this.f33730c));
        gVar.a(new j(this.f33732e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f33733f = -1;
        this.f33729b.setVisibility(8);
        p();
    }

    private void m() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f33732e = aVar;
        com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f33839a;
        aVar.f32867b = aVar2.f33566f;
        aVar.f32866a = 0;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f33568h;
        aVar.f32868c = adBaseFrameLayout;
        aVar.f32870e = adBaseFrameLayout;
        aVar.f32871f = this.f33729b;
    }

    private void n() {
        this.f33733f = -1;
        o();
        this.f33729b.setBackgroundColor(0);
        this.f33729b.setVisibility(4);
        if (l() != null) {
            File e2 = com.kwad.sdk.core.config.c.e(l());
            if (e2.exists() && e2.length() > 0) {
                this.f33736i = Uri.fromFile(e2).toString();
            }
        }
        if (this.f33736i == null) {
            this.f33736i = com.kwad.sdk.core.config.c.c().h5Url;
        }
        if (!TextUtils.isEmpty(this.f33736i)) {
            this.f33729b.loadUrl(this.f33736i);
        }
        this.f33729b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.reward.b.c.9
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
                com.kwad.sdk.core.report.e.c(((com.kwad.sdk.reward.d) c.this).f33839a.f33566f, c.this.f33736i, "1");
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        p();
        com.kwad.sdk.core.webview.a.g gVar = new com.kwad.sdk.core.webview.a.g(this.f33729b);
        this.f33731d = gVar;
        a(gVar);
        this.f33729b.addJavascriptInterface(this.f33731d, "KwaiAd");
    }

    private void p() {
        com.kwad.sdk.core.webview.a.g gVar = this.f33731d;
        if (gVar != null) {
            gVar.a();
            this.f33731d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f33729b.getVisibility() == 0) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.f();
        for (com.kwad.sdk.reward.a.e eVar : ((com.kwad.sdk.reward.d) this).f33839a.o) {
            eVar.a();
        }
        this.f33729b.setAlpha(1.0f);
        this.f33729b.setScaleX(0.0f);
        this.f33729b.setScaleY(0.0f);
        this.f33729b.setVisibility(0);
        this.k.c();
        this.f33729b.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f33729b.setVisibility(0);
                c.this.k.d();
            }
        }).start();
        this.f33729b.setVisibility(0);
        this.f33735h.setVisibility(0);
        this.f33735h.setAlpha(0.0f);
        this.f33735h.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                c.this.f33735h.setAlpha(1.0f);
                c.this.f33735h.setVisibility(0);
            }
        }).setDuration(300L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.f33729b.getVisibility() != 0) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.e();
        for (com.kwad.sdk.reward.a.e eVar : ((com.kwad.sdk.reward.d) this).f33839a.o) {
            eVar.b();
        }
        this.k.e();
        this.f33729b.setVisibility(0);
        this.f33729b.setScaleX(1.0f);
        this.f33729b.setScaleY(1.0f);
        this.f33729b.animate().scaleX(0.5f).scaleY(0.5f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.k.f();
                c.this.f33729b.setVisibility(8);
            }
        }).start();
        this.f33735h.animate().alpha(0.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f33735h.setVisibility(8);
            }
        }).start();
    }

    private void s() {
        this.f33729b.animate().cancel();
        this.f33729b.setVisibility(8);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a() {
        super.a();
        this.l = SystemClock.elapsedRealtime();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33839a;
        this.f33730c = aVar.j;
        aVar.f33569i.a(this.m);
        m();
        aq.b(this.f33729b);
        n();
        final AdInfo g2 = com.kwad.sdk.core.response.b.c.g(((com.kwad.sdk.reward.d) this).f33839a.f33566f);
        this.f33734g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.kwad.sdk.core.response.b.a.v(g2)) {
                    AdWebViewActivityProxy.launch(c.this.l(), ((com.kwad.sdk.reward.d) c.this).f33839a.f33566f);
                } else if (TextUtils.isEmpty(c.this.f33736i) || SystemClock.elapsedRealtime() - c.this.l <= 1500) {
                } else {
                    c.this.q();
                }
            }
        });
        this.f33735h.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.b.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.r();
            }
        });
        ((com.kwad.sdk.reward.d) this).f33839a.f33561a.add(new com.kwad.sdk.reward.a.a() { // from class: com.kwad.sdk.reward.b.c.6
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
    public void b() {
        super.b();
        this.f33729b = (KsAdWebView) a(R.id.ksad_mini_web_card_webView);
        this.j = (RatioFrameLayout) a(R.id.ksad_mini_web_card_container);
        this.f33735h = (ImageView) a(R.id.ksad_reward_mini_card_close);
        this.f33734g = (DetailVideoView) a(R.id.ksad_video_player);
        this.j.setVisibility(0);
        this.j.setRatio(1.0f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f33839a.f33569i.b(this.m);
        s();
        e();
    }
}
