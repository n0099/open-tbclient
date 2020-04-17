package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public class a implements Iterable<Character> {
    public static final C0792a mXY = new C0792a(null);
    private final char mXW;
    private final char mXX;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.mXW = c;
        this.mXX = (char) kotlin.internal.c.an(c, c2, i);
        this.step = i;
    }

    public final char dEc() {
        return this.mXW;
    }

    public final char dEd() {
        return this.mXX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dEe */
    public kotlin.collections.n iterator() {
        return new b(this.mXW, this.mXX, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.mXW > this.mXX : this.mXW < this.mXX;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.mXW == ((a) obj).mXW && this.mXX == ((a) obj).mXX && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.mXW * 31) + this.mXX) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.mXW + IStringUtil.TOP_PATH + this.mXX + " step " + this.step : this.mXW + " downTo " + this.mXX + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0792a {
        private C0792a() {
        }

        public /* synthetic */ C0792a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
