package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public class i implements Iterable<Long> {
    public static final a nQt = new a(null);
    private final long nQq;
    private final long nQr;
    private final long nQs;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.nQq = j;
        this.nQr = kotlin.internal.c.j(j, j2, j3);
        this.nQs = j3;
    }

    public final long dRa() {
        return this.nQq;
    }

    public final long dRb() {
        return this.nQr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dRc */
    public ae iterator() {
        return new j(this.nQq, this.nQr, this.nQs);
    }

    public boolean isEmpty() {
        return this.nQs > 0 ? this.nQq > this.nQr : this.nQq < this.nQr;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.nQq == ((i) obj).nQq && this.nQr == ((i) obj).nQr && this.nQs == ((i) obj).nQs));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.nQq ^ (this.nQq >>> 32))) + (this.nQr ^ (this.nQr >>> 32)))) + (this.nQs ^ (this.nQs >>> 32)));
    }

    public String toString() {
        return this.nQs > 0 ? this.nQq + IStringUtil.TOP_PATH + this.nQr + " step " + this.nQs : this.nQq + " downTo " + this.nQr + " step " + (-this.nQs);
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
