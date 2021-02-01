package com.google.android.material.shape;

import com.google.android.material.internal.Experimental;
@Experimental("The shapes API is currently experimental and subject to change")
/* loaded from: classes15.dex */
public class CutCornerTreatment extends CornerTreatment {
    private final float size;

    public CutCornerTreatment(float f) {
        this.size = f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(float f, float f2, ShapePath shapePath) {
        shapePath.reset(0.0f, this.size * f2);
        shapePath.lineTo((float) (Math.sin(f) * this.size * f2), (float) (Math.cos(f) * this.size * f2));
    }
}
