package com.kwad.sdk.contentalliance.home.b;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
/* loaded from: classes6.dex */
public class o extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    public SlidePlayViewPager f33002b;

    /* renamed from: c  reason: collision with root package name */
    public View f33003c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33004d;

    /* renamed from: e  reason: collision with root package name */
    public LottieAnimationView f33005e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33006f;

    /* renamed from: g  reason: collision with root package name */
    public LottieAnimationView f33007g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f33008h;
    public GestureDetector.SimpleOnGestureListener i;
    public GestureDetector j;
    public ViewPager.OnPageChangeListener k;
    public boolean l = false;
    public boolean m = false;
    public int n = 0;
    public boolean o = false;
    public com.kwad.sdk.contentalliance.home.a.d p = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.home.b.o.2
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i, int i2) {
            if (z && o.this.f33003c.getVisibility() == 0) {
                if (o.this.m) {
                    o.this.h();
                } else if (o.this.l) {
                    o.this.g();
                }
            }
        }
    };

    private void e() {
        this.f33002b.b(this.k);
        ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (o.this.n == 1) {
                    com.kwad.sdk.contentalliance.home.viewpager.a adapter = o.this.f33002b.getAdapter();
                    AdTemplate e2 = adapter.e(adapter.a(i));
                    if (e2 == null || !com.kwad.sdk.core.response.b.c.b(e2)) {
                        return;
                    }
                    o.this.q();
                    o.this.j = new GestureDetector(o.this.o(), o.this.i);
                    o.this.f33003c.setClickable(true);
                    o.this.f33003c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.1.1
                        @Override // android.view.View.OnTouchListener
                        @SuppressLint({"ClickableViewAccessibility"})
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return o.this.j.onTouchEvent(motionEvent);
                        }
                    });
                    o.this.n = 2;
                }
            }
        };
        this.k = simpleOnPageChangeListener;
        this.f33002b.a(simpleOnPageChangeListener);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void f() {
        GestureDetector gestureDetector;
        if (this.f33008h == null) {
            this.f33008h = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.3
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    return (f3 >= -5000.0f || Math.abs(f3) <= Math.abs(f2) * 3.0f) ? super.onFling(motionEvent, motionEvent2, f2, f3) : o.this.h();
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    return (f3 <= 60.0f || Math.abs(f3) <= Math.abs(f2) * 2.0f) ? super.onScroll(motionEvent, motionEvent2, f2, f3) : o.this.h();
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    return o.this.h();
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return o.this.h();
                }
            };
            this.i = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.4
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    return o.this.g();
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    return o.this.g();
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    return o.this.g();
                }
            };
            int i = this.n;
            if (i != 0) {
                if (i == 1) {
                    gestureDetector = new GestureDetector(o(), this.i);
                }
                this.f33003c.setClickable(true);
                this.f33003c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.5
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return o.this.j.onTouchEvent(motionEvent);
                    }
                });
            }
            gestureDetector = new GestureDetector(o(), this.f33008h);
            this.j = gestureDetector;
            this.f33003c.setClickable(true);
            this.f33003c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return o.this.j.onTouchEvent(motionEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (this.l) {
            this.l = false;
            ae.b(o());
            com.kwad.sdk.contentalliance.detail.photo.newui.d.c.a().b(false);
            this.f33002b.setEnabled(true);
            this.f33007g.d();
            this.f33003c.setOnTouchListener(null);
            this.f33003c.setVisibility(8);
            this.n = 2;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (this.m) {
            this.m = false;
            ae.d(o());
            com.kwad.sdk.contentalliance.detail.photo.newui.d.c.a().a(false);
            this.f33002b.setEnabled(true);
            this.f33005e.d();
            this.f33003c.setOnTouchListener(null);
            if (this.l) {
                this.n = 1;
            }
            this.f33003c.animate().translationYBy(-o().getResources().getDisplayMetrics().heightPixels).setDuration(600L).setListener(new Animator.AnimatorListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    o.this.f33003c.setVisibility(8);
                    o.this.f33003c.setVisibility(8);
                    o.this.f33005e.d();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    o.this.f33003c.setVisibility(8);
                    o.this.f33003c.setVisibility(8);
                    o.this.f33005e.d();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).start();
            this.o = true;
            return true;
        }
        return false;
    }

    private void p() {
        this.f33002b.setEnabled(false);
        this.f33007g.d();
        this.f33006f.setVisibility(8);
        this.f33007g.setVisibility(8);
        this.f33004d.setVisibility(0);
        this.f33005e.setVisibility(0);
        this.f33005e.b();
        this.f33003c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.f33002b.setEnabled(false);
        this.f33005e.d();
        this.f33005e.setVisibility(8);
        this.f33004d.setVisibility(8);
        this.f33007g.b();
        this.f33007g.setVisibility(0);
        this.f33006f.setVisibility(0);
        this.f33003c.setVisibility(0);
        if (this.o) {
            int i = this.f33003c.getContext().getResources().getDisplayMetrics().heightPixels;
            View view = this.f33003c;
            view.setTranslationY(view.getTranslationY() + i);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33002b.setEnabled(true);
        this.m = ae.c(o());
        boolean z = ae.a(o()) && ((com.kwad.sdk.contentalliance.home.e) this).f33058a.l;
        this.l = z;
        if (this.m) {
            this.n = 0;
            p();
            f();
            e();
        } else if (z) {
            this.n = 1;
            q();
            f();
        } else {
            this.n = 2;
            this.f33007g.setVisibility(8);
            this.f33003c.setVisibility(8);
        }
        ((com.kwad.sdk.contentalliance.home.e) this).f33058a.f33060b.a(this.p);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ViewPager.OnPageChangeListener onPageChangeListener = this.k;
        if (onPageChangeListener != null) {
            this.f33002b.b(onPageChangeListener);
        }
        if (this.f33005e.c()) {
            this.f33005e.d();
        }
        if (this.f33007g.c()) {
            this.f33007g.d();
        }
        this.f33003c.animate().cancel();
        this.f33003c.setOnTouchListener(null);
        this.f33003c.setVisibility(8);
        ((com.kwad.sdk.contentalliance.home.e) this).f33058a.f33060b.b(this.p);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33002b = (SlidePlayViewPager) b(R.id.ksad_slide_play_view_pager);
        this.f33003c = b(R.id.ksad_guider_mask);
        this.f33004d = (TextView) b(R.id.ksad_guider_up_title);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_guider_up_anim);
        this.f33005e = lottieAnimationView;
        lottieAnimationView.setAnimation(R.raw.ksad_detail_guider_slide_up_new);
        this.f33005e.setRepeatMode(1);
        this.f33005e.setRepeatCount(-1);
        this.f33006f = (TextView) b(R.id.ksad_guider_left_title);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) b(R.id.ksad_guider_left_anim);
        this.f33007g = lottieAnimationView2;
        lottieAnimationView2.setAnimation(R.raw.ksad_detail_guider_slide_left);
        this.f33007g.setRepeatMode(1);
        this.f33007g.setRepeatCount(-1);
    }
}
