package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.y;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes6.dex */
public class f implements Iterable<Integer> {
    public static final a qtH = new a(null);
    private final int pkp;
    private final int qtG;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qtG = i;
        this.pkp = kotlin.internal.d.am(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.qtG;
    }

    public final int getLast() {
        return this.pkp;
    }

    public final int eLt() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eLu */
    public y iterator() {
        return new g(this.qtG, this.pkp, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.qtG > this.pkp : this.qtG < this.pkp;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.qtG == ((f) obj).qtG && this.pkp == ((f) obj).pkp && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.qtG * 31) + this.pkp) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.qtG + IStringUtil.TOP_PATH + this.pkp + " step " + this.step : "" + this.qtG + " downTo " + this.pkp + " step " + (-this.step);
    }

    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final f an(int i, int i2, int i3) {
            return new f(i, i2, i3);
        }
    }
}
