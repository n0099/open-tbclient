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
    private boolean odm;
    private int odn;
    private final com.opensource.svgaplayer.a.b odo;
    private final f odp;
    private final c odq;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.odp = fVar;
        this.odq = cVar;
        this.odm = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.odo = new com.opensource.svgaplayer.a.b(this.odp, this.odq);
    }

    public final f ebe() {
        return this.odp;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.m(fVar, "videoItem");
    }

    public final void yE(boolean z) {
        if (this.odm != z) {
            this.odm = z;
            invalidateSelf();
        }
    }

    public final int ebd() {
        return this.odn;
    }

    public final void Nz(int i) {
        if (this.odn != i) {
            this.odn = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.m(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.odm && canvas != null) {
            this.odo.a(canvas, this.odn, this.scaleType);
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
