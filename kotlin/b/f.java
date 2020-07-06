package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes7.dex */
public class f implements Iterable<Integer> {
    public static final a nQn = new a(null);
    private final int nQl;
    private final int nQm;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nQl = i;
        this.nQm = kotlin.internal.c.an(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.nQl;
    }

    public final int getLast() {
        return this.nQm;
    }

    public final int dQU() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dQV */
    public ad iterator() {
        return new g(this.nQl, this.nQm, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nQl > this.nQm : this.nQl < this.nQm;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.nQl == ((f) obj).nQl && this.nQm == ((f) obj).nQm && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nQl * 31) + this.nQm) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nQl + IStringUtil.TOP_PATH + this.nQm + " step " + this.step : this.nQl + " downTo " + this.nQm + " step " + (-this.step);
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
