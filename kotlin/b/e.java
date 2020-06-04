package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
final class e {
    private final float nuu;
    private final float nuv;

    public boolean isEmpty() {
        return this.nuu > this.nuv;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.nuu == ((e) obj).nuu && this.nuv == ((e) obj).nuv));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.nuu).hashCode() * 31) + Float.valueOf(this.nuv).hashCode();
    }

    public String toString() {
        return this.nuu + IStringUtil.TOP_PATH + this.nuv;
    }
}
