package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public class a implements Iterable<Character> {
    public static final C0875a ntd = new C0875a(null);
    private final char ntb;
    private final char ntc;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.ntb = c;
        this.ntc = (char) kotlin.internal.c.an(c, c2, i);
        this.step = i;
    }

    public final char dLT() {
        return this.ntb;
    }

    public final char dLU() {
        return this.ntc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dLV */
    public kotlin.collections.n iterator() {
        return new b(this.ntb, this.ntc, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.ntb > this.ntc : this.ntb < this.ntc;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.ntb == ((a) obj).ntb && this.ntc == ((a) obj).ntc && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.ntb * 31) + this.ntc) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.ntb + IStringUtil.TOP_PATH + this.ntc + " step " + this.step : this.ntb + " downTo " + this.ntc + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0875a {
        private C0875a() {
        }

        public /* synthetic */ C0875a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
