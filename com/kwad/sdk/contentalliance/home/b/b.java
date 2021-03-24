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
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.home.e implements ap.a {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32638b;

    /* renamed from: c  reason: collision with root package name */
    public AnimatorSet f32639c;

    /* renamed from: d  reason: collision with root package name */
    public ap f32640d;

    /* renamed from: e  reason: collision with root package name */
    public View f32641e;

    /* renamed from: f  reason: collision with root package name */
    public View f32642f;

    /* renamed from: g  reason: collision with root package name */
    public View f32643g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f32644h;
    public TextView i;
    public ImageView j;
    public ViewStub k;
    public int l;
    public HandlerThread m;

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(final AdTemplate adTemplate, final boolean z) {
        if (adTemplate == null || !com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            return;
        }
        if (this.f32641e == null) {
            this.f32641e = this.k.inflate();
        }
        this.f32642f = this.f32641e.findViewById(R.id.ksad_home_banner_close_btn);
        this.f32644h = (TextView) this.f32641e.findViewById(R.id.ksad_home_banner_ad_content);
        this.i = (TextView) this.f32641e.findViewById(R.id.ksad_home_banner_ad_link_btn);
        this.f32643g = this.f32641e.findViewById(R.id.ksad_home_banner_ad_link_btn_layout);
        this.j = (ImageView) this.f32641e.findViewById(R.id.ksad_home_banner_ad_img);
        com.kwad.sdk.glide.c.b(o()).a(com.kwad.sdk.core.response.b.c.q(adTemplate)).a(com.kwad.sdk.glide.load.engine.h.f35535a).a((com.kwad.sdk.glide.load.h<Bitmap>) new com.kwad.sdk.contentalliance.widget.a(o(), ao.a(o(), 4.0f), 0, 1, Color.parseColor("#eaeaea"), 15)).a(this.j);
        this.f32644h.setText(String.format(o().getString(z ? R.string.ksad_home_banner_installed_format : R.string.ksad_home_banner_uninstalled_format), com.kwad.sdk.core.response.b.a.q(com.kwad.sdk.core.response.b.c.j(adTemplate))));
        this.i.setText(z ? "立即体验" : "安装");
        this.f32641e.setTranslationY(this.l);
        this.f32638b = new com.kwad.sdk.core.download.b.b(adTemplate);
        this.f32643g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.home.b.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdTemplate adTemplate2;
                int i;
                if (z) {
                    com.kwad.sdk.core.download.b.b bVar = b.this.f32638b;
                    if (bVar != null) {
                        bVar.d();
                    }
                    adTemplate2 = adTemplate;
                    i = 47;
                } else {
                    com.kwad.sdk.core.download.b.b bVar2 = b.this.f32638b;
                    if (bVar2 != null) {
                        bVar2.e();
                    }
                    adTemplate2 = adTemplate;
                    i = 45;
                }
                com.kwad.sdk.core.report.b.c(adTemplate2, i);
                b.this.e();
            }
        });
        this.f32642f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.home.b.b.6
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

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        HandlerThread handlerThread = new HandlerThread("HomeAdBannerPresenter");
        this.m = handlerThread;
        handlerThread.start();
        ap apVar = new ap(this, this.m.getLooper());
        this.f32640d = apVar;
        apVar.sendEmptyMessageDelayed(6666, c.a.ad.f());
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        int i = message.what;
        if (i != 6666) {
            if (i == 8888) {
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
                this.f32640d.sendEmptyMessageDelayed(8888, c.a.ad.g());
                return;
            }
            final AdTemplate c2 = com.kwad.sdk.home.download.a.a().c();
            if (c2 != null) {
                ak.a(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.b.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a(c2, true);
                    }
                });
                com.kwad.sdk.core.d.a.a("HomeAdBannerPresenter", "handleMsg MSG_CHECK_DELAY installedData not null, showBanner");
                com.kwad.sdk.home.download.a.a().a(com.kwad.sdk.core.response.b.a.s(com.kwad.sdk.core.response.b.c.j(c2)));
                this.f32640d.sendEmptyMessageDelayed(8888, c.a.ad.g());
            }
        }
    }

    public void a(final boolean z) {
        AnimatorSet animatorSet = this.f32639c;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f32639c.removeAllListeners();
            this.f32639c.cancel();
        }
        this.f32639c = new AnimatorSet();
        com.kwad.sdk.core.d.a.a("HomeAdBannerPresenter", "bottomViewAnimate + isShow : " + z);
        View view = this.f32641e;
        String name = View.TRANSLATION_Y.getName();
        float[] fArr = new float[1];
        fArr[0] = z ? 0.0f : this.l;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, name, fArr);
        ofFloat.setDuration(z ? 300L : 260L);
        this.f32639c.playTogether(ofFloat);
        this.f32639c.removeAllListeners();
        this.f32639c.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.home.b.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                b.this.f32641e.setVisibility(z ? 4 : 0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (z) {
                    return;
                }
                b.this.f32641e.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator) {
                super.onAnimationPause(animator);
                b.this.f32641e.setVisibility(z ? 4 : 0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z) {
                    b.this.f32641e.setVisibility(0);
                }
            }
        });
        this.f32639c.start();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32640d.removeCallbacksAndMessages(null);
        com.kwad.sdk.core.download.b.b bVar = this.f32638b;
        if (bVar != null) {
            bVar.f();
        }
        com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.home.download.a.a().d();
            }
        });
        this.m.quit();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.k = (ViewStub) b(R.id.ksad_home_banner_layout_vs);
        this.l = -ao.a(o(), 100.0f);
    }
}
