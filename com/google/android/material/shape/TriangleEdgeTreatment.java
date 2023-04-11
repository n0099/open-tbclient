package com.google.android.material.shape;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    public final boolean inside;
    public final float size;

    public TriangleEdgeTreatment(float f, boolean z) {
        this.size = f;
        this.inside = z;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, @NonNull ShapePath shapePath) {
        float f4;
        shapePath.lineTo(f2 - (this.size * f3), 0.0f);
        if (this.inside) {
            f4 = this.size;
        } else {
            f4 = -this.size;
        }
        shapePath.lineTo(f2, f4 * f3);
        shapePath.lineTo(f2 + (this.size * f3), 0.0f);
        shapePath.lineTo(f, 0.0f);
    }
}
