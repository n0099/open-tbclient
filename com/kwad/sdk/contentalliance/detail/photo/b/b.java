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
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private SlidePlayViewPager f8430b;
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
    private final com.kwad.sdk.contentalliance.a.a m = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            if (b.this.f8430b.getCurrentItem() != b.this.f8430b.getPreItem()) {
                ae.d(b.this.o());
                b.this.e();
            }
        }
    };
    private final e n = new f() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.2
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            super.a(j, j2);
            b.this.a(j2);
        }
    };
    private final c o = new c() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.3
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            b.this.h = false;
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            b.this.h = true;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (!ae.c(o())) {
            e();
        } else if (this.f8393a.n || !this.h || j < com.kwad.sdk.core.config.c.ai() || this.i) {
        } else {
            this.i = true;
            this.f8393a.n = true;
            if (this.c.getParent() != null) {
                this.d = this.c.inflate();
                this.e = (LottieAnimationView) b(R.id.ksad_guider_up_anim);
                this.e.setAnimation(R.raw.ksad_detail_guider_slide_up_new);
                this.e.setRepeatMode(1);
                this.e.setRepeatCount(-1);
            }
            this.e.b();
            this.k = am.a(this.d, true);
            this.k.start();
            this.f8430b.a(false, 2);
            this.d.setClickable(true);
            this.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.g();
                    return false;
                }
            });
            com.kwad.sdk.core.report.e.r(this.f8393a.j);
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
        this.f8393a.f8403b.remove(this.m);
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
        ae.d(o());
        this.l = am.a(this.d, false);
        this.l.start();
        if (this.f8430b != null) {
            this.f8430b.a(true, 2);
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        h hVar;
        super.a();
        if (ae.c(o()) && (hVar = this.f8393a.f8402a) != null) {
            this.f8430b = this.f8393a.l;
            this.g = hVar.f8742a;
            this.f = this.f8393a.m;
            if (this.f == null || this.f8430b == null || this.g == null) {
                return;
            }
            this.f.a(this.n);
            this.g.a(this.o);
            this.f8393a.f8403b.add(this.m);
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
        this.c = (ViewStub) b(R.id.ksad_slide_up_guide_view_stub);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        e();
        f();
    }
}
