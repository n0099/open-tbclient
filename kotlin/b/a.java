package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0373a jSA = new C0373a(null);
    private final int jSy;
    private final int jSz;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.jSy = i;
        this.jSz = kotlin.internal.a.ak(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.jSy;
    }

    public final int getLast() {
        return this.jSz;
    }

    public final int cCv() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cCw */
    public y iterator() {
        return new b(this.jSy, this.jSz, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.jSy > this.jSz : this.jSy < this.jSz;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.jSy == ((a) obj).jSy && this.jSz == ((a) obj).jSz && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.jSy * 31) + this.jSz) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.jSy + ".." + this.jSz + " step " + this.step : "" + this.jSy + " downTo " + this.jSz + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0373a {
        private C0373a() {
        }

        public /* synthetic */ C0373a(o oVar) {
            this();
        }

        public final a al(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
