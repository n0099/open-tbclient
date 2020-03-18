package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public final class k extends i {
    public static final a nET = new a(null);
    private static final k nES = new k(1, 0);

    public k(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.b.i
    public boolean isEmpty() {
        return dLm() > dLn();
    }

    @Override // kotlin.b.i
    public boolean equals(Object obj) {
        return (obj instanceof k) && ((isEmpty() && ((k) obj).isEmpty()) || (dLm() == ((k) obj).dLm() && dLn() == ((k) obj).dLn()));
    }

    @Override // kotlin.b.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (dLm() ^ (dLm() >>> 32))) + (dLn() ^ (dLn() >>> 32)));
    }

    @Override // kotlin.b.i
    public String toString() {
        return dLm() + IStringUtil.TOP_PATH + dLn();
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
