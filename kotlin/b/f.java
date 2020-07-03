package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes7.dex */
public class f implements Iterable<Integer> {
    public static final a nQk = new a(null);
    private final int nQi;
    private final int nQj;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nQi = i;
        this.nQj = kotlin.internal.c.an(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.nQi;
    }

    public final int getLast() {
        return this.nQj;
    }

    public final int dQQ() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dQR */
    public ad iterator() {
        return new g(this.nQi, this.nQj, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nQi > this.nQj : this.nQi < this.nQj;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.nQi == ((f) obj).nQi && this.nQj == ((f) obj).nQj && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nQi * 31) + this.nQj) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nQi + IStringUtil.TOP_PATH + this.nQj + " step " + this.step : this.nQi + " downTo " + this.nQj + " step " + (-this.step);
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final f ao(int i, int i2, int i3) {
            return new f(i, i2, i3);
        }
    }
}
