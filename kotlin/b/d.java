package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class d {
    private final double nCD;
    private final double nCE;

    public boolean isEmpty() {
        return this.nCD > this.nCE;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.nCD == ((d) obj).nCD && this.nCE == ((d) obj).nCE));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.nCD).hashCode() * 31) + Double.valueOf(this.nCE).hashCode();
    }

    public String toString() {
        return this.nCD + IStringUtil.TOP_PATH + this.nCE;
    }
}
