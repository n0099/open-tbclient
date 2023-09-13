package kotlin.ranges;

import com.baidu.android.common.others.IStringUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(FF)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Float;", "getStart", "contains", "", "value", "equals", "other", "", TTDownloadField.TT_HASHCODE, "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {
    public final float _endInclusive;
    public final float _start;

    public boolean lessThanOrEquals(float f, float f2) {
        return f <= f2;
    }

    public ClosedFloatRange(float f, float f2) {
        this._start = f;
        this._endInclusive = f2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable, java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Float f, Float f2) {
        return lessThanOrEquals(f.floatValue(), f2.floatValue());
    }

    public boolean contains(float f) {
        if (f >= this._start && f <= this._endInclusive) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).floatValue());
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj instanceof ClosedFloatRange) {
            if (isEmpty() && ((ClosedFloatRange) obj).isEmpty()) {
                return true;
            }
            ClosedFloatRange closedFloatRange = (ClosedFloatRange) obj;
            if (this._start == closedFloatRange._start) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (this._endInclusive == closedFloatRange._endInclusive) {
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
        return (Float.valueOf(this._start).hashCode() * 31) + Float.valueOf(this._endInclusive).hashCode();
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
    public Float getEndInclusive() {
        return Float.valueOf(this._endInclusive);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.ranges.ClosedRange
    public Float getStart() {
        return Float.valueOf(this._start);
    }
}
