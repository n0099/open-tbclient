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
    public SlidePlayViewPager f33298b;

    /* renamed from: c  reason: collision with root package name */
    public View f33299c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33300d;

    /* renamed from: e  reason: collision with root package name */
    public LottieAnimationView f33301e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33302f;

    /* renamed from: g  reason: collision with root package name */
    public LottieAnimationView f33303g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f33304h;

    /* renamed from: i  reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f33305i;
    public GestureDetector j;
    public ViewPager.OnPageChangeListener k;
    public boolean l = false;
    public boolean m = false;
    public int n = 0;
    public boolean o = false;
    public com.kwad.sdk.contentalliance.home.a.d p = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.home.b.o.2
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i2, int i3) {
            if (z && o.this.f33299c.getVisibility() == 0) {
                if (o.this.m) {
                    o.this.h();
                } else if (o.this.l) {
                    o.this.g();
                }
            }
        }
    };

    private void e() {
        this.f33298b.b(this.k);
        ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (o.this.n == 1) {
                    com.kwad.sdk.contentalliance.home.viewpager.a adapter = o.this.f33298b.getAdapter();
                    AdTemplate e2 = adapter.e(adapter.a(i2));
                    if (e2 == null || !com.kwad.sdk.core.response.b.c.b(e2)) {
                        return;
                    }
                    o.this.q();
                    o.this.j = new GestureDetector(o.this.o(), o.this.f33305i);
                    o.this.f33299c.setClickable(true);
                    o.this.f33299c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.1.1
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
        this.f33298b.a(simpleOnPageChangeListener);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void f() {
        GestureDetector gestureDetector;
        if (this.f33304h == null) {
            this.f33304h = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.3
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
            this.f33305i = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.4
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
                    gestureDetector = new GestureDetector(o(), this.f33305i);
                }
                this.f33299c.setClickable(true);
                this.f33299c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.5
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return o.this.j.onTouchEvent(motionEvent);
                    }
                });
            }
            gestureDetector = new GestureDetector(o(), this.f33304h);
            this.j = gestureDetector;
            this.f33299c.setClickable(true);
            this.f33299c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.5
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
            this.f33298b.setEnabled(true);
            this.f33303g.d();
            this.f33299c.setOnTouchListener(null);
            this.f33299c.setVisibility(8);
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
            this.f33298b.setEnabled(true);
            this.f33301e.d();
            this.f33299c.setOnTouchListener(null);
            if (this.l) {
                this.n = 1;
            }
            this.f33299c.animate().translationYBy(-o().getResources().getDisplayMetrics().heightPixels).setDuration(600L).setListener(new Animator.AnimatorListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    o.this.f33299c.setVisibility(8);
                    o.this.f33299c.setVisibility(8);
                    o.this.f33301e.d();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    o.this.f33299c.setVisibility(8);
                    o.this.f33299c.setVisibility(8);
                    o.this.f33301e.d();
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
        this.f33298b.setEnabled(false);
        this.f33303g.d();
        this.f33302f.setVisibility(8);
        this.f33303g.setVisibility(8);
        this.f33300d.setVisibility(0);
        this.f33301e.setVisibility(0);
        this.f33301e.b();
        this.f33299c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.f33298b.setEnabled(false);
        this.f33301e.d();
        this.f33301e.setVisibility(8);
        this.f33300d.setVisibility(8);
        this.f33303g.b();
        this.f33303g.setVisibility(0);
        this.f33302f.setVisibility(0);
        this.f33299c.setVisibility(0);
        if (this.o) {
            int i2 = this.f33299c.getContext().getResources().getDisplayMetrics().heightPixels;
            View view = this.f33299c;
            view.setTranslationY(view.getTranslationY() + i2);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33298b.setEnabled(true);
        this.m = ae.c(o());
        boolean z = ae.a(o()) && ((com.kwad.sdk.contentalliance.home.e) this).f33357a.l;
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
            this.f33303g.setVisibility(8);
            this.f33299c.setVisibility(8);
        }
        ((com.kwad.sdk.contentalliance.home.e) this).f33357a.f33359b.a(this.p);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ViewPager.OnPageChangeListener onPageChangeListener = this.k;
        if (onPageChangeListener != null) {
            this.f33298b.b(onPageChangeListener);
        }
        if (this.f33301e.c()) {
            this.f33301e.d();
        }
        if (this.f33303g.c()) {
            this.f33303g.d();
        }
        this.f33299c.animate().cancel();
        this.f33299c.setOnTouchListener(null);
        this.f33299c.setVisibility(8);
        ((com.kwad.sdk.contentalliance.home.e) this).f33357a.f33359b.b(this.p);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33298b = (SlidePlayViewPager) b(R.id.ksad_slide_play_view_pager);
        this.f33299c = b(R.id.ksad_guider_mask);
        this.f33300d = (TextView) b(R.id.ksad_guider_up_title);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_guider_up_anim);
        this.f33301e = lottieAnimationView;
        lottieAnimationView.setAnimation(R.raw.ksad_detail_guider_slide_up_new);
        this.f33301e.setRepeatMode(1);
        this.f33301e.setRepeatCount(-1);
        this.f33302f = (TextView) b(R.id.ksad_guider_left_title);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) b(R.id.ksad_guider_left_anim);
        this.f33303g = lottieAnimationView2;
        lottieAnimationView2.setAnimation(R.raw.ksad_detail_guider_slide_left);
        this.f33303g.setRepeatMode(1);
        this.f33303g.setRepeatCount(-1);
    }
}
