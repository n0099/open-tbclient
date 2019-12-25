package com.tb.airbnb.lottie.model.content;
/* loaded from: classes2.dex */
public class c {
    private final float[] hT;
    private final int[] hU;

    public c(float[] fArr, int[] iArr) {
        this.hT = fArr;
        this.hU = iArr;
    }

    public float[] cx() {
        return this.hT;
    }

    public int[] getColors() {
        return this.hU;
    }

    public int getSize() {
        return this.hU.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.hU.length != cVar2.hU.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.hU.length + " vs " + cVar2.hU.length + ")");
        }
        for (int i = 0; i < cVar.hU.length; i++) {
            this.hT[i] = com.tb.airbnb.lottie.c.e.lerp(cVar.hT[i], cVar2.hT[i], f);
            this.hU[i] = com.tb.airbnb.lottie.c.a.b(f, cVar.hU[i], cVar2.hU[i]);
        }
    }
}
