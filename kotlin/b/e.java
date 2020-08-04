package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class e {
    private final float nYU;
    private final float nYV;

    public boolean isEmpty() {
        return this.nYU > this.nYV;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.nYU == ((e) obj).nYU && this.nYV == ((e) obj).nYV));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.nYU).hashCode() * 31) + Float.valueOf(this.nYV).hashCode();
    }

    public String toString() {
        return this.nYU + IStringUtil.TOP_PATH + this.nYV;
    }
}
