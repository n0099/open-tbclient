package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public class i implements Iterable<Long> {
    public static final a mYr = new a(null);
    private final long mYo;
    private final long mYp;
    private final long mYq;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.mYo = j;
        this.mYp = kotlin.internal.c.g(j, j2, j3);
        this.mYq = j3;
    }

    public final long dEh() {
        return this.mYo;
    }

    public final long dEi() {
        return this.mYp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dEj */
    public ae iterator() {
        return new j(this.mYo, this.mYp, this.mYq);
    }

    public boolean isEmpty() {
        return this.mYq > 0 ? this.mYo > this.mYp : this.mYo < this.mYp;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.mYo == ((i) obj).mYo && this.mYp == ((i) obj).mYp && this.mYq == ((i) obj).mYq));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.mYo ^ (this.mYo >>> 32))) + (this.mYp ^ (this.mYp >>> 32)))) + (this.mYq ^ (this.mYq >>> 32)));
    }

    public String toString() {
        return this.mYq > 0 ? this.mYo + IStringUtil.TOP_PATH + this.mYp + " step " + this.mYq : this.mYo + " downTo " + this.mYp + " step " + (-this.mYq);
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
