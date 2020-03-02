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
    private int nkA;
    private final com.opensource.svgaplayer.a.b nkB;
    private final f nkC;
    private final c nkD;
    private boolean nkz;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.nkC = fVar;
        this.nkD = cVar;
        this.nkz = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.nkB = new com.opensource.svgaplayer.a.b(this.nkC, this.nkD);
    }

    public final f dEG() {
        return this.nkC;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.j(fVar, "videoItem");
    }

    public final void wu(boolean z) {
        if (this.nkz != z) {
            this.nkz = z;
            invalidateSelf();
        }
    }

    public final int dEF() {
        return this.nkA;
    }

    public final void Nh(int i) {
        if (this.nkA != i) {
            this.nkA = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.j(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.nkz && canvas != null) {
            this.nkB.a(canvas, this.nkA, this.scaleType);
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
