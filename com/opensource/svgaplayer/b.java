package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class b extends Drawable {
    private boolean pYj;
    private int pYk;
    private final com.opensource.svgaplayer.a.b pYl;
    private final f pYm;
    private final c pYn;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pYm = fVar;
        this.pYn = cVar;
        this.pYj = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.pYl = new com.opensource.svgaplayer.a.b(this.pYm, this.pYn);
    }

    public final f eCw() {
        return this.pYm;
    }

    public final void BG(boolean z) {
        if (this.pYj != z) {
            this.pYj = z;
            invalidateSelf();
        }
    }

    public final int eCv() {
        return this.pYk;
    }

    public final void QC(int i) {
        if (this.pYk != i) {
            this.pYk = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        p.o(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.pYj && canvas != null) {
            this.pYl.a(canvas, this.pYk, this.scaleType);
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
