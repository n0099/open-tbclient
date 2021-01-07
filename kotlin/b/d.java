package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes5.dex */
final class d {
    private final double qnZ;
    private final double qoa;

    public boolean isEmpty() {
        return this.qnZ > this.qoa;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.qnZ == ((d) obj).qnZ && this.qoa == ((d) obj).qoa));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.qnZ).hashCode() * 31) + Double.valueOf(this.qoa).hashCode();
    }

    public String toString() {
        return "" + this.qnZ + IStringUtil.TOP_PATH + this.qoa;
    }
}
