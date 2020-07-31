package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public class a implements Iterable<Character> {
    public static final C0911a nYM = new C0911a(null);
    private final char nYK;
    private final char nYL;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nYK = c;
        this.nYL = (char) kotlin.internal.c.ak(c, c2, i);
        this.step = i;
    }

    public final char dUn() {
        return this.nYK;
    }

    public final char dUo() {
        return this.nYL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dUp */
    public kotlin.collections.n iterator() {
        return new b(this.nYK, this.nYL, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nYK > this.nYL : this.nYK < this.nYL;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.nYK == ((a) obj).nYK && this.nYL == ((a) obj).nYL && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nYK * 31) + this.nYL) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nYK + IStringUtil.TOP_PATH + this.nYL + " step " + this.step : this.nYK + " downTo " + this.nYL + " step " + (-this.step);
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
