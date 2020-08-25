package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes20.dex */
public final class k extends i {
    public static final a otg = new a(null);
    private static final k otf = new k(1, 0);

    public k(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.b.i
    public boolean isEmpty() {
        return egz() > egA();
    }

    @Override // kotlin.b.i
    public boolean equals(Object obj) {
        return (obj instanceof k) && ((isEmpty() && ((k) obj).isEmpty()) || (egz() == ((k) obj).egz() && egA() == ((k) obj).egA()));
    }

    @Override // kotlin.b.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (egz() ^ (egz() >>> 32))) + (egA() ^ (egA() >>> 32)));
    }

    @Override // kotlin.b.i
    public String toString() {
        return egz() + IStringUtil.TOP_PATH + egA();
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
