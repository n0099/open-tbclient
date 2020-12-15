package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes17.dex */
public final class k extends i {
    public static final a pLd = new a(null);
    private static final k pLc = new k(1, 0);

    public k(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.b.i
    public boolean isEmpty() {
        return eEn() > eEo();
    }

    @Override // kotlin.b.i
    public boolean equals(Object obj) {
        return (obj instanceof k) && ((isEmpty() && ((k) obj).isEmpty()) || (eEn() == ((k) obj).eEn() && eEo() == ((k) obj).eEo()));
    }

    @Override // kotlin.b.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (eEn() ^ (eEn() >>> 32))) + (eEo() ^ (eEo() >>> 32)));
    }

    @Override // kotlin.b.i
    public String toString() {
        return "" + eEn() + IStringUtil.TOP_PATH + eEo();
    }

    @kotlin.e
    /* loaded from: classes17.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
