package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes10.dex */
public final class k extends i {
    public static final a pTk = new a(null);
    private static final k pTj = new k(1, 0);

    public k(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.b.i
    public boolean isEmpty() {
        return eCf() > eCg();
    }

    @Override // kotlin.b.i
    public boolean equals(Object obj) {
        return (obj instanceof k) && ((isEmpty() && ((k) obj).isEmpty()) || (eCf() == ((k) obj).eCf() && eCg() == ((k) obj).eCg()));
    }

    @Override // kotlin.b.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (eCf() ^ (eCf() >>> 32))) + (eCg() ^ (eCg() >>> 32)));
    }

    @Override // kotlin.b.i
    public String toString() {
        return eCf() + IStringUtil.TOP_PATH + eCg();
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
