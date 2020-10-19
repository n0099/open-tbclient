package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes10.dex */
public class f implements Iterable<Integer> {
    public static final a oSk = new a(null);
    private final int oSi;
    private final int oSj;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.oSi = i;
        this.oSj = kotlin.internal.d.an(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.oSi;
    }

    public final int getLast() {
        return this.oSj;
    }

    public final int eom() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eon */
    public ad iterator() {
        return new g(this.oSi, this.oSj, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.oSi > this.oSj : this.oSi < this.oSj;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.oSi == ((f) obj).oSi && this.oSj == ((f) obj).oSj && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.oSi * 31) + this.oSj) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.oSi + IStringUtil.TOP_PATH + this.oSj + " step " + this.step : this.oSi + " downTo " + this.oSj + " step " + (-this.step);
    }

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final f ao(int i, int i2, int i3) {
            return new f(i, i2, i3);
        }
    }
}
