package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public class a implements Iterable<Character> {
    public static final C0896a nQd = new C0896a(null);
    private final char nQb;
    private final char nQc;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nQb = c;
        this.nQc = (char) kotlin.internal.c.an(c, c2, i);
        this.step = i;
    }

    public final char dQR() {
        return this.nQb;
    }

    public final char dQS() {
        return this.nQc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dQT */
    public kotlin.collections.n iterator() {
        return new b(this.nQb, this.nQc, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nQb > this.nQc : this.nQb < this.nQc;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.nQb == ((a) obj).nQb && this.nQc == ((a) obj).nQc && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nQb * 31) + this.nQc) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nQb + IStringUtil.TOP_PATH + this.nQc + " step " + this.step : this.nQb + " downTo " + this.nQc + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0896a {
        private C0896a() {
        }

        public /* synthetic */ C0896a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
