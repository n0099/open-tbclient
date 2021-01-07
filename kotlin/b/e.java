package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes5.dex */
final class e {
    private final float qob;
    private final float qoc;

    public boolean isEmpty() {
        return this.qob > this.qoc;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.qob == ((e) obj).qob && this.qoc == ((e) obj).qoc));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.qob).hashCode() * 31) + Float.valueOf(this.qoc).hashCode();
    }

    public String toString() {
        return "" + this.qob + IStringUtil.TOP_PATH + this.qoc;
    }
}
