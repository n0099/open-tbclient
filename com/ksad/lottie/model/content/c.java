package com.ksad.lottie.model.content;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f32144a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f32145b;

    public c(float[] fArr, int[] iArr) {
        this.f32144a = fArr;
        this.f32145b = iArr;
    }

    public void a(c cVar, c cVar2, float f2) {
        if (cVar.f32145b.length == cVar2.f32145b.length) {
            for (int i2 = 0; i2 < cVar.f32145b.length; i2++) {
                this.f32144a[i2] = com.ksad.lottie.d.e.a(cVar.f32144a[i2], cVar2.f32144a[i2], f2);
                this.f32145b[i2] = com.ksad.lottie.d.b.a(f2, cVar.f32145b[i2], cVar2.f32145b[i2]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f32145b.length + " vs " + cVar2.f32145b.length + SmallTailInfo.EMOTION_SUFFIX);
    }

    public float[] a() {
        return this.f32144a;
    }

    public int[] b() {
        return this.f32145b;
    }

    public int c() {
        return this.f32145b.length;
    }
}
