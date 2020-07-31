package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes7.dex */
public class f implements Iterable<Integer> {
    public static final a nYW = new a(null);
    private final int nYU;
    private final int nYV;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nYU = i;
        this.nYV = kotlin.internal.c.ak(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.nYU;
    }

    public final int getLast() {
        return this.nYV;
    }

    public final int dUq() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dUr */
    public ad iterator() {
        return new g(this.nYU, this.nYV, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nYU > this.nYV : this.nYU < this.nYV;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.nYU == ((f) obj).nYU && this.nYV == ((f) obj).nYV && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nYU * 31) + this.nYV) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nYU + IStringUtil.TOP_PATH + this.nYV + " step " + this.step : this.nYU + " downTo " + this.nYV + " step " + (-this.step);
    }

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final f al(int i, int i2, int i3) {
            return new f(i, i2, i3);
        }
    }
}
