package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.y;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes6.dex */
public class f implements Iterable<Integer> {
    public static final a quh = new a(null);
    private final int pkP;
    private final int qug;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qug = i;
        this.pkP = kotlin.internal.d.am(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.qug;
    }

    public final int getLast() {
        return this.pkP;
    }

    public final int eLB() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eLC */
    public y iterator() {
        return new g(this.qug, this.pkP, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.qug > this.pkP : this.qug < this.pkP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.qug == ((f) obj).qug && this.pkP == ((f) obj).pkP && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.qug * 31) + this.pkP) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.qug + IStringUtil.TOP_PATH + this.pkP + " step " + this.step : "" + this.qug + " downTo " + this.pkP + " step " + (-this.step);
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
