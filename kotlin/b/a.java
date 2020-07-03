package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes7.dex */
public class a implements Iterable<Character> {
    public static final C0895a nQa = new C0895a(null);
    private final char nPY;
    private final char nPZ;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.nPY = c;
        this.nPZ = (char) kotlin.internal.c.an(c, c2, i);
        this.step = i;
    }

    public final char dQN() {
        return this.nPY;
    }

    public final char dQO() {
        return this.nPZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dQP */
    public kotlin.collections.n iterator() {
        return new b(this.nPY, this.nPZ, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.nPY > this.nPZ : this.nPY < this.nPZ;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.nPY == ((a) obj).nPY && this.nPZ == ((a) obj).nPZ && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.nPY * 31) + this.nPZ) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.nPY + IStringUtil.TOP_PATH + this.nPZ + " step " + this.step : this.nPY + " downTo " + this.nPZ + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0895a {
        private C0895a() {
        }

        public /* synthetic */ C0895a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
