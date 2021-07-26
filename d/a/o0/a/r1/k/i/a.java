package d.a.o0.a.r1.k.i;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.d;
import d.a.o0.a.r1.l.e;
import d.a.o0.a.v2.q0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class a implements d.a.o0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f47622f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f47623g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47624b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47625c;

    /* renamed from: d  reason: collision with root package name */
    public List<Runnable> f47626d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.a.r1.r.c.a f47627e;

    /* renamed from: d.a.o0.a.r1.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0885a implements d.a.o0.a.r1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f47628b;

        public C0885a(a aVar) {
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
            this.f47628b = aVar;
        }

        @Override // d.a.o0.a.r1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // d.a.o0.a.r1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f47628b.f47624b = false;
                this.f47628b.l();
                this.f47628b.f47625c = false;
            }
        }

        @Override // d.a.o0.a.r1.r.c.a
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f47628b.f47624b = false;
                this.f47628b.l();
                this.f47628b.p();
            }
        }

        @Override // d.a.o0.a.r1.r.c.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f47628b.f47624b = true;
                this.f47628b.o();
                this.f47628b.q();
            }
        }

        @Override // d.a.o0.a.r1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "IdleHandler" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47629a;

        public b(a aVar) {
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
            this.f47629a = aVar;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f47629a.f47624b) {
                    if (a.f47623g) {
                        this.f47629a.m();
                    }
                } else {
                    this.f47629a.l();
                }
                return this.f47629a.f47624b;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f47630a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1300632222, "Ld/a/o0/a/r1/k/i/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1300632222, "Ld/a/o0/a/r1/k/i/a$c;");
                    return;
                }
            }
            f47630a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1275095037, "Ld/a/o0/a/r1/k/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1275095037, "Ld/a/o0/a/r1/k/i/a;");
                return;
            }
        }
        int f2 = e.f();
        f47622f = f2;
        f47623g = f2 % 10 == 1;
    }

    public /* synthetic */ a(C0885a c0885a) {
        this();
    }

    public static a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? c.f47630a : (a) invokeV.objValue;
    }

    public boolean j(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            if (runnable == null) {
                return false;
            }
            if (f47622f > 0 && this.f47624b) {
                this.f47626d.add(runnable);
                return true;
            }
            q0.X(runnable);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f47626d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (Runnable runnable : this.f47626d) {
            d.i().post(runnable);
        }
        if (d.a.o0.a.f1.f.a.f44988a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "idle handle all, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f47626d.size());
        }
        this.f47626d.clear();
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f47626d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Runnable remove = this.f47626d.remove(0);
        if (remove != null) {
            d.i().post(remove);
        }
        if (d.a.o0.a.f1.f.a.f44988a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "idle handle one, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f47626d.size());
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f47622f > 0) {
                d.a.o0.a.r1.r.a.f().h(this.f47627e, f47622f);
                this.f47624b = true;
            } else if (d.a.o0.a.f1.f.a.f44988a) {
                Log.e("SwanPerformance", "idle handler can't register. ab is closed");
            }
            q();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Looper.getMainLooper();
            Looper.myQueue().addIdleHandler(new b(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f47625c) {
            this.f47625c = false;
            d.a.o0.a.c1.a.g0().a();
            if (d.a.o0.a.f1.f.a.f44988a) {
                Log.d("SwanPerformance", "YaLog notify");
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f47625c) {
            return;
        }
        this.f47625c = true;
        int o = e.o();
        d.a.o0.a.c1.a.g0().b(o);
        if (d.a.o0.a.f1.f.a.f44988a) {
            Log.d("SwanPerformance", "YaLog block time = " + o);
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47624b = false;
        this.f47625c = false;
        this.f47626d = new CopyOnWriteArrayList();
        this.f47627e = new C0885a(this);
    }
}
