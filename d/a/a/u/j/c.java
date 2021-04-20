package d.a.a.u.j;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f41674a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f41675b;

    public c(float[] fArr, int[] iArr) {
        this.f41674a = fArr;
        this.f41675b = iArr;
    }

    public int[] a() {
        return this.f41675b;
    }

    public float[] b() {
        return this.f41674a;
    }

    public int c() {
        return this.f41675b.length;
    }

    public void d(c cVar, c cVar2, float f2) {
        if (cVar.f41675b.length == cVar2.f41675b.length) {
            for (int i = 0; i < cVar.f41675b.length; i++) {
                this.f41674a[i] = d.a.a.x.g.k(cVar.f41674a[i], cVar2.f41674a[i], f2);
                this.f41675b[i] = d.a.a.x.b.c(f2, cVar.f41675b[i], cVar2.f41675b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f41675b.length + " vs " + cVar2.f41675b.length + SmallTailInfo.EMOTION_SUFFIX);
    }
}
