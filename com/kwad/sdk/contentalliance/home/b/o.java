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
/* loaded from: classes3.dex */
public class o extends com.kwad.sdk.contentalliance.home.e {
    private SlidePlayViewPager b;
    private View c;
    private TextView d;
    private LottieAnimationView e;
    private TextView f;
    private LottieAnimationView g;
    private GestureDetector.SimpleOnGestureListener h;
    private GestureDetector.SimpleOnGestureListener i;
    private GestureDetector j;
    private ViewPager.OnPageChangeListener k;
    private boolean l = false;
    private boolean m = false;
    private int n = 0;
    private boolean o = false;
    private com.kwad.sdk.contentalliance.home.a.d p = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.home.b.o.2
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i, int i2) {
            if (z && o.this.c.getVisibility() == 0) {
                if (o.this.m) {
                    o.this.h();
                } else if (o.this.l) {
                    o.this.g();
                }
            }
        }
    };

    private void e() {
        this.b.b(this.k);
        this.k = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (o.this.n == 1) {
                    com.kwad.sdk.contentalliance.home.viewpager.a adapter = o.this.b.getAdapter();
                    AdTemplate e = adapter.e(adapter.a(i));
                    if (e == null || !com.kwad.sdk.core.response.b.c.b(e)) {
                        return;
                    }
                    o.this.q();
                    o.this.j = new GestureDetector(o.this.o(), o.this.i);
                    o.this.c.setClickable(true);
                    o.this.c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.1.1
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
        this.b.a(this.k);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void f() {
        if (this.h == null) {
            this.h = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.3
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return (f2 >= -5000.0f || Math.abs(f2) <= 3.0f * Math.abs(f)) ? super.onFling(motionEvent, motionEvent2, f, f2) : o.this.h();
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return (f2 <= 60.0f || Math.abs(f2) <= 2.0f * Math.abs(f)) ? super.onScroll(motionEvent, motionEvent2, f, f2) : o.this.h();
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
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return o.this.g();
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return o.this.g();
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    return o.this.g();
                }
            };
            if (this.n == 0) {
                this.j = new GestureDetector(o(), this.h);
            } else if (this.n == 1) {
                this.j = new GestureDetector(o(), this.i);
            }
            this.c.setClickable(true);
            this.c.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.5
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
            this.b.setEnabled(true);
            this.g.d();
            this.c.setOnTouchListener(null);
            this.c.setVisibility(8);
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
            this.b.setEnabled(true);
            this.e.d();
            this.c.setOnTouchListener(null);
            if (this.l) {
                this.n = 1;
            }
            this.c.animate().translationYBy(-o().getResources().getDisplayMetrics().heightPixels).setDuration(600L).setListener(new Animator.AnimatorListener() { // from class: com.kwad.sdk.contentalliance.home.b.o.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    o.this.c.setVisibility(8);
                    o.this.c.setVisibility(8);
                    o.this.e.d();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    o.this.c.setVisibility(8);
                    o.this.c.setVisibility(8);
                    o.this.e.d();
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
        this.b.setEnabled(false);
        this.g.d();
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.e.b();
        this.c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.b.setEnabled(false);
        this.e.d();
        this.e.setVisibility(8);
        this.d.setVisibility(8);
        this.g.b();
        this.g.setVisibility(0);
        this.f.setVisibility(0);
        this.c.setVisibility(0);
        if (this.o) {
            this.c.setTranslationY(this.c.getContext().getResources().getDisplayMetrics().heightPixels + this.c.getTranslationY());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b.setEnabled(true);
        this.m = ae.c(o());
        this.l = ae.a(o()) && this.f5821a.l;
        if (this.m) {
            this.n = 0;
            p();
            f();
            e();
        } else if (this.l) {
            this.n = 1;
            q();
            f();
        } else {
            this.n = 2;
            this.g.setVisibility(8);
            this.c.setVisibility(8);
        }
        this.f5821a.b.a(this.p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.k != null) {
            this.b.b(this.k);
        }
        if (this.e.c()) {
            this.e.d();
        }
        if (this.g.c()) {
            this.g.d();
        }
        this.c.animate().cancel();
        this.c.setOnTouchListener(null);
        this.c.setVisibility(8);
        this.f5821a.b.b(this.p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (SlidePlayViewPager) b(R.id.ksad_slide_play_view_pager);
        this.c = b(R.id.ksad_guider_mask);
        this.d = (TextView) b(R.id.ksad_guider_up_title);
        this.e = (LottieAnimationView) b(R.id.ksad_guider_up_anim);
        this.e.setAnimation(R.raw.ksad_detail_guider_slide_up_new);
        this.e.setRepeatMode(1);
        this.e.setRepeatCount(-1);
        this.f = (TextView) b(R.id.ksad_guider_left_title);
        this.g = (LottieAnimationView) b(R.id.ksad_guider_left_anim);
        this.g.setAnimation(R.raw.ksad_detail_guider_slide_left);
        this.g.setRepeatMode(1);
        this.g.setRepeatCount(-1);
    }
}
