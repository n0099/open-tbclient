package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes6.dex */
public final class k extends i {
    public static final a qtR = new a(null);
    private static final k qtQ = new k(1, 0);

    public k(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.b.i
    public boolean isEmpty() {
        return eLz() > eLA();
    }

    @Override // kotlin.b.i
    public boolean equals(Object obj) {
        return (obj instanceof k) && ((isEmpty() && ((k) obj).isEmpty()) || (eLz() == ((k) obj).eLz() && eLA() == ((k) obj).eLA()));
    }

    @Override // kotlin.b.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (eLz() ^ (eLz() >>> 32))) + (eLA() ^ (eLA() >>> 32)));
    }

    @Override // kotlin.b.i
    public String toString() {
        return "" + eLz() + IStringUtil.TOP_PATH + eLA();
    }

    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
