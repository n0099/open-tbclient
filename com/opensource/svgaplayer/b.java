package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes5.dex */
public final class b extends Drawable {
    private final f pZA;
    private final c pZB;
    private boolean pZx;
    private int pZy;
    private final com.opensource.svgaplayer.a.b pZz;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        p.p(fVar, "videoItem");
        p.p(cVar, "dynamicItem");
        this.pZA = fVar;
        this.pZB = cVar;
        this.pZx = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.pZz = new com.opensource.svgaplayer.a.b(this.pZA, this.pZB);
    }

    public final f eCK() {
        return this.pZA;
    }

    public final void BE(boolean z) {
        if (this.pZx != z) {
            this.pZx = z;
            invalidateSelf();
        }
    }

    public final int eCJ() {
        return this.pZy;
    }

    public final void QH(int i) {
        if (this.pZy != i) {
            this.pZy = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        p.p(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.pZx && canvas != null) {
            this.pZz.a(canvas, this.pZy, this.scaleType);
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
