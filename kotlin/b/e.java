package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class e {
    private final float nCS;
    private final float nCT;

    public boolean isEmpty() {
        return this.nCS > this.nCT;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.nCS == ((e) obj).nCS && this.nCT == ((e) obj).nCT));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.nCS).hashCode() * 31) + Float.valueOf(this.nCT).hashCode();
    }

    public String toString() {
        return this.nCS + IStringUtil.TOP_PATH + this.nCT;
    }
}
