package com.google.android.material.shape;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class RoundedCornerTreatment extends CornerTreatment {
    public float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath shapePath, float f2, float f3, float f4) {
        shapePath.reset(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        float f5 = f4 * 2.0f * f3;
        shapePath.addArc(0.0f, 0.0f, f5, f5, 180.0f, f2);
    }

    @Deprecated
    public RoundedCornerTreatment(float f2) {
        this.radius = -1.0f;
        this.radius = f2;
    }
}
