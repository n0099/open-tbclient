package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class e {
    private final float nCH;
    private final float nCI;

    public boolean isEmpty() {
        return this.nCH > this.nCI;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.nCH == ((e) obj).nCH && this.nCI == ((e) obj).nCI));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.nCH).hashCode() * 31) + Float.valueOf(this.nCI).hashCode();
    }

    public String toString() {
        return this.nCH + IStringUtil.TOP_PATH + this.nCI;
    }
}
