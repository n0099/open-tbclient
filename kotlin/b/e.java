package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes6.dex */
final class e {
    private final float qtE;
    private final float qtF;

    public boolean isEmpty() {
        return this.qtE > this.qtF;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.qtE == ((e) obj).qtE && this.qtF == ((e) obj).qtF));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.qtE).hashCode() * 31) + Float.valueOf(this.qtF).hashCode();
    }

    public String toString() {
        return "" + this.qtE + IStringUtil.TOP_PATH + this.qtF;
    }
}
