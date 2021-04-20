package com.ksad.lottie.model.content;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f31800a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f31801b;

    public c(float[] fArr, int[] iArr) {
        this.f31800a = fArr;
        this.f31801b = iArr;
    }

    public void a(c cVar, c cVar2, float f2) {
        if (cVar.f31801b.length == cVar2.f31801b.length) {
            for (int i = 0; i < cVar.f31801b.length; i++) {
                this.f31800a[i] = com.ksad.lottie.d.e.a(cVar.f31800a[i], cVar2.f31800a[i], f2);
                this.f31801b[i] = com.ksad.lottie.d.b.a(f2, cVar.f31801b[i], cVar2.f31801b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f31801b.length + " vs " + cVar2.f31801b.length + SmallTailInfo.EMOTION_SUFFIX);
    }

    public float[] a() {
        return this.f31800a;
    }

    public int[] b() {
        return this.f31801b;
    }

    public int c() {
        return this.f31801b.length;
    }
}
