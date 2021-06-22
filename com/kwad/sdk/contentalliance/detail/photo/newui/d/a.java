package com.kwad.sdk.contentalliance.detail.photo.newui.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.newui.d.b;
import com.kwad.sdk.contentalliance.detail.photo.newui.d.c;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.profile.home.ProfileHomeParam;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveStatusResultData;
import com.kwad.sdk.plugin.g;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.photo.f.a<View> {

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f33098d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33099e;

    /* renamed from: f  reason: collision with root package name */
    public View f33100f;

    /* renamed from: g  reason: collision with root package name */
    public View f33101g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f33102h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f33103i;
    public LottieAnimationView j;
    public ImageView k;
    public AnimatorSet l;
    public boolean m;
    public i<com.kwad.sdk.live.a.c, LiveStatusResultData> o;
    public LiveStatusResultData.LiveStatus p;
    public boolean q;
    public boolean r;
    public boolean s;
    @Nullable
    public com.kwad.sdk.core.i.a t;
    public ImageView u;
    public b v;
    public volatile boolean w;
    public int x;
    public Handler n = new Handler(Looper.getMainLooper());
    public com.kwad.sdk.contentalliance.a.a y = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            a.this.m = true;
            a.this.r();
            a.this.u.setVisibility(8);
            com.kwad.sdk.core.d.a.a("PhotoAuthorIconPresenter", "becomesAttachedOnPageSelected");
            if (a.this.t != null) {
                a.this.t.a(a.this.z);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            a.this.m = false;
            a.this.p();
            if (a.this.t != null) {
                a.this.t.b(a.this.z);
            }
        }
    };
    public com.kwad.sdk.core.i.c z = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.3
        @Override // com.kwad.sdk.core.i.c
        public void b() {
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (a.this.w) {
                return;
            }
            a.this.w = true;
            com.kwad.sdk.core.d.a.a("PhotoAuthorIconPresenter", "mTryShowProfileGuider");
            a.this.h();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        this.f33101g.clearAnimation();
        AnimatorSet animatorSet = new AnimatorSet();
        this.l = animatorSet;
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        this.l.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                a.this.f33101g.setScaleX(1.0f);
                a.this.f33101g.setScaleY(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.m) {
                    a.this.a(0L);
                }
            }
        });
        this.l.playSequentially(b(this.f33101g));
        this.l.setStartDelay(j);
        this.l.setDuration(1000L);
        this.l.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveStatusResultData.LiveStatus liveStatus) {
        this.p = liveStatus;
        this.k.setVisibility(0);
        String q = com.kwad.sdk.core.response.b.c.q(this.f33099e);
        ImageView imageView = this.f33102h;
        KSImageLoader.loadCircleIconWithoutStroke(imageView, q, imageView.getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon_2));
        s();
        a(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.s) {
            PhotoInfo k = com.kwad.sdk.core.response.b.c.k(this.f33099e);
            AdTemplate adTemplate = this.f33099e;
            SceneImpl sceneImpl = adTemplate.mAdScene;
            if (sceneImpl != null) {
                if (z) {
                    e.f(adTemplate, this.x);
                } else {
                    c(3);
                }
                ProfileHomeParam profileHomeParam = new ProfileHomeParam();
                profileHomeParam.mEntryScene = sceneImpl.entryScene;
                profileHomeParam.mAuthorId = d.o(k);
                profileHomeParam.mAuthorIcon = d.r(k);
                profileHomeParam.mAuthorName = d.p(k);
                profileHomeParam.mCurrentPhotoId = d.k(k);
                com.kwad.sdk.contentalliance.profile.home.a.a(o(), profileHomeParam);
                b bVar = this.v;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    private AnimatorSet b(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.8f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.8f, 1.0f));
        return animatorSet;
    }

    private void c(int i2) {
        e.a(this.f33099e, 5, i2, this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.r || ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.l.getSourceType() != 0) {
            return;
        }
        c a2 = c.a();
        AdTemplate adTemplate = this.f33099e;
        a2.a(adTemplate, adTemplate.getShowPosition(), ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32811a.f33485i, new c.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.4
            @Override // com.kwad.sdk.contentalliance.detail.photo.newui.d.c.a
            public void a(AdTemplate adTemplate2, final int i2) {
                com.kwad.sdk.core.d.a.a("PhotoAuthorIconPresenter", "onCall currentPosition = " + i2);
                a aVar = a.this;
                aVar.v = new b(aVar.f33102h, a.this.u, a.this.n, new b.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.4.1
                    @Override // com.kwad.sdk.contentalliance.detail.photo.newui.d.b.a
                    public void a() {
                        a.this.a(-65437);
                        c.a().a(i2);
                        a.this.x = c.a().c();
                        e.e(a.this.f33099e, a.this.x);
                    }

                    @Override // com.kwad.sdk.contentalliance.detail.photo.newui.d.b.a
                    public void b() {
                        a.this.a(-1);
                    }
                });
                a.this.v.a(c.a.ac.d());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.l != null) {
            this.f33101g.clearAnimation();
            this.l.cancel();
        }
        LottieAnimationView lottieAnimationView = this.j;
        if (lottieAnimationView != null) {
            lottieAnimationView.d();
            this.j.setVisibility(8);
        }
        this.w = false;
        b bVar = this.v;
        if (bVar != null) {
            bVar.a();
        }
        this.x = 0;
        this.k.setVisibility(8);
        this.p = null;
        this.r = false;
        i<com.kwad.sdk.live.a.c, LiveStatusResultData> iVar = this.o;
        if (iVar != null) {
            iVar.e();
        }
        this.n.removeCallbacksAndMessages(null);
    }

    private boolean q() {
        return com.kwad.sdk.core.config.c.A() && com.kwad.sdk.core.response.b.c.b(this.f33099e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (q() && !this.q && this.m) {
            this.q = true;
            final long o = d.o(com.kwad.sdk.core.response.b.c.k(this.f33099e));
            i<com.kwad.sdk.live.a.c, LiveStatusResultData> iVar = new i<com.kwad.sdk.live.a.c, LiveStatusResultData>() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.sdk.live.a.c b() {
                    return new com.kwad.sdk.live.a.c(o);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public LiveStatusResultData b(String str) {
                    LiveStatusResultData liveStatusResultData = new LiveStatusResultData();
                    liveStatusResultData.parseJson(new JSONObject(str));
                    return liveStatusResultData;
                }
            };
            this.o = iVar;
            iVar.a(new j<com.kwad.sdk.live.a.c, LiveStatusResultData>() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.live.a.c cVar, int i2, String str) {
                    a.this.q = false;
                    a.this.r = false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.live.a.c cVar, @NonNull final LiveStatusResultData liveStatusResultData) {
                    a.this.n.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.r = true;
                            a.this.a(liveStatusResultData.liveStatus);
                            a.this.q = false;
                        }
                    });
                }
            });
        }
    }

    private void s() {
        if (!this.j.c()) {
            this.j.b();
        }
        this.j.setVisibility(0);
    }

    private void t() {
        if (((com.kwad.sdk.contentalliance.detail.b) this).f32790a.j.mAdScene == null || this.p == null || !this.r) {
            return;
        }
        c(9);
        com.kwad.sdk.plugin.d dVar = (com.kwad.sdk.plugin.d) g.a(com.kwad.sdk.plugin.d.class);
        if (dVar != null) {
            dVar.a(o(), this.f33099e, this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.kwad.sdk.core.report.b.a(this.f33099e, 13, this.f33098d.getTouchCoords());
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        h hVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32811a;
        if (hVar != null) {
            this.t = hVar.f33477a;
        }
        this.f33099e = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.j;
        a(-1);
        e();
        this.f33100f.setOnClickListener(this);
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ao.a()) {
                    return;
                }
                a.this.a(true);
            }
        });
        ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32812b.add(this.y);
    }

    public void a(@ColorInt int i2) {
        if (this.f33102h == null) {
            return;
        }
        String q = com.kwad.sdk.core.response.b.c.q(this.f33099e);
        int i3 = com.kwad.sdk.core.response.b.c.c(this.f33099e) ? R.drawable.ksad_default_ad_author_icon : R.drawable.ksad_photo_default_author_icon_2;
        ImageView imageView = this.f33102h;
        KSImageLoader.loadCircleIcon(imageView, q, imageView.getResources().getDrawable(i3));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32812b.remove(this.y);
        p();
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33098d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f33100f = b(R.id.ksad_author_button_container);
        this.f33101g = b(R.id.ksad_author_icon_container);
        this.f33102h = (ImageView) b(R.id.ksad_author_icon);
        this.f33103i = (ImageView) b(R.id.ksad_author_guide_icon);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_live_border_anim);
        this.j = lottieAnimationView;
        lottieAnimationView.setRepeatMode(1);
        this.j.setRepeatCount(-1);
        this.j.setAnimation(R.raw.ksad_live_author_icon);
        this.k = (ImageView) b(R.id.ksad_live_tip_icon);
        this.s = com.kwad.sdk.core.config.c.B();
        ImageView imageView = (ImageView) b(R.id.ksad_profile_guider_img);
        this.u = imageView;
        imageView.setVisibility(8);
    }

    public void e() {
        String r = com.kwad.sdk.core.response.b.c.r(this.f33099e);
        if (ag.a(r)) {
            this.f33103i.setVisibility(8);
        } else if (!com.kwad.sdk.core.response.b.c.b(this.f33099e) ? !com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(this.f33099e)) || com.kwad.sdk.core.config.c.T() : this.s) {
            this.f33103i.setVisibility(8);
        } else {
            KSImageLoader.loadImage(this.f33103i, r, this.f33099e);
            this.f33103i.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    public View g() {
        return LayoutInflater.from(o()).inflate(R.layout.ksad_photo_newui_author_icon_view, (ViewGroup) ((com.kwad.sdk.contentalliance.detail.photo.f.a) this).f33030c, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ao.a()) {
            return;
        }
        if (com.kwad.sdk.core.response.b.c.c(this.f33099e)) {
            if (!com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(this.f33099e)) || com.kwad.sdk.core.config.c.T()) {
                com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33099e, new a.InterfaceC0382a() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.8
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
                    public void a() {
                        a.this.u();
                    }
                }, ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.o);
            }
            c(0);
        } else if (this.r) {
            t();
        } else {
            a(false);
        }
    }
}
