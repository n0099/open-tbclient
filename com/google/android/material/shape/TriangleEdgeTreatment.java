package com.google.android.material.shape;

import com.google.android.material.internal.Experimental;
@Experimental("The shapes API is currently experimental and subject to change")
/* loaded from: classes6.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    public final boolean inside;
    public final float size;

    public TriangleEdgeTreatment(float f2, boolean z) {
        this.size = f2;
        this.inside = z;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f2, float f3, ShapePath shapePath) {
        float f4 = f2 / 2.0f;
        shapePath.lineTo(f4 - (this.size * f3), 0.0f);
        shapePath.lineTo(f4, (this.inside ? this.size : -this.size) * f3);
        shapePath.lineTo(f4 + (this.size * f3), 0.0f);
        shapePath.lineTo(f2, 0.0f);
    }
}
