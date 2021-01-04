package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.y;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes5.dex */
public class f implements Iterable<Integer> {
    public static final a qmw = new a(null);
    private final int peC;
    private final int qmv;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qmv = i;
        this.peC = kotlin.internal.d.an(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.qmv;
    }

    public final int getLast() {
        return this.peC;
    }

    public final int eMp() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eMq */
    public y iterator() {
        return new g(this.qmv, this.peC, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.qmv > this.peC : this.qmv < this.peC;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.qmv == ((f) obj).qmv && this.peC == ((f) obj).peC && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.qmv * 31) + this.peC) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.qmv + IStringUtil.TOP_PATH + this.peC + " step " + this.step : "" + this.qmv + " downTo " + this.peC + " step " + (-this.step);
    }

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final f ao(int i, int i2, int i3) {
            return new f(i, i2, i3);
        }
    }
}
