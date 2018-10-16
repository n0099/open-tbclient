package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0356a ipC = new C0356a(null);
    private final int ipA;
    private final int ipB;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.ipA = i;
        this.ipB = kotlin.internal.a.ah(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.ipA;
    }

    public final int getLast() {
        return this.ipB;
    }

    public final int cap() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: caq */
    public y iterator() {
        return new b(this.ipA, this.ipB, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.ipA > this.ipB : this.ipA < this.ipB;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.ipA == ((a) obj).ipA && this.ipB == ((a) obj).ipB && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.ipA * 31) + this.ipB) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.ipA + ".." + this.ipB + " step " + this.step : "" + this.ipA + " downTo " + this.ipB + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0356a {
        private C0356a() {
        }

        public /* synthetic */ C0356a(o oVar) {
            this();
        }

        public final a ai(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
