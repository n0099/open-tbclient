package kotlinx.coroutines.scheduling;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010)\u001a\u00020!¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J#\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\r\u001a\u00020\u00042\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\r\u0010\u0011J#\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u001b\u0010\u0014\u001a\u00020\u00042\n\u0010\u0013\u001a\u00060\nj\u0002`\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001a\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R \u0010'\u001a\f\u0012\b\u0012\u00060\nj\u0002`\u000b0&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010)\u001a\u00020!8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%¨\u0006-"}, d2 = {"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "", "afterTask", "()V", IntentConfig.CLOSE, "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "", "parallelism", "I", "getParallelism", "()I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "taskMode", "getTaskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;II)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class LimitingDispatcher extends ExecutorCoroutineDispatcher implements TaskContext, Executor {
    public static final AtomicIntegerFieldUpdater inFlightTasks$FU = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, "inFlightTasks");
    public final ExperimentalCoroutineDispatcher dispatcher;
    public final int parallelism;
    public final int taskMode;
    public final ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();
    public volatile int inFlightTasks = 0;

    public LimitingDispatcher(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i2, int i3) {
        this.dispatcher = experimentalCoroutineDispatcher;
        this.parallelism = i2;
        this.taskMode = i3;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
        Runnable poll = this.queue.poll();
        if (poll != null) {
            this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(poll, this, true);
            return;
        }
        inFlightTasks$FU.decrementAndGet(this);
        Runnable poll2 = this.queue.poll();
        if (poll2 != null) {
            dispatch(poll2, true);
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        dispatch(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        dispatch(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        dispatch(runnable, false);
    }

    public final ExperimentalCoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor getExecutor() {
        return this;
    }

    public final int getParallelism() {
        return this.parallelism;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return this.taskMode;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return super.toString() + "[dispatcher = " + this.dispatcher + ']';
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void dispatch(Runnable runnable, boolean z) {
        while (inFlightTasks$FU.incrementAndGet(this) > this.parallelism) {
            this.queue.add(runnable);
            if (inFlightTasks$FU.decrementAndGet(this) >= this.parallelism || (runnable = this.queue.poll()) == null) {
                return;
            }
            while (inFlightTasks$FU.incrementAndGet(this) > this.parallelism) {
            }
        }
        this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(runnable, this, z);
    }
}
