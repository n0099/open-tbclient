package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes6.dex */
final class d {
    private final double quc;
    private final double qud;

    public boolean isEmpty() {
        return this.quc > this.qud;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.quc == ((d) obj).quc && this.qud == ((d) obj).qud));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.quc).hashCode() * 31) + Double.valueOf(this.qud).hashCode();
    }

    public String toString() {
        return "" + this.quc + IStringUtil.TOP_PATH + this.qud;
    }
}
