package com.ksad.lottie.model.content;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f8067a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f8068b;

    public c(float[] fArr, int[] iArr) {
        this.f8067a = fArr;
        this.f8068b = iArr;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.f8068b.length != cVar2.f8068b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f8068b.length + " vs " + cVar2.f8068b.length + ")");
        }
        for (int i = 0; i < cVar.f8068b.length; i++) {
            this.f8067a[i] = com.ksad.lottie.d.e.a(cVar.f8067a[i], cVar2.f8067a[i], f);
            this.f8068b[i] = com.ksad.lottie.d.b.a(f, cVar.f8068b[i], cVar2.f8068b[i]);
        }
    }

    public float[] a() {
        return this.f8067a;
    }

    public int[] b() {
        return this.f8068b;
    }

    public int c() {
        return this.f8068b.length;
    }
}
