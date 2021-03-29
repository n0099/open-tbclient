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
        double d3 = f3;
        shapePath.lineTo((float) (Math.sin(d2) * this.size * d3), (float) (Math.cos(d2) * this.size * d3));
    }
}
