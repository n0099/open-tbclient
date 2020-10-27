package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes10.dex */
public class i implements Iterable<Long> {
    public static final a pJM = new a(null);
    private final long pJJ;
    private final long pJK;
    private final long pJL;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.pJJ = j;
        this.pJK = kotlin.internal.d.j(j, j2, j3);
        this.pJL = j3;
    }

    public final long eyq() {
        return this.pJJ;
    }

    public final long eyr() {
        return this.pJK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eys */
    public ae iterator() {
        return new j(this.pJJ, this.pJK, this.pJL);
    }

    public boolean isEmpty() {
        return this.pJL > 0 ? this.pJJ > this.pJK : this.pJJ < this.pJK;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.pJJ == ((i) obj).pJJ && this.pJK == ((i) obj).pJK && this.pJL == ((i) obj).pJL));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.pJJ ^ (this.pJJ >>> 32))) + (this.pJK ^ (this.pJK >>> 32)))) + (this.pJL ^ (this.pJL >>> 32)));
    }

    public String toString() {
        return this.pJL > 0 ? this.pJJ + IStringUtil.TOP_PATH + this.pJK + " step " + this.pJL : this.pJJ + " downTo " + this.pJK + " step " + (-this.pJL);
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
