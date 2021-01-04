package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;
/* loaded from: classes5.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private float cradleVerticalOffset;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f, float f2, float f3) {
        this.fabMargin = f;
        this.roundedCornerRadius = f2;
        this.cradleVerticalOffset = f3;
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.horizontalOffset = 0.0f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, ShapePath shapePath) {
        if (this.fabDiameter == 0.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f3 = ((this.fabMargin * 2.0f) + this.fabDiameter) / 2.0f;
        float f4 = f2 * this.roundedCornerRadius;
        float f5 = (f / 2.0f) + this.horizontalOffset;
        float f6 = (this.cradleVerticalOffset * f2) + ((1.0f - f2) * f3);
        if (f6 / f3 >= 1.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f7 = f3 + f4;
        float f8 = f6 + f4;
        float sqrt = (float) Math.sqrt((f7 * f7) - (f8 * f8));
        float f9 = f5 - sqrt;
        float f10 = f5 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f8));
        float f11 = 90.0f - degrees;
        shapePath.lineTo(f9 - f4, 0.0f);
        shapePath.addArc(f9 - f4, 0.0f, f9 + f4, f4 * 2.0f, 270.0f, degrees);
        shapePath.addArc(f5 - f3, (-f3) - f6, f5 + f3, f3 - f6, 180.0f - f11, (2.0f * f11) - 180.0f);
        shapePath.addArc(f10 - f4, 0.0f, f10 + f4, f4 * 2.0f, 270.0f - degrees, degrees);
        shapePath.lineTo(f, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHorizontalOffset(float f) {
        this.horizontalOffset = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCradleVerticalOffset(float f) {
        this.cradleVerticalOffset = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFabDiameter(float f) {
        this.fabDiameter = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFabCradleMargin(float f) {
        this.fabMargin = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFabCradleRoundedCornerRadius(float f) {
        this.roundedCornerRadius = f;
    }
}
