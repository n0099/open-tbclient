package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.y;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes5.dex */
public class f implements Iterable<Integer> {
    public static final a qjD = new a(null);
    private final int oZY;
    private final int qjC;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qjC = i;
        this.oZY = kotlin.internal.d.ao(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.qjC;
    }

    public final int getLast() {
        return this.oZY;
    }

    public final int eJd() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eJe */
    public y iterator() {
        return new g(this.qjC, this.oZY, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.qjC > this.oZY : this.qjC < this.oZY;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.qjC == ((f) obj).qjC && this.oZY == ((f) obj).oZY && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.qjC * 31) + this.oZY) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.qjC + IStringUtil.TOP_PATH + this.oZY + " step " + this.step : "" + this.qjC + " downTo " + this.oZY + " step " + (-this.step);
    }

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final f ap(int i, int i2, int i3) {
            return new f(i, i2, i3);
        }
    }
}
