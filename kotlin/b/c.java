package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
/* loaded from: classes4.dex */
public final class c extends kotlin.b.a {
    public static final a mZo = new a(null);
    private static final c mZn = new c(1, 0);

    public c(int i, int i2) {
        super(i, i2, 1);
    }

    public Integer dEX() {
        return Integer.valueOf(getFirst());
    }

    public Integer dEY() {
        return Integer.valueOf(getLast());
    }

    @Override // kotlin.b.a
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // kotlin.b.a
    public boolean equals(Object obj) {
        return (obj instanceof c) && ((isEmpty() && ((c) obj).isEmpty()) || (getFirst() == ((c) obj).getFirst() && getLast() == ((c) obj).getLast()));
    }

    @Override // kotlin.b.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.b.a
    public String toString() {
        return "" + getFirst() + IStringUtil.TOP_PATH + getLast();
    }

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final c dFa() {
            return c.mZn;
        }
    }
}
