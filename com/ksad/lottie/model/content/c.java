package com.ksad.lottie.model.content;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f31510a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f31511b;

    public c(float[] fArr, int[] iArr) {
        this.f31510a = fArr;
        this.f31511b = iArr;
    }

    public void a(c cVar, c cVar2, float f2) {
        if (cVar.f31511b.length == cVar2.f31511b.length) {
            for (int i = 0; i < cVar.f31511b.length; i++) {
                this.f31510a[i] = com.ksad.lottie.d.e.a(cVar.f31510a[i], cVar2.f31510a[i], f2);
                this.f31511b[i] = com.ksad.lottie.d.b.a(f2, cVar.f31511b[i], cVar2.f31511b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f31511b.length + " vs " + cVar2.f31511b.length + SmallTailInfo.EMOTION_SUFFIX);
    }

    public float[] a() {
        return this.f31510a;
    }

    public int[] b() {
        return this.f31511b;
    }

    public int c() {
        return this.f31511b.length;
    }
}
