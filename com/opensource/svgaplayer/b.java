package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.q;
/* loaded from: classes.dex */
public final class b extends Drawable {
    private boolean njV;
    private int njW;
    private ImageView.ScaleType njX;
    private final com.opensource.svgaplayer.a.b njY;
    private final f njZ;
    private final c nka;

    public b(f fVar, c cVar) {
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.njZ = fVar;
        this.nka = cVar;
        this.njV = true;
        this.njX = ImageView.ScaleType.MATRIX;
        this.njY = new com.opensource.svgaplayer.a.b(this.njZ, this.nka);
    }

    public final f dDx() {
        return this.njZ;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.j(fVar, "videoItem");
    }

    public final void wq(boolean z) {
        if (this.njV != z) {
            this.njV = z;
            invalidateSelf();
        }
    }

    public final int dDw() {
        return this.njW;
    }

    public final void Ne(int i) {
        if (this.njW != i) {
            this.njW = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.j(scaleType, "<set-?>");
        this.njX = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.njV && canvas != null) {
            this.njY.a(canvas, this.njW, this.njX);
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
