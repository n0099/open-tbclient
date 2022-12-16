package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0006*\u00020\u0005H\u0007¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "from", "(Ljava/util/concurrent/Executor;)Lkotlinx/coroutines/CoroutineDispatcher;", "asCoroutineDispatcher", "Ljava/util/concurrent/ExecutorService;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "(Ljava/util/concurrent/ExecutorService;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "asExecutor", "(Lkotlinx/coroutines/CoroutineDispatcher;)Ljava/util/concurrent/Executor;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class ExecutorsKt {
    public static final Executor asExecutor(CoroutineDispatcher coroutineDispatcher) {
        CoroutineDispatcher coroutineDispatcher2;
        Executor executor;
        if (!(coroutineDispatcher instanceof ExecutorCoroutineDispatcher)) {
            coroutineDispatcher2 = null;
        } else {
            coroutineDispatcher2 = coroutineDispatcher;
        }
        ExecutorCoroutineDispatcher executorCoroutineDispatcher = (ExecutorCoroutineDispatcher) coroutineDispatcher2;
        if (executorCoroutineDispatcher == null || (executor = executorCoroutineDispatcher.getExecutor()) == null) {
            return new DispatcherExecutor(coroutineDispatcher);
        }
        return executor;
    }

    @JvmName(name = "from")
    public static final CoroutineDispatcher from(Executor executor) {
        Executor executor2;
        CoroutineDispatcher coroutineDispatcher;
        if (!(executor instanceof DispatcherExecutor)) {
            executor2 = null;
        } else {
            executor2 = executor;
        }
        DispatcherExecutor dispatcherExecutor = (DispatcherExecutor) executor2;
        if (dispatcherExecutor == null || (coroutineDispatcher = dispatcherExecutor.dispatcher) == null) {
            return new ExecutorCoroutineDispatcherImpl(executor);
        }
        return coroutineDispatcher;
    }

    @JvmName(name = "from")
    public static final ExecutorCoroutineDispatcher from(ExecutorService executorService) {
        return new ExecutorCoroutineDispatcherImpl(executorService);
    }
}
