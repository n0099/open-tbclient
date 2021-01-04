package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class b extends Drawable {
    private boolean pQW;
    private int pQX;
    private final com.opensource.svgaplayer.a.b pQY;
    private final f pQZ;
    private final c pRa;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pQZ = fVar;
        this.pRa = cVar;
        this.pQW = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.pQY = new com.opensource.svgaplayer.a.b(this.pQZ, this.pRa);
    }

    public final f eDt() {
        return this.pQZ;
    }

    public final void Br(boolean z) {
        if (this.pQW != z) {
            this.pQW = z;
            invalidateSelf();
        }
    }

    public final int eDs() {
        return this.pQX;
    }

    public final void Ry(int i) {
        if (this.pQX != i) {
            this.pQX = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        p.o(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.pQW && canvas != null) {
            this.pQY.a(canvas, this.pQX, this.scaleType);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
