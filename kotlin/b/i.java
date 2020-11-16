package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes9.dex */
public class i implements Iterable<Long> {
    public static final a pUJ = new a(null);
    private final long pUG;
    private final long pUH;
    private final long pUI;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.pUG = j;
        this.pUH = kotlin.internal.d.j(j, j2, j3);
        this.pUI = j3;
    }

    public final long eCg() {
        return this.pUG;
    }

    public final long eCh() {
        return this.pUH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eCi */
    public ae iterator() {
        return new j(this.pUG, this.pUH, this.pUI);
    }

    public boolean isEmpty() {
        return this.pUI > 0 ? this.pUG > this.pUH : this.pUG < this.pUH;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.pUG == ((i) obj).pUG && this.pUH == ((i) obj).pUH && this.pUI == ((i) obj).pUI));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.pUG ^ (this.pUG >>> 32))) + (this.pUH ^ (this.pUH >>> 32)))) + (this.pUI ^ (this.pUI >>> 32)));
    }

    public String toString() {
        return this.pUI > 0 ? this.pUG + IStringUtil.TOP_PATH + this.pUH + " step " + this.pUI : this.pUG + " downTo " + this.pUH + " step " + (-this.pUI);
    }

    @kotlin.h
    /* loaded from: classes9.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
