package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class a implements com.facebook.imagepipeline.animated.base.a {
    @GuardedBy("this")
    @Nullable
    private Bitmap mHg;
    private final com.facebook.imagepipeline.animated.b.a nBT;
    private final d nCR;
    private final com.facebook.imagepipeline.animated.base.b nCS;
    private final Rect nCT;
    private final int[] nCU;
    private final int[] nCV;
    private final AnimatedDrawableFrameInfo[] nCW;
    private final Rect nCX = new Rect();
    private final Rect nCY = new Rect();
    private final int nyM;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.nBT = aVar;
        this.nCR = dVar;
        this.nCS = dVar.dVF();
        this.nCU = this.nCS.dRL();
        this.nBT.o(this.nCU);
        this.nyM = this.nBT.p(this.nCU);
        this.nCV = this.nBT.q(this.nCU);
        this.nCT = a(this.nCS, rect);
        this.nCW = new AnimatedDrawableFrameInfo[this.nCS.getFrameCount()];
        for (int i = 0; i < this.nCS.getFrameCount(); i++) {
            this.nCW[i] = this.nCS.Lt(i);
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
        return this.nCS.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.nCS.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.nCS.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.nCS.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dVD() {
        return this.nCT.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dVE() {
        return this.nCT.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Lt(int i) {
        return this.nCW[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int Mf(int i) {
        return this.nCU[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.nCS, rect).equals(this.nCT) ? this : new a(this.nBT, this.nCR, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Lv = this.nCS.Lv(i);
        try {
            if (this.nCS.dRM()) {
                a(canvas, Lv);
            } else {
                b(canvas, Lv);
            }
        } finally {
            Lv.dispose();
        }
    }

    private synchronized void dJ(int i, int i2) {
        if (this.mHg != null && (this.mHg.getWidth() < i || this.mHg.getHeight() < i2)) {
            dFY();
        }
        if (this.mHg == null) {
            this.mHg = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.mHg.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.nCT.width() / this.nCS.getWidth();
        double height = this.nCT.height() / this.nCS.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.nCT.width();
            int height2 = this.nCT.height();
            dJ(width2, height2);
            cVar.b(round, round2, this.mHg);
            this.nCX.set(0, 0, width2, height2);
            this.nCY.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.mHg, this.nCX, this.nCY, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dJ(width, height);
            cVar.b(width, height, this.mHg);
            this.nCX.set(0, 0, width, height);
            this.nCY.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.mHg, this.nCX, this.nCY, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dFY() {
        if (this.mHg != null) {
            this.mHg.recycle();
            this.mHg = null;
        }
    }
}
