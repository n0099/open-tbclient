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
    private Bitmap lXW;
    private final int mMs;
    private final com.facebook.imagepipeline.animated.b.a mPB;
    private final com.facebook.imagepipeline.animated.base.b mQA;
    private final Rect mQB;
    private final int[] mQC;
    private final int[] mQD;
    private final AnimatedDrawableFrameInfo[] mQE;
    private final Rect mQF = new Rect();
    private final Rect mQG = new Rect();
    private final d mQz;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.mPB = aVar;
        this.mQz = dVar;
        this.mQA = dVar.dCi();
        this.mQC = this.mQA.dyn();
        this.mPB.n(this.mQC);
        this.mMs = this.mPB.o(this.mQC);
        this.mQD = this.mPB.p(this.mQC);
        this.mQB = a(this.mQA, rect);
        this.mQE = new AnimatedDrawableFrameInfo[this.mQA.getFrameCount()];
        for (int i = 0; i < this.mQA.getFrameCount(); i++) {
            this.mQE[i] = this.mQA.HP(i);
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
        return this.mQA.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.mQA.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.mQA.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.mQA.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dCg() {
        return this.mQB.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dCh() {
        return this.mQB.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo HP(int i) {
        return this.mQE[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int IB(int i) {
        return this.mQC[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.mQA, rect).equals(this.mQB) ? this : new a(this.mPB, this.mQz, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c HR = this.mQA.HR(i);
        try {
            if (this.mQA.dyo()) {
                a(canvas, HR);
            } else {
                b(canvas, HR);
            }
        } finally {
            HR.dispose();
        }
    }

    private synchronized void dv(int i, int i2) {
        if (this.lXW != null && (this.lXW.getWidth() < i || this.lXW.getHeight() < i2)) {
            dnl();
        }
        if (this.lXW == null) {
            this.lXW = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.lXW.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.mQB.width() / this.mQA.getWidth();
        double height = this.mQB.height() / this.mQA.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.mQB.width();
            int height2 = this.mQB.height();
            dv(width2, height2);
            cVar.b(round, round2, this.lXW);
            this.mQF.set(0, 0, width2, height2);
            this.mQG.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.lXW, this.mQF, this.mQG, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dv(width, height);
            cVar.b(width, height, this.lXW);
            this.mQF.set(0, 0, width, height);
            this.mQG.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.lXW, this.mQF, this.mQG, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dnl() {
        if (this.lXW != null) {
            this.lXW.recycle();
            this.lXW = null;
        }
    }
}
