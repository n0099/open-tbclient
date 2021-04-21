package d.b.h0.a.a0.f;

import androidx.annotation.IntRange;
import d.b.h0.a.c0.c;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f43897b = k.f45772a;

    /* renamed from: c  reason: collision with root package name */
    public static int f43898c = 5;

    /* renamed from: a  reason: collision with root package name */
    public int[] f43899a;

    public a(@IntRange(from = 1) int i) {
        c(i, false);
    }

    public final int a(int i) {
        return i >> f43898c;
    }

    public boolean b(@IntRange(from = 0) int i) {
        if (i < 0) {
            c.b("Component-DiffBitMap", "diff < 0: " + i);
            if (f43897b) {
                throw new IndexOutOfBoundsException("diff < 0: " + i);
            }
            return false;
        }
        int[] iArr = this.f43899a;
        int length = (iArr.length << f43898c) - 1;
        if (i <= length) {
            return ((1 << i) & iArr[a(i)]) != 0;
        }
        String str = "diff > " + length + ": " + i;
        c.b("Component-DiffBitMap", str);
        if (f43897b) {
            throw new IndexOutOfBoundsException(str);
        }
        return false;
    }

    public final void c(@IntRange(from = 1) int i, boolean z) {
        if (i <= 0) {
            String str = "number <= 0: " + i;
            c.b("Component-DiffBitMap", str);
            if (f43897b) {
                throw new NegativeArraySizeException(str);
            }
            i = 500;
        }
        int[] iArr = new int[a(i - 1) + 1];
        this.f43899a = iArr;
        int length = iArr.length;
        if (z) {
            for (int i2 = 0; i2 < length; i2++) {
                this.f43899a[i2] = -1;
            }
        }
    }

    public void d(@IntRange(from = 0) int i) {
        if (i < 0) {
            c.b("Component-DiffBitMap", "diff < 0: " + i);
            if (f43897b) {
                throw new IndexOutOfBoundsException("diff < 0: " + i);
            }
            return;
        }
        int[] iArr = this.f43899a;
        int length = (iArr.length << f43898c) - 1;
        if (i > length) {
            String str = "diff > " + length + ": " + i;
            c.b("Component-DiffBitMap", str);
            if (f43897b) {
                throw new IndexOutOfBoundsException(str);
            }
            return;
        }
        int a2 = a(i);
        iArr[a2] = (1 << i) | iArr[a2];
    }

    public a(@IntRange(from = 1) int i, boolean z) {
        c(i, z);
    }
}
