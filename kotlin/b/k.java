package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes14.dex */
public final class k extends i {
    public static final a quT = new a(null);
    private static final k quS = new k(1, 0);

    public k(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.b.i
    public boolean isEmpty() {
        return eLp() > eLq();
    }

    @Override // kotlin.b.i
    public boolean equals(Object obj) {
        return (obj instanceof k) && ((isEmpty() && ((k) obj).isEmpty()) || (eLp() == ((k) obj).eLp() && eLq() == ((k) obj).eLq()));
    }

    @Override // kotlin.b.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (eLp() ^ (eLp() >>> 32))) + (eLq() ^ (eLq() >>> 32)));
    }

    @Override // kotlin.b.i
    public String toString() {
        return "" + eLp() + IStringUtil.TOP_PATH + eLq();
    }

    @kotlin.e
    /* loaded from: classes14.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
