package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes7.dex */
public class f implements Iterable<Integer> {
    public static final a mYl = new a(null);
    private final int mYj;
    private final int mYk;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.mYj = i;
        this.mYk = kotlin.internal.c.an(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.mYj;
    }

    public final int getLast() {
        return this.mYk;
    }

    public final int dEc() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dEd */
    public ad iterator() {
        return new g(this.mYj, this.mYk, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.mYj > this.mYk : this.mYj < this.mYk;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.mYj == ((f) obj).mYj && this.mYk == ((f) obj).mYk && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.mYj * 31) + this.mYk) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.mYj + IStringUtil.TOP_PATH + this.mYk + " step " + this.step : this.mYj + " downTo " + this.mYk + " step " + (-this.step);
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
