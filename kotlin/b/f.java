package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.y;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes17.dex */
public class f implements Iterable<Integer> {
    public static final a pKT = new a(null);
    private final int oYt;
    private final int pKS;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.pKS = i;
        this.oYt = kotlin.internal.d.al(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.pKS;
    }

    public final int getLast() {
        return this.oYt;
    }

    public final int eEh() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eEi */
    public y iterator() {
        return new g(this.pKS, this.oYt, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.pKS > this.oYt : this.pKS < this.oYt;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.pKS == ((f) obj).pKS && this.oYt == ((f) obj).oYt && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.pKS * 31) + this.oYt) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.pKS + IStringUtil.TOP_PATH + this.oYt + " step " + this.step : "" + this.pKS + " downTo " + this.oYt + " step " + (-this.step);
    }

    @kotlin.e
    /* loaded from: classes17.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final f am(int i, int i2, int i3) {
            return new f(i, i2, i3);
        }
    }
}
