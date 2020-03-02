package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public final class k extends i {
    public static final a nCV = new a(null);
    private static final k nCU = new k(1, 0);

    public k(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.b.i
    public boolean isEmpty() {
        return dKL() > dKM();
    }

    @Override // kotlin.b.i
    public boolean equals(Object obj) {
        return (obj instanceof k) && ((isEmpty() && ((k) obj).isEmpty()) || (dKL() == ((k) obj).dKL() && dKM() == ((k) obj).dKM()));
    }

    @Override // kotlin.b.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (dKL() ^ (dKL() >>> 32))) + (dKM() ^ (dKM() >>> 32)));
    }

    @Override // kotlin.b.i
    public String toString() {
        return dKL() + IStringUtil.TOP_PATH + dKM();
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
