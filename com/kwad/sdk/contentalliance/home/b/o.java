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
    public SlidePlayViewPager f33396b;

    /* renamed from: c  reason: collision with root package name */
    public View f33397c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33398d;

    /* renamed from: e  reason: collision with root package name */
    public LottieAnimationView f33399e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33400f;

    /* renamed from: g  reason: collision with root package name */
    public LottieAnimationView f33401g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f33402h;

    /* renamed from: i  reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f33403i;
    public GestureDetector j;
    public ViewPager.OnPageChangeListener k;
    public boolean l = false;
    public boolean m = false;
    public int n = 0;
    public boolean o = false;
    public com.kwad.sdk.contentalliance.home.a.d p = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.home.b.o.2
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i2, int i3) {
            if (z && o.this.f33397c.getVisibility() == 0) {
                if (o.this.m) {
                    o.this.h();
                } else if (o.this.l) {
                    o.this.g();
                }
            }
        }
    };

    private void e() {
        this.f33396b.b(this.k);
        ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (o.this.n == 1) {
                    com.kwad.sdk.contentalliance.home.viewpager.a adapter = o.this.f33396b.getAdapter();
                    AdTemplate e2 = adapter.e(adapter.a(i2));
                    if (e2 == null || !com.kwad.sdk.core.response.b.c.b(e2)) {
                        return;
                    }
                    o.this.q();
                    o.this.j = new GestureDetector(o.this.o(), o.this.f33403i);
                    o.this.f33397c.setClickable(true);
                    o.this.f33397c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.1.1
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
        this.f33396b.a(simpleOnPageChangeListener);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void f() {
        GestureDetector gestureDetector;
        if (this.f33402h == null) {
            this.f33402h = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.3
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
            this.f33403i = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.4
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
            int i2 = this.n;
            if (i2 != 0) {
                if (i2 == 1) {
                    gestureDetector = new GestureDetector(o(), this.f33403i);
                }
                this.f33397c.setClickable(true);
                this.f33397c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.5
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return o.this.j.onTouchEvent(motionEvent);
                    }
                });
            }
            gestureDetector = new GestureDetector(o(), this.f33402h);
            this.j = gestureDetector;
            this.f33397c.setClickable(true);
            this.f33397c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.5
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
            this.f33396b.setEnabled(true);
            this.f33401g.d();
            this.f33397c.setOnTouchListener(null);
            this.f33397c.setVisibility(8);
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
            this.f33396b.setEnabled(true);
            this.f33399e.d();
            this.f33397c.setOnTouchListener(null);
            if (this.l) {
                this.n = 1;
            }
            this.f33397c.animate().translationYBy(-o().getResources().getDisplayMetrics().heightPixels).setDuration(600L).setListener(new Animator.AnimatorListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    o.this.f33397c.setVisibility(8);
                    o.this.f33397c.setVisibility(8);
                    o.this.f33399e.d();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    o.this.f33397c.setVisibility(8);
                    o.this.f33397c.setVisibility(8);
                    o.this.f33399e.d();
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
        this.f33396b.setEnabled(false);
        this.f33401g.d();
        this.f33400f.setVisibility(8);
        this.f33401g.setVisibility(8);
        this.f33398d.setVisibility(0);
        this.f33399e.setVisibility(0);
        this.f33399e.b();
        this.f33397c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.f33396b.setEnabled(false);
        this.f33399e.d();
        this.f33399e.setVisibility(8);
        this.f33398d.setVisibility(8);
        this.f33401g.b();
        this.f33401g.setVisibility(0);
        this.f33400f.setVisibility(0);
        this.f33397c.setVisibility(0);
        if (this.o) {
            int i2 = this.f33397c.getContext().getResources().getDisplayMetrics().heightPixels;
            View view = this.f33397c;
            view.setTranslationY(view.getTranslationY() + i2);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33396b.setEnabled(true);
        this.m = ae.c(o());
        boolean z = ae.a(o()) && ((com.kwad.sdk.contentalliance.home.e) this).f33455a.l;
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
            this.f33401g.setVisibility(8);
            this.f33397c.setVisibility(8);
        }
        ((com.kwad.sdk.contentalliance.home.e) this).f33455a.f33457b.a(this.p);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ViewPager.OnPageChangeListener onPageChangeListener = this.k;
        if (onPageChangeListener != null) {
            this.f33396b.b(onPageChangeListener);
        }
        if (this.f33399e.c()) {
            this.f33399e.d();
        }
        if (this.f33401g.c()) {
            this.f33401g.d();
        }
        this.f33397c.animate().cancel();
        this.f33397c.setOnTouchListener(null);
        this.f33397c.setVisibility(8);
        ((com.kwad.sdk.contentalliance.home.e) this).f33455a.f33457b.b(this.p);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33396b = (SlidePlayViewPager) b(R.id.ksad_slide_play_view_pager);
        this.f33397c = b(R.id.ksad_guider_mask);
        this.f33398d = (TextView) b(R.id.ksad_guider_up_title);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_guider_up_anim);
        this.f33399e = lottieAnimationView;
        lottieAnimationView.setAnimation(R.raw.ksad_detail_guider_slide_up_new);
        this.f33399e.setRepeatMode(1);
        this.f33399e.setRepeatCount(-1);
        this.f33400f = (TextView) b(R.id.ksad_guider_left_title);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) b(R.id.ksad_guider_left_anim);
        this.f33401g = lottieAnimationView2;
        lottieAnimationView2.setAnimation(R.raw.ksad_detail_guider_slide_left);
        this.f33401g.setRepeatMode(1);
        this.f33401g.setRepeatCount(-1);
    }
}
