package com.repackage;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ag5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public b b;
    public VelocityTracker c;
    public float d;
    public float e;
    public long f;
    public long g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ag5 a;

        public a(ag5 ag5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ag5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.i || !this.a.h || this.a.b == null) {
                return;
            }
            this.a.b.onViewClick();
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void K(float f, float f2);

        void onViewClick();

        void onViewDragToRight();
    }

    public ag5(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view2;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view2.getContext());
        if (viewConfiguration != null) {
            this.l = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = ViewConfiguration.getMaximumFlingVelocity();
        this.j = ViewConfiguration.getMinimumFlingVelocity();
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (this.c == null) {
                this.c = VelocityTracker.obtain();
            }
            this.c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.d = motionEvent.getX();
                this.e = motionEvent.getY();
                this.f = System.currentTimeMillis();
                this.h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f < 100 && currentTimeMillis - this.g < 500) {
                    this.i = true;
                } else {
                    this.i = false;
                }
                VelocityTracker velocityTracker = this.c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.e - motionEvent.getY()) > 50.0f) {
                    this.i = false;
                    this.h = false;
                }
                if (this.i) {
                    b bVar2 = this.b;
                    if (bVar2 != null) {
                        bVar2.K(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.d - motionEvent.getX()) > this.l && (this.d - motionEvent.getX()) - 50.0f > Math.abs(this.e - motionEvent.getY()) && (bVar = this.b) != null) {
                    bVar.onViewDragToRight();
                }
                if (!this.i && this.h && Math.abs(this.d - motionEvent.getX()) < 30.0f && Math.abs(this.e - motionEvent.getY()) < 30.0f) {
                    this.a.postDelayed(new a(this), 300L);
                }
                this.g = currentTimeMillis;
                e();
            } else if (action == 3) {
                e();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void e() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.c) == null) {
            return;
        }
        velocityTracker.clear();
        this.c.recycle();
        this.c = null;
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.b = bVar;
        }
    }
}
