package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class a implements com.facebook.imagepipeline.animated.base.a {
    @GuardedBy("this")
    @Nullable
    private Bitmap lEn;
    private final int mqt;
    private final com.facebook.imagepipeline.animated.b.a mtC;
    private final d muA;
    private final com.facebook.imagepipeline.animated.base.b muB;
    private final Rect muC;
    private final int[] muD;
    private final int[] muE;
    private final AnimatedDrawableFrameInfo[] muF;
    private final Rect muG = new Rect();
    private final Rect muH = new Rect();

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.mtC = aVar;
        this.muA = dVar;
        this.muB = dVar.dxG();
        this.muD = this.muB.dtK();
        this.mtC.n(this.muD);
        this.mqt = this.mtC.o(this.muD);
        this.muE = this.mtC.p(this.muD);
        this.muC = a(this.muB, rect);
        this.muF = new AnimatedDrawableFrameInfo[this.muB.getFrameCount()];
        for (int i = 0; i < this.muB.getFrameCount(); i++) {
            this.muF[i] = this.muB.GI(i);
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
        return this.muB.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.muB.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.muB.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.muB.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dxE() {
        return this.muC.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dxF() {
        return this.muC.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo GI(int i) {
        return this.muF[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int Hu(int i) {
        return this.muD[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.muB, rect).equals(this.muC) ? this : new a(this.mtC, this.muA, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c GK = this.muB.GK(i);
        try {
            if (this.muB.dtL()) {
                a(canvas, GK);
            } else {
                b(canvas, GK);
            }
        } finally {
            GK.dispose();
        }
    }

    private synchronized void dm(int i, int i2) {
        if (this.lEn != null && (this.lEn.getWidth() < i || this.lEn.getHeight() < i2)) {
            djc();
        }
        if (this.lEn == null) {
            this.lEn = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.lEn.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.muC.width() / this.muB.getWidth();
        double height = this.muC.height() / this.muB.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.muC.width();
            int height2 = this.muC.height();
            dm(width2, height2);
            cVar.b(round, round2, this.lEn);
            this.muG.set(0, 0, width2, height2);
            this.muH.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.lEn, this.muG, this.muH, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dm(width, height);
            cVar.b(width, height, this.lEn);
            this.muG.set(0, 0, width, height);
            this.muH.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.lEn, this.muG, this.muH, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void djc() {
        if (this.lEn != null) {
            this.lEn.recycle();
            this.lEn = null;
        }
    }
}
