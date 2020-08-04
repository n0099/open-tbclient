package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class d {
    private final double nYS;
    private final double nYT;

    public boolean isEmpty() {
        return this.nYS > this.nYT;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.nYS == ((d) obj).nYS && this.nYT == ((d) obj).nYT));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.nYS).hashCode() * 31) + Double.valueOf(this.nYT).hashCode();
    }

    public String toString() {
        return this.nYS + IStringUtil.TOP_PATH + this.nYT;
    }
}
