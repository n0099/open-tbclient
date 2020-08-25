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
    private Bitmap mxc;
    private final int nov;
    private final com.facebook.imagepipeline.animated.b.a nrD;
    private final d nsB;
    private final com.facebook.imagepipeline.animated.base.b nsC;
    private final Rect nsD;
    private final int[] nsE;
    private final int[] nsF;
    private final AnimatedDrawableFrameInfo[] nsG;
    private final Rect nsH = new Rect();
    private final Rect nsI = new Rect();

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.nrD = aVar;
        this.nsB = dVar;
        this.nsC = dVar.dRy();
        this.nsE = this.nsC.dNE();
        this.nrD.o(this.nsE);
        this.nov = this.nrD.p(this.nsE);
        this.nsF = this.nrD.q(this.nsE);
        this.nsD = a(this.nsC, rect);
        this.nsG = new AnimatedDrawableFrameInfo[this.nsC.getFrameCount()];
        for (int i = 0; i < this.nsC.getFrameCount(); i++) {
            this.nsG[i] = this.nsC.KO(i);
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
        return this.nsC.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.nsC.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.nsC.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.nsC.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dRw() {
        return this.nsD.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dRx() {
        return this.nsD.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo KO(int i) {
        return this.nsG[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int LA(int i) {
        return this.nsE[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.nsC, rect).equals(this.nsD) ? this : new a(this.nrD, this.nsB, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c KQ = this.nsC.KQ(i);
        try {
            if (this.nsC.dNF()) {
                a(canvas, KQ);
            } else {
                b(canvas, KQ);
            }
        } finally {
            KQ.dispose();
        }
    }

    private synchronized void dF(int i, int i2) {
        if (this.mxc != null && (this.mxc.getWidth() < i || this.mxc.getHeight() < i2)) {
            dBV();
        }
        if (this.mxc == null) {
            this.mxc = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.mxc.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.nsD.width() / this.nsC.getWidth();
        double height = this.nsD.height() / this.nsC.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.nsD.width();
            int height2 = this.nsD.height();
            dF(width2, height2);
            cVar.b(round, round2, this.mxc);
            this.nsH.set(0, 0, width2, height2);
            this.nsI.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.mxc, this.nsH, this.nsI, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dF(width, height);
            cVar.b(width, height, this.mxc);
            this.nsH.set(0, 0, width, height);
            this.nsI.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.mxc, this.nsH, this.nsI, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dBV() {
        if (this.mxc != null) {
            this.mxc.recycle();
            this.mxc = null;
        }
    }
}
