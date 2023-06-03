package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0004*\u00020\u0005H\u0007¢\u0006\u0002\b\u0003\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0001*\u0010\b\u0007\u0010\u0007\"\u00020\u00042\u00020\u0004B\u0002\b\b¨\u0006\t"}, d2 = {"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "from", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/ExecutorService;", "asExecutor", "CloseableCoroutineDispatcher", "Lkotlinx/coroutines/ExperimentalCoroutinesApi;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class ExecutorsKt {
    @ExperimentalCoroutinesApi
    public static /* synthetic */ void CloseableCoroutineDispatcher$annotations() {
    }

    public static final Executor asExecutor(CoroutineDispatcher coroutineDispatcher) {
        ExecutorCoroutineDispatcher executorCoroutineDispatcher;
        Executor executor = null;
        if (coroutineDispatcher instanceof ExecutorCoroutineDispatcher) {
            executorCoroutineDispatcher = (ExecutorCoroutineDispatcher) coroutineDispatcher;
        } else {
            executorCoroutineDispatcher = null;
        }
        if (executorCoroutineDispatcher != null) {
            executor = executorCoroutineDispatcher.getExecutor();
        }
        if (executor == null) {
            return new DispatcherExecutor(coroutineDispatcher);
        }
        return executor;
    }

    @JvmName(name = "from")
    public static final CoroutineDispatcher from(Executor executor) {
        DispatcherExecutor dispatcherExecutor;
        CoroutineDispatcher coroutineDispatcher = null;
        if (executor instanceof DispatcherExecutor) {
            dispatcherExecutor = (DispatcherExecutor) executor;
        } else {
            dispatcherExecutor = null;
        }
        if (dispatcherExecutor != null) {
            coroutineDispatcher = dispatcherExecutor.dispatcher;
        }
        if (coroutineDispatcher == null) {
            return new ExecutorCoroutineDispatcherImpl(executor);
        }
        return coroutineDispatcher;
    }

    @JvmName(name = "from")
    public static final ExecutorCoroutineDispatcher from(ExecutorService executorService) {
        return new ExecutorCoroutineDispatcherImpl(executorService);
    }
}
