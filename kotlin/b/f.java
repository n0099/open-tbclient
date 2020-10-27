package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes10.dex */
public class f implements Iterable<Integer> {
    public static final a pJG = new a(null);
    private final int oyp;
    private final int pJF;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.pJF = i;
        this.oyp = kotlin.internal.d.ao(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.pJF;
    }

    public final int getLast() {
        return this.oyp;
    }

    public final int eyk() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eyl */
    public ad iterator() {
        return new g(this.pJF, this.oyp, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.pJF > this.oyp : this.pJF < this.oyp;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.pJF == ((f) obj).pJF && this.oyp == ((f) obj).oyp && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.pJF * 31) + this.oyp) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.pJF + IStringUtil.TOP_PATH + this.oyp + " step " + this.step : this.pJF + " downTo " + this.oyp + " step " + (-this.step);
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final f ap(int i, int i2, int i3) {
            return new f(i, i2, i3);
        }
    }
}
