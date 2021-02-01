package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.kwad.sdk.utils.ap;
/* loaded from: classes3.dex */
public class c extends GestureDetector implements ap.a {
    private long A;
    private VelocityTracker B;

    /* renamed from: a  reason: collision with root package name */
    private int f9024a;
    private int c;
    private int d;
    private int e;
    private int f;
    private final Handler i;
    private final GestureDetector.OnGestureListener j;
    private GestureDetector.OnDoubleTapListener k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private MotionEvent s;
    private MotionEvent t;
    private boolean u;
    private float v;
    private float w;
    private float x;
    private float y;
    private boolean z;
    private static final int g = ViewConfiguration.getLongPressTimeout();
    private static final int h = ViewConfiguration.getTapTimeout();

    /* renamed from: b  reason: collision with root package name */
    public static final int f9023b = ViewConfiguration.getDoubleTapTimeout();

    public c(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        super(context, onGestureListener, handler);
        this.A = f9023b;
        if (handler != null) {
            this.i = new ap(this, handler.getLooper());
        } else {
            this.i = new ap(this);
        }
        this.j = onGestureListener;
        if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
            setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
        }
        a(context);
    }

    private void a() {
        this.i.removeMessages(1);
        this.i.removeMessages(2);
        this.i.removeMessages(3);
        this.B.recycle();
        this.B = null;
        this.u = false;
        this.l = false;
        this.p = false;
        this.q = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.r = false;
    }

    private void a(Context context) {
        int scaledTouchSlop;
        int i;
        int i2;
        if (this.j == null) {
            throw new NullPointerException("OnGestureListener must not be null");
        }
        this.z = true;
        if (context == null) {
            int touchSlop = ViewConfiguration.getTouchSlop();
            this.e = ViewConfiguration.getMinimumFlingVelocity();
            this.f = ViewConfiguration.getMaximumFlingVelocity();
            i = touchSlop;
            i2 = 300;
            scaledTouchSlop = touchSlop;
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.e = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f = viewConfiguration.getScaledMaximumFlingVelocity();
            i = 300;
            i2 = scaledDoubleTapSlop;
        }
        this.f9024a = scaledTouchSlop * scaledTouchSlop;
        this.c = i * i;
        this.d = i2 * i2;
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (this.q) {
            long eventTime = motionEvent3.getEventTime() - motionEvent2.getEventTime();
            if (eventTime > this.A || eventTime < 10) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < ((motionEvent.getFlags() & 8) != 0 ? 0 : this.d);
        }
        return false;
    }

    private void b() {
        this.i.removeMessages(1);
        this.i.removeMessages(2);
        this.i.removeMessages(3);
        this.u = false;
        this.p = false;
        this.q = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.r = false;
    }

    private void c() {
        this.i.removeMessages(3);
        this.m = false;
        this.n = true;
        this.j.onLongPress(this.s);
    }

    public void a(long j) {
        this.A = j;
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        switch (message.what) {
            case 1:
                this.j.onShowPress(this.s);
                return;
            case 2:
                c();
                return;
            case 3:
                if (this.k != null) {
                    if (this.l) {
                        this.m = true;
                        return;
                    } else {
                        this.k.onSingleTapConfirmed(this.s);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // android.view.GestureDetector
    public boolean isLongpressEnabled() {
        return this.z;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010f  */
    @Override // android.view.GestureDetector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        int action = motionEvent.getAction();
        if (this.B == null) {
            this.B = VelocityTracker.obtain();
        }
        this.B.addMovement(motionEvent);
        boolean z4 = (action & 255) == 6;
        int actionIndex = z4 ? motionEvent.getActionIndex() : -1;
        boolean z5 = (motionEvent.getFlags() & 8) != 0;
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (actionIndex != i) {
                f2 += motionEvent.getX(i);
                f += motionEvent.getY(i);
            }
        }
        int i2 = z4 ? pointerCount - 1 : pointerCount;
        float f3 = f2 / i2;
        float f4 = f / i2;
        switch (action & 255) {
            case 0:
                if (this.k != null) {
                    boolean hasMessages = this.i.hasMessages(3);
                    if (hasMessages) {
                        this.i.removeMessages(3);
                    }
                    if (this.s != null && this.t != null && hasMessages && a(this.s, this.t, motionEvent)) {
                        this.u = true;
                        z3 = this.k.onDoubleTap(this.s) | false | this.k.onDoubleTapEvent(motionEvent);
                        this.v = f3;
                        this.x = f3;
                        this.w = f4;
                        this.y = f4;
                        if (this.s != null) {
                            this.s.recycle();
                        }
                        this.s = MotionEvent.obtain(motionEvent);
                        this.p = true;
                        this.q = true;
                        this.l = true;
                        this.n = false;
                        this.m = false;
                        if (this.z) {
                            this.i.removeMessages(2);
                            this.i.sendEmptyMessageAtTime(2, this.s.getDownTime() + g);
                        }
                        this.i.sendEmptyMessageAtTime(1, this.s.getDownTime() + h);
                        return z3 | this.j.onDown(motionEvent);
                    }
                    this.i.sendEmptyMessageDelayed(3, this.A);
                }
                z3 = false;
                this.v = f3;
                this.x = f3;
                this.w = f4;
                this.y = f4;
                if (this.s != null) {
                }
                this.s = MotionEvent.obtain(motionEvent);
                this.p = true;
                this.q = true;
                this.l = true;
                this.n = false;
                this.m = false;
                if (this.z) {
                }
                this.i.sendEmptyMessageAtTime(1, this.s.getDownTime() + h);
                return z3 | this.j.onDown(motionEvent);
            case 1:
                this.l = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.u) {
                    z = this.k.onDoubleTapEvent(motionEvent) | false;
                } else if (this.n) {
                    this.i.removeMessages(3);
                    this.n = false;
                    z = false;
                } else if (!this.p || this.r) {
                    if (!this.r) {
                        VelocityTracker velocityTracker = this.B;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, this.f);
                        float yVelocity = velocityTracker.getYVelocity(pointerId);
                        float xVelocity = velocityTracker.getXVelocity(pointerId);
                        if (Math.abs(yVelocity) > this.e || Math.abs(xVelocity) > this.e) {
                            z = this.j.onFling(this.s, motionEvent, xVelocity, yVelocity);
                        }
                    }
                    z = false;
                } else {
                    z = this.j.onSingleTapUp(motionEvent);
                    if (this.m && this.k != null) {
                        this.k.onSingleTapConfirmed(motionEvent);
                    }
                }
                if (this.t != null) {
                    this.t.recycle();
                }
                this.t = obtain;
                if (this.B != null) {
                    this.B.recycle();
                    this.B = null;
                }
                this.u = false;
                this.m = false;
                this.r = false;
                this.i.removeMessages(1);
                this.i.removeMessages(2);
                return z;
            case 2:
                if (this.n || this.o) {
                    return false;
                }
                float f5 = this.v - f3;
                float f6 = this.w - f4;
                if (this.u) {
                    return false | this.k.onDoubleTapEvent(motionEvent);
                }
                if (!this.p) {
                    if (Math.abs(f5) >= 1.0f || Math.abs(f6) >= 1.0f) {
                        boolean onScroll = this.j.onScroll(this.s, motionEvent, f5, f6);
                        this.v = f3;
                        this.w = f4;
                        return onScroll;
                    }
                    return false;
                }
                int i3 = (int) (f3 - this.x);
                int i4 = (int) (f4 - this.y);
                int i5 = (i4 * i4) + (i3 * i3);
                if (i5 > (z5 ? 0 : this.f9024a)) {
                    z2 = this.j.onScroll(this.s, motionEvent, f5, f6);
                    this.v = f3;
                    this.w = f4;
                    this.p = false;
                    this.i.removeMessages(3);
                    this.i.removeMessages(1);
                    this.i.removeMessages(2);
                } else {
                    z2 = false;
                }
                if (i5 > (z5 ? 0 : this.c)) {
                    this.q = false;
                }
                return z2;
            case 3:
                a();
                return false;
            case 4:
            default:
                return false;
            case 5:
                this.v = f3;
                this.x = f3;
                this.w = f4;
                this.y = f4;
                b();
                return false;
            case 6:
                this.v = f3;
                this.x = f3;
                this.w = f4;
                this.y = f4;
                this.B.computeCurrentVelocity(1000, this.f);
                int actionIndex2 = motionEvent.getActionIndex();
                int pointerId2 = motionEvent.getPointerId(actionIndex2);
                float xVelocity2 = this.B.getXVelocity(pointerId2);
                float yVelocity2 = this.B.getYVelocity(pointerId2);
                for (int i6 = 0; i6 < pointerCount; i6++) {
                    if (i6 != actionIndex2) {
                        int pointerId3 = motionEvent.getPointerId(i6);
                        if ((this.B.getYVelocity(pointerId3) * yVelocity2) + (this.B.getXVelocity(pointerId3) * xVelocity2) < 0.0f) {
                            this.B.clear();
                            return false;
                        }
                    }
                }
                return false;
        }
    }

    @Override // android.view.GestureDetector
    public void setIsLongpressEnabled(boolean z) {
        this.z = z;
    }

    @Override // android.view.GestureDetector
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.k = onDoubleTapListener;
    }
}
