package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0397a iCP = new C0397a(null);
    private final int iCN;
    private final int iCO;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.iCN = i;
        this.iCO = kotlin.internal.a.ah(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.iCN;
    }

    public final int getLast() {
        return this.iCO;
    }

    public final int cdq() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cdr */
    public y iterator() {
        return new b(this.iCN, this.iCO, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.iCN > this.iCO : this.iCN < this.iCO;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.iCN == ((a) obj).iCN && this.iCO == ((a) obj).iCO && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.iCN * 31) + this.iCO) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.iCN + ".." + this.iCO + " step " + this.step : "" + this.iCN + " downTo " + this.iCO + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0397a {
        private C0397a() {
        }

        public /* synthetic */ C0397a(o oVar) {
            this();
        }

        public final a ai(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
