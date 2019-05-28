package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0491a kkx = new C0491a(null);
    private final int kkv;
    private final int kkw;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.kkv = i;
        this.kkw = kotlin.internal.a.al(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.kkv;
    }

    public final int getLast() {
        return this.kkw;
    }

    public final int cKf() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cKg */
    public y iterator() {
        return new b(this.kkv, this.kkw, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.kkv > this.kkw : this.kkv < this.kkw;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.kkv == ((a) obj).kkv && this.kkw == ((a) obj).kkw && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.kkv * 31) + this.kkw) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.kkv + ".." + this.kkw + " step " + this.step : "" + this.kkv + " downTo " + this.kkw + " step " + (-this.step);
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
