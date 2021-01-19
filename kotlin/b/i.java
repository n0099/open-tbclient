package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.z;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes5.dex */
public class i implements Iterable<Long> {
    public static final a qjJ = new a(null);
    private final long qjG;
    private final long qjH;
    private final long qjI;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qjG = j;
        this.qjH = kotlin.internal.d.j(j, j2, j3);
        this.qjI = j3;
    }

    public final long eJj() {
        return this.qjG;
    }

    public final long eJk() {
        return this.qjH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eJl */
    public z iterator() {
        return new j(this.qjG, this.qjH, this.qjI);
    }

    public boolean isEmpty() {
        return this.qjI > 0 ? this.qjG > this.qjH : this.qjG < this.qjH;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.qjG == ((i) obj).qjG && this.qjH == ((i) obj).qjH && this.qjI == ((i) obj).qjI));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.qjG ^ (this.qjG >>> 32))) + (this.qjH ^ (this.qjH >>> 32)))) + (this.qjI ^ (this.qjI >>> 32)));
    }

    public String toString() {
        return this.qjI > 0 ? "" + this.qjG + IStringUtil.TOP_PATH + this.qjH + " step " + this.qjI : "" + this.qjG + " downTo " + this.qjH + " step " + (-this.qjI);
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
