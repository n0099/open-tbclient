package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes17.dex */
public final class b extends Drawable {
    private boolean pEJ;
    private int pEK;
    private final com.opensource.svgaplayer.a.b pEL;
    private final f pEM;
    private final c pEN;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.n(fVar, "videoItem");
        q.n(cVar, "dynamicItem");
        this.pEM = fVar;
        this.pEN = cVar;
        this.pEJ = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.pEL = new com.opensource.svgaplayer.a.b(this.pEM, this.pEN);
    }

    public final f ewD() {
        return this.pEM;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.n(fVar, "videoItem");
    }

    public final void AT(boolean z) {
        if (this.pEJ != z) {
            this.pEJ = z;
            invalidateSelf();
        }
    }

    public final int ewC() {
        return this.pEK;
    }

    public final void Rz(int i) {
        if (this.pEK != i) {
            this.pEK = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.n(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.pEJ && canvas != null) {
            this.pEL.a(canvas, this.pEK, this.scaleType);
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
