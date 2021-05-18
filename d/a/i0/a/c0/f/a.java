package d.a.i0.a.c0.f;

import androidx.annotation.IntRange;
import d.a.i0.a.e0.d;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f40742b = k.f43025a;

    /* renamed from: c  reason: collision with root package name */
    public static int f40743c = 5;

    /* renamed from: a  reason: collision with root package name */
    public int[] f40744a;

    public a(@IntRange(from = 1) int i2) {
        c(i2, false);
    }

    public final int a(int i2) {
        return i2 >> f40743c;
    }

    public boolean b(@IntRange(from = 0) int i2) {
        if (i2 < 0) {
            d.b("Component-DiffBitMap", "diff < 0: " + i2);
            if (f40742b) {
                throw new IndexOutOfBoundsException("diff < 0: " + i2);
            }
            return false;
        }
        int[] iArr = this.f40744a;
        int length = (iArr.length << f40743c) - 1;
        if (i2 <= length) {
            return ((1 << i2) & iArr[a(i2)]) != 0;
        }
        String str = "diff > " + length + ": " + i2;
        d.b("Component-DiffBitMap", str);
        if (f40742b) {
            throw new IndexOutOfBoundsException(str);
        }
        return false;
    }

    public final void c(@IntRange(from = 1) int i2, boolean z) {
        if (i2 <= 0) {
            String str = "number <= 0: " + i2;
            d.b("Component-DiffBitMap", str);
            if (f40742b) {
                throw new NegativeArraySizeException(str);
            }
            i2 = 500;
        }
        int[] iArr = new int[a(i2 - 1) + 1];
        this.f40744a = iArr;
        int length = iArr.length;
        if (z) {
            for (int i3 = 0; i3 < length; i3++) {
                this.f40744a[i3] = -1;
            }
        }
    }

    public void d(@IntRange(from = 0) int i2) {
        if (i2 < 0) {
            d.b("Component-DiffBitMap", "diff < 0: " + i2);
            if (f40742b) {
                throw new IndexOutOfBoundsException("diff < 0: " + i2);
            }
            return;
        }
        int[] iArr = this.f40744a;
        int length = (iArr.length << f40743c) - 1;
        if (i2 > length) {
            String str = "diff > " + length + ": " + i2;
            d.b("Component-DiffBitMap", str);
            if (f40742b) {
                throw new IndexOutOfBoundsException(str);
            }
            return;
        }
        int a2 = a(i2);
        iArr[a2] = (1 << i2) | iArr[a2];
    }

    public a(@IntRange(from = 1) int i2, boolean z) {
        c(i2, z);
    }
}
