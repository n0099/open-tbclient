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
    public SlidePlayViewPager f32773b;

    /* renamed from: c  reason: collision with root package name */
    public ViewStub f32774c;

    /* renamed from: d  reason: collision with root package name */
    public View f32775d;

    /* renamed from: e  reason: collision with root package name */
    public LottieAnimationView f32776e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32777f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32778g;
    public ValueAnimator k;
    public ValueAnimator l;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32779h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32780i = false;
    public boolean j = false;
    public final com.kwad.sdk.contentalliance.a.a m = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            if (b.this.f32773b.getCurrentItem() != b.this.f32773b.getPreItem()) {
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
            b.this.f32779h = false;
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            b.this.f32779h = true;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (!ae.c(o())) {
            e();
        } else if (!((com.kwad.sdk.contentalliance.detail.b) this).f32692a.n && this.f32779h && j >= com.kwad.sdk.core.config.c.ai() && !this.f32780i) {
            this.f32780i = true;
            ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.n = true;
            if (this.f32774c.getParent() != null) {
                this.f32775d = this.f32774c.inflate();
                LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_guider_up_anim);
                this.f32776e = lottieAnimationView;
                lottieAnimationView.setAnimation(R.raw.ksad_detail_guider_slide_up_new);
                this.f32776e.setRepeatMode(1);
                this.f32776e.setRepeatCount(-1);
            }
            this.f32776e.b();
            ValueAnimator a2 = am.a(this.f32775d, true);
            this.k = a2;
            a2.start();
            this.f32773b.a(false, 2);
            this.f32775d.setClickable(true);
            this.f32775d.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.g();
                    return false;
                }
            });
            com.kwad.sdk.core.report.e.r(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f32780i = false;
        this.j = false;
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32777f;
        if (bVar != null) {
            bVar.b(this.n);
        }
        com.kwad.sdk.core.i.a aVar = this.f32778g;
        if (aVar != null) {
            aVar.b(this.o);
            this.f32779h = false;
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.remove(this.m);
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
        ValueAnimator a2 = am.a(this.f32775d, false);
        this.l = a2;
        a2.start();
        SlidePlayViewPager slidePlayViewPager = this.f32773b;
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
        if (ae.c(o()) && (hVar = (cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a).f32713a) != null) {
            SlidePlayViewPager slidePlayViewPager = cVar.l;
            this.f32773b = slidePlayViewPager;
            com.kwad.sdk.core.i.a aVar = hVar.f33379a;
            this.f32778g = aVar;
            com.kwad.sdk.contentalliance.detail.video.b bVar = cVar.m;
            this.f32777f = bVar;
            if (bVar == null || slidePlayViewPager == null || aVar == null) {
                return;
            }
            bVar.a(this.n);
            this.f32778g.a(this.o);
            ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.add(this.m);
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
        this.f32774c = (ViewStub) b(R.id.ksad_slide_up_guide_view_stub);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        e();
        f();
    }
}
