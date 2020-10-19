package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes10.dex */
final class d {
    private final double oSe;
    private final double oSf;

    public boolean isEmpty() {
        return this.oSe > this.oSf;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.oSe == ((d) obj).oSe && this.oSf == ((d) obj).oSf));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.oSe).hashCode() * 31) + Double.valueOf(this.oSf).hashCode();
    }

    public String toString() {
        return this.oSe + IStringUtil.TOP_PATH + this.oSf;
    }
}
