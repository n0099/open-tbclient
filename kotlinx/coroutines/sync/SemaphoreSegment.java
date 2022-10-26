package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\f\u0010\rJ$\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreSegment;", "Lkotlinx/coroutines/internal/Segment;", "", "index", "", "cancel", "(I)Z", "", "expected", "value", "cas", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "get", "(I)Ljava/lang/Object;", "getAndSet", "(ILjava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "getRemoved", "()Z", "removed", "", "id", "prev", "<init>", "(JLkotlinx/coroutines/sync/SemaphoreSegment;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class SemaphoreSegment extends Segment {
    public static final AtomicIntegerFieldUpdater cancelledSlots$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreSegment.class, "cancelledSlots");
    public AtomicReferenceArray acquirers;
    public volatile int cancelledSlots;

    public SemaphoreSegment(long j, SemaphoreSegment semaphoreSegment) {
        super(j, semaphoreSegment);
        int i;
        i = SemaphoreKt.SEGMENT_SIZE;
        this.acquirers = new AtomicReferenceArray(i);
        this.cancelledSlots = 0;
    }

    public final Object getAndSet(int i, Object obj) {
        return this.acquirers.getAndSet(i, obj);
    }

    public final boolean cancel(int i) {
        Symbol symbol;
        Symbol symbol2;
        boolean z;
        int i2;
        symbol = SemaphoreKt.CANCELLED;
        Object andSet = this.acquirers.getAndSet(i, symbol);
        symbol2 = SemaphoreKt.RESUMED;
        if (andSet != symbol2) {
            z = true;
        } else {
            z = false;
        }
        int incrementAndGet = cancelledSlots$FU.incrementAndGet(this);
        i2 = SemaphoreKt.SEGMENT_SIZE;
        if (incrementAndGet == i2) {
            remove();
        }
        return z;
    }

    public final Object get(int i) {
        return this.acquirers.get(i);
    }

    public final boolean cas(int i, Object obj, Object obj2) {
        return this.acquirers.compareAndSet(i, obj, obj2);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public boolean getRemoved() {
        int i;
        int i2 = this.cancelledSlots;
        i = SemaphoreKt.SEGMENT_SIZE;
        if (i2 == i) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + getId() + ", hashCode=" + hashCode() + ']';
    }
}
