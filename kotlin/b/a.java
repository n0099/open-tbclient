package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes10.dex */
public class a implements Iterable<Character> {
    public static final C1076a pSR = new C1076a(null);
    private final char pSP;
    private final char pSQ;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.pSP = c;
        this.pSQ = (char) kotlin.internal.d.ao(c, c2, i);
        this.step = i;
    }

    public final char eBW() {
        return this.pSP;
    }

    public final char eBX() {
        return this.pSQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eBY */
    public kotlin.collections.n iterator() {
        return new b(this.pSP, this.pSQ, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.pSP > this.pSQ : this.pSP < this.pSQ;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.pSP == ((a) obj).pSP && this.pSQ == ((a) obj).pSQ && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.pSP * 31) + this.pSQ) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.pSP + IStringUtil.TOP_PATH + this.pSQ + " step " + this.step : this.pSP + " downTo " + this.pSQ + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C1076a {
        private C1076a() {
        }

        public /* synthetic */ C1076a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
