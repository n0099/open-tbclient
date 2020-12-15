package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes17.dex */
final class d {
    private final double pKO;
    private final double pKP;

    public boolean isEmpty() {
        return this.pKO > this.pKP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.pKO == ((d) obj).pKO && this.pKP == ((d) obj).pKP));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.pKO).hashCode() * 31) + Double.valueOf(this.pKP).hashCode();
    }

    public String toString() {
        return "" + this.pKO + IStringUtil.TOP_PATH + this.pKP;
    }
}
