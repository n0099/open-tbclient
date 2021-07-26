package d.a.p0.d1.p;

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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f52485a;

    /* renamed from: b  reason: collision with root package name */
    public b f52486b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f52487c;

    /* renamed from: d  reason: collision with root package name */
    public float f52488d;

    /* renamed from: e  reason: collision with root package name */
    public float f52489e;

    /* renamed from: f  reason: collision with root package name */
    public long f52490f;

    /* renamed from: g  reason: collision with root package name */
    public long f52491g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52492h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52493i;
    public int j;
    public int k;
    public int l;

    /* renamed from: d.a.p0.d1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1194a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f52494e;

        public RunnableC1194a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52494e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52494e.f52493i || !this.f52494e.f52492h || this.f52494e.f52486b == null) {
                return;
            }
            this.f52494e.f52486b.k();
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void O(float f2, float f3);

        void j();

        void k();
    }

    public a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52485a = view;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
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
            if (this.f52487c == null) {
                this.f52487c = VelocityTracker.obtain();
            }
            this.f52487c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f52488d = motionEvent.getX();
                this.f52489e = motionEvent.getY();
                this.f52490f = System.currentTimeMillis();
                this.f52492h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f52490f < 100 && currentTimeMillis - this.f52491g < 500) {
                    this.f52493i = true;
                } else {
                    this.f52493i = false;
                }
                VelocityTracker velocityTracker = this.f52487c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f52489e - motionEvent.getY()) > 50.0f) {
                    this.f52493i = false;
                    this.f52492h = false;
                }
                if (this.f52493i) {
                    b bVar2 = this.f52486b;
                    if (bVar2 != null) {
                        bVar2.O(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f52488d - motionEvent.getX()) > this.l && (this.f52488d - motionEvent.getX()) - 50.0f > Math.abs(this.f52489e - motionEvent.getY()) && (bVar = this.f52486b) != null) {
                    bVar.j();
                }
                if (!this.f52493i && this.f52492h && Math.abs(this.f52488d - motionEvent.getX()) < 30.0f && Math.abs(this.f52489e - motionEvent.getY()) < 30.0f) {
                    this.f52485a.postDelayed(new RunnableC1194a(this), 300L);
                }
                this.f52491g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f52487c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f52487c.recycle();
        this.f52487c = null;
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f52486b = bVar;
        }
    }
}
