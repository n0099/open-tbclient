package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.z;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes5.dex */
public class i implements Iterable<Long> {
    public static final a qok = new a(null);
    private final long qoh;
    private final long qoi;
    private final long qoj;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qoh = j;
        this.qoi = kotlin.internal.d.j(j, j2, j3);
        this.qoj = j3;
    }

    public final long eMZ() {
        return this.qoh;
    }

    public final long eNa() {
        return this.qoi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eNb */
    public z iterator() {
        return new j(this.qoh, this.qoi, this.qoj);
    }

    public boolean isEmpty() {
        return this.qoj > 0 ? this.qoh > this.qoi : this.qoh < this.qoi;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.qoh == ((i) obj).qoh && this.qoi == ((i) obj).qoi && this.qoj == ((i) obj).qoj));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.qoh ^ (this.qoh >>> 32))) + (this.qoi ^ (this.qoi >>> 32)))) + (this.qoj ^ (this.qoj >>> 32)));
    }

    public String toString() {
        return this.qoj > 0 ? "" + this.qoh + IStringUtil.TOP_PATH + this.qoi + " step " + this.qoj : "" + this.qoh + " downTo " + this.qoi + " step " + (-this.qoj);
    }

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
