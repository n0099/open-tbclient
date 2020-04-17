package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class e {
    private final float mYe;
    private final float mYf;

    public boolean isEmpty() {
        return this.mYe > this.mYf;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.mYe == ((e) obj).mYe && this.mYf == ((e) obj).mYf));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.mYe).hashCode() * 31) + Float.valueOf(this.mYf).hashCode();
    }

    public String toString() {
        return this.mYe + IStringUtil.TOP_PATH + this.mYf;
    }
}
