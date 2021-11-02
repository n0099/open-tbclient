package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.IStringUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0013\u001a\u00028\u0000\u0012\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00028\u00008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00028\u00008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0017"}, d2 = {"Lkotlin/ranges/ComparableRange;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/ranges/ClosedRange;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "", "toString", "()Ljava/lang/String;", "endInclusive", "Ljava/lang/Comparable;", "getEndInclusive", "()Ljava/lang/Comparable;", "start", "getStart", "<init>", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public class ComparableRange<T extends Comparable<? super T>> implements ClosedRange<T> {
    public final T endInclusive;
    public final T start;

    public ComparableRange(T start, T endInclusive) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(endInclusive, "endInclusive");
        this.start = start;
        this.endInclusive = endInclusive;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean contains(T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return ClosedRange.DefaultImpls.contains(this, value);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ComparableRange) {
            if (!isEmpty() || !((ComparableRange) obj).isEmpty()) {
                ComparableRange comparableRange = (ComparableRange) obj;
                if (!Intrinsics.areEqual(getStart(), comparableRange.getStart()) || !Intrinsics.areEqual(getEndInclusive(), comparableRange.getEndInclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public T getEndInclusive() {
        return this.endInclusive;
    }

    @Override // kotlin.ranges.ClosedRange
    public T getStart() {
        return this.start;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }

    public String toString() {
        return getStart() + IStringUtil.TOP_PATH + getEndInclusive();
    }
}
