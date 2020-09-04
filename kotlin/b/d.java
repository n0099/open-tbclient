package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes20.dex */
final class d {
    private final double oti;
    private final double otj;

    public boolean isEmpty() {
        return this.oti > this.otj;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((isEmpty() && ((d) obj).isEmpty()) || (this.oti == ((d) obj).oti && this.otj == ((d) obj).otj));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.oti).hashCode() * 31) + Double.valueOf(this.otj).hashCode();
    }

    public String toString() {
        return this.oti + IStringUtil.TOP_PATH + this.otj;
    }
}
