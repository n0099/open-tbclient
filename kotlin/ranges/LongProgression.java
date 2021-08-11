package kotlin.ranges;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\b\u0016\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B!\b\u0000\u0012\u0006\u0010\u001c\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0019\u0010\u001a\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017¨\u0006!"}, d2 = {"Lkotlin/ranges/LongProgression;", "Ljava/lang/Iterable;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isEmpty", "()Z", "Lkotlin/collections/LongIterator;", "iterator", "()Lkotlin/collections/LongIterator;", "", "toString", "()Ljava/lang/String;", "", "first", "J", "getFirst", "()J", "last", "getLast", ShaderParams.VALUE_TYPE_STEP, "getStep", "start", "endInclusive", "<init>", "(JJJ)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class LongProgression implements Iterable<Long>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    public final long first;
    public final long last;
    public final long step;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/ranges/LongProgression$Companion;", "", "rangeStart", "rangeEnd", ShaderParams.VALUE_TYPE_STEP, "Lkotlin/ranges/LongProgression;", "fromClosedRange", "(JJJ)Lkotlin/ranges/LongProgression;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public final LongProgression fromClosedRange(long j2, long j3, long j4) {
            return new LongProgression(j2, j3, j4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LongProgression(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j4 != Long.MIN_VALUE) {
            this.first = j2;
            this.last = ProgressionUtilKt.getProgressionLastElement(j2, j3, j4);
            this.step = j4;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    }

    public boolean equals(Object obj) {
        if (obj instanceof LongProgression) {
            if (!isEmpty() || !((LongProgression) obj).isEmpty()) {
                LongProgression longProgression = (LongProgression) obj;
                if (this.first != longProgression.first || this.last != longProgression.last || this.step != longProgression.step) {
                }
            }
            return true;
        }
        return false;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getLast() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j2 = 31;
        long j3 = this.first;
        long j4 = this.last;
        long j5 = j2 * (((j3 ^ (j3 >>> 32)) * j2) + (j4 ^ (j4 >>> 32)));
        long j6 = this.step;
        return (int) (j5 + (j6 ^ (j6 >>> 32)));
    }

    public boolean isEmpty() {
        int i2 = (this.step > 0L ? 1 : (this.step == 0L ? 0 : -1));
        long j2 = this.first;
        long j3 = this.last;
        if (i2 > 0) {
            if (j2 > j3) {
                return true;
            }
        } else if (j2 < j3) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        long j2;
        if (this.step > 0) {
            sb = new StringBuilder();
            sb.append(this.first);
            sb.append(IStringUtil.TOP_PATH);
            sb.append(this.last);
            sb.append(" step ");
            j2 = this.step;
        } else {
            sb = new StringBuilder();
            sb.append(this.first);
            sb.append(" downTo ");
            sb.append(this.last);
            sb.append(" step ");
            j2 = -this.step;
        }
        sb.append(j2);
        return sb.toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'kotlin.collections.LongIterator' to match base method */
    @Override // java.lang.Iterable
    public Iterator<Long> iterator() {
        return new LongProgressionIterator(this.first, this.last, this.step);
    }
}
