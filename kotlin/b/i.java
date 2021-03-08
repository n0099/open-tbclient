package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.z;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes14.dex */
public class i implements Iterable<Long> {
    public static final a quP = new a(null);
    private final long quM;
    private final long quN;
    private final long quO;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.quM = j;
        this.quN = kotlin.internal.d.k(j, j2, j3);
        this.quO = j3;
    }

    public final long eLp() {
        return this.quM;
    }

    public final long eLq() {
        return this.quN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eLr */
    public z iterator() {
        return new j(this.quM, this.quN, this.quO);
    }

    public boolean isEmpty() {
        return this.quO > 0 ? this.quM > this.quN : this.quM < this.quN;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.quM == ((i) obj).quM && this.quN == ((i) obj).quN && this.quO == ((i) obj).quO));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.quM ^ (this.quM >>> 32))) + (this.quN ^ (this.quN >>> 32)))) + (this.quO ^ (this.quO >>> 32)));
    }

    public String toString() {
        return this.quO > 0 ? "" + this.quM + IStringUtil.TOP_PATH + this.quN + " step " + this.quO : "" + this.quM + " downTo " + this.quN + " step " + (-this.quO);
    }

    @kotlin.e
    /* loaded from: classes14.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
