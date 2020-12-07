package com.tb.airbnb.lottie.model.content;
/* loaded from: classes20.dex */
public class c {
    private final float[] FU;
    private final int[] FV;

    public c(float[] fArr, int[] iArr) {
        this.FU = fArr;
        this.FV = iArr;
    }

    public float[] jO() {
        return this.FU;
    }

    public int[] getColors() {
        return this.FV;
    }

    public int getSize() {
        return this.FV.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.FV.length != cVar2.FV.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.FV.length + " vs " + cVar2.FV.length + ")");
        }
        for (int i = 0; i < cVar.FV.length; i++) {
            this.FU[i] = com.tb.airbnb.lottie.d.e.lerp(cVar.FU[i], cVar2.FU[i], f);
            this.FV[i] = com.tb.airbnb.lottie.d.b.b(f, cVar.FV[i], cVar2.FV[i]);
        }
    }
}
