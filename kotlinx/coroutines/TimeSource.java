package kotlinx.coroutines;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH&¢\u0006\u0004\b\u0014\u0010\rJ\u001f\u0010\u0018\u001a\u00060\u0015j\u0002`\u00162\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/TimeSource;", "Lkotlin/Any;", "", "currentTimeMillis", "()J", "nanoTime", "", "blocker", "nanos", "", "parkNanos", "(Ljava/lang/Object;J)V", "registerTimeLoopThread", "()V", "trackTask", "unTrackTask", "Ljava/lang/Thread;", "thread", "unpark", "(Ljava/lang/Thread;)V", "unregisterTimeLoopThread", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "wrapTask", "(Ljava/lang/Runnable;)Ljava/lang/Runnable;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface TimeSource {
    long currentTimeMillis();

    long nanoTime();

    void parkNanos(Object obj, long j2);

    void registerTimeLoopThread();

    void trackTask();

    void unTrackTask();

    void unpark(Thread thread);

    void unregisterTimeLoopThread();

    Runnable wrapTask(Runnable runnable);
}
