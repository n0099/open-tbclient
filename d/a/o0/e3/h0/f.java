package d.a.o0.e3.h0;

import android.util.SparseIntArray;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f57812c = {3, 8, 13};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f57813d = {2, 12};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f57814e = {20};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f57815f = {3, 13, 23};

    /* renamed from: a  reason: collision with root package name */
    public SparseIntArray f57816a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    public final int[] f57817b;

    public f(String str, int[] iArr) {
        this.f57817b = iArr;
    }

    public void a(int i2, int i3) {
        SparseIntArray sparseIntArray;
        if (i2 < 0 || i3 < 0 || (sparseIntArray = this.f57816a) == null) {
            return;
        }
        sparseIntArray.append(i3, i2);
    }

    public int b(int i2) {
        SparseIntArray sparseIntArray;
        if (i2 >= 0 && (sparseIntArray = this.f57816a) != null) {
            return sparseIntArray.get(i2, -1);
        }
        return -1;
    }

    public void c(int i2) {
        SparseIntArray sparseIntArray = this.f57816a;
        if (sparseIntArray != null) {
            sparseIntArray.delete(i2);
        }
    }

    public void d() {
        e(0);
    }

    public void e(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        SparseIntArray sparseIntArray = this.f57816a;
        if (sparseIntArray != null) {
            sparseIntArray.clear();
            int[] iArr = this.f57817b;
            if (iArr != null) {
                for (int i3 : iArr) {
                    if (i3 >= 0) {
                        this.f57816a.append(i3 + i2, i3);
                    }
                }
            }
        }
    }
}
