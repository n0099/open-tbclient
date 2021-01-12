package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes5.dex */
final class e {
    private final float qjA;
    private final float qjz;

    public boolean isEmpty() {
        return this.qjz > this.qjA;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.qjz == ((e) obj).qjz && this.qjA == ((e) obj).qjA));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.qjz).hashCode() * 31) + Float.valueOf(this.qjA).hashCode();
    }

    public String toString() {
        return "" + this.qjz + IStringUtil.TOP_PATH + this.qjA;
    }
}
