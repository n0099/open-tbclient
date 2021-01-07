package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes5.dex */
public final class k extends i {
    public static final a qoo = new a(null);
    private static final k qon = new k(1, 0);

    public k(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.b.i
    public boolean isEmpty() {
        return eMZ() > eNa();
    }

    @Override // kotlin.b.i
    public boolean equals(Object obj) {
        return (obj instanceof k) && ((isEmpty() && ((k) obj).isEmpty()) || (eMZ() == ((k) obj).eMZ() && eNa() == ((k) obj).eNa()));
    }

    @Override // kotlin.b.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (eMZ() ^ (eMZ() >>> 32))) + (eNa() ^ (eNa() >>> 32)));
    }

    @Override // kotlin.b.i
    public String toString() {
        return "" + eMZ() + IStringUtil.TOP_PATH + eNa();
    }

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
