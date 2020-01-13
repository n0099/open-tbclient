package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
import kotlin.jvm.internal.o;
/* loaded from: classes5.dex */
public class a implements Iterable<Integer> {
    public static final C0760a nBS = new C0760a(null);
    private final int nBQ;
    private final int nBR;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nBQ = i;
        this.nBR = kotlin.internal.c.at(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.nBQ;
    }

    public final int getLast() {
        return this.nBR;
    }

    public final int dJr() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dJs */
    public ad iterator() {
        return new b(this.nBQ, this.nBR, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nBQ > this.nBR : this.nBQ < this.nBR;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.nBQ == ((a) obj).nBQ && this.nBR == ((a) obj).nBR && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nBQ * 31) + this.nBR) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nBQ + IStringUtil.TOP_PATH + this.nBR + " step " + this.step : this.nBQ + " downTo " + this.nBR + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0760a {
        private C0760a() {
        }

        public /* synthetic */ C0760a(o oVar) {
            this();
        }

        public final a au(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
