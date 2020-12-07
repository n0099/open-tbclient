package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class a implements com.facebook.imagepipeline.animated.base.a {
    @GuardedBy("this")
    @Nullable
    private Bitmap nEy;
    private final int pfD;
    private final com.facebook.imagepipeline.animated.b.a piz;
    private final int[] pjA;
    private final int[] pjB;
    private final AnimatedDrawableFrameInfo[] pjC;
    private final Rect pjD = new Rect();
    private final Rect pjE = new Rect();
    private final d pjx;
    private final com.facebook.imagepipeline.animated.base.b pjy;
    private final Rect pjz;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.piz = aVar;
        this.pjx = dVar;
        this.pjy = dVar.esM();
        this.pjA = this.pjy.eoX();
        this.piz.s(this.pjA);
        this.pfD = this.piz.t(this.pjA);
        this.pjB = this.piz.u(this.pjA);
        this.pjz = a(this.pjy, rect);
        this.pjC = new AnimatedDrawableFrameInfo[this.pjy.getFrameCount()];
        for (int i = 0; i < this.pjy.getFrameCount(); i++) {
            this.pjC[i] = this.pjy.PM(i);
        }
    }

    private static Rect a(com.facebook.imagepipeline.animated.base.b bVar, Rect rect) {
        if (rect == null) {
            return new Rect(0, 0, bVar.getWidth(), bVar.getHeight());
        }
        return new Rect(0, 0, Math.min(rect.width(), bVar.getWidth()), Math.min(rect.height(), bVar.getHeight()));
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getFrameCount() {
        return this.pjy.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.pjy.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.pjy.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.pjy.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int esK() {
        return this.pjz.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int esL() {
        return this.pjz.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo PM(int i) {
        return this.pjC[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int Qw(int i) {
        return this.pjA[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a m(Rect rect) {
        return a(this.pjy, rect).equals(this.pjz) ? this : new a(this.piz, this.pjx, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c PO = this.pjy.PO(i);
        try {
            if (this.pjy.eoY()) {
                a(canvas, PO);
            } else {
                b(canvas, PO);
            }
        } finally {
            PO.dispose();
        }
    }

    private synchronized void eb(int i, int i2) {
        if (this.nEy != null && (this.nEy.getWidth() < i || this.nEy.getHeight() < i2)) {
            dUL();
        }
        if (this.nEy == null) {
            this.nEy = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.nEy.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.pjz.width() / this.pjy.getWidth();
        double height = this.pjz.height() / this.pjy.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.pjz.width();
            int height2 = this.pjz.height();
            eb(width2, height2);
            cVar.b(round, round2, this.nEy);
            this.pjD.set(0, 0, width2, height2);
            this.pjE.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.nEy, this.pjD, this.pjE, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            eb(width, height);
            cVar.b(width, height, this.nEy);
            this.pjD.set(0, 0, width, height);
            this.pjE.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.nEy, this.pjD, this.pjE, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dUL() {
        if (this.nEy != null) {
            this.nEy.recycle();
            this.nEy = null;
        }
    }
}
