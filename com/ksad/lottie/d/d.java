package com.ksad.lottie.d;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public float f31364a;

    /* renamed from: b  reason: collision with root package name */
    public int f31365b;

    public void a(float f2) {
        float f3 = this.f31364a + f2;
        this.f31364a = f3;
        int i = this.f31365b + 1;
        this.f31365b = i;
        if (i == Integer.MAX_VALUE) {
            this.f31364a = f3 / 2.0f;
            this.f31365b = i / 2;
        }
    }
}
