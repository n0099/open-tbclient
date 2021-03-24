package com.google.android.material.shape;

import com.google.android.material.internal.Experimental;
@Experimental("The shapes API is currently experimental and subject to change")
/* loaded from: classes6.dex */
public class CutCornerTreatment extends CornerTreatment {
    public final float size;

    public CutCornerTreatment(float f2) {
        this.size = f2;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(float f2, float f3, ShapePath shapePath) {
        shapePath.reset(0.0f, this.size * f3);
        double d2 = f2;
        double sin = Math.sin(d2);
        double d3 = this.size;
        Double.isNaN(d3);
        double d4 = f3;
        Double.isNaN(d4);
        double cos = Math.cos(d2);
        double d5 = this.size;
        Double.isNaN(d5);
        Double.isNaN(d4);
        shapePath.lineTo((float) (sin * d3 * d4), (float) (cos * d5 * d4));
    }
}
