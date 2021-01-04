package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.z;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes5.dex */
public class i implements Iterable<Long> {
    public static final a qmC = new a(null);
    private final long qmA;
    private final long qmB;
    private final long qmz;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qmz = j;
        this.qmA = kotlin.internal.d.j(j, j2, j3);
        this.qmB = j3;
    }

    public final long eMv() {
        return this.qmz;
    }

    public final long eMw() {
        return this.qmA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eMx */
    public z iterator() {
        return new j(this.qmz, this.qmA, this.qmB);
    }

    public boolean isEmpty() {
        return this.qmB > 0 ? this.qmz > this.qmA : this.qmz < this.qmA;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.qmz == ((i) obj).qmz && this.qmA == ((i) obj).qmA && this.qmB == ((i) obj).qmB));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.qmz ^ (this.qmz >>> 32))) + (this.qmA ^ (this.qmA >>> 32)))) + (this.qmB ^ (this.qmB >>> 32)));
    }

    public String toString() {
        return this.qmB > 0 ? "" + this.qmz + IStringUtil.TOP_PATH + this.qmA + " step " + this.qmB : "" + this.qmz + " downTo " + this.qmA + " step " + (-this.qmB);
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
