package d.a.w0.a.f;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static List<WeakReference<ScheduledFuture<?>>> f70954a;

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f70955b;

    /* renamed from: c  reason: collision with root package name */
    public static ScheduledExecutorService f70956c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1419795103, "Ld/a/w0/a/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1419795103, "Ld/a/w0/a/f/b;");
                return;
            }
        }
        f70954a = new ArrayList();
        f70955b = Executors.newFixedThreadPool(2);
        f70956c = Executors.newScheduledThreadPool(2);
    }

    public static synchronized void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, runnable) == null) {
            synchronized (b.class) {
                if (f70956c == null || f70956c.isShutdown()) {
                    f70956c = Executors.newScheduledThreadPool(2);
                }
                f70956c.execute(runnable);
            }
        }
    }

    public static synchronized void b(Runnable runnable, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{runnable, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            synchronized (b.class) {
                if (f70956c == null || f70956c.isShutdown()) {
                    f70956c = Executors.newScheduledThreadPool(2);
                }
                f70954a.add(new WeakReference<>(f70956c.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
            }
        }
    }

    public static void c(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            ExecutorService executorService = f70955b;
            if (executorService == null || executorService.isShutdown()) {
                f70955b = Executors.newFixedThreadPool(2);
            }
            f70955b.execute(runnable);
        }
    }
}
