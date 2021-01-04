package com.ksad.lottie.model.content;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f8366a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f8367b;

    public c(float[] fArr, int[] iArr) {
        this.f8366a = fArr;
        this.f8367b = iArr;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.f8367b.length != cVar2.f8367b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f8367b.length + " vs " + cVar2.f8367b.length + ")");
        }
        for (int i = 0; i < cVar.f8367b.length; i++) {
            this.f8366a[i] = com.ksad.lottie.d.e.a(cVar.f8366a[i], cVar2.f8366a[i], f);
            this.f8367b[i] = com.ksad.lottie.d.b.a(f, cVar.f8367b[i], cVar2.f8367b[i]);
        }
    }

    public float[] a() {
        return this.f8366a;
    }

    public int[] b() {
        return this.f8367b;
    }

    public int c() {
        return this.f8367b.length;
    }
}
