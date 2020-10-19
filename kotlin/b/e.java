package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes10.dex */
final class e {
    private final float oSg;
    private final float oSh;

    public boolean isEmpty() {
        return this.oSg > this.oSh;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.oSg == ((e) obj).oSg && this.oSh == ((e) obj).oSh));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.oSg).hashCode() * 31) + Float.valueOf(this.oSh).hashCode();
    }

    public String toString() {
        return this.oSg + IStringUtil.TOP_PATH + this.oSh;
    }
}
