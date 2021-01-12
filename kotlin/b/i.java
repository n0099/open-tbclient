package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.z;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes5.dex */
public class i implements Iterable<Long> {
    public static final a qjI = new a(null);
    private final long qjF;
    private final long qjG;
    private final long qjH;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qjF = j;
        this.qjG = kotlin.internal.d.j(j, j2, j3);
        this.qjH = j3;
    }

    public final long eJj() {
        return this.qjF;
    }

    public final long eJk() {
        return this.qjG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eJl */
    public z iterator() {
        return new j(this.qjF, this.qjG, this.qjH);
    }

    public boolean isEmpty() {
        return this.qjH > 0 ? this.qjF > this.qjG : this.qjF < this.qjG;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.qjF == ((i) obj).qjF && this.qjG == ((i) obj).qjG && this.qjH == ((i) obj).qjH));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.qjF ^ (this.qjF >>> 32))) + (this.qjG ^ (this.qjG >>> 32)))) + (this.qjH ^ (this.qjH >>> 32)));
    }

    public String toString() {
        return this.qjH > 0 ? "" + this.qjF + IStringUtil.TOP_PATH + this.qjG + " step " + this.qjH : "" + this.qjF + " downTo " + this.qjG + " step " + (-this.qjH);
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
