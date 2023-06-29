package kotlinx.coroutines;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.EventLoopImplBase;
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0014\u0010 \u001a\u00020\u001e2\n\u0010!\u001a\u00060\u0002j\u0002`\u0003H\u0016J\r\u0010\"\u001a\u00020\u001eH\u0000¢\u0006\u0002\b#J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\b2\n\u0010'\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0015H\u0002J\u0018\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\b\u00101\u001a\u00020\u001eH\u0002J\u000e\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0004R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00064"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE_MS", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "debugStatus", "isShutDown", "", "()Z", "isShutdownRequested", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "enqueue", DownloadStatisticConstants.UBC_VALUE_TASK, "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "context", "Lkotlin/coroutines/CoroutineContext;", "notifyStartup", "reschedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "run", "shutdown", "shutdownError", "shutdownForTests", "timeout", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    public static final int ACTIVE = 1;
    public static final long DEFAULT_KEEP_ALIVE_MS = 1000;
    public static final int FRESH = 0;
    public static final DefaultExecutor INSTANCE;
    public static final long KEEP_ALIVE_NANOS;
    public static final int SHUTDOWN = 4;
    public static final int SHUTDOWN_ACK = 3;
    public static final int SHUTDOWN_REQ = 2;
    public static final String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";
    public static volatile Thread _thread;
    public static volatile int debugStatus;

    public static /* synthetic */ void get_thread$annotations() {
    }

    static {
        Long l;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        INSTANCE = defaultExecutor;
        EventLoop.incrementUseCount$default(defaultExecutor, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l.longValue());
    }

    private final synchronized void acknowledgeShutdownIfNeeded() {
        if (!isShutdownRequested()) {
            return;
        }
        debugStatus = 3;
        resetAll();
        notifyAll();
    }

    private final synchronized Thread createThreadSync() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, THREAD_NAME);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean isShutDown() {
        if (debugStatus == 4) {
            return true;
        }
        return false;
    }

    private final boolean isShutdownRequested() {
        int i = debugStatus;
        if (i != 2 && i != 3) {
            return false;
        }
        return true;
    }

    private final synchronized boolean notifyStartup() {
        if (isShutdownRequested()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final void shutdownError() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public Thread getThread() {
        Thread thread = _thread;
        if (thread == null) {
            return createThreadSync();
        }
        return thread;
    }

    public final boolean isThreadPresent$kotlinx_coroutines_core() {
        if (_thread != null) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.EventLoop
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public void enqueue(Runnable runnable) {
        if (isShutDown()) {
            shutdownError();
        }
        super.enqueue(runnable);
    }

    public final synchronized void ensureStarted$kotlinx_coroutines_core() {
        boolean z;
        boolean z2 = true;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (_thread == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (debugStatus != 0 && debugStatus != 3) {
                z2 = false;
            }
            throw new AssertionError();
        }
        debugStatus = 0;
        createThreadSync();
        while (debugStatus == 0) {
            wait();
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return scheduleInvokeOnTimeout(j, runnable);
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public void reschedule(long j, EventLoopImplBase.DelayedTask delayedTask) {
        shutdownError();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[SPUT, INVOKE, INVOKE]}, finally: {[SPUT, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, IF] complete} */
    @Override // java.lang.Runnable
    public void run() {
        Unit unit;
        Long valueOf;
        long longValue;
        boolean isEmpty;
        ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
        try {
            if (!notifyStartup()) {
                if (!isEmpty) {
                    return;
                }
                return;
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long processNextEvent = processNextEvent();
                if (processNextEvent == Long.MAX_VALUE) {
                    AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource2 == null) {
                        valueOf = null;
                    } else {
                        valueOf = Long.valueOf(timeSource2.nanoTime());
                    }
                    if (valueOf == null) {
                        longValue = System.nanoTime();
                    } else {
                        longValue = valueOf.longValue();
                    }
                    if (j == Long.MAX_VALUE) {
                        j = KEEP_ALIVE_NANOS + longValue;
                    }
                    long j2 = j - longValue;
                    if (j2 <= 0) {
                        _thread = null;
                        acknowledgeShutdownIfNeeded();
                        AbstractTimeSource timeSource3 = AbstractTimeSourceKt.getTimeSource();
                        if (timeSource3 != null) {
                            timeSource3.unregisterTimeLoopThread();
                        }
                        if (!isEmpty()) {
                            getThread();
                            return;
                        }
                        return;
                    }
                    processNextEvent = RangesKt___RangesKt.coerceAtMost(processNextEvent, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (processNextEvent > 0) {
                    if (isShutdownRequested()) {
                        _thread = null;
                        acknowledgeShutdownIfNeeded();
                        AbstractTimeSource timeSource4 = AbstractTimeSourceKt.getTimeSource();
                        if (timeSource4 != null) {
                            timeSource4.unregisterTimeLoopThread();
                        }
                        if (!isEmpty()) {
                            getThread();
                            return;
                        }
                        return;
                    }
                    AbstractTimeSource timeSource5 = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource5 == null) {
                        unit = null;
                    } else {
                        timeSource5.parkNanos(this, processNextEvent);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        LockSupport.parkNanos(this, processNextEvent);
                    }
                }
            }
        } finally {
            _thread = null;
            acknowledgeShutdownIfNeeded();
            AbstractTimeSource timeSource6 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource6 != null) {
                timeSource6.unregisterTimeLoopThread();
            }
            if (!isEmpty()) {
                getThread();
            }
        }
    }

    public final synchronized void shutdownForTests(long j) {
        Unit unit;
        long currentTimeMillis = System.currentTimeMillis() + j;
        if (!isShutdownRequested()) {
            debugStatus = 2;
        }
        while (debugStatus != 3 && _thread != null) {
            Thread thread = _thread;
            if (thread != null) {
                AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
                if (timeSource == null) {
                    unit = null;
                } else {
                    timeSource.unpark(thread);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    LockSupport.unpark(thread);
                }
            }
            if (currentTimeMillis - System.currentTimeMillis() <= 0) {
                break;
            }
            wait(j);
        }
        debugStatus = 0;
    }
}
