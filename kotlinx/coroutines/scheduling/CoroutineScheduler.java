package kotlinx.coroutines.scheduling;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.TimeSourceKt;
import kotlinx.coroutines.internal.Symbol;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0003^_`B+\u0012\u0006\u0010L\u001a\u00020\n\u0012\u0006\u0010V\u001a\u00020\n\u0012\b\b\u0002\u0010S\u001a\u00020\b\u0012\b\b\u0002\u0010W\u001a\u00020A¢\u0006\u0004\b\\\u0010]J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0082\b¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u001a\u001a\u00020\u00032\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0082\b¢\u0006\u0004\b\u001b\u0010\fJ\u0015\u0010\u001d\u001a\b\u0018\u00010\u001cR\u00020\u0000H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u000eH\u0082\b¢\u0006\u0004\b\u001f\u0010\u0010J\u0010\u0010 \u001a\u00020\nH\u0082\b¢\u0006\u0004\b \u0010\u0012J-\u0010\"\u001a\u00020\u000e2\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u001b\u0010%\u001a\u00020\u000e2\n\u0010$\u001a\u00060\u0013j\u0002`\u0014H\u0016¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\bH\u0082\b¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\nH\u0082\b¢\u0006\u0004\b)\u0010\u0012J\u001b\u0010+\u001a\u00020\n2\n\u0010*\u001a\u00060\u001cR\u00020\u0000H\u0002¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\b\u0018\u00010\u001cR\u00020\u0000H\u0002¢\u0006\u0004\b-\u0010\u001eJ\u001b\u00100\u001a\u00020\u00052\n\u0010*\u001a\u00060\u001cR\u00020\u0000H\u0000¢\u0006\u0004\b.\u0010/J+\u00105\u001a\u00020\u000e2\n\u0010*\u001a\u00060\u001cR\u00020\u00002\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0000¢\u0006\u0004\b3\u00104J\u0010\u00106\u001a\u00020\bH\u0082\b¢\u0006\u0004\b6\u0010(J\u0015\u00107\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\b¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u0005H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020\u000eH\u0000¢\u0006\u0004\b?\u0010\u0010J\u000f\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0005H\u0082\b¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0005H\u0002¢\u0006\u0004\bH\u0010EJ+\u0010I\u001a\u0004\u0018\u00010\u0003*\b\u0018\u00010\u001cR\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\bI\u0010JR\u0017\u0010\u000b\u001a\u00020\n8Â\u0002@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0012R\u0016\u0010L\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0017\u0010\u001b\u001a\u00020\n8Â\u0002@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\u0012R\u0016\u0010P\u001a\u00020O8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020O8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bR\u0010QR\u0016\u0010S\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0013\u0010U\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\bU\u0010ER\u0016\u0010V\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bV\u0010MR\u0016\u0010W\u001a\u00020A8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\"\u0010Z\u001a\u000e\u0012\n\u0012\b\u0018\u00010\u001cR\u00020\u00000Y8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006a"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "", "state", "", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createTask", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", StatConstants.VALUE_TYPE_DISPATCH, "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "parkedWorkersStackPush", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "parkedWorkersStackTopUpdate", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork$kotlinx_coroutines_core", "signalCpuWork", "", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "corePoolSize", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "idleWorkerKeepAliveNs", "J", "isTerminated", "maxPoolSize", "schedulerName", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "<init>", "(IIJLjava/lang/String;)V", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    public static final long BLOCKING_MASK = 4398044413952L;
    public static final int BLOCKING_SHIFT = 21;
    public static final int CLAIMED = 0;
    public static final long CPU_PERMITS_MASK = 9223367638808264704L;
    public static final int CPU_PERMITS_SHIFT = 42;
    public static final long CREATED_MASK = 2097151;
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    public static final int PARKED = -1;
    public static final long PARKED_INDEX_MASK = 2097151;
    public static final long PARKED_VERSION_INC = 2097152;
    public static final long PARKED_VERSION_MASK = -2097152;
    public static final int TERMINATED = 1;
    public volatile int _isTerminated;
    public volatile long controlState;
    @JvmField
    public final int corePoolSize;
    @JvmField
    public final GlobalQueue globalBlockingQueue;
    @JvmField
    public final GlobalQueue globalCpuQueue;
    @JvmField
    public final long idleWorkerKeepAliveNs;
    @JvmField
    public final int maxPoolSize;
    public volatile long parkedWorkersStack;
    @JvmField
    public final String schedulerName;
    @JvmField
    public final AtomicReferenceArray<Worker> workers;
    public static final Companion Companion = new Companion(null);
    @JvmField
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    public static final AtomicLongFieldUpdater parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    public static final AtomicLongFieldUpdater controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    public static final AtomicIntegerFieldUpdater _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkerState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[WorkerState.PARKING.ordinal()] = 1;
            $EnumSwitchMapping$0[WorkerState.BLOCKING.ordinal()] = 2;
            $EnumSwitchMapping$0[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            $EnumSwitchMapping$0[WorkerState.DORMANT.ordinal()] = 4;
            $EnumSwitchMapping$0[WorkerState.TERMINATED.ordinal()] = 5;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    private final int blockingTasks(long j) {
        return (int) ((j & BLOCKING_MASK) >> 21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int createdWorkers(long j) {
        return (int) (j & 2097151);
    }

    public final int availableCpuPermits(long j) {
        return (int) ((j & CPU_PERMITS_MASK) >> 42);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00048\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0016\u0010\f\u001a\u00020\u00048\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0003R\u0016\u0010\u0012\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0013\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0003R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0006¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "BLOCKING_MASK", "J", "", "BLOCKING_SHIFT", "I", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "Lkotlinx/coroutines/internal/Symbol;", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\bF\u0010GB\t\b\u0002¢\u0006\u0004\bF\u0010HJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001aJ\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u0014J\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u001aJ\u0017\u0010%\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u0004\u0018\u00010\b2\u0006\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010\u000fJ\u000f\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010\u001aR*\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\u0006R\u0016\u00100\u001a\u00020/8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010+R\u0014\u0010B\u001a\u00020?8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00106¨\u0006I"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt$kotlinx_coroutines_core", "(I)I", "nextInt", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "tryReleaseCpu", "blockingOnly", "trySteal", "tryTerminateWorker", "index", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public final class Worker extends Thread {
        public static final AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        public volatile int indexInArray;
        @JvmField
        public final WorkQueue localQueue;
        @JvmField
        public boolean mayHaveLocalTasks;
        public long minDelayUntilStealableTaskNs;
        public volatile Object nextParkedWorker;
        public int rngState;
        @JvmField
        public WorkerState state;
        public long terminationDeadline;
        public volatile int workerCtl;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public Worker() {
            setDaemon(true);
            this.localQueue = new WorkQueue();
            this.state = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.rngState = Random.Default.nextInt();
        }

        private final void afterTask(int i) {
            boolean z;
            if (i == 0) {
                return;
            }
            CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, CoroutineScheduler.PARKED_VERSION_MASK);
            WorkerState workerState = this.state;
            if (workerState != WorkerState.TERMINATED) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (workerState == WorkerState.BLOCKING) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.DORMANT;
            }
        }

        private final void beforeTask(int i) {
            if (i != 0 && tryReleaseCpu$kotlinx_coroutines_core(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.signalCpuWork$kotlinx_coroutines_core();
            }
        }

        private final void executeTask(Task task) {
            int taskMode = task.taskContext.getTaskMode();
            idleReset(taskMode);
            beforeTask(taskMode);
            CoroutineScheduler.this.runSafely(task);
            afterTask(taskMode);
        }

        private final void idleReset(int i) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean z = true;
                    if (i != 1) {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.BLOCKING;
            }
        }

        public final int nextInt$kotlinx_coroutines_core(int i) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = i - 1;
            if ((i6 & i) == 0) {
                return i5 & i6;
            }
            return (i5 & Integer.MAX_VALUE) % i;
        }

        public final void setIndexInArray(int i) {
            String valueOf;
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            if (i == 0) {
                valueOf = "TERMINATED";
            } else {
                valueOf = String.valueOf(i);
            }
            sb.append(valueOf);
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu$kotlinx_coroutines_core(WorkerState workerState) {
            boolean z;
            WorkerState workerState2 = this.state;
            if (workerState2 == WorkerState.CPU_ACQUIRED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i) {
            this();
            setIndexInArray(i);
        }

        private final Task findAnyTask(boolean z) {
            boolean z2;
            Task pollGlobalQueues;
            Task pollGlobalQueues2;
            if (z) {
                if (nextInt$kotlinx_coroutines_core(CoroutineScheduler.this.corePoolSize * 2) == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && (pollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return pollGlobalQueues2;
                }
                Task poll = this.localQueue.poll();
                if (poll != null) {
                    return poll;
                }
                if (!z2 && (pollGlobalQueues = pollGlobalQueues()) != null) {
                    return pollGlobalQueues;
                }
            } else {
                Task pollGlobalQueues3 = pollGlobalQueues();
                if (pollGlobalQueues3 != null) {
                    return pollGlobalQueues3;
                }
            }
            return trySteal(false);
        }

        public final Task findTask(boolean z) {
            Task removeFirstOrNull;
            if (tryAcquireCpuPermit()) {
                return findAnyTask(z);
            }
            if (z) {
                removeFirstOrNull = this.localQueue.poll();
                if (removeFirstOrNull == null) {
                    removeFirstOrNull = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
                }
            } else {
                removeFirstOrNull = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            if (removeFirstOrNull == null) {
                return trySteal(true);
            }
            return removeFirstOrNull;
        }

        private final boolean inStack() {
            if (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                return true;
            }
            return false;
        }

        private final void park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                tryTerminateWorker();
            }
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            runWorker();
        }

        private final Task pollGlobalQueues() {
            if (nextInt$kotlinx_coroutines_core(2) == 0) {
                Task removeFirstOrNull = CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                if (removeFirstOrNull != null) {
                    return removeFirstOrNull;
                }
                return CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            Task removeFirstOrNull2 = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            if (removeFirstOrNull2 != null) {
                return removeFirstOrNull2;
            }
            return CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
        }

        private final void runWorker() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    Task findTask = findTask(this.mayHaveLocalTasks);
                    if (findTask != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        executeTask(findTask);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs != 0) {
                            if (!z) {
                                z = true;
                            } else {
                                tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
                                Thread.interrupted();
                                LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                                this.minDelayUntilStealableTaskNs = 0L;
                            }
                        } else {
                            tryPark();
                        }
                    }
                }
            }
            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.TERMINATED);
        }

        private final boolean tryAcquireCpuPermit() {
            boolean z;
            if (this.state != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j = coroutineScheduler.controlState;
                    if (((int) ((CoroutineScheduler.CPU_PERMITS_MASK & j) >> 42)) == 0) {
                        z = false;
                        break;
                    }
                    if (CoroutineScheduler.controlState$FU.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.state = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        private final void tryPark() {
            boolean z;
            if (!inStack()) {
                CoroutineScheduler.this.parkedWorkersStackPush$kotlinx_coroutines_core(this);
                return;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (this.localQueue.getSize$kotlinx_coroutines_core() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (inStack() && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        private final Task trySteal(boolean z) {
            long tryStealFrom;
            boolean z2;
            boolean z3;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (this.localQueue.getSize$kotlinx_coroutines_core() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    throw new AssertionError();
                }
            }
            int createdWorkers = CoroutineScheduler.this.getCreatedWorkers();
            if (createdWorkers < 2) {
                return null;
            }
            int nextInt$kotlinx_coroutines_core = nextInt$kotlinx_coroutines_core(createdWorkers);
            long j = Long.MAX_VALUE;
            for (int i = 0; i < createdWorkers; i++) {
                nextInt$kotlinx_coroutines_core++;
                if (nextInt$kotlinx_coroutines_core > createdWorkers) {
                    nextInt$kotlinx_coroutines_core = 1;
                }
                Worker worker = CoroutineScheduler.this.workers.get(nextInt$kotlinx_coroutines_core);
                if (worker != null && worker != this) {
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        if (this.localQueue.getSize$kotlinx_coroutines_core() == 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            throw new AssertionError();
                        }
                    }
                    if (z) {
                        tryStealFrom = this.localQueue.tryStealBlockingFrom(worker.localQueue);
                    } else {
                        tryStealFrom = this.localQueue.tryStealFrom(worker.localQueue);
                    }
                    if (tryStealFrom == -1) {
                        return this.localQueue.poll();
                    }
                    if (tryStealFrom > 0) {
                        j = Math.min(j, tryStealFrom);
                    }
                }
            }
            if (j == Long.MAX_VALUE) {
                j = 0;
            }
            this.minDelayUntilStealableTaskNs = j;
            return null;
        }

        private final void tryTerminateWorker() {
            synchronized (CoroutineScheduler.this.workers) {
                if (CoroutineScheduler.this.isTerminated()) {
                    return;
                }
                if (CoroutineScheduler.this.getCreatedWorkers() <= CoroutineScheduler.this.corePoolSize) {
                    return;
                }
                if (!workerCtl$FU.compareAndSet(this, -1, 1)) {
                    return;
                }
                int i = this.indexInArray;
                setIndexInArray(0);
                CoroutineScheduler.this.parkedWorkersStackTopUpdate$kotlinx_coroutines_core(this, i, 0);
                int andDecrement = (int) (CoroutineScheduler.controlState$FU.getAndDecrement(CoroutineScheduler.this) & 2097151);
                if (andDecrement != i) {
                    Worker worker = CoroutineScheduler.this.workers.get(andDecrement);
                    if (worker == null) {
                        Intrinsics.throwNpe();
                    }
                    Worker worker2 = worker;
                    CoroutineScheduler.this.workers.set(i, worker2);
                    worker2.setIndexInArray(i);
                    CoroutineScheduler.this.parkedWorkersStackTopUpdate$kotlinx_coroutines_core(worker2, andDecrement, i);
                }
                CoroutineScheduler.this.workers.set(andDecrement, null);
                Unit unit = Unit.INSTANCE;
                this.state = WorkerState.TERMINATED;
            }
        }
    }

    private final Worker currentWorker() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof Worker)) {
            currentThread = null;
        }
        Worker worker = (Worker) currentThread;
        if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void decrementBlockingTasks() {
        controlState$FU.addAndGet(this, PARKED_VERSION_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int decrementCreatedWorkers() {
        return (int) (controlState$FU.getAndDecrement(this) & 2097151);
    }

    private final int getAvailableCpuPermits() {
        return (int) ((this.controlState & CPU_PERMITS_MASK) >> 42);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCreatedWorkers() {
        return (int) (this.controlState & 2097151);
    }

    private final long incrementBlockingTasks() {
        return controlState$FU.addAndGet(this, 2097152L);
    }

    private final int incrementCreatedWorkers() {
        return (int) (controlState$FU.incrementAndGet(this) & 2097151);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long releaseCpuPermit() {
        return controlState$FU.addAndGet(this, 4398046511104L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryAcquireCpuPermit() {
        long j;
        do {
            j = this.controlState;
            if (((int) ((CPU_PERMITS_MASK & j) >> 42)) == 0) {
                return false;
            }
        } while (!controlState$FU.compareAndSet(this, j, j - 4398046511104L));
        return true;
    }

    private final boolean tryUnpark() {
        Worker parkedWorkersStackPop;
        do {
            parkedWorkersStackPop = parkedWorkersStackPop();
            if (parkedWorkersStackPop == null) {
                return false;
            }
        } while (!Worker.workerCtl$FU.compareAndSet(parkedWorkersStackPop, -1, 0));
        LockSupport.unpark(parkedWorkersStackPop);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown(10000L);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final void signalCpuWork$kotlinx_coroutines_core() {
        if (tryUnpark() || tryCreateWorker$default(this, 0L, 1, null)) {
            return;
        }
        tryUnpark();
    }

    public CoroutineScheduler(int i, int i2, long j, String str) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (i >= 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (this.maxPoolSize >= this.corePoolSize) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (this.maxPoolSize <= 2097150) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if (this.idleWorkerKeepAliveNs > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        this.globalCpuQueue = new GlobalQueue();
                        this.globalBlockingQueue = new GlobalQueue();
                        this.parkedWorkersStack = 0L;
                        this.workers = new AtomicReferenceArray<>(this.maxPoolSize + 1);
                        this.controlState = this.corePoolSize << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + this.idleWorkerKeepAliveNs + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + this.maxPoolSize + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + this.maxPoolSize + " should be greater than or equals to core pool size " + this.corePoolSize).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + this.corePoolSize + " should be at least 1").toString());
    }

    public /* synthetic */ CoroutineScheduler(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? TasksKt.IDLE_WORKER_KEEP_ALIVE_NS : j, (i3 & 8) != 0 ? TasksKt.DEFAULT_SCHEDULER_NAME : str);
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            taskContext = NonBlockingContext.INSTANCE;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, z);
    }

    public final Task createTask$kotlinx_coroutines_core(Runnable runnable, TaskContext taskContext) {
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (runnable instanceof Task) {
            Task task = (Task) runnable;
            task.submissionTime = nanoTime;
            task.taskContext = taskContext;
            return task;
        }
        return new TaskImpl(runnable, nanoTime, taskContext);
    }

    private final boolean addToGlobalQueue(Task task) {
        boolean z = true;
        if (task.taskContext.getTaskMode() != 1) {
            z = false;
        }
        if (z) {
            return this.globalBlockingQueue.addLast(task);
        }
        return this.globalCpuQueue.addLast(task);
    }

    private final int parkedWorkersStackNextIndex(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    private final void signalBlockingWork(boolean z) {
        long addAndGet = controlState$FU.addAndGet(this, 2097152L);
        if (z || tryUnpark() || tryCreateWorker(addAndGet)) {
            return;
        }
        tryUnpark();
    }

    private final boolean tryCreateWorker(long j) {
        if (RangesKt___RangesKt.coerceAtLeast(((int) (2097151 & j)) - ((int) ((j & BLOCKING_MASK) >> 21)), 0) < this.corePoolSize) {
            int createNewWorker = createNewWorker();
            if (createNewWorker == 1 && this.corePoolSize > 1) {
                createNewWorker();
            }
            if (createNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        dispatch$default(this, runnable, null, false, 6, null);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    public final void runSafely(Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                kotlinx.coroutines.TimeSource timeSource = TimeSourceKt.getTimeSource();
                if (timeSource == null) {
                }
            } finally {
                kotlinx.coroutines.TimeSource timeSource2 = TimeSourceKt.getTimeSource();
                if (timeSource2 != null) {
                    timeSource2.unTrackTask();
                }
            }
        }
    }

    private final int createNewWorker() {
        boolean z;
        synchronized (this.workers) {
            if (isTerminated()) {
                return -1;
            }
            long j = this.controlState;
            int i = (int) (j & 2097151);
            boolean z2 = false;
            int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i - ((int) ((j & BLOCKING_MASK) >> 21)), 0);
            if (coerceAtLeast >= this.corePoolSize) {
                return 0;
            }
            if (i >= this.maxPoolSize) {
                return 0;
            }
            int i2 = ((int) (this.controlState & 2097151)) + 1;
            if (i2 > 0 && this.workers.get(i2) == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Worker worker = new Worker(this, i2);
                this.workers.set(i2, worker);
                if (i2 == ((int) (2097151 & controlState$FU.incrementAndGet(this)))) {
                    z2 = true;
                }
                if (z2) {
                    worker.start();
                    return coerceAtLeast + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final Worker parkedWorkersStackPop() {
        while (true) {
            long j = this.parkedWorkersStack;
            Worker worker = this.workers.get((int) (2097151 & j));
            if (worker != null) {
                long j2 = (2097152 + j) & PARKED_VERSION_MASK;
                int parkedWorkersStackNextIndex = parkedWorkersStackNextIndex(worker);
                if (parkedWorkersStackNextIndex >= 0 && parkedWorkersStack$FU.compareAndSet(this, j, parkedWorkersStackNextIndex | j2)) {
                    worker.setNextParkedWorker(NOT_IN_STACK);
                    return worker;
                }
            } else {
                return null;
            }
        }
    }

    private final Task submitToLocalQueue(Worker worker, Task task, boolean z) {
        if (worker == null) {
            return task;
        }
        if (worker.state == WorkerState.TERMINATED) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 0 && worker.state == WorkerState.BLOCKING) {
            return task;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.add(task, z);
    }

    public final void parkedWorkersStackTopUpdate$kotlinx_coroutines_core(Worker worker, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & PARKED_VERSION_MASK;
            if (i3 == i) {
                if (i2 == 0) {
                    i3 = parkedWorkersStackNextIndex(worker);
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0 && parkedWorkersStack$FU.compareAndSet(this, j, j2 | i3)) {
                return;
            }
        }
    }

    public static /* synthetic */ boolean tryCreateWorker$default(CoroutineScheduler coroutineScheduler, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = coroutineScheduler.controlState;
        }
        return coroutineScheduler.tryCreateWorker(j);
    }

    public final void dispatch(Runnable runnable, TaskContext taskContext, boolean z) {
        boolean z2;
        kotlinx.coroutines.TimeSource timeSource = TimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.trackTask();
        }
        Task createTask$kotlinx_coroutines_core = createTask$kotlinx_coroutines_core(runnable, taskContext);
        Worker currentWorker = currentWorker();
        Task submitToLocalQueue = submitToLocalQueue(currentWorker, createTask$kotlinx_coroutines_core, z);
        if (submitToLocalQueue != null && !addToGlobalQueue(submitToLocalQueue)) {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
        if (z && currentWorker != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (createTask$kotlinx_coroutines_core.taskContext.getTaskMode() == 0) {
            if (z2) {
                return;
            }
            signalCpuWork$kotlinx_coroutines_core();
            return;
        }
        signalBlockingWork(z2);
    }

    public final boolean parkedWorkersStackPush$kotlinx_coroutines_core(Worker worker) {
        long j;
        long j2;
        int indexInArray;
        boolean z;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        do {
            j = this.parkedWorkersStack;
            int i = (int) (2097151 & j);
            j2 = (2097152 + j) & PARKED_VERSION_MASK;
            indexInArray = worker.getIndexInArray();
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (indexInArray != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            worker.setNextParkedWorker(this.workers.get(i));
        } while (!parkedWorkersStack$FU.compareAndSet(this, j, indexInArray | j2));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
        if (r9 != null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void shutdown(long j) {
        int i;
        Task removeFirstOrNull;
        boolean z;
        boolean z2 = false;
        if (!_isTerminated$FU.compareAndSet(this, 0, 1)) {
            return;
        }
        Worker currentWorker = currentWorker();
        synchronized (this.workers) {
            i = (int) (this.controlState & 2097151);
        }
        if (1 <= i) {
            int i2 = 1;
            while (true) {
                Worker worker = this.workers.get(i2);
                if (worker == null) {
                    Intrinsics.throwNpe();
                }
                Worker worker2 = worker;
                if (worker2 != currentWorker) {
                    while (worker2.isAlive()) {
                        LockSupport.unpark(worker2);
                        worker2.join(j);
                    }
                    WorkerState workerState = worker2.state;
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        if (workerState == WorkerState.TERMINATED) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            throw new AssertionError();
                        }
                    }
                    worker2.localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                }
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        this.globalBlockingQueue.close();
        this.globalCpuQueue.close();
        while (true) {
            if (currentWorker != null) {
                removeFirstOrNull = currentWorker.findTask(true);
            }
            removeFirstOrNull = this.globalCpuQueue.removeFirstOrNull();
            if (removeFirstOrNull == null) {
                removeFirstOrNull = this.globalBlockingQueue.removeFirstOrNull();
            }
            if (removeFirstOrNull == null) {
                break;
            }
            runSafely(removeFirstOrNull);
        }
        if (currentWorker != null) {
            currentWorker.tryReleaseCpu$kotlinx_coroutines_core(WorkerState.TERMINATED);
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (((int) ((this.controlState & CPU_PERMITS_MASK) >> 42)) == this.corePoolSize) {
                z2 = true;
            }
            if (!z2) {
                throw new AssertionError();
            }
        }
        this.parkedWorkersStack = 0L;
        this.controlState = 0L;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.workers.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            Worker worker = this.workers.get(i6);
            if (worker != null) {
                int size$kotlinx_coroutines_core = worker.localQueue.getSize$kotlinx_coroutines_core();
                int i7 = WhenMappings.$EnumSwitchMapping$0[worker.state.ordinal()];
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 != 4) {
                                if (i7 == 5) {
                                    i5++;
                                }
                            } else {
                                i4++;
                                if (size$kotlinx_coroutines_core > 0) {
                                    arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "d");
                                }
                            }
                        } else {
                            i++;
                            arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "c");
                        }
                    } else {
                        i2++;
                        arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "b");
                    }
                } else {
                    i3++;
                }
            }
        }
        long j = this.controlState;
        return this.schedulerName + '@' + DebugStringsKt.getHexAddress(this) + "[Pool Size {core = " + this.corePoolSize + StringUtil.ARRAY_ELEMENT_SEPARATOR + "max = " + this.maxPoolSize + "}, Worker States {CPU = " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + "blocking = " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + "parked = " + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + "dormant = " + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + "terminated = " + i5 + "}, running workers queues = " + arrayList + StringUtil.ARRAY_ELEMENT_SEPARATOR + "global CPU queue size = " + this.globalCpuQueue.getSize() + StringUtil.ARRAY_ELEMENT_SEPARATOR + "global blocking queue size = " + this.globalBlockingQueue.getSize() + StringUtil.ARRAY_ELEMENT_SEPARATOR + "Control State {created workers= " + ((int) (2097151 & j)) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "blocking tasks = " + ((int) ((BLOCKING_MASK & j) >> 21)) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "CPUs acquired = " + (this.corePoolSize - ((int) ((CPU_PERMITS_MASK & j) >> 42))) + "}]";
    }
}
