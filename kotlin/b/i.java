package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public class i implements Iterable<Long> {
    public static final a nDc = new a(null);
    private final long nCZ;
    private final long nDa;
    private final long nDb;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.nCZ = j;
        this.nDa = kotlin.internal.c.l(j, j2, j3);
        this.nDb = j3;
    }

    public final long dKM() {
        return this.nCZ;
    }

    public final long dKN() {
        return this.nDa;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dKO */
    public ae iterator() {
        return new j(this.nCZ, this.nDa, this.nDb);
    }

    public boolean isEmpty() {
        return this.nDb > 0 ? this.nCZ > this.nDa : this.nCZ < this.nDa;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.nCZ == ((i) obj).nCZ && this.nDa == ((i) obj).nDa && this.nDb == ((i) obj).nDb));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.nCZ ^ (this.nCZ >>> 32))) + (this.nDa ^ (this.nDa >>> 32)))) + (this.nDb ^ (this.nDb >>> 32)));
    }

    public String toString() {
        return this.nDb > 0 ? this.nCZ + IStringUtil.TOP_PATH + this.nDa + " step " + this.nDb : this.nCZ + " downTo " + this.nDa + " step " + (-this.nDb);
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
