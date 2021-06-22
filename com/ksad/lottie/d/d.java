package com.ksad.lottie.d;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public float f31993a;

    /* renamed from: b  reason: collision with root package name */
    public int f31994b;

    public void a(float f2) {
        float f3 = this.f31993a + f2;
        this.f31993a = f3;
        int i2 = this.f31994b + 1;
        this.f31994b = i2;
        if (i2 == Integer.MAX_VALUE) {
            this.f31993a = f3 / 2.0f;
            this.f31994b = i2 / 2;
        }
    }
}
