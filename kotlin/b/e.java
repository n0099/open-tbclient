package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class e {
    private final float nQg;
    private final float nQh;

    public boolean isEmpty() {
        return this.nQg > this.nQh;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.nQg == ((e) obj).nQg && this.nQh == ((e) obj).nQh));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.nQg).hashCode() * 31) + Float.valueOf(this.nQh).hashCode();
    }

    public String toString() {
        return this.nQg + IStringUtil.TOP_PATH + this.nQh;
    }
}
