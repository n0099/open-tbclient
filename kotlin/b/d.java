package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes17.dex */
final class d {
    private final double pKM;
    private final double pKN;

    public boolean isEmpty() {
        return this.pKM > this.pKN;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.pKM == ((d) obj).pKM && this.pKN == ((d) obj).pKN));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.pKM).hashCode() * 31) + Double.valueOf(this.pKN).hashCode();
    }

    public String toString() {
        return "" + this.pKM + IStringUtil.TOP_PATH + this.pKN;
    }
}
