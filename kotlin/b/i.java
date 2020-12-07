package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.z;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes17.dex */
public class i implements Iterable<Long> {
    public static final a pKX = new a(null);
    private final long pKU;
    private final long pKV;
    private final long pKW;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.pKU = j;
        this.pKV = kotlin.internal.d.j(j, j2, j3);
        this.pKW = j3;
    }

    public final long eEm() {
        return this.pKU;
    }

    public final long eEn() {
        return this.pKV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eEo */
    public z iterator() {
        return new j(this.pKU, this.pKV, this.pKW);
    }

    public boolean isEmpty() {
        return this.pKW > 0 ? this.pKU > this.pKV : this.pKU < this.pKV;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.pKU == ((i) obj).pKU && this.pKV == ((i) obj).pKV && this.pKW == ((i) obj).pKW));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.pKU ^ (this.pKU >>> 32))) + (this.pKV ^ (this.pKV >>> 32)))) + (this.pKW ^ (this.pKW >>> 32)));
    }

    public String toString() {
        return this.pKW > 0 ? "" + this.pKU + IStringUtil.TOP_PATH + this.pKV + " step " + this.pKW : "" + this.pKU + " downTo " + this.pKV + " step " + (-this.pKW);
    }

    @kotlin.e
    /* loaded from: classes17.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
