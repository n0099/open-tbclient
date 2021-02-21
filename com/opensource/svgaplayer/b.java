package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class b extends Drawable {
    private boolean pYJ;
    private int pYK;
    private final com.opensource.svgaplayer.a.b pYL;
    private final f pYM;
    private final c pYN;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pYM = fVar;
        this.pYN = cVar;
        this.pYJ = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.pYL = new com.opensource.svgaplayer.a.b(this.pYM, this.pYN);
    }

    public final f eCE() {
        return this.pYM;
    }

    public final void BG(boolean z) {
        if (this.pYJ != z) {
            this.pYJ = z;
            invalidateSelf();
        }
    }

    public final int eCD() {
        return this.pYK;
    }

    public final void QD(int i) {
        if (this.pYK != i) {
            this.pYK = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        p.o(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.pYJ && canvas != null) {
            this.pYL.a(canvas, this.pYK, this.scaleType);
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
