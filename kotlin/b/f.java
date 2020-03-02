package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes7.dex */
public class f implements Iterable<Integer> {
    public static final a nCL = new a(null);
    private final int nCJ;
    private final int nCK;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nCJ = i;
        this.nCK = kotlin.internal.c.au(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.nCJ;
    }

    public final int getLast() {
        return this.nCK;
    }

    public final int dKF() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dKG */
    public ad iterator() {
        return new g(this.nCJ, this.nCK, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nCJ > this.nCK : this.nCJ < this.nCK;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.nCJ == ((f) obj).nCJ && this.nCK == ((f) obj).nCK && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nCJ * 31) + this.nCK) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nCJ + IStringUtil.TOP_PATH + this.nCK + " step " + this.step : this.nCJ + " downTo " + this.nCK + " step " + (-this.step);
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
