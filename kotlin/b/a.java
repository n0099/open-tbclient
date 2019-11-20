package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0593a kvp = new C0593a(null);
    private final int kvn;
    private final int kvo;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.kvn = i;
        this.kvo = kotlin.internal.a.ad(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.kvn;
    }

    public final int getLast() {
        return this.kvo;
    }

    public final int cNa() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cNb */
    public y iterator() {
        return new b(this.kvn, this.kvo, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.kvn > this.kvo : this.kvn < this.kvo;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.kvn == ((a) obj).kvn && this.kvo == ((a) obj).kvo && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.kvn * 31) + this.kvo) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.kvn + ".." + this.kvo + " step " + this.step : "" + this.kvn + " downTo " + this.kvo + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0593a {
        private C0593a() {
        }

        public /* synthetic */ C0593a(o oVar) {
            this();
        }

        public final a ae(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
