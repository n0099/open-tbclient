package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class e {
    private final float nQj;
    private final float nQk;

    public boolean isEmpty() {
        return this.nQj > this.nQk;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.nQj == ((e) obj).nQj && this.nQk == ((e) obj).nQk));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.nQj).hashCode() * 31) + Float.valueOf(this.nQk).hashCode();
    }

    public String toString() {
        return this.nQj + IStringUtil.TOP_PATH + this.nQk;
    }
}
