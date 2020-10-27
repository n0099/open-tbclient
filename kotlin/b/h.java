package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes10.dex */
public final class h extends f {
    public static final a pJI = new a(null);
    private static final h pJH = new h(1, 0);

    public h(int i, int i2) {
        super(i, i2, 1);
    }

    public Integer eym() {
        return Integer.valueOf(getFirst());
    }

    public Integer eyn() {
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
        return getFirst() + IStringUtil.TOP_PATH + getLast();
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final h eyp() {
            return h.pJH;
        }
    }
}
