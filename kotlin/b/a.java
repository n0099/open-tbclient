package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes6.dex */
public class a implements Iterable<Character> {
    public static final C1307a qtY = new C1307a(null);
    private final char qtW;
    private final char qtX;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qtW = c;
        this.qtX = (char) kotlin.internal.d.am(c, c2, i);
        this.step = i;
    }

    public final char eLy() {
        return this.qtW;
    }

    public final char eLz() {
        return this.qtX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eLA */
    public kotlin.collections.m iterator() {
        return new b(this.qtW, this.qtX, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.qtW > this.qtX : this.qtW < this.qtX;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.qtW == ((a) obj).qtW && this.qtX == ((a) obj).qtX && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.qtW * 31) + this.qtX) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.qtW + IStringUtil.TOP_PATH + this.qtX + " step " + this.step : "" + this.qtW + " downTo " + this.qtX + " step " + (-this.step);
    }

    @kotlin.e
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1307a {
        private C1307a() {
        }

        public /* synthetic */ C1307a(o oVar) {
            this();
        }
    }
}
