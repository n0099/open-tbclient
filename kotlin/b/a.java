package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0398a iBH = new C0398a(null);
    private final int iBF;
    private final int iBG;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.iBF = i;
        this.iBG = kotlin.internal.a.ah(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.iBF;
    }

    public final int getLast() {
        return this.iBG;
    }

    public final int ccI() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: ccJ */
    public y iterator() {
        return new b(this.iBF, this.iBG, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.iBF > this.iBG : this.iBF < this.iBG;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.iBF == ((a) obj).iBF && this.iBG == ((a) obj).iBG && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.iBF * 31) + this.iBG) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.iBF + ".." + this.iBG + " step " + this.step : "" + this.iBF + " downTo " + this.iBG + " step " + (-this.step);
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
