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
    private boolean ptM;
    private int ptN;
    private final com.opensource.svgaplayer.a.b ptO;
    private final f ptP;
    private final c ptQ;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.n(fVar, "videoItem");
        q.n(cVar, "dynamicItem");
        this.ptP = fVar;
        this.ptQ = cVar;
        this.ptM = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.ptO = new com.opensource.svgaplayer.a.b(this.ptP, this.ptQ);
    }

    public final f esN() {
        return this.ptP;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.n(fVar, "videoItem");
    }

    public final void AB(boolean z) {
        if (this.ptM != z) {
            this.ptM = z;
            invalidateSelf();
        }
    }

    public final int esM() {
        return this.ptN;
    }

    public final void QB(int i) {
        if (this.ptN != i) {
            this.ptN = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.n(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.ptM && canvas != null) {
            this.ptO.a(canvas, this.ptN, this.scaleType);
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
