package com.tb.airbnb.lottie.model.content;
/* loaded from: classes6.dex */
public class c {
    private final float[] Eg;
    private final int[] colors;

    public c(float[] fArr, int[] iArr) {
        this.Eg = fArr;
        this.colors = iArr;
    }

    public float[] im() {
        return this.Eg;
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
            this.Eg[i] = com.tb.airbnb.lottie.d.e.lerp(cVar.Eg[i], cVar2.Eg[i], f);
            this.colors[i] = com.tb.airbnb.lottie.d.b.b(f, cVar.colors[i], cVar2.colors[i]);
        }
    }
}
