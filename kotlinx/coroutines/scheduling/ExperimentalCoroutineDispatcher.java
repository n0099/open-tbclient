package kotlinx.coroutines.scheduling;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.InternalCoroutinesApi;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001B'\b\u0016\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u0012\b\b\u0002\u00103\u001a\u00020#¢\u0006\u0004\b5\u00106B\u001d\b\u0017\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0002¢\u0006\u0004\b5\u00107B)\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u00102\u001a\u00020\u0002\u0012\u0006\u00100\u001a\u00020\u001e\u0012\b\b\u0002\u00103\u001a\u00020#¢\u0006\u0004\b5\u00108J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0019\u001a\u00020\u00072\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u000e\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0013J\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u001c\u0010\tJ\u0017\u0010\"\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020\u0007H\u0000¢\u0006\u0004\b&\u0010\tR\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00100\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010)R\u0016\u00103\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00069"}, d2 = {"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "", "parallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "blocking", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "", IntentConfig.CLOSE, "()V", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "createScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "Lkotlinx/coroutines/scheduling/TaskContext;", "", "tailDispatch", "dispatchWithContext$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "dispatchWithContext", "dispatchYield", "limited", "restore$kotlinx_coroutines_core", "restore", "", "timeout", "shutdown$kotlinx_coroutines_core", "(J)V", "shutdown", "", "toString", "()Ljava/lang/String;", "usePrivateScheduler$kotlinx_coroutines_core", "usePrivateScheduler", "corePoolSize", "I", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "idleWorkerKeepAliveNs", "J", "maxPoolSize", "schedulerName", "Ljava/lang/String;", "<init>", "(IILjava/lang/String;)V", "(II)V", "(IIJLjava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public class ExperimentalCoroutineDispatcher extends ExecutorCoroutineDispatcher {
    public final int corePoolSize;
    public CoroutineScheduler coroutineScheduler;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    public final String schedulerName;

    public /* synthetic */ ExperimentalCoroutineDispatcher(int i2, int i3, long j, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, j, (i4 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public static /* synthetic */ CoroutineDispatcher blocking$default(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i2 = TasksKt.BLOCKING_DEFAULT_PARALLELISM;
            }
            return experimentalCoroutineDispatcher.blocking(i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
    }

    private final CoroutineScheduler createScheduler() {
        return new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, this.schedulerName);
    }

    public final CoroutineDispatcher blocking(int i2) {
        if (i2 > 0) {
            return new LimitingDispatcher(this, i2, 1);
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i2).toString());
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.coroutineScheduler.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.dispatch(coroutineContext, runnable);
        }
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(Runnable runnable, TaskContext taskContext, boolean z) {
        try {
            this.coroutineScheduler.dispatch(runnable, taskContext, z);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.enqueue(this.coroutineScheduler.createTask$kotlinx_coroutines_core(runnable, taskContext));
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.dispatchYield(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor getExecutor() {
        return this.coroutineScheduler;
    }

    public final CoroutineDispatcher limited(int i2) {
        if (i2 > 0) {
            if (i2 <= this.corePoolSize) {
                return new LimitingDispatcher(this, i2, 0);
            }
            throw new IllegalArgumentException(("Expected parallelism level lesser than core pool size (" + this.corePoolSize + "), but have " + i2).toString());
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i2).toString());
    }

    public final void restore$kotlinx_coroutines_core() {
        usePrivateScheduler$kotlinx_coroutines_core();
    }

    public final synchronized void shutdown$kotlinx_coroutines_core(long j) {
        this.coroutineScheduler.shutdown(j);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return super.toString() + "[scheduler = " + this.coroutineScheduler + ']';
    }

    public final synchronized void usePrivateScheduler$kotlinx_coroutines_core() {
        this.coroutineScheduler.shutdown(1000L);
        this.coroutineScheduler = createScheduler();
    }

    public ExperimentalCoroutineDispatcher(int i2, int i3, long j, String str) {
        this.corePoolSize = i2;
        this.maxPoolSize = i3;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        this.coroutineScheduler = createScheduler();
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int i2, int i3, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? TasksKt.CORE_POOL_SIZE : i2, (i4 & 2) != 0 ? TasksKt.MAX_POOL_SIZE : i3, (i4 & 4) != 0 ? TasksKt.DEFAULT_SCHEDULER_NAME : str);
    }

    public ExperimentalCoroutineDispatcher(int i2, int i3, String str) {
        this(i2, i3, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, str);
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? TasksKt.CORE_POOL_SIZE : i2, (i4 & 2) != 0 ? TasksKt.MAX_POOL_SIZE : i3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ ExperimentalCoroutineDispatcher(int i2, int i3) {
        this(i2, i3, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, null, 8, null);
    }
}
