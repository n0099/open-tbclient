package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0356a ipD = new C0356a(null);
    private final int ipB;
    private final int ipC;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.ipB = i;
        this.ipC = kotlin.internal.a.ah(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.ipB;
    }

    public final int getLast() {
        return this.ipC;
    }

    public final int cap() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: caq */
    public y iterator() {
        return new b(this.ipB, this.ipC, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.ipB > this.ipC : this.ipB < this.ipC;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.ipB == ((a) obj).ipB && this.ipC == ((a) obj).ipC && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.ipB * 31) + this.ipC) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.ipB + ".." + this.ipC + " step " + this.step : "" + this.ipB + " downTo " + this.ipC + " step " + (-this.step);
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
