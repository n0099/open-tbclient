package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public class a implements Iterable<Character> {
    public static final C0768a nCB = new C0768a(null);
    private final char nCA;
    private final char nCz;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nCz = c;
        this.nCA = (char) kotlin.internal.c.au(c, c2, i);
        this.step = i;
    }

    public final char dKC() {
        return this.nCz;
    }

    public final char dKD() {
        return this.nCA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dKE */
    public kotlin.collections.n iterator() {
        return new b(this.nCz, this.nCA, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nCz > this.nCA : this.nCz < this.nCA;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.nCz == ((a) obj).nCz && this.nCA == ((a) obj).nCA && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nCz * 31) + this.nCA) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nCz + IStringUtil.TOP_PATH + this.nCA + " step " + this.step : this.nCz + " downTo " + this.nCA + " step " + (-this.step);
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
