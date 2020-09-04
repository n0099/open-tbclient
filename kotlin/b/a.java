package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes20.dex */
public class a implements Iterable<Character> {
    public static final C0969a ote = new C0969a(null);
    private final char otc;
    private final char otd;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.otc = c;
        this.otd = (char) kotlin.internal.d.ak(c, c2, i);
        this.step = i;
    }

    public final char egz() {
        return this.otc;
    }

    public final char egA() {
        return this.otd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: egB */
    public kotlin.collections.n iterator() {
        return new b(this.otc, this.otd, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.otc > this.otd : this.otc < this.otd;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.otc == ((a) obj).otc && this.otd == ((a) obj).otd && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.otc * 31) + this.otd) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.otc + IStringUtil.TOP_PATH + this.otd + " step " + this.step : this.otc + " downTo " + this.otd + " step " + (-this.step);
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
