package com.davemorrissey.labs.subscaleview;

import android.graphics.PointF;
import java.io.Serializable;
/* loaded from: classes12.dex */
public class ImageViewState implements Serializable {
    private static final long serialVersionUID = 7824752745943015695L;
    private float centerX;
    private float centerY;
    private int orientation;
    private float scale;

    public ImageViewState(float f, PointF pointF, int i) {
        this.scale = f;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i;
    }

    public float getScale() {
        return this.scale;
    }

    public PointF getCenter() {
        return new PointF(this.centerX, this.centerY);
    }

    public int getOrientation() {
        return this.orientation;
    }
}
