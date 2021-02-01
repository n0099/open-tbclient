package com.ksad.lottie.d;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private float f7989a;

    /* renamed from: b  reason: collision with root package name */
    private int f7990b;

    public void a(float f) {
        this.f7989a += f;
        this.f7990b++;
        if (this.f7990b == Integer.MAX_VALUE) {
            this.f7989a /= 2.0f;
            this.f7990b /= 2;
        }
    }
}
