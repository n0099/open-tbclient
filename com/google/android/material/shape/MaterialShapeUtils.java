package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewUtils;
/* loaded from: classes8.dex */
public class MaterialShapeUtils {
    @NonNull
    public static CornerTreatment createDefaultCornerTreatment() {
        return new RoundedCornerTreatment();
    }

    @NonNull
    public static EdgeTreatment createDefaultEdgeTreatment() {
        return new EdgeTreatment();
    }

    @NonNull
    public static CornerTreatment createCornerTreatment(int i) {
        if (i != 0) {
            if (i != 1) {
                return createDefaultCornerTreatment();
            }
            return new CutCornerTreatment();
        }
        return new RoundedCornerTreatment();
    }

    public static void setParentAbsoluteElevation(@NonNull View view2) {
        Drawable background = view2.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            setParentAbsoluteElevation(view2, (MaterialShapeDrawable) background);
        }
    }

    public static void setElevation(@NonNull View view2, float f) {
        Drawable background = view2.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).setElevation(f);
        }
    }

    public static void setParentAbsoluteElevation(@NonNull View view2, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        if (materialShapeDrawable.isElevationOverlayEnabled()) {
            materialShapeDrawable.setParentAbsoluteElevation(ViewUtils.getParentAbsoluteElevation(view2));
        }
    }
}
