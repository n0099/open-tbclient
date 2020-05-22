package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class e {
    private final float ntj;
    private final float ntk;

    public boolean isEmpty() {
        return this.ntj > this.ntk;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.ntj == ((e) obj).ntj && this.ntk == ((e) obj).ntk));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.ntj).hashCode() * 31) + Float.valueOf(this.ntk).hashCode();
    }

    public String toString() {
        return this.ntj + IStringUtil.TOP_PATH + this.ntk;
    }
}
