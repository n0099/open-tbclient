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
    private final f nkA;
    private final c nkB;
    private boolean nkx;
    private int nky;
    private final com.opensource.svgaplayer.a.b nkz;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.j(fVar, "videoItem");
        q.j(cVar, "dynamicItem");
        this.nkA = fVar;
        this.nkB = cVar;
        this.nkx = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.nkz = new com.opensource.svgaplayer.a.b(this.nkA, this.nkB);
    }

    public final f dEE() {
        return this.nkA;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.j(fVar, "videoItem");
    }

    public final void wu(boolean z) {
        if (this.nkx != z) {
            this.nkx = z;
            invalidateSelf();
        }
    }

    public final int dED() {
        return this.nky;
    }

    public final void Nh(int i) {
        if (this.nky != i) {
            this.nky = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.j(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.nkx && canvas != null) {
            this.nkz.a(canvas, this.nky, this.scaleType);
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
