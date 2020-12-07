package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes17.dex */
public class a implements Iterable<Character> {
    public static final C1053a pKI = new C1053a(null);
    private final char pKG;
    private final char pKH;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.pKG = c;
        this.pKH = (char) kotlin.internal.d.al(c, c2, i);
        this.step = i;
    }

    public final char eEd() {
        return this.pKG;
    }

    public final char eEe() {
        return this.pKH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eEf */
    public kotlin.collections.m iterator() {
        return new b(this.pKG, this.pKH, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.pKG > this.pKH : this.pKG < this.pKH;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.pKG == ((a) obj).pKG && this.pKH == ((a) obj).pKH && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.pKG * 31) + this.pKH) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.pKG + IStringUtil.TOP_PATH + this.pKH + " step " + this.step : "" + this.pKG + " downTo " + this.pKH + " step " + (-this.step);
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
