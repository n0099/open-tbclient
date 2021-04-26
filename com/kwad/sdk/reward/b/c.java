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
    public KsAdWebView f34484b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34485c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f34486d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f34487e;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f34489g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34490h;

    /* renamed from: i  reason: collision with root package name */
    public String f34491i;
    public RatioFrameLayout j;
    public m k;
    public long l;

    /* renamed from: f  reason: collision with root package name */
    public int f34488f = -1;
    public com.kwad.sdk.contentalliance.detail.video.d m = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.c.7
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            c.this.e();
        }
    };
    public a.b n = new a.b() { // from class: com.kwad.sdk.reward.b.c.8
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(@Nullable a.C0386a c0386a) {
            if (((com.kwad.sdk.reward.d) c.this).f34594a.f34317b != null) {
                ((com.kwad.sdk.reward.d) c.this).f34594a.f34317b.a();
            }
        }
    };
    public i.b o = new i.b() { // from class: com.kwad.sdk.reward.b.c.10
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            c.this.f34484b.setTranslationY(aVar.f33707a + aVar.f33710d);
        }
    };
    public k.b p = new k.b() { // from class: com.kwad.sdk.reward.b.c.11
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
            c.this.f34488f = i2;
            com.kwad.sdk.core.d.a.c("RewardMiniCardPresenter", "updatePageStatus mPageState: " + i2);
            if (c.this.f34488f == -1) {
                com.kwad.sdk.core.report.e.c(((com.kwad.sdk.reward.d) c.this).f34594a.f34321f, c.this.f34491i, "3");
            }
        }
    };

    private void a(com.kwad.sdk.core.webview.a.g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f34487e, this.f34485c, this.n));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f34487e));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f34487e));
        gVar.a(new i(this.f34487e, this.o));
        gVar.a(new k(this.p));
        m mVar = new m();
        this.k = mVar;
        gVar.a(mVar);
        gVar.a(new n(this.f34487e, this.f34485c));
        gVar.a(new j(this.f34487e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f34488f = -1;
        this.f34484b.setVisibility(8);
        p();
    }

    private void m() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f34487e = aVar;
        com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f34594a;
        aVar.f33622b = aVar2.f34321f;
        aVar.f33621a = 0;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f34323h;
        aVar.f33623c = adBaseFrameLayout;
        aVar.f33625e = adBaseFrameLayout;
        aVar.f33626f = this.f34484b;
    }

    private void n() {
        this.f34488f = -1;
        o();
        this.f34484b.setBackgroundColor(0);
        this.f34484b.setVisibility(4);
        if (l() != null) {
            File e2 = com.kwad.sdk.core.config.c.e(l());
            if (e2.exists() && e2.length() > 0) {
                this.f34491i = Uri.fromFile(e2).toString();
            }
        }
        if (this.f34491i == null) {
            this.f34491i = com.kwad.sdk.core.config.c.c().h5Url;
        }
        if (!TextUtils.isEmpty(this.f34491i)) {
            this.f34484b.loadUrl(this.f34491i);
        }
        this.f34484b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.reward.b.c.9
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
                com.kwad.sdk.core.report.e.c(((com.kwad.sdk.reward.d) c.this).f34594a.f34321f, c.this.f34491i, "1");
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        p();
        com.kwad.sdk.core.webview.a.g gVar = new com.kwad.sdk.core.webview.a.g(this.f34484b);
        this.f34486d = gVar;
        a(gVar);
        this.f34484b.addJavascriptInterface(this.f34486d, "KwaiAd");
    }

    private void p() {
        com.kwad.sdk.core.webview.a.g gVar = this.f34486d;
        if (gVar != null) {
            gVar.a();
            this.f34486d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f34484b.getVisibility() == 0) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.f();
        for (com.kwad.sdk.reward.a.e eVar : ((com.kwad.sdk.reward.d) this).f34594a.o) {
            eVar.a();
        }
        this.f34484b.setAlpha(1.0f);
        this.f34484b.setScaleX(0.0f);
        this.f34484b.setScaleY(0.0f);
        this.f34484b.setVisibility(0);
        this.k.c();
        this.f34484b.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f34484b.setVisibility(0);
                c.this.k.d();
            }
        }).start();
        this.f34484b.setVisibility(0);
        this.f34490h.setVisibility(0);
        this.f34490h.setAlpha(0.0f);
        this.f34490h.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                c.this.f34490h.setAlpha(1.0f);
                c.this.f34490h.setVisibility(0);
            }
        }).setDuration(300L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.f34484b.getVisibility() != 0) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.e();
        for (com.kwad.sdk.reward.a.e eVar : ((com.kwad.sdk.reward.d) this).f34594a.o) {
            eVar.b();
        }
        this.k.e();
        this.f34484b.setVisibility(0);
        this.f34484b.setScaleX(1.0f);
        this.f34484b.setScaleY(1.0f);
        this.f34484b.animate().scaleX(0.5f).scaleY(0.5f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.k.f();
                c.this.f34484b.setVisibility(8);
            }
        }).start();
        this.f34490h.animate().alpha(0.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f34490h.setVisibility(8);
            }
        }).start();
    }

    private void s() {
        this.f34484b.animate().cancel();
        this.f34484b.setVisibility(8);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a() {
        super.a();
        this.l = SystemClock.elapsedRealtime();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f34594a;
        this.f34485c = aVar.j;
        aVar.f34324i.a(this.m);
        m();
        aq.b(this.f34484b);
        n();
        final AdInfo g2 = com.kwad.sdk.core.response.b.c.g(((com.kwad.sdk.reward.d) this).f34594a.f34321f);
        this.f34489g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.kwad.sdk.core.response.b.a.v(g2)) {
                    AdWebViewActivityProxy.launch(c.this.l(), ((com.kwad.sdk.reward.d) c.this).f34594a.f34321f);
                } else if (TextUtils.isEmpty(c.this.f34491i) || SystemClock.elapsedRealtime() - c.this.l <= 1500) {
                } else {
                    c.this.q();
                }
            }
        });
        this.f34490h.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.b.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.r();
            }
        });
        ((com.kwad.sdk.reward.d) this).f34594a.f34316a.add(new com.kwad.sdk.reward.a.a() { // from class: com.kwad.sdk.reward.b.c.6
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
        this.f34484b = (KsAdWebView) a(R.id.ksad_mini_web_card_webView);
        this.j = (RatioFrameLayout) a(R.id.ksad_mini_web_card_container);
        this.f34490h = (ImageView) a(R.id.ksad_reward_mini_card_close);
        this.f34489g = (DetailVideoView) a(R.id.ksad_video_player);
        this.j.setVisibility(0);
        this.j.setRatio(1.0f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.reward.d) this).f34594a.f34324i.b(this.m);
        s();
        e();
    }
}
