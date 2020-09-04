package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes20.dex */
public class f implements Iterable<Integer> {
    public static final a oto = new a(null);
    private final int otm;
    private final int otn;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.otm = i;
        this.otn = kotlin.internal.d.ak(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.otm;
    }

    public final int getLast() {
        return this.otn;
    }

    public final int egC() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: egD */
    public ad iterator() {
        return new g(this.otm, this.otn, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.otm > this.otn : this.otm < this.otn;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.otm == ((f) obj).otm && this.otn == ((f) obj).otn && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.otm * 31) + this.otn) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? this.otm + IStringUtil.TOP_PATH + this.otn + " step " + this.step : this.otm + " downTo " + this.otn + " step " + (-this.step);
    }

    @kotlin.h
    /* loaded from: classes20.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final f al(int i, int i2, int i3) {
            return new f(i, i2, i3);
        }
    }
}
