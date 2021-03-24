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
    public SlidePlayViewPager f32195b;

    /* renamed from: c  reason: collision with root package name */
    public ViewStub f32196c;

    /* renamed from: d  reason: collision with root package name */
    public View f32197d;

    /* renamed from: e  reason: collision with root package name */
    public LottieAnimationView f32198e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32199f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32200g;
    public ValueAnimator k;
    public ValueAnimator l;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32201h = false;
    public boolean i = false;
    public boolean j = false;
    public final com.kwad.sdk.contentalliance.a.a m = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.a.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            if (a.this.f32195b.getCurrentItem() == a.this.f32195b.getPreItem() && c.ak()) {
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
            a.this.f32201h = false;
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            a.this.f32201h = true;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (!ae.a(o())) {
            e();
        } else if (!((com.kwad.sdk.contentalliance.detail.b) this).f32132a.n && this.f32201h && j >= c.ai() && !this.i) {
            this.i = true;
            if (this.f32196c.getParent() != null) {
                this.f32197d = this.f32196c.inflate();
                LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_guider_left_anim);
                this.f32198e = lottieAnimationView;
                lottieAnimationView.setAnimation(R.raw.ksad_detail_guider_slide_left);
                this.f32198e.setRepeatMode(1);
                this.f32198e.setRepeatCount(-1);
            }
            this.f32198e.b();
            ValueAnimator a2 = am.a(this.f32197d, true);
            this.k = a2;
            a2.start();
            this.f32195b.a(false, 2);
            this.f32197d.setClickable(true);
            this.f32197d.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.a.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    a.this.g();
                    return false;
                }
            });
            com.kwad.sdk.core.report.e.s(((com.kwad.sdk.contentalliance.detail.b) this).f32132a.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.i = false;
        this.j = false;
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32199f;
        if (bVar != null) {
            bVar.b(this.n);
        }
        com.kwad.sdk.core.i.a aVar = this.f32200g;
        if (aVar != null) {
            aVar.b(this.o);
            this.f32201h = false;
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32152b.remove(this.m);
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
        ValueAnimator a2 = am.a(this.f32197d, false);
        this.l = a2;
        a2.start();
        SlidePlayViewPager slidePlayViewPager = this.f32195b;
        if (slidePlayViewPager != null) {
            slidePlayViewPager.a(true, 2);
        }
        e();
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (ae.a(o())) {
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a;
            this.f32195b = cVar.l;
            h hVar = cVar.f32151a;
            if (hVar != null) {
                this.f32200g = hVar.f32788a;
            }
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.m;
            this.f32199f = bVar;
            if (bVar == null || this.f32195b == null || this.f32200g == null) {
                return;
            }
            bVar.a(this.n);
            this.f32200g.a(this.o);
            ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32152b.add(this.m);
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
        this.f32196c = (ViewStub) b(R.id.ksad_slide_left_guide_view_stub);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        e();
        f();
    }
}
