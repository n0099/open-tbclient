package d.b.b.c.j;

import d.b.b.e.p.j;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int[] f41573a;

    public e(int i, int i2, int i3) {
        this.f41573a = null;
        this.f41573a = r0;
        int[] iArr = {i, i2, i3};
    }

    public int a() {
        int[] iArr = this.f41573a;
        if (iArr == null || iArr.length != 1) {
            return 0;
        }
        return iArr[0];
    }

    public int b() {
        int[] iArr = this.f41573a;
        if (iArr == null || iArr.length != 3) {
            return 0;
        }
        int I = j.I();
        if (I != 1) {
            if (I != 2) {
                if (I != 3) {
                    return this.f41573a[2];
                }
                return this.f41573a[1];
            }
            return this.f41573a[0];
        }
        return this.f41573a[2];
    }
}
