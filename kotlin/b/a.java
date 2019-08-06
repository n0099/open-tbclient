package kotlin.b;

import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {
    public static final C0497a ktf = new C0497a(null);
    private final int ktd;
    private final int kte;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.ktd = i;
        this.kte = kotlin.internal.a.am(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.ktd;
    }

    public final int getLast() {
        return this.kte;
    }

    public final int cOj() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: cOk */
    public y iterator() {
        return new b(this.ktd, this.kte, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.ktd > this.kte : this.ktd < this.kte;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.ktd == ((a) obj).ktd && this.kte == ((a) obj).kte && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.ktd * 31) + this.kte) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.ktd + ".." + this.kte + " step " + this.step : "" + this.ktd + " downTo " + this.kte + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0497a {
        private C0497a() {
        }

        public /* synthetic */ C0497a(o oVar) {
            this();
        }

        public final a an(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
