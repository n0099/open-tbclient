package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes8.dex */
public final class b extends Drawable {
    private boolean nJb;
    private int nJc;
    private final com.opensource.svgaplayer.a.b nJd;
    private final f nJe;
    private final c nJf;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.nJe = fVar;
        this.nJf = cVar;
        this.nJb = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.nJd = new com.opensource.svgaplayer.a.b(this.nJe, this.nJf);
    }

    public final f dOT() {
        return this.nJe;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.m(fVar, "videoItem");
    }

    public final void xK(boolean z) {
        if (this.nJb != z) {
            this.nJb = z;
            invalidateSelf();
        }
    }

    public final int dOS() {
        return this.nJc;
    }

    public final void KV(int i) {
        if (this.nJc != i) {
            this.nJc = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.m(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.nJb && canvas != null) {
            this.nJd.a(canvas, this.nJc, this.scaleType);
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
