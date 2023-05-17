package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.Segment;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u0005\u001a\u00020\u00042\b\u0010\u0002\u001a\u0004\u0018\u00018\u00002\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\f\u0010\nJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/internal/Segment;", ExifInterface.LATITUDE_SOUTH, "expected", "value", "", "casNext", "(Lkotlinx/coroutines/internal/Segment;Lkotlinx/coroutines/internal/Segment;)Z", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "", "moveNextToRight", "(Lkotlinx/coroutines/internal/Segment;)V", "prev", "movePrevToLeft", "remove", "()V", "", "id", "J", "getId", "()J", "getNext", "()Lkotlinx/coroutines/internal/Segment;", "getRemoved", "()Z", "removed", "<init>", "(JLkotlinx/coroutines/internal/Segment;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public abstract class Segment<S extends Segment<S>> {
    public static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(Segment.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater prev$FU = AtomicReferenceFieldUpdater.newUpdater(Segment.class, Object.class, "prev");
    public volatile Object _next = null;
    public final long id;
    public volatile Object prev;

    public abstract boolean getRemoved();

    public Segment(long j, S s) {
        this.id = j;
        this.prev = null;
        this.prev = s;
    }

    public final boolean casNext(S s, S s2) {
        return _next$FU.compareAndSet(this, s, s2);
    }

    private final void moveNextToRight(S s) {
        Segment segment;
        do {
            Object obj = this._next;
            if (obj != null) {
                segment = (Segment) obj;
                if (s.id <= segment.id) {
                    return;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type S");
            }
        } while (!_next$FU.compareAndSet(this, segment, s));
    }

    private final void movePrevToLeft(S s) {
        Segment segment;
        do {
            segment = (Segment) this.prev;
            if (segment == null || segment.id <= s.id) {
                return;
            }
        } while (!prev$FU.compareAndSet(this, segment, s));
    }

    public final long getId() {
        return this.id;
    }

    public final S getNext() {
        return (S) this._next;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: kotlinx.coroutines.internal.Segment */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: kotlinx.coroutines.internal.Segment */
    /* JADX WARN: Multi-variable type inference failed */
    public final void remove() {
        Segment segment;
        Segment next;
        Segment segment2;
        if (DebugKt.getASSERTIONS_ENABLED() && !getRemoved()) {
            throw new AssertionError();
        }
        Segment segment3 = (Segment) this._next;
        if (segment3 != null && (segment = (Segment) this.prev) != 0) {
            segment.moveNextToRight(segment3);
            S s = segment;
            while (s.getRemoved() && (segment2 = (Segment) s.prev) != 0) {
                segment2.moveNextToRight(segment3);
                s = segment2;
            }
            segment3.movePrevToLeft(s);
            Segment segment4 = segment3;
            while (segment4.getRemoved() && (next = segment4.getNext()) != null) {
                next.movePrevToLeft(s);
                segment4 = next;
            }
        }
    }
}
