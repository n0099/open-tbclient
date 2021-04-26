package com.google.android.material.transition.platform;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
/* loaded from: classes6.dex */
public final class MaterialArcMotion extends PathMotion {
    public static PointF getControlPoint(float f2, float f3, float f4, float f5) {
        if (f3 > f5) {
            return new PointF(f4, f3);
        }
        return new PointF(f2, f5);
    }

    @Override // android.transition.PathMotion
    @NonNull
    public Path getPath(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(f2, f3);
        PointF controlPoint = getControlPoint(f2, f3, f4, f5);
        path.quadTo(controlPoint.x, controlPoint.y, f4, f5);
        return path;
    }
}
