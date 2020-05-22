package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public class i implements Iterable<Long> {
    public static final a ntt = new a(null);
    private final long ntq;
    private final long ntr;
    private final long nts;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.ntq = j;
        this.ntr = kotlin.internal.c.g(j, j2, j3);
        this.nts = j3;
    }

    public final long dMc() {
        return this.ntq;
    }

    public final long dMd() {
        return this.ntr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dMe */
    public ae iterator() {
        return new j(this.ntq, this.ntr, this.nts);
    }

    public boolean isEmpty() {
        return this.nts > 0 ? this.ntq > this.ntr : this.ntq < this.ntr;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.ntq == ((i) obj).ntq && this.ntr == ((i) obj).ntr && this.nts == ((i) obj).nts));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.ntq ^ (this.ntq >>> 32))) + (this.ntr ^ (this.ntr >>> 32)))) + (this.nts ^ (this.nts >>> 32)));
    }

    public String toString() {
        return this.nts > 0 ? this.ntq + IStringUtil.TOP_PATH + this.ntr + " step " + this.nts : this.ntq + " downTo " + this.ntr + " step " + (-this.nts);
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
