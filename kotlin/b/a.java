package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0491a kkw = new C0491a(null);
    private final int kku;
    private final int kkv;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.kku = i;
        this.kkv = kotlin.internal.a.al(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.kku;
    }

    public final int getLast() {
        return this.kkv;
    }

    public final int cKd() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cKe */
    public y iterator() {
        return new b(this.kku, this.kkv, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.kku > this.kkv : this.kku < this.kkv;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.kku == ((a) obj).kku && this.kkv == ((a) obj).kkv && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.kku * 31) + this.kkv) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.kku + ".." + this.kkv + " step " + this.step : "" + this.kku + " downTo " + this.kkv + " step " + (-this.step);
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
