package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.z;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes6.dex */
public class i implements Iterable<Long> {
    public static final a qun = new a(null);
    private final long quk;
    private final long qul;
    private final long qum;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.quk = j;
        this.qul = kotlin.internal.d.j(j, j2, j3);
        this.qum = j3;
    }

    public final long eLH() {
        return this.quk;
    }

    public final long eLI() {
        return this.qul;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eLJ */
    public z iterator() {
        return new j(this.quk, this.qul, this.qum);
    }

    public boolean isEmpty() {
        return this.qum > 0 ? this.quk > this.qul : this.quk < this.qul;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.quk == ((i) obj).quk && this.qul == ((i) obj).qul && this.qum == ((i) obj).qum));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.quk ^ (this.quk >>> 32))) + (this.qul ^ (this.qul >>> 32)))) + (this.qum ^ (this.qum >>> 32)));
    }

    public String toString() {
        return this.qum > 0 ? "" + this.quk + IStringUtil.TOP_PATH + this.qul + " step " + this.qum : "" + this.quk + " downTo " + this.qul + " step " + (-this.qum);
    }

    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
