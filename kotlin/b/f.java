package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.y;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes14.dex */
public class f implements Iterable<Integer> {
    public static final a quJ = new a(null);
    private final int pmU;
    private final int quI;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.quI = i;
        this.pmU = kotlin.internal.d.am(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.quI;
    }

    public final int getLast() {
        return this.pmU;
    }

    public final int eLj() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eLk */
    public y iterator() {
        return new g(this.quI, this.pmU, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.quI > this.pmU : this.quI < this.pmU;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.quI == ((f) obj).quI && this.pmU == ((f) obj).pmU && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.quI * 31) + this.pmU) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.quI + IStringUtil.TOP_PATH + this.pmU + " step " + this.step : "" + this.quI + " downTo " + this.pmU + " step " + (-this.step);
    }

    @kotlin.e
    /* loaded from: classes14.dex */
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
