package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public class i implements Iterable<Long> {
    public static final a nQq = new a(null);
    private final long nQn;
    private final long nQo;
    private final long nQp;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.nQn = j;
        this.nQo = kotlin.internal.c.j(j, j2, j3);
        this.nQp = j3;
    }

    public final long dQW() {
        return this.nQn;
    }

    public final long dQX() {
        return this.nQo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dQY */
    public ae iterator() {
        return new j(this.nQn, this.nQo, this.nQp);
    }

    public boolean isEmpty() {
        return this.nQp > 0 ? this.nQn > this.nQo : this.nQn < this.nQo;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.nQn == ((i) obj).nQn && this.nQo == ((i) obj).nQo && this.nQp == ((i) obj).nQp));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.nQn ^ (this.nQn >>> 32))) + (this.nQo ^ (this.nQo >>> 32)))) + (this.nQp ^ (this.nQp >>> 32)));
    }

    public String toString() {
        return this.nQp > 0 ? this.nQn + IStringUtil.TOP_PATH + this.nQo + " step " + this.nQp : this.nQn + " downTo " + this.nQo + " step " + (-this.nQp);
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
