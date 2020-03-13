package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class d {
    private final double nCQ;
    private final double nCR;

    public boolean isEmpty() {
        return this.nCQ > this.nCR;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.nCQ == ((d) obj).nCQ && this.nCR == ((d) obj).nCR));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.nCQ).hashCode() * 31) + Double.valueOf(this.nCR).hashCode();
    }

    public String toString() {
        return this.nCQ + IStringUtil.TOP_PATH + this.nCR;
    }
}
