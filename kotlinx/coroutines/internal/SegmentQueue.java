package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\b \u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\r\u0010\fJ#\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00028\u00008D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00028\u00008D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/SegmentQueue;", "Lkotlinx/coroutines/internal/Segment;", "S", "startFrom", "", "id", "getSegment", "(Lkotlinx/coroutines/internal/Segment;J)Lkotlinx/coroutines/internal/Segment;", "getSegmentAndMoveHead", "new", "", "moveHeadForward", "(Lkotlinx/coroutines/internal/Segment;)V", "moveTailForward", "prev", "newSegment", "(JLkotlinx/coroutines/internal/Segment;)Lkotlinx/coroutines/internal/Segment;", "getHead", "()Lkotlinx/coroutines/internal/Segment;", "head", "getTail", "tail", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class SegmentQueue<S extends Segment<S>> {
    public static final AtomicReferenceFieldUpdater _head$FU = AtomicReferenceFieldUpdater.newUpdater(SegmentQueue.class, Object.class, "_head");
    public static final AtomicReferenceFieldUpdater _tail$FU = AtomicReferenceFieldUpdater.newUpdater(SegmentQueue.class, Object.class, "_tail");
    public volatile Object _head;
    public volatile Object _tail;

    public SegmentQueue() {
        Segment newSegment$default = newSegment$default(this, 0L, null, 2, null);
        this._head = newSegment$default;
        this._tail = newSegment$default;
    }

    private final void moveHeadForward(S s) {
        Segment segment;
        do {
            segment = (Segment) this._head;
            if (segment.getId() > s.getId()) {
                return;
            }
        } while (!_head$FU.compareAndSet(this, segment, s));
        s.prev = null;
    }

    private final void moveTailForward(S s) {
        Segment segment;
        do {
            segment = (Segment) this._tail;
            if (segment.getId() > s.getId()) {
                return;
            }
        } while (!_tail$FU.compareAndSet(this, segment, s));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlinx.coroutines.internal.SegmentQueue */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Segment newSegment$default(SegmentQueue segmentQueue, long j2, Segment segment, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                segment = null;
            }
            return segmentQueue.newSegment(j2, segment);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newSegment");
    }

    public final S getHead() {
        return (S) this._head;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlinx.coroutines.internal.SegmentQueue<S extends kotlinx.coroutines.internal.Segment<S>> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v9, resolved type: S extends kotlinx.coroutines.internal.Segment<S> */
    /* JADX WARN: Multi-variable type inference failed */
    public final S getSegment(S s, long j2) {
        while (s.getId() < j2) {
            Object next = s.getNext();
            if (next == null) {
                next = newSegment(s.getId() + 1, s);
                if (s.casNext(null, next)) {
                    if (s.getRemoved()) {
                        s.remove();
                    }
                    moveTailForward(next);
                } else {
                    next = s.getNext();
                    if (next == null) {
                        Intrinsics.throwNpe();
                    }
                }
            }
            s = (S) next;
        }
        if (s.getId() != j2) {
            return null;
        }
        return s;
    }

    public final S getSegmentAndMoveHead(S s, long j2) {
        if (s.getId() == j2) {
            return s;
        }
        S segment = getSegment(s, j2);
        if (segment != null) {
            moveHeadForward(segment);
            return segment;
        }
        return null;
    }

    public final S getTail() {
        return (S) this._tail;
    }

    public abstract S newSegment(long j2, S s);
}
