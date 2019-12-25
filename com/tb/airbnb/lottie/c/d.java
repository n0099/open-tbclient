package com.tb.airbnb.lottie.c;
/* loaded from: classes2.dex */
public class d {
    private float kj;
    private int n;

    public void add(float f) {
        this.kj += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.kj /= 2.0f;
            this.n /= 2;
        }
    }
}
