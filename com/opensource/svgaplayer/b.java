package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class b extends Drawable {
    private boolean pSE;
    private int pSF;
    private final com.opensource.svgaplayer.a.b pSG;
    private final f pSH;
    private final c pSI;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pSH = fVar;
        this.pSI = cVar;
        this.pSE = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.pSG = new com.opensource.svgaplayer.a.b(this.pSH, this.pSI);
    }

    public final f eDX() {
        return this.pSH;
    }

    public final void Br(boolean z) {
        if (this.pSE != z) {
            this.pSE = z;
            invalidateSelf();
        }
    }

    public final int eDW() {
        return this.pSF;
    }

    public final void RO(int i) {
        if (this.pSF != i) {
            this.pSF = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        p.o(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.pSE && canvas != null) {
            this.pSG.a(canvas, this.pSF, this.scaleType);
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
