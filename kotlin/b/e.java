package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes14.dex */
final class e {
    private final float quG;
    private final float quH;

    public boolean isEmpty() {
        return this.quG > this.quH;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.quG == ((e) obj).quG && this.quH == ((e) obj).quH));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.quG).hashCode() * 31) + Float.valueOf(this.quH).hashCode();
    }

    public String toString() {
        return "" + this.quG + IStringUtil.TOP_PATH + this.quH;
    }
}
