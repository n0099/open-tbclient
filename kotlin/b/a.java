package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public class a implements Iterable<Character> {
    public static final C0768a nCM = new C0768a(null);
    private final char nCK;
    private final char nCL;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nCK = c;
        this.nCL = (char) kotlin.internal.c.au(c, c2, i);
        this.step = i;
    }

    public final char dKD() {
        return this.nCK;
    }

    public final char dKE() {
        return this.nCL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dKF */
    public kotlin.collections.n iterator() {
        return new b(this.nCK, this.nCL, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nCK > this.nCL : this.nCK < this.nCL;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.nCK == ((a) obj).nCK && this.nCL == ((a) obj).nCL && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nCK * 31) + this.nCL) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nCK + IStringUtil.TOP_PATH + this.nCL + " step " + this.step : this.nCK + " downTo " + this.nCL + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0768a {
        private C0768a() {
        }

        public /* synthetic */ C0768a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
