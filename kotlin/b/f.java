package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes7.dex */
public class f implements Iterable<Integer> {
    public static final a mYi = new a(null);
    private final int mYg;
    private final int mYh;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.mYg = i;
        this.mYh = kotlin.internal.c.an(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.mYg;
    }

    public final int getLast() {
        return this.mYh;
    }

    public final int dEf() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dEg */
    public ad iterator() {
        return new g(this.mYg, this.mYh, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.mYg > this.mYh : this.mYg < this.mYh;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.mYg == ((f) obj).mYg && this.mYh == ((f) obj).mYh && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.mYg * 31) + this.mYh) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.mYg + IStringUtil.TOP_PATH + this.mYh + " step " + this.step : this.mYg + " downTo " + this.mYh + " step " + (-this.step);
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
