package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public final class k extends i {
    public static final a nZg = new a(null);
    private static final k nZf = new k(1, 0);

    public k(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.b.i
    public boolean isEmpty() {
        return dUw() > dUx();
    }

    @Override // kotlin.b.i
    public boolean equals(Object obj) {
        return (obj instanceof k) && ((isEmpty() && ((k) obj).isEmpty()) || (dUw() == ((k) obj).dUw() && dUx() == ((k) obj).dUx()));
    }

    @Override // kotlin.b.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (dUw() ^ (dUw() >>> 32))) + (dUx() ^ (dUx() >>> 32)));
    }

    @Override // kotlin.b.i
    public String toString() {
        return dUw() + IStringUtil.TOP_PATH + dUx();
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
