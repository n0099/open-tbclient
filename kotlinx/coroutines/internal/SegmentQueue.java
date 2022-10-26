package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\b \u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\r\u0010\fJ#\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00028\u00008D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00028\u00008D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/SegmentQueue;", "Lkotlinx/coroutines/internal/Segment;", ExifInterface.LATITUDE_SOUTH, "startFrom", "", "id", "getSegment", "(Lkotlinx/coroutines/internal/Segment;J)Lkotlinx/coroutines/internal/Segment;", "getSegmentAndMoveHead", "new", "", "moveHeadForward", "(Lkotlinx/coroutines/internal/Segment;)V", "moveTailForward", "prev", "newSegment", "(JLkotlinx/coroutines/internal/Segment;)Lkotlinx/coroutines/internal/Segment;", "getHead", "()Lkotlinx/coroutines/internal/Segment;", "head", "getTail", "tail", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public abstract class SegmentQueue {
    public static final AtomicReferenceFieldUpdater _head$FU = AtomicReferenceFieldUpdater.newUpdater(SegmentQueue.class, Object.class, "_head");
    public static final AtomicReferenceFieldUpdater _tail$FU = AtomicReferenceFieldUpdater.newUpdater(SegmentQueue.class, Object.class, "_tail");
    public volatile Object _head;
    public volatile Object _tail;

    public abstract Segment newSegment(long j, Segment segment);

    public SegmentQueue() {
        Segment newSegment$default = newSegment$default(this, 0L, null, 2, null);
        this._head = newSegment$default;
        this._tail = newSegment$default;
    }

    public final Segment getHead() {
        return (Segment) this._head;
    }

    public final Segment getTail() {
        return (Segment) this._tail;
    }

    private final void moveHeadForward(Segment segment) {
        Segment segment2;
        do {
            segment2 = (Segment) this._head;
            if (segment2.getId() > segment.getId()) {
                return;
            }
        } while (!_head$FU.compareAndSet(this, segment2, segment));
        segment.prev = null;
    }

    private final void moveTailForward(Segment segment) {
        Segment segment2;
        do {
            segment2 = (Segment) this._tail;
            if (segment2.getId() > segment.getId()) {
                return;
            }
        } while (!_tail$FU.compareAndSet(this, segment2, segment));
    }

    public static /* synthetic */ Segment newSegment$default(SegmentQueue segmentQueue, long j, Segment segment, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                segment = null;
            }
            return segmentQueue.newSegment(j, segment);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newSegment");
    }

    public final Segment getSegment(Segment segment, long j) {
        while (segment.getId() < j) {
            Segment next = segment.getNext();
            if (next == null) {
                next = newSegment(segment.getId() + 1, segment);
                if (segment.casNext(null, next)) {
                    if (segment.getRemoved()) {
                        segment.remove();
                    }
                    moveTailForward(next);
                } else {
                    next = segment.getNext();
                    if (next == null) {
                        Intrinsics.throwNpe();
                    }
                }
            }
            segment = next;
        }
        if (segment.getId() != j) {
            return null;
        }
        return segment;
    }

    public final Segment getSegmentAndMoveHead(Segment segment, long j) {
        if (segment.getId() == j) {
            return segment;
        }
        Segment segment2 = getSegment(segment, j);
        if (segment2 != null) {
            moveHeadForward(segment2);
            return segment2;
        }
        return null;
    }
}
