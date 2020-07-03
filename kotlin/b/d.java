package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class d {
    private final double nQe;
    private final double nQf;

    public boolean isEmpty() {
        return this.nQe > this.nQf;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.nQe == ((d) obj).nQe && this.nQf == ((d) obj).nQf));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.nQe).hashCode() * 31) + Double.valueOf(this.nQf).hashCode();
    }

    public String toString() {
        return this.nQe + IStringUtil.TOP_PATH + this.nQf;
    }
}
