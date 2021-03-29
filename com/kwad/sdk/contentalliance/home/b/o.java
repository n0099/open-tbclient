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
    public SlidePlayViewPager f32713b;

    /* renamed from: c  reason: collision with root package name */
    public View f32714c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32715d;

    /* renamed from: e  reason: collision with root package name */
    public LottieAnimationView f32716e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f32717f;

    /* renamed from: g  reason: collision with root package name */
    public LottieAnimationView f32718g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f32719h;
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
            if (z && o.this.f32714c.getVisibility() == 0) {
                if (o.this.m) {
                    o.this.h();
                } else if (o.this.l) {
                    o.this.g();
                }
            }
        }
    };

    private void e() {
        this.f32713b.b(this.k);
        ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (o.this.n == 1) {
                    com.kwad.sdk.contentalliance.home.viewpager.a adapter = o.this.f32713b.getAdapter();
                    AdTemplate e2 = adapter.e(adapter.a(i));
                    if (e2 == null || !com.kwad.sdk.core.response.b.c.b(e2)) {
                        return;
                    }
                    o.this.q();
                    o.this.j = new GestureDetector(o.this.o(), o.this.i);
                    o.this.f32714c.setClickable(true);
                    o.this.f32714c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.1.1
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
        this.f32713b.a(simpleOnPageChangeListener);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void f() {
        GestureDetector gestureDetector;
        if (this.f32719h == null) {
            this.f32719h = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.3
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
                this.f32714c.setClickable(true);
                this.f32714c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.5
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return o.this.j.onTouchEvent(motionEvent);
                    }
                });
            }
            gestureDetector = new GestureDetector(o(), this.f32719h);
            this.j = gestureDetector;
            this.f32714c.setClickable(true);
            this.f32714c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.5
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
            this.f32713b.setEnabled(true);
            this.f32718g.d();
            this.f32714c.setOnTouchListener(null);
            this.f32714c.setVisibility(8);
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
            this.f32713b.setEnabled(true);
            this.f32716e.d();
            this.f32714c.setOnTouchListener(null);
            if (this.l) {
                this.n = 1;
            }
            this.f32714c.animate().translationYBy(-o().getResources().getDisplayMetrics().heightPixels).setDuration(600L).setListener(new Animator.AnimatorListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    o.this.f32714c.setVisibility(8);
                    o.this.f32714c.setVisibility(8);
                    o.this.f32716e.d();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    o.this.f32714c.setVisibility(8);
                    o.this.f32714c.setVisibility(8);
                    o.this.f32716e.d();
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
        this.f32713b.setEnabled(false);
        this.f32718g.d();
        this.f32717f.setVisibility(8);
        this.f32718g.setVisibility(8);
        this.f32715d.setVisibility(0);
        this.f32716e.setVisibility(0);
        this.f32716e.b();
        this.f32714c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.f32713b.setEnabled(false);
        this.f32716e.d();
        this.f32716e.setVisibility(8);
        this.f32715d.setVisibility(8);
        this.f32718g.b();
        this.f32718g.setVisibility(0);
        this.f32717f.setVisibility(0);
        this.f32714c.setVisibility(0);
        if (this.o) {
            int i = this.f32714c.getContext().getResources().getDisplayMetrics().heightPixels;
            View view = this.f32714c;
            view.setTranslationY(view.getTranslationY() + i);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32713b.setEnabled(true);
        this.m = ae.c(o());
        boolean z = ae.a(o()) && ((com.kwad.sdk.contentalliance.home.e) this).f32769a.l;
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
            this.f32718g.setVisibility(8);
            this.f32714c.setVisibility(8);
        }
        ((com.kwad.sdk.contentalliance.home.e) this).f32769a.f32771b.a(this.p);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ViewPager.OnPageChangeListener onPageChangeListener = this.k;
        if (onPageChangeListener != null) {
            this.f32713b.b(onPageChangeListener);
        }
        if (this.f32716e.c()) {
            this.f32716e.d();
        }
        if (this.f32718g.c()) {
            this.f32718g.d();
        }
        this.f32714c.animate().cancel();
        this.f32714c.setOnTouchListener(null);
        this.f32714c.setVisibility(8);
        ((com.kwad.sdk.contentalliance.home.e) this).f32769a.f32771b.b(this.p);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32713b = (SlidePlayViewPager) b(R.id.ksad_slide_play_view_pager);
        this.f32714c = b(R.id.ksad_guider_mask);
        this.f32715d = (TextView) b(R.id.ksad_guider_up_title);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_guider_up_anim);
        this.f32716e = lottieAnimationView;
        lottieAnimationView.setAnimation(R.raw.ksad_detail_guider_slide_up_new);
        this.f32716e.setRepeatMode(1);
        this.f32716e.setRepeatCount(-1);
        this.f32717f = (TextView) b(R.id.ksad_guider_left_title);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) b(R.id.ksad_guider_left_anim);
        this.f32718g = lottieAnimationView2;
        lottieAnimationView2.setAnimation(R.raw.ksad_detail_guider_slide_left);
        this.f32718g.setRepeatMode(1);
        this.f32718g.setRepeatCount(-1);
    }
}
