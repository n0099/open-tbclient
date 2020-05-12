package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public class a implements Iterable<Character> {
    public static final C0813a mYb = new C0813a(null);
    private final char mXZ;
    private final char mYa;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.mXZ = c;
        this.mYa = (char) kotlin.internal.c.an(c, c2, i);
        this.step = i;
    }

    public final char dDZ() {
        return this.mXZ;
    }

    public final char dEa() {
        return this.mYa;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dEb */
    public kotlin.collections.n iterator() {
        return new b(this.mXZ, this.mYa, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.mXZ > this.mYa : this.mXZ < this.mYa;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.mXZ == ((a) obj).mXZ && this.mYa == ((a) obj).mYa && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.mXZ * 31) + this.mYa) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.mXZ + IStringUtil.TOP_PATH + this.mYa + " step " + this.step : this.mXZ + " downTo " + this.mYa + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0813a {
        private C0813a() {
        }

        public /* synthetic */ C0813a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
