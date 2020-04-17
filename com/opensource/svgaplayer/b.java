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
    private boolean mJh;
    private int mJi;
    private final com.opensource.svgaplayer.a.b mJj;
    private final f mJk;
    private final c mJl;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.mJk = fVar;
        this.mJl = cVar;
        this.mJh = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.mJj = new com.opensource.svgaplayer.a.b(this.mJk, this.mJl);
    }

    public final f dzj() {
        return this.mJk;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.j(fVar, "videoItem");
    }

    public final void wk(boolean z) {
        if (this.mJh != z) {
            this.mJh = z;
            invalidateSelf();
        }
    }

    public final int dzi() {
        return this.mJi;
    }

    public final void IH(int i) {
        if (this.mJi != i) {
            this.mJi = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.j(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.mJh && canvas != null) {
            this.mJj.a(canvas, this.mJi, this.scaleType);
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
