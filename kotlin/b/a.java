package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public class a implements Iterable<Character> {
    public static final C0768a nCz = new C0768a(null);
    private final char nCx;
    private final char nCy;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nCx = c;
        this.nCy = (char) kotlin.internal.c.au(c, c2, i);
        this.step = i;
    }

    public final char dKA() {
        return this.nCx;
    }

    public final char dKB() {
        return this.nCy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dKC */
    public kotlin.collections.n iterator() {
        return new b(this.nCx, this.nCy, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nCx > this.nCy : this.nCx < this.nCy;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.nCx == ((a) obj).nCx && this.nCy == ((a) obj).nCy && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nCx * 31) + this.nCy) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nCx + IStringUtil.TOP_PATH + this.nCy + " step " + this.step : this.nCx + " downTo " + this.nCy + " step " + (-this.step);
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
