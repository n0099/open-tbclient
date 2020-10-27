package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes10.dex */
public class a implements Iterable<Character> {
    public static final C1056a pJx = new C1056a(null);
    private final char pJv;
    private final char pJw;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.pJv = c;
        this.pJw = (char) kotlin.internal.d.ao(c, c2, i);
        this.step = i;
    }

    public final char eyh() {
        return this.pJv;
    }

    public final char eyi() {
        return this.pJw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eyj */
    public kotlin.collections.n iterator() {
        return new b(this.pJv, this.pJw, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.pJv > this.pJw : this.pJv < this.pJw;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.pJv == ((a) obj).pJv && this.pJw == ((a) obj).pJw && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.pJv * 31) + this.pJw) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.pJv + IStringUtil.TOP_PATH + this.pJw + " step " + this.step : this.pJv + " downTo " + this.pJw + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C1056a {
        private C1056a() {
        }

        public /* synthetic */ C1056a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
