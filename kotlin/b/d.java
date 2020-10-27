package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes10.dex */
final class d {
    private final double pJB;
    private final double pJC;

    public boolean isEmpty() {
        return this.pJB > this.pJC;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.pJB == ((d) obj).pJB && this.pJC == ((d) obj).pJC));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.pJB).hashCode() * 31) + Double.valueOf(this.pJC).hashCode();
    }

    public String toString() {
        return this.pJB + IStringUtil.TOP_PATH + this.pJC;
    }
}
