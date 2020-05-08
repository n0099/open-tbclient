package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class d {
    private final double mYf;
    private final double mYg;

    public boolean isEmpty() {
        return this.mYf > this.mYg;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.mYf == ((d) obj).mYf && this.mYg == ((d) obj).mYg));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.mYf).hashCode() * 31) + Double.valueOf(this.mYg).hashCode();
    }

    public String toString() {
        return this.mYf + IStringUtil.TOP_PATH + this.mYg;
    }
}
