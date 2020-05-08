package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class e {
    private final float mYh;
    private final float mYi;

    public boolean isEmpty() {
        return this.mYh > this.mYi;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.mYh == ((e) obj).mYh && this.mYi == ((e) obj).mYi));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.mYh).hashCode() * 31) + Float.valueOf(this.mYi).hashCode();
    }

    public String toString() {
        return this.mYh + IStringUtil.TOP_PATH + this.mYi;
    }
}
