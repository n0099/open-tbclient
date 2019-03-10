package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0376a jST = new C0376a(null);
    private final int jSR;
    private final int jSS;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.jSR = i;
        this.jSS = kotlin.internal.a.ak(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.jSR;
    }

    public final int getLast() {
        return this.jSS;
    }

    public final int cCF() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cCG */
    public y iterator() {
        return new b(this.jSR, this.jSS, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.jSR > this.jSS : this.jSR < this.jSS;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.jSR == ((a) obj).jSR && this.jSS == ((a) obj).jSS && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.jSR * 31) + this.jSS) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.jSR + ".." + this.jSS + " step " + this.step : "" + this.jSR + " downTo " + this.jSS + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0376a {
        private C0376a() {
        }

        public /* synthetic */ C0376a(o oVar) {
            this();
        }

        public final a al(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
