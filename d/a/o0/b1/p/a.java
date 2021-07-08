package d.a.o0.b1.p;

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
    public View f51822a;

    /* renamed from: b  reason: collision with root package name */
    public b f51823b;

    /* renamed from: c  reason: collision with root package name */
    public VelocityTracker f51824c;

    /* renamed from: d  reason: collision with root package name */
    public float f51825d;

    /* renamed from: e  reason: collision with root package name */
    public float f51826e;

    /* renamed from: f  reason: collision with root package name */
    public long f51827f;

    /* renamed from: g  reason: collision with root package name */
    public long f51828g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51829h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f51830i;
    public int j;
    public int k;
    public int l;

    /* renamed from: d.a.o0.b1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1183a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f51831e;

        public RunnableC1183a(a aVar) {
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
            this.f51831e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51831e.f51830i || !this.f51831e.f51829h || this.f51831e.f51823b == null) {
                return;
            }
            this.f51831e.f51823b.k();
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void N(float f2, float f3);

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
        this.f51822a = view;
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
            if (this.f51824c == null) {
                this.f51824c = VelocityTracker.obtain();
            }
            this.f51824c.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f51825d = motionEvent.getX();
                this.f51826e = motionEvent.getY();
                this.f51827f = System.currentTimeMillis();
                this.f51829h = true;
            } else if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f51827f < 100 && currentTimeMillis - this.f51828g < 500) {
                    this.f51830i = true;
                } else {
                    this.f51830i = false;
                }
                VelocityTracker velocityTracker = this.f51824c;
                velocityTracker.computeCurrentVelocity(1000, this.k);
                if (Math.abs(velocityTracker.getYVelocity()) > this.j && Math.abs(this.f51826e - motionEvent.getY()) > 50.0f) {
                    this.f51830i = false;
                    this.f51829h = false;
                }
                if (this.f51830i) {
                    b bVar2 = this.f51823b;
                    if (bVar2 != null) {
                        bVar2.N(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.f51825d - motionEvent.getX()) > this.l && (this.f51825d - motionEvent.getX()) - 50.0f > Math.abs(this.f51826e - motionEvent.getY()) && (bVar = this.f51823b) != null) {
                    bVar.j();
                }
                if (!this.f51830i && this.f51829h && Math.abs(this.f51825d - motionEvent.getX()) < 30.0f && Math.abs(this.f51826e - motionEvent.getY()) < 30.0f) {
                    this.f51822a.postDelayed(new RunnableC1183a(this), 300L);
                }
                this.f51828g = currentTimeMillis;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.f51824c) == null) {
            return;
        }
        velocityTracker.clear();
        this.f51824c.recycle();
        this.f51824c = null;
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f51823b = bVar;
        }
    }
}
