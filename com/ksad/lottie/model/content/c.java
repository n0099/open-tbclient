package com.ksad.lottie.model.content;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f31511a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f31512b;

    public c(float[] fArr, int[] iArr) {
        this.f31511a = fArr;
        this.f31512b = iArr;
    }

    public void a(c cVar, c cVar2, float f2) {
        if (cVar.f31512b.length == cVar2.f31512b.length) {
            for (int i = 0; i < cVar.f31512b.length; i++) {
                this.f31511a[i] = com.ksad.lottie.d.e.a(cVar.f31511a[i], cVar2.f31511a[i], f2);
                this.f31512b[i] = com.ksad.lottie.d.b.a(f2, cVar.f31512b[i], cVar2.f31512b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f31512b.length + " vs " + cVar2.f31512b.length + SmallTailInfo.EMOTION_SUFFIX);
    }

    public float[] a() {
        return this.f31511a;
    }

    public int[] b() {
        return this.f31512b;
    }

    public int c() {
        return this.f31512b.length;
    }
}
