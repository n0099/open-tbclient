package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes7.dex */
public class f implements Iterable<Integer> {
    public static final a nEJ = new a(null);
    private final int nEH;
    private final int nEI;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nEH = i;
        this.nEI = kotlin.internal.c.au(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.nEH;
    }

    public final int getLast() {
        return this.nEI;
    }

    public final int dLg() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dLh */
    public ad iterator() {
        return new g(this.nEH, this.nEI, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nEH > this.nEI : this.nEH < this.nEI;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.nEH == ((f) obj).nEH && this.nEI == ((f) obj).nEI && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nEH * 31) + this.nEI) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nEH + IStringUtil.TOP_PATH + this.nEI + " step " + this.step : this.nEH + " downTo " + this.nEI + " step " + (-this.step);
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
