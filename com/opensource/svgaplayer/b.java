package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.q;
/* loaded from: classes.dex */
public final class b extends Drawable {
    private boolean njQ;
    private int njR;
    private ImageView.ScaleType njS;
    private final com.opensource.svgaplayer.a.b njT;
    private final f njU;
    private final c njV;

    public b(f fVar, c cVar) {
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.njU = fVar;
        this.njV = cVar;
        this.njQ = true;
        this.njS = ImageView.ScaleType.MATRIX;
        this.njT = new com.opensource.svgaplayer.a.b(this.njU, this.njV);
    }

    public final f dDv() {
        return this.njU;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.j(fVar, "videoItem");
    }

    public final void wq(boolean z) {
        if (this.njQ != z) {
            this.njQ = z;
            invalidateSelf();
        }
    }

    public final int dDu() {
        return this.njR;
    }

    public final void Ne(int i) {
        if (this.njR != i) {
            this.njR = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.j(scaleType, "<set-?>");
        this.njS = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.njQ && canvas != null) {
            this.njT.a(canvas, this.njR, this.njS);
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
