package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public class i implements Iterable<Long> {
    public static final a nZe = new a(null);
    private final long nZb;
    private final long nZc;
    private final long nZd;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.nZb = j;
        this.nZc = kotlin.internal.c.j(j, j2, j3);
        this.nZd = j3;
    }

    public final long dUx() {
        return this.nZb;
    }

    public final long dUy() {
        return this.nZc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dUz */
    public ae iterator() {
        return new j(this.nZb, this.nZc, this.nZd);
    }

    public boolean isEmpty() {
        return this.nZd > 0 ? this.nZb > this.nZc : this.nZb < this.nZc;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.nZb == ((i) obj).nZb && this.nZc == ((i) obj).nZc && this.nZd == ((i) obj).nZd));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.nZb ^ (this.nZb >>> 32))) + (this.nZc ^ (this.nZc >>> 32)))) + (this.nZd ^ (this.nZd >>> 32)));
    }

    public String toString() {
        return this.nZd > 0 ? this.nZb + IStringUtil.TOP_PATH + this.nZc + " step " + this.nZd : this.nZb + " downTo " + this.nZc + " step " + (-this.nZd);
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
