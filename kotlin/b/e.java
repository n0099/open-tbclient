package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class e {
    private final float nCF;
    private final float nCG;

    public boolean isEmpty() {
        return this.nCF > this.nCG;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.nCF == ((e) obj).nCF && this.nCG == ((e) obj).nCG));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.nCF).hashCode() * 31) + Float.valueOf(this.nCG).hashCode();
    }

    public String toString() {
        return this.nCF + IStringUtil.TOP_PATH + this.nCG;
    }
}
