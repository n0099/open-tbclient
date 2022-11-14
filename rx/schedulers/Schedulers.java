package rx.schedulers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b4a;
import com.baidu.tieba.c4a;
import com.baidu.tieba.n1a;
import com.baidu.tieba.o1a;
import com.baidu.tieba.p1a;
import com.baidu.tieba.s1a;
import com.baidu.tieba.u1a;
import com.baidu.tieba.uz9;
import com.baidu.tieba.y3a;
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
    public static final AtomicReference<Schedulers> d;
    public transient /* synthetic */ FieldHolder $fh;
    public final uz9 a;
    public final uz9 b;
    public final uz9 c;

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

    public static uz9 computation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return y3a.f(a().a);
        }
        return (uz9) invokeV.objValue;
    }

    public static uz9 immediate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return p1a.a;
        }
        return (uz9) invokeV.objValue;
    }

    public static uz9 io() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return y3a.k(a().b);
        }
        return (uz9) invokeV.objValue;
    }

    public static uz9 newThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return y3a.l(a().c);
        }
        return (uz9) invokeV.objValue;
    }

    public static void reset() {
        Schedulers andSet;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, null) == null) && (andSet = d.getAndSet(null)) != null) {
            andSet.b();
        }
    }

    public static void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            Schedulers a = a();
            a.b();
            synchronized (a) {
                o1a.d.shutdown();
            }
        }
    }

    public static void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            Schedulers a = a();
            a.c();
            synchronized (a) {
                o1a.d.start();
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

    public static uz9 trampoline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return u1a.a;
        }
        return (uz9) invokeV.objValue;
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
        c4a f = b4a.c().f();
        uz9 g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = c4a.a();
        }
        uz9 i3 = f.i();
        if (i3 != null) {
            this.b = i3;
        } else {
            this.b = c4a.c();
        }
        uz9 j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = c4a.e();
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

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.a instanceof s1a) {
                    ((s1a) this.a).shutdown();
                }
                if (this.b instanceof s1a) {
                    ((s1a) this.b).shutdown();
                }
                if (this.c instanceof s1a) {
                    ((s1a) this.c).shutdown();
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.a instanceof s1a) {
                    ((s1a) this.a).start();
                }
                if (this.b instanceof s1a) {
                    ((s1a) this.b).start();
                }
                if (this.c instanceof s1a) {
                    ((s1a) this.c).start();
                }
            }
        }
    }

    public static uz9 from(Executor executor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, executor)) == null) {
            return new n1a(executor);
        }
        return (uz9) invokeL.objValue;
    }
}
