package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class e {
    private final float nEF;
    private final float nEG;

    public boolean isEmpty() {
        return this.nEF > this.nEG;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.nEF == ((e) obj).nEF && this.nEG == ((e) obj).nEG));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.nEF).hashCode() * 31) + Float.valueOf(this.nEG).hashCode();
    }

    public String toString() {
        return this.nEF + IStringUtil.TOP_PATH + this.nEG;
    }
}
