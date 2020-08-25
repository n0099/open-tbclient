package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes20.dex */
final class d {
    private final double osQ;
    private final double osR;

    public boolean isEmpty() {
        return this.osQ > this.osR;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.osQ == ((d) obj).osQ && this.osR == ((d) obj).osR));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.osQ).hashCode() * 31) + Double.valueOf(this.osR).hashCode();
    }

    public String toString() {
        return this.osQ + IStringUtil.TOP_PATH + this.osR;
    }
}
