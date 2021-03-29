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
/* loaded from: classes6.dex */
public class c extends d {
    public static final Interpolator l = new AccelerateDecelerateInterpolator();
    public static final Interpolator m = new Interpolator() { // from class: com.kwad.sdk.contentalliance.home.swipe.c.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f32803a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32804b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32805c;

    /* renamed from: d  reason: collision with root package name */
    public VelocityTracker f32806d;

    /* renamed from: e  reason: collision with root package name */
    public float f32807e;

    /* renamed from: f  reason: collision with root package name */
    public float f32808f;

    /* renamed from: g  reason: collision with root package name */
    public long f32809g;

    /* renamed from: h  reason: collision with root package name */
    public float f32810h = 1.0f;
    public boolean i;
    public boolean j;
    public boolean k;
    public a n;
    public boolean o;

    public c(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f32803a = (int) (context.getResources().getDisplayMetrics().density * 400.0f);
        this.f32804b = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f32805c = viewConfiguration.getScaledPagingTouchSlop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
    }

    private void a(float f2, final float f3, boolean z) {
        if (!this.o) {
            this.o = true;
            a aVar = this.n;
            if (aVar != null) {
                aVar.d(f2);
            }
        }
        a aVar2 = this.n;
        if (aVar2 != null) {
            aVar2.c(f3);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
        ofFloat.setDuration(250L);
        ofFloat.setInterpolator(z ? m : l);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.contentalliance.home.swipe.c.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.n != null) {
                    c.this.f32810h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.n.a(c.this.f32810h);
                }
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.home.swipe.c.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.k = false;
                if (c.this.n != null) {
                    c.this.n.e(f3);
                }
                c.this.a(f3);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                c.this.k = true;
            }
        });
        ofFloat.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
        if (r0 != 3) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(MotionEvent motionEvent) {
        String str;
        boolean z = true;
        if (this.k) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX() - this.f32807e;
                    float abs = Math.abs(x);
                    float abs2 = Math.abs(motionEvent.getY() - this.f32808f);
                    if (this.n != null && abs > this.f32805c && abs > abs2) {
                        if (this.f32810h < 1.0f) {
                            z = false;
                            this.i = z;
                        } else {
                            z = false;
                            this.i = z;
                        }
                    }
                    str = "handlerInterceptTouchEvent ACTION_MOVE dx=" + x + "--mIsBeingDragged: " + this.i;
                }
            }
            this.i = false;
            VelocityTracker velocityTracker = this.f32806d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f32806d = null;
            }
            if (this.f32806d == null) {
                this.f32806d = VelocityTracker.obtain();
            }
            this.f32806d.addMovement(motionEvent);
            return this.i;
        }
        this.i = false;
        this.j = false;
        this.f32809g = 0L;
        this.o = false;
        this.f32807e = motionEvent.getX();
        this.f32808f = motionEvent.getY();
        str = "handlerInterceptTouchEvent ACTION_DOWN mInitialMotionX: " + this.f32807e;
        com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", str);
        if (this.f32806d == null) {
        }
        this.f32806d.addMovement(motionEvent);
        return this.i;
    }

    private float b(float f2) {
        a aVar = this.n;
        if (aVar != null) {
            return aVar.b(f2);
        }
        return 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
        if (r0 != 3) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0072, code lost:
        r3 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(MotionEvent motionEvent) {
        String str;
        if (this.k) {
            return true;
        }
        if (this.f32806d == null) {
            this.f32806d = VelocityTracker.obtain();
        }
        this.f32806d.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            boolean z = false;
            if (action != 1) {
                if (action == 2) {
                    com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "onTouchEvent ACTION_MOVE");
                    if (!this.j) {
                        float x = motionEvent.getX() - this.f32807e;
                        float abs = Math.abs(x);
                        float abs2 = Math.abs(motionEvent.getY() - this.f32808f);
                        if (!this.i && this.n != null && abs > this.f32805c && abs * 0.5d > abs2) {
                            if (this.f32810h == 0.0f) {
                                this.i = z;
                            } else {
                                this.i = z;
                            }
                        }
                        if (this.i) {
                            if (c(motionEvent)) {
                                str = "shouldIgnoreTouch";
                            } else {
                                float b2 = b(x);
                                com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "dx" + x);
                                com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "progress" + b2);
                                a aVar = this.n;
                                if (aVar != null) {
                                    this.f32810h = b2;
                                    if (!this.o) {
                                        this.o = true;
                                        aVar.d(b2);
                                    }
                                    this.n.a(b2);
                                }
                            }
                        }
                    }
                }
                return this.i;
            }
            com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "onTouchEvent ACTION_CANCEL");
            if (this.i) {
                d();
            }
            this.j = false;
            this.o = false;
            VelocityTracker velocityTracker = this.f32806d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f32806d = null;
            }
            return this.i;
        }
        str = "onTouchEvent ACTION_DOWN";
        com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", str);
        return this.i;
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.f32809g == 0) {
            this.f32809g = SystemClock.elapsedRealtime();
        }
        if (SystemClock.elapsedRealtime() - this.f32809g >= 80 || Math.abs(e()) < this.f32803a) {
            return false;
        }
        this.f32807e = motionEvent.getX();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 > 0.5f) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        float f2;
        int e2 = e();
        if (Math.abs(e2) >= this.f32803a) {
            if (e2 < 0) {
                f2 = this.f32810h;
                a(f2, 0.0f, true);
                return;
            }
            f2 = this.f32810h;
            a(f2, 1.0f, true);
            return;
        }
        f2 = this.f32810h;
    }

    private int e() {
        VelocityTracker velocityTracker = this.f32806d;
        velocityTracker.computeCurrentVelocity(1000, this.f32804b);
        return (int) velocityTracker.getXVelocity();
    }

    private void g(View view, MotionEvent motionEvent) {
        if (this.n == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    public a a() {
        return this.n;
    }

    @Override // com.kwad.sdk.contentalliance.home.swipe.d
    public void a(View view, MotionEvent motionEvent) {
        g(view, motionEvent);
    }

    public void a(a aVar) {
        this.n = aVar;
    }

    public boolean b() {
        return this.f32810h != 1.0f;
    }

    @Override // com.kwad.sdk.contentalliance.home.swipe.d
    public boolean b(View view, MotionEvent motionEvent) {
        return a(motionEvent);
    }

    public void c() {
        float f2 = this.f32810h;
        if (f2 != 1.0f) {
            this.o = false;
            a(f2, 1.0f, false);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.swipe.d
    public boolean c(View view, MotionEvent motionEvent) {
        return b(motionEvent);
    }
}
