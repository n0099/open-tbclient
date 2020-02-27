package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes7.dex */
public class f implements Iterable<Integer> {
    public static final a nCJ = new a(null);
    private final int nCH;
    private final int nCI;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nCH = i;
        this.nCI = kotlin.internal.c.au(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.nCH;
    }

    public final int getLast() {
        return this.nCI;
    }

    public final int dKD() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dKE */
    public ad iterator() {
        return new g(this.nCH, this.nCI, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nCH > this.nCI : this.nCH < this.nCI;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.nCH == ((f) obj).nCH && this.nCI == ((f) obj).nCI && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nCH * 31) + this.nCI) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nCH + IStringUtil.TOP_PATH + this.nCI + " step " + this.step : this.nCH + " downTo " + this.nCI + " step " + (-this.step);
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
