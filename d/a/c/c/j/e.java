package d.a.c.c.j;

import d.a.c.e.p.j;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int[] f42066a;

    public e(int i2, int i3, int i4) {
        this.f42066a = null;
        this.f42066a = r0;
        int[] iArr = {i2, i3, i4};
    }

    public int a() {
        int[] iArr = this.f42066a;
        if (iArr == null || iArr.length != 1) {
            return 0;
        }
        return iArr[0];
    }

    public int b() {
        int[] iArr = this.f42066a;
        if (iArr == null || iArr.length != 3) {
            return 0;
        }
        int I = j.I();
        if (I != 1) {
            if (I != 2) {
                if (I != 3) {
                    return this.f42066a[2];
                }
                return this.f42066a[1];
            }
            return this.f42066a[0];
        }
        return this.f42066a[2];
    }
}
