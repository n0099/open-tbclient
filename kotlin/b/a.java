package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0503a kvy = new C0503a(null);
    private final int kvw;
    private final int kvx;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.kvw = i;
        this.kvx = kotlin.internal.a.am(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.kvw;
    }

    public final int getLast() {
        return this.kvx;
    }

    public final int cOV() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cOW */
    public y iterator() {
        return new b(this.kvw, this.kvx, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.kvw > this.kvx : this.kvw < this.kvx;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.kvw == ((a) obj).kvw && this.kvx == ((a) obj).kvx && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.kvw * 31) + this.kvx) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.kvw + ".." + this.kvx + " step " + this.step : "" + this.kvw + " downTo " + this.kvx + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0503a {
        private C0503a() {
        }

        public /* synthetic */ C0503a(o oVar) {
            this();
        }

        public final a an(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
