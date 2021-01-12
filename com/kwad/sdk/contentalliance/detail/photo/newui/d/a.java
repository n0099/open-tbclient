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
/* loaded from: classes4.dex */
public class a extends com.kwad.sdk.contentalliance.detail.photo.f.a<View> {
    private AdBaseFrameLayout d;
    private AdTemplate e;
    private View f;
    private View g;
    private ImageView h;
    private ImageView i;
    private LottieAnimationView j;
    private ImageView k;
    private AnimatorSet l;
    private boolean m;
    private i<com.kwad.sdk.live.a.c, LiveStatusResultData> o;
    private LiveStatusResultData.LiveStatus p;
    private boolean q;
    private boolean r;
    private boolean s;
    @Nullable
    private com.kwad.sdk.core.i.a t;
    private ImageView u;
    private b v;
    private volatile boolean w;
    private int x;
    private Handler n = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.contentalliance.a.a y = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.2
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
    private com.kwad.sdk.core.i.c z = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.3
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
        this.g.clearAnimation();
        this.l = new AnimatorSet();
        this.l.setInterpolator(new AccelerateDecelerateInterpolator());
        this.l.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                a.this.g.setScaleX(1.0f);
                a.this.g.setScaleY(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.m) {
                    a.this.a(0L);
                }
            }
        });
        this.l.playSequentially(b(this.g));
        this.l.setStartDelay(j);
        this.l.setDuration(1000L);
        this.l.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveStatusResultData.LiveStatus liveStatus) {
        this.p = liveStatus;
        this.k.setVisibility(0);
        KSImageLoader.loadCircleIconWithoutStroke(this.h, com.kwad.sdk.core.response.b.c.q(this.e), this.h.getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon_2));
        s();
        a(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.s) {
            PhotoInfo k = com.kwad.sdk.core.response.b.c.k(this.e);
            SceneImpl sceneImpl = this.e.mAdScene;
            if (sceneImpl != null) {
                if (z) {
                    e.f(this.e, this.x);
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
                if (this.v != null) {
                    this.v.a();
                }
            }
        }
    }

    private AnimatorSet b(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.8f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.8f, 1.0f));
        return animatorSet;
    }

    private void c(int i) {
        e.a(this.e, 5, i, this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.r || this.f8393a.l.getSourceType() != 0) {
            return;
        }
        c.a().a(this.e, this.e.getShowPosition(), this.f8393a.f8402a.i, new c.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.4
            @Override // com.kwad.sdk.contentalliance.detail.photo.newui.d.c.a
            public void a(AdTemplate adTemplate, final int i) {
                com.kwad.sdk.core.d.a.a("PhotoAuthorIconPresenter", "onCall currentPosition = " + i);
                a.this.v = new b(a.this.h, a.this.u, a.this.n, new b.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.4.1
                    @Override // com.kwad.sdk.contentalliance.detail.photo.newui.d.b.a
                    public void a() {
                        a.this.a(-65437);
                        c.a().a(i);
                        a.this.x = c.a().c();
                        e.e(a.this.e, a.this.x);
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
            this.g.clearAnimation();
            this.l.cancel();
        }
        if (this.j != null) {
            this.j.d();
            this.j.setVisibility(8);
        }
        this.w = false;
        if (this.v != null) {
            this.v.a();
        }
        this.x = 0;
        this.k.setVisibility(8);
        this.p = null;
        this.r = false;
        if (this.o != null) {
            this.o.e();
        }
        this.n.removeCallbacksAndMessages(null);
    }

    private boolean q() {
        return com.kwad.sdk.core.config.c.A() && com.kwad.sdk.core.response.b.c.b(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (q() && !this.q && this.m) {
            this.q = true;
            final long o = d.o(com.kwad.sdk.core.response.b.c.k(this.e));
            this.o = new i<com.kwad.sdk.live.a.c, LiveStatusResultData>() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.5
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.sdk.live.a.c b() {
                    return new com.kwad.sdk.live.a.c(o);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public LiveStatusResultData b(String str) {
                    LiveStatusResultData liveStatusResultData = new LiveStatusResultData();
                    liveStatusResultData.parseJson(new JSONObject(str));
                    return liveStatusResultData;
                }
            };
            this.o.a(new j<com.kwad.sdk.live.a.c, LiveStatusResultData>() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.live.a.c cVar, int i, String str) {
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
        if (this.f8393a.j.mAdScene == null || this.p == null || !this.r) {
            return;
        }
        c(9);
        com.kwad.sdk.plugin.d dVar = (com.kwad.sdk.plugin.d) g.a(com.kwad.sdk.plugin.d.class);
        if (dVar != null) {
            dVar.a(o(), this.e, this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.kwad.sdk.core.report.b.a(this.e, 13, this.d.getTouchCoords());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        h hVar = this.f8393a.f8402a;
        if (hVar != null) {
            this.t = hVar.f8742a;
        }
        this.e = this.f8393a.j;
        a(-1);
        e();
        this.f.setOnClickListener(this);
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ao.a()) {
                    return;
                }
                a.this.a(true);
            }
        });
        this.f8393a.f8403b.add(this.y);
    }

    public void a(@ColorInt int i) {
        if (this.h == null) {
            return;
        }
        KSImageLoader.loadCircleIcon(this.h, com.kwad.sdk.core.response.b.c.q(this.e), this.h.getResources().getDrawable(com.kwad.sdk.core.response.b.c.c(this.e) ? R.drawable.ksad_default_ad_author_icon : R.drawable.ksad_photo_default_author_icon_2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8393a.f8403b.remove(this.y);
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f = b(R.id.ksad_author_button_container);
        this.g = b(R.id.ksad_author_icon_container);
        this.h = (ImageView) b(R.id.ksad_author_icon);
        this.i = (ImageView) b(R.id.ksad_author_guide_icon);
        this.j = (LottieAnimationView) b(R.id.ksad_live_border_anim);
        this.j.setRepeatMode(1);
        this.j.setRepeatCount(-1);
        this.j.setAnimation(R.raw.ksad_live_author_icon);
        this.k = (ImageView) b(R.id.ksad_live_tip_icon);
        this.s = com.kwad.sdk.core.config.c.B();
        this.u = (ImageView) b(R.id.ksad_profile_guider_img);
        this.u.setVisibility(8);
    }

    public void e() {
        String r = com.kwad.sdk.core.response.b.c.r(this.e);
        if (ag.a(r)) {
            this.i.setVisibility(8);
        } else if (com.kwad.sdk.core.response.b.c.b(this.e)) {
            if (!this.s) {
                this.i.setVisibility(8);
                return;
            }
            KSImageLoader.loadImage(this.i, r, this.e);
            this.i.setVisibility(0);
        } else if (!com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(this.e))) {
            KSImageLoader.loadImage(this.i, r, this.e);
            this.i.setVisibility(0);
        } else if (!com.kwad.sdk.core.config.c.T()) {
            this.i.setVisibility(8);
        } else {
            KSImageLoader.loadImage(this.i, r, this.e);
            this.i.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    public View g() {
        return LayoutInflater.from(o()).inflate(R.layout.ksad_photo_newui_author_icon_view, (ViewGroup) this.c, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ao.a()) {
            return;
        }
        if (com.kwad.sdk.core.response.b.c.c(this.e)) {
            if (!com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(this.e)) || com.kwad.sdk.core.config.c.T()) {
                com.kwad.sdk.core.download.b.a.a(view.getContext(), this.e, new a.InterfaceC1088a() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.8
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC1088a
                    public void a() {
                        a.this.u();
                    }
                }, this.f8393a.o);
            }
            c(0);
        } else if (this.r) {
            t();
        } else {
            a(false);
        }
    }
}
