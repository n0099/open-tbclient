package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
@kotlin.h
/* loaded from: classes10.dex */
public class a implements Iterable<Character> {
    public static final C0984a oSa = new C0984a(null);
    private final char oRY;
    private final char oRZ;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.oRY = c;
        this.oRZ = (char) kotlin.internal.d.an(c, c2, i);
        this.step = i;
    }

    public final char eoj() {
        return this.oRY;
    }

    public final char eok() {
        return this.oRZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eol */
    public kotlin.collections.n iterator() {
        return new b(this.oRY, this.oRZ, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.oRY > this.oRZ : this.oRY < this.oRZ;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.oRY == ((a) obj).oRY && this.oRZ == ((a) obj).oRZ && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.oRY * 31) + this.oRZ) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.oRY + IStringUtil.TOP_PATH + this.oRZ + " step " + this.step : this.oRY + " downTo " + this.oRZ + " step " + (-this.step);
    }

    @kotlin.h
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0984a {
        private C0984a() {
        }

        public /* synthetic */ C0984a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }
}
