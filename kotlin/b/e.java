package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes17.dex */
final class e {
    private final float pKQ;
    private final float pKR;

    public boolean isEmpty() {
        return this.pKQ > this.pKR;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.pKQ == ((e) obj).pKQ && this.pKR == ((e) obj).pKR));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.pKQ).hashCode() * 31) + Float.valueOf(this.pKR).hashCode();
    }

    public String toString() {
        return "" + this.pKQ + IStringUtil.TOP_PATH + this.pKR;
    }
}
