package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes5.dex */
public class a implements Iterable<Character> {
    public static final C0966a oCL = new C0966a(null);
    private final char oCJ;
    private final char oCK;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.oCJ = c;
        this.oCK = (char) kotlin.internal.d.an(c, c2, i);
        this.step = i;
    }

    public final char ekw() {
        return this.oCJ;
    }

    public final char ekx() {
        return this.oCK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eky */
    public kotlin.collections.n iterator() {
        return new b(this.oCJ, this.oCK, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.oCJ > this.oCK : this.oCJ < this.oCK;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.oCJ == ((a) obj).oCJ && this.oCK == ((a) obj).oCK && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.oCJ * 31) + this.oCK) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.oCJ + IStringUtil.TOP_PATH + this.oCK + " step " + this.step : this.oCJ + " downTo " + this.oCK + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0966a {
        private C0966a() {
        }

        public /* synthetic */ C0966a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
