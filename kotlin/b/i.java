package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public class i implements Iterable<Long> {
    public static final a nCR = new a(null);
    private final long nCO;
    private final long nCP;
    private final long nCQ;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.nCO = j;
        this.nCP = kotlin.internal.c.l(j, j2, j3);
        this.nCQ = j3;
    }

    public final long dKL() {
        return this.nCO;
    }

    public final long dKM() {
        return this.nCP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dKN */
    public ae iterator() {
        return new j(this.nCO, this.nCP, this.nCQ);
    }

    public boolean isEmpty() {
        return this.nCQ > 0 ? this.nCO > this.nCP : this.nCO < this.nCP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.nCO == ((i) obj).nCO && this.nCP == ((i) obj).nCP && this.nCQ == ((i) obj).nCQ));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.nCO ^ (this.nCO >>> 32))) + (this.nCP ^ (this.nCP >>> 32)))) + (this.nCQ ^ (this.nCQ >>> 32)));
    }

    public String toString() {
        return this.nCQ > 0 ? this.nCO + IStringUtil.TOP_PATH + this.nCP + " step " + this.nCQ : this.nCO + " downTo " + this.nCP + " step " + (-this.nCQ);
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
