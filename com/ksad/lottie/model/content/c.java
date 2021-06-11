package com.ksad.lottie.model.content;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f32046a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f32047b;

    public c(float[] fArr, int[] iArr) {
        this.f32046a = fArr;
        this.f32047b = iArr;
    }

    public void a(c cVar, c cVar2, float f2) {
        if (cVar.f32047b.length == cVar2.f32047b.length) {
            for (int i2 = 0; i2 < cVar.f32047b.length; i2++) {
                this.f32046a[i2] = com.ksad.lottie.d.e.a(cVar.f32046a[i2], cVar2.f32046a[i2], f2);
                this.f32047b[i2] = com.ksad.lottie.d.b.a(f2, cVar.f32047b[i2], cVar2.f32047b[i2]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f32047b.length + " vs " + cVar2.f32047b.length + SmallTailInfo.EMOTION_SUFFIX);
    }

    public float[] a() {
        return this.f32046a;
    }

    public int[] b() {
        return this.f32047b;
    }

    public int c() {
        return this.f32047b.length;
    }
}
