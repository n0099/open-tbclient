package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes10.dex */
public class i implements Iterable<Long> {
    public static final a pTg = new a(null);
    private final long pTd;
    private final long pTe;
    private final long pTf;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.pTd = j;
        this.pTe = kotlin.internal.d.j(j, j2, j3);
        this.pTf = j3;
    }

    public final long eCf() {
        return this.pTd;
    }

    public final long eCg() {
        return this.pTe;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eCh */
    public ae iterator() {
        return new j(this.pTd, this.pTe, this.pTf);
    }

    public boolean isEmpty() {
        return this.pTf > 0 ? this.pTd > this.pTe : this.pTd < this.pTe;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.pTd == ((i) obj).pTd && this.pTe == ((i) obj).pTe && this.pTf == ((i) obj).pTf));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.pTd ^ (this.pTd >>> 32))) + (this.pTe ^ (this.pTe >>> 32)))) + (this.pTf ^ (this.pTf >>> 32)));
    }

    public String toString() {
        return this.pTf > 0 ? this.pTd + IStringUtil.TOP_PATH + this.pTe + " step " + this.pTf : this.pTd + " downTo " + this.pTe + " step " + (-this.pTf);
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
