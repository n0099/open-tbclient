package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes17.dex */
public class a implements Iterable<Character> {
    public static final C1053a pKK = new C1053a(null);
    private final char pKI;
    private final char pKJ;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.pKI = c;
        this.pKJ = (char) kotlin.internal.d.al(c, c2, i);
        this.step = i;
    }

    public final char eEe() {
        return this.pKI;
    }

    public final char eEf() {
        return this.pKJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eEg */
    public kotlin.collections.m iterator() {
        return new b(this.pKI, this.pKJ, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.pKI > this.pKJ : this.pKI < this.pKJ;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.pKI == ((a) obj).pKI && this.pKJ == ((a) obj).pKJ && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.pKI * 31) + this.pKJ) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.pKI + IStringUtil.TOP_PATH + this.pKJ + " step " + this.step : "" + this.pKI + " downTo " + this.pKJ + " step " + (-this.step);
    }

    @kotlin.e
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C1053a {
        private C1053a() {
        }

        public /* synthetic */ C1053a(o oVar) {
            this();
        }
    }
}
