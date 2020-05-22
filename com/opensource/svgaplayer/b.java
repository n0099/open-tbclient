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
    private boolean ndn;
    private int ndo;
    private final com.opensource.svgaplayer.a.b ndp;
    private final f ndq;
    private final c ndr;
    private ImageView.ScaleType scaleType;

    public b(f fVar, c cVar) {
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.ndq = fVar;
        this.ndr = cVar;
        this.ndn = true;
        this.scaleType = ImageView.ScaleType.MATRIX;
        this.ndp = new com.opensource.svgaplayer.a.b(this.ndq, this.ndr);
    }

    public final f dGz() {
        return this.ndq;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        this(fVar, new c());
        q.m(fVar, "videoItem");
    }

    public final void wI(boolean z) {
        if (this.ndn != z) {
            this.ndn = z;
            invalidateSelf();
        }
    }

    public final int dGy() {
        return this.ndo;
    }

    public final void Js(int i) {
        if (this.ndo != i) {
            this.ndo = i;
            invalidateSelf();
        }
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        q.m(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.ndn && canvas != null) {
            this.ndp.a(canvas, this.ndo, this.scaleType);
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
