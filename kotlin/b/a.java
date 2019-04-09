package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0470a jSe = new C0470a(null);
    private final int jSc;
    private final int jSd;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.jSc = i;
        this.jSd = kotlin.internal.a.ak(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.jSc;
    }

    public final int getLast() {
        return this.jSd;
    }

    public final int cCx() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cCy */
    public y iterator() {
        return new b(this.jSc, this.jSd, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.jSc > this.jSd : this.jSc < this.jSd;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.jSc == ((a) obj).jSc && this.jSd == ((a) obj).jSd && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.jSc * 31) + this.jSd) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.jSc + ".." + this.jSd + " step " + this.step : "" + this.jSc + " downTo " + this.jSd + " step " + (-this.step);
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
