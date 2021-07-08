package kotlinx.coroutines;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/ThreadPoolDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "", IntentConfig.CLOSE, "()V", "", "toString", "()Ljava/lang/String;", "Ljava/util/concurrent/Executor;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "", "nThreads", "I", "name", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadNo", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "(ILjava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class ThreadPoolDispatcher extends ExecutorCoroutineDispatcherBase {
    public final Executor executor;
    public final int nThreads;
    public final String name;
    public final AtomicInteger threadNo = new AtomicInteger();

    public ThreadPoolDispatcher(int i2, String str) {
        this.nThreads = i2;
        this.name = str;
        this.executor = Executors.newScheduledThreadPool(this.nThreads, new ThreadFactory() { // from class: kotlinx.coroutines.ThreadPoolDispatcher$executor$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.ThreadFactory
            public final PoolThread newThread(Runnable runnable) {
                int i3;
                String str2;
                AtomicInteger atomicInteger;
                String sb;
                ThreadPoolDispatcher threadPoolDispatcher = ThreadPoolDispatcher.this;
                i3 = threadPoolDispatcher.nThreads;
                if (i3 == 1) {
                    sb = ThreadPoolDispatcher.this.name;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    str2 = ThreadPoolDispatcher.this.name;
                    sb2.append(str2);
                    sb2.append("-");
                    atomicInteger = ThreadPoolDispatcher.this.threadNo;
                    sb2.append(atomicInteger.incrementAndGet());
                    sb = sb2.toString();
                }
                return new PoolThread(threadPoolDispatcher, runnable, sb);
            }
        });
        initFutureCancellation$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executor = getExecutor();
        if (executor == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.concurrent.ExecutorService");
        }
        ((ExecutorService) executor).shutdown();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor getExecutor() {
        return this.executor;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "ThreadPoolDispatcher[" + this.nThreads + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.name + ']';
    }
}
