package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public class i implements Iterable<Long> {
    public static final a nCP = new a(null);
    private final long nCM;
    private final long nCN;
    private final long nCO;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.nCM = j;
        this.nCN = kotlin.internal.c.l(j, j2, j3);
        this.nCO = j3;
    }

    public final long dKJ() {
        return this.nCM;
    }

    public final long dKK() {
        return this.nCN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dKL */
    public ae iterator() {
        return new j(this.nCM, this.nCN, this.nCO);
    }

    public boolean isEmpty() {
        return this.nCO > 0 ? this.nCM > this.nCN : this.nCM < this.nCN;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.nCM == ((i) obj).nCM && this.nCN == ((i) obj).nCN && this.nCO == ((i) obj).nCO));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.nCM ^ (this.nCM >>> 32))) + (this.nCN ^ (this.nCN >>> 32)))) + (this.nCO ^ (this.nCO >>> 32)));
    }

    public String toString() {
        return this.nCO > 0 ? this.nCM + IStringUtil.TOP_PATH + this.nCN + " step " + this.nCO : this.nCM + " downTo " + this.nCN + " step " + (-this.nCO);
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
