package kotlinx.coroutines;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.ruka.ioc.Constant;
import com.tachikoma.core.event.base.TKBaseEvent;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b \u0018\u00002\u00020\u00012\u00020\u0002:\u00046789B\u0007¢\u0006\u0004\b5\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00032\n\u0010\u000f\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u00122\n\u0010\u000f\u001a\u00060\u0006j\u0002`\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0019\u0010\u0005J\u001d\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b \u0010!J#\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u00152\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007H\u0004¢\u0006\u0004\b$\u0010%J%\u0010(\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u001bH\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0003H\u0014¢\u0006\u0004\b,\u0010\u0005R$\u0010.\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00128B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00128T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b2\u0010/R\u0016\u00104\u001a\u00020\u00158T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0017¨\u0006:"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/Delay;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "", "closeQueue", "()V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, TKBaseEvent.TK_DISPATCH_EVENT_NAME, "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "<init>", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    public static final AtomicReferenceFieldUpdater _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
    public static final AtomicReferenceFieldUpdater _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    public volatile Object _queue = null;
    public volatile Object _delayed = null;
    public volatile int _isCompleted = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "kotlinx/coroutines/EventLoopImplBase$DelayedTask", "", "run", "()V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "nanoTime", "<init>", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public final class DelayedResumeTask extends DelayedTask {
        public final CancellableContinuation<Unit> cont;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public DelayedResumeTask(long j2, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j2);
            this.cont = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this, Unit.INSTANCE);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.cont.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00060\bj\u0002`\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "kotlinx/coroutines/EventLoopImplBase$DelayedTask", "", "run", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Ljava/lang/Runnable;", "", "nanoTime", "<init>", "(JLjava/lang/Runnable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class DelayedRunnableTask extends DelayedTask {
        public final Runnable block;

        public DelayedRunnableTask(long j2, Runnable runnable) {
            super(j2);
            this.block = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.block.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.block.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010*\u001a\u00020\f¢\u0006\u0004\b,\u0010-J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR0\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\f\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Ljava/lang/Comparable;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "other", "", "compareTo", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "", "dispose", "()V", "", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "delayed", "Lkotlinx/coroutines/EventLoopImplBase;", "eventLoop", "scheduleTask", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;Lkotlinx/coroutines/EventLoopImplBase;)I", "", "timeToExecute", "(J)Z", "", "toString", "()Ljava/lang/String;", "", "_heap", "Ljava/lang/Object;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "value", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", Constant.KEY_HEAP, "index", "I", "getIndex", "()I", "setIndex", "(I)V", "nanoTime", "J", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        public Object _heap;
        public int index = -1;
        @JvmField
        public long nanoTime;

        public DelayedTask(long j2) {
            this.nanoTime = j2;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final synchronized void dispose() {
            Symbol symbol;
            Symbol symbol2;
            Object obj = this._heap;
            symbol = EventLoop_commonKt.DISPOSED_TASK;
            if (obj == symbol) {
                return;
            }
            if (!(obj instanceof DelayedTaskQueue)) {
                obj = null;
            }
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) obj;
            if (delayedTaskQueue != null) {
                delayedTaskQueue.remove(this);
            }
            symbol2 = EventLoop_commonKt.DISPOSED_TASK;
            this._heap = symbol2;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public ThreadSafeHeap<?> getHeap() {
            Object obj = this._heap;
            if (!(obj instanceof ThreadSafeHeap)) {
                obj = null;
            }
            return (ThreadSafeHeap) obj;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.index;
        }

        public final synchronized int scheduleTask(long j2, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            Symbol symbol;
            Object obj = this._heap;
            symbol = EventLoop_commonKt.DISPOSED_TASK;
            if (obj == symbol) {
                return 2;
            }
            synchronized (delayedTaskQueue) {
                DelayedTask firstImpl = delayedTaskQueue.firstImpl();
                if (eventLoopImplBase.isCompleted()) {
                    return 1;
                }
                if (firstImpl == null) {
                    delayedTaskQueue.timeNow = j2;
                } else {
                    long j3 = firstImpl.nanoTime;
                    if (j3 - j2 < 0) {
                        j2 = j3;
                    }
                    if (j2 - delayedTaskQueue.timeNow > 0) {
                        delayedTaskQueue.timeNow = j2;
                    }
                }
                if (this.nanoTime - delayedTaskQueue.timeNow < 0) {
                    this.nanoTime = delayedTaskQueue.timeNow;
                }
                delayedTaskQueue.addImpl(this);
                return 0;
            }
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(ThreadSafeHeap<?> threadSafeHeap) {
            Symbol symbol;
            Object obj = this._heap;
            symbol = EventLoop_commonKt.DISPOSED_TASK;
            if (obj != symbol) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int i2) {
            this.index = i2;
        }

        public final boolean timeToExecute(long j2) {
            return j2 - this.nanoTime >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(DelayedTask delayedTask) {
            int i2 = ((this.nanoTime - delayedTask.nanoTime) > 0L ? 1 : ((this.nanoTime - delayedTask.nanoTime) == 0L ? 0 : -1));
            if (i2 > 0) {
                return 1;
            }
            return i2 < 0 ? -1 : 0;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "", "timeNow", "J", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        @JvmField
        public long timeNow;

        public DelayedTaskQueue(long j2) {
            this.timeNow = j2;
        }
    }

    private final void closeQueue() {
        Symbol symbol;
        Symbol symbol2;
        if (DebugKt.getASSERTIONS_ENABLED() && !isCompleted()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$FU;
                symbol = EventLoop_commonKt.CLOSED_EMPTY;
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, symbol)) {
                    return;
                }
            } else if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol2 = EventLoop_commonKt.CLOSED_EMPTY;
                if (obj == symbol2) {
                    return;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                if (obj != null) {
                    lockFreeTaskQueueCore.addLast((Runnable) obj);
                    if (_queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                        return;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            } else {
                ((LockFreeTaskQueueCore) obj).close();
                return;
            }
        }
    }

    private final Runnable dequeue() {
        Symbol symbol;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.CLOSED_EMPTY;
                if (obj == symbol) {
                    return null;
                }
                if (_queue$FU.compareAndSet(this, obj, null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            } else if (obj != null) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                Object removeFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
                if (removeFirstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                    return (Runnable) removeFirstOrNull;
                }
                _queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore.next());
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
            }
        }
    }

    private final boolean enqueueImpl(Runnable runnable) {
        Symbol symbol;
        while (true) {
            Object obj = this._queue;
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (_queue$FU.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.CLOSED_EMPTY;
                if (obj == symbol) {
                    return false;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                if (obj != null) {
                    lockFreeTaskQueueCore.addLast((Runnable) obj);
                    lockFreeTaskQueueCore.addLast(runnable);
                    if (_queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                        return true;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            } else if (obj != null) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = (LockFreeTaskQueueCore) obj;
                int addLast = lockFreeTaskQueueCore2.addLast(runnable);
                if (addLast == 0) {
                    return true;
                }
                if (addLast == 1) {
                    _queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore2.next());
                } else if (addLast == 2) {
                    return false;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean isCompleted() {
        return this._isCompleted;
    }

    private final void rescheduleAllDelayed() {
        DelayedTask removeFirstOrNull;
        TimeSource timeSource = TimeSourceKt.getTimeSource();
        long nanoTime = timeSource != null ? timeSource.nanoTime() : System.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
            if (delayedTaskQueue == null || (removeFirstOrNull = delayedTaskQueue.removeFirstOrNull()) == null) {
                return;
            }
            reschedule(nanoTime, removeFirstOrNull);
        }
    }

    private final int scheduleImpl(long j2, DelayedTask delayedTask) {
        if (isCompleted()) {
            return 1;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null) {
            _delayed$FU.compareAndSet(this, null, new DelayedTaskQueue(j2));
            Object obj = this._delayed;
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            delayedTaskQueue = (DelayedTaskQueue) obj;
        }
        return delayedTask.scheduleTask(j2, delayedTaskQueue, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCompleted(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    private final boolean shouldUnpark(DelayedTask delayedTask) {
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        return (delayedTaskQueue != null ? delayedTaskQueue.peek() : null) == delayedTask;
    }

    @Override // kotlinx.coroutines.Delay
    public Object delay(long j2, Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j2, continuation);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        enqueue(runnable);
    }

    public final void enqueue(Runnable runnable) {
        if (enqueueImpl(runnable)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    public long getNextTime() {
        DelayedTask peek;
        Symbol symbol;
        if (super.getNextTime() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = EventLoop_commonKt.CLOSED_EMPTY;
                return obj == symbol ? Long.MAX_VALUE : 0L;
            } else if (!((LockFreeTaskQueueCore) obj).isEmpty()) {
                return 0L;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null || (peek = delayedTaskQueue.peek()) == null) {
            return Long.MAX_VALUE;
        }
        long j2 = peek.nanoTime;
        TimeSource timeSource = TimeSourceKt.getTimeSource();
        return RangesKt___RangesKt.coerceAtLeast(j2 - (timeSource != null ? timeSource.nanoTime() : System.nanoTime()), 0L);
    }

    public DisposableHandle invokeOnTimeout(long j2, Runnable runnable) {
        return Delay.DefaultImpls.invokeOnTimeout(this, j2, runnable);
    }

    @Override // kotlinx.coroutines.EventLoop
    public boolean isEmpty() {
        Symbol symbol;
        if (isUnconfinedQueueEmpty()) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
            if (delayedTaskQueue == null || delayedTaskQueue.isEmpty()) {
                Object obj = this._queue;
                if (obj != null) {
                    if (obj instanceof LockFreeTaskQueueCore) {
                        return ((LockFreeTaskQueueCore) obj).isEmpty();
                    }
                    symbol = EventLoop_commonKt.CLOSED_EMPTY;
                    if (obj != symbol) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0055  */
    @Override // kotlinx.coroutines.EventLoop
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long processNextEvent() {
        Runnable dequeue;
        DelayedTask delayedTask;
        if (processUnconfinedEvent()) {
            return getNextTime();
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            TimeSource timeSource = TimeSourceKt.getTimeSource();
            long nanoTime = timeSource != null ? timeSource.nanoTime() : System.nanoTime();
            do {
                synchronized (delayedTaskQueue) {
                    DelayedTask firstImpl = delayedTaskQueue.firstImpl();
                    if (firstImpl != null) {
                        DelayedTask delayedTask2 = firstImpl;
                        delayedTask = delayedTask2.timeToExecute(nanoTime) ? enqueueImpl(delayedTask2) : false ? delayedTaskQueue.removeAtImpl(0) : null;
                    }
                }
            } while (delayedTask != null);
            dequeue = dequeue();
            if (dequeue != null) {
            }
            return getNextTime();
        }
        dequeue = dequeue();
        if (dequeue != null) {
            dequeue.run();
        }
        return getNextTime();
    }

    public final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    public final void schedule(long j2, DelayedTask delayedTask) {
        int scheduleImpl = scheduleImpl(j2, delayedTask);
        if (scheduleImpl == 0) {
            if (shouldUnpark(delayedTask)) {
                unpark();
            }
        } else if (scheduleImpl == 1) {
            reschedule(j2, delayedTask);
        } else if (scheduleImpl != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    public final DisposableHandle scheduleInvokeOnTimeout(long j2, Runnable runnable) {
        long delayToNanos = EventLoop_commonKt.delayToNanos(j2);
        if (delayToNanos < 4611686018427387903L) {
            TimeSource timeSource = TimeSourceKt.getTimeSource();
            long nanoTime = timeSource != null ? timeSource.nanoTime() : System.nanoTime();
            DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(delayToNanos + nanoTime, runnable);
            schedule(nanoTime, delayedRunnableTask);
            return delayedRunnableTask;
        }
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long j2, CancellableContinuation<? super Unit> cancellableContinuation) {
        long delayToNanos = EventLoop_commonKt.delayToNanos(j2);
        if (delayToNanos < 4611686018427387903L) {
            TimeSource timeSource = TimeSourceKt.getTimeSource();
            long nanoTime = timeSource != null ? timeSource.nanoTime() : System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(delayToNanos + nanoTime, cancellableContinuation);
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuation, delayedResumeTask);
            schedule(nanoTime, delayedResumeTask);
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        setCompleted(true);
        closeQueue();
        do {
        } while (processNextEvent() <= 0);
        rescheduleAllDelayed();
    }
}
