package com.ksad.lottie.d;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public float f31654a;

    /* renamed from: b  reason: collision with root package name */
    public int f31655b;

    public void a(float f2) {
        float f3 = this.f31654a + f2;
        this.f31654a = f3;
        int i = this.f31655b + 1;
        this.f31655b = i;
        if (i == Integer.MAX_VALUE) {
            this.f31654a = f3 / 2.0f;
            this.f31655b = i / 2;
        }
    }
}
