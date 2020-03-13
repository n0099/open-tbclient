package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes7.dex */
public class f implements Iterable<Integer> {
    public static final a nCW = new a(null);
    private final int nCU;
    private final int nCV;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nCU = i;
        this.nCV = kotlin.internal.c.au(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.nCU;
    }

    public final int getLast() {
        return this.nCV;
    }

    public final int dKG() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dKH */
    public ad iterator() {
        return new g(this.nCU, this.nCV, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nCU > this.nCV : this.nCU < this.nCV;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.nCU == ((f) obj).nCU && this.nCV == ((f) obj).nCV && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nCU * 31) + this.nCV) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nCU + IStringUtil.TOP_PATH + this.nCV + " step " + this.step : this.nCU + " downTo " + this.nCV + " step " + (-this.step);
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final f av(int i, int i2, int i3) {
            return new f(i, i2, i3);
        }
    }
}
