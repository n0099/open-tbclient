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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic;
    public static final Interpolator l;
    public static final Interpolator m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f35255a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35256b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35257c;

    /* renamed from: d  reason: collision with root package name */
    public VelocityTracker f35258d;

    /* renamed from: e  reason: collision with root package name */
    public float f35259e;

    /* renamed from: f  reason: collision with root package name */
    public float f35260f;

    /* renamed from: g  reason: collision with root package name */
    public long f35261g;

    /* renamed from: h  reason: collision with root package name */
    public float f35262h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35263i;
    public boolean j;
    public boolean k;
    public a n;
    public boolean o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2081823421, "Lcom/kwad/sdk/contentalliance/home/swipe/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2081823421, "Lcom/kwad/sdk/contentalliance/home/swipe/c;");
                return;
            }
        }
        l = new AccelerateDecelerateInterpolator();
        m = new Interpolator() { // from class: com.kwad.sdk.contentalliance.home.swipe.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                InterceptResult invokeF;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeF = interceptable2.invokeF(1048576, this, f2)) == null) {
                    float f3 = f2 - 1.0f;
                    return (f3 * f3 * f3 * f3 * f3) + 1.0f;
                }
                return invokeF.floatValue;
            }
        };
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35262h = 1.0f;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f35255a = (int) (context.getResources().getDisplayMetrics().density * 400.0f);
        this.f35256b = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f35257c = viewConfiguration.getScaledPagingTouchSlop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65540, this, f2) == null) {
        }
    }

    private void a(float f2, float f3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)}) == null) {
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
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.contentalliance.home.swipe.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f35264a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35264a = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) || this.f35264a.n == null) {
                        return;
                    }
                    this.f35264a.f35262h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.f35264a.n.a(this.f35264a.f35262h);
                }
            });
            ofFloat.addListener(new AnimatorListenerAdapter(this, f3) { // from class: com.kwad.sdk.contentalliance.home.swipe.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ float f35265a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f35266b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Float.valueOf(f3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35266b = this;
                    this.f35265a = f3;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f35266b.k = false;
                        if (this.f35266b.n != null) {
                            this.f35266b.n.e(this.f35265a);
                        }
                        this.f35266b.a(this.f35265a);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationStart(animator);
                        this.f35266b.k = true;
                    }
                }
            });
            ofFloat.start();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
        if (r0 != 3) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, motionEvent)) == null) {
            boolean z = true;
            if (this.k) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x = motionEvent.getX() - this.f35259e;
                        float abs = Math.abs(x);
                        float abs2 = Math.abs(motionEvent.getY() - this.f35260f);
                        if (this.n != null && abs > this.f35257c && abs > abs2) {
                            if (this.f35262h < 1.0f) {
                                z = false;
                                this.f35263i = z;
                            } else {
                                z = false;
                                this.f35263i = z;
                            }
                        }
                        str = "handlerInterceptTouchEvent ACTION_MOVE dx=" + x + "--mIsBeingDragged: " + this.f35263i;
                    }
                }
                this.f35263i = false;
                VelocityTracker velocityTracker = this.f35258d;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.f35258d = null;
                }
                if (this.f35258d == null) {
                    this.f35258d = VelocityTracker.obtain();
                }
                this.f35258d.addMovement(motionEvent);
                return this.f35263i;
            }
            this.f35263i = false;
            this.j = false;
            this.f35261g = 0L;
            this.o = false;
            this.f35259e = motionEvent.getX();
            this.f35260f = motionEvent.getY();
            str = "handlerInterceptTouchEvent ACTION_DOWN mInitialMotionX: " + this.f35259e;
            com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", str);
            if (this.f35258d == null) {
            }
            this.f35258d.addMovement(motionEvent);
            return this.f35263i;
        }
        return invokeL.booleanValue;
    }

    private float b(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65544, this, f2)) == null) {
            a aVar = this.n;
            if (aVar != null) {
                return aVar.b(f2);
            }
            return 0.0f;
        }
        return invokeF.floatValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
        if (r0 != 3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0076, code lost:
        r3 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, motionEvent)) == null) {
            if (this.k) {
                return true;
            }
            if (this.f35258d == null) {
                this.f35258d = VelocityTracker.obtain();
            }
            this.f35258d.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                boolean z = false;
                if (action != 1) {
                    if (action == 2) {
                        com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "onTouchEvent ACTION_MOVE");
                        if (!this.j) {
                            float x = motionEvent.getX() - this.f35259e;
                            float abs = Math.abs(x);
                            float abs2 = Math.abs(motionEvent.getY() - this.f35260f);
                            if (!this.f35263i && this.n != null && abs > this.f35257c && abs * 0.5d > abs2) {
                                if (this.f35262h == 0.0f) {
                                    this.f35263i = z;
                                } else {
                                    this.f35263i = z;
                                }
                            }
                            if (this.f35263i) {
                                if (c(motionEvent)) {
                                    str = "shouldIgnoreTouch";
                                } else {
                                    float b2 = b(x);
                                    com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "dx" + x);
                                    com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "progress" + b2);
                                    a aVar = this.n;
                                    if (aVar != null) {
                                        this.f35262h = b2;
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
                    return this.f35263i;
                }
                com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", "onTouchEvent ACTION_CANCEL");
                if (this.f35263i) {
                    d();
                }
                this.j = false;
                this.o = false;
                VelocityTracker velocityTracker = this.f35258d;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.f35258d = null;
                }
                return this.f35263i;
            }
            str = "onTouchEvent ACTION_DOWN";
            com.kwad.sdk.core.d.a.a("SwipeToProfileListTouchDetector", str);
            return this.f35263i;
        }
        return invokeL.booleanValue;
    }

    private boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, motionEvent)) == null) {
            if (this.f35261g == 0) {
                this.f35261g = SystemClock.elapsedRealtime();
            }
            if (SystemClock.elapsedRealtime() - this.f35261g >= 80 || Math.abs(e()) < this.f35255a) {
                return false;
            }
            this.f35259e = motionEvent.getX();
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r0 > 0.5f) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65549, this) != null) {
            return;
        }
        int e2 = e();
        if (Math.abs(e2) >= this.f35255a) {
            if (e2 < 0) {
                f2 = this.f35262h;
                a(f2, 0.0f, true);
                return;
            }
            f2 = this.f35262h;
            a(f2, 1.0f, true);
            return;
        }
        f2 = this.f35262h;
    }

    private int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            VelocityTracker velocityTracker = this.f35258d;
            velocityTracker.computeCurrentVelocity(1000, this.f35256b);
            return (int) velocityTracker.getXVelocity();
        }
        return invokeV.intValue;
    }

    private void g(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, this, view, motionEvent) == null) || this.n == null) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : (a) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.swipe.d
    public void a(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent) == null) {
            g(view, motionEvent);
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35262h != 1.0f : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.swipe.d
    public boolean b(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view, motionEvent)) == null) ? a(motionEvent) : invokeLL.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            float f2 = this.f35262h;
            if (f2 != 1.0f) {
                this.o = false;
                a(f2, 1.0f, false);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.swipe.d
    public boolean c(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view, motionEvent)) == null) ? b(motionEvent) : invokeLL.booleanValue;
    }
}
