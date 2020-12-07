package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.y;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes17.dex */
public class f implements Iterable<Integer> {
    public static final a pKR = new a(null);
    private final int oYr;
    private final int pKQ;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.pKQ = i;
        this.oYr = kotlin.internal.d.al(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.pKQ;
    }

    public final int getLast() {
        return this.oYr;
    }

    public final int eEg() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eEh */
    public y iterator() {
        return new g(this.pKQ, this.oYr, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.pKQ > this.oYr : this.pKQ < this.oYr;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.pKQ == ((f) obj).pKQ && this.oYr == ((f) obj).oYr && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.pKQ * 31) + this.oYr) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.pKQ + IStringUtil.TOP_PATH + this.oYr + " step " + this.step : "" + this.pKQ + " downTo " + this.oYr + " step " + (-this.step);
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
