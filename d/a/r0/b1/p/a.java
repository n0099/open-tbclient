package d.a.r0.b1.p;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f55117a;

    /* renamed from: b  reason: collision with root package name */
    public b f55118b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f55119c;

    /* renamed from: d  reason: collision with root package name */
    public float f55120d;

    /* renamed from: e  reason: collision with root package name */
    public float f55121e;

    /* renamed from: f  reason: collision with root package name */
    public long f55122f;

    /* renamed from: g  reason: collision with root package name */
    public long f55123g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55124h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55125i;
    public int j;
    public int k;
    public int l;

    /* renamed from: d.a.r0.b1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1234a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f55126e;

        public RunnableC1234a(a aVar) {
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
            this.f55126e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55126e.f55125i || !this.f55126e.f55124h || this.f55126e.f55118b == null) {
                return;
            }
            this.f55126e.f55118b.l();
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void N(float f2, float f3);

        void k();

        void l();
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
        this.f55117a = view;
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
            if (this.f55119c == null) {
                this.f55119c = VelocityTracker.obtain();
            }
            this.f55119c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f55120d = motionEvent.getX();
                this.f55121e = motionEvent.getY();
                this.f55122f = System.currentTimeMillis();
                this.f55124h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f55122f < 100 && currentTimeMillis - this.f55123g < 500) {
                    this.f55125i = true;
                } else {
                    this.f55125i = false;
                }
                VelocityTracker velocityTracker = this.f55119c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f55121e - motionEvent.getY()) > 50.0f) {
                    this.f55125i = false;
                    this.f55124h = false;
                }
                if (this.f55125i) {
                    b bVar2 = this.f55118b;
                    if (bVar2 != null) {
                        bVar2.N(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f55120d - motionEvent.getX()) > this.l && (this.f55120d - motionEvent.getX()) - 50.0f > Math.abs(this.f55121e - motionEvent.getY()) && (bVar = this.f55118b) != null) {
                    bVar.k();
                }
                if (!this.f55125i && this.f55124h && Math.abs(this.f55120d - motionEvent.getX()) < 30.0f && Math.abs(this.f55121e - motionEvent.getY()) < 30.0f) {
                    this.f55117a.postDelayed(new RunnableC1234a(this), 300L);
                }
                this.f55123g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f55119c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f55119c.recycle();
        this.f55119c = null;
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f55118b = bVar;
        }
    }
}
