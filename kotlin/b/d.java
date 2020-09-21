package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes5.dex */
final class d {
    private final double oCP;
    private final double oCQ;

    public boolean isEmpty() {
        return this.oCP > this.oCQ;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.oCP == ((d) obj).oCP && this.oCQ == ((d) obj).oCQ));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.oCP).hashCode() * 31) + Double.valueOf(this.oCQ).hashCode();
    }

    public String toString() {
        return this.oCP + IStringUtil.TOP_PATH + this.oCQ;
    }
}
