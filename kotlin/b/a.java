package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes9.dex */
public class a implements Iterable<Character> {
    public static final C1079a pUu = new C1079a(null);
    private final char pUs;
    private final char pUt;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.pUs = c;
        this.pUt = (char) kotlin.internal.d.ar(c, c2, i);
        this.step = i;
    }

    public final char eBX() {
        return this.pUs;
    }

    public final char eBY() {
        return this.pUt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eBZ */
    public kotlin.collections.n iterator() {
        return new b(this.pUs, this.pUt, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.pUs > this.pUt : this.pUs < this.pUt;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.pUs == ((a) obj).pUs && this.pUt == ((a) obj).pUt && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.pUs * 31) + this.pUt) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.pUs + IStringUtil.TOP_PATH + this.pUt + " step " + this.step : this.pUs + " downTo " + this.pUt + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1079a {
        private C1079a() {
        }

        public /* synthetic */ C1079a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
