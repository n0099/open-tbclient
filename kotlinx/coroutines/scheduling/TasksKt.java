package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0016\u0010\u0001\u001a\u00020\u00008\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u00008\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u0016\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0016\u0010\b\u001a\u00020\u00078\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u0016\u0010\n\u001a\u00020\u00008\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0002\"\u0016\u0010\u000b\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0002\"\u0016\u0010\f\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\u0002\"\u0016\u0010\r\u001a\u00020\u00078\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\r\u0010\t\"\u0016\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0013\u001a\u00020\u0012*\u00020\u00118À\u0002@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"", "BLOCKING_DEFAULT_PARALLELISM", "I", "CORE_POOL_SIZE", "", "DEFAULT_SCHEDULER_NAME", "Ljava/lang/String;", "", "IDLE_WORKER_KEEP_ALIVE_NS", "J", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "Lkotlinx/coroutines/scheduling/TimeSource;", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "Lkotlinx/coroutines/scheduling/Task;", "", "isBlocking", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class TasksKt {
    @JvmField
    public static final int BLOCKING_DEFAULT_PARALLELISM;
    @JvmField
    public static final int CORE_POOL_SIZE;
    public static final String DEFAULT_SCHEDULER_NAME = "DefaultDispatcher";
    @JvmField
    public static final long IDLE_WORKER_KEEP_ALIVE_NS;
    @JvmField
    public static final int MAX_POOL_SIZE;
    public static final int TASK_NON_BLOCKING = 0;
    public static final int TASK_PROBABLY_BLOCKING = 1;
    @JvmField
    public static final long WORK_STEALING_TIME_RESOLUTION_NS;
    @JvmField
    public static TimeSource schedulerTimeSource;

    static {
        long systemProp$default;
        int systemProp$default2;
        int systemProp$default3;
        int systemProp$default4;
        long systemProp$default5;
        systemProp$default = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, (Object) null);
        WORK_STEALING_TIME_RESOLUTION_NS = systemProp$default;
        systemProp$default2 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);
        BLOCKING_DEFAULT_PARALLELISM = systemProp$default2;
        systemProp$default3 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", RangesKt___RangesKt.coerceAtLeast(SystemPropsKt.getAVAILABLE_PROCESSORS(), 2), 1, 0, 8, (Object) null);
        CORE_POOL_SIZE = systemProp$default3;
        systemProp$default4 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", RangesKt___RangesKt.coerceIn(SystemPropsKt.getAVAILABLE_PROCESSORS() * 128, CORE_POOL_SIZE, (int) CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE), 0, (int) CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE, 4, (Object) null);
        MAX_POOL_SIZE = systemProp$default4;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        systemProp$default5 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, (Object) null);
        IDLE_WORKER_KEEP_ALIVE_NS = timeUnit.toNanos(systemProp$default5);
        schedulerTimeSource = NanoTimeSource.INSTANCE;
    }

    public static final boolean isBlocking(Task task) {
        return task.taskContext.getTaskMode() == 1;
    }
}
