package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0491a kkA = new C0491a(null);
    private final int kky;
    private final int kkz;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.kky = i;
        this.kkz = kotlin.internal.a.al(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.kky;
    }

    public final int getLast() {
        return this.kkz;
    }

    public final int cKe() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cKf */
    public y iterator() {
        return new b(this.kky, this.kkz, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.kky > this.kkz : this.kky < this.kkz;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.kky == ((a) obj).kky && this.kkz == ((a) obj).kkz && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.kky * 31) + this.kkz) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.kky + ".." + this.kkz + " step " + this.step : "" + this.kky + " downTo " + this.kkz + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0491a {
        private C0491a() {
        }

        public /* synthetic */ C0491a(o oVar) {
            this();
        }

        public final a am(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
