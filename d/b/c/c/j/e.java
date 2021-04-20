package d.b.c.c.j;

import d.b.c.e.p.j;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int[] f42071a;

    public e(int i, int i2, int i3) {
        this.f42071a = null;
        this.f42071a = r0;
        int[] iArr = {i, i2, i3};
    }

    public int a() {
        int[] iArr = this.f42071a;
        if (iArr == null || iArr.length != 1) {
            return 0;
        }
        return iArr[0];
    }

    public int b() {
        int[] iArr = this.f42071a;
        if (iArr == null || iArr.length != 3) {
            return 0;
        }
        int I = j.I();
        if (I != 1) {
            if (I != 2) {
                if (I != 3) {
                    return this.f42071a[2];
                }
                return this.f42071a[1];
            }
            return this.f42071a[0];
        }
        return this.f42071a[2];
    }
}
