package com.tb.airbnb.lottie.model.content;
/* loaded from: classes17.dex */
public class c {
    private final float[] Fd;
    private final int[] colors;

    public c(float[] fArr, int[] iArr) {
        this.Fd = fArr;
        this.colors = iArr;
    }

    public float[] jO() {
        return this.Fd;
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
            this.Fd[i] = com.tb.airbnb.lottie.d.e.lerp(cVar.Fd[i], cVar2.Fd[i], f);
            this.colors[i] = com.tb.airbnb.lottie.d.b.b(f, cVar.colors[i], cVar2.colors[i]);
        }
    }
}
