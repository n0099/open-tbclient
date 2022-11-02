package rx.schedulers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c1a;
import com.baidu.tieba.d1a;
import com.baidu.tieba.e1a;
import com.baidu.tieba.h1a;
import com.baidu.tieba.j1a;
import com.baidu.tieba.jz9;
import com.baidu.tieba.n3a;
import com.baidu.tieba.q3a;
import com.baidu.tieba.r3a;
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
    public final jz9 a;
    public final jz9 b;
    public final jz9 c;

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

    public static jz9 computation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return n3a.f(a().a);
        }
        return (jz9) invokeV.objValue;
    }

    public static jz9 immediate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return e1a.a;
        }
        return (jz9) invokeV.objValue;
    }

    public static jz9 io() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return n3a.k(a().b);
        }
        return (jz9) invokeV.objValue;
    }

    public static jz9 newThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return n3a.l(a().c);
        }
        return (jz9) invokeV.objValue;
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
                d1a.d.shutdown();
            }
        }
    }

    public static void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            Schedulers a = a();
            a.c();
            synchronized (a) {
                d1a.d.start();
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

    public static jz9 trampoline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return j1a.a;
        }
        return (jz9) invokeV.objValue;
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
        r3a f = q3a.c().f();
        jz9 g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = r3a.a();
        }
        jz9 i3 = f.i();
        if (i3 != null) {
            this.b = i3;
        } else {
            this.b = r3a.c();
        }
        jz9 j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = r3a.e();
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
                if (this.a instanceof h1a) {
                    ((h1a) this.a).shutdown();
                }
                if (this.b instanceof h1a) {
                    ((h1a) this.b).shutdown();
                }
                if (this.c instanceof h1a) {
                    ((h1a) this.c).shutdown();
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.a instanceof h1a) {
                    ((h1a) this.a).start();
                }
                if (this.b instanceof h1a) {
                    ((h1a) this.b).start();
                }
                if (this.c instanceof h1a) {
                    ((h1a) this.c).start();
                }
            }
        }
    }

    public static jz9 from(Executor executor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, executor)) == null) {
            return new c1a(executor);
        }
        return (jz9) invokeL.objValue;
    }
}
