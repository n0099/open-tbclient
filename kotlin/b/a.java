package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0398a iyx = new C0398a(null);
    private final int iyv;
    private final int iyw;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.iyv = i;
        this.iyw = kotlin.internal.a.ah(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.iyv;
    }

    public final int getLast() {
        return this.iyw;
    }

    public final int cbS() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cbT */
    public y iterator() {
        return new b(this.iyv, this.iyw, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.iyv > this.iyw : this.iyv < this.iyw;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.iyv == ((a) obj).iyv && this.iyw == ((a) obj).iyw && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.iyv * 31) + this.iyw) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.iyv + ".." + this.iyw + " step " + this.step : "" + this.iyv + " downTo " + this.iyw + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0398a {
        private C0398a() {
        }

        public /* synthetic */ C0398a(o oVar) {
            this();
        }

        public final a ai(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
