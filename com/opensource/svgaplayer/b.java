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
    private boolean mJk;
    private int mJl;
    private final com.opensource.svgaplayer.a.b mJm;
    private final f mJn;
    private final c mJo;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.mJn = fVar;
        this.mJo = cVar;
        this.mJk = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.mJm = new com.opensource.svgaplayer.a.b(this.mJn, this.mJo);
    }

    public final f dzf() {
        return this.mJn;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.j(fVar, "videoItem");
    }

    public final void wk(boolean z) {
        if (this.mJk != z) {
            this.mJk = z;
            invalidateSelf();
        }
    }

    public final int dze() {
        return this.mJl;
    }

    public final void IH(int i) {
        if (this.mJl != i) {
            this.mJl = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.j(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.mJk && canvas != null) {
            this.mJm.a(canvas, this.mJl, this.scaleType);
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
