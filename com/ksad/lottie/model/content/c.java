package com.ksad.lottie.model.content;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f8069a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f8070b;

    public c(float[] fArr, int[] iArr) {
        this.f8069a = fArr;
        this.f8070b = iArr;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.f8070b.length != cVar2.f8070b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f8070b.length + " vs " + cVar2.f8070b.length + ")");
        }
        for (int i = 0; i < cVar.f8070b.length; i++) {
            this.f8069a[i] = com.ksad.lottie.d.e.a(cVar.f8069a[i], cVar2.f8069a[i], f);
            this.f8070b[i] = com.ksad.lottie.d.b.a(f, cVar.f8070b[i], cVar2.f8070b[i]);
        }
    }

    public float[] a() {
        return this.f8069a;
    }

    public int[] b() {
        return this.f8070b;
    }

    public int c() {
        return this.f8070b.length;
    }
}
