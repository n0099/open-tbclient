package d.a.a.s.j;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f41368a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f41369b;

    public c(float[] fArr, int[] iArr) {
        this.f41368a = fArr;
        this.f41369b = iArr;
    }

    public int[] a() {
        return this.f41369b;
    }

    public float[] b() {
        return this.f41368a;
    }

    public int c() {
        return this.f41369b.length;
    }

    public void d(c cVar, c cVar2, float f2) {
        if (cVar.f41369b.length == cVar2.f41369b.length) {
            for (int i = 0; i < cVar.f41369b.length; i++) {
                this.f41368a[i] = d.a.a.v.e.j(cVar.f41368a[i], cVar2.f41368a[i], f2);
                this.f41369b[i] = d.a.a.v.b.c(f2, cVar.f41369b[i], cVar2.f41369b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f41369b.length + " vs " + cVar2.f41369b.length + SmallTailInfo.EMOTION_SUFFIX);
    }
}
