package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes10.dex */
final class d {
    private final double pSV;
    private final double pSW;

    public boolean isEmpty() {
        return this.pSV > this.pSW;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.pSV == ((d) obj).pSV && this.pSW == ((d) obj).pSW));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.pSV).hashCode() * 31) + Double.valueOf(this.pSW).hashCode();
    }

    public String toString() {
        return this.pSV + IStringUtil.TOP_PATH + this.pSW;
    }
}
