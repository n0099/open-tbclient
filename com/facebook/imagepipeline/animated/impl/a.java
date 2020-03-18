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
    private Bitmap kzY;
    private final com.facebook.imagepipeline.animated.b.a lQO;
    private final d lRK;
    private final com.facebook.imagepipeline.animated.base.b lRL;
    private final Rect lRM;
    private final int[] lRN;
    private final int[] lRO;
    private final AnimatedDrawableFrameInfo[] lRP;
    private final Rect lRQ = new Rect();
    private final Rect lRR = new Rect();
    private final int mDurationMs;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.lQO = aVar;
        this.lRK = dVar;
        this.lRL = dVar.dof();
        this.lRN = this.lRL.getFrameDurations();
        this.lQO.fixFrameDurations(this.lRN);
        this.mDurationMs = this.lQO.l(this.lRN);
        this.lRO = this.lQO.m(this.lRN);
        this.lRM = a(this.lRL, rect);
        this.lRP = new AnimatedDrawableFrameInfo[this.lRL.getFrameCount()];
        for (int i = 0; i < this.lRL.getFrameCount(); i++) {
            this.lRP[i] = this.lRL.Ht(i);
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
        return this.lRL.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.lRL.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.lRL.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.lRL.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dod() {
        return this.lRM.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int doe() {
        return this.lRM.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Ht(int i) {
        return this.lRP[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int If(int i) {
        return this.lRN[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.lRL, rect).equals(this.lRM) ? this : new a(this.lQO, this.lRK, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void renderFrame(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Hv = this.lRL.Hv(i);
        try {
            if (this.lRL.dkq()) {
                a(canvas, Hv);
            } else {
                b(canvas, Hv);
            }
        } finally {
            Hv.dispose();
        }
    }

    private synchronized void dx(int i, int i2) {
        if (this.kzY != null && (this.kzY.getWidth() < i || this.kzY.getHeight() < i2)) {
            cQE();
        }
        if (this.kzY == null) {
            this.kzY = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.kzY.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.lRM.width() / this.lRL.getWidth();
        double height = this.lRM.height() / this.lRL.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.lRM.width();
            int height2 = this.lRM.height();
            dx(width2, height2);
            cVar.renderFrame(round, round2, this.kzY);
            this.lRQ.set(0, 0, width2, height2);
            this.lRR.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.kzY, this.lRQ, this.lRR, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dx(width, height);
            cVar.renderFrame(width, height, this.kzY);
            this.lRQ.set(0, 0, width, height);
            this.lRR.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.kzY, this.lRQ, this.lRR, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void cQE() {
        if (this.kzY != null) {
            this.kzY.recycle();
            this.kzY = null;
        }
    }
}
