package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes5.dex */
public final class b extends Drawable {
    private boolean pOf;
    private int pOg;
    private final com.opensource.svgaplayer.a.b pOh;
    private final f pOi;
    private final c pOj;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pOi = fVar;
        this.pOj = cVar;
        this.pOf = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.pOh = new com.opensource.svgaplayer.a.b(this.pOi, this.pOj);
    }

    public final f eAf() {
        return this.pOi;
    }

    public final void Bn(boolean z) {
        if (this.pOf != z) {
            this.pOf = z;
            invalidateSelf();
        }
    }

    public final int eAe() {
        return this.pOg;
    }

    public final void Qh(int i) {
        if (this.pOg != i) {
            this.pOg = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        p.o(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.pOf && canvas != null) {
            this.pOh.a(canvas, this.pOg, this.scaleType);
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
