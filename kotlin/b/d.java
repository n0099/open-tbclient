package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class d {
    private final double nth;
    private final double nti;

    public boolean isEmpty() {
        return this.nth > this.nti;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.nth == ((d) obj).nth && this.nti == ((d) obj).nti));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.nth).hashCode() * 31) + Double.valueOf(this.nti).hashCode();
    }

    public String toString() {
        return this.nth + IStringUtil.TOP_PATH + this.nti;
    }
}
