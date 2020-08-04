package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes7.dex */
public class f implements Iterable<Integer> {
    public static final a nYY = new a(null);
    private final int nYW;
    private final int nYX;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nYW = i;
        this.nYX = kotlin.internal.c.ak(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.nYW;
    }

    public final int getLast() {
        return this.nYX;
    }

    public final int dUr() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dUs */
    public ad iterator() {
        return new g(this.nYW, this.nYX, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nYW > this.nYX : this.nYW < this.nYX;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.nYW == ((f) obj).nYW && this.nYX == ((f) obj).nYX && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nYW * 31) + this.nYX) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nYW + IStringUtil.TOP_PATH + this.nYX + " step " + this.step : this.nYW + " downTo " + this.nYX + " step " + (-this.step);
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
