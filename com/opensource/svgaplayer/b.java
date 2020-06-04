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
    private final com.opensource.svgaplayer.a.b neA;
    private final f neB;
    private final c neC;
    private boolean ney;
    private int nez;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.neB = fVar;
        this.neC = cVar;
        this.ney = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.neA = new com.opensource.svgaplayer.a.b(this.neB, this.neC);
    }

    public final f dGN() {
        return this.neB;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.m(fVar, "videoItem");
    }

    public final void wK(boolean z) {
        if (this.ney != z) {
            this.ney = z;
            invalidateSelf();
        }
    }

    public final int dGM() {
        return this.nez;
    }

    public final void Ju(int i) {
        if (this.nez != i) {
            this.nez = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.m(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.ney && canvas != null) {
            this.neA.a(canvas, this.nez, this.scaleType);
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
