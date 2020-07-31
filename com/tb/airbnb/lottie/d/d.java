package com.tb.airbnb.lottie.d;
/* loaded from: classes5.dex */
public class d {
    private float Gl;
    private int n;

    public void add(float f) {
        this.Gl += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.Gl /= 2.0f;
            this.n /= 2;
        }
    }
}
