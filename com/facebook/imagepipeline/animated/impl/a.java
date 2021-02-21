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
    private Bitmap nOk;
    private final com.facebook.imagepipeline.animated.b.a pFV;
    private final d pGT;
    private final com.facebook.imagepipeline.animated.base.b pGU;
    private final Rect pGV;
    private final int[] pGW;
    private final int[] pGX;
    private final AnimatedDrawableFrameInfo[] pGY;
    private final Rect pGZ = new Rect();
    private final Rect pHa = new Rect();

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.pFV = aVar;
        this.pGT = dVar;
        this.pGU = dVar.evF();
        this.pGW = this.pGU.getFrameDurations();
        this.pFV.fixFrameDurations(this.pGW);
        this.mDurationMs = this.pFV.t(this.pGW);
        this.pGX = this.pFV.u(this.pGW);
        this.pGV = a(this.pGU, rect);
        this.pGY = new AnimatedDrawableFrameInfo[this.pGU.getFrameCount()];
        for (int i = 0; i < this.pGU.getFrameCount(); i++) {
            this.pGY[i] = this.pGU.OP(i);
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
        return this.pGU.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.pGU.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.pGU.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.pGU.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int evD() {
        return this.pGV.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int evE() {
        return this.pGV.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo OP(int i) {
        return this.pGY[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int Pz(int i) {
        return this.pGW[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a m(Rect rect) {
        return a(this.pGU, rect).equals(this.pGV) ? this : new a(this.pFV, this.pGT, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void d(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c OR = this.pGU.OR(i);
        try {
            if (this.pGU.erS()) {
                a(canvas, OR);
            } else {
                b(canvas, OR);
            }
        } finally {
            OR.dispose();
        }
    }

    private synchronized void dZ(int i, int i2) {
        if (this.nOk != null && (this.nOk.getWidth() < i || this.nOk.getHeight() < i2)) {
            dTf();
        }
        if (this.nOk == null) {
            this.nOk = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.nOk.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.pGV.width() / this.pGU.getWidth();
        double height = this.pGV.height() / this.pGU.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.pGV.width();
            int height2 = this.pGV.height();
            dZ(width2, height2);
            cVar.renderFrame(round, round2, this.nOk);
            this.pGZ.set(0, 0, width2, height2);
            this.pHa.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.nOk, this.pGZ, this.pHa, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dZ(width, height);
            cVar.renderFrame(width, height, this.nOk);
            this.pGZ.set(0, 0, width, height);
            this.pHa.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.nOk, this.pGZ, this.pHa, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dTf() {
        if (this.nOk != null) {
            this.nOk.recycle();
            this.nOk = null;
        }
    }
}
