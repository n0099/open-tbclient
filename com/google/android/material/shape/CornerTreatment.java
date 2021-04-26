package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float f2, float f3, @NonNull ShapePath shapePath) {
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f2, float f3, float f4) {
        getCornerPath(f2, f3, shapePath);
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f2, float f3, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        getCornerPath(shapePath, f2, f3, cornerSize.getCornerSize(rectF));
    }
}
