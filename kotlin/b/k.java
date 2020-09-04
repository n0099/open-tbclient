package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes20.dex */
public final class k extends i {
    public static final a oty = new a(null);
    private static final k otx = new k(1, 0);

    public k(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.b.i
    public boolean isEmpty() {
        return egI() > egJ();
    }

    @Override // kotlin.b.i
    public boolean equals(Object obj) {
        return (obj instanceof k) && ((isEmpty() && ((k) obj).isEmpty()) || (egI() == ((k) obj).egI() && egJ() == ((k) obj).egJ()));
    }

    @Override // kotlin.b.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (egI() ^ (egI() >>> 32))) + (egJ() ^ (egJ() >>> 32)));
    }

    @Override // kotlin.b.i
    public String toString() {
        return egI() + IStringUtil.TOP_PATH + egJ();
    }

    @kotlin.h
    /* loaded from: classes20.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
