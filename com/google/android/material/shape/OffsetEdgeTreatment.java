package com.google.android.material.shape;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public final class OffsetEdgeTreatment extends EdgeTreatment {
    public final float offset;
    public final EdgeTreatment other;

    public OffsetEdgeTreatment(@NonNull EdgeTreatment edgeTreatment, float f2) {
        this.other = edgeTreatment;
        this.offset = f2;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean forceIntersection() {
        return this.other.forceIntersection();
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f2, float f3, float f4, @NonNull ShapePath shapePath) {
        this.other.getEdgePath(f2, f3 - this.offset, f4, shapePath);
    }
}
