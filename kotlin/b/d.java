package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class d {
    private final double nus;
    private final double nut;

    public boolean isEmpty() {
        return this.nus > this.nut;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.nus == ((d) obj).nus && this.nut == ((d) obj).nut));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.nus).hashCode() * 31) + Double.valueOf(this.nut).hashCode();
    }

    public String toString() {
        return this.nus + IStringUtil.TOP_PATH + this.nut;
    }
}
