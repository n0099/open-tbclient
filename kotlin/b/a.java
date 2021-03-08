package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes14.dex */
public class a implements Iterable<Character> {
    public static final C1289a quA = new C1289a(null);
    private final char quy;
    private final char quz;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.quy = c;
        this.quz = (char) kotlin.internal.d.am(c, c2, i);
        this.step = i;
    }

    public final char eLg() {
        return this.quy;
    }

    public final char eLh() {
        return this.quz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eLi */
    public kotlin.collections.m iterator() {
        return new b(this.quy, this.quz, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.quy > this.quz : this.quy < this.quz;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.quy == ((a) obj).quy && this.quz == ((a) obj).quz && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.quy * 31) + this.quz) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.quy + IStringUtil.TOP_PATH + this.quz + " step " + this.step : "" + this.quy + " downTo " + this.quz + " step " + (-this.step);
    }

    @kotlin.e
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C1289a {
        private C1289a() {
        }

        public /* synthetic */ C1289a(o oVar) {
            this();
        }
    }
}
