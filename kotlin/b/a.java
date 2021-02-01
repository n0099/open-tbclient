package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes6.dex */
public class a implements Iterable<Character> {
    public static final C1305a qty = new C1305a(null);
    private final char qtw;
    private final char qtx;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qtw = c;
        this.qtx = (char) kotlin.internal.d.am(c, c2, i);
        this.step = i;
    }

    public final char eLq() {
        return this.qtw;
    }

    public final char eLr() {
        return this.qtx;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eLs */
    public kotlin.collections.m iterator() {
        return new b(this.qtw, this.qtx, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.qtw > this.qtx : this.qtw < this.qtx;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.qtw == ((a) obj).qtw && this.qtx == ((a) obj).qtx && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.qtw * 31) + this.qtx) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.qtw + IStringUtil.TOP_PATH + this.qtx + " step " + this.step : "" + this.qtw + " downTo " + this.qtx + " step " + (-this.step);
    }

    @kotlin.e
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1305a {
        private C1305a() {
        }

        public /* synthetic */ C1305a(o oVar) {
            this();
        }
    }
}
