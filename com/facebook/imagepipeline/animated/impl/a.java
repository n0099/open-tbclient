package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class a implements com.facebook.imagepipeline.animated.base.a {
    private final int mDurationMs;
    @GuardedBy("this")
    @Nullable
    private Bitmap nIE;
    private final d pAL;
    private final com.facebook.imagepipeline.animated.base.b pAM;
    private final Rect pAN;
    private final int[] pAO;
    private final int[] pAP;
    private final AnimatedDrawableFrameInfo[] pAQ;
    private final Rect pAR = new Rect();
    private final Rect pAS = new Rect();
    private final com.facebook.imagepipeline.animated.b.a pzN;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.pzN = aVar;
        this.pAL = dVar;
        this.pAM = dVar.ewX();
        this.pAO = this.pAM.getFrameDurations();
        this.pzN.fixFrameDurations(this.pAO);
        this.mDurationMs = this.pzN.t(this.pAO);
        this.pAP = this.pzN.u(this.pAO);
        this.pAN = a(this.pAM, rect);
        this.pAQ = new AnimatedDrawableFrameInfo[this.pAM.getFrameCount()];
        for (int i = 0; i < this.pAM.getFrameCount(); i++) {
            this.pAQ[i] = this.pAM.Qa(i);
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
        return this.pAM.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.pAM.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.pAM.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.pAM.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int ewV() {
        return this.pAN.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int ewW() {
        return this.pAN.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Qa(int i) {
        return this.pAQ[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int QK(int i) {
        return this.pAO[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a m(Rect rect) {
        return a(this.pAM, rect).equals(this.pAN) ? this : new a(this.pzN, this.pAL, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void d(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Qc = this.pAM.Qc(i);
        try {
            if (this.pAM.etl()) {
                a(canvas, Qc);
            } else {
                b(canvas, Qc);
            }
        } finally {
            Qc.dispose();
        }
    }

    private synchronized void eb(int i, int i2) {
        if (this.nIE != null && (this.nIE.getWidth() < i || this.nIE.getHeight() < i2)) {
            dUE();
        }
        if (this.nIE == null) {
            this.nIE = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.nIE.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.pAN.width() / this.pAM.getWidth();
        double height = this.pAN.height() / this.pAM.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.pAN.width();
            int height2 = this.pAN.height();
            eb(width2, height2);
            cVar.renderFrame(round, round2, this.nIE);
            this.pAR.set(0, 0, width2, height2);
            this.pAS.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.nIE, this.pAR, this.pAS, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            eb(width, height);
            cVar.renderFrame(width, height, this.nIE);
            this.pAR.set(0, 0, width, height);
            this.pAS.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.nIE, this.pAR, this.pAS, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dUE() {
        if (this.nIE != null) {
            this.nIE.recycle();
            this.nIE = null;
        }
    }
}
