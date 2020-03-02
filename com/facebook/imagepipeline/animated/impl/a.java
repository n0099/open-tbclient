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
    private Bitmap kyh;
    private final com.facebook.imagepipeline.animated.b.a lOX;
    private final d lPT;
    private final com.facebook.imagepipeline.animated.base.b lPU;
    private final Rect lPV;
    private final int[] lPW;
    private final int[] lPX;
    private final AnimatedDrawableFrameInfo[] lPY;
    private final Rect lPZ = new Rect();
    private final Rect lQa = new Rect();
    private final int mDurationMs;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.lOX = aVar;
        this.lPT = dVar;
        this.lPU = dVar.dnH();
        this.lPW = this.lPU.getFrameDurations();
        this.lOX.fixFrameDurations(this.lPW);
        this.mDurationMs = this.lOX.l(this.lPW);
        this.lPX = this.lOX.m(this.lPW);
        this.lPV = a(this.lPU, rect);
        this.lPY = new AnimatedDrawableFrameInfo[this.lPU.getFrameCount()];
        for (int i = 0; i < this.lPU.getFrameCount(); i++) {
            this.lPY[i] = this.lPU.Hn(i);
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
        return this.lPU.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.lPU.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.lPU.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.lPU.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dnF() {
        return this.lPV.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dnG() {
        return this.lPV.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Hn(int i) {
        return this.lPY[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int HZ(int i) {
        return this.lPW[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.lPU, rect).equals(this.lPV) ? this : new a(this.lOX, this.lPT, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void renderFrame(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Hp = this.lPU.Hp(i);
        try {
            if (this.lPU.djS()) {
                a(canvas, Hp);
            } else {
                b(canvas, Hp);
            }
        } finally {
            Hp.dispose();
        }
    }

    private synchronized void dw(int i, int i2) {
        if (this.kyh != null && (this.kyh.getWidth() < i || this.kyh.getHeight() < i2)) {
            cQj();
        }
        if (this.kyh == null) {
            this.kyh = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.kyh.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.lPV.width() / this.lPU.getWidth();
        double height = this.lPV.height() / this.lPU.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.lPV.width();
            int height2 = this.lPV.height();
            dw(width2, height2);
            cVar.renderFrame(round, round2, this.kyh);
            this.lPZ.set(0, 0, width2, height2);
            this.lQa.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.kyh, this.lPZ, this.lQa, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dw(width, height);
            cVar.renderFrame(width, height, this.kyh);
            this.lPZ.set(0, 0, width, height);
            this.lQa.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.kyh, this.lPZ, this.lQa, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void cQj() {
        if (this.kyh != null) {
            this.kyh.recycle();
            this.kyh = null;
        }
    }
}
