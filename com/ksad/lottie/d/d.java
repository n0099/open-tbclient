package com.ksad.lottie.d;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private float f5342a;
    private int b;

    public void a(float f) {
        this.f5342a += f;
        this.b++;
        if (this.b == Integer.MAX_VALUE) {
            this.f5342a /= 2.0f;
            this.b /= 2;
        }
    }
}
