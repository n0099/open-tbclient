package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes10.dex */
final class e {
    private final float pJD;
    private final float pJE;

    public boolean isEmpty() {
        return this.pJD > this.pJE;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.pJD == ((e) obj).pJD && this.pJE == ((e) obj).pJE));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.pJD).hashCode() * 31) + Float.valueOf(this.pJE).hashCode();
    }

    public String toString() {
        return this.pJD + IStringUtil.TOP_PATH + this.pJE;
    }
}
