package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes10.dex */
public class i implements Iterable<Long> {
    public static final a oSq = new a(null);
    private final long oSn;
    private final long oSo;
    private final long oSp;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.oSn = j;
        this.oSo = kotlin.internal.d.j(j, j2, j3);
        this.oSp = j3;
    }

    public final long eos() {
        return this.oSn;
    }

    public final long eot() {
        return this.oSo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eou */
    public ae iterator() {
        return new j(this.oSn, this.oSo, this.oSp);
    }

    public boolean isEmpty() {
        return this.oSp > 0 ? this.oSn > this.oSo : this.oSn < this.oSo;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.oSn == ((i) obj).oSn && this.oSo == ((i) obj).oSo && this.oSp == ((i) obj).oSp));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.oSn ^ (this.oSn >>> 32))) + (this.oSo ^ (this.oSo >>> 32)))) + (this.oSp ^ (this.oSp >>> 32)));
    }

    public String toString() {
        return this.oSp > 0 ? this.oSn + IStringUtil.TOP_PATH + this.oSo + " step " + this.oSp : this.oSn + " downTo " + this.oSo + " step " + (-this.oSp);
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
