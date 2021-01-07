package com.ksad.lottie.d;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private float f8287a;

    /* renamed from: b  reason: collision with root package name */
    private int f8288b;

    public void a(float f) {
        this.f8287a += f;
        this.f8288b++;
        if (this.f8288b == Integer.MAX_VALUE) {
            this.f8287a /= 2.0f;
            this.f8288b /= 2;
        }
    }
}
