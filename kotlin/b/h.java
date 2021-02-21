package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes6.dex */
public final class h extends f {
    public static final a quj = new a(null);
    private static final h qui = new h(1, 0);

    public h(int i, int i2) {
        super(i, i2, 1);
    }

    public Integer eLD() {
        return Integer.valueOf(getFirst());
    }

    public Integer eLE() {
        return Integer.valueOf(getLast());
    }

    @Override // kotlin.b.f
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // kotlin.b.f
    public boolean equals(Object obj) {
        return (obj instanceof h) && ((isEmpty() && ((h) obj).isEmpty()) || (getFirst() == ((h) obj).getFirst() && getLast() == ((h) obj).getLast()));
    }

    @Override // kotlin.b.f
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.b.f
    public String toString() {
        return "" + getFirst() + IStringUtil.TOP_PATH + getLast();
    }

    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final h eLG() {
            return h.qui;
        }
    }
}
