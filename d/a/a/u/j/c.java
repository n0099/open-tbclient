package d.a.a.u.j;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f41769a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f41770b;

    public c(float[] fArr, int[] iArr) {
        this.f41769a = fArr;
        this.f41770b = iArr;
    }

    public int[] a() {
        return this.f41770b;
    }

    public float[] b() {
        return this.f41769a;
    }

    public int c() {
        return this.f41770b.length;
    }

    public void d(c cVar, c cVar2, float f2) {
        if (cVar.f41770b.length == cVar2.f41770b.length) {
            for (int i = 0; i < cVar.f41770b.length; i++) {
                this.f41769a[i] = d.a.a.x.g.k(cVar.f41769a[i], cVar2.f41769a[i], f2);
                this.f41770b[i] = d.a.a.x.b.c(f2, cVar.f41770b[i], cVar2.f41770b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f41770b.length + " vs " + cVar2.f41770b.length + SmallTailInfo.EMOTION_SUFFIX);
    }
}
