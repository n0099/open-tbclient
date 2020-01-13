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
    private Bitmap kxf;
    private final com.facebook.imagepipeline.animated.b.a lOj;
    private final d lPf;
    private final com.facebook.imagepipeline.animated.base.b lPg;
    private final Rect lPh;
    private final int[] lPi;
    private final int[] lPj;
    private final AnimatedDrawableFrameInfo[] lPk;
    private final Rect lPl = new Rect();
    private final Rect lPm = new Rect();
    private final int mDurationMs;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.lOj = aVar;
        this.lPf = dVar;
        this.lPg = dVar.dmq();
        this.lPi = this.lPg.getFrameDurations();
        this.lOj.fixFrameDurations(this.lPi);
        this.mDurationMs = this.lOj.m(this.lPi);
        this.lPj = this.lOj.n(this.lPi);
        this.lPh = a(this.lPg, rect);
        this.lPk = new AnimatedDrawableFrameInfo[this.lPg.getFrameCount()];
        for (int i = 0; i < this.lPg.getFrameCount(); i++) {
            this.lPk[i] = this.lPg.Hi(i);
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
        return this.lPg.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.lPg.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.lPg.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.lPg.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dmo() {
        return this.lPh.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dmp() {
        return this.lPh.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Hi(int i) {
        return this.lPk[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int HU(int i) {
        return this.lPi[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.lPg, rect).equals(this.lPh) ? this : new a(this.lOj, this.lPf, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void renderFrame(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Hk = this.lPg.Hk(i);
        try {
            if (this.lPg.diB()) {
                a(canvas, Hk);
            } else {
                b(canvas, Hk);
            }
        } finally {
            Hk.dispose();
        }
    }

    private synchronized void dt(int i, int i2) {
        if (this.kxf != null && (this.kxf.getWidth() < i || this.kxf.getHeight() < i2)) {
            cOM();
        }
        if (this.kxf == null) {
            this.kxf = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.kxf.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.lPh.width() / this.lPg.getWidth();
        double height = this.lPh.height() / this.lPg.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.lPh.width();
            int height2 = this.lPh.height();
            dt(width2, height2);
            cVar.renderFrame(round, round2, this.kxf);
            this.lPl.set(0, 0, width2, height2);
            this.lPm.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.kxf, this.lPl, this.lPm, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dt(width, height);
            cVar.renderFrame(width, height, this.kxf);
            this.lPl.set(0, 0, width, height);
            this.lPm.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.kxf, this.lPl, this.lPm, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void cOM() {
        if (this.kxf != null) {
            this.kxf.recycle();
            this.kxf = null;
        }
    }
}
