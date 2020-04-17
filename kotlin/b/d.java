package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class d {
    private final double mYc;
    private final double mYd;

    public boolean isEmpty() {
        return this.mYc > this.mYd;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.mYc == ((d) obj).mYc && this.mYd == ((d) obj).mYd));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.mYc).hashCode() * 31) + Double.valueOf(this.mYd).hashCode();
    }

    public String toString() {
        return this.mYc + IStringUtil.TOP_PATH + this.mYd;
    }
}
