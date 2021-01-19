package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes5.dex */
final class d {
    private final double qjy;
    private final double qjz;

    public boolean isEmpty() {
        return this.qjy > this.qjz;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.qjy == ((d) obj).qjy && this.qjz == ((d) obj).qjz));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.qjy).hashCode() * 31) + Double.valueOf(this.qjz).hashCode();
    }

    public String toString() {
        return "" + this.qjy + IStringUtil.TOP_PATH + this.qjz;
    }
}
