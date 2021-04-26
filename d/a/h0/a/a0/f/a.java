package d.a.h0.a.a0.f;

import androidx.annotation.IntRange;
import d.a.h0.a.c0.c;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f41162b = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public static int f41163c = 5;

    /* renamed from: a  reason: collision with root package name */
    public int[] f41164a;

    public a(@IntRange(from = 1) int i2) {
        c(i2, false);
    }

    public final int a(int i2) {
        return i2 >> f41163c;
    }

    public boolean b(@IntRange(from = 0) int i2) {
        if (i2 < 0) {
            c.b("Component-DiffBitMap", "diff < 0: " + i2);
            if (f41162b) {
                throw new IndexOutOfBoundsException("diff < 0: " + i2);
            }
            return false;
        }
        int[] iArr = this.f41164a;
        int length = (iArr.length << f41163c) - 1;
        if (i2 <= length) {
            return ((1 << i2) & iArr[a(i2)]) != 0;
        }
        String str = "diff > " + length + ": " + i2;
        c.b("Component-DiffBitMap", str);
        if (f41162b) {
            throw new IndexOutOfBoundsException(str);
        }
        return false;
    }

    public final void c(@IntRange(from = 1) int i2, boolean z) {
        if (i2 <= 0) {
            String str = "number <= 0: " + i2;
            c.b("Component-DiffBitMap", str);
            if (f41162b) {
                throw new NegativeArraySizeException(str);
            }
            i2 = 500;
        }
        int[] iArr = new int[a(i2 - 1) + 1];
        this.f41164a = iArr;
        int length = iArr.length;
        if (z) {
            for (int i3 = 0; i3 < length; i3++) {
                this.f41164a[i3] = -1;
            }
        }
    }

    public void d(@IntRange(from = 0) int i2) {
        if (i2 < 0) {
            c.b("Component-DiffBitMap", "diff < 0: " + i2);
            if (f41162b) {
                throw new IndexOutOfBoundsException("diff < 0: " + i2);
            }
            return;
        }
        int[] iArr = this.f41164a;
        int length = (iArr.length << f41163c) - 1;
        if (i2 > length) {
            String str = "diff > " + length + ": " + i2;
            c.b("Component-DiffBitMap", str);
            if (f41162b) {
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
