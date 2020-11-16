package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes9.dex */
public class f implements Iterable<Integer> {
    public static final a pUD = new a(null);
    private final int oJl;
    private final int pUC;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.pUC = i;
        this.oJl = kotlin.internal.d.ar(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.pUC;
    }

    public final int getLast() {
        return this.oJl;
    }

    public final int eCa() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eCb */
    public ad iterator() {
        return new g(this.pUC, this.oJl, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.pUC > this.oJl : this.pUC < this.oJl;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.pUC == ((f) obj).pUC && this.oJl == ((f) obj).oJl && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.pUC * 31) + this.oJl) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.pUC + IStringUtil.TOP_PATH + this.oJl + " step " + this.step : this.pUC + " downTo " + this.oJl + " step " + (-this.step);
    }

    @kotlin.h
    /* loaded from: classes9.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final f as(int i, int i2, int i3) {
            return new f(i, i2, i3);
        }
    }
}
