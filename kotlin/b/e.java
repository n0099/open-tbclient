package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes20.dex */
final class e {
    private final float otk;
    private final float otl;

    public boolean isEmpty() {
        return this.otk > this.otl;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.otk == ((e) obj).otk && this.otl == ((e) obj).otl));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.otk).hashCode() * 31) + Float.valueOf(this.otl).hashCode();
    }

    public String toString() {
        return this.otk + IStringUtil.TOP_PATH + this.otl;
    }
}
