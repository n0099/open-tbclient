package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class a implements com.facebook.imagepipeline.animated.base.a {
    private final int mDurationMs;
    @GuardedBy("this")
    @Nullable
    private Bitmap nNK;
    private final com.facebook.imagepipeline.animated.b.a pFv;
    private final d pGt;
    private final com.facebook.imagepipeline.animated.base.b pGu;
    private final Rect pGv;
    private final int[] pGw;
    private final int[] pGx;
    private final AnimatedDrawableFrameInfo[] pGy;
    private final Rect pGz = new Rect();
    private final Rect pGA = new Rect();

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.pFv = aVar;
        this.pGt = dVar;
        this.pGu = dVar.evx();
        this.pGw = this.pGu.getFrameDurations();
        this.pFv.fixFrameDurations(this.pGw);
        this.mDurationMs = this.pFv.t(this.pGw);
        this.pGx = this.pFv.u(this.pGw);
        this.pGv = a(this.pGu, rect);
        this.pGy = new AnimatedDrawableFrameInfo[this.pGu.getFrameCount()];
        for (int i = 0; i < this.pGu.getFrameCount(); i++) {
            this.pGy[i] = this.pGu.OO(i);
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
        return this.pGu.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.pGu.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.pGu.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.pGu.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int evv() {
        return this.pGv.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int evw() {
        return this.pGv.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo OO(int i) {
        return this.pGy[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int Py(int i) {
        return this.pGw[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a m(Rect rect) {
        return a(this.pGu, rect).equals(this.pGv) ? this : new a(this.pFv, this.pGt, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void d(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c OQ = this.pGu.OQ(i);
        try {
            if (this.pGu.erK()) {
                a(canvas, OQ);
            } else {
                b(canvas, OQ);
            }
        } finally {
            OQ.dispose();
        }
    }

    private synchronized void dY(int i, int i2) {
        if (this.nNK != null && (this.nNK.getWidth() < i || this.nNK.getHeight() < i2)) {
            dSX();
        }
        if (this.nNK == null) {
            this.nNK = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.nNK.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.pGv.width() / this.pGu.getWidth();
        double height = this.pGv.height() / this.pGu.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.pGv.width();
            int height2 = this.pGv.height();
            dY(width2, height2);
            cVar.renderFrame(round, round2, this.nNK);
            this.pGz.set(0, 0, width2, height2);
            this.pGA.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.nNK, this.pGz, this.pGA, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dY(width, height);
            cVar.renderFrame(width, height, this.nNK);
            this.pGz.set(0, 0, width, height);
            this.pGA.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.nNK, this.pGz, this.pGA, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dSX() {
        if (this.nNK != null) {
            this.nNK.recycle();
            this.nNK = null;
        }
    }
}
