package com.qq.e.comm.plugin.util;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
/* loaded from: classes15.dex */
public class ap {
    public static ShapeDrawable a(float f, int i, int i2) {
        float[] fArr = new float[8];
        for (int i3 = 0; i3 < 8; i3++) {
            fArr[i3] = f;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setAlpha(i2);
        return shapeDrawable;
    }
}
