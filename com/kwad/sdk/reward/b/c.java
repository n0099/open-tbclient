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
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.reward.d {

    /* renamed from: b  reason: collision with root package name */
    private KsAdWebView f10903b;
    private com.kwad.sdk.core.download.b.b c;
    private g d;
    private com.kwad.sdk.core.webview.a e;
    private DetailVideoView g;
    private ImageView h;
    private String i;
    private RatioFrameLayout j;
    private n k;
    private long l;
    private int f = -1;
    private com.kwad.sdk.contentalliance.detail.video.e m = new f() { // from class: com.kwad.sdk.reward.b.c.7
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            c.this.e();
        }
    };
    private a.b n = new a.b() { // from class: com.kwad.sdk.reward.b.c.8
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            if (c.this.f10950a.f10825b != null) {
                c.this.f10950a.f10825b.a();
            }
        }
    };
    private i.b o = new i.b() { // from class: com.kwad.sdk.reward.b.c.10
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            c.this.f10903b.setTranslationY(aVar.f9885a + aVar.d);
        }
    };
    private k.b p = new k.b() { // from class: com.kwad.sdk.reward.b.c.11
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
            c.this.f = i;
            com.kwad.sdk.core.d.a.b("RewardMiniCardPresenter", "updatePageStatus mPageState: " + i);
            if (c.this.f == -1) {
                com.kwad.sdk.core.report.e.e(c.this.f10950a.f, c.this.i, "3");
            }
        }
    };

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.e, this.c, this.n));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.e));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.e));
        gVar.a(new i(this.e, this.o));
        gVar.a(new k(this.p));
        this.k = new n();
        gVar.a(this.k);
        gVar.a(new o(this.e, this.c));
        gVar.a(new j(this.e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f = -1;
        this.f10903b.setVisibility(8);
        p();
    }

    private void f() {
        this.e = new com.kwad.sdk.core.webview.a();
        this.e.f9837b = this.f10950a.f;
        this.e.f9836a = 0;
        this.e.c = this.f10950a.h;
        this.e.e = this.f10950a.h;
        this.e.f = this.f10903b;
    }

    private void g() {
        this.f = -1;
        h();
        this.f10903b.setBackgroundColor(0);
        this.f10903b.setVisibility(4);
        if (o() != null) {
            File e = com.kwad.sdk.core.config.c.e(o());
            if (e.exists() && e.length() > 0) {
                this.i = Uri.fromFile(e).toString();
            }
        }
        if (this.i == null) {
            this.i = com.kwad.sdk.core.config.c.c().h5Url;
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.f10903b.loadUrl(this.i);
        }
        this.f10903b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.reward.b.c.9
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str, String str2) {
                com.kwad.sdk.core.report.e.e(c.this.f10950a.f, c.this.i, "1");
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        this.d = new g(this.f10903b);
        a(this.d);
        this.f10903b.addJavascriptInterface(this.d, "KwaiAd");
    }

    private void p() {
        if (this.d != null) {
            this.d.a();
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f10903b.getVisibility() == 0) {
            return;
        }
        this.f10950a.i.f();
        for (com.kwad.sdk.reward.a.d dVar : this.f10950a.o) {
            dVar.a();
        }
        this.f10903b.setAlpha(1.0f);
        this.f10903b.setScaleX(0.0f);
        this.f10903b.setScaleY(0.0f);
        this.f10903b.setVisibility(0);
        this.k.c();
        this.f10903b.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f10903b.setVisibility(0);
                c.this.k.d();
            }
        }).start();
        this.f10903b.setVisibility(0);
        this.h.setVisibility(0);
        this.h.setAlpha(0.0f);
        this.h.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                c.this.h.setAlpha(1.0f);
                c.this.h.setVisibility(0);
            }
        }).setDuration(300L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.f10903b.getVisibility() != 0) {
            return;
        }
        this.f10950a.i.e();
        for (com.kwad.sdk.reward.a.d dVar : this.f10950a.o) {
            dVar.b();
        }
        this.k.e();
        this.f10903b.setVisibility(0);
        this.f10903b.setScaleX(1.0f);
        this.f10903b.setScaleY(1.0f);
        this.f10903b.animate().scaleX(0.5f).scaleY(0.5f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.k.f();
                c.this.f10903b.setVisibility(8);
            }
        }).start();
        this.h.animate().alpha(0.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.h.setVisibility(8);
            }
        }).start();
    }

    private void s() {
        this.f10903b.animate().cancel();
        this.f10903b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a() {
        super.a();
        this.l = SystemClock.elapsedRealtime();
        this.c = this.f10950a.j;
        this.f10950a.i.a(this.m);
        f();
        ar.b(this.f10903b);
        g();
        final AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f10950a.f);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.kwad.sdk.core.response.b.a.y(j)) {
                    AdWebViewActivityProxy.launch(c.this.o(), c.this.f10950a.f);
                } else if (TextUtils.isEmpty(c.this.i) || SystemClock.elapsedRealtime() - c.this.l <= 1500) {
                } else {
                    c.this.q();
                }
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.b.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.r();
            }
        });
        this.f10950a.f10824a.add(new com.kwad.sdk.reward.a.a() { // from class: com.kwad.sdk.reward.b.c.6
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f10950a.i.b(this.m);
        s();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f10903b = (KsAdWebView) b(R.id.ksad_mini_web_card_webView);
        this.j = (RatioFrameLayout) b(R.id.ksad_mini_web_card_container);
        this.h = (ImageView) b(R.id.ksad_reward_mini_card_close);
        this.g = (DetailVideoView) b(R.id.ksad_video_player);
        this.j.setVisibility(0);
        this.j.setRatio(1.0f);
    }
}
