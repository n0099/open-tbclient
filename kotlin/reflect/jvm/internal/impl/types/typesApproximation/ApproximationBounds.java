package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes10.dex */
public final class ApproximationBounds<T> {
    public final T lower;
    public final T upper;

    public final T component1() {
        return this.lower;
    }

    public final T component2() {
        return this.upper;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ApproximationBounds) {
                ApproximationBounds approximationBounds = (ApproximationBounds) obj;
                return Intrinsics.areEqual(this.lower, approximationBounds.lower) && Intrinsics.areEqual(this.upper, approximationBounds.upper);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t = this.lower;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        T t2 = this.upper;
        return hashCode + (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.lower + ", upper=" + this.upper + SmallTailInfo.EMOTION_SUFFIX;
    }

    public ApproximationBounds(T t, T t2) {
        this.lower = t;
        this.upper = t2;
    }

    public final T getLower() {
        return this.lower;
    }

    public final T getUpper() {
        return this.upper;
    }
}
