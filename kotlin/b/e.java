package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.e
/* loaded from: classes6.dex */
final class e {
    private final float que;
    private final float quf;

    public boolean isEmpty() {
        return this.que > this.quf;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((isEmpty() && ((e) obj).isEmpty()) || (this.que == ((e) obj).que && this.quf == ((e) obj).quf));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.que).hashCode() * 31) + Float.valueOf(this.quf).hashCode();
    }

    public String toString() {
        return "" + this.que + IStringUtil.TOP_PATH + this.quf;
    }
}
