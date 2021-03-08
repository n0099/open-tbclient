package com.ksad.lottie.model.content;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f5387a;
    private final int[] b;

    public c(float[] fArr, int[] iArr) {
        this.f5387a = fArr;
        this.b = iArr;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.b.length != cVar2.b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.b.length + " vs " + cVar2.b.length + ")");
        }
        for (int i = 0; i < cVar.b.length; i++) {
            this.f5387a[i] = com.ksad.lottie.d.e.a(cVar.f5387a[i], cVar2.f5387a[i], f);
            this.b[i] = com.ksad.lottie.d.b.a(f, cVar.b[i], cVar2.b[i]);
        }
    }

    public float[] a() {
        return this.f5387a;
    }

    public int[] b() {
        return this.b;
    }

    public int c() {
        return this.b.length;
    }
}
