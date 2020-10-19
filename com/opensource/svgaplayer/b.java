package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes15.dex */
public final class b extends Drawable {
    private boolean oCq;
    private int oCr;
    private final com.opensource.svgaplayer.a.b oCs;
    private final f oCt;
    private final c oCu;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.n(fVar, "videoItem");
        q.n(cVar, "dynamicItem");
        this.oCt = fVar;
        this.oCu = cVar;
        this.oCq = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.oCs = new com.opensource.svgaplayer.a.b(this.oCt, this.oCu);
    }

    public final f eiN() {
        return this.oCt;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.n(fVar, "videoItem");
    }

    public final void zt(boolean z) {
        if (this.oCq != z) {
            this.oCq = z;
            invalidateSelf();
        }
    }

    public final int eiM() {
        return this.oCr;
    }

    public final void OK(int i) {
        if (this.oCr != i) {
            this.oCr = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.n(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.oCq && canvas != null) {
            this.oCs.a(canvas, this.oCr, this.scaleType);
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
