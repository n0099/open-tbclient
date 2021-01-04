package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes5.dex */
final class d {
    private final double qmr;
    private final double qms;

    public boolean isEmpty() {
        return this.qmr > this.qms;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.qmr == ((d) obj).qmr && this.qms == ((d) obj).qms));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.qmr).hashCode() * 31) + Double.valueOf(this.qms).hashCode();
    }

    public String toString() {
        return "" + this.qmr + IStringUtil.TOP_PATH + this.qms;
    }
}
