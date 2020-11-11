package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes10.dex */
final class e {
    private final float pSX;
    private final float pSY;

    public boolean isEmpty() {
        return this.pSX > this.pSY;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.pSX == ((e) obj).pSX && this.pSY == ((e) obj).pSY));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.pSX).hashCode() * 31) + Float.valueOf(this.pSY).hashCode();
    }

    public String toString() {
        return this.pSX + IStringUtil.TOP_PATH + this.pSY;
    }
}
