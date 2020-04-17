package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public class i implements Iterable<Long> {
    public static final a mYo = new a(null);
    private final long mYl;
    private final long mYm;
    private final long mYn;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.mYl = j;
        this.mYm = kotlin.internal.c.g(j, j2, j3);
        this.mYn = j3;
    }

    public final long dEl() {
        return this.mYl;
    }

    public final long dEm() {
        return this.mYm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dEn */
    public ae iterator() {
        return new j(this.mYl, this.mYm, this.mYn);
    }

    public boolean isEmpty() {
        return this.mYn > 0 ? this.mYl > this.mYm : this.mYl < this.mYm;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.mYl == ((i) obj).mYl && this.mYm == ((i) obj).mYm && this.mYn == ((i) obj).mYn));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.mYl ^ (this.mYl >>> 32))) + (this.mYm ^ (this.mYm >>> 32)))) + (this.mYn ^ (this.mYn >>> 32)));
    }

    public String toString() {
        return this.mYn > 0 ? this.mYl + IStringUtil.TOP_PATH + this.mYm + " step " + this.mYn : this.mYl + " downTo " + this.mYm + " step " + (-this.mYn);
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
