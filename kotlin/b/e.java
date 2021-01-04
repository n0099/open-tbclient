package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes5.dex */
final class e {
    private final float qmt;
    private final float qmu;

    public boolean isEmpty() {
        return this.qmt > this.qmu;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.qmt == ((e) obj).qmt && this.qmu == ((e) obj).qmu));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.qmt).hashCode() * 31) + Float.valueOf(this.qmu).hashCode();
    }

    public String toString() {
        return "" + this.qmt + IStringUtil.TOP_PATH + this.qmu;
    }
}
