package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes5.dex */
public class a implements Iterable<Character> {
    public static final C1295a qjt = new C1295a(null);
    private final char qjr;
    private final char qjs;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qjr = c;
        this.qjs = (char) kotlin.internal.d.ao(c, c2, i);
        this.step = i;
    }

    public final char eJa() {
        return this.qjr;
    }

    public final char eJb() {
        return this.qjs;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eJc */
    public kotlin.collections.m iterator() {
        return new b(this.qjr, this.qjs, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.qjr > this.qjs : this.qjr < this.qjs;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.qjr == ((a) obj).qjr && this.qjs == ((a) obj).qjs && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.qjr * 31) + this.qjs) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.qjr + IStringUtil.TOP_PATH + this.qjs + " step " + this.step : "" + this.qjr + " downTo " + this.qjs + " step " + (-this.step);
    }

    @kotlin.e
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1295a {
        private C1295a() {
        }

        public /* synthetic */ C1295a(o oVar) {
            this();
        }
    }
}
