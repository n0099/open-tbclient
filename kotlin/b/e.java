package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class e {
    private final float nYS;
    private final float nYT;

    public boolean isEmpty() {
        return this.nYS > this.nYT;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.nYS == ((e) obj).nYS && this.nYT == ((e) obj).nYT));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.nYS).hashCode() * 31) + Float.valueOf(this.nYT).hashCode();
    }

    public String toString() {
        return this.nYS + IStringUtil.TOP_PATH + this.nYT;
    }
}
