package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes6.dex */
public final class k extends i {
    public static final a qur = new a(null);
    private static final k quq = new k(1, 0);

    public k(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.b.i
    public boolean isEmpty() {
        return eLH() > eLI();
    }

    @Override // kotlin.b.i
    public boolean equals(Object obj) {
        return (obj instanceof k) && ((isEmpty() && ((k) obj).isEmpty()) || (eLH() == ((k) obj).eLH() && eLI() == ((k) obj).eLI()));
    }

    @Override // kotlin.b.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (eLH() ^ (eLH() >>> 32))) + (eLI() ^ (eLI() >>> 32)));
    }

    @Override // kotlin.b.i
    public String toString() {
        return "" + eLH() + IStringUtil.TOP_PATH + eLI();
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
