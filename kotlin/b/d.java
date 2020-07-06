package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class d {
    private final double nQh;
    private final double nQi;

    public boolean isEmpty() {
        return this.nQh > this.nQi;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.nQh == ((d) obj).nQh && this.nQi == ((d) obj).nQi));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.nQh).hashCode() * 31) + Double.valueOf(this.nQi).hashCode();
    }

    public String toString() {
        return this.nQh + IStringUtil.TOP_PATH + this.nQi;
    }
}
