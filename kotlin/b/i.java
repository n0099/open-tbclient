package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public class i implements Iterable<Long> {
    public static final a nuE = new a(null);
    private final long nuB;
    private final long nuC;
    private final long nuD;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.nuB = j;
        this.nuC = kotlin.internal.c.g(j, j2, j3);
        this.nuD = j3;
    }

    public final long dMq() {
        return this.nuB;
    }

    public final long dMr() {
        return this.nuC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dMs */
    public ae iterator() {
        return new j(this.nuB, this.nuC, this.nuD);
    }

    public boolean isEmpty() {
        return this.nuD > 0 ? this.nuB > this.nuC : this.nuB < this.nuC;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.nuB == ((i) obj).nuB && this.nuC == ((i) obj).nuC && this.nuD == ((i) obj).nuD));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.nuB ^ (this.nuB >>> 32))) + (this.nuC ^ (this.nuC >>> 32)))) + (this.nuD ^ (this.nuD >>> 32)));
    }

    public String toString() {
        return this.nuD > 0 ? this.nuB + IStringUtil.TOP_PATH + this.nuC + " step " + this.nuD : this.nuB + " downTo " + this.nuC + " step " + (-this.nuD);
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
