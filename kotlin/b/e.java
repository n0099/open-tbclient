package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes17.dex */
final class e {
    private final float pKO;
    private final float pKP;

    public boolean isEmpty() {
        return this.pKO > this.pKP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.pKO == ((e) obj).pKO && this.pKP == ((e) obj).pKP));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.pKO).hashCode() * 31) + Float.valueOf(this.pKP).hashCode();
    }

    public String toString() {
        return "" + this.pKO + IStringUtil.TOP_PATH + this.pKP;
    }
}
