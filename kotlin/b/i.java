package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.z;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes6.dex */
public class i implements Iterable<Long> {
    public static final a qtN = new a(null);
    private final long qtK;
    private final long qtL;
    private final long qtM;

    public i(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qtK = j;
        this.qtL = kotlin.internal.d.j(j, j2, j3);
        this.qtM = j3;
    }

    public final long eLz() {
        return this.qtK;
    }

    public final long eLA() {
        return this.qtL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eLB */
    public z iterator() {
        return new j(this.qtK, this.qtL, this.qtM);
    }

    public boolean isEmpty() {
        return this.qtM > 0 ? this.qtK > this.qtL : this.qtK < this.qtL;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((isEmpty() && ((i) obj).isEmpty()) || (this.qtK == ((i) obj).qtK && this.qtL == ((i) obj).qtL && this.qtM == ((i) obj).qtM));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * ((31 * (this.qtK ^ (this.qtK >>> 32))) + (this.qtL ^ (this.qtL >>> 32)))) + (this.qtM ^ (this.qtM >>> 32)));
    }

    public String toString() {
        return this.qtM > 0 ? "" + this.qtK + IStringUtil.TOP_PATH + this.qtL + " step " + this.qtM : "" + this.qtK + " downTo " + this.qtL + " step " + (-this.qtM);
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
