package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.p;
/* loaded from: classes4.dex */
public final class b extends Drawable {
    private boolean mKo;
    private int mKp;
    private ImageView.ScaleType mKq;
    private final com.opensource.svgaplayer.a.b mKr;
    private final f mKs;
    private final c mKt;

    public b(f fVar, c cVar) {
        p.j(fVar, "videoItem");
        p.j(cVar, "dynamicItem");
        this.mKs = fVar;
        this.mKt = cVar;
        this.mKo = true;
        this.mKq = ImageView.ScaleType.MATRIX;
        this.mKr = new com.opensource.svgaplayer.a.b(this.mKs, this.mKt);
    }

    public final f dzC() {
        return this.mKs;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        p.j(fVar, "videoItem");
    }

    public final void vR(boolean z) {
        if (this.mKo != z) {
            this.mKo = z;
            invalidateSelf();
        }
    }

    public final int dzB() {
        return this.mKp;
    }

    public final void Mu(int i) {
        if (this.mKp != i) {
            this.mKp = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        p.j(scaleType, "<set-?>");
        this.mKq = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.mKo && canvas != null) {
            this.mKr.a(canvas, this.mKp, this.mKq);
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
