package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.ap;
/* loaded from: classes7.dex */
public class c extends GestureDetector implements ap.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final int f35870b;

    /* renamed from: g  reason: collision with root package name */
    public static final int f35871g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f35872h;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public VelocityTracker B;

    /* renamed from: a  reason: collision with root package name */
    public int f35873a;

    /* renamed from: c  reason: collision with root package name */
    public int f35874c;

    /* renamed from: d  reason: collision with root package name */
    public int f35875d;

    /* renamed from: e  reason: collision with root package name */
    public int f35876e;

    /* renamed from: f  reason: collision with root package name */
    public int f35877f;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f35878i;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(230121929, "Lcom/kwad/sdk/contentalliance/widget/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(230121929, "Lcom/kwad/sdk/contentalliance/widget/c;");
                return;
            }
        }
        f35871g = ViewConfiguration.getLongPressTimeout();
        f35872h = ViewConfiguration.getTapTimeout();
        f35870b = ViewConfiguration.getDoubleTapTimeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onGestureListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (GestureDetector.OnGestureListener) objArr2[1], (Handler) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        super(context, onGestureListener, handler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onGestureListener, handler};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (GestureDetector.OnGestureListener) objArr2[1], (Handler) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.A = f35870b;
        if (handler != null) {
            this.f35878i = new ap(this, handler.getLooper());
        } else {
            this.f35878i = new ap(this);
        }
        this.j = onGestureListener;
        if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
            setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
        }
        a(context);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f35878i.removeMessages(1);
            this.f35878i.removeMessages(2);
            this.f35878i.removeMessages(3);
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
    }

    private void a(Context context) {
        int scaledDoubleTapSlop;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, context) == null) {
            if (this.j == null) {
                throw new NullPointerException("OnGestureListener must not be null");
            }
            this.z = true;
            int i3 = 300;
            if (context == null) {
                i2 = ViewConfiguration.getTouchSlop();
                this.f35876e = ViewConfiguration.getMinimumFlingVelocity();
                this.f35877f = ViewConfiguration.getMaximumFlingVelocity();
                i3 = i2;
                scaledDoubleTapSlop = 300;
            } else {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.f35876e = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f35877f = viewConfiguration.getScaledMaximumFlingVelocity();
                i2 = scaledTouchSlop;
            }
            this.f35873a = i2 * i2;
            this.f35874c = i3 * i3;
            this.f35875d = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, motionEvent, motionEvent2, motionEvent3)) == null) {
            if (this.q) {
                long eventTime = motionEvent3.getEventTime() - motionEvent2.getEventTime();
                if (eventTime > this.A || eventTime < 10) {
                    return false;
                }
                int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
                int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
                return (x * x) + (y * y) < ((motionEvent.getFlags() & 8) != 0 ? 0 : this.f35875d);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f35878i.removeMessages(1);
            this.f35878i.removeMessages(2);
            this.f35878i.removeMessages(3);
            this.u = false;
            this.p = false;
            this.q = false;
            this.m = false;
            this.n = false;
            this.o = false;
            this.r = false;
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f35878i.removeMessages(3);
            this.m = false;
            this.n = true;
            this.j.onLongPress(this.s);
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.A = j;
        }
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        GestureDetector.OnDoubleTapListener onDoubleTapListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
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
    }

    @Override // android.view.GestureDetector
    public boolean isLongpressEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.z : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0242  */
    @Override // android.view.GestureDetector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        MotionEvent motionEvent2;
        MotionEvent motionEvent3;
        boolean onFling;
        GestureDetector.OnDoubleTapListener onDoubleTapListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
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
                    boolean hasMessages = this.f35878i.hasMessages(3);
                    if (hasMessages) {
                        this.f35878i.removeMessages(3);
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
                            this.f35878i.removeMessages(2);
                            this.f35878i.sendEmptyMessageAtTime(2, this.s.getDownTime() + f35871g);
                        }
                        this.f35878i.sendEmptyMessageAtTime(1, this.s.getDownTime() + f35872h);
                        return z | this.j.onDown(motionEvent);
                    }
                    this.f35878i.sendEmptyMessageDelayed(3, this.A);
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
                this.f35878i.sendEmptyMessageAtTime(1, this.s.getDownTime() + f35872h);
                return z | this.j.onDown(motionEvent);
            }
            if (i2 == 1) {
                this.l = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.u) {
                    onFling = this.k.onDoubleTapEvent(motionEvent) | false;
                } else {
                    if (this.n) {
                        this.f35878i.removeMessages(3);
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
                        velocityTracker.computeCurrentVelocity(1000, this.f35877f);
                        float yVelocity = velocityTracker.getYVelocity(pointerId);
                        float xVelocity = velocityTracker.getXVelocity(pointerId);
                        if (Math.abs(yVelocity) > this.f35876e || Math.abs(xVelocity) > this.f35876e) {
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
                this.f35878i.removeMessages(1);
                this.f35878i.removeMessages(2);
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
                    this.B.computeCurrentVelocity(1000, this.f35877f);
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
                if (i7 > (z3 ? 0 : this.f35873a)) {
                    onFling = this.j.onScroll(this.s, motionEvent, f7, f8);
                    this.v = f5;
                    this.w = f6;
                    this.p = false;
                    this.f35878i.removeMessages(3);
                    this.f35878i.removeMessages(1);
                    this.f35878i.removeMessages(2);
                } else {
                    onFling = false;
                }
                if (i7 > (z3 ? 0 : this.f35874c)) {
                    this.q = false;
                }
            }
            return onFling;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector
    public void setIsLongpressEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.z = z;
        }
    }

    @Override // android.view.GestureDetector
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onDoubleTapListener) == null) {
            this.k = onDoubleTapListener;
        }
    }
}
