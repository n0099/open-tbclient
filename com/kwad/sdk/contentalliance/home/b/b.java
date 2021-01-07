package com.kwad.sdk.contentalliance.home.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.contentalliance.home.e implements ap.a {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f8970b;
    private AnimatorSet c;
    private ap d;
    private View e;
    private View f;
    private View g;
    private TextView h;
    private TextView i;
    private ImageView j;
    private ViewStub k;
    private int l;
    private HandlerThread m;

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(final AdTemplate adTemplate, final boolean z) {
        if (adTemplate == null || !com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            return;
        }
        if (this.e == null) {
            this.e = this.k.inflate();
        }
        this.f = this.e.findViewById(R.id.ksad_home_banner_close_btn);
        this.h = (TextView) this.e.findViewById(R.id.ksad_home_banner_ad_content);
        this.i = (TextView) this.e.findViewById(R.id.ksad_home_banner_ad_link_btn);
        this.g = this.e.findViewById(R.id.ksad_home_banner_ad_link_btn_layout);
        this.j = (ImageView) this.e.findViewById(R.id.ksad_home_banner_ad_img);
        com.kwad.sdk.glide.c.b(o()).a(com.kwad.sdk.core.response.b.c.q(adTemplate)).a(com.kwad.sdk.glide.load.engine.h.f10516a).a((com.kwad.sdk.glide.load.h<Bitmap>) new com.kwad.sdk.contentalliance.widget.a(o(), ao.a(o(), 4.0f), 0, 1, Color.parseColor("#eaeaea"), 15)).a(this.j);
        this.h.setText(String.format(o().getString(z ? R.string.ksad_home_banner_installed_format : R.string.ksad_home_banner_uninstalled_format), com.kwad.sdk.core.response.b.a.q(com.kwad.sdk.core.response.b.c.j(adTemplate))));
        this.i.setText(z ? "立即体验" : "安装");
        this.e.setTranslationY(this.l);
        this.f8970b = new com.kwad.sdk.core.download.b.b(adTemplate);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.home.b.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (z) {
                    if (b.this.f8970b != null) {
                        b.this.f8970b.d();
                    }
                    com.kwad.sdk.core.report.b.c(adTemplate, 47);
                } else {
                    if (b.this.f8970b != null) {
                        b.this.f8970b.e();
                    }
                    com.kwad.sdk.core.report.b.c(adTemplate, 45);
                }
                b.this.e();
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.home.b.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kwad.sdk.core.report.b.c(adTemplate, z ? 48 : 46);
                b.this.e();
            }
        });
        a(true);
        com.kwad.sdk.core.report.b.d(adTemplate, z ? 93 : 92, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void e() {
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.m = new HandlerThread("HomeAdBannerPresenter");
        this.m.start();
        this.d = new ap(this, this.m.getLooper());
        this.d.sendEmptyMessageDelayed(6666, c.a.ad.f());
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        if (message.what != 6666) {
            if (message.what == 8888) {
                ak.a(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.b.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.e();
                    }
                });
                com.kwad.sdk.core.d.a.a("HomeAdBannerPresenter", "handleMsg MSG_BANNER_SHOW_DURATION hideBanner");
            }
        } else if (com.kwad.sdk.home.download.a.a().e()) {
        } else {
            com.kwad.sdk.core.d.a.a("HomeAdBannerPresenter", "handleMsg MSG_CHECK_DELAY");
            final AdTemplate b2 = com.kwad.sdk.home.download.a.a().b();
            if (b2 != null) {
                ak.a(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.b.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a(b2, false);
                    }
                });
                com.kwad.sdk.core.d.a.a("HomeAdBannerPresenter", "handleMsg MSG_CHECK_DELAY downloadData not null, showBanner");
                com.kwad.sdk.home.download.a.a().a(com.kwad.sdk.core.response.b.a.s(com.kwad.sdk.core.response.b.c.j(b2)));
                this.d.sendEmptyMessageDelayed(8888, c.a.ad.g());
                return;
            }
            final AdTemplate c = com.kwad.sdk.home.download.a.a().c();
            if (c != null) {
                ak.a(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.b.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a(c, true);
                    }
                });
                com.kwad.sdk.core.d.a.a("HomeAdBannerPresenter", "handleMsg MSG_CHECK_DELAY installedData not null, showBanner");
                com.kwad.sdk.home.download.a.a().a(com.kwad.sdk.core.response.b.a.s(com.kwad.sdk.core.response.b.c.j(c)));
                this.d.sendEmptyMessageDelayed(8888, c.a.ad.g());
            }
        }
    }

    public void a(final boolean z) {
        if (this.c != null && this.c.isRunning()) {
            this.c.removeAllListeners();
            this.c.cancel();
        }
        this.c = new AnimatorSet();
        com.kwad.sdk.core.d.a.a("HomeAdBannerPresenter", "bottomViewAnimate + isShow : " + z);
        View view = this.e;
        String name = View.TRANSLATION_Y.getName();
        float[] fArr = new float[1];
        fArr[0] = z ? 0.0f : this.l;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, name, fArr);
        ofFloat.setDuration(z ? 300L : 260L);
        this.c.playTogether(ofFloat);
        this.c.removeAllListeners();
        this.c.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.home.b.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                b.this.e.setVisibility(z ? 4 : 0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (z) {
                    return;
                }
                b.this.e.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator) {
                super.onAnimationPause(animator);
                b.this.e.setVisibility(z ? 4 : 0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z) {
                    b.this.e.setVisibility(0);
                }
            }
        });
        this.c.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.d.removeCallbacksAndMessages(null);
        if (this.f8970b != null) {
            this.f8970b.f();
        }
        com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.home.download.a.a().d();
            }
        });
        this.m.quit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.k = (ViewStub) b(R.id.ksad_home_banner_layout_vs);
        this.l = -ao.a(o(), 100.0f);
    }
}
