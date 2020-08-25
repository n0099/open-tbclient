package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes20.dex */
public class a implements Iterable<Character> {
    public static final C0969a osM = new C0969a(null);
    private final char osK;
    private final char osL;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.osK = c;
        this.osL = (char) kotlin.internal.d.ak(c, c2, i);
        this.step = i;
    }

    public final char egq() {
        return this.osK;
    }

    public final char egr() {
        return this.osL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: egs */
    public kotlin.collections.n iterator() {
        return new b(this.osK, this.osL, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.osK > this.osL : this.osK < this.osL;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.osK == ((a) obj).osK && this.osL == ((a) obj).osL && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.osK * 31) + this.osL) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.osK + IStringUtil.TOP_PATH + this.osL + " step " + this.step : this.osK + " downTo " + this.osL + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C0969a {
        private C0969a() {
        }

        public /* synthetic */ C0969a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
