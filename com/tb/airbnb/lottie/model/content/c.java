package com.tb.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class c {
    private final int[] colors;
    private final float[] hW;

    public c(float[] fArr, int[] iArr) {
        this.hW = fArr;
        this.colors = iArr;
    }

    public float[] cy() {
        return this.hW;
    }

    public int[] getColors() {
        return this.colors;
    }

    public int getSize() {
        return this.colors.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.colors.length != cVar2.colors.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.colors.length + " vs " + cVar2.colors.length + ")");
        }
        for (int i = 0; i < cVar.colors.length; i++) {
            this.hW[i] = com.tb.airbnb.lottie.d.e.lerp(cVar.hW[i], cVar2.hW[i], f);
            this.colors[i] = com.tb.airbnb.lottie.d.b.b(f, cVar.colors[i], cVar2.colors[i]);
        }
    }
}
