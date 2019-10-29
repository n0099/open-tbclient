package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0604a kwg = new C0604a(null);
    private final int kwe;
    private final int kwf;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.kwe = i;
        this.kwf = kotlin.internal.a.ad(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.kwe;
    }

    public final int getLast() {
        return this.kwf;
    }

    public final int cNc() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cNd */
    public y iterator() {
        return new b(this.kwe, this.kwf, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.kwe > this.kwf : this.kwe < this.kwf;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.kwe == ((a) obj).kwe && this.kwf == ((a) obj).kwf && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.kwe * 31) + this.kwf) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.kwe + ".." + this.kwf + " step " + this.step : "" + this.kwe + " downTo " + this.kwf + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0604a {
        private C0604a() {
        }

        public /* synthetic */ C0604a(o oVar) {
            this();
        }

        public final a ae(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
