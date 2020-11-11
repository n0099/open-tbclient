package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes10.dex */
public class f implements Iterable<Integer> {
    public static final a pTa = new a(null);
    private final int oHH;
    private final int pSZ;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.pSZ = i;
        this.oHH = kotlin.internal.d.ao(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.pSZ;
    }

    public final int getLast() {
        return this.oHH;
    }

    public final int eBZ() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eCa */
    public ad iterator() {
        return new g(this.pSZ, this.oHH, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.pSZ > this.oHH : this.pSZ < this.oHH;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.pSZ == ((f) obj).pSZ && this.oHH == ((f) obj).oHH && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.pSZ * 31) + this.oHH) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.pSZ + IStringUtil.TOP_PATH + this.oHH + " step " + this.step : this.pSZ + " downTo " + this.oHH + " step " + (-this.step);
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final f ap(int i, int i2, int i3) {
            return new f(i, i2, i3);
        }
    }
}
