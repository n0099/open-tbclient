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
    private boolean nAo;
    private int nAp;
    private final com.opensource.svgaplayer.a.b nAq;
    private final f nAr;
    private final c nAs;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.nAr = fVar;
        this.nAs = cVar;
        this.nAo = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.nAq = new com.opensource.svgaplayer.a.b(this.nAr, this.nAs);
    }

    public final f dLt() {
        return this.nAr;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.m(fVar, "videoItem");
    }

    public final void xf(boolean z) {
        if (this.nAo != z) {
            this.nAo = z;
            invalidateSelf();
        }
    }

    public final int dLs() {
        return this.nAp;
    }

    public final void KB(int i) {
        if (this.nAp != i) {
            this.nAp = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.m(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.nAo && canvas != null) {
            this.nAq.a(canvas, this.nAp, this.scaleType);
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
