package com.google.android.material.shape;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    public final boolean inside;
    public final float size;

    public TriangleEdgeTreatment(float f2, boolean z) {
        this.size = f2;
        this.inside = z;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f2, float f3, float f4, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f3 - (this.size * f4), 0.0f);
        shapePath.lineTo(f3, (this.inside ? this.size : -this.size) * f4);
        shapePath.lineTo(f3 + (this.size * f4), 0.0f);
        shapePath.lineTo(f2, 0.0f);
    }
}
