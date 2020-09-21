package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes16.dex */
public final class b extends Drawable {
    private boolean omX;
    private int omY;
    private final com.opensource.svgaplayer.a.b omZ;
    private final f ona;
    private final c onb;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.ona = fVar;
        this.onb = cVar;
        this.omX = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.omZ = new com.opensource.svgaplayer.a.b(this.ona, this.onb);
    }

    public final f efc() {
        return this.ona;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.m(fVar, "videoItem");
    }

    public final void yM(boolean z) {
        if (this.omX != z) {
            this.omX = z;
            invalidateSelf();
        }
    }

    public final int efb() {
        return this.omY;
    }

    public final void Oe(int i) {
        if (this.omY != i) {
            this.omY = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.m(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.omX && canvas != null) {
            this.omZ.a(canvas, this.omY, this.scaleType);
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
