package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0384a irn = new C0384a(null);
    private final int irl;
    private final int irm;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.irl = i;
        this.irm = kotlin.internal.a.ah(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.irl;
    }

    public final int getLast() {
        return this.irm;
    }

    public final int bZM() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: bZN */
    public y iterator() {
        return new b(this.irl, this.irm, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.irl > this.irm : this.irl < this.irm;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.irl == ((a) obj).irl && this.irm == ((a) obj).irm && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.irl * 31) + this.irm) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.irl + ".." + this.irm + " step " + this.step : "" + this.irl + " downTo " + this.irm + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0384a {
        private C0384a() {
        }

        public /* synthetic */ C0384a(o oVar) {
            this();
        }

        public final a ai(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
