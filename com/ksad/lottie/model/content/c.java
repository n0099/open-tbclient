package com.ksad.lottie.model.content;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f8367a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f8368b;

    public c(float[] fArr, int[] iArr) {
        this.f8367a = fArr;
        this.f8368b = iArr;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.f8368b.length != cVar2.f8368b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f8368b.length + " vs " + cVar2.f8368b.length + ")");
        }
        for (int i = 0; i < cVar.f8368b.length; i++) {
            this.f8367a[i] = com.ksad.lottie.d.e.a(cVar.f8367a[i], cVar2.f8367a[i], f);
            this.f8368b[i] = com.ksad.lottie.d.b.a(f, cVar.f8368b[i], cVar2.f8368b[i]);
        }
    }

    public float[] a() {
        return this.f8367a;
    }

    public int[] b() {
        return this.f8368b;
    }

    public int c() {
        return this.f8368b.length;
    }
}
