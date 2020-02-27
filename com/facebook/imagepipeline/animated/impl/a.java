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
    private Bitmap kyf;
    private final com.facebook.imagepipeline.animated.b.a lOV;
    private final d lPR;
    private final com.facebook.imagepipeline.animated.base.b lPS;
    private final Rect lPT;
    private final int[] lPU;
    private final int[] lPV;
    private final AnimatedDrawableFrameInfo[] lPW;
    private final Rect lPX = new Rect();
    private final Rect lPY = new Rect();
    private final int mDurationMs;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.lOV = aVar;
        this.lPR = dVar;
        this.lPS = dVar.dnF();
        this.lPU = this.lPS.getFrameDurations();
        this.lOV.fixFrameDurations(this.lPU);
        this.mDurationMs = this.lOV.l(this.lPU);
        this.lPV = this.lOV.m(this.lPU);
        this.lPT = a(this.lPS, rect);
        this.lPW = new AnimatedDrawableFrameInfo[this.lPS.getFrameCount()];
        for (int i = 0; i < this.lPS.getFrameCount(); i++) {
            this.lPW[i] = this.lPS.Hn(i);
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
        return this.lPS.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.lPS.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.lPS.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.lPS.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dnD() {
        return this.lPT.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dnE() {
        return this.lPT.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Hn(int i) {
        return this.lPW[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int HZ(int i) {
        return this.lPU[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.lPS, rect).equals(this.lPT) ? this : new a(this.lOV, this.lPR, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void renderFrame(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Hp = this.lPS.Hp(i);
        try {
            if (this.lPS.djQ()) {
                a(canvas, Hp);
            } else {
                b(canvas, Hp);
            }
        } finally {
            Hp.dispose();
        }
    }

    private synchronized void dw(int i, int i2) {
        if (this.kyf != null && (this.kyf.getWidth() < i || this.kyf.getHeight() < i2)) {
            cQh();
        }
        if (this.kyf == null) {
            this.kyf = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.kyf.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.lPT.width() / this.lPS.getWidth();
        double height = this.lPT.height() / this.lPS.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.lPT.width();
            int height2 = this.lPT.height();
            dw(width2, height2);
            cVar.renderFrame(round, round2, this.kyf);
            this.lPX.set(0, 0, width2, height2);
            this.lPY.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.kyf, this.lPX, this.lPY, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dw(width, height);
            cVar.renderFrame(width, height, this.kyf);
            this.lPX.set(0, 0, width, height);
            this.lPY.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.kyf, this.lPX, this.lPY, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void cQh() {
        if (this.kyf != null) {
            this.kyf.recycle();
            this.kyf = null;
        }
    }
}
