package com.ksad.lottie.d;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private float f8286a;

    /* renamed from: b  reason: collision with root package name */
    private int f8287b;

    public void a(float f) {
        this.f8286a += f;
        this.f8287b++;
        if (this.f8287b == Integer.MAX_VALUE) {
            this.f8286a /= 2.0f;
            this.f8287b /= 2;
        }
    }
}
