package kotlinx.coroutines;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0001\u001a\u00020\u0000H\u0081\b¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u0000H\u0081\b¢\u0006\u0004\b\u0003\u0010\u0002\u001a \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0000H\u0081\b¢\u0006\u0004\b\b\u0010\t\u001a\u0010\u0010\n\u001a\u00020\u0007H\u0081\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0010\u0010\f\u001a\u00020\u0007H\u0081\b¢\u0006\u0004\b\f\u0010\u000b\u001a\u0010\u0010\r\u001a\u00020\u0007H\u0081\b¢\u0006\u0004\b\r\u0010\u000b\u001a\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0081\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0010\u0010\u0012\u001a\u00020\u0007H\u0081\b¢\u0006\u0004\b\u0012\u0010\u000b\u001a \u0010\u0016\u001a\u00060\u0013j\u0002`\u00142\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0081\b¢\u0006\u0004\b\u0016\u0010\u0017\"$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"", "currentTimeMillis", "()J", "nanoTime", "", "blocker", "nanos", "", "parkNanos", "(Ljava/lang/Object;J)V", "registerTimeLoopThread", "()V", "trackTask", "unTrackTask", "Ljava/lang/Thread;", "thread", "unpark", "(Ljava/lang/Thread;)V", "unregisterTimeLoopThread", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "wrapTask", "(Ljava/lang/Runnable;)Ljava/lang/Runnable;", "Lkotlinx/coroutines/TimeSource;", "timeSource", "Lkotlinx/coroutines/TimeSource;", "getTimeSource", "()Lkotlinx/coroutines/TimeSource;", "setTimeSource", "(Lkotlinx/coroutines/TimeSource;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class TimeSourceKt {
    public static TimeSource timeSource;

    @InlineOnly
    public static final long currentTimeMillis() {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            return timeSource2.currentTimeMillis();
        }
        return System.currentTimeMillis();
    }

    public static final TimeSource getTimeSource() {
        return timeSource;
    }

    @InlineOnly
    public static final long nanoTime() {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            return timeSource2.nanoTime();
        }
        return System.nanoTime();
    }

    @InlineOnly
    public static final void registerTimeLoopThread() {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.registerTimeLoopThread();
        }
    }

    @InlineOnly
    public static final void trackTask() {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.trackTask();
        }
    }

    @InlineOnly
    public static final void unTrackTask() {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.unTrackTask();
        }
    }

    @InlineOnly
    public static final void unregisterTimeLoopThread() {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.unregisterTimeLoopThread();
        }
    }

    @InlineOnly
    public static final void parkNanos(Object obj, long j) {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.parkNanos(obj, j);
        } else {
            LockSupport.parkNanos(obj, j);
        }
    }

    public static final void setTimeSource(TimeSource timeSource2) {
        timeSource = timeSource2;
    }

    @InlineOnly
    public static final void unpark(Thread thread) {
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.unpark(thread);
        } else {
            LockSupport.unpark(thread);
        }
    }

    @InlineOnly
    public static final Runnable wrapTask(Runnable runnable) {
        Runnable wrapTask;
        TimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null && (wrapTask = timeSource2.wrapTask(runnable)) != null) {
            return wrapTask;
        }
        return runnable;
    }
}
