package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public class i implements Iterable<Long> {
    public static final a nEP = new a(null);
    private final long nEM;
    private final long nEN;
    private final long nEO;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.nEM = j;
        this.nEN = kotlin.internal.c.l(j, j2, j3);
        this.nEO = j3;
    }

    public final long dLm() {
        return this.nEM;
    }

    public final long dLn() {
        return this.nEN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dLo */
    public ae iterator() {
        return new j(this.nEM, this.nEN, this.nEO);
    }

    public boolean isEmpty() {
        return this.nEO > 0 ? this.nEM > this.nEN : this.nEM < this.nEN;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.nEM == ((i) obj).nEM && this.nEN == ((i) obj).nEN && this.nEO == ((i) obj).nEO));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.nEM ^ (this.nEM >>> 32))) + (this.nEN ^ (this.nEN >>> 32)))) + (this.nEO ^ (this.nEO >>> 32)));
    }

    public String toString() {
        return this.nEO > 0 ? this.nEM + IStringUtil.TOP_PATH + this.nEN + " step " + this.nEO : this.nEM + " downTo " + this.nEN + " step " + (-this.nEO);
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
