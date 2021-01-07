package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes5.dex */
public class a implements Iterable<Character> {
    public static final C1312a qnV = new C1312a(null);
    private final char qnT;
    private final char qnU;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qnT = c;
        this.qnU = (char) kotlin.internal.d.ao(c, c2, i);
        this.step = i;
    }

    public final char eMQ() {
        return this.qnT;
    }

    public final char eMR() {
        return this.qnU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eMS */
    public kotlin.collections.m iterator() {
        return new b(this.qnT, this.qnU, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.qnT > this.qnU : this.qnT < this.qnU;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.qnT == ((a) obj).qnT && this.qnU == ((a) obj).qnU && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.qnT * 31) + this.qnU) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.qnT + IStringUtil.TOP_PATH + this.qnU + " step " + this.step : "" + this.qnT + " downTo " + this.qnU + " step " + (-this.step);
    }

    @kotlin.e
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1312a {
        private C1312a() {
        }

        public /* synthetic */ C1312a(o oVar) {
            this();
        }
    }
}
