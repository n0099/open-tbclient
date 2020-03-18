package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public class a implements Iterable<Character> {
    public static final C0769a nEz = new C0769a(null);
    private final char nEx;
    private final char nEy;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nEx = c;
        this.nEy = (char) kotlin.internal.c.au(c, c2, i);
        this.step = i;
    }

    public final char dLd() {
        return this.nEx;
    }

    public final char dLe() {
        return this.nEy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dLf */
    public kotlin.collections.n iterator() {
        return new b(this.nEx, this.nEy, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nEx > this.nEy : this.nEx < this.nEy;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.nEx == ((a) obj).nEx && this.nEy == ((a) obj).nEy && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nEx * 31) + this.nEy) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nEx + IStringUtil.TOP_PATH + this.nEy + " step " + this.step : this.nEx + " downTo " + this.nEy + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0769a {
        private C0769a() {
        }

        public /* synthetic */ C0769a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
