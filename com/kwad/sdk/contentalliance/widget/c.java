package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.kwad.sdk.utils.ap;
/* loaded from: classes6.dex */
public class c extends GestureDetector implements ap.a {
    public long A;
    public VelocityTracker B;

    /* renamed from: a  reason: collision with root package name */
    public int f34012a;

    /* renamed from: c  reason: collision with root package name */
    public int f34013c;

    /* renamed from: d  reason: collision with root package name */
    public int f34014d;

    /* renamed from: e  reason: collision with root package name */
    public int f34015e;

    /* renamed from: f  reason: collision with root package name */
    public int f34016f;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f34017i;
    public final GestureDetector.OnGestureListener j;
    public GestureDetector.OnDoubleTapListener k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public MotionEvent s;
    public MotionEvent t;
    public boolean u;
    public float v;
    public float w;
    public float x;
    public float y;
    public boolean z;

    /* renamed from: g  reason: collision with root package name */
    public static final int f34010g = ViewConfiguration.getLongPressTimeout();

    /* renamed from: h  reason: collision with root package name */
    public static final int f34011h = ViewConfiguration.getTapTimeout();

    /* renamed from: b  reason: collision with root package name */
    public static final int f34009b = ViewConfiguration.getDoubleTapTimeout();

    public c(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        super(context, onGestureListener, handler);
        this.A = f34009b;
        if (handler != null) {
            this.f34017i = new ap(this, handler.getLooper());
        } else {
            this.f34017i = new ap(this);
        }
        this.j = onGestureListener;
        if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
            setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
        }
        a(context);
    }

    private void a() {
        this.f34017i.removeMessages(1);
        this.f34017i.removeMessages(2);
        this.f34017i.removeMessages(3);
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
        int scaledDoubleTapSlop;
        int i2;
        if (this.j == null) {
            throw new NullPointerException("OnGestureListener must not be null");
        }
        this.z = true;
        int i3 = 300;
        if (context == null) {
            i2 = ViewConfiguration.getTouchSlop();
            this.f34015e = ViewConfiguration.getMinimumFlingVelocity();
            this.f34016f = ViewConfiguration.getMaximumFlingVelocity();
            i3 = i2;
            scaledDoubleTapSlop = 300;
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.f34015e = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f34016f = viewConfiguration.getScaledMaximumFlingVelocity();
            i2 = scaledTouchSlop;
        }
        this.f34012a = i2 * i2;
        this.f34013c = i3 * i3;
        this.f34014d = scaledDoubleTapSlop * scaledDoubleTapSlop;
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (this.q) {
            long eventTime = motionEvent3.getEventTime() - motionEvent2.getEventTime();
            if (eventTime > this.A || eventTime < 10) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < ((motionEvent.getFlags() & 8) != 0 ? 0 : this.f34014d);
        }
        return false;
    }

    private void b() {
        this.f34017i.removeMessages(1);
        this.f34017i.removeMessages(2);
        this.f34017i.removeMessages(3);
        this.u = false;
        this.p = false;
        this.q = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.r = false;
    }

    private void c() {
        this.f34017i.removeMessages(3);
        this.m = false;
        this.n = true;
        this.j.onLongPress(this.s);
    }

    public void a(long j) {
        this.A = j;
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        GestureDetector.OnDoubleTapListener onDoubleTapListener;
        int i2 = message.what;
        if (i2 == 1) {
            this.j.onShowPress(this.s);
        } else if (i2 == 2) {
            c();
        } else if (i2 == 3 && (onDoubleTapListener = this.k) != null) {
            if (this.l) {
                this.m = true;
            } else {
                onDoubleTapListener.onSingleTapConfirmed(this.s);
            }
        }
    }

    @Override // android.view.GestureDetector
    public boolean isLongpressEnabled() {
        return this.z;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023e  */
    @Override // android.view.GestureDetector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2;
        MotionEvent motionEvent3;
        boolean onFling;
        GestureDetector.OnDoubleTapListener onDoubleTapListener;
        int action = motionEvent.getAction();
        if (this.B == null) {
            this.B = VelocityTracker.obtain();
        }
        this.B.addMovement(motionEvent);
        int i2 = action & 255;
        boolean z2 = i2 == 6;
        int actionIndex = z2 ? motionEvent.getActionIndex() : -1;
        boolean z3 = (motionEvent.getFlags() & 8) != 0;
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                f2 += motionEvent.getX(i3);
                f3 += motionEvent.getY(i3);
            }
        }
        float f4 = z2 ? pointerCount - 1 : pointerCount;
        float f5 = f2 / f4;
        float f6 = f3 / f4;
        if (i2 == 0) {
            if (this.k != null) {
                boolean hasMessages = this.f34017i.hasMessages(3);
                if (hasMessages) {
                    this.f34017i.removeMessages(3);
                }
                MotionEvent motionEvent4 = this.s;
                if (motionEvent4 != null && (motionEvent3 = this.t) != null && hasMessages && a(motionEvent4, motionEvent3, motionEvent)) {
                    this.u = true;
                    z = this.k.onDoubleTap(this.s) | false | this.k.onDoubleTapEvent(motionEvent);
                    this.v = f5;
                    this.x = f5;
                    this.w = f6;
                    this.y = f6;
                    motionEvent2 = this.s;
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    this.s = MotionEvent.obtain(motionEvent);
                    this.p = true;
                    this.q = true;
                    this.l = true;
                    this.n = false;
                    this.m = false;
                    if (this.z) {
                        this.f34017i.removeMessages(2);
                        this.f34017i.sendEmptyMessageAtTime(2, this.s.getDownTime() + f34010g);
                    }
                    this.f34017i.sendEmptyMessageAtTime(1, this.s.getDownTime() + f34011h);
                    return z | this.j.onDown(motionEvent);
                }
                this.f34017i.sendEmptyMessageDelayed(3, this.A);
            }
            z = false;
            this.v = f5;
            this.x = f5;
            this.w = f6;
            this.y = f6;
            motionEvent2 = this.s;
            if (motionEvent2 != null) {
            }
            this.s = MotionEvent.obtain(motionEvent);
            this.p = true;
            this.q = true;
            this.l = true;
            this.n = false;
            this.m = false;
            if (this.z) {
            }
            this.f34017i.sendEmptyMessageAtTime(1, this.s.getDownTime() + f34011h);
            return z | this.j.onDown(motionEvent);
        }
        if (i2 == 1) {
            this.l = false;
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            if (this.u) {
                onFling = this.k.onDoubleTapEvent(motionEvent) | false;
            } else {
                if (this.n) {
                    this.f34017i.removeMessages(3);
                    this.n = false;
                } else if (this.p && !this.r) {
                    boolean onSingleTapUp = this.j.onSingleTapUp(motionEvent);
                    if (this.m && (onDoubleTapListener = this.k) != null) {
                        onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                    }
                    onFling = onSingleTapUp;
                } else if (!this.r) {
                    VelocityTracker velocityTracker = this.B;
                    int pointerId = motionEvent.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(1000, this.f34016f);
                    float yVelocity = velocityTracker.getYVelocity(pointerId);
                    float xVelocity = velocityTracker.getXVelocity(pointerId);
                    if (Math.abs(yVelocity) > this.f34015e || Math.abs(xVelocity) > this.f34015e) {
                        onFling = this.j.onFling(this.s, motionEvent, xVelocity, yVelocity);
                    }
                }
                onFling = false;
            }
            MotionEvent motionEvent5 = this.t;
            if (motionEvent5 != null) {
                motionEvent5.recycle();
            }
            this.t = obtain;
            VelocityTracker velocityTracker2 = this.B;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.B = null;
            }
            this.u = false;
            this.m = false;
            this.r = false;
            this.f34017i.removeMessages(1);
            this.f34017i.removeMessages(2);
        } else if (i2 != 2) {
            if (i2 == 3) {
                a();
                return false;
            } else if (i2 == 5) {
                this.v = f5;
                this.x = f5;
                this.w = f6;
                this.y = f6;
                b();
                return false;
            } else if (i2 != 6) {
                return false;
            } else {
                this.v = f5;
                this.x = f5;
                this.w = f6;
                this.y = f6;
                this.B.computeCurrentVelocity(1000, this.f34016f);
                int actionIndex2 = motionEvent.getActionIndex();
                int pointerId2 = motionEvent.getPointerId(actionIndex2);
                float xVelocity2 = this.B.getXVelocity(pointerId2);
                float yVelocity2 = this.B.getYVelocity(pointerId2);
                for (int i4 = 0; i4 < pointerCount; i4++) {
                    if (i4 != actionIndex2) {
                        int pointerId3 = motionEvent.getPointerId(i4);
                        if ((this.B.getXVelocity(pointerId3) * xVelocity2) + (this.B.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                            this.B.clear();
                            return false;
                        }
                    }
                }
                return false;
            }
        } else if (this.n || this.o) {
            return false;
        } else {
            float f7 = this.v - f5;
            float f8 = this.w - f6;
            if (this.u) {
                return false | this.k.onDoubleTapEvent(motionEvent);
            }
            if (!this.p) {
                if (Math.abs(f7) >= 1.0f || Math.abs(f8) >= 1.0f) {
                    boolean onScroll = this.j.onScroll(this.s, motionEvent, f7, f8);
                    this.v = f5;
                    this.w = f6;
                    return onScroll;
                }
                return false;
            }
            int i5 = (int) (f5 - this.x);
            int i6 = (int) (f6 - this.y);
            int i7 = (i5 * i5) + (i6 * i6);
            if (i7 > (z3 ? 0 : this.f34012a)) {
                onFling = this.j.onScroll(this.s, motionEvent, f7, f8);
                this.v = f5;
                this.w = f6;
                this.p = false;
                this.f34017i.removeMessages(3);
                this.f34017i.removeMessages(1);
                this.f34017i.removeMessages(2);
            } else {
                onFling = false;
            }
            if (i7 > (z3 ? 0 : this.f34013c)) {
                this.q = false;
            }
        }
        return onFling;
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
