package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes18.dex */
public final class b extends Drawable {
    private boolean pyr;
    private int pys;
    private final com.opensource.svgaplayer.a.b pyt;
    private final f pyu;
    private final c pyv;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        p.o(fVar, "videoItem");
        p.o(cVar, "dynamicItem");
        this.pyu = fVar;
        this.pyv = cVar;
        this.pyr = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.pyt = new com.opensource.svgaplayer.a.b(this.pyu, this.pyv);
    }

    public final f ezB() {
        return this.pyu;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        p.o(fVar, "videoItem");
    }

    public final void Bh(boolean z) {
        if (this.pyr != z) {
            this.pyr = z;
            invalidateSelf();
        }
    }

    public final int ezA() {
        return this.pys;
    }

    public final void RB(int i) {
        if (this.pys != i) {
            this.pys = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        p.o(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.pyr && canvas != null) {
            this.pyt.a(canvas, this.pys, this.scaleType);
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
