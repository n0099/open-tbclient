package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes5.dex */
public class a implements Iterable<Character> {
    public static final C1271a qmn = new C1271a(null);
    private final char qml;
    private final char qmm;
    private final int step;

    public a(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qml = c;
        this.qmm = (char) kotlin.internal.d.an(c, c2, i);
        this.step = i;
    }

    public final char eMm() {
        return this.qml;
    }

    public final char eMn() {
        return this.qmm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eMo */
    public kotlin.collections.m iterator() {
        return new b(this.qml, this.qmm, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.qml > this.qmm : this.qml < this.qmm;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.qml == ((a) obj).qml && this.qmm == ((a) obj).qmm && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.qml * 31) + this.qmm) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.qml + IStringUtil.TOP_PATH + this.qmm + " step " + this.step : "" + this.qml + " downTo " + this.qmm + " step " + (-this.step);
    }

    @kotlin.e
    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1271a {
        private C1271a() {
        }

        public /* synthetic */ C1271a(o oVar) {
            this();
        }
    }
}
