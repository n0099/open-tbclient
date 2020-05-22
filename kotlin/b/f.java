package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes7.dex */
public class f implements Iterable<Integer> {
    public static final a ntn = new a(null);
    private final int ntl;
    private final int ntm;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.ntl = i;
        this.ntm = kotlin.internal.c.an(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.ntl;
    }

    public final int getLast() {
        return this.ntm;
    }

    public final int dLW() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dLX */
    public ad iterator() {
        return new g(this.ntl, this.ntm, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.ntl > this.ntm : this.ntl < this.ntm;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.ntl == ((f) obj).ntl && this.ntm == ((f) obj).ntm && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.ntl * 31) + this.ntm) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.ntl + IStringUtil.TOP_PATH + this.ntm + " step " + this.step : this.ntl + " downTo " + this.ntm + " step " + (-this.step);
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
