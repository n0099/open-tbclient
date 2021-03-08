package com.kwad.sdk.contentalliance.home.swipe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
/* loaded from: classes3.dex */
public class c extends d {
    private static final Interpolator l = new AccelerateDecelerateInterpolator();
    private static final Interpolator m = new Interpolator() { // from class: com.kwad.sdk.contentalliance.home.swipe.c.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f5828a;
    private final int b;
    private final int c;
    private VelocityTracker d;
    private float e;
    private float f;
    private long g;
    private float h = 1.0f;
    private boolean i;
    private boolean j;
    private boolean k;
    private a n;
    private boolean o;

    public c(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f5828a = (int) (context.getResources().getDisplayMetrics().density * 400.0f);
        this.b = viewConfiguration.getScaledMaximumFlingVelocity();
        this.c = viewConfiguration.getScaledPagingTouchSlop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
    }

    private void a(float f, final float f2, boolean z) {
        if (!this.o) {
            this.o = true;
            if (this.n != null) {
                this.n.d(f);
            }
        }
        if (this.n != null) {
            this.n.c(f2);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(250L);
        ofFloat.setInterpolator(z ? m : l);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.contentalliance.home.swipe.c.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.n != null) {
                    c.this.h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.n.a(c.this.h);
                }
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.home.swipe.c.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.k = false;
                if (c.this.n != null) {
                    c.this.n.e(f2);
                }
                c.this.a(f2);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                c.this.k = true;
            }
        });
        ofFloat.start();
    }

    private boolean a(MotionEvent motionEvent) {
        if (this.k) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.i = false;
                this.j = false;
                this.g = 0L;
                this.o = false;
                this.e = motionEvent.getX();
                this.f = motionEvent.getY();
                com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "handlerInterceptTouchEvent ACTION_DOWN mInitialMotionX: " + this.e);
                break;
            case 1:
            case 3:
                this.i = false;
                if (this.d != null) {
                    this.d.recycle();
                    this.d = null;
                    break;
                }
                break;
            case 2:
                float x = motionEvent.getX() - this.e;
                float abs = Math.abs(x);
                float abs2 = Math.abs(motionEvent.getY() - this.f);
                if (this.n != null && abs > this.c && abs > abs2) {
                    if (this.h < 1.0f) {
                        this.i = x > 0.0f;
                    } else {
                        this.i = x < 0.0f;
                    }
                }
                com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "handlerInterceptTouchEvent ACTION_MOVE dx=" + x + "--mIsBeingDragged: " + this.i);
                break;
        }
        if (this.d == null) {
            this.d = VelocityTracker.obtain();
        }
        this.d.addMovement(motionEvent);
        return this.i;
    }

    private float b(float f) {
        if (this.n != null) {
            return this.n.b(f);
        }
        return 0.0f;
    }

    private boolean b(MotionEvent motionEvent) {
        if (this.k) {
            return true;
        }
        if (this.d == null) {
            this.d = VelocityTracker.obtain();
        }
        this.d.addMovement(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "onTouchEvent ACTION_DOWN");
                break;
            case 1:
            case 3:
                com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "onTouchEvent ACTION_CANCEL");
                if (this.i) {
                    d();
                }
                this.j = false;
                this.o = false;
                if (this.d != null) {
                    this.d.recycle();
                    this.d = null;
                    break;
                }
                break;
            case 2:
                com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "onTouchEvent ACTION_MOVE");
                if (!this.j) {
                    float x = motionEvent.getX() - this.e;
                    float abs = Math.abs(x);
                    float abs2 = Math.abs(motionEvent.getY() - this.f);
                    if (!this.i && this.n != null && abs > this.c && abs * 0.5d > abs2) {
                        if (this.h == 0.0f) {
                            this.i = x > 0.0f;
                        } else {
                            this.i = x < 0.0f;
                        }
                    }
                    if (this.i) {
                        if (!c(motionEvent)) {
                            float b = b(x);
                            com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "dx" + x);
                            com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "progress" + b);
                            if (this.n != null) {
                                this.h = b;
                                if (!this.o) {
                                    this.o = true;
                                    this.n.d(b);
                                }
                                this.n.a(b);
                                break;
                            }
                        } else {
                            com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "shouldIgnoreTouch");
                            break;
                        }
                    }
                }
                break;
        }
        return this.i;
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.g == 0) {
            this.g = SystemClock.elapsedRealtime();
        }
        if (SystemClock.elapsedRealtime() - this.g >= 80 || Math.abs(e()) < this.f5828a) {
            return false;
        }
        this.e = motionEvent.getX();
        return true;
    }

    private void d() {
        int e = e();
        if (Math.abs(e) >= this.f5828a) {
            if (e < 0) {
                a(this.h, 0.0f, true);
            } else {
                a(this.h, 1.0f, true);
            }
        } else if (this.h > 0.5f) {
            a(this.h, 1.0f, true);
        } else {
            a(this.h, 0.0f, true);
        }
    }

    private int e() {
        VelocityTracker velocityTracker = this.d;
        velocityTracker.computeCurrentVelocity(1000, this.b);
        return (int) velocityTracker.getXVelocity();
    }

    private void g(View view, MotionEvent motionEvent) {
        if (this.n == null) {
            return;
        }
        switch (motionEvent.getAction()) {
            case 0:
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return;
            case 1:
            case 3:
                view.getParent().requestDisallowInterceptTouchEvent(false);
                return;
            case 2:
            default:
                return;
        }
    }

    public a a() {
        return this.n;
    }

    @Override // com.kwad.sdk.contentalliance.home.swipe.d
    protected void a(View view, MotionEvent motionEvent) {
        g(view, motionEvent);
    }

    public void a(a aVar) {
        this.n = aVar;
    }

    public boolean b() {
        return this.h != 1.0f;
    }

    @Override // com.kwad.sdk.contentalliance.home.swipe.d
    protected boolean b(View view, MotionEvent motionEvent) {
        return a(motionEvent);
    }

    public void c() {
        if (this.h != 1.0f) {
            this.o = false;
            a(this.h, 1.0f, false);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.swipe.d
    protected boolean c(View view, MotionEvent motionEvent) {
        return b(motionEvent);
    }
}
