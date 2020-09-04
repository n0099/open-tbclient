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
    @GuardedBy("this")
    @Nullable
    private Bitmap mxu;
    private final int noO;
    private final com.facebook.imagepipeline.animated.b.a nrV;
    private final d nsT;
    private final com.facebook.imagepipeline.animated.base.b nsU;
    private final Rect nsV;
    private final int[] nsW;
    private final int[] nsX;
    private final AnimatedDrawableFrameInfo[] nsY;
    private final Rect nsZ = new Rect();
    private final Rect nta = new Rect();

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.nrV = aVar;
        this.nsT = dVar;
        this.nsU = dVar.dRH();
        this.nsW = this.nsU.dNN();
        this.nrV.o(this.nsW);
        this.noO = this.nrV.p(this.nsW);
        this.nsX = this.nrV.q(this.nsW);
        this.nsV = a(this.nsU, rect);
        this.nsY = new AnimatedDrawableFrameInfo[this.nsU.getFrameCount()];
        for (int i = 0; i < this.nsU.getFrameCount(); i++) {
            this.nsY[i] = this.nsU.KO(i);
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
        return this.nsU.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.nsU.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.nsU.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.nsU.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dRF() {
        return this.nsV.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dRG() {
        return this.nsV.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo KO(int i) {
        return this.nsY[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int LA(int i) {
        return this.nsW[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.nsU, rect).equals(this.nsV) ? this : new a(this.nrV, this.nsT, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c KQ = this.nsU.KQ(i);
        try {
            if (this.nsU.dNO()) {
                a(canvas, KQ);
            } else {
                b(canvas, KQ);
            }
        } finally {
            KQ.dispose();
        }
    }

    private synchronized void dF(int i, int i2) {
        if (this.mxu != null && (this.mxu.getWidth() < i || this.mxu.getHeight() < i2)) {
            dCe();
        }
        if (this.mxu == null) {
            this.mxu = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.mxu.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.nsV.width() / this.nsU.getWidth();
        double height = this.nsV.height() / this.nsU.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.nsV.width();
            int height2 = this.nsV.height();
            dF(width2, height2);
            cVar.b(round, round2, this.mxu);
            this.nsZ.set(0, 0, width2, height2);
            this.nta.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.mxu, this.nsZ, this.nta, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dF(width, height);
            cVar.b(width, height, this.mxu);
            this.nsZ.set(0, 0, width, height);
            this.nta.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.mxu, this.nsZ, this.nta, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dCe() {
        if (this.mxu != null) {
            this.mxu.recycle();
            this.mxu = null;
        }
    }
}
