package d.b.j0.d3.h0;

import android.util.SparseIntArray;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f55241c = {3, 8, 13};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f55242d = {2, 12};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f55243e = {20};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f55244f = {3, 13, 23};

    /* renamed from: a  reason: collision with root package name */
    public SparseIntArray f55245a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    public final int[] f55246b;

    public f(String str, int[] iArr) {
        this.f55246b = iArr;
    }

    public void a(int i, int i2) {
        SparseIntArray sparseIntArray;
        if (i < 0 || i2 < 0 || (sparseIntArray = this.f55245a) == null) {
            return;
        }
        sparseIntArray.append(i2, i);
    }

    public int b(int i) {
        SparseIntArray sparseIntArray;
        if (i >= 0 && (sparseIntArray = this.f55245a) != null) {
            return sparseIntArray.get(i, -1);
        }
        return -1;
    }

    public void c(int i) {
        SparseIntArray sparseIntArray = this.f55245a;
        if (sparseIntArray != null) {
            sparseIntArray.delete(i);
        }
    }

    public void d() {
        e(0);
    }

    public void e(int i) {
        if (i < 0) {
            i = 0;
        }
        SparseIntArray sparseIntArray = this.f55245a;
        if (sparseIntArray != null) {
            sparseIntArray.clear();
            int[] iArr = this.f55246b;
            if (iArr != null) {
                for (int i2 : iArr) {
                    if (i2 >= 0) {
                        this.f55245a.append(i2 + i, i2);
                    }
                }
            }
        }
    }
}
