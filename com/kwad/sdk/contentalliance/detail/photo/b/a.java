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
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private SlidePlayViewPager f8427b;
    private ViewStub c;
    private View d;
    private LottieAnimationView e;
    private com.kwad.sdk.contentalliance.detail.video.b f;
    private com.kwad.sdk.core.i.a g;
    private ValueAnimator k;
    private ValueAnimator l;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private final com.kwad.sdk.contentalliance.a.a m = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.a.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            if (a.this.f8427b.getCurrentItem() == a.this.f8427b.getPreItem() && c.ak()) {
                a.this.e();
            }
        }
    };
    private final e n = new f() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            super.a(j, j2);
            a.this.a(j2);
        }
    };
    private final com.kwad.sdk.core.i.c o = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.a.3
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            a.this.h = false;
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            a.this.h = true;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (!ae.a(o())) {
            e();
        } else if (this.f8395a.n || !this.h || j < c.ai() || this.i) {
        } else {
            this.i = true;
            if (this.c.getParent() != null) {
                this.d = this.c.inflate();
                this.e = (LottieAnimationView) b(R.id.ksad_guider_left_anim);
                this.e.setAnimation(R.raw.ksad_detail_guider_slide_left);
                this.e.setRepeatMode(1);
                this.e.setRepeatCount(-1);
            }
            this.e.b();
            this.k = am.a(this.d, true);
            this.k.start();
            this.f8427b.a(false, 2);
            this.d.setClickable(true);
            this.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.a.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    a.this.g();
                    return false;
                }
            });
            com.kwad.sdk.core.report.e.s(this.f8395a.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.i = false;
        this.j = false;
        if (this.f != null) {
            this.f.b(this.n);
        }
        if (this.g != null) {
            this.g.b(this.o);
            this.h = false;
        }
        this.f8395a.f8405b.remove(this.m);
    }

    private void f() {
        if (this.k != null) {
            this.k.cancel();
        }
        if (this.l != null) {
            this.l.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.j) {
            return;
        }
        this.j = true;
        ae.b(o());
        this.l = am.a(this.d, false);
        this.l.start();
        if (this.f8427b != null) {
            this.f8427b.a(true, 2);
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (ae.a(o())) {
            this.f8427b = this.f8395a.l;
            h hVar = this.f8395a.f8404a;
            if (hVar != null) {
                this.g = hVar.f8744a;
            }
            this.f = this.f8395a.m;
            if (this.f == null || this.f8427b == null || this.g == null) {
                return;
            }
            this.f.a(this.n);
            this.g.a(this.o);
            this.f8395a.f8405b.add(this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c = (ViewStub) b(R.id.ksad_slide_left_guide_view_stub);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        e();
        f();
    }
}
