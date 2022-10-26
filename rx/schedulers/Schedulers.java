package rx.schedulers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a0a;
import com.baidu.tieba.ay9;
import com.baidu.tieba.e2a;
import com.baidu.tieba.h2a;
import com.baidu.tieba.i2a;
import com.baidu.tieba.tz9;
import com.baidu.tieba.uz9;
import com.baidu.tieba.vz9;
import com.baidu.tieba.yz9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class Schedulers {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference d;
    public transient /* synthetic */ FieldHolder $fh;
    public final ay9 a;
    public final ay9 b;
    public final ay9 c;

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
        d = new AtomicReference();
    }

    public static ay9 computation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return e2a.f(a().a);
        }
        return (ay9) invokeV.objValue;
    }

    public static ay9 immediate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return vz9.a;
        }
        return (ay9) invokeV.objValue;
    }

    public static ay9 io() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return e2a.k(a().b);
        }
        return (ay9) invokeV.objValue;
    }

    public static ay9 newThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return e2a.l(a().c);
        }
        return (ay9) invokeV.objValue;
    }

    public static void reset() {
        Schedulers schedulers;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, null) == null) && (schedulers = (Schedulers) d.getAndSet(null)) != null) {
            schedulers.b();
        }
    }

    public static void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            Schedulers a = a();
            a.b();
            synchronized (a) {
                uz9.d.shutdown();
            }
        }
    }

    public static void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            Schedulers a = a();
            a.c();
            synchronized (a) {
                uz9.d.start();
            }
        }
    }

    public static TestScheduler test() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return new TestScheduler();
        }
        return (TestScheduler) invokeV.objValue;
    }

    public static ay9 trampoline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return a0a.a;
        }
        return (ay9) invokeV.objValue;
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
        i2a f = h2a.c().f();
        ay9 g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = i2a.a();
        }
        ay9 i3 = f.i();
        if (i3 != null) {
            this.b = i3;
        } else {
            this.b = i2a.c();
        }
        ay9 j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = i2a.e();
        }
    }

    public static Schedulers a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, null)) != null) {
            return (Schedulers) invokeV.objValue;
        }
        while (true) {
            Schedulers schedulers = (Schedulers) d.get();
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

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.a instanceof yz9) {
                    ((yz9) this.a).shutdown();
                }
                if (this.b instanceof yz9) {
                    ((yz9) this.b).shutdown();
                }
                if (this.c instanceof yz9) {
                    ((yz9) this.c).shutdown();
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.a instanceof yz9) {
                    ((yz9) this.a).start();
                }
                if (this.b instanceof yz9) {
                    ((yz9) this.b).start();
                }
                if (this.c instanceof yz9) {
                    ((yz9) this.c).start();
                }
            }
        }
    }

    public static ay9 from(Executor executor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, executor)) == null) {
            return new tz9(executor);
        }
        return (ay9) invokeL.objValue;
    }
}
