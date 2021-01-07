package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.y;
import kotlin.jvm.internal.o;
@kotlin.e
/* loaded from: classes5.dex */
public class f implements Iterable<Integer> {
    public static final a qoe = new a(null);
    private final int peC;
    private final int qod;
    private final int step;

    public f(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.qod = i;
        this.peC = kotlin.internal.d.ao(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.qod;
    }

    public final int getLast() {
        return this.peC;
    }

    public final int eMT() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: eMU */
    public y iterator() {
        return new g(this.qod, this.peC, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.qod > this.peC : this.qod < this.peC;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((isEmpty() && ((f) obj).isEmpty()) || (this.qod == ((f) obj).qod && this.peC == ((f) obj).peC && this.step == ((f) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.qod * 31) + this.peC) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.qod + IStringUtil.TOP_PATH + this.peC + " step " + this.step : "" + this.qod + " downTo " + this.peC + " step " + (-this.step);
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
