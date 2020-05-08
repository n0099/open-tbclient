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
    private final int lVq;
    private final com.facebook.imagepipeline.animated.b.a lYx;
    private final AnimatedDrawableFrameInfo[] lZA;
    private final Rect lZB = new Rect();
    private final Rect lZC = new Rect();
    private final d lZv;
    private final com.facebook.imagepipeline.animated.base.b lZw;
    private final Rect lZx;
    private final int[] lZy;
    private final int[] lZz;
    @GuardedBy("this")
    @Nullable
    private Bitmap lkt;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.lYx = aVar;
        this.lZv = dVar;
        this.lZw = dVar.dpZ();
        this.lZy = this.lZw.dmc();
        this.lYx.n(this.lZy);
        this.lVq = this.lYx.o(this.lZy);
        this.lZz = this.lYx.p(this.lZy);
        this.lZx = a(this.lZw, rect);
        this.lZA = new AnimatedDrawableFrameInfo[this.lZw.getFrameCount()];
        for (int i = 0; i < this.lZw.getFrameCount(); i++) {
            this.lZA[i] = this.lZw.FU(i);
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
        return this.lZw.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.lZw.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.lZw.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.lZw.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dpX() {
        return this.lZx.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dpY() {
        return this.lZx.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo FU(int i) {
        return this.lZA[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int GG(int i) {
        return this.lZy[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.lZw, rect).equals(this.lZx) ? this : new a(this.lYx, this.lZv, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c FW = this.lZw.FW(i);
        try {
            if (this.lZw.dmd()) {
                a(canvas, FW);
            } else {
                b(canvas, FW);
            }
        } finally {
            FW.dispose();
        }
    }

    private synchronized void dh(int i, int i2) {
        if (this.lkt != null && (this.lkt.getWidth() < i || this.lkt.getHeight() < i2)) {
            dby();
        }
        if (this.lkt == null) {
            this.lkt = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.lkt.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.lZx.width() / this.lZw.getWidth();
        double height = this.lZx.height() / this.lZw.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.lZx.width();
            int height2 = this.lZx.height();
            dh(width2, height2);
            cVar.b(round, round2, this.lkt);
            this.lZB.set(0, 0, width2, height2);
            this.lZC.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.lkt, this.lZB, this.lZC, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dh(width, height);
            cVar.b(width, height, this.lkt);
            this.lZB.set(0, 0, width, height);
            this.lZC.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.lkt, this.lZB, this.lZC, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dby() {
        if (this.lkt != null) {
            this.lkt.recycle();
            this.lkt = null;
        }
    }
}
