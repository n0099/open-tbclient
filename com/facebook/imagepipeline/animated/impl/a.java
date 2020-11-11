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
    @GuardedBy("this")
    @Nullable
    private Bitmap npq;
    private final int oOR;
    private final com.facebook.imagepipeline.animated.b.a oRX;
    private final d oSV;
    private final com.facebook.imagepipeline.animated.base.b oSW;
    private final Rect oSX;
    private final int[] oSY;
    private final int[] oSZ;
    private final AnimatedDrawableFrameInfo[] oTa;
    private final Rect oTb = new Rect();
    private final Rect oTc = new Rect();

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.oRX = aVar;
        this.oSV = dVar;
        this.oSW = dVar.ene();
        this.oSY = this.oSW.ejj();
        this.oRX.p(this.oSY);
        this.oOR = this.oRX.q(this.oSY);
        this.oSZ = this.oRX.r(this.oSY);
        this.oSX = a(this.oSW, rect);
        this.oTa = new AnimatedDrawableFrameInfo[this.oSW.getFrameCount()];
        for (int i = 0; i < this.oSW.getFrameCount(); i++) {
            this.oTa[i] = this.oSW.Ol(i);
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
        return this.oSW.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.oSW.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.oSW.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.oSW.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int enb() {
        return this.oSX.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int enc() {
        return this.oSX.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Ol(int i) {
        return this.oTa[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int OX(int i) {
        return this.oSY[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a m(Rect rect) {
        return a(this.oSW, rect).equals(this.oSX) ? this : new a(this.oRX, this.oSV, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c On = this.oSW.On(i);
        try {
            if (this.oSW.ejk()) {
                a(canvas, On);
            } else {
                b(canvas, On);
            }
        } finally {
            On.dispose();
        }
    }

    private synchronized void dV(int i, int i2) {
        if (this.npq != null && (this.npq.getWidth() < i || this.npq.getHeight() < i2)) {
            dPu();
        }
        if (this.npq == null) {
            this.npq = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.npq.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.oSX.width() / this.oSW.getWidth();
        double height = this.oSX.height() / this.oSW.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.oSX.width();
            int height2 = this.oSX.height();
            dV(width2, height2);
            cVar.b(round, round2, this.npq);
            this.oTb.set(0, 0, width2, height2);
            this.oTc.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.npq, this.oTb, this.oTc, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dV(width, height);
            cVar.b(width, height, this.npq);
            this.oTb.set(0, 0, width, height);
            this.oTc.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.npq, this.oTb, this.oTc, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dPu() {
        if (this.npq != null) {
            this.npq.recycle();
            this.npq = null;
        }
    }
}
