package com.ksad.lottie.d;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public float f31749a;

    /* renamed from: b  reason: collision with root package name */
    public int f31750b;

    public void a(float f2) {
        float f3 = this.f31749a + f2;
        this.f31749a = f3;
        int i = this.f31750b + 1;
        this.f31750b = i;
        if (i == Integer.MAX_VALUE) {
            this.f31749a = f3 / 2.0f;
            this.f31750b = i / 2;
        }
    }
}
