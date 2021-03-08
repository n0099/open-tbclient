package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes14.dex */
public class a implements com.facebook.imagepipeline.animated.base.a {
    private final int mDurationMs;
    @GuardedBy("this")
    @Nullable
    private Bitmap nQp;
    private final d pIY;
    private final com.facebook.imagepipeline.animated.base.b pIZ;
    private final com.facebook.imagepipeline.animated.b.a pIa;
    private final Rect pJa;
    private final int[] pJb;
    private final int[] pJc;
    private final AnimatedDrawableFrameInfo[] pJd;
    private final Rect pJe = new Rect();
    private final Rect pJf = new Rect();

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.pIa = aVar;
        this.pIY = dVar;
        this.pIZ = dVar.evO();
        this.pJb = this.pIZ.getFrameDurations();
        this.pIa.fixFrameDurations(this.pJb);
        this.mDurationMs = this.pIa.t(this.pJb);
        this.pJc = this.pIa.u(this.pJb);
        this.pJa = a(this.pIZ, rect);
        this.pJd = new AnimatedDrawableFrameInfo[this.pIZ.getFrameCount()];
        for (int i = 0; i < this.pIZ.getFrameCount(); i++) {
            this.pJd[i] = this.pIZ.OT(i);
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
        return this.pIZ.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.pIZ.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.pIZ.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.pIZ.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int evM() {
        return this.pJa.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int evN() {
        return this.pJa.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo OT(int i) {
        return this.pJd[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int PD(int i) {
        return this.pJb[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a m(Rect rect) {
        return a(this.pIZ, rect).equals(this.pJa) ? this : new a(this.pIa, this.pIY, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void d(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c OV = this.pIZ.OV(i);
        try {
            if (this.pIZ.esb()) {
                a(canvas, OV);
            } else {
                b(canvas, OV);
            }
        } finally {
            OV.dispose();
        }
    }

    private synchronized void dZ(int i, int i2) {
        if (this.nQp != null && (this.nQp.getWidth() < i || this.nQp.getHeight() < i2)) {
            dTn();
        }
        if (this.nQp == null) {
            this.nQp = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.nQp.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.pJa.width() / this.pIZ.getWidth();
        double height = this.pJa.height() / this.pIZ.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.pJa.width();
            int height2 = this.pJa.height();
            dZ(width2, height2);
            cVar.renderFrame(round, round2, this.nQp);
            this.pJe.set(0, 0, width2, height2);
            this.pJf.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.nQp, this.pJe, this.pJf, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dZ(width, height);
            cVar.renderFrame(width, height, this.nQp);
            this.pJe.set(0, 0, width, height);
            this.pJf.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.nQp, this.pJe, this.pJf, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dTn() {
        if (this.nQp != null) {
            this.nQp.recycle();
            this.nQp = null;
        }
    }
}
