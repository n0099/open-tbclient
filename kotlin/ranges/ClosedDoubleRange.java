package kotlin.ranges;

import com.baidu.android.common.others.IStringUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(DD)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", "other", "", TTDownloadField.TT_HASHCODE, "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClosedDoubleRange implements ClosedFloatingPointRange<Double> {
    public final double _endInclusive;
    public final double _start;

    public boolean lessThanOrEquals(double d, double d2) {
        return d <= d2;
    }

    public ClosedDoubleRange(double d, double d2) {
        this._start = d;
        this._endInclusive = d2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable, java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Double d, Double d2) {
        return lessThanOrEquals(d.doubleValue(), d2.doubleValue());
    }

    public boolean contains(double d) {
        if (d >= this._start && d <= this._endInclusive) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).doubleValue());
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj instanceof ClosedDoubleRange) {
            if (isEmpty() && ((ClosedDoubleRange) obj).isEmpty()) {
                return true;
            }
            ClosedDoubleRange closedDoubleRange = (ClosedDoubleRange) obj;
            if (this._start == closedDoubleRange._start) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (this._endInclusive == closedDoubleRange._endInclusive) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this._start).hashCode() * 31) + Double.valueOf(this._endInclusive).hashCode();
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        if (this._start > this._endInclusive) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this._start + IStringUtil.TOP_PATH + this._endInclusive;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.ranges.ClosedRange
    public Double getEndInclusive() {
        return Double.valueOf(this._endInclusive);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.ranges.ClosedRange
    public Double getStart() {
        return Double.valueOf(this._start);
    }
}
