package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes5.dex */
final class e {
    private final float oCR;
    private final float oCS;

    public boolean isEmpty() {
        return this.oCR > this.oCS;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.oCR == ((e) obj).oCR && this.oCS == ((e) obj).oCS));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.oCR).hashCode() * 31) + Float.valueOf(this.oCS).hashCode();
    }

    public String toString() {
        return this.oCR + IStringUtil.TOP_PATH + this.oCS;
    }
}
