package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0470a jSL = new C0470a(null);
    private final int jSJ;
    private final int jSK;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.jSJ = i;
        this.jSK = kotlin.internal.a.ak(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.jSJ;
    }

    public final int getLast() {
        return this.jSK;
    }

    public final int cCI() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cCJ */
    public y iterator() {
        return new b(this.jSJ, this.jSK, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.jSJ > this.jSK : this.jSJ < this.jSK;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.jSJ == ((a) obj).jSJ && this.jSK == ((a) obj).jSK && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.jSJ * 31) + this.jSK) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.jSJ + ".." + this.jSK + " step " + this.step : "" + this.jSJ + " downTo " + this.jSK + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0470a {
        private C0470a() {
        }

        public /* synthetic */ C0470a(o oVar) {
            this();
        }

        public final a al(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
