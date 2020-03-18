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
    private final f nmA;
    private final c nmB;
    private boolean nmx;
    private int nmy;
    private final com.opensource.svgaplayer.a.b nmz;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.nmA = fVar;
        this.nmB = cVar;
        this.nmx = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.nmz = new com.opensource.svgaplayer.a.b(this.nmA, this.nmB);
    }

    public final f dFh() {
        return this.nmA;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.j(fVar, "videoItem");
    }

    public final void wC(boolean z) {
        if (this.nmx != z) {
            this.nmx = z;
            invalidateSelf();
        }
    }

    public final int dFg() {
        return this.nmy;
    }

    public final void Nn(int i) {
        if (this.nmy != i) {
            this.nmy = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.j(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.nmx && canvas != null) {
            this.nmz.a(canvas, this.nmy, this.scaleType);
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
