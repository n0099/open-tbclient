package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes5.dex */
public class i implements Iterable<Long> {
    public static final a oDb = new a(null);
    private final long oCY;
    private final long oCZ;
    private final long oDa;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.oCY = j;
        this.oCZ = kotlin.internal.d.j(j, j2, j3);
        this.oDa = j3;
    }

    public final long ekF() {
        return this.oCY;
    }

    public final long ekG() {
        return this.oCZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: ekH */
    public ae iterator() {
        return new j(this.oCY, this.oCZ, this.oDa);
    }

    public boolean isEmpty() {
        return this.oDa > 0 ? this.oCY > this.oCZ : this.oCY < this.oCZ;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.oCY == ((i) obj).oCY && this.oCZ == ((i) obj).oCZ && this.oDa == ((i) obj).oDa));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.oCY ^ (this.oCY >>> 32))) + (this.oCZ ^ (this.oCZ >>> 32)))) + (this.oDa ^ (this.oDa >>> 32)));
    }

    public String toString() {
        return this.oDa > 0 ? this.oCY + IStringUtil.TOP_PATH + this.oCZ + " step " + this.oDa : this.oCY + " downTo " + this.oCZ + " step " + (-this.oDa);
    }

    @kotlin.h
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
