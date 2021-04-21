package com.kwad.sdk.contentalliance.detail.photo.b;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.am;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public SlidePlayViewPager f32580b;

    /* renamed from: c  reason: collision with root package name */
    public ViewStub f32581c;

    /* renamed from: d  reason: collision with root package name */
    public View f32582d;

    /* renamed from: e  reason: collision with root package name */
    public LottieAnimationView f32583e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32584f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32585g;
    public ValueAnimator k;
    public ValueAnimator l;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32586h = false;
    public boolean i = false;
    public boolean j = false;
    public final com.kwad.sdk.contentalliance.a.a m = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.a.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            if (a.this.f32580b.getCurrentItem() == a.this.f32580b.getPreItem() && c.ak()) {
                a.this.e();
            }
        }
    };
    public final e n = new f() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            super.a(j, j2);
            a.this.a(j2);
        }
    };
    public final com.kwad.sdk.core.i.c o = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.a.3
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            a.this.f32586h = false;
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            a.this.f32586h = true;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (!ae.a(o())) {
            e();
        } else if (!((com.kwad.sdk.contentalliance.detail.b) this).f32517a.n && this.f32586h && j >= c.ai() && !this.i) {
            this.i = true;
            if (this.f32581c.getParent() != null) {
                this.f32582d = this.f32581c.inflate();
                LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_guider_left_anim);
                this.f32583e = lottieAnimationView;
                lottieAnimationView.setAnimation(R.raw.ksad_detail_guider_slide_left);
                this.f32583e.setRepeatMode(1);
                this.f32583e.setRepeatCount(-1);
            }
            this.f32583e.b();
            ValueAnimator a2 = am.a(this.f32582d, true);
            this.k = a2;
            a2.start();
            this.f32580b.a(false, 2);
            this.f32582d.setClickable(true);
            this.f32582d.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.a.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    a.this.g();
                    return false;
                }
            });
            com.kwad.sdk.core.report.e.s(((com.kwad.sdk.contentalliance.detail.b) this).f32517a.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.i = false;
        this.j = false;
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32584f;
        if (bVar != null) {
            bVar.b(this.n);
        }
        com.kwad.sdk.core.i.a aVar = this.f32585g;
        if (aVar != null) {
            aVar.b(this.o);
            this.f32586h = false;
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32537b.remove(this.m);
    }

    private void f() {
        ValueAnimator valueAnimator = this.k;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.l;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.j) {
            return;
        }
        this.j = true;
        ae.b(o());
        ValueAnimator a2 = am.a(this.f32582d, false);
        this.l = a2;
        a2.start();
        SlidePlayViewPager slidePlayViewPager = this.f32580b;
        if (slidePlayViewPager != null) {
            slidePlayViewPager.a(true, 2);
        }
        e();
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (ae.a(o())) {
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a;
            this.f32580b = cVar.l;
            h hVar = cVar.f32536a;
            if (hVar != null) {
                this.f32585g = hVar.f33173a;
            }
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.m;
            this.f32584f = bVar;
            if (bVar == null || this.f32580b == null || this.f32585g == null) {
                return;
            }
            bVar.a(this.n);
            this.f32585g.a(this.o);
            ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32537b.add(this.m);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
        f();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32581c = (ViewStub) b(R.id.ksad_slide_left_guide_view_stub);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        e();
        f();
    }
}
