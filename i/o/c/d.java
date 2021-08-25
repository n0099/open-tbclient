package i.o.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.GenericScheduledExecutorServiceFactory;
/* loaded from: classes10.dex */
public final class d implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final ScheduledExecutorService[] f78561f;

    /* renamed from: g  reason: collision with root package name */
    public static final ScheduledExecutorService f78562g;

    /* renamed from: h  reason: collision with root package name */
    public static final d f78563h;

    /* renamed from: i  reason: collision with root package name */
    public static int f78564i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<ScheduledExecutorService[]> f78565e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(371144661, "Li/o/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(371144661, "Li/o/c/d;");
                return;
            }
        }
        f78561f = new ScheduledExecutorService[0];
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f78562g = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f78563h = new d();
    }

    public d() {
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
        this.f78565e = new AtomicReference<>(f78561f);
        start();
    }

    public static ScheduledExecutorService a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ScheduledExecutorService[] scheduledExecutorServiceArr = f78563h.f78565e.get();
            if (scheduledExecutorServiceArr == f78561f) {
                return f78562g;
            }
            int i2 = f78564i + 1;
            if (i2 >= scheduledExecutorServiceArr.length) {
                i2 = 0;
            }
            f78564i = i2;
            return scheduledExecutorServiceArr[i2];
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    @Override // i.o.c.h
    public void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            do {
                scheduledExecutorServiceArr = this.f78565e.get();
                scheduledExecutorServiceArr2 = f78561f;
                if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                    return;
                }
            } while (!this.f78565e.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
            for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
                g.d(scheduledExecutorService);
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    @Override // i.o.c.h
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            if (availableProcessors > 4) {
                availableProcessors /= 2;
            }
            if (availableProcessors > 8) {
                availableProcessors = 8;
            }
            ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[availableProcessors];
            int i2 = 0;
            for (int i3 = 0; i3 < availableProcessors; i3++) {
                scheduledExecutorServiceArr[i3] = GenericScheduledExecutorServiceFactory.create();
            }
            if (!this.f78565e.compareAndSet(f78561f, scheduledExecutorServiceArr)) {
                while (i2 < availableProcessors) {
                    scheduledExecutorServiceArr[i2].shutdownNow();
                    i2++;
                }
                return;
            }
            while (i2 < availableProcessors) {
                ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr[i2];
                if (!g.k(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    g.g((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
                i2++;
            }
        }
    }
}
