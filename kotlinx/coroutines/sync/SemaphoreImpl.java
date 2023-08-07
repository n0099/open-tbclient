package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSlowPath", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", "addAcquireToQueue", "(Lkotlinx/coroutines/CancellableContinuation;)Z", "release", "()V", "tryAcquire", "()Z", "tryResumeNextFromQueue", "tryResumeAcquire", "getAvailablePermits", "()I", "availablePermits", "Lkotlin/Function1;", "", "onCancellationRelease", "Lkotlin/jvm/functions/Function1;", "I", "kotlinx-coroutines-core", "Lkotlinx/coroutines/sync/Semaphore;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SemaphoreImpl implements Semaphore {
    public volatile /* synthetic */ int _availablePermits;
    public volatile /* synthetic */ long deqIdx = 0;
    public volatile /* synthetic */ long enqIdx = 0;
    public volatile /* synthetic */ Object head;
    public final Function1<Throwable, Unit> onCancellationRelease;
    public final int permits;
    public volatile /* synthetic */ Object tail;
    public static final /* synthetic */ AtomicReferenceFieldUpdater head$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
    public static final /* synthetic */ AtomicLongFieldUpdater deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
    public static final /* synthetic */ AtomicReferenceFieldUpdater tail$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
    public static final /* synthetic */ AtomicLongFieldUpdater enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
    public static final /* synthetic */ AtomicIntegerFieldUpdater _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");

    public SemaphoreImpl(int i, int i2) {
        boolean z;
        this.permits = i;
        boolean z2 = true;
        if (this.permits > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if ((i2 < 0 || i2 > this.permits) ? false : false) {
                SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
                this.head = semaphoreSegment;
                this.tail = semaphoreSegment;
                this._availablePermits = this.permits - i2;
                this.onCancellationRelease = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
                    {
                        super(1);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        SemaphoreImpl.this.release();
                    }
                };
                return;
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("The number of acquired permits should be in 0..", Integer.valueOf(this.permits)).toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Semaphore should have at least 1 permit, but had ", Integer.valueOf(this.permits)).toString());
    }

    private final boolean tryResumeAcquire(CancellableContinuation<? super Unit> cancellableContinuation) {
        Object tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
        if (tryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(tryResume);
        return true;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public Object acquire(Continuation<? super Unit> continuation) {
        if (_availablePermits$FU.getAndDecrement(this) > 0) {
            return Unit.INSTANCE;
        }
        Object acquireSlowPath = acquireSlowPath(continuation);
        if (acquireSlowPath == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return acquireSlowPath;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object acquireSlowPath(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        while (true) {
            if (!addAcquireToQueue(orCreateCancellableContinuation)) {
                if (_availablePermits$FU.getAndDecrement(this) > 0) {
                    orCreateCancellableContinuation.resume(Unit.INSTANCE, this.onCancellationRelease);
                    break;
                }
            } else {
                break;
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0074, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean addAcquireToQueue(CancellableContinuation<? super Unit> cancellableContinuation) {
        int i;
        Object m2345constructorimpl;
        boolean z;
        int i2;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        boolean z2;
        Segment segment = (SemaphoreSegment) this.tail;
        long andIncrement = enqIdx$FU.getAndIncrement(this);
        i = SemaphoreKt.SEGMENT_SIZE;
        long j = andIncrement / i;
        do {
            Segment segment2 = segment;
            while (true) {
                if (segment2.getId() < j || segment2.getRemoved()) {
                    Object nextOrClosed = segment2.getNextOrClosed();
                    if (nextOrClosed == ConcurrentLinkedListKt.CLOSED) {
                        m2345constructorimpl = SegmentOrClosed.m2345constructorimpl(ConcurrentLinkedListKt.CLOSED);
                        break;
                    }
                    Segment segment3 = (Segment) ((ConcurrentLinkedListNode) nextOrClosed);
                    if (segment3 == null) {
                        segment3 = SemaphoreKt.createSegment(segment2.getId() + 1, (SemaphoreSegment) segment2);
                        if (segment2.trySetNext(segment3)) {
                            if (segment2.getRemoved()) {
                                segment2.remove();
                            }
                        }
                    }
                    segment2 = segment3;
                } else {
                    m2345constructorimpl = SegmentOrClosed.m2345constructorimpl(segment2);
                    break;
                }
            }
            z = true;
            if (!SegmentOrClosed.m2350isClosedimpl(m2345constructorimpl)) {
                Segment m2348getSegmentimpl = SegmentOrClosed.m2348getSegmentimpl(m2345constructorimpl);
                while (true) {
                    Segment segment4 = (Segment) this.tail;
                    if (segment4.getId() >= m2348getSegmentimpl.getId()) {
                        break;
                    } else if (!m2348getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        z2 = false;
                        continue;
                        break;
                    } else if (tail$FU.compareAndSet(this, segment4, m2348getSegmentimpl)) {
                        if (segment4.decPointers$kotlinx_coroutines_core()) {
                            segment4.remove();
                        }
                    } else if (m2348getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        m2348getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        } while (!z2);
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) SegmentOrClosed.m2348getSegmentimpl(m2345constructorimpl);
        i2 = SemaphoreKt.SEGMENT_SIZE;
        int i3 = (int) (andIncrement % i2);
        if (!semaphoreSegment.acquirers.compareAndSet(i3, null, cancellableContinuation)) {
            symbol = SemaphoreKt.PERMIT;
            symbol2 = SemaphoreKt.TAKEN;
            if (semaphoreSegment.acquirers.compareAndSet(i3, symbol, symbol2)) {
                cancellableContinuation.resume(Unit.INSTANCE, this.onCancellationRelease);
                return true;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                Object obj = semaphoreSegment.acquirers.get(i3);
                symbol3 = SemaphoreKt.BROKEN;
                if (obj != symbol3) {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            return false;
        }
        cancellableContinuation.invokeOnCancellation(new CancelSemaphoreAcquisitionHandler(semaphoreSegment, i3));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0070, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean tryResumeNextFromQueue() {
        int i;
        Object m2345constructorimpl;
        int i2;
        int i3;
        Symbol symbol;
        Symbol symbol2;
        int i4;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        boolean z;
        Segment segment = (SemaphoreSegment) this.head;
        long andIncrement = deqIdx$FU.getAndIncrement(this);
        i = SemaphoreKt.SEGMENT_SIZE;
        long j = andIncrement / i;
        do {
            Segment segment2 = segment;
            while (true) {
                if (segment2.getId() < j || segment2.getRemoved()) {
                    Object nextOrClosed = segment2.getNextOrClosed();
                    if (nextOrClosed == ConcurrentLinkedListKt.CLOSED) {
                        m2345constructorimpl = SegmentOrClosed.m2345constructorimpl(ConcurrentLinkedListKt.CLOSED);
                        break;
                    }
                    Segment segment3 = (Segment) ((ConcurrentLinkedListNode) nextOrClosed);
                    if (segment3 == null) {
                        segment3 = SemaphoreKt.createSegment(segment2.getId() + 1, (SemaphoreSegment) segment2);
                        if (segment2.trySetNext(segment3)) {
                            if (segment2.getRemoved()) {
                                segment2.remove();
                            }
                        }
                    }
                    segment2 = segment3;
                } else {
                    m2345constructorimpl = SegmentOrClosed.m2345constructorimpl(segment2);
                    break;
                }
            }
            i2 = 0;
            if (!SegmentOrClosed.m2350isClosedimpl(m2345constructorimpl)) {
                Segment m2348getSegmentimpl = SegmentOrClosed.m2348getSegmentimpl(m2345constructorimpl);
                while (true) {
                    Segment segment4 = (Segment) this.head;
                    if (segment4.getId() >= m2348getSegmentimpl.getId()) {
                        break;
                    } else if (!m2348getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        z = false;
                        continue;
                        break;
                    } else if (head$FU.compareAndSet(this, segment4, m2348getSegmentimpl)) {
                        if (segment4.decPointers$kotlinx_coroutines_core()) {
                            segment4.remove();
                        }
                    } else if (m2348getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        m2348getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        } while (!z);
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) SegmentOrClosed.m2348getSegmentimpl(m2345constructorimpl);
        semaphoreSegment.cleanPrev();
        if (semaphoreSegment.getId() <= j) {
            i3 = SemaphoreKt.SEGMENT_SIZE;
            int i5 = (int) (andIncrement % i3);
            symbol = SemaphoreKt.PERMIT;
            Object andSet = semaphoreSegment.acquirers.getAndSet(i5, symbol);
            if (andSet == null) {
                i4 = SemaphoreKt.MAX_SPIN_CYCLES;
                while (i2 < i4) {
                    i2++;
                    Object obj = semaphoreSegment.acquirers.get(i5);
                    symbol5 = SemaphoreKt.TAKEN;
                    if (obj == symbol5) {
                        return true;
                    }
                }
                symbol3 = SemaphoreKt.PERMIT;
                symbol4 = SemaphoreKt.BROKEN;
                return !semaphoreSegment.acquirers.compareAndSet(i5, symbol3, symbol4);
            }
            symbol2 = SemaphoreKt.CANCELLED;
            if (andSet == symbol2) {
                return false;
            }
            return tryResumeAcquire((CancellableContinuation) andSet);
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return Math.max(this._availablePermits, 0);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
        int i;
        do {
            i = this._availablePermits;
            if (i <= 0) {
                return false;
            }
        } while (!_availablePermits$FU.compareAndSet(this, i, i - 1));
        return true;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        boolean z;
        while (true) {
            int i = this._availablePermits;
            if (i < this.permits) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (_availablePermits$FU.compareAndSet(this, i, i + 1) && (i >= 0 || tryResumeNextFromQueue())) {
                    return;
                }
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("The number of released permits cannot be greater than ", Integer.valueOf(this.permits)).toString());
            }
        }
    }
}
