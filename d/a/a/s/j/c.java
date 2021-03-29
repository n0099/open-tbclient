package d.a.a.s.j;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f41369a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f41370b;

    public c(float[] fArr, int[] iArr) {
        this.f41369a = fArr;
        this.f41370b = iArr;
    }

    public int[] a() {
        return this.f41370b;
    }

    public float[] b() {
        return this.f41369a;
    }

    public int c() {
        return this.f41370b.length;
    }

    public void d(c cVar, c cVar2, float f2) {
        if (cVar.f41370b.length == cVar2.f41370b.length) {
            for (int i = 0; i < cVar.f41370b.length; i++) {
                this.f41369a[i] = d.a.a.v.e.j(cVar.f41369a[i], cVar2.f41369a[i], f2);
                this.f41370b[i] = d.a.a.v.b.c(f2, cVar.f41370b[i], cVar2.f41370b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f41370b.length + " vs " + cVar2.f41370b.length + SmallTailInfo.EMOTION_SUFFIX);
    }
}
