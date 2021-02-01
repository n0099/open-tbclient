package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes6.dex */
final class d {
    private final double qtC;
    private final double qtD;

    public boolean isEmpty() {
        return this.qtC > this.qtD;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.qtC == ((d) obj).qtC && this.qtD == ((d) obj).qtD));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.qtC).hashCode() * 31) + Double.valueOf(this.qtD).hashCode();
    }

    public String toString() {
        return "" + this.qtC + IStringUtil.TOP_PATH + this.qtD;
    }
}
