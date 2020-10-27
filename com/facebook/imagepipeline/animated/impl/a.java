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
    private Bitmap njt;
    private final int oFy;
    private final com.facebook.imagepipeline.animated.b.a oIE;
    private final d oJC;
    private final com.facebook.imagepipeline.animated.base.b oJD;
    private final Rect oJE;
    private final int[] oJF;
    private final int[] oJG;
    private final AnimatedDrawableFrameInfo[] oJH;
    private final Rect oJI = new Rect();
    private final Rect oJJ = new Rect();

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.oIE = aVar;
        this.oJC = dVar;
        this.oJD = dVar.ejo();
        this.oJF = this.oJD.efu();
        this.oIE.n(this.oJF);
        this.oFy = this.oIE.o(this.oJF);
        this.oJG = this.oIE.p(this.oJF);
        this.oJE = a(this.oJD, rect);
        this.oJH = new AnimatedDrawableFrameInfo[this.oJD.getFrameCount()];
        for (int i = 0; i < this.oJD.getFrameCount(); i++) {
            this.oJH[i] = this.oJD.NQ(i);
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
        return this.oJD.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.oJD.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.oJD.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.oJD.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int ejm() {
        return this.oJE.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int ejn() {
        return this.oJE.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo NQ(int i) {
        return this.oJH[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int OC(int i) {
        return this.oJF[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a l(Rect rect) {
        return a(this.oJD, rect).equals(this.oJE) ? this : new a(this.oIE, this.oJC, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c NS = this.oJD.NS(i);
        try {
            if (this.oJD.efv()) {
                a(canvas, NS);
            } else {
                b(canvas, NS);
            }
        } finally {
            NS.dispose();
        }
    }

    private synchronized void dS(int i, int i2) {
        if (this.njt != null && (this.njt.getWidth() < i || this.njt.getHeight() < i2)) {
            dMS();
        }
        if (this.njt == null) {
            this.njt = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.njt.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.oJE.width() / this.oJD.getWidth();
        double height = this.oJE.height() / this.oJD.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.oJE.width();
            int height2 = this.oJE.height();
            dS(width2, height2);
            cVar.b(round, round2, this.njt);
            this.oJI.set(0, 0, width2, height2);
            this.oJJ.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.njt, this.oJI, this.oJJ, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dS(width, height);
            cVar.b(width, height, this.njt);
            this.oJI.set(0, 0, width, height);
            this.oJJ.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.njt, this.oJI, this.oJJ, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dMS() {
        if (this.njt != null) {
            this.njt.recycle();
            this.njt = null;
        }
    }
}
