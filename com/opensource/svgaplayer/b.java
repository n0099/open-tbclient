package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes18.dex */
public final class b extends Drawable {
    private boolean pyp;
    private int pyq;
    private final com.opensource.svgaplayer.a.b pyr;
    private final f pys;
    private final c pyt;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pys = fVar;
        this.pyt = cVar;
        this.pyp = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.pyr = new com.opensource.svgaplayer.a.b(this.pys, this.pyt);
    }

    public final f ezA() {
        return this.pys;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        p.o(fVar, "videoItem");
    }

    public final void Bh(boolean z) {
        if (this.pyp != z) {
            this.pyp = z;
            invalidateSelf();
        }
    }

    public final int ezz() {
        return this.pyq;
    }

    public final void RB(int i) {
        if (this.pyq != i) {
            this.pyq = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        p.o(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.pyp && canvas != null) {
            this.pyr.a(canvas, this.pyq, this.scaleType);
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
