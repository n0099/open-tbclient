package com.tb.airbnb.lottie.c;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: if  reason: not valid java name */
    private float f3if;
    private int n;

    public void o(float f) {
        this.f3if += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.f3if /= 2.0f;
            this.n /= 2;
        }
    }
}
