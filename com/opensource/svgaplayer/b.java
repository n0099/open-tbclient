package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes11.dex */
public final class b extends Drawable {
    private boolean ocU;
    private int ocV;
    private final com.opensource.svgaplayer.a.b ocW;
    private final f ocX;
    private final c ocY;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.ocX = fVar;
        this.ocY = cVar;
        this.ocU = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.ocW = new com.opensource.svgaplayer.a.b(this.ocX, this.ocY);
    }

    public final f eaV() {
        return this.ocX;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.m(fVar, "videoItem");
    }

    public final void yC(boolean z) {
        if (this.ocU != z) {
            this.ocU = z;
            invalidateSelf();
        }
    }

    public final int eaU() {
        return this.ocV;
    }

    public final void Nz(int i) {
        if (this.ocV != i) {
            this.ocV = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.m(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.ocU && canvas != null) {
            this.ocW.a(canvas, this.ocV, this.scaleType);
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
