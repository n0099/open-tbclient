package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes5.dex */
final class e {
    private final float qjA;
    private final float qjB;

    public boolean isEmpty() {
        return this.qjA > this.qjB;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.qjA == ((e) obj).qjA && this.qjB == ((e) obj).qjB));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.qjA).hashCode() * 31) + Float.valueOf(this.qjB).hashCode();
    }

    public String toString() {
        return "" + this.qjA + IStringUtil.TOP_PATH + this.qjB;
    }
}
