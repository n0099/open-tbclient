package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public class a implements Iterable<Character> {
    public static final C0876a nuo = new C0876a(null);
    private final char nul;
    private final char nun;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nul = c;
        this.nun = (char) kotlin.internal.c.an(c, c2, i);
        this.step = i;
    }

    public final char dMh() {
        return this.nul;
    }

    public final char dMi() {
        return this.nun;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dMj */
    public kotlin.collections.n iterator() {
        return new b(this.nul, this.nun, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nul > this.nun : this.nul < this.nun;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.nul == ((a) obj).nul && this.nun == ((a) obj).nun && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nul * 31) + this.nun) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nul + IStringUtil.TOP_PATH + this.nun + " step " + this.step : this.nul + " downTo " + this.nun + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0876a {
        private C0876a() {
        }

        public /* synthetic */ C0876a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
