package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes20.dex */
public class i implements Iterable<Long> {
    public static final a otu = new a(null);
    private final long otr;
    private final long ots;
    private final long ott;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.otr = j;
        this.ots = kotlin.internal.d.j(j, j2, j3);
        this.ott = j3;
    }

    public final long egI() {
        return this.otr;
    }

    public final long egJ() {
        return this.ots;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: egK */
    public ae iterator() {
        return new j(this.otr, this.ots, this.ott);
    }

    public boolean isEmpty() {
        return this.ott > 0 ? this.otr > this.ots : this.otr < this.ots;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.otr == ((i) obj).otr && this.ots == ((i) obj).ots && this.ott == ((i) obj).ott));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.otr ^ (this.otr >>> 32))) + (this.ots ^ (this.ots >>> 32)))) + (this.ott ^ (this.ott >>> 32)));
    }

    public String toString() {
        return this.ott > 0 ? this.otr + IStringUtil.TOP_PATH + this.ots + " step " + this.ott : this.otr + " downTo " + this.ots + " step " + (-this.ott);
    }

    @kotlin.h
    /* loaded from: classes20.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
