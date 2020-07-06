package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class b extends Drawable {
    private boolean nAr;
    private int nAs;
    private final com.opensource.svgaplayer.a.b nAt;
    private final f nAu;
    private final c nAv;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.nAu = fVar;
        this.nAv = cVar;
        this.nAr = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.nAt = new com.opensource.svgaplayer.a.b(this.nAu, this.nAv);
    }

    public final f dLx() {
        return this.nAu;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.m(fVar, "videoItem");
    }

    public final void xf(boolean z) {
        if (this.nAr != z) {
            this.nAr = z;
            invalidateSelf();
        }
    }

    public final int dLw() {
        return this.nAs;
    }

    public final void KB(int i) {
        if (this.nAs != i) {
            this.nAs = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.m(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.nAr && canvas != null) {
            this.nAt.a(canvas, this.nAs, this.scaleType);
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
