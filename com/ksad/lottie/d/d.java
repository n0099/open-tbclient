package com.ksad.lottie.d;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private float f7987a;

    /* renamed from: b  reason: collision with root package name */
    private int f7988b;

    public void a(float f) {
        this.f7987a += f;
        this.f7988b++;
        if (this.f7988b == Integer.MAX_VALUE) {
            this.f7987a /= 2.0f;
            this.f7988b /= 2;
        }
    }
}
