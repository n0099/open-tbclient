package kotlin.ranges;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u000f\b\u0016\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B!\b\u0000\u0012\u0006\u0010\u001d\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0019\u0010\u001a\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\n¨\u0006\""}, d2 = {"Lkotlin/ranges/CharProgression;", "Ljava/lang/Iterable;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isEmpty", "()Z", "Lkotlin/collections/CharIterator;", "iterator", "()Lkotlin/collections/CharIterator;", "", "toString", "()Ljava/lang/String;", "", Config.TRACE_VISIT_FIRST, "C", "getFirst", "()C", "last", "getLast", "step", "I", "getStep", IntentConfig.START, "endInclusive", "<init>", "(CCI)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public class CharProgression implements Iterable<Character>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    public final char first;
    public final char last;
    public final int step;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlin/ranges/CharProgression$Companion;", "", "rangeStart", "rangeEnd", "", "step", "Lkotlin/ranges/CharProgression;", "fromClosedRange", "(CCI)Lkotlin/ranges/CharProgression;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public Companion() {
        }

        public final CharProgression fromClosedRange(char c2, char c3, int i2) {
            return new CharProgression(c2, c3, i2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CharProgression(char c2, char c3, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i2 != Integer.MIN_VALUE) {
            this.first = c2;
            this.last = (char) ProgressionUtilKt.getProgressionLastElement((int) c2, (int) c3, i2);
            this.step = i2;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public boolean equals(Object obj) {
        if (obj instanceof CharProgression) {
            if (!isEmpty() || !((CharProgression) obj).isEmpty()) {
                CharProgression charProgression = (CharProgression) obj;
                if (this.first != charProgression.first || this.last != charProgression.last || this.step != charProgression.step) {
                }
            }
            return true;
        }
        return false;
    }

    public final char getFirst() {
        return this.first;
    }

    public final char getLast() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    public boolean isEmpty() {
        if (this.step > 0) {
            if (Intrinsics.compare((int) this.first, (int) this.last) > 0) {
                return true;
            }
        } else if (Intrinsics.compare((int) this.first, (int) this.last) < 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.step > 0) {
            sb = new StringBuilder();
            sb.append(this.first);
            sb.append(IStringUtil.TOP_PATH);
            sb.append(this.last);
            sb.append(" step ");
            i2 = this.step;
        } else {
            sb = new StringBuilder();
            sb.append(this.first);
            sb.append(" downTo ");
            sb.append(this.last);
            sb.append(" step ");
            i2 = -this.step;
        }
        sb.append(i2);
        return sb.toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'kotlin.collections.CharIterator' to match base method */
    @Override // java.lang.Iterable
    public Iterator<Character> iterator() {
        return new CharProgressionIterator(this.first, this.last, this.step);
    }
}
