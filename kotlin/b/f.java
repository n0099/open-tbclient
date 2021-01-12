package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.y;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes5.dex */
public class f implements Iterable<Integer> {
    public static final a qjC = new a(null);
    private final int oZX;
    private final int qjB;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qjB = i;
        this.oZX = kotlin.internal.d.ao(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.qjB;
    }

    public final int getLast() {
        return this.oZX;
    }

    public final int eJd() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eJe */
    public y iterator() {
        return new g(this.qjB, this.oZX, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.qjB > this.oZX : this.qjB < this.oZX;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.qjB == ((f) obj).qjB && this.oZX == ((f) obj).oZX && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.qjB * 31) + this.oZX) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.qjB + IStringUtil.TOP_PATH + this.oZX + " step " + this.step : "" + this.qjB + " downTo " + this.oZX + " step " + (-this.step);
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
