package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes9.dex */
public final class k extends i {
    public static final a pUN = new a(null);
    private static final k pUM = new k(1, 0);

    public k(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.b.i
    public boolean isEmpty() {
        return eCg() > eCh();
    }

    @Override // kotlin.b.i
    public boolean equals(Object obj) {
        return (obj instanceof k) && ((isEmpty() && ((k) obj).isEmpty()) || (eCg() == ((k) obj).eCg() && eCh() == ((k) obj).eCh()));
    }

    @Override // kotlin.b.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (eCg() ^ (eCg() >>> 32))) + (eCh() ^ (eCh() >>> 32)));
    }

    @Override // kotlin.b.i
    public String toString() {
        return eCg() + IStringUtil.TOP_PATH + eCh();
    }

    @kotlin.h
    /* loaded from: classes9.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
