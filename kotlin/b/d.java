package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes9.dex */
final class d {
    private final double pUy;
    private final double pUz;

    public boolean isEmpty() {
        return this.pUy > this.pUz;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.pUy == ((d) obj).pUy && this.pUz == ((d) obj).pUz));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.pUy).hashCode() * 31) + Double.valueOf(this.pUz).hashCode();
    }

    public String toString() {
        return this.pUy + IStringUtil.TOP_PATH + this.pUz;
    }
}
