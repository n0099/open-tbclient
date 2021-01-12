package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes5.dex */
final class d {
    private final double qjx;
    private final double qjy;

    public boolean isEmpty() {
        return this.qjx > this.qjy;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.qjx == ((d) obj).qjx && this.qjy == ((d) obj).qjy));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.qjx).hashCode() * 31) + Double.valueOf(this.qjy).hashCode();
    }

    public String toString() {
        return "" + this.qjx + IStringUtil.TOP_PATH + this.qjy;
    }
}
