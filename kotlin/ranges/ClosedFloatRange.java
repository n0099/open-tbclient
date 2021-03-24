package kotlin.ranges;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006!"}, d2 = {"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "value", "", "contains", "(F)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isEmpty", "()Z", "a", "b", "lessThanOrEquals", "(FF)Z", "", "toString", "()Ljava/lang/String;", "_endInclusive", "F", "_start", "getEndInclusive", "()Ljava/lang/Float;", "endInclusive", "getStart", IntentConfig.START, "<init>", "(FF)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {
    public final float _endInclusive;
    public final float _start;

    public ClosedFloatRange(float f2, float f3) {
        this._start = f2;
        this._endInclusive = f3;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).floatValue());
    }

    public boolean equals(Object obj) {
        if (obj instanceof ClosedFloatRange) {
            if (!isEmpty() || !((ClosedFloatRange) obj).isEmpty()) {
                ClosedFloatRange closedFloatRange = (ClosedFloatRange) obj;
                if (this._start != closedFloatRange._start || this._endInclusive != closedFloatRange._endInclusive) {
                }
            }
            return true;
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
        return this._start > this._endInclusive;
    }

    public boolean lessThanOrEquals(float f2, float f3) {
        return f2 <= f3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable, java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Float f2, Float f3) {
        return lessThanOrEquals(f2.floatValue(), f3.floatValue());
    }

    public String toString() {
        return this._start + IStringUtil.TOP_PATH + this._endInclusive;
    }

    public boolean contains(float f2) {
        return f2 >= this._start && f2 <= this._endInclusive;
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
