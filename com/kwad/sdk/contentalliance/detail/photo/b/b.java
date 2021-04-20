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
import com.kwad.sdk.core.i.c;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.am;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public SlidePlayViewPager f32496b;

    /* renamed from: c  reason: collision with root package name */
    public ViewStub f32497c;

    /* renamed from: d  reason: collision with root package name */
    public View f32498d;

    /* renamed from: e  reason: collision with root package name */
    public LottieAnimationView f32499e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32500f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32501g;
    public ValueAnimator k;
    public ValueAnimator l;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32502h = false;
    public boolean i = false;
    public boolean j = false;
    public final com.kwad.sdk.contentalliance.a.a m = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            if (b.this.f32496b.getCurrentItem() != b.this.f32496b.getPreItem()) {
                ae.d(b.this.o());
                b.this.e();
            }
        }
    };
    public final e n = new f() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            super.a(j, j2);
            b.this.a(j2);
        }
    };
    public final c o = new c() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.3
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            b.this.f32502h = false;
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            b.this.f32502h = true;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (!ae.c(o())) {
            e();
        } else if (!((com.kwad.sdk.contentalliance.detail.b) this).f32422a.n && this.f32502h && j >= com.kwad.sdk.core.config.c.ai() && !this.i) {
            this.i = true;
            ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.n = true;
            if (this.f32497c.getParent() != null) {
                this.f32498d = this.f32497c.inflate();
                LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_guider_up_anim);
                this.f32499e = lottieAnimationView;
                lottieAnimationView.setAnimation(R.raw.ksad_detail_guider_slide_up_new);
                this.f32499e.setRepeatMode(1);
                this.f32499e.setRepeatCount(-1);
            }
            this.f32499e.b();
            ValueAnimator a2 = am.a(this.f32498d, true);
            this.k = a2;
            a2.start();
            this.f32496b.a(false, 2);
            this.f32498d.setClickable(true);
            this.f32498d.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.g();
                    return false;
                }
            });
            com.kwad.sdk.core.report.e.r(((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.i = false;
        this.j = false;
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32500f;
        if (bVar != null) {
            bVar.b(this.n);
        }
        com.kwad.sdk.core.i.a aVar = this.f32501g;
        if (aVar != null) {
            aVar.b(this.o);
            this.f32502h = false;
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.remove(this.m);
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
        ae.d(o());
        ValueAnimator a2 = am.a(this.f32498d, false);
        this.l = a2;
        a2.start();
        SlidePlayViewPager slidePlayViewPager = this.f32496b;
        if (slidePlayViewPager != null) {
            slidePlayViewPager.a(true, 2);
        }
        e();
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        com.kwad.sdk.contentalliance.detail.c cVar;
        h hVar;
        super.a();
        if (ae.c(o()) && (hVar = (cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a).f32441a) != null) {
            SlidePlayViewPager slidePlayViewPager = cVar.l;
            this.f32496b = slidePlayViewPager;
            com.kwad.sdk.core.i.a aVar = hVar.f33078a;
            this.f32501g = aVar;
            com.kwad.sdk.contentalliance.detail.video.b bVar = cVar.m;
            this.f32500f = bVar;
            if (bVar == null || slidePlayViewPager == null || aVar == null) {
                return;
            }
            bVar.a(this.n);
            this.f32501g.a(this.o);
            ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.add(this.m);
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
        this.f32497c = (ViewStub) b(R.id.ksad_slide_up_guide_view_stub);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        e();
        f();
    }
}
