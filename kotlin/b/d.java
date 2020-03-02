package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class d {
    private final double nCF;
    private final double nCG;

    public boolean isEmpty() {
        return this.nCF > this.nCG;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.nCF == ((d) obj).nCF && this.nCG == ((d) obj).nCG));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.nCF).hashCode() * 31) + Double.valueOf(this.nCG).hashCode();
    }

    public String toString() {
        return this.nCF + IStringUtil.TOP_PATH + this.nCG;
    }
}
