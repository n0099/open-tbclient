package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes5.dex */
public class f implements Iterable<Integer> {
    public static final a oCV = new a(null);
    private final int oCT;
    private final int oCU;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.oCT = i;
        this.oCU = kotlin.internal.d.an(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.oCT;
    }

    public final int getLast() {
        return this.oCU;
    }

    public final int ekz() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: ekA */
    public ad iterator() {
        return new g(this.oCT, this.oCU, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.oCT > this.oCU : this.oCT < this.oCU;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.oCT == ((f) obj).oCT && this.oCU == ((f) obj).oCU && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.oCT * 31) + this.oCU) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.oCT + IStringUtil.TOP_PATH + this.oCU + " step " + this.step : this.oCT + " downTo " + this.oCU + " step " + (-this.step);
    }

    @kotlin.h
    /* loaded from: classes5.dex */
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
