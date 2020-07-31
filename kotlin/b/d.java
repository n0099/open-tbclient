package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class d {
    private final double nYQ;
    private final double nYR;

    public boolean isEmpty() {
        return this.nYQ > this.nYR;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.nYQ == ((d) obj).nYQ && this.nYR == ((d) obj).nYR));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.nYQ).hashCode() * 31) + Double.valueOf(this.nYR).hashCode();
    }

    public String toString() {
        return this.nYQ + IStringUtil.TOP_PATH + this.nYR;
    }
}
