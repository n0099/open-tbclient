package rx.schedulers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.g;
import h.o.c.d;
import h.o.c.e;
import h.o.c.h;
import h.o.c.j;
import h.r.c;
import h.r.f;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class Schedulers {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicReference<Schedulers> f72694d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final g f72695a;

    /* renamed from: b  reason: collision with root package name */
    public final g f72696b;

    /* renamed from: c  reason: collision with root package name */
    public final g f72697c;

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
        f72694d = new AtomicReference<>();
    }

    public Schedulers() {
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
        h.r.g f2 = f.c().f();
        g g2 = f2.g();
        if (g2 != null) {
            this.f72695a = g2;
        } else {
            this.f72695a = h.r.g.a();
        }
        g i4 = f2.i();
        if (i4 != null) {
            this.f72696b = i4;
        } else {
            this.f72696b = h.r.g.c();
        }
        g j = f2.j();
        if (j != null) {
            this.f72697c = j;
        } else {
            this.f72697c = h.r.g.e();
        }
    }

    public static Schedulers a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, null)) != null) {
            return (Schedulers) invokeV.objValue;
        }
        while (true) {
            Schedulers schedulers = f72694d.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (f72694d.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.b();
        }
    }

    public static g computation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.f(a().f72695a) : (g) invokeV.objValue;
    }

    public static g from(Executor executor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, executor)) == null) ? new h.o.c.c(executor) : (g) invokeL.objValue;
    }

    public static g immediate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? e.f72044a : (g) invokeV.objValue;
    }

    public static g io() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? c.k(a().f72696b) : (g) invokeV.objValue;
    }

    public static g newThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c.l(a().f72697c) : (g) invokeV.objValue;
    }

    public static void reset() {
        Schedulers andSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || (andSet = f72694d.getAndSet(null)) == null) {
            return;
        }
        andSet.b();
    }

    public static void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            Schedulers a2 = a();
            a2.b();
            synchronized (a2) {
                d.f72041h.shutdown();
            }
        }
    }

    public static void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            Schedulers a2 = a();
            a2.c();
            synchronized (a2) {
                d.f72041h.start();
            }
        }
    }

    public static TestScheduler test() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? new TestScheduler() : (TestScheduler) invokeV.objValue;
    }

    public static g trampoline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? j.f72056a : (g) invokeV.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.f72695a instanceof h) {
                    ((h) this.f72695a).shutdown();
                }
                if (this.f72696b instanceof h) {
                    ((h) this.f72696b).shutdown();
                }
                if (this.f72697c instanceof h) {
                    ((h) this.f72697c).shutdown();
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f72695a instanceof h) {
                    ((h) this.f72695a).start();
                }
                if (this.f72696b instanceof h) {
                    ((h) this.f72696b).start();
                }
                if (this.f72697c instanceof h) {
                    ((h) this.f72697c).start();
                }
            }
        }
    }
}
