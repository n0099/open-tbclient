package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes11.dex */
public class a implements com.facebook.imagepipeline.animated.base.a {
    @GuardedBy("this")
    @Nullable
    private Bitmap ktC;
    private final com.facebook.imagepipeline.animated.b.a lKy;
    private final Rect lLA = new Rect();
    private final Rect lLB = new Rect();
    private final d lLu;
    private final com.facebook.imagepipeline.animated.base.b lLv;
    private final Rect lLw;
    private final int[] lLx;
    private final int[] lLy;
    private final AnimatedDrawableFrameInfo[] lLz;
    private final int mDurationMs;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.lKy = aVar;
        this.lLu = dVar;
        this.lLv = dVar.dll();
        this.lLx = this.lLv.getFrameDurations();
        this.lKy.fixFrameDurations(this.lLx);
        this.mDurationMs = this.lKy.m(this.lLx);
        this.lLy = this.lKy.n(this.lLx);
        this.lLw = a(this.lLv, rect);
        this.lLz = new AnimatedDrawableFrameInfo[this.lLv.getFrameCount()];
        for (int i = 0; i < this.lLv.getFrameCount(); i++) {
            this.lLz[i] = this.lLv.Hd(i);
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
        return this.lLv.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.lLv.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.lLv.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.lLv.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dlj() {
        return this.lLw.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dlk() {
        return this.lLw.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Hd(int i) {
        return this.lLz[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int HL(int i) {
        return this.lLx[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.lLv, rect).equals(this.lLw) ? this : new a(this.lKy, this.lLu, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void renderFrame(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Hf = this.lLv.Hf(i);
        try {
            if (this.lLv.dhA()) {
                a(canvas, Hf);
            } else {
                b(canvas, Hf);
            }
        } finally {
            Hf.dispose();
        }
    }

    private synchronized void dv(int i, int i2) {
        if (this.ktC != null && (this.ktC.getWidth() < i || this.ktC.getHeight() < i2)) {
            cNH();
        }
        if (this.ktC == null) {
            this.ktC = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.ktC.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.lLw.width() / this.lLv.getWidth();
        double height = this.lLw.height() / this.lLv.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.lLw.width();
            int height2 = this.lLw.height();
            dv(width2, height2);
            cVar.renderFrame(round, round2, this.ktC);
            this.lLA.set(0, 0, width2, height2);
            this.lLB.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.ktC, this.lLA, this.lLB, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dv(width, height);
            cVar.renderFrame(width, height, this.ktC);
            this.lLA.set(0, 0, width, height);
            this.lLB.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.ktC, this.lLA, this.lLB, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void cNH() {
        if (this.ktC != null) {
            this.ktC.recycle();
            this.ktC = null;
        }
    }
}
