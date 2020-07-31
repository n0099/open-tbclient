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
    private final int mUE;
    private final com.facebook.imagepipeline.animated.b.a mXM;
    private final d mYK;
    private final com.facebook.imagepipeline.animated.base.b mYL;
    private final Rect mYM;
    private final int[] mYN;
    private final int[] mYO;
    private final AnimatedDrawableFrameInfo[] mYP;
    private final Rect mYQ = new Rect();
    private final Rect mYR = new Rect();
    @GuardedBy("this")
    @Nullable
    private Bitmap mfq;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.mXM = aVar;
        this.mYK = dVar;
        this.mYL = dVar.dFy();
        this.mYN = this.mYL.dBD();
        this.mXM.n(this.mYN);
        this.mUE = this.mXM.o(this.mYN);
        this.mYO = this.mXM.p(this.mYN);
        this.mYM = a(this.mYL, rect);
        this.mYP = new AnimatedDrawableFrameInfo[this.mYL.getFrameCount()];
        for (int i = 0; i < this.mYL.getFrameCount(); i++) {
            this.mYP[i] = this.mYL.Ik(i);
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
        return this.mYL.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.mYL.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.mYL.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.mYL.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dFw() {
        return this.mYM.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dFx() {
        return this.mYM.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Ik(int i) {
        return this.mYP[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int IW(int i) {
        return this.mYN[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.mYL, rect).equals(this.mYM) ? this : new a(this.mXM, this.mYK, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Im = this.mYL.Im(i);
        try {
            if (this.mYL.dBE()) {
                a(canvas, Im);
            } else {
                b(canvas, Im);
            }
        } finally {
            Im.dispose();
        }
    }

    private synchronized void dx(int i, int i2) {
        if (this.mfq != null && (this.mfq.getWidth() < i || this.mfq.getHeight() < i2)) {
            dqz();
        }
        if (this.mfq == null) {
            this.mfq = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.mfq.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.mYM.width() / this.mYL.getWidth();
        double height = this.mYM.height() / this.mYL.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.mYM.width();
            int height2 = this.mYM.height();
            dx(width2, height2);
            cVar.b(round, round2, this.mfq);
            this.mYQ.set(0, 0, width2, height2);
            this.mYR.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.mfq, this.mYQ, this.mYR, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dx(width, height);
            cVar.b(width, height, this.mfq);
            this.mYQ.set(0, 0, width, height);
            this.mYR.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.mfq, this.mYQ, this.mYR, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dqz() {
        if (this.mfq != null) {
            this.mfq.recycle();
            this.mfq = null;
        }
    }
}
