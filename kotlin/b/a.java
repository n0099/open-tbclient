package kotlin.b;

import com.baidu.android.common.others.IStringUtil;
import kotlin.collections.y;
import kotlin.jvm.internal.o;
/* loaded from: classes4.dex */
public class a implements Iterable<Integer> {
    public static final C0716a mZl = new C0716a(null);
    private final int mZj;
    private final int mZk;
    private final int step;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.mZj = i;
        this.mZk = kotlin.internal.c.at(i, i2, i3);
        this.step = i3;
    }

    public final int getFirst() {
        return this.mZj;
    }

    public final int getLast() {
        return this.mZk;
    }

    public final int dEV() {
        return this.step;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: dEW */
    public y iterator() {
        return new b(this.mZj, this.mZk, this.step);
    }

    public boolean isEmpty() {
        return this.step > 0 ? this.mZj > this.mZk : this.mZj < this.mZk;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.mZj == ((a) obj).mZj && this.mZk == ((a) obj).mZk && this.step == ((a) obj).step));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.mZj * 31) + this.mZk) * 31) + this.step;
    }

    public String toString() {
        return this.step > 0 ? "" + this.mZj + IStringUtil.TOP_PATH + this.mZk + " step " + this.step : "" + this.mZj + " downTo " + this.mZk + " step " + (-this.step);
    }

    /* renamed from: kotlin.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0716a {
        private C0716a() {
        }

        public /* synthetic */ C0716a(o oVar) {
            this();
        }

        public final a au(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
