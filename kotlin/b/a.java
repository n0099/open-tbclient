package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0470a jSd = new C0470a(null);
    private final int jSb;
    private final int jSc;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.jSb = i;
        this.jSc = kotlin.internal.a.ak(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.jSb;
    }

    public final int getLast() {
        return this.jSc;
    }

    public final int cCx() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cCy */
    public y iterator() {
        return new b(this.jSb, this.jSc, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.jSb > this.jSc : this.jSb < this.jSc;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.jSb == ((a) obj).jSb && this.jSc == ((a) obj).jSc && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.jSb * 31) + this.jSc) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.jSb + ".." + this.jSc + " step " + this.step : "" + this.jSb + " downTo " + this.jSc + " step " + (-this.step);
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
