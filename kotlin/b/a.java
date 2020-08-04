package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public class a implements Iterable<Character> {
    public static final C0911a nYO = new C0911a(null);
    private final char nYM;
    private final char nYN;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nYM = c;
        this.nYN = (char) kotlin.internal.c.ak(c, c2, i);
        this.step = i;
    }

    public final char dUo() {
        return this.nYM;
    }

    public final char dUp() {
        return this.nYN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dUq */
    public kotlin.collections.n iterator() {
        return new b(this.nYM, this.nYN, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nYM > this.nYN : this.nYM < this.nYN;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.nYM == ((a) obj).nYM && this.nYN == ((a) obj).nYN && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nYM * 31) + this.nYN) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nYM + IStringUtil.TOP_PATH + this.nYN + " step " + this.step : this.nYM + " downTo " + this.nYN + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0911a {
        private C0911a() {
        }

        public /* synthetic */ C0911a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
