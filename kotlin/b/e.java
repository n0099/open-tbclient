package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes20.dex */
final class e {
    private final float osS;
    private final float osT;

    public boolean isEmpty() {
        return this.osS > this.osT;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.osS == ((e) obj).osS && this.osT == ((e) obj).osT));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.osS).hashCode() * 31) + Float.valueOf(this.osT).hashCode();
    }

    public String toString() {
        return this.osS + IStringUtil.TOP_PATH + this.osT;
    }
}
