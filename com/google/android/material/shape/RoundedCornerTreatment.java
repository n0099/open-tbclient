package com.google.android.material.shape;

import com.google.android.material.internal.Experimental;
@Experimental("The shapes API is currently experimental and subject to change")
/* loaded from: classes6.dex */
public class RoundedCornerTreatment extends CornerTreatment {
    public final float radius;

    public RoundedCornerTreatment(float f2) {
        this.radius = f2;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(float f2, float f3, ShapePath shapePath) {
        shapePath.reset(0.0f, this.radius * f3);
        float f4 = this.radius;
        shapePath.addArc(0.0f, 0.0f, f4 * 2.0f * f3, f4 * 2.0f * f3, f2 + 180.0f, 90.0f);
    }
}
