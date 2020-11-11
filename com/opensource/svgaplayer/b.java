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
    private boolean pDg;
    private int pDh;
    private final com.opensource.svgaplayer.a.b pDi;
    private final f pDj;
    private final c pDk;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.n(fVar, "videoItem");
        q.n(cVar, "dynamicItem");
        this.pDj = fVar;
        this.pDk = cVar;
        this.pDg = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.pDi = new com.opensource.svgaplayer.a.b(this.pDj, this.pDk);
    }

    public final f ewC() {
        return this.pDj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.n(fVar, "videoItem");
    }

    public final void AM(boolean z) {
        if (this.pDg != z) {
            this.pDg = z;
            invalidateSelf();
        }
    }

    public final int ewB() {
        return this.pDh;
    }

    public final void QW(int i) {
        if (this.pDh != i) {
            this.pDh = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.n(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.pDg && canvas != null) {
            this.pDi.a(canvas, this.pDh, this.scaleType);
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
