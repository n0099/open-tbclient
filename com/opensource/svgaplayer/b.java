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
    private boolean nkK;
    private int nkL;
    private final com.opensource.svgaplayer.a.b nkM;
    private final f nkN;
    private final c nkO;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.nkN = fVar;
        this.nkO = cVar;
        this.nkK = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.nkM = new com.opensource.svgaplayer.a.b(this.nkN, this.nkO);
    }

    public final f dEH() {
        return this.nkN;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.j(fVar, "videoItem");
    }

    public final void wu(boolean z) {
        if (this.nkK != z) {
            this.nkK = z;
            invalidateSelf();
        }
    }

    public final int dEG() {
        return this.nkL;
    }

    public final void Nh(int i) {
        if (this.nkL != i) {
            this.nkL = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.j(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.nkK && canvas != null) {
            this.nkM.a(canvas, this.nkL, this.scaleType);
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
