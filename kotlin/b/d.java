package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes14.dex */
final class d {
    private final double quE;
    private final double quF;

    public boolean isEmpty() {
        return this.quE > this.quF;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.quE == ((d) obj).quE && this.quF == ((d) obj).quF));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.quE).hashCode() * 31) + Double.valueOf(this.quF).hashCode();
    }

    public String toString() {
        return "" + this.quE + IStringUtil.TOP_PATH + this.quF;
    }
}
