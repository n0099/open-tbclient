package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public final class k extends i {
    public static final a nuI = new a(null);
    private static final k nuH = new k(1, 0);

    public k(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.b.i
    public boolean isEmpty() {
        return dMq() > dMr();
    }

    @Override // kotlin.b.i
    public boolean equals(Object obj) {
        return (obj instanceof k) && ((isEmpty() && ((k) obj).isEmpty()) || (dMq() == ((k) obj).dMq() && dMr() == ((k) obj).dMr()));
    }

    @Override // kotlin.b.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (dMq() ^ (dMq() >>> 32))) + (dMr() ^ (dMr() >>> 32)));
    }

    @Override // kotlin.b.i
    public String toString() {
        return dMq() + IStringUtil.TOP_PATH + dMr();
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
