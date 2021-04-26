package com.davemorrissey.labs.subscaleview;

import android.graphics.PointF;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class ImageViewState implements Serializable {
    public static final long serialVersionUID = 7824752745943015695L;
    public float centerX;
    public float centerY;
    public int orientation;
    public float scale;

    public ImageViewState(float f2, PointF pointF, int i2) {
        this.scale = f2;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i2;
    }

    public PointF getCenter() {
        return new PointF(this.centerX, this.centerY);
    }

    public int getOrientation() {
        return this.orientation;
    }

    public float getScale() {
        return this.scale;
    }
}
