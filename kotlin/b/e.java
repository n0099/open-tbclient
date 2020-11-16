package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes9.dex */
final class e {
    private final float pUA;
    private final float pUB;

    public boolean isEmpty() {
        return this.pUA > this.pUB;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.pUA == ((e) obj).pUA && this.pUB == ((e) obj).pUB));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.pUA).hashCode() * 31) + Float.valueOf(this.pUB).hashCode();
    }

    public String toString() {
        return this.pUA + IStringUtil.TOP_PATH + this.pUB;
    }
}
