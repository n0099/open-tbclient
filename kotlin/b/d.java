package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class d {
    private final double nED;
    private final double nEE;

    public boolean isEmpty() {
        return this.nED > this.nEE;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.nED == ((d) obj).nED && this.nEE == ((d) obj).nEE));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.nED).hashCode() * 31) + Double.valueOf(this.nEE).hashCode();
    }

    public String toString() {
        return this.nED + IStringUtil.TOP_PATH + this.nEE;
    }
}
