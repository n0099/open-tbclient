package kotlinx.coroutines;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import org.aspectj.runtime.reflect.SignatureImpl;
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", "", "name", "", "newSingleThreadContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ThreadPoolDispatcherKt {
    @DelicateCoroutinesApi
    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(final int i, final String str) {
        boolean z = true;
        if (i < 1) {
            z = false;
        }
        if (z) {
            final AtomicInteger atomicInteger = new AtomicInteger();
            return ExecutorsKt.from((ExecutorService) Executors.newScheduledThreadPool(i, new ThreadFactory() { // from class: com.baidu.tieba.flc
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) ? ThreadPoolDispatcherKt.m2300newFixedThreadPoolContext$lambda1(i, str, atomicInteger, runnable) : (Thread) invokeL.objValue;
                }
            }));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i + " specified").toString());
    }

    /* renamed from: newFixedThreadPoolContext$lambda-1  reason: not valid java name */
    public static final Thread m2300newFixedThreadPoolContext$lambda1(int i, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i != 1) {
            str = str + SignatureImpl.SEP + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }

    @DelicateCoroutinesApi
    public static final ExecutorCoroutineDispatcher newSingleThreadContext(String str) {
        return newFixedThreadPoolContext(1, str);
    }
}
