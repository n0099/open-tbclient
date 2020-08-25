package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes20.dex */
public class f implements Iterable<Integer> {
    public static final a osW = new a(null);
    private final int osU;
    private final int osV;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.osU = i;
        this.osV = kotlin.internal.d.ak(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.osU;
    }

    public final int getLast() {
        return this.osV;
    }

    public final int egt() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: egu */
    public ad iterator() {
        return new g(this.osU, this.osV, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.osU > this.osV : this.osU < this.osV;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.osU == ((f) obj).osU && this.osV == ((f) obj).osV && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.osU * 31) + this.osV) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.osU + IStringUtil.TOP_PATH + this.osV + " step " + this.step : this.osU + " downTo " + this.osV + " step " + (-this.step);
    }

    @kotlin.h
    /* loaded from: classes20.dex */
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
