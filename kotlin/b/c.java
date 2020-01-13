package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
/* loaded from: classes5.dex */
public final class c extends kotlin.b.a {
    public static final a nBV = new a(null);
    private static final c nBU = new c(1, 0);

    public c(int i, int i2) {
        super(i, i2, 1);
    }

    public Integer dJt() {
        return Integer.valueOf(getFirst());
    }

    public Integer dJu() {
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
        return getFirst() + IStringUtil.TOP_PATH + getLast();
    }

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final c dJw() {
            return c.nBU;
        }
    }
}
