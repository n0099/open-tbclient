package rx.schedulers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bw9;
import com.repackage.ew9;
import com.repackage.fw9;
import com.repackage.qt9;
import com.repackage.rt9;
import com.repackage.st9;
import com.repackage.vt9;
import com.repackage.xr9;
import com.repackage.xt9;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class Schedulers {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<Schedulers> d;
    public transient /* synthetic */ FieldHolder $fh;
    public final xr9 a;
    public final xr9 b;
    public final xr9 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1980950871, "Lrx/schedulers/Schedulers;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1980950871, "Lrx/schedulers/Schedulers;");
                return;
            }
        }
        d = new AtomicReference<>();
    }

    public Schedulers() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        fw9 f = ew9.c().f();
        xr9 g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = fw9.a();
        }
        xr9 i3 = f.i();
        if (i3 != null) {
            this.b = i3;
        } else {
            this.b = fw9.c();
        }
        xr9 j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = fw9.e();
        }
    }

    public static Schedulers a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, null)) != null) {
            return (Schedulers) invokeV.objValue;
        }
        while (true) {
            Schedulers schedulers = d.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (d.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.b();
        }
    }

    public static xr9 computation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? bw9.f(a().a) : (xr9) invokeV.objValue;
    }

    public static xr9 from(Executor executor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, executor)) == null) ? new qt9(executor) : (xr9) invokeL.objValue;
    }

    public static xr9 immediate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? st9.a : (xr9) invokeV.objValue;
    }

    public static xr9 io() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? bw9.k(a().b) : (xr9) invokeV.objValue;
    }

    public static xr9 newThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? bw9.l(a().c) : (xr9) invokeV.objValue;
    }

    public static void reset() {
        Schedulers andSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || (andSet = d.getAndSet(null)) == null) {
            return;
        }
        andSet.b();
    }

    public static void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            Schedulers a = a();
            a.b();
            synchronized (a) {
                rt9.d.shutdown();
            }
        }
    }

    public static void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            Schedulers a = a();
            a.c();
            synchronized (a) {
                rt9.d.start();
            }
        }
    }

    public static TestScheduler test() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? new TestScheduler() : (TestScheduler) invokeV.objValue;
    }

    public static xr9 trampoline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? xt9.a : (xr9) invokeV.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.a instanceof vt9) {
                    ((vt9) this.a).shutdown();
                }
                if (this.b instanceof vt9) {
                    ((vt9) this.b).shutdown();
                }
                if (this.c instanceof vt9) {
                    ((vt9) this.c).shutdown();
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.a instanceof vt9) {
                    ((vt9) this.a).start();
                }
                if (this.b instanceof vt9) {
                    ((vt9) this.b).start();
                }
                if (this.c instanceof vt9) {
                    ((vt9) this.c).start();
                }
            }
        }
    }
}
