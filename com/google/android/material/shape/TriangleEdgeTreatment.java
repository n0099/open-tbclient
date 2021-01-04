package com.google.android.material.shape;

import com.google.android.material.internal.Experimental;
@Experimental("The shapes API is currently experimental and subject to change")
/* loaded from: classes5.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f, boolean z) {
        this.size = f;
        this.inside = z;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, ShapePath shapePath) {
        shapePath.lineTo((f / 2.0f) - (this.size * f2), 0.0f);
        shapePath.lineTo(f / 2.0f, this.inside ? this.size * f2 : (-this.size) * f2);
        shapePath.lineTo((f / 2.0f) + (this.size * f2), 0.0f);
        shapePath.lineTo(f, 0.0f);
    }
}
