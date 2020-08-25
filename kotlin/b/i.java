package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes20.dex */
public class i implements Iterable<Long> {
    public static final a otc = new a(null);
    private final long osZ;
    private final long ota;
    private final long otb;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.osZ = j;
        this.ota = kotlin.internal.d.j(j, j2, j3);
        this.otb = j3;
    }

    public final long egz() {
        return this.osZ;
    }

    public final long egA() {
        return this.ota;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: egB */
    public ae iterator() {
        return new j(this.osZ, this.ota, this.otb);
    }

    public boolean isEmpty() {
        return this.otb > 0 ? this.osZ > this.ota : this.osZ < this.ota;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.osZ == ((i) obj).osZ && this.ota == ((i) obj).ota && this.otb == ((i) obj).otb));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.osZ ^ (this.osZ >>> 32))) + (this.ota ^ (this.ota >>> 32)))) + (this.otb ^ (this.otb >>> 32)));
    }

    public String toString() {
        return this.otb > 0 ? this.osZ + IStringUtil.TOP_PATH + this.ota + " step " + this.otb : this.osZ + " downTo " + this.ota + " step " + (-this.otb);
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
