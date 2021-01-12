package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes5.dex */
public final class b extends Drawable {
    private boolean pOe;
    private int pOf;
    private final com.opensource.svgaplayer.a.b pOg;
    private final f pOh;
    private final c pOi;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pOh = fVar;
        this.pOi = cVar;
        this.pOe = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.pOg = new com.opensource.svgaplayer.a.b(this.pOh, this.pOi);
    }

    public final f eAf() {
        return this.pOh;
    }

    public final void Bn(boolean z) {
        if (this.pOe != z) {
            this.pOe = z;
            invalidateSelf();
        }
    }

    public final int eAe() {
        return this.pOf;
    }

    public final void Qh(int i) {
        if (this.pOf != i) {
            this.pOf = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        p.o(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.pOe && canvas != null) {
            this.pOg.a(canvas, this.pOf, this.scaleType);
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
