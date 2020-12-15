package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.z;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes17.dex */
public class i implements Iterable<Long> {
    public static final a pKZ = new a(null);
    private final long pKW;
    private final long pKX;
    private final long pKY;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.pKW = j;
        this.pKX = kotlin.internal.d.j(j, j2, j3);
        this.pKY = j3;
    }

    public final long eEn() {
        return this.pKW;
    }

    public final long eEo() {
        return this.pKX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eEp */
    public z iterator() {
        return new j(this.pKW, this.pKX, this.pKY);
    }

    public boolean isEmpty() {
        return this.pKY > 0 ? this.pKW > this.pKX : this.pKW < this.pKX;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.pKW == ((i) obj).pKW && this.pKX == ((i) obj).pKX && this.pKY == ((i) obj).pKY));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.pKW ^ (this.pKW >>> 32))) + (this.pKX ^ (this.pKX >>> 32)))) + (this.pKY ^ (this.pKY >>> 32)));
    }

    public String toString() {
        return this.pKY > 0 ? "" + this.pKW + IStringUtil.TOP_PATH + this.pKX + " step " + this.pKY : "" + this.pKW + " downTo " + this.pKX + " step " + (-this.pKY);
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
