package com.tb.airbnb.lottie.d;
/* loaded from: classes6.dex */
public class d {
    private float FK;
    private int n;

    public void add(float f) {
        this.FK += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.FK /= 2.0f;
            this.n /= 2;
        }
    }
}
