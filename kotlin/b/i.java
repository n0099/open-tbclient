package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public class i implements Iterable<Long> {
    public static final a nZc = new a(null);
    private final long nYZ;
    private final long nZa;
    private final long nZb;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.nYZ = j;
        this.nZa = kotlin.internal.c.j(j, j2, j3);
        this.nZb = j3;
    }

    public final long dUw() {
        return this.nYZ;
    }

    public final long dUx() {
        return this.nZa;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dUy */
    public ae iterator() {
        return new j(this.nYZ, this.nZa, this.nZb);
    }

    public boolean isEmpty() {
        return this.nZb > 0 ? this.nYZ > this.nZa : this.nYZ < this.nZa;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.nYZ == ((i) obj).nYZ && this.nZa == ((i) obj).nZa && this.nZb == ((i) obj).nZb));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.nYZ ^ (this.nYZ >>> 32))) + (this.nZa ^ (this.nZa >>> 32)))) + (this.nZb ^ (this.nZb >>> 32)));
    }

    public String toString() {
        return this.nZb > 0 ? this.nYZ + IStringUtil.TOP_PATH + this.nZa + " step " + this.nZb : this.nYZ + " downTo " + this.nZa + " step " + (-this.nZb);
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
